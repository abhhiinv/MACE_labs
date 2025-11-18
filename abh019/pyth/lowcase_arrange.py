import re
s = input('Enter a string : ')
lowercase ="".join(re.findall(r"[a-z]",s))
others ="".join(re.findall(r"[^a-z]",s))
result = lowercase + others
print(result)