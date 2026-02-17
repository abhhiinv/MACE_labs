def print_K(size=10):
    for i in range(size):
        for j in range(size):
            if (j==(size//2)-1) or\
            (i<size//2 and j==size-1-i) or\
            (i>size//2 and j==i):
                print('*',end='')
            else:
                print(' ',end='')
        print()
print_K()