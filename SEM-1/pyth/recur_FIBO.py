def fibo(n):
    if n==0:
        return 0
    if n==1:
        return 1
    return fibo(n-1)+fibo(n-2)
num=int(input('Enter nth fibo: '))
print('Fibonacci of %d is %d'%(num,fibo(num)))