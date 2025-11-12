a=['ca t','car','fea r','cente r']
result=[]

for b in a:
    if ' ' in b:
        result.append('True')
    else:
        result.append('False')
print(result)