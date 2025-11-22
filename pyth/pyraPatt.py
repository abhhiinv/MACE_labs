num=int(input("enter the number of rows :"))
for i in range(1,num+1):
    print("",end=" "*(num-i))
    for j in range (1,i+1):
        print("*",end=" ")
    print("\n")