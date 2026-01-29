package lbs;

	
	import java.util.Scanner;

	public class LibraryMain {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n===== Library Management System =====");
	            System.out.println("1. Admin (Librarian)");
	            System.out.println("2. Student");
	            System.out.println("3. Exit");
	            System.out.print("Enter choice: ");

	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    AdminMenu.adminOperations();
	                    break;
	                case 2:
	                    StudentMenu.studentOperations();
	                    break;
	                case 3:
	                    System.out.println("Thank you for using Library System");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }
	}



