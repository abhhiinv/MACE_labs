import math

def pow_2(num):
    loga = math.log(num,2)
    return loga

try:
    num = int(input('Enter a number to check if it is a power of 2 : '))
    print(pow_2(num),'True')

except ValueError as ve:
    if num < 0:
        print(ve,'\nEnter a positive number !!!')