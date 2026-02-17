s = input("Enter a string: ")
if s.endswith("ing"):
    s += "ly"
else:
    s += "ing"
print(s)