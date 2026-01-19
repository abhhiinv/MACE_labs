def revList(l):
    newList = l[::-1]
    return newList

li = input('Enter the list with commas : ').split(',')
print(revList(li))