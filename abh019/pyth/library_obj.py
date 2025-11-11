class Publisher:
    def __init__(self,name = "D C Books"):
        self.name = name
    def getPub(self,name):
        self.name = name
    def disp(self):
        print("Name of publisher :",self.name)

class Book(Publisher):
    def __init__(self,title = "Changapuzha's Fundamentals of Python",author = "Changampuzha"):
        super().__init__()
        self.title = title
        self.author = author
    '''def getBook(self,title,author):
        self.title = title
        self.author = author'''
    def disp(self):
        super().disp()
        print("Title :",self.title)
        print("Author :",self.author)

class Python(Book):
    def __init__(self,price = 2000,pages = 2575):
        super().__init__()
        self.price = price
        self.pages = pages
    '''def getPyth(self,price,pages):
        self.price = price
        self.pages = pages'''
    def disp(self):
        super().disp()
        print("Price :",self.price)
        print("Number of pages :",self.pages)

book1 = Python()
book1.disp()