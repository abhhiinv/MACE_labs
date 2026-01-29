ip = False
try:
    ip = open('file.txt')
    lines = ip.readlines() 
    match = False
    for line in lines:
        stripped_line = line.strip() #removes white spaces
        if stripped_line and stripped_line.startswith('s') and stripped_line.endswith('e'):
            print(stripped_line)
            match = True

    if not match:
        print('Specific lines not found!!!')
        
except IOError as ie:
    print(ie)
    
finally:
    if ip:ip.close()
