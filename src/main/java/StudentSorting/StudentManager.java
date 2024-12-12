package StudentSorting;

import java.io.*;
import java.util.HashMap;

public class StudentManager {

    private static volatile StudentManager instance;
    private HashMap<Integer, String> listStudent;

    // private constructor av sig själv...?
    private StudentManager() {
        listStudent = new HashMap<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }

        return instance;
    }

    public synchronized void addStudent(int id, String name) {
        listStudent.put(id, name);
    }

    public synchronized void removeStudent(int id) {
        // listStudent.remove(id);
        if (listStudent.containsKey(id)) {
            listStudent.remove(id);

            // uppdaterar listan så att de som ska vara kvar är kvar
            // writeStudentsToFile();

        } else {
            System.out.println("Student ID not found");
        }
    }

    public String getStudent(int id) {
        return listStudent.get(id);
    }

    public static String getAllStudents() {
        return getInstance().listStudent.toString();
    }

    // för att få in input till lista
    // syncronized metod för att säkerställa trådsäkerhet
    // så kan jag använda hela BufferedWriter här istället för i main
    public synchronized void writeStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ListOfStudents.txt"))) {
            writer.write("List of students:\n");
            for (HashMap.Entry<Integer, String> entry : listStudent.entrySet()) {

                writer.write("Student ID: " + entry.getKey() + ", Name: "
                        + entry.getValue() + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void removeStudentsFromFile() {
//        try {
//            if (listStudent.containsKey(id)) {
//                listStudent.remove(id);
//
//                // uppdaterar listan så att de som ska vara kvar är kvar
//                writeStudentsToFile();
//
//            } else {
//                System.out.println("Student ID not found");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    // för att skriva ut alla studenter
    public synchronized void readStudentsFromFile() {
        try {
            // skapar möjligheten att printa ut/läsa filerna
            BufferedReader reader = new BufferedReader(new FileReader("ListOfStudents.txt"));
            String line;
            // denna läser tills sista raden och då finns det inte mer att läsa så null
            while((line = reader.readLine()) != null) {

                System.out.println(line);

            }

                reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
