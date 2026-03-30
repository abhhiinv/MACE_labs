import java.sql.*;
import java.util.Scanner;

public class BookMenu {

    static final String URL  = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASS = "yourpassword";

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        Scanner sc = new Scanner(System.in);

        // Create table if not exists
        con.createStatement().executeUpdate(
            "CREATE TABLE IF NOT EXISTS Book (" +
            "BookId INT PRIMARY KEY AUTO_INCREMENT, " +
            "Title  VARCHAR(100), " +
            "Author VARCHAR(100), " +
            "Price  DOUBLE)"
        );

        int choice;
        do {
            System.out.println("\n===== BOOK MENU =====");
            System.out.println("1. Insert Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search by Title");
            System.out.println("4. Books by Author");
            System.out.println("5. Update Price");
            System.out.println("6. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: // Insert
                    System.out.print("Title  : "); String title  = sc.nextLine();
                    System.out.print("Author : "); String author = sc.nextLine();
                    System.out.print("Price  : "); double price  = sc.nextDouble();
                    sc.nextLine();
                    PreparedStatement ins = con.prepareStatement(
                        "INSERT INTO Book (Title, Author, Price) VALUES (?, ?, ?)");
                    ins.setString(1, title);
                    ins.setString(2, author);
                    ins.setDouble(3, price);
                    ins.executeUpdate();
                    System.out.println("Book inserted successfully.");
                    break;

                case 2: // Display all
                    ResultSet rs = con.createStatement()
                                      .executeQuery("SELECT * FROM Book");
                    printHeader();
                    while (rs.next()) printRow(rs);
                    break;

                case 3: // Search by title
                    System.out.print("Enter Title: "); String t = sc.nextLine();
                    PreparedStatement sbt = con.prepareStatement(
                        "SELECT * FROM Book WHERE Title = ?");
                    sbt.setString(1, t);
                    ResultSet rt = sbt.executeQuery();
                    printHeader();
                    boolean found = false;
                    while (rt.next()) { printRow(rt); found = true; }
                    if (!found) System.out.println("No book found with that title.");
                    break;

                case 4: // Books by author
                    System.out.print("Enter Author: "); String a = sc.nextLine();
                    PreparedStatement sba = con.prepareStatement(
                        "SELECT * FROM Book WHERE Author = ?");
                    sba.setString(1, a);
                    ResultSet ra = sba.executeQuery();
                    printHeader();
                    boolean any = false;
                    while (ra.next()) { printRow(ra); any = true; }
                    if (!any) System.out.println("No books found for that author.");
                    break;

                case 5: // Update price
                    System.out.print("Enter Title to update: "); String ut = sc.nextLine();
                    System.out.print("Enter new Price      : "); double np = sc.nextDouble();
                    sc.nextLine();
                    PreparedStatement upd = con.prepareStatement(
                        "UPDATE Book SET Price = ? WHERE Title = ?");
                    upd.setDouble(1, np);
                    upd.setString(2, ut);
                    int ur = upd.executeUpdate();
                    System.out.println(ur > 0 ? "Price updated." : "Book not found.");
                    break;

                case 6: // Delete
                    System.out.print("Enter Title to delete: "); String dt = sc.nextLine();
                    PreparedStatement del = con.prepareStatement(
                        "DELETE FROM Book WHERE Title = ?");
                    del.setString(1, dt);
                    int dr = del.executeUpdate();
                    System.out.println(dr > 0 ? "Book deleted." : "Book not found.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        con.close();
        sc.close();
    }

    static void printHeader() {
        System.out.println("+--------+----------------------+------------------+--------+");
        System.out.printf( "| %-6s | %-20s | %-16s | %-6s |%n",
                           "BookId", "Title", "Author", "Price");
        System.out.println("+--------+----------------------+------------------+--------+");
    }

    static void printRow(ResultSet rs) throws SQLException {
        System.out.printf("| %-6d | %-20s | %-16s | %-6.2f |%n",
            rs.getInt("BookId"),
            rs.getString("Title"),
            rs.getString("Author"),
            rs.getDouble("Price"));
        System.out.println("+--------+----------------------+------------------+--------+");
    }
}