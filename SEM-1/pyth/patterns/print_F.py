def print_F(size=10):
    for row in range(size):
        for col in range(size):
            if col==0 or\
                (row==0 or row==size//2)and col<size:
                print("*",end="")
            else: 
                print(" ",end="")
        print()
print_F()