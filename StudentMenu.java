 
package lbs;


	
	import java.sql.*;
	import java.util.Scanner;

	public class StudentMenu {

	    public static void studentOperations() {
	        Scanner sc = new Scanner(System.in);
	        Connection con = DBConnection.getConnection();

	        while (true) {
	            System.out.println("\n--- Student Menu ---");
	            System.out.println("1. View Available Books");
	            System.out.println("2. Issue Book");
	            System.out.println("3. Return Book");
	            System.out.println("4. Back");
	            System.out.print("Enter choice: ");

	            int ch = sc.nextInt();

	            try {
	                if (ch == 1) {
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

	                } else if (ch == 2) {
	                    System.out.print("Book ID: ");
	                    int bookId = sc.nextInt();
	                    sc.nextLine();

	                    System.out.print("Student Name: ");
	                    String name = sc.nextLine();

	                    PreparedStatement ps = con.prepareStatement(
	                        "INSERT INTO issued_books(book_id, student_name, issue_date) VALUES(?,?,CURDATE())"
	                    );
	                    ps.setInt(1, bookId);
	                    ps.setString(2, name);
	                    ps.executeUpdate();

	                    PreparedStatement ps2 = con.prepareStatement(
	                        "UPDATE books SET quantity = quantity - 1 WHERE book_id=?"
	                    );
	                    ps2.setInt(1, bookId);
	                    ps2.executeUpdate();

	                    System.out.println("Book Issued Successfully");

	                } else if (ch == 3) {
	                    System.out.print("Issue ID: ");
	                    int issueId = sc.nextInt();

	                    PreparedStatement ps = con.prepareStatement(
	                        "UPDATE issued_books SET return_date = CURDATE() WHERE issue_id=?"
	                    );
	                    ps.setInt(1, issueId);
	                    ps.executeUpdate();

	                    System.out.println("Book Returned Successfully");

	                } else if (ch == 4) {
	                    break;
	                } else {
	                    System.out.println("Invalid choice");
	                }
	            } catch (Exception e) {
	                System.out.println("Student Operation Failed");
	            }
	        }
	    }
	}



