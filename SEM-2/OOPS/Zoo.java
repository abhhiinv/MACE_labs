import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zoo {
    private String name;
    private String[] regions;
    private Contact contact;
    private List<Enclosure> enclosures;

    public Zoo(String name, String[] regions, Contact contact) {
        this.name = name;
        this.regions = regions;
        this.contact = contact;
        this.enclosures = new ArrayList<>();
    }

    public void addEnclosure(String name, String type, String[] animals) {
        enclosures.add(new Enclosure(name, type, animals));
    }

    public void displayDetails() {
        System.out.println("Zoo: " + name);
        System.out.println("Regions: " + Arrays.toString(regions));
        contact.display();
        
        System.out.println("\nEnclosures:");
        for (Enclosure e : enclosures) {
            e.display();
        }
    }

    // Static Nested Class
    static class Contact {
        private String address;
        private String phone_no;

        public Contact(String address, String phone_no) {
            this.address = address;
            this.phone_no = phone_no;
        }

        public void display() {
            System.out.println("Contact: " + address + " | " + phone_no);
        }
    }

    // Inner Class
    class Enclosure {
        private String name;
        private String type;
        private String[] animals;

        public Enclosure(String name, String type, String[] animals) {
            this.name = name;
            this.type = type;
            this.animals = animals;
        }

        public void display() {
            System.out.println("  " + name + " (" + type + "): " + Arrays.toString(animals));
        }
    }

    public static void main(String[] args) {
        Zoo.Contact contact = new Zoo.Contact("123 Safari Road", "555-0100");
        Zoo zoo = new Zoo("Wild Kingdom", new String[]{"Area-1", "Area-2"}, contact);

        zoo.addEnclosure("Grassland", "Outdoor", new String[]{"Lion", "Zebra"});
        zoo.addEnclosure("Flyzone", "Indoor", new String[]{"Parrot", "Eagle"});
        zoo.addEnclosure("Aquatic", "Indoor", new String[]{"Shark", "Dolphin"});

        zoo.displayDetails();
    }
}