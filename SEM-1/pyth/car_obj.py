class Engine:
    def __init__(self,power):
        self._power = power
    def disp(self):
        print("Power of this car is",self._power,"HP")

class Wheels:
    def __init__(self,size):
        self._size = size
    def disp(self):
        print("The wheel size is",self._size,"inches")

class Car(Engine,Wheels):
    def __init__(self,model = "Mustang G T",power = 486,size = 19):
        Engine.__init__(self, power)
        Wheels.__init__(self, size)
        self._model = model
    def disp(self):
        print("The model is",self._model)
        Engine.disp(self)
        Wheels.disp(self)
car = Car()
car.disp()