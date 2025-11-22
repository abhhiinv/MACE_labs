class Person:
    def __init__(self,name,rollNo):
        self.name = name
        self.rollNo = rollNo
    def disp(self):
        print(f'Name:{self.name}\nRoll No:{self.rollNo}')
class Marks:
    def __init__(self,maths,comp):
        self.maths = maths
        self.comp = comp
    def disp(self):
        print(f'Maths : {self.maths}\nComputer : {self.comp}')
class Student(Person,Marks):
    def __init__(self, name, rollNo, maths = 0, comp = 0):
        super().__init__(name, rollNo)
        Marks.__init__(self,maths,comp)
    def get_percentage(self):
        return (self.maths + self.computer) / 2
    def disp(self):
        percent = self.get_percentage()
        print('Student Details')
        Student.disp(self)
        Marks.disp(self)
        print(f'Percentage : {self.percent}')
        if percent >= 50:
            print(f'Result : Pass')
        else:
            print(f'Result : Fail')

s1 = Student('Madhav',39,49,52)
s2 = Student('Vasudev',51,69,81)
s1.disp()
s2.disp()
p1=s1.get_percentage()
p2=s2.get_percentage()
if p1>p2:
    print(f'{s1.name} has higher percentage {p1}% than')