package StudentSorting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // hämta singleton HashMap
        StudentManager manager = StudentManager.getInstance();


        // to do

        // Vad ska jag ha i Student klassen?
        // vad fyller den för funktion...?
        // Och hur sparar jag så att all information inte går
        // förlorad om jag vill lägga till en ny student
        // Lägga till betyg till alla elever

        Scanner scan = new Scanner(System.in);
        boolean running = true;

        try {
            while (running) {
                System.out.println("What would you like to do? ");
                System.out.println("1. Add student");
                System.out.println("2. Remove student");
                System.out.println("3. Add student grade");
                System.out.println("4. View student/students");
                System.out.println("5. Exit");

                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                        // funkar
                        // ska jag lägga till funktion att spara i .txt
                        // längre än vad programmet körs bara...?
                    case 1:
                        // Add a student

                        System.out.println("Adding student...");
                        System.out.println("Enter student name: ");
                        String name = scan.nextLine();

                        System.out.println("Assign student ID: ");
                        int id = scan.nextInt();

                        manager.addStudent(id, name);

                        manager.writeStudentsToFile();

                        break;


                    case 2:
                        // remove a student
                        // den ska funka nu!!
                        // nu tar den bara precis bort den som matchar med

                        System.out.println("Removing student...");
                        System.out.println("To remove a student, please enter student ID: ");

                        int removeId = scan.nextInt();

                        System.out.println("Removing student with ID: " + removeId);
                        manager.removeStudent(removeId);

                        manager.writeStudentsToFile();

                        break;


                        // den här är långt ifrån klar...
                    // vad fan ska jag göra här...
                    case 3:
                        // Adding a grade to existing student

                        System.out.println("Adding student grade...");
                        System.out.println("Enter student ID: ");

                        int grade = scan.nextInt();

                        // Och nu lägga till ett betyg också...

                        // to do
                        // lägga till funktion för att lägga till betyg

                        break;

                    case 4:
                        // View student information

                        System.out.println("View student information." +
                                "Which student would you like to view?: ");
                        System.out.println("1. A specific student, sorted by ID");
                        System.out.println("2. All students");

                        int viewInfo = scan.nextInt();

                        if(viewInfo == 1) {
                            // så vill jag bara visa en student

                            System.out.println("Which student would you like to view? Enter student ID: ");
                            int viewId = scan.nextInt();

                            System.out.println(manager.getStudent(viewId));
                            // nu får jag iallafall ut namnet på den student vars ID matchar input

                            // ska se hur jag gör med grade + id sen också

                        } else if (viewInfo == 2) {
                           // kalla på alla studenter
                            manager.readStudentsFromFile();

                        } else {
                            System.out.println("Invalid choice, try again.");
                        }

                        break;

                        // funkar
                    case 5:

                        System.out.println("Goodbye!");

                        running = false;

                        break;

                        // funkar
                    default:
                        System.out.println("Invalid choice, try again.");


                }


            }

        } catch (Exception e) {
            System.out.println("Invalid input. Check your uppgifter and try again");
        }



//        System.out.println("Add new name: ");
//        String name = scan.nextLine();
//
//        System.out.println("Assign new number ID: ");
//        int id = scan.nextInt();
//
//        manager.addStudent(id, name);
//
//        System.out.println("Wich student? Insert ID:");
//        int theID = scan.nextInt();
//
//        System.out.println(manager.getStudent(theID));







    }
}
