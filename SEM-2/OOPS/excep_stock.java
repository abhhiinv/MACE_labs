/*
Create a class Product (productName, stockQuantity).
Implement a method purchase (int quantity):
    if the requested quantity is less than or equal to zero, 
        throw bulit-in IllegealArgumentException with the message:"Quantity must be positive".
    if the requested quantity is greater than stockQuantity, throw a custom OutOfStockException.
 */
class OutOfStockException extends Exception {
    public OutOfStockException(String productName, int requested, int available) {
        super("OutOfStock: '" + productName + "' | Requested: " + requested + ", Available: " + available);
    }
}

class Product {
    String productName;
    int stockQuantity;

    Product(String productName, int stockQuantity) {
        this.productName = productName;
        this.stockQuantity = stockQuantity;
    }

    void purchase(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > stockQuantity) {
            throw new OutOfStockException(productName, quantity, stockQuantity);
        }
        stockQuantity -= quantity;
        System.out.println("Purchase successful! Bought " + quantity + " unit(s) of '" + productName + "'. Remaining stock: " + stockQuantity);
    }
}

public class excep_stock {
    public static void main(String[] args) {
        Product p = new Product("Wireless Mouse", 5);

        int[] testQuantities = {3, -1, 0, 4};

        for (int qty : testQuantities) {
            try {
                System.out.print("Attempting to purchase " + qty + " unit(s): ");
                p.purchase(qty);
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException -> " + e.getMessage());
            } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}