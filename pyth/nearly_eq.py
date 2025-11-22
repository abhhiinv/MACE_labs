def near_eq(s1,s2):
    a = 0
    if len(s1) != len(s2):
        print('Not nearly equal')
        return False
    
    for i in range(len(s1)):
        if(s1[i]!=s2[i]):
            a+=1
    if a>1:
        print('Not nearly equal ')
        return False
    else:
        print('Nearly equal')
        return True
s1 = input('Enter string 1 : ').lower()
s2 = input('Enter string 2 : ').lower()
print(near_eq(s1,s2))