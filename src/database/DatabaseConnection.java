package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gojek_app?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final String INIT_SQL = "CREATE TABLE IF NOT EXISTS users (" +
            "id INT PRIMARY KEY AUTO_INCREMENT," +
            "username VARCHAR(50) UNIQUE NOT NULL," +
            "email VARCHAR(100) UNIQUE NOT NULL," +
            "password VARCHAR(255) NOT NULL," +
            "saldo DECIMAL(10,2) DEFAULT 0.00," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
            ");" +
            "CREATE TABLE IF NOT EXISTS transactions (" +
            "id INT PRIMARY KEY AUTO_INCREMENT," +
            "user_id INT," +
            "pickup_location VARCHAR(255)," +
            "destination VARCHAR(255)," +
            "vehicle_type VARCHAR(20) DEFAULT 'GoRide'," +
            "fare DECIMAL(10,2)," +
            "status ENUM('pending','completed','cancelled') DEFAULT 'pending'," +
            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
            "FOREIGN KEY (user_id) REFERENCES users(id)" +
            ");" +
            "ALTER TABLE transactions ADD COLUMN IF NOT EXISTS vehicle_type VARCHAR(20) DEFAULT 'GoRide' AFTER destination;" +
            "UPDATE transactions SET vehicle_type = COALESCE(vehicle_type, 'GoRide');" +
            "INSERT INTO users (username, email, password, saldo) " +
            "SELECT 'demo_user', 'demo@example.com', 'password123', 150000.00 " +
            "WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'demo_user');" +
            "INSERT INTO transactions (user_id, pickup_location, destination, vehicle_type, fare, status) " +
            "SELECT id, 'Jl. Merdeka No.1', 'Mall Grand Indonesia', 'GoRide', 25000.00, 'completed' FROM users WHERE username = 'demo_user' " +
            "AND NOT EXISTS (SELECT 1 FROM transactions WHERE pickup_location = 'Jl. Merdeka No.1' AND destination = 'Mall Grand Indonesia');" +
            "INSERT INTO transactions (user_id, pickup_location, destination, vehicle_type, fare, status) " +
            "SELECT id, 'Kantor Pusat', 'Bandara Soekarno-Hatta', 'GoCar', 120000.00, 'completed' FROM users WHERE username = 'demo_user' " +
            "AND NOT EXISTS (SELECT 1 FROM transactions WHERE pickup_location = 'Kantor Pusat' AND destination = 'Bandara Soekarno-Hatta');";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            for (String sql : INIT_SQL.split(";")) {
                String trimmed = sql.trim();
                if (!trimmed.isEmpty()) {
                    stmt.execute(trimmed);
                }
            }
            return true;
        } catch (SQLException e) {
            System.err.println("Gagal inisialisasi database: " + e.getMessage());
            return false;
        }
    }

    public static boolean testConnection() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("SELECT 1");
            return true;
        } catch (SQLException e) {
            System.err.println("Koneksi database gagal: " + e.getMessage());
            return false;
        }
    }
}
