#Count number of lines in a file
ip = False
try:
    ip = open('infile.txt', encoding='utf-8')
    lines = ip.readlines()
    print(lines)
    print('No. of lines :',len(lines))
except IOError as ie:
    print(ie)
finally:
    if ip: ip.close()