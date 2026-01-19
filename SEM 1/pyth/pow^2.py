# Check whether a given positive integer is power of 2. Raise exception for negative input.

def ispower(n):
    if n < 0:
        raise ValueError("Negative number not allowed")

    return (n != 0) and (n & (n - 1) == 0)


try:
    num = int(input("Enter number: "))
    if ispower(num):
        print(num, "is a power of 2")
    else:
        print(num, "is NOT a power of 2")
except ValueError as e:
    print(e)
