def print_J(size=16):
    for i in range(size):
        for j in range(size):
            if i==size-1 or\
                j==size-1 or\
                (i==0 and j>=size//2) or\
                (j==0 and i>=size//2):
                print('*',end='')
            else:
                print(' ',end='')
        print()
print_J()