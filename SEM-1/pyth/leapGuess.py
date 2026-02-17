import datetime
current = datetime.date.today().year
future = int(input("Enter future year: "))
leaps = [y for y in range(current, future+1) if (y%4==0 and (y%100!=0 or y%400==0))]
print(leaps)