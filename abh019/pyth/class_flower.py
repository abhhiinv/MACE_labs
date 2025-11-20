class Flower:
    def __init__(self,name):
        self.name = name
fl1 = Flower("Rose")
fl2 = Flower("Tulip")
fl1.color = "Red"

if hasattr(fl1,"color"):
    print(f"{fl1.color} {fl1.name}")
else:
    print(f"Unknown color for {fl2.name}")