def print_E(size=9):
    for i in range(size):
        for j in range(size):
            if j==0 or\
                i==0 or\
                (i==size//2 and j<(size//2)+2) or\
                i==size-1:
                print('*',end='')
            else:
                print(' ',end='')
        print()
print_E()