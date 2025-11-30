package service;

import database.DatabaseConnection;
import model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    public boolean createTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (user_id, pickup_location, destination, vehicle_type, fare, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getUserId());
            stmt.setString(2, transaction.getPickupLocation());
            stmt.setString(3, transaction.getDestination());
            stmt.setString(4, transaction.getVehicleType());
            stmt.setDouble(5, transaction.getFare());
            stmt.setString(6, transaction.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Transaction> getTransactionsByUser(int userId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE user_id = ? ORDER BY created_at DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                transactions.add(extractTransaction(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    private Transaction extractTransaction(ResultSet rs) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("id"));
        transaction.setUserId(rs.getInt("user_id"));
        transaction.setPickupLocation(rs.getString("pickup_location"));
        transaction.setDestination(rs.getString("destination"));
        transaction.setVehicleType(rs.getString("vehicle_type"));
        transaction.setFare(rs.getDouble("fare"));
        transaction.setStatus(rs.getString("status"));
        transaction.setCreatedAt(rs.getTimestamp("created_at"));
        return transaction;
    }
}
