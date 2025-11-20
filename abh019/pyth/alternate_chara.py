def altdisp(text,ind=0):
    if ind >= len(text):
        return ""
    else:
        return text[ind] + altdisp(text,ind+2)
t = input('Enter a text or string : ')
print(altdisp(t))