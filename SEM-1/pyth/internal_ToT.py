words= input('Enter comma separated words: ').split(',')
result=[]
for w in words:
    if  w[-2]==' ':
        result.append('True')
    else:
        result.append('false')
print(result)