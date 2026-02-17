s1 = input("Enter first string: ")
s2 = input("Enter second string: ")

# Swap the first characters
new_s1 = s2[0] + s1[1:]
new_s2 = s1[0] + s2[1:]

# Combine them with a space
result_a = new_s1 + " " + new_s2

print("Result (a):", result_a)
