import fitz  # PyMuPDF
from transformers import pipeline

# Step 1: Load the summarization model
print("Loading AI model (first time may take a minute)...")
summarizer = pipeline("summarization", model="facebook/bart-large-cnn")

# Step 2: Ask for PDF file path
pdf_path = input("Enter the path to your PDF file: ")

# Step 3: Extract text from the PDF
print("Extracting text from PDF...")
pdf_text = ""
with fitz.open(pdf_path) as doc:
    for page in doc:
        pdf_text += page.get_text()

# Step 4: Split text into manageable chunks
max_chunk_size = 1000
chunks = [pdf_text[i:i + max_chunk_size] for i in range(0, len(pdf_text), max_chunk_size)]

# Step 5: Summarize each chunk
print("Summarizing content...")
summary = ""
for i, chunk in enumerate(chunks, 1):
    print(f"Summarizing chunk {i}/{len(chunks)}...")
    result = summarizer(chunk, max_length=150, min_length=40, do_sample=False)
    summary += result[0]['summary_text'] + "\n\n"

# Step 6: Save summarized text
output_file = "pdf_summary.txt"
with open(output_file, "w", encoding="utf-8") as f:
    f.write(summary)

print(f"\n Summary saved as {output_file}")

