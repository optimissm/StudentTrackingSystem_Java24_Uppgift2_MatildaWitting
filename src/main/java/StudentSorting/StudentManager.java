package StudentSorting;

import java.io.*;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StudentManager {

    private static volatile StudentManager instance;
    private final ConcurrentHashMap<Integer, String> listStudent;
    private final String studentList = "ListStudent.txt";

    // private constructor av sig själv...?
    private StudentManager() {
        listStudent = new ConcurrentHashMap<>();

    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }

        return instance;
    }

    // testar putifabsent ist för bara put
    // använder den iaf för då lägger den inte till en med samma id
    public synchronized void addStudent(int id, String name) {
        listStudent.putIfAbsent(id, name);
        saveToFile();


    }

    public synchronized void removeStudent(int id) {

        if (listStudent.containsKey(id)) {
            listStudent.remove(id);

            // uppdaterar listan så att de som ska vara kvar är kvar
            // writeStudentsToFile();

        } else {
            System.out.println("Student ID not found");
        }
    }

    public synchronized void addGrade(double grade) {
        if (listStudent.containsKey(grade)) {

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

    public synchronized void saveToFile() {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(studentList))) {
            for (var entry : listStudent.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // fick inte rätt på att spara redan inskrivna studenter än där
    // om jag startar om programmet och lägger till fler så nollställs alla
    // tidigare studenter...
//    public synchronized void loadFromFile() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("ListOfStudents.txt"))){
//            String line;
//
//            while ((line = reader.readLine()) != null){
//                String[] parts = line.split(",", 2) ;
//                if(parts.length == 2){
//                    int id = Integer.parseInt(parts[0]);
//                    String name = parts[1];
//                    listStudent.put(id, name);
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
