import sys
sys.setrecursionlimit(1000000)
arr={0:0,1:1}
def fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        if n in arr:
            return arr[n]
        else:
            arr[n] = fibo(n-1) + fibo(n-2)
            return arr[n]
print(fibo(10))