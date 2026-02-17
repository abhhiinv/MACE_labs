nums = [int(x) for x in input("Enter numbers: ").split()]
odd = [n for n in nums if n % 2 != 0]
print(odd)