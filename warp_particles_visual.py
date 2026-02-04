import warp as wp
import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D  # needed for 3D projection
import time

# Initialize Warp
wp.init()

# Warp kernel for particle integration
@wp.kernel
def integrate(x: wp.array(dtype=wp.vec3),
              v: wp.array(dtype=wp.vec3),
              gravity: wp.vec3,
              dt: float):
    tid = wp.tid()
    v0 = v[tid]
    x0 = x[tid]
    v1 = v0 + gravity * dt
    x1 = x0 + v1 * dt
    v[tid] = v1
    x[tid] = x1

# Simulation parameters
n = 1000          # number of particles (keep smaller for plotting)
dt = 1.0 / 30.0   # time step
steps = 200       # number of frames
gravity = wp.spatial.vectorf(0.0, -9.81, 0.0)

state_in.body_q = wp.array(
    [wp.transform(wp.vec3(0.0, 3.0, 0.0), wp.quat_identity())],
    dtype=wp.transform
)
state_in.body_qd = wp.array(
    [wp.spatial_vectorf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)],
    dtype=wp.spatial_vectorf
)


# Initial particle positions and velocities
np.random.seed(0)
x = np.random.uniform(-5.0, 5.0, (n, 3)).astype(np.float32)
v = np.random.uniform(-2.0, 2.0, (n, 3)).astype(np.float32)

# Send data to GPU
x_gpu = wp.array(x, dtype=wp.vec3, device="cuda:0")
v_gpu = wp.array(v, dtype=wp.vec3, device="cuda:0")

# Set up matplotlib 3D plot
fig = plt.figure(figsize=(8, 6))
ax = fig.add_subplot(111, projection='3d')
sc = ax.scatter([], [], [], s=4, color='cyan')

ax.set_xlim([-10, 10])
ax.set_ylim([-10, 10])
ax.set_zlim([-10, 10])
ax.set_xlabel('X')
ax.set_ylabel('Y')
ax.set_zlabel('Z')
ax.set_title('Warp GPU Particle Simulation')

# Update function for animation
def update(frame):
    # Run one integration step on GPU
    wp.launch(kernel=integrate, dim=n, inputs=[x_gpu, v_gpu, gravity, dt], device="cuda:0")
    wp.synchronize()

    # Get positions from GPU (sampled)
    pos = x_gpu.numpy()

    sc._offsets3d = (pos[:, 0], pos[:, 1], pos[:, 2])
    ax.set_title(f"Warp GPU Particle Simulation (frame {frame})")
    return sc,

# Animate using matplotlib
for frame in range(steps):
    update(frame)
    plt.pause(0.01)

plt.show()
