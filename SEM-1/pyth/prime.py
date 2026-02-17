def primes(n):
    if n < 2:
        return []
    isPrime = [True] * (n + 1)
    isPrime[0] = isPrime[1] = False
    for i in range(2, int(n**0.5) + 1):
        if isPrime[i]:
            for j in range(i*i, n + 1, i):
                isPrime[j] = False
    return [i for i, is_prime in enumerate(isPrime) if is_prime]
# print(*primes(1000000))
print(len(primes(1000000000)))