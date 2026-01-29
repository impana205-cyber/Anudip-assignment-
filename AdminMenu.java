package lbs;

	
	import java.sql.*;
	import java.util.Scanner;

	public class AdminMenu {

	    public static void adminOperations() {
	        Scanner sc = new Scanner(System.in);
	        Connection con = DBConnection.getConnection();

	        while (true) {
	            System.out.println("\n--- Admin Menu ---");
	            System.out.println("1. Add Book");
	            System.out.println("2. View All Books");
	            System.out.println("3. Update Book Quantity");
	            System.out.println("4. Delete Book");
	            System.out.println("5. Back");
	            System.out.print("Enter choice: ");

	            int ch = sc.nextInt();

	            try {
	                if (ch == 1) {
	                    sc.nextLine();
	                    System.out.print("Book Title: ");
	                    String title = sc.nextLine();

	                    System.out.print("Author: ");
	                    String author = sc.nextLine();

	                    System.out.print("Quantity: ");
	                    int qty = sc.nextInt();

	                    PreparedStatement ps = con.prepareStatement(
	                        "INSERT INTO books(title, author, quantity) VALUES(?,?,?)"
	                    );
	                    ps.setString(1, title);
	                    ps.setString(2, author);
	                    ps.setInt(3, qty);
	                    ps.executeUpdate();

	                    System.out.println("Book Added Successfully");

	                } else if (ch == 2) {
	                    Statement st = con.createStatement();
	                    ResultSet rs = st.executeQuery("SELECT * FROM books");

	                    while (rs.next()) {
	                        System.out.println(
	                            rs.getInt(1) + " | " +
	                            rs.getString(2) + " | " +
	                            rs.getString(3) + " | Qty: " +
	                            rs.getInt(4)
	                        );
	                    }

	                } else if (ch == 3) {
	                    System.out.print("Book ID: ");
	                    int id = sc.nextInt();

	                    System.out.print("New Quantity: ");
	                    int qty = sc.nextInt();

	                    PreparedStatement ps = con.prepareStatement(
	                        "UPDATE books SET quantity=? WHERE book_id=?"
	                    );
	                    ps.setInt(1, qty);
	                    ps.setInt(2, id);
	                    ps.executeUpdate();

	                    System.out.println("Quantity Updated");

	                } else if (ch == 4) {
	                    System.out.print("Book ID: ");
	                    int id = sc.nextInt();

	                    PreparedStatement ps = con.prepareStatement(
	                        "DELETE FROM books WHERE book_id=?"
	                    );
	                    ps.setInt(1, id);
	                    ps.executeUpdate();

	                    System.out.println("Book Deleted");

	                } else if (ch == 5) {
	                    break;
	                } else {
	                    System.out.println("Invalid choice");
	                }
	            } catch (Exception e) {
	                System.out.println("Admin Operation Failed");
	            }
	        }
	    }
	}



