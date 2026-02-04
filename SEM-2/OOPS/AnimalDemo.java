
abstract class Animal{
    private String species;
    protected int age,weight;
    String color;
    Animal(){
        this("Unknown",0,0,"Unknown");
    }
    Animal(String species,int age,int weight,String color){
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }
    public abstract void display();
}

class Dog extends Animal{
    String breed, name, owner;
    Dog(String breed,String name,String owner,int age,int weight,String color){
        super("Canine",age,weight,color);
        this.breed = breed;
        this.name = name;
        this.owner = owner;
    }
    @Override
    public void display() {
        System.out.println("Dog: " + name + " | Breed: " + breed + " | Owner: " + owner + " | Age: " + age);
    }
}

class Cat extends Animal{
    String name,eyeColor;
    int tailLength;
    Cat(String name, String eyeColor, int tailLength, int age, int weight, String color){
        super("Feline",age,weight,color);
        this.name = name;
        this.eyeColor = eyeColor;
        this.tailLength = tailLength;
    }
    public void showCatDetails() {
        System.out.println("Cat: " + name + " | Eye Color: " + eyeColor + " | Tail: " + tailLength + "cm");
    }

    @Override
    public void display() { showCatDetails(); }
}

public class AnimalDemo{
    public static void main(String[] args) {
        Animal dog = new Dog("Labrador", "Buddy", "Alex", 3, 25, "Gold");
        Animal cat = new Cat("Tuttu","Blue",20,6,12,"White");
        dog.display();
        cat.display();
    }
}