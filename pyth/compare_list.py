def comp(l1,l2):
    if len(l1) != len(l2):
        print('Number of elements are unequal')
        return False
    s1 = sorted(l1)
    s2 = sorted(l2)
    for i in range(len(l1)):
        if s1[i] != s2[i]:
            print('List is not equal')
            return False
        else:
            print('List is equal')
            return True
li1 = input('Enter the items in list 1 : ').split(',')
li2 = input('Enter the items in list 2 : ').split(',')
comp(li1,li2)