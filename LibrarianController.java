public class LibrarianController {

	// GRASP Principle: Controller
	// Handles user requests like borrowing and returning books.
	// Delegates tasks to the appropriate objects.
	
	// DONE: implement functionality of Member class
	private Library library;

    public LibrarianController(Library library) {
        this.library = library;
    }

    public void borrowBook(String memberName, String bookTitle) {
        Member member = library.findMemberByName(memberName);
        Book book = library.findBookByTitle(bookTitle);

        if (member == null) {
            System.out.println("Member " + memberName + " not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book " + bookTitle + " not found.");
            return;
        }

        member.borrowBook(book);
    }

    public void returnBook(String memberName, String bookTitle) {
        Member member = library.findMemberByName(memberName);
        Book book = library.findBookByTitle(bookTitle);

        if (member == null || book == null) {
            System.out.println("Invalid member or book.");
            return;
        }

        member.returnBook(book);
    }

}
