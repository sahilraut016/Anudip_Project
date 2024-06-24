package project1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO {

    // Method to add a new result
    public void addResult(int studentId, int subjectId, int marks) throws SQLException {
        String sql = "INSERT INTO Results (student_id, subject_id, marks) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, subjectId);
            stmt.setInt(3, marks);
            stmt.executeUpdate();
            System.out.println("Result added successfully.");
        }
    }

    // Method to display all results
    public void displayAllResults() throws SQLException {
        String sql = "SELECT * FROM Results";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Results:");
            while (rs.next()) {
                System.out.println("Result ID: " + rs.getInt("result_id"));
                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Subject ID: " + rs.getInt("subject_id"));
                System.out.println("Marks: " + rs.getInt("marks"));
                System.out.println("--------------------");
            }
        }
    }

    // Method to update result by result ID
    public void updateResult(int resultId, int newMarks) throws SQLException {
        String sql = "UPDATE Results SET marks = ? WHERE result_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newMarks);
            stmt.setInt(2, resultId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Result updated successfully.");
            } else {
                System.out.println("No result found with ID " + resultId);
            }
        }
    }

    // Method to delete a result by result ID
    public void deleteResult(int resultId) throws SQLException {
        String sql = "DELETE FROM Results WHERE result_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, resultId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Result deleted successfully.");
            } else {
                System.out.println("No result found with ID " + resultId);
            }
        }
    }
}
