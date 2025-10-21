num=int(input("Enter a number to find factors :"))
for i in range (1,num+1):
    if(num%i==0):
        print(i,end=",")
print()
