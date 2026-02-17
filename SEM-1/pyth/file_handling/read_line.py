# Reading a text file
inf = False
try:
    inf = open ('infile.txt')
    # inf = open ('infile.txt','r')
    line = inf.readline() # Reads line by line
    while line:
        print(line.strip())
        line = inf.readline()
except IOError as io:
    print(io)
finally:
    if inf: inf.close()