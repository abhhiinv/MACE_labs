def print_P(size=10):
    print("--- Letter P ---")
    for ro in range(size):
        for col in range(size):
            # Column on the left (0) OR
            # Top and middle horizontal lines (0 and size//2) OR
            # Right vertical line, only on the top half (j == size-1 AND i < size//2)
            if col == 0 or \
               (ro == 0 or ro == size // 2) and col < size or \
               col == size - 1 and ro > 0 and ro < size // 2:
                print("*", end="")
            else:
                print(" ", end="")
        print()

print_P()