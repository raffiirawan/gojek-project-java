package gui;

import model.User;
import service.AuthService;
import service.RideService;
import service.TransactionService;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MainMenuFrame extends javax.swing.JFrame {

    private final AuthService authService;
    private final RideService rideService;
    private final TransactionService transactionService;

    private User currentUser;

    public MainMenuFrame(AuthService authService, RideService rideService, TransactionService transactionService, User user) {
        this.authService = authService;
        this.rideService = rideService;
        this.transactionService = transactionService;
        this.currentUser = user;
        initComponents();
        styleButtons();
        configureKeyboardShortcuts();
        updateHeader();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        contentPanel = UITheme.createMapBackgroundPanel();
        headerPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        saldoLabel = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        goRideCard = new javax.swing.JPanel();
        goRideTitleLabel = new javax.swing.JLabel();
        goRideDescriptionLabel = new javax.swing.JLabel();
        goRideButton = new javax.swing.JButton();
        goCarCard = new javax.swing.JPanel();
        goCarTitleLabel = new javax.swing.JLabel();
        goCarDescriptionLabel = new javax.swing.JLabel();
        goCarButton = new javax.swing.JButton();
        topUpCard = new javax.swing.JPanel();
        topUpTitleLabel = new javax.swing.JLabel();
        topUpDescriptionLabel = new javax.swing.JLabel();
        topUpButton = new javax.swing.JButton();
        historyCard = new javax.swing.JPanel();
        historyTitleLabel = new javax.swing.JLabel();
        historyDescriptionLabel = new javax.swing.JLabel();
        historyButton = new javax.swing.JButton();
        logoutCard = new javax.swing.JPanel();
        logoutTitleLabel = new javax.swing.JLabel();
        logoutDescriptionLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gojek App - Main Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 32, 32));
        contentPanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 24, 0));
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.Y_AXIS));

        welcomeLabel.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 26)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(17, 24, 39));
        welcomeLabel.setText("Halo, User!");
        headerPanel.add(welcomeLabel);

        saldoLabel.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 18)); // NOI18N
        saldoLabel.setForeground(new java.awt.Color(255, 255, 255));
        saldoLabel.setText("Saldo: Rp0,00");
        saldoLabel.setOpaque(true);
        saldoLabel.setBackground(UITheme.GOJEK_GREEN);
        saldoLabel.setBorder(UITheme.roundedBorder(18, UITheme.GOJEK_GREEN.darker()));
        saldoLabel.setIcon(UITheme.rideIcon());
        saldoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        saldoLabel.setIconTextGap(10);
        headerPanel.add(saldoLabel);

        contentPanel.add(headerPanel, java.awt.BorderLayout.NORTH);

        menuPanel.setOpaque(false);
        menuPanel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints;

        goRideCard.setBackground(new java.awt.Color(255, 255, 255));
        goRideCard.setBorder(UITheme.cardBorder());
        UITheme.applyTranslucentCard(goRideCard);
        goRideCard.setLayout(new java.awt.GridBagLayout());

        goRideTitleLabel.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 18)); // NOI18N
        goRideTitleLabel.setForeground(new java.awt.Color(17, 31, 23));
        goRideTitleLabel.setText("GoRide");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        goRideCard.add(goRideTitleLabel, gridBagConstraints);

        goRideDescriptionLabel.setFont(UITheme.primaryFont(java.awt.Font.PLAIN, 13)); // NOI18N
        goRideDescriptionLabel.setForeground(new java.awt.Color(68, 64, 60));
        goRideDescriptionLabel.setText("<html><p style='width:180px;'>Pesan motor gesit untuk perjalanan pribadi yang hemat.</p></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 16, 0);
        goRideCard.add(goRideDescriptionLabel, gridBagConstraints);

        goRideButton.setBackground(new java.awt.Color(22, 163, 74));
        goRideButton.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 13)); // NOI18N
        goRideButton.setForeground(new java.awt.Color(255, 255, 255));
        goRideButton.setText("Buka");
        goRideButton.setFocusPainted(false);
        goRideButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 12, 0));
        goRideButton.setIcon(UITheme.rideIcon());
        goRideButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goRideButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        goRideButton.setIconTextGap(10);
        goRideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goRideButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        goRideCard.add(goRideButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 20);
        menuPanel.add(goRideCard, gridBagConstraints);

        goCarCard.setBackground(new java.awt.Color(255, 255, 255));
        goCarCard.setBorder(UITheme.cardBorder());
        UITheme.applyTranslucentCard(goCarCard);
        goCarCard.setLayout(new java.awt.GridBagLayout());

        goCarTitleLabel.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 18)); // NOI18N
        goCarTitleLabel.setForeground(new java.awt.Color(17, 31, 23));
        goCarTitleLabel.setText("GoCar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        goCarCard.add(goCarTitleLabel, gridBagConstraints);

        goCarDescriptionLabel.setFont(UITheme.primaryFont(java.awt.Font.PLAIN, 13)); // NOI18N
        goCarDescriptionLabel.setForeground(new java.awt.Color(68, 64, 60));
        goCarDescriptionLabel.setText("<html><p style='width:180px;'>Pesan mobil nyaman untuk perjalanan bersama teman atau keluarga.</p></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 16, 0);
        goCarCard.add(goCarDescriptionLabel, gridBagConstraints);

        goCarButton.setBackground(new java.awt.Color(59, 130, 246));
        goCarButton.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 13)); // NOI18N
        goCarButton.setForeground(new java.awt.Color(255, 255, 255));
        goCarButton.setText("Buka");
        goCarButton.setFocusPainted(false);
        goCarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 12, 0));
        goCarButton.setIcon(UITheme.carIcon());
        goCarButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        goCarButton.setIconTextGap(10);
        goCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goCarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        goCarCard.add(goCarButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        menuPanel.add(goCarCard, gridBagConstraints);

        topUpCard.setBackground(new java.awt.Color(255, 255, 255));
        topUpCard.setBorder(UITheme.cardBorder());
        UITheme.applyTranslucentCard(topUpCard);
        topUpCard.setLayout(new java.awt.GridBagLayout());

        topUpTitleLabel.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 18)); // NOI18N
        topUpTitleLabel.setForeground(new java.awt.Color(17, 31, 23));
        topUpTitleLabel.setText("Top Up");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        topUpCard.add(topUpTitleLabel, gridBagConstraints);

        topUpDescriptionLabel.setFont(UITheme.primaryFont(java.awt.Font.PLAIN, 13)); // NOI18N
        topUpDescriptionLabel.setForeground(new java.awt.Color(68, 64, 60));
        topUpDescriptionLabel.setText("<html><p style='width:180px;'>Isi saldo kamu dengan metode pembayaran favoritmu.</p></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 16, 0);
        topUpCard.add(topUpDescriptionLabel, gridBagConstraints);

        topUpButton.setBackground(new java.awt.Color(22, 163, 74));
        topUpButton.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 13)); // NOI18N
        topUpButton.setForeground(new java.awt.Color(255, 255, 255));
        topUpButton.setText("Buka");
        topUpButton.setFocusPainted(false);
        topUpButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 12, 0));
        topUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topUpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        topUpCard.add(topUpButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 20);
        menuPanel.add(topUpCard, gridBagConstraints);

        historyCard.setBackground(new java.awt.Color(255, 255, 255));
        historyCard.setBorder(UITheme.cardBorder());
        UITheme.applyTranslucentCard(historyCard);
        historyCard.setLayout(new java.awt.GridBagLayout());

        historyTitleLabel.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 18)); // NOI18N
        historyTitleLabel.setForeground(new java.awt.Color(17, 31, 23));
        historyTitleLabel.setText("Riwayat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        historyCard.add(historyTitleLabel, gridBagConstraints);

        historyDescriptionLabel.setFont(UITheme.primaryFont(java.awt.Font.PLAIN, 13)); // NOI18N
        historyDescriptionLabel.setForeground(new java.awt.Color(68, 64, 60));
        historyDescriptionLabel.setText("<html><p style='width:180px;'>Lihat riwayat perjalanan dan transaksi kamu sebelumnya.</p></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 16, 0);
        historyCard.add(historyDescriptionLabel, gridBagConstraints);

        historyButton.setBackground(new java.awt.Color(241, 102, 99));
        historyButton.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 13)); // NOI18N
        historyButton.setForeground(new java.awt.Color(255, 255, 255));
        historyButton.setText("Buka");
        historyButton.setFocusPainted(false);
        historyButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 12, 0));
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        historyCard.add(historyButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        menuPanel.add(historyCard, gridBagConstraints);

        logoutCard.setBackground(new java.awt.Color(255, 255, 255));
        logoutCard.setBorder(UITheme.cardBorder());
        UITheme.applyTranslucentCard(logoutCard);
        logoutCard.setLayout(new java.awt.GridBagLayout());

        logoutTitleLabel.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 18)); // NOI18N
        logoutTitleLabel.setForeground(new java.awt.Color(17, 31, 23));
        logoutTitleLabel.setText("Keluar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        logoutCard.add(logoutTitleLabel, gridBagConstraints);

        logoutDescriptionLabel.setFont(UITheme.primaryFont(java.awt.Font.PLAIN, 13)); // NOI18N
        logoutDescriptionLabel.setForeground(new java.awt.Color(68, 64, 60));
        logoutDescriptionLabel.setText("<html><p style='width:180px;'>Keluar dari akun dan kembali ke halaman login.</p></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 16, 0);
        logoutCard.add(logoutDescriptionLabel, gridBagConstraints);

        logoutButton.setBackground(new java.awt.Color(68, 68, 239));
        logoutButton.setFont(UITheme.primaryFont(java.awt.Font.BOLD, 13)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Keluar");
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 12, 0));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        logoutCard.add(logoutButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        menuPanel.add(logoutCard, gridBagConstraints);

        contentPanel.add(menuPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void styleButtons() {
        ButtonStyler.applySolid(goRideButton, new java.awt.Color(22, 163, 74), java.awt.Color.WHITE);
        ButtonStyler.applySolid(goCarButton, new java.awt.Color(59, 130, 246), java.awt.Color.WHITE);
        ButtonStyler.applySolid(topUpButton, new java.awt.Color(22, 163, 74), java.awt.Color.WHITE);
        ButtonStyler.applySolid(historyButton, new java.awt.Color(241, 102, 99), java.awt.Color.WHITE);
        ButtonStyler.applySolid(logoutButton, new java.awt.Color(68, 68, 239), java.awt.Color.WHITE);
    }

    private void configureKeyboardShortcuts() {
        setupGlobalEnterAction();
        enableCardKeyboardSupport(goRideCard, goRideButton);
        enableCardKeyboardSupport(goCarCard, goCarButton);
        enableCardKeyboardSupport(topUpCard, topUpButton);
        enableCardKeyboardSupport(historyCard, historyButton);
        enableCardKeyboardSupport(logoutCard, logoutButton);
    }

    private void setupGlobalEnterAction() {
        JComponent root = getRootPane();
        InputMap inputMap = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = root.getActionMap();
        final String ACTION_KEY = "trigger-enter";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), ACTION_KEY);
        actionMap.put(ACTION_KEY, new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                if (focusOwner instanceof JButton focusedButton) {
                    focusedButton.doClick();
                    return;
                }

                if (focusOwner != null) {
                    if (SwingUtilities.isDescendingFrom(focusOwner, goRideCard)) {
                        triggerButton(goRideButton);
                        return;
                    }
                    if (SwingUtilities.isDescendingFrom(focusOwner, goCarCard)) {
                        triggerButton(goCarButton);
                        return;
                    }
                    if (SwingUtilities.isDescendingFrom(focusOwner, topUpCard)) {
                        triggerButton(topUpButton);
                        return;
                    }
                    if (SwingUtilities.isDescendingFrom(focusOwner, historyCard)) {
                        triggerButton(historyButton);
                        return;
                    }
                    if (SwingUtilities.isDescendingFrom(focusOwner, logoutCard)) {
                        triggerButton(logoutButton);
                        return;
                    }
                }

                triggerButton(goRideButton);
            }
        });
    }

    private void enableCardKeyboardSupport(javax.swing.JPanel card, JButton targetButton) {
        card.setFocusable(true);
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                targetButton.requestFocusInWindow();
            }
        });

        InputMap inputMap = card.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = card.getActionMap();
        final String ACTION_KEY = "card-enter";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), ACTION_KEY);
        actionMap.put(ACTION_KEY, new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                triggerButton(targetButton);
            }
        });
    }

    private void triggerButton(JButton button) {
        button.requestFocusInWindow();
        button.doClick();
    }

    private void goRideButtonActionPerformed(java.awt.event.ActionEvent evt) {
        openGoRideFrame();
    }

    private void goCarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        openGoCarFrame();
    }

    private void topUpButtonActionPerformed(java.awt.event.ActionEvent evt) {
        openTopUpFrame();
    }

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        openHistoryFrame();
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        logout();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        updateHeader();
    }

    private void updateHeader() {
        welcomeLabel.setText("Halo, " + currentUser.getUsername() + "!");
        saldoLabel.setText(String.format("Saldo: Rp%,.2f", currentUser.getSaldo()));
    }

    private void openGoRideFrame() {
        java.awt.EventQueue.invokeLater(() -> {
            GoRideFrame goRideFrame = new GoRideFrame(authService, rideService, transactionService, currentUser);
            goRideFrame.setVisible(true);
        });
        dispose();
    }

    private void openGoCarFrame() {
        java.awt.EventQueue.invokeLater(() -> {
            GoCarFrame goCarFrame = new GoCarFrame(authService, rideService, transactionService, currentUser);
            goCarFrame.setVisible(true);
        });
        dispose();
    }

    private void openTopUpFrame() {
        java.awt.EventQueue.invokeLater(() -> {
            TopUpFrame topUpFrame = new TopUpFrame(authService, rideService, transactionService, currentUser);
            topUpFrame.setVisible(true);
        });
        dispose();
    }

    private void openHistoryFrame() {
        java.awt.EventQueue.invokeLater(() -> {
            HistoryFrame historyFrame = new HistoryFrame(authService, rideService, transactionService, currentUser);
            historyFrame.setVisible(true);
        });
        dispose();
    }

    private void logout() {
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(authService, rideService, transactionService);
            loginFrame.setVisible(true);
        });
        dispose();
    }

    public void refreshUser(User updatedUser) {
        this.currentUser = updatedUser;
        updateHeader();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel goCarCard;
    private javax.swing.JButton goCarButton;
    private javax.swing.JLabel goCarDescriptionLabel;
    private javax.swing.JLabel goCarTitleLabel;
    private javax.swing.JPanel goRideCard;
    private javax.swing.JButton goRideButton;
    private javax.swing.JLabel goRideDescriptionLabel;
    private javax.swing.JLabel goRideTitleLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel historyCard;
    private javax.swing.JButton historyButton;
    private javax.swing.JLabel historyDescriptionLabel;
    private javax.swing.JLabel historyTitleLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel logoutCard;
    private javax.swing.JLabel logoutDescriptionLabel;
    private javax.swing.JLabel logoutTitleLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JButton topUpButton;
    private javax.swing.JPanel topUpCard;
    private javax.swing.JLabel topUpDescriptionLabel;
    private javax.swing.JLabel topUpTitleLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration                   
}
