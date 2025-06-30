import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GradeTracker tracker = new GradeTracker();
    int choice;

    do {
      System.out.println("\n======= STUDENT GRADE TRACKER =======");
      System.out.println("1. Add Student");
      System.out.println("2. View All Students");
      System.out.println("3. Search Student");
      System.out.println("4. Class Statistics");
      System.out.println("5. Exit");
      System.out.print("Choose an option: ");
      while (!sc.hasNextInt()) {
        System.out.print("Please enter a number: ");
        sc.next();
      }
      choice = sc.nextInt();
      sc.nextLine(); // consume newline

      switch (choice) {
        case 1:
          System.out.print("Enter student name: ");
          String name = sc.nextLine();
          Student student = new Student(name);

          System.out.print("How many grades to enter? ");
          int count = sc.nextInt();
          System.out.println("Enter " + count + " grades (0-100):");
          for (int i = 0; i < count; i++) {
            int grade;
            while (true) {
              grade = sc.nextInt();
              if (grade >= 0 && grade <= 100)
                break;
              System.out.print("Invalid! Enter grade between 0-100: ");
            }
            student.addGrade(grade);
          }
          tracker.addStudent(student);
          System.out.println("Student added successfully!");
          break;

        case 2:
          tracker.displayAllStudents();
          break;

        case 3:
          System.out.print("Enter student name to search: ");
          String searchName = sc.nextLine();
          Student found = tracker.searchStudent(searchName);
          if (found != null) {
            tracker.displayStudentReport(found);
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 4:
          tracker.showClassStatistics();
          break;

        case 5:
          System.out.println("Exiting... Thank you!");
          break;

        default:
          System.out.println("Invalid choice. Try again.");
      }

    } while (choice != 5);

    sc.close();
  }
}
