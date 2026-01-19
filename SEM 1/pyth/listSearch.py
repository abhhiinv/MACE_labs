#Write a program to search an item in a given list and display the number of occurrences of the given item.
def search_list(str,item):
    count=0
    for i in range(len(str)):
        if str[i]==item:
            count+=1
    return count
s=list(input("Enter the items: ").split())
item=input("Enter item to search: ")
result=search_list(s,item)
print('Item found',result,'times')
