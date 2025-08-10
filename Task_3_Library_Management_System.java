import java.util.*;
class user
{
    String name;
    String userId;
    String Department;
}

class user_Authentication
{
    void login(String userId, Vector<user> userList, Scanner sc, user_Registration registration)
    {
        String name ,department ;
        name = department = "";
        for (user u : userList) 
        {
            if (u.userId.equals(userId)) 
            {
                System.out.println("User logged in " + u.name);
                return;
            }
        }
        System.out.println("User ID not found. Please register.");
        System.out.println("Do you want to register? (yes/no)");
        String response = sc.next();
        if (response.equalsIgnoreCase("yes")) 
        {
            System.out.println("Enter your name:");
            name = sc.next();
            System.out.println("Enter your Department:");
            department = sc.next();
            registration.register(name, userId, department, userList);
        } 
        else 
        {
            System.out.println("Exiting the system.");
        }
    }
}

class user_Registration
{
    void register(String name, String userId, String Department, Vector<user> userList) 
    {
        for (user u : userList) 
        {
            if (u.userId.equals(userId)) 
            {
                System.out.println("User ID already exists. Please enter a unique ID.");
                return;
            }
        }
        user newUser = new user();
        newUser.name = name;
        newUser.userId = userId;
        newUser.Department = Department;
        userList.add(newUser);
        System.out.println("User registered successfully!");
    }
}

class Books_Reservation
{
    void reserve(Books_Status booksStatus, Vector<Books_Status> booksStatusList, Scanner sc, int choice) 
    {
        if(choice == 1)
        {
            System.out.println("choose an option:");
            System.out.println("(1) Add a book");
            System.out.println("(2) View all books");
            System.out.println("(3) Update book status");
            System.out.println("(4) Delete a book");
            int adminChoice = sc.nextInt();
            switch (adminChoice) 
            {
                case 1:
                    System.out.println("Enter book name:");
                    String bookName = sc.next();
                    System.out.println("Enter book ID:");
                    String bookId = sc.next();
                    System.out.println("Enter book status (1 for available, 0 for not available):");
                    int status = sc.nextInt();
                    Books_Status newBook = new Books_Status();
                    newBook.bookname = bookName;
                    newBook.bookId = bookId;
                    newBook.status = status;
                    booksStatusList.add(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.println("Books in the library:");
                    for (Books_Status book : booksStatusList) 
                    {
                        System.out.println("Book Name: " + book.bookname + ", Book ID: " + book.bookId + ", Status: " + (book.status == 1 ? "Available" : "Not Available"));
                    }
                    break;
                case 3:
                    System.out.println("Enter book ID to update status:");
                    String updateBookId = sc.next();
                    boolean found = false;
                    for (Books_Status book : booksStatusList) 
                    {
                        if (book.bookId.equals(updateBookId)) 
                        {
                            System.out.println("Enter new status (1 for available, 0 for not available):");
                            book.status = sc.nextInt();
                            found = true;
                            System.out.println("Book status updated successfully!");
                            break;
                        }
                    }
                    if (!found) 
                    {
                        System.out.println("Book ID not found.");
                    } 
                    break;
                case 4:
                    System.out.println("Enter book ID to delete:");
                    String deleteBookId = sc.next();
                    for (int i = 0; i < booksStatusList.size(); i++) 
                    {
                        if (booksStatusList.get(i).bookId.equals(deleteBookId)) 
                        {
                            booksStatusList.remove(i);
                            System.out.println("Book deleted successfully!");
                            return;
                        }
                    }
                    System.out.println("Book ID not found.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        else if(choice == 2)
        {
            System.out.println("Books in the library:");
            for (Books_Status book : booksStatusList) 
            {
                System.out.println("Book Name: " + book.bookname + ", Book ID: " + book.bookId + ", Status: " + (book.status == 1 ? "Available" : "Not Available"));
            }
                    
                System.out.println("Enter book ID to reserve:");
                String reserveBookId = sc.next();
                boolean reserved = false;
                for (Books_Status book : booksStatusList) 
                {
                    if (book.bookId.equals(reserveBookId)) 
                    {
                        if (book.status == 1) 
                        {
                            book.status = 0;
                            System.out.println("Book reserved successfully!");
                        } 
                        else 
                        {
                            System.out.println("Book is not available for reservation.");
                        }
                        reserved = true;
                    }
                }
                if (!reserved) 
                {
                    System.out.println("Book ID not found.");
                }  
        }
        else 
        {
            System.out.println("Invalid choice. Exiting.");
        }
    }
}

class Books_Status
{
    String bookname;
    String bookId;
    int status;
}

public class Task_3_Library_Management_System 
{
    public static void main(String[] args) 
    {
        Vector<user> userList = new Vector<>();
        Vector<Books_Status> booksStatusList = new Vector<>();
        user_Authentication auth = new user_Authentication();
        user_Registration registration = new user_Registration();
        Books_Reservation reservation = new Books_Reservation();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System");

        while (true) 
        {
            System.out.println("\nChoose an option:");
            System.out.println("(1) Admin");
            System.out.println("(2) User");
            System.out.println("(3) Exit");
            int choice = sc.nextInt();

            if (choice == 1) 
            {
                System.out.println("Do you have admin user ID? (yes/no)");
                String hasAdmin = sc.next();
                if (hasAdmin.equalsIgnoreCase("yes")) 
                {
                    System.out.println("Enter your Admin ID:");
                    String adminId = sc.next();
                    auth.login(adminId, userList, sc, registration);
                    boolean adminSession = true;
                    while (adminSession) 
                    {
                        System.out.println("\nAdmin Menu:");
                        System.out.println("(1) Add/View/Update/Delete Books");
                        System.out.println("(2) Logout");
                        int adminMenu = sc.nextInt();
                        if (adminMenu == 1) 
                        {
                            reservation.reserve(null, booksStatusList, sc, 1);
                        } 
                        else if (adminMenu == 2) 
                        {
                            adminSession = false;
                            System.out.println("Admin logged out.");
                        } 
                        else 
                        {
                            System.out.println("Invalid choice.");
                        }
                    }
                } 
                else 
                {
                    System.out.println("Please register as an admin first.");
                }
            } 
            else if (choice == 2) 
            {
                System.out.println("Do you have user ID? (yes/no)");
                String hasUserId = sc.next();
                if (hasUserId.equalsIgnoreCase("yes")) 
                {
                    System.out.println("Enter your User ID:");
                    String userId = sc.next();
                    auth.login(userId, userList, sc, registration);
                    boolean userSession = true;
                    while (userSession) 
                    {
                        System.out.println("\nUser Menu:");
                        System.out.println("(1) View/Reserve Books");
                        System.out.println("(2) Logout");
                        int userMenu = sc.nextInt();
                        if (userMenu == 1) 
                        {
                            reservation.reserve(null, booksStatusList, sc, 2);
                        } 
                        else if (userMenu == 2) 
                        {
                            userSession = false;
                            System.out.println("User logged out.");
                        } 
                        else 
                        {
                            System.out.println("Invalid choice.");
                        }
                    }
                } 
                else 
                {
                    System.out.println("Please register first.");
                }
            } 
            else if (choice == 3) 
            {
                System.out.println("Exiting the system. Goodbye!");
                break;
            } 
            else 
            {
                System.out.println("Invalid choice. Exiting.");
                break;
            }
        }
        sc.close();
    }
}
