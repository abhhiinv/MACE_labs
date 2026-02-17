def print_O(size=8):
    for row in range (size):
        for col in range (size):
            if (col==0 or col==size-1)or\
                (row==0 or row==size-1):
                print("*",end="")
            else:
                print(" ",end="")
        print()
print_O()