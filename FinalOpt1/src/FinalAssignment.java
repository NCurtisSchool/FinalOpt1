/*
Name: Nathan Curtis
Date: 11/31/2024
Class: Computer Programming II 24FD-CSC372-1
Teacher: Luis Gonzalez
Assignment: Programming II Final Option 1
GitHub: https://github.com/NCurtisSchool/FinalOpt1.git
*/

//Imports
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.Scanner;

public class FinalAssignment {
    public static void main(String[] args) throws Exception {
        // Add linked list
        LinkedList<Students> studentList = new LinkedList<>();

        // Scanner
        Scanner userInput = new Scanner(System.in);
        int choice;

        while (true) { 
            System.out.println("1 - Add Student Info");
            System.out.println("2 - Print Student Info");
            System.out.println("3 - Exit");

            System.out.print("Enter choice: ");
            choice = userInput.nextInt();
            userInput.nextLine(); // Consuming \n

            switch (choice) {
                case 1: // Add Student info to studentList
                    AddStudentInfo(userInput, studentList);
                    break;
                case 2: // Sort then Print Info to document
                    sortStudentList(studentList);
                    printInfo(studentList);
                    break;
                case 3: // Exit
                    userInput.close();
                    System.out.println("Exiting program");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice. Retry.");
            }
        }
    }

    private static LinkedList<Students> AddStudentInfo(Scanner userInput, LinkedList<Students> studentList) {
        try {
            //Get student info
            System.out.print("Student Name: ");
            String name = userInput.nextLine();
            System.out.print("Student GPA: ");
            double gpa = userInput.nextDouble();
            userInput.nextLine(); // Consuming \n
            System.out.print("Student Address: ");
            String address = userInput.nextLine();

            //Create object
            Students student = new Students(name, address, gpa);

            // Add object to studentList
            studentList.addLast(student);

            // Print Success Statement
            System.out.println("Student info added");

            // Return studentList
            return(studentList);
        } catch (Exception e) {
            // Print Failure Statement
            System.out.println("Failed to add student info.");
            return(studentList);
        }
    }

    private static void sortStudentList(LinkedList<Students> studentList) {
        try {
            // Sort studentList
            // Find length
            
            studentList.sort( (a,b) -> {return 1 * a.getName().compareTo(b.getName());});

        } catch (Exception e) {
            // Print Failure Statment
            System.out.println("Failed to sort info.");
        }
    }

    private static void printInfo(LinkedList<Students> studentList) {
        try {
            String uploadString = "";
            // Path to file
            Path textPath = Paths.get("Student Info.txt");

            // Create file if it does not exist
            if (!Files.exists(textPath)) {
                Files.createFile(textPath);
            }

            // Loop to add to file            
            for (int i = 0; i < studentList.size(); i++) {
                // String uploaded
                uploadString = uploadString + studentList.get(i).toString() + "\n";
            }

            // Save to file
            Files.write(textPath, uploadString.getBytes(StandardCharsets.UTF_8));

            // Print Success Statment
            System.out.println("Info printed.");
        } catch (Exception e) {
            // Print Failure Statment
            System.out.println("Failed to print info.");
        }
    }
}
