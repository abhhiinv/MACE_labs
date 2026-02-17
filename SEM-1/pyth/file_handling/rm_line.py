# Remove a line from a file
ip = False
try:
    n = int(input('Enter line no. : '))
    with open('abc.txt', 'r+', encoding='utf-8') as ip:
        lines = ip.readlines()
        lines.pop(n-1)
        ip.truncate(0)
        ip.seek(0,0)
        ip.writelines(lines)
except IOError as ie:
    print(ie)
finally:
    if ip: ip.close()