
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentCRUD {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("--- Student Records ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : studentList) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                s.name = scanner.nextLine();

                System.out.print("Enter new marks: ");
                s.marks = scanner.nextDouble();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = scanner.nextInt();

        for (Student s : studentList) {
            if (s.id == id) {
                studentList.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }
}
