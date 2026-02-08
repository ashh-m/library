import java.util.Scanner;
import java.util.InputMismatchException;

public class LibraryApp {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		System.out.println("Welcome to the Library App!");

		while (running) {
			System.out.println("\nMenu:");
			System.out.println("1. Add Book");
			System.out.println("2. Borrow Book");
			System.out.println("3. Return Book");
			System.out.println("4. View All Books");
			System.out.println("5. Search by Title");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");

			try {
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				switch (choice) {
					case 1:
						System.out.print("Enter ID: ");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter title: ");
					String title = scanner.nextLine();
					System.out.print("Enter Author: ");
					String author = scanner.nextLine();
					System.out.print("Enter ISBN: ");
					String isbn = scanner.nextLine();
					System.out.print("Enter Pages: ");
					int pages = scanner.nextInt();

					inventory.addBook(new Book(id, title, author, isbn, pages));
					break;

				case 2:
					System.out.print("Enter ID of book to borrow: ");
					int borrowId = scanner.nextInt();
					if (inventory.borrowBook(borrowId)) {
						System.out.println("Book borrowed successfully!");
					} else {
						System.out.println("Book not found or already borrowed.");
					}	
					break;

				case 3:
					System.out.print("Enter ID of book to return: ");
					int returnId = scanner.nextInt();
					if (inventory.returnBook(returnId)) {
						System.out.println("Book returned successfully!");
					} else {
						System.out.println("Book not found in lending inventory.");
					}		
					break;

				case 4:
					inventory.printAll();
					break;

				case 5:
					System.out.print("Search Title: ");
					String searchTitle = scanner.nextLine();
					inventory.searchByTitle(searchTitle);
						System.out.println("Exiting the Library App. Goodbye!");
						running = false;
						break;

					default:
						System.out.println("Invalid option. Please 1-6.");

				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();	
			}	
	}
	scanner.close();
	}	
}
					
				