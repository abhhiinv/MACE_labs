def print_N(size=14):
    for i in range(size):
        for j in range(size):
            if j==0 or j==size-1 or\
                (i<size and j==i)or\
                (i<size//2 and j==size-1):
                print('*',end='')
            else:
                print(' ',end='')
        print()
print_N()
