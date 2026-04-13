package app;
import dao.StudentDAO;
import model.Student;
import java.util.Scanner;

public class MainApp
{
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        StudentDAO dao = new StudentDAO();

	        int choice;

	        do {
	            System.out.println("\n===== MENU =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. View Students");
	            System.out.println("3. Update Student");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Exit");
	            System.out.print("Enter choice: ");

	            choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    System.out.print("ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();

	                    System.out.print("Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Course: ");
	                    String course = sc.nextLine();

	                    dao.addStudent(new Student(id, name, course));
	                    break;

	                case 2:
	                    dao.viewStudents();
	                    break;

	                case 3:
	                    System.out.print("Enter ID to update: ");
	                    int uid = sc.nextInt();
	                    sc.nextLine();

	                    System.out.print("New Name: ");
	                    String uname = sc.nextLine();

	                    System.out.print("New Course: ");
	                    String ucourse = sc.nextLine();

	                    dao.updateStudent(uid, uname, ucourse);
	                    break;

	                case 4:
	                    System.out.print("Enter ID to delete: ");
	                    int did = sc.nextInt();

	                    dao.deleteStudent(did);
	                    break;

	                case 5:
	                    System.out.println("Exiting...");
	                    break;

	                default:
	                    System.out.println("Invalid choice");
	            }

	        } while (choice != 5);
	    }
}
