import database.DatabaseConnection;
import gui.LoginFrame;
import service.AuthService;
import service.RideService;
import service.TransactionService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        setupLookAndFeel();
        if (!DatabaseConnection.initializeDatabase() || !DatabaseConnection.testConnection()) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Koneksi database gagal. Pastikan MySQL berjalan dan kredensial benar.",
                    "Koneksi Gagal",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingUtilities.invokeLater(() -> {
            AuthService authService = new AuthService();
            RideService rideService = new RideService();
            TransactionService transactionService = new TransactionService();

            LoginFrame loginFrame = new LoginFrame(authService, rideService, transactionService);
            loginFrame.setVisible(true);
        });
    }

    private static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println("Tidak dapat menginisialisasi tampilan sistem. Menggunakan tampilan default.");
        }
    }
}
