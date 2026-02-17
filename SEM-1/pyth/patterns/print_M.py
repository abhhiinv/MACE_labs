def print_M(size=14):
    for i in range(size):
        for j in range(size):
            if j==0 or j==size-1 or\
                (j<size//2 and i==j) or\
                (j>size//2 and i==size-1-j):
                print('*',end='')
            else:
                print(' ',end='')
        print()
print_M()
