def print_R(size=10):
    for i in range(size):
        for j in range (size):
            if j==0 or\
            (j==size-1 and i<=size//2) or\
            i==0 or i==size//2 or\
            (j==i and i>=size//2):
                print('*',end='')
            else:
                print(' ',end='')
        print()
print_R()