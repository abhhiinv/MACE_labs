def fibo_sum(n):
    a,b = 0,1
    sum = 0
    print(a,b,end=' ')
    for i in range(2,n):
        c = a+b
        print(c,end=' ')
        if (c%2 == 0):
            sum += c
        a = b
        b = c
    return sum

n = int(input('Enter the number of terms of Fibonacci :'))
print('The sum of even elements of',n,'terms is',fibo_sum(n))