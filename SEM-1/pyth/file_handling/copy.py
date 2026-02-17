ip=op=False
try:    
    ip=open('infile.txt')
    op=open('outfile.txt','w')
    line=ip.readline()
    while line:
        op.write(line)
        line=ip.readline()
except IOError as IO:
    print(IO)
finally:
    if ip:ip.close()
    if op:op.close()