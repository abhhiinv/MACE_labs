def joiner(li,ind = 0):
    if ind >= len(li):
        return ""
    else:
        if ind == (len(li)-1):
            return str(li[ind])
        return str(li[ind])+'-'+joiner(li,ind+1)
li1 = ['a','b','c']
print(joiner(li1))