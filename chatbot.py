import os
os.environ["CUDA_VISIBLE_DEVICES"] = ""  # disable GPU

import torch
from llama_index.core import SimpleDirectoryReader, VectorStoreIndex, Settings
from llama_index.embeddings.huggingface import HuggingFaceEmbedding
import gradio as gr

# Disable OpenAI LLM
Settings.llm = None

# Force CPU embeddings
Settings.embed_model = HuggingFaceEmbedding(
    model_name="sentence-transformers/all-MiniLM-L6-v2",
    device="cpu"
)

# Load documents
documents = SimpleDirectoryReader("data").load_data()

# Create index
index = VectorStoreIndex.from_documents(documents)
chat_engine = index.as_chat_engine()

# Chatbot response
def chatbot_response(message, history):
    response = chat_engine.chat(message)
    return str(response)

# Web UI
demo = gr.ChatInterface(fn=chatbot_response, title="Law Firm AI Assistant")
demo.launch()

