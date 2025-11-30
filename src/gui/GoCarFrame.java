package gui;

import java.awt.Dimension;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import model.Car;
import model.Transaction;
import model.User;
import model.Vehicle;
import service.AuthService;
import service.RideService;
import service.TransactionService;

public class GoCarFrame extends javax.swing.JFrame {

    private final AuthService authService;
    private final RideService rideService;
    private final TransactionService transactionService;
    private final User currentUser;

    public GoCarFrame(AuthService authService, RideService rideService, TransactionService transactionService, User currentUser) {
        this.authService = authService;
        this.rideService = rideService;
        this.transactionService = transactionService;
        this.currentUser = currentUser;
        initComponents();
        styleButtons();
        setupEnterKeyActions();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        pickupLabel = new javax.swing.JLabel();
        pickupField = new javax.swing.JTextField();
        destinationLabel = new javax.swing.JLabel();
        destinationField = new javax.swing.JTextField();
        vehicleNoteLabel = new javax.swing.JLabel();
        distanceLabel = new javax.swing.JLabel();
        distanceField = new javax.swing.JTextField();
        fareLabel = new javax.swing.JLabel();
        estimateButton = new javax.swing.JButton();
        orderButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gojek App - GoCar");
        setResizable(false);

        contentPanel.setBackground(new java.awt.Color(239, 246, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contentPanel.setLayout(new java.awt.BorderLayout());

        headerLabel.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(14, 165, 233));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Pesan GoCar (Mobil)");
        contentPanel.add(headerLabel, java.awt.BorderLayout.NORTH);

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(125, 211, 252)),
            javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25)));
        formPanel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints;

        pickupLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pickupLabel.setForeground(new java.awt.Color(30, 64, 175));
        pickupLabel.setText("Pickup");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(pickupLabel, gridBagConstraints);

        pickupField.setColumns(25);
        pickupField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 219, 254)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        gridBagConstraints.weightx = 1.0;
        formPanel.add(pickupField, gridBagConstraints);

        destinationLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        destinationLabel.setForeground(new java.awt.Color(30, 64, 175));
        destinationLabel.setText("Tujuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(destinationLabel, gridBagConstraints);

        destinationField.setColumns(25);
        destinationField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 219, 254)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        gridBagConstraints.weightx = 1.0;
        formPanel.add(destinationField, gridBagConstraints);

        vehicleNoteLabel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        vehicleNoteLabel.setForeground(new java.awt.Color(37, 99, 235));
        vehicleNoteLabel.setText("Kendaraan: Mobil nyaman (maks 4 penumpang)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formPanel.add(vehicleNoteLabel, gridBagConstraints);

        distanceLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        distanceLabel.setForeground(new java.awt.Color(30, 64, 175));
        distanceLabel.setText("Jarak (km)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(distanceLabel, gridBagConstraints);

        distanceField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 219, 254)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        gridBagConstraints.weightx = 1.0;
        formPanel.add(distanceField, gridBagConstraints);

        fareLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        fareLabel.setForeground(new java.awt.Color(37, 99, 235));
        fareLabel.setText("Estimasi Tarif: Rp0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        formPanel.add(fareLabel, gridBagConstraints);

        estimateButton.setBackground(new java.awt.Color(59, 130, 246));
        estimateButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        estimateButton.setForeground(new java.awt.Color(255, 255, 255));
        estimateButton.setText("Hitung Tarif");
        estimateButton.setFocusPainted(false);
        estimateButton.setPreferredSize(new java.awt.Dimension(180, 36));
        estimateButton.setMaximumSize(new java.awt.Dimension(220, 36));
        estimateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estimateButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        formPanel.add(estimateButton, gridBagConstraints);

        orderButton.setBackground(new java.awt.Color(59, 130, 246));
        orderButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        orderButton.setForeground(new java.awt.Color(255, 255, 255));
        orderButton.setText("Pesan Sekarang");
        orderButton.setFocusPainted(false);
        orderButton.setPreferredSize(new java.awt.Dimension(180, 36));
        orderButton.setMaximumSize(new java.awt.Dimension(220, 36));
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        formPanel.add(orderButton, gridBagConstraints);

        backButton.setBackground(new java.awt.Color(224, 242, 254));
        backButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(59, 130, 246));
        backButton.setText("Kembali");
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new java.awt.Dimension(180, 30));
        backButton.setMaximumSize(new java.awt.Dimension(220, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        formPanel.add(backButton, gridBagConstraints);

        contentPanel.add(formPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void styleButtons() {
        ButtonStyler.applySolid(estimateButton, new java.awt.Color(59, 130, 246), java.awt.Color.WHITE);
        ButtonStyler.applySolid(orderButton, new java.awt.Color(59, 130, 246), java.awt.Color.WHITE);
        ButtonStyler.applySoft(backButton, new java.awt.Color(224, 242, 254), new java.awt.Color(59, 130, 246), new java.awt.Color(191, 219, 254));
        estimateButton.setIcon(UITheme.carIcon());
        orderButton.setIcon(UITheme.carIcon());
        estimateButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        orderButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        estimateButton.setIconTextGap(8);
        orderButton.setIconTextGap(8);
    }

    private void setupEnterKeyActions() {
        getRootPane().setDefaultButton(orderButton);

        distanceField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "calc-fare");
        distanceField.getActionMap().put("calc-fare", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                calculateFare();
            }
        });

        pickupField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "focus-destination");
        pickupField.getActionMap().put("focus-destination", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                destinationField.requestFocusInWindow();
            }
        });

        destinationField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "focus-distance");
        destinationField.getActionMap().put("focus-distance", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                distanceField.requestFocusInWindow();
            }
        });
    }

    private void estimateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        calculateFare();
    }

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        placeOrder();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        openMainMenu();
    }

    private Vehicle getSelectedVehicle() {
        return new Car();
    }

    private void calculateFare() {
        try {
            double distance = Double.parseDouble(distanceField.getText().trim());
            if (distance <= 0) {
                throw new NumberFormatException();
            }
            Vehicle vehicle = getSelectedVehicle();
            double fare = rideService.estimateFare(vehicle, distance);
            fareLabel.setText("Estimasi Tarif: Rp" + String.format("%,.2f", fare));
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Masukkan jarak yang valid.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }

    private void placeOrder() {
        String pickup = pickupField.getText().trim();
        String destination = destinationField.getText().trim();
        String distanceText = distanceField.getText().trim();

        if (pickup.isEmpty() || destination.isEmpty() || distanceText.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Mohon isi semua field.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        double distance;
        try {
            distance = Double.parseDouble(distanceText);
            if (distance <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Masukkan jarak yang valid.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vehicle vehicle = getSelectedVehicle();
        double fare = rideService.estimateFare(vehicle, distance);

        if (!rideService.canAffordRide(currentUser, fare)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Saldo tidak cukup untuk GoCar.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmation = javax.swing.JOptionPane.showConfirmDialog(this,
                "Total tarif GoCar: Rp" + String.format("%,.2f", fare) + "\nKonfirmasi pemesanan?",
                "Konfirmasi",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmation == javax.swing.JOptionPane.YES_OPTION) {
            Transaction transaction = new Transaction();
            transaction.setUserId(currentUser.getId());
            transaction.setPickupLocation(pickup);
            transaction.setDestination(destination);
            transaction.setVehicleType("GoCar");
            transaction.setFare(fare);
            transaction.setStatus("completed");

            boolean success = transactionService.createTransaction(transaction);
            if (success) {
                double newSaldo = currentUser.getSaldo() - fare;
                authService.updateSaldo(currentUser.getId(), newSaldo);
                currentUser.setSaldo(newSaldo);
                javax.swing.JOptionPane.showMessageDialog(this, "Pemesanan GoCar berhasil!", "Informasi", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                openMainMenuWithRefresh();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan transaksi.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void openMainMenu() {
        java.awt.EventQueue.invokeLater(() -> {
            MainMenuFrame mainMenuFrame = new MainMenuFrame(authService, rideService, transactionService, currentUser);
            mainMenuFrame.setVisible(true);
        });
        dispose();
    }

    private void openMainMenuWithRefresh() {
        java.awt.EventQueue.invokeLater(() -> {
            User refreshedUser = authService.getUserById(currentUser.getId());
            MainMenuFrame mainMenuFrame = new MainMenuFrame(authService, rideService, transactionService, refreshedUser);
            mainMenuFrame.setVisible(true);
        });
        dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton backButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTextField destinationField;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JTextField distanceField;
    private javax.swing.JLabel distanceLabel;
    private javax.swing.JButton estimateButton;
    private javax.swing.JLabel fareLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton orderButton;
    private javax.swing.JTextField pickupField;
    private javax.swing.JLabel pickupLabel;
    private javax.swing.JLabel vehicleNoteLabel;
    // End of variables declaration                   
}
