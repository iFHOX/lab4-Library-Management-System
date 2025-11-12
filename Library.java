import java.util.ArrayList;

public class Library {
	
	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available
	
	
	// Attributes:
	private ArrayList<Book> catalog;
	private ArrayList<Member> members;

	// TODO: implement functionality of Member class
	
	public Library() {
		this.catalog = new ArrayList<>();
		this.members = new ArrayList<>();
	}
	
	public void addBook(String title, String author) {
        Book book = new Book(title, author);
        catalog.add(book);
        System.out.println("Added book: " + title);
    }
	
	public void registerMember(String memberId, String name) {
        Member member = new Member(memberId, name);
        members.add(member);
        System.out.println("Registered member: " + name);
    }
	
	public Book findBookByTitle(String title) {
        for (Book b : catalog) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }
	
	public Member findMemberByName(String name) {
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
	
	public Member findMemberById(String memberId) {
		for (Member member : members) {
			if (member.getMemberId().equals(memberId)) {
				return member;
			}
		}
		return null;
	}
	
	public boolean removeBook(String title) {
		Book book = findBookByTitle(title);
		if (book != null) {
			if (!book.isAvailable()) {
				System.out.println("Cannot remove " + title + " - it is currently borrowed.");
				return false;
			}
			catalog.remove(book);
			System.out.println(title + " has been removed from the catalog.");
			return true;
		}
		System.out.println("Book " + title + " not found in catalog.");
		return false;
	}
	
	public boolean removeMember(String name) {
		Member member = findMemberByName(name);
		if (member != null) {
			if (!member.getBorrowedBooks().isEmpty()) {
				System.out.println("Cannot remove member " + name + " - they have borrowed books.");
				return false;
			}
			members.remove(member);
			System.out.println("Member " + name + " has been removed.");
			return true;
		}
		System.out.println("Member " + name + " not found.");
		return false;
	}
	
	public void showMembers() {
        System.out.println("\nLibrary Members:");
        for (Member m : members) {
            System.out.println(m);
        }
    }
	
	public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : catalog) {
            if (b.isAvailable()) {
                System.out.println(b);
            }
        }
    }
	
	public ArrayList<Book> getCatalog() {
		return new ArrayList<>(catalog);
	}

	public ArrayList<Member> getMembers() {
		return new ArrayList<>(members);
	}
	
	

}
