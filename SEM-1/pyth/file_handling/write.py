# Writing a text file
outf = False
try:
    outf = open('infile.txt','w')
    line = input('Enter Text : ')
    while line:
        outf.write(line) # NO newline added
        #outf.write(line+'\n') # newline added
        line = input('Enter Text :')
    outf.close()
    inf = False
    inf = open ('infile.txt')
    line = inf.read() # Reads entire fileprint(line)
except IOError as io:
    print(io)
finally:
    if inf: inf.close()