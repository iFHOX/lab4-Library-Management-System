import java.util.ArrayList;

public class Member {

	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.

	private String name;
	private String memberId;
	private ArrayList<Book> borrowedBooks;
	// private borrowedbBooks DONE: implement collection of borrowed books
	
	public Member(String memberId, String name) {
		this.name = name;
		this.memberId = memberId;
		this.borrowedBooks = new ArrayList<>();
	}
	// DONE: implement functionality of Member class

	public boolean borrowBook(Book book) {
		if (book != null && book.borrowBook()) {
			borrowedBooks.add(book);
			System.out.println(name + " succesfully borrowed " + book.getTitle());
			return true;
		}
		System.out.println(name + " can't borrow " + book.getTitle() + ", it is already borrowed.");
		return false;
	}
	
	public boolean returnBook(Book book) {
		if (book != null && borrowedBooks.contains(book)) {
			if (book.returnBook()) {
				borrowedBooks.remove(book);
				System.out.println(name + " has returned " + book.getTitle());
				return true;
			}
		}
		System.out.println(name + " didn't borrow " + book.getTitle());
		return false;
	}
	
	public String getName() {
		return name;
	}

	public String getMemberId() {
		return memberId;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return new ArrayList<>(borrowedBooks);
	}
	
	@Override
	public String toString() {
		return name + " (ID: " + memberId + ") - " + borrowedBooks.size() + " book(s) borrowed";
	}

}
