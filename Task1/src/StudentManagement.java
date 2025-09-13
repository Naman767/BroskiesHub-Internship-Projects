import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagement {
        private static ArrayList<Student> students = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        // Add a new student
        public static void addStudent() {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Grade: ");
            double grade = scanner.nextDouble();

            students.add(new Student(id, name, grade));
            System.out.println("Student added successfully!");
        }

        // Remove a student by ID
        public static void removeStudent() {
            System.out.print("Enter Student ID to remove: ");
            int id = scanner.nextInt();
            boolean removed = false;

            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() == id) {
                    students.remove(i);
                    removed = true;
                    System.out.println("Student removed successfully!");
                    break;
                }
            }

            if (!removed) {
                System.out.println("Student with ID " + id + " not found.");
            }
        }

        // Display all students
        public static void displayStudents() {
            if (students.isEmpty()) {
                System.out.println("No students available.");
            } else {
                System.out.println("----- Student List -----");
                for (Student s : students) {
                    System.out.println(s);
                }
                System.out.println();
            }
        }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> displayStudents();
                case 4 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
}

