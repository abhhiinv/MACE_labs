string = input('Enter a string : ')
if len(string)<7 and len(string)%2 == 0: print(string)
else:
    a = len(string)//2
    print(string[a-1:a+2])