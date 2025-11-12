public class LibraryApp {

    public static void main(String[] args) {

        Library library = new Library();
        LibrarianController controller = new LibrarianController(library);

        System.out.println("*** Library Management System Demo ***\n");


        library.addBook("Dune", "Frank Herbert");
        library.addBook("1984", "George Orwell");
        library.addBook("Moby Dick", "Herman Melville");


        library.registerMember("1", "Alice");
        library.registerMember("2", "Bob");


        library.showMembers();
        library.showAvailableBooks();


        System.out.println("\n*** Borrowing ***");
        controller.borrowBook("Alice", "Dune");
        controller.borrowBook("Bob", "1984");
        controller.borrowBook("Bob", "Dune");

        library.showAvailableBooks();


        System.out.println("\n*** Returning ***");
        controller.returnBook("Alice", "Dune");
        controller.borrowBook("Bob", "Dune");

        library.showAvailableBooks();
    }
}
