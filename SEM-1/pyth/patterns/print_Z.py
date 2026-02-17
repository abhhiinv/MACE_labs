def print_Z(size=19):
    for row in range(size):
        for col in range (size):
            if row==0 or\
                row==size-1 or\
                row>=0 and col==size-1-row:
                print('*',end="")
            else:
                print(' ',end="")
        print()
print_Z()