def print_C(size=5):
    for row in range(size):
        for col in range(size):
            if col==0 or\
                (row==0 or row==size-1) and col<size:
                print("*",end="")
            else:
                print(" ",end="") 
        print()
print_C()
                
                