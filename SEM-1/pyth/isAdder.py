def add_is(s):
    return s if s.startswith("Is") else "Is" + s

s = input("Enter a string: ")
print("Result:", add_is(s))
