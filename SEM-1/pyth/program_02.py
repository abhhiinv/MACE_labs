s = input("Enter a string: ")

# If string length is more than 1, swap first and last
if len(s) > 1:
    result_b = s[-1] + s[1:-1] + s[0]
else:
    result_b = s  # if only 1 character, no change

print("Modified string (b):", result_b)
