package std;

//StudentManagementSystem.java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

 private static ArrayList<Student> students = new ArrayList<>();
 private static Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) {
     int choice;
     do {
         displayMenu();
         choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (choice) {
             case 1: addStudent(); break;
             case 2: viewStudents(); break;
             case 3: updateStudent(); break;
             case 4: deleteStudent(); break;
             case 5: System.out.println("Exiting the system."); break;
             default: System.out.println("Invalid choice. Please try again.");
         }
     } while (choice != 5);
     scanner.close();
 }

 private static void displayMenu() {
     System.out.println("\n--- Student Record Management ---");
     System.out.println("1. Add a new student");
     System.out.println("2. View all students");
     System.out.println("3. Update a student's record");
     System.out.println("4. Delete a student's record");
     System.out.println("5. Exit");
     System.out.print("Enter your choice: ");
 }

 private static void addStudent() {
     System.out.print("Enter ID: ");
     int id = scanner.nextInt();
     scanner.nextLine(); 
     System.out.print("Enter name: ");
     String name = scanner.nextLine();
     System.out.print("Enter marks: ");
     double marks = scanner.nextDouble();
     scanner.nextLine(); 

     students.add(new Student(id, name, marks));
     System.out.println("Student added successfully! ✅");
 }

 private static void viewStudents() {
     if (students.isEmpty()) {
         System.out.println("No student records found.");
     } else {
         System.out.println("\n--- All Student Records ---");
         for (Student student : students) {
             System.out.println(student);
         }
     }
 }

 private static void updateStudent() {
     System.out.print("Enter student ID to update: ");
     int id = scanner.nextInt();
     scanner.nextLine(); 

     for (Student student : students) {
         if (student.getId() == id) {
             System.out.print("Enter new name (current: " + student.getName() + "): ");
             String newName = scanner.nextLine();
             if (!newName.isEmpty()) {
                 student.setName(newName);
             }
             
             System.out.print("Enter new marks (current: " + student.getMarks() + "): ");
             double newMarks = scanner.nextDouble();
             student.setMarks(newMarks);
             scanner.nextLine(); 

             System.out.println("Student record updated successfully! ✍️");
             return; 
         }
     }
     System.out.println("Student with ID " + id + " not found.");
 }

 private static void deleteStudent() {
     System.out.print("Enter student ID to delete: ");
     int id = scanner.nextInt();
     scanner.nextLine(); 

     if (students.removeIf(student -> student.getId() == id)) {
         System.out.println("Student with ID " + id + " deleted. 🗑️");
     } else {
         System.out.println("Student with ID " + id + " not found.");
     }
 }
}
