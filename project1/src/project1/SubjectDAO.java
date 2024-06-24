package project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDAO {

    // Method to add a new subject
    public void addSubject(String subjectName) throws SQLException {
        String sql = "INSERT INTO Subjects (subject_name) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, subjectName);
            stmt.executeUpdate();
            System.out.println("Subject added successfully.");
        }
    }

    // Method to display all subjects
    public void displayAllSubjects() throws SQLException {
        String sql = "SELECT * FROM Subjects";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Subjects:");
            while (rs.next()) {
                System.out.println("Subject ID: " + rs.getInt("subject_id"));
                System.out.println("Subject Name: " + rs.getString("subject_name"));
                System.out.println("--------------------");
            }
        }
    }

    // Method to update subject name by subject ID
    public void updateSubject(int subjectId, String newSubjectName) throws SQLException {
        String sql = "UPDATE Subjects SET subject_name = ? WHERE subject_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newSubjectName);
            stmt.setInt(2, subjectId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Subject updated successfully.");
            } else {
                System.out.println("No subject found with ID " + subjectId);
            }
        }
    }

    // Method to delete a subject by subject ID
    public void deleteSubject(int subjectId) throws SQLException {
        String sql = "DELETE FROM Subjects WHERE subject_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, subjectId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Subject deleted successfully.");
            } else {
                System.out.println("No subject found with ID " + subjectId);
            }
        }
    }
}

