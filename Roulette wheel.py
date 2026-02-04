import random

pocket = random.randint (0, 36)

if pocket == 0:
 pocket_color = "Green"

elif (1 <= pocket <= 10) or (19 <= pocket <= 28):
 pocket_color = "Black" if pocket % 2 == 0 else "Red"

else:
 pocket_color = "Red" if pocket % 2 == 0 else "Black"

print(f"The pocket number is: {pocket}")
print(f"The pocket color is: {pocket_color}")