x,y = 0,1   
num=int(input("\nEnter the number to find Fibonacci :"))
if(num<0):
    print("Enter a postive number!!")
else:
    print(x,end=" ")
    print(y,end=" ")
    for i in range (1,num):
        x,y=y,x+y
        print(y,end=" ")
