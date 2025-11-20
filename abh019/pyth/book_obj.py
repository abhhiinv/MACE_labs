class Book:
    def __init__(self,title,author):
        self.title = title
        self.author = author

b1 = Book("Harry Potter","J K Rowling")
b2 = Book("Orikkal","N Mohanan")
b2.publisher = "DC Books"

if hasattr(b2,"publisher"):
    print(f"{b2.title} written by {b2.author} published by {b2.publisher}")
else:
    print("Unknown publisher")