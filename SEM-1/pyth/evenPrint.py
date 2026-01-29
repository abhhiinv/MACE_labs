#Write a program to print all even numbers from a given list in the given order until you reach number 237 or end of the list. 
def even_f(numl):
    for i in range(len(numl)):
        if numl[i]==237:
            break
        if not (numl[i]%2):
            numl[numl[i]]

lis1=int(list(input("Enter list of numbers: ").split()))

print(result=even_f(lis1))