
 import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Book> mainInventory;
	private List<Book> lendingInventory;

	public Inventory() {
		this.mainInventory = new ArrayList<>();
		this.lendingInventory = new ArrayList<>();
	}

	public void addBook(Book book) {
		mainInventory.add(book);
		System.out.println("Book added to library);
	}

	public boolean borrowBook(int id) {
		for (Book book : mainInventory) {
			if (book.getId() == id) {
				mainInventory.remove(book);
				lendingInventory.add(book);
				return true;
			}	
		}
		return false;
	}


	public boolean returnBook(int id) {
		for (Book book : lendingInventory) {
			if (book.getId() == id) {
				lendingInventory.remove(book);
				mainInventory.add(book);
				return true;
			}
		}
		return false;
	}

	public void printAll() {
		if (mainInventory.isEmpty()) {
			System.out.println("No books in library");
		} else {
			for (Book book : mainInventory) {
				book.printBookInfo();
			}
		}
	}	


	public void searchByTitle(String title) {
		boolean found = false;
		for (Book book : mainInventory) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				book.printBookInfo();
				found = true;
			}
		}
		if (!found) {
			System.out.println("No books found with the title: " + title);
		}
	}

	public int getMainInventoryCount() {
		return mainInventory.size();
		}
	}
			