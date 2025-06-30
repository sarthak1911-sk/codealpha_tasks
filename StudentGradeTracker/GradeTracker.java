import java.util.ArrayList;

public class GradeTracker {
  private ArrayList<Student> students;

  public GradeTracker() {
    students = new ArrayList<>();
  }

  public void addStudent(Student s) {
    students.add(s);
  }

  public Student searchStudent(String name) {
    for (Student s : students) {
      if (s.getName().equalsIgnoreCase(name)) {
        return s;
      }
    }
    return null;
  }

  public void displayAllStudents() {
    System.out.println("\n--- All Students Report ---");
    for (Student s : students) {
      displayStudentReport(s);
    }
  }

  public void displayStudentReport(Student s) {
    System.out.println("Name       : " + s.getName());
    System.out.println("Grades     : " + s.getGrades());
    System.out.printf("Average    : %.2f\n", s.getAverage());
    System.out.println("Highest    : " + s.getHighest());
    System.out.println("Lowest     : " + s.getLowest());
    System.out.println("Grade      : " + s.getGradeCategory());
    System.out.println("----------------------------");
  }

  public void showClassStatistics() {
    if (students.isEmpty()) {
      System.out.println("No students added yet.");
      return;
    }

    double total = 0;
    Student top = students.get(0);
    Student low = students.get(0);

    for (Student s : students) {
      double avg = s.getAverage();
      total += avg;
      if (avg > top.getAverage())
        top = s;
      if (avg < low.getAverage())
        low = s;
    }

    System.out.println("\n--- Class Statistics ---");
    System.out.printf("Class Average : %.2f\n", total / students.size());
    System.out.println("Top Performer : " + top.getName() + " (" + top.getAverage() + ")");
    System.out.println("Lowest Scorer : " + low.getName() + " (" + low.getAverage() + ")");
    System.out.println("-------------------------");
  }
}
