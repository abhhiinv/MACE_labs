def prime(n):
    size = int(0.5*(n-3))+1
    primes = [2]
    isPrime = [True]*size
    for i in range(0,size):
        if(isPrime[i]):
            p = (i*2)+3
            primes.append(p)
            for k in range((2*i*i + 6*i +3),size,p):
                isPrime[k]=False
    return primes
print(len(prime(1000000000)))   