package gui;

import model.User;
import service.AuthService;
import service.RideService;
import service.TransactionService;

public class MainMenuForm extends javax.swing.JFrame {

    private final AuthService authService;
    private final RideService rideService;
    private final TransactionService transactionService;
    private User currentUser;

    public MainMenuForm(AuthService authService, RideService rideService, TransactionService transactionService, User user) {
        this.authService = authService;
        this.rideService = rideService;
        this.transactionService = transactionService;
        this.currentUser = user;
        initComponents();
        styleButtons();
        refreshUserInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        saldoLabel = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        goRideButton = new javax.swing.JButton();
        goCarButton = new javax.swing.JButton();
        topUpButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gojek App - Main Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        contentPanel.setBackground(new java.awt.Color(240, 253, 244));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contentPanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setOpaque(false);
        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.Y_AXIS));

        welcomeLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(22, 163, 74));
        welcomeLabel.setText("Halo, User!");
        headerPanel.add(welcomeLabel);

        saldoLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        saldoLabel.setForeground(new java.awt.Color(30, 64, 175));
        saldoLabel.setText("Saldo: Rp0,00");
        headerPanel.add(saldoLabel);

        contentPanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        menuPanel.setBackground(new java.awt.Color(240, 253, 244));
        menuPanel.setLayout(new java.awt.GridLayout(3, 2, 20, 20));

        goRideButton.setBackground(new java.awt.Color(16, 185, 129));
        goRideButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        goRideButton.setForeground(new java.awt.Color(255, 255, 255));
        goRideButton.setText("GoRide");
        goRideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goRideButtonActionPerformed(evt);
            }
        });
        menuPanel.add(goRideButton);

        goCarButton.setBackground(new java.awt.Color(59, 130, 246));
        goCarButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        goCarButton.setForeground(new java.awt.Color(255, 255, 255));
        goCarButton.setText("GoCar");
        goCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goCarButtonActionPerformed(evt);
            }
        });
        menuPanel.add(goCarButton);

        topUpButton.setBackground(new java.awt.Color(245, 158, 11));
        topUpButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        topUpButton.setForeground(new java.awt.Color(255, 255, 255));
        topUpButton.setText("Top Up");
        topUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topUpButtonActionPerformed(evt);
            }
        });
        menuPanel.add(topUpButton);

        historyButton.setBackground(new java.awt.Color(59, 130, 246));
        historyButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        historyButton.setForeground(new java.awt.Color(255, 255, 255));
        historyButton.setText("Riwayat");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });
        menuPanel.add(historyButton);

        logoutButton.setBackground(new java.awt.Color(220, 76, 100));
        logoutButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Keluar");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        menuPanel.add(logoutButton);

        contentPanel.add(menuPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void styleButtons() {
        ButtonStyler.applySolid(goRideButton, new java.awt.Color(16, 185, 129), java.awt.Color.WHITE);
        ButtonStyler.applySolid(goCarButton, new java.awt.Color(59, 130, 246), java.awt.Color.WHITE);
        ButtonStyler.applySolid(topUpButton, new java.awt.Color(245, 158, 11), java.awt.Color.WHITE);
        ButtonStyler.applySolid(historyButton, new java.awt.Color(59, 130, 246), java.awt.Color.WHITE);
        ButtonStyler.applySolid(logoutButton, new java.awt.Color(220, 76, 100), java.awt.Color.WHITE);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        refreshUserInfo();
    }

    private void goRideButtonActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            GoRideFrame goRideFrame = new GoRideFrame(authService, rideService, transactionService, currentUser);
            goRideFrame.setVisible(true);
        });
        dispose();
    }

    private void goCarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            GoCarFrame goCarFrame = new GoCarFrame(authService, rideService, transactionService, currentUser);
            goCarFrame.setVisible(true);
        });
        dispose();
    }

    private void topUpButtonActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            TopUpFrame topUpFrame = new TopUpFrame(authService, rideService, transactionService, currentUser);
            topUpFrame.setVisible(true);
        });
        dispose();
    }

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            HistoryFrame historyFrame = new HistoryFrame(authService, rideService, transactionService, currentUser);
            historyFrame.setVisible(true);
        });
        dispose();
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(authService, rideService, transactionService);
            loginFrame.setVisible(true);
        });
        dispose();
    }

    private void refreshUserInfo() {
        welcomeLabel.setText("Halo, " + currentUser.getUsername() + "!");
        saldoLabel.setText(String.format("Saldo: Rp%,.2f", currentUser.getSaldo()));
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        refreshUserInfo();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton goRideButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton historyButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JButton topUpButton;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JButton goCarButton;
    // End of variables declaration                   
}
