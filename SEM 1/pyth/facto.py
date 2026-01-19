num=int(input("Enter the number to find the factorial:"))
fact=1
if(num==0):
    print("0! is 1")
elif(num<0):
    print("No negative factorial")
else:
    for i in range (1,num+1):
        fact*=i
    print( "%d! is"%(num),fact)