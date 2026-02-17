s = input("Enter a string: ")

# Take the first character
first_char = s[0]

# Replace all occurrences of first_char in the rest of the string
result_a = first_char + s[1:].replace(first_char, "$")

print("Modified string (a):", result_a)
