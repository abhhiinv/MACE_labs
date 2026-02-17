li=[89,72,10,99]
for i in range(len(li)):
    for j in range(i+1,len(li)):
        if li[i]>li[j]:
            t=li[i]
            li[i]=li[j]
            li[j]=t
print(li)