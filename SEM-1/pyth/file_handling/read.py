inf = False
try:
    inf = open ('infile.txt')
    # inf = open ('infile.txt','r')
    line = inf.read() # Reads entire file
    print(line)
except IOError as io:
    print(io)
finally:
    if inf: inf.close()