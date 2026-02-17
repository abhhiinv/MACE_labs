def print_V(size=17):
    for i in range (size):
        for j in range (size):
            if (i<size//2 and j==i) or\
                  (i<size//2 and j==size-1-i):
                print('*',end='')
            else:
                print(' ',end='')
        print()
print_V()