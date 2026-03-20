package clinic.db;
import java.sql.*;

public class DatabaseManager {
    private static final String URL  = "jdbc:mysql://localhost:3306/clinic_db?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "123konKL"; 

    public static void saveResult(String patientId, String status) {
        String sql = "INSERT INTO screening_results (patient_id, result_status) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, patientId);
            pstmt.setString(2, status);
            pstmt.executeUpdate();
            
            System.out.println("✅ DATABASE SUCCESS -> Result saved for " + patientId);
            
        } catch (SQLException e) {
           
            System.err.println("❌ DB ERROR: " + e.getMessage());
        }
    }
}