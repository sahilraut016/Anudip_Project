package project1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // Method to add a new student
    public void addStudent(String studentName, int age) throws SQLException {
        String sql = "INSERT INTO Students (student_name, age) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentName);
            stmt.setInt(2, age);
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }

    // Method to display all students
    public void displayAllStudents() throws SQLException {
        String sql = "SELECT * FROM Students";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Students:");
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Student Name: " + rs.getString("student_name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("--------------------");
            }
        }
    }

    // Method to update student information by student ID
    public void updateStudent(int studentId, String newStudentName, int newAge) throws SQLException {
        String sql = "UPDATE Students SET student_name = ?, age = ? WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newStudentName);
            stmt.setInt(2, newAge);
            stmt.setInt(3, studentId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with ID " + studentId);
            }
        }
    }

    // Method to delete a student by student ID
    public void deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM Students WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with ID " + studentId);
            }
        }
    }
}

