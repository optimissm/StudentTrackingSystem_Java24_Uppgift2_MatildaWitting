package StudentSorting;


// håller attribut som
// ID
// namn
// betyg
public class Student {

   private int studentID;
   private String studentName;
   private double studentGrade;

   public Student(int studentID, String studentName, double studentGrade) {
       this.studentID = studentID;
       this.studentName = studentName;
       this.studentGrade = studentGrade;
   }

   @Override
    public String toString() {
       return "ID: " + studentID + ", Name: " + studentName + ", Grade: " + studentGrade + "\n";
   }





}
