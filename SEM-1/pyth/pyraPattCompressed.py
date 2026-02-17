n=int(input('Enter the limit: '))
for i in range(1,n+1):
    spaces=n-i-1
    stars=2*i+1
    print(' '*spaces + '*'*stars )