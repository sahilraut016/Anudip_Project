package project1;



import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        ResultDAO resultDAO = new ResultDAO();

        try {
            while (true) {
                System.out.println("=== Students Result Management System ===");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Add Subject");
                System.out.println("6. Display All Subjects");
                System.out.println("7. Update Subject");
                System.out.println("8. Delete Subject");
                System.out.println("9. Add Result");
                System.out.println("10. Display All Results");
                System.out.println("11. Update Result");
                System.out.println("12. Delete Result");
                System.out.println("13. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addStudent(studentDAO);
                        break;
                    case 2:
                        displayAllStudents(studentDAO);
                        break;
                    case 3:
                        updateStudent(studentDAO);
                        break;
                    case 4:
                        deleteStudent(studentDAO);
                        break;
                    case 5:
                        addSubject(subjectDAO);
                        break;
                    case 6:
                        displayAllSubjects(subjectDAO);
                        break;
                    case 7:
                        updateSubject(subjectDAO);
                        break;
                    case 8:
                        deleteSubject(subjectDAO);
                        break;
                    case 9:
                        addResult(resultDAO);
                        break;
                    case 10:
                        displayAllResults(resultDAO);
                        break;
                    case 11:
                        updateResult(resultDAO);
                        break;
                    case 12:
                        deleteResult(resultDAO);
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void addStudent(StudentDAO studentDAO) throws SQLException {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        studentDAO.addStudent(studentName, age);
    }

    private static void displayAllStudents(StudentDAO studentDAO) throws SQLException {
        studentDAO.displayAllStudents();
    }

    private static void updateStudent(StudentDAO studentDAO) throws SQLException {
        System.out.print("Enter student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new student name: ");
        String newStudentName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        studentDAO.updateStudent(studentId, newStudentName, newAge);
    }

    private static void deleteStudent(StudentDAO studentDAO) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        studentDAO.deleteStudent(studentId);
    }

    private static void addSubject(SubjectDAO subjectDAO) throws SQLException {
        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();
        subjectDAO.addSubject(subjectName);
    }

    private static void displayAllSubjects(SubjectDAO subjectDAO) throws SQLException {
        subjectDAO.displayAllSubjects();
    }

    private static void updateSubject(SubjectDAO subjectDAO) throws SQLException {
        System.out.print("Enter subject ID to update: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new subject name: ");
        String newSubjectName = scanner.nextLine();
        subjectDAO.updateSubject(subjectId, newSubjectName);
    }

    private static void deleteSubject(SubjectDAO subjectDAO) throws SQLException {
        System.out.print("Enter subject ID to delete: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        subjectDAO.deleteSubject(subjectId);
    }

    private static void addResult(ResultDAO resultDAO) throws SQLException {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter subject ID: ");
        int subjectId = scanner.nextInt();
        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        resultDAO.addResult(studentId, subjectId, marks);
    }

    private static void displayAllResults(ResultDAO resultDAO) throws SQLException {
        resultDAO.displayAllResults();
    }

    private static void updateResult(ResultDAO resultDAO) throws SQLException {
        System.out.print("Enter result ID to update: ");
        int resultId = scanner.nextInt();
        System.out.print("Enter new marks: ");
        int newMarks = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        resultDAO.updateResult(resultId, newMarks);
    }

    private static void deleteResult(ResultDAO resultDAO) throws SQLException {
        System.out.print("Enter result ID to delete: ");
        int resultId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        resultDAO.deleteResult(resultId);
    }
}

