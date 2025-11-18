import re
def pwdval(pwd):
    pattern = r"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$#@])[a-zA-Z0-9$#@]{6,16}$"
    return re.match(pattern,pwd)

pwd = input('Enter your password : ')
if pwdval(pwd):
    print('Valid ^_^')
else:
    print('Try again ToT')