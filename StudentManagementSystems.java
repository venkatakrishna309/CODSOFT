import java.util.*;
import java.io.*;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructor
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully!");
    }

    public void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            out.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.dat"))) {
            students = (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All Students\n5. Save to File\n6. Load from File\n7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    loadFromFile();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class StudentManagementSystems {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.run();
    }
}