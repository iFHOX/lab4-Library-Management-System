public class Book {

	// GRASP Principle: Information Expert
	// Manages its own state (available or borrowed).
	private String title;
	private boolean isAvailable;
	private String author;
	
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	} 
	
	// DONE: implement Book functionality
	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public String getAuthor() {
		return author;
	}	
	
	public boolean borrowBook() {
		if(isAvailable) {
			isAvailable = false;
			return true;
		}
		return false;
	}

	public boolean returnBook() {
		if (!isAvailable) {
			isAvailable = true;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
	    return title + " by " + author + (isAvailable ? " [Available]" : " [Borrowed]");
	}
}
