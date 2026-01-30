class CPU {
    int price;

    CPU(int price) {
        this.price = price;
    }

    class Processor {
        int cores;
        String manufacturer;

        Processor(int cores, String manufacturer) {
            this.cores = cores;
            this.manufacturer = manufacturer;
        }

        void display() {
            System.out.println("--- Processor Details ---");
            System.out.println("Cores: " + cores);
            System.out.println("Manufacturer: " + manufacturer);
        }
    }

    static class RAM {
        int memory;
        String manufacturer;

        RAM(int memory, String manufacturer) {
            this.memory = memory;
            this.manufacturer = manufacturer;
        }

        void display() {
            System.out.println("--- RAM Details ---");
            System.out.println("Memory: " + memory + "GB");
            System.out.println("Manufacturer: " + manufacturer);
        }
    }

    void displayCPU() {
        System.out.println("CPU Price: Rs." + price);
    }
}

class Main {
    public static void main(String[] args) {
        // 1. Create CPU object
        CPU myCpu = new CPU(23000);

        // 2. Create Inner Class (Processor) object
        //OuterObject.new InnerClass()
        CPU.Processor myProcessor = myCpu.new Processor(8, "Intel");

        // 3. Create Static Nested Class (RAM) object
        //new OuterClass.StaticNestedClass()
        CPU.RAM myRam = new CPU.RAM(16, "Corsair");

        myCpu.displayCPU();
        myProcessor.display();
        myRam.display();
    }
}