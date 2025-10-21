#Accept full name and display in reverse order with space between the words.
def rev_name(s):
    if not s: return ""
    if len(s)==1: return s
    else:
        name=s[::-1]
        return name
string=input("Enter full name: ")
print(rev_name(string))