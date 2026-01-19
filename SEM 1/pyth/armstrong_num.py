# Armstrong numbers between 100 and 500

for num in range(100, 501):
    sum = 0
    temp = num

    while temp > 0:
        digit = temp % 10
        sum += digit ** 3
        temp = temp // 10

    if num == sum:
        print(num)
