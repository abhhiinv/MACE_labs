f = False
res = []
try:
    with open('abc.txt','w+') as f:
        n = input('Enter text: ')
        while n:
            f.write(n+'\n')
            n = input('Enter text: ')
        f.seek(0)
        p = f.readlines()
        for i in p:
            if not i.strip().startswith('#') :
                res.append(i)
        f.truncate(0)
        f.seek(0)
        f.writelines(res)
        f.seek(0)
        print(f.read())
except Exception as fe:
    print(fe)
finally:
    if f: f.close()