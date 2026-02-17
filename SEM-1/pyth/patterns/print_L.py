def print_L(size=7):
    for row in range(size):
        for col in range(size):
            if col==0 or\
                row==size-1 and col<size:
                print("*",end="")
            else :
                print(" ",end="")
        print()
print_L()