package gui;

import service.AuthService;
import service.RideService;
import service.TransactionService;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class RegisterFrame extends javax.swing.JFrame {

    private final AuthService authService;
    private final RideService rideService;
    private final TransactionService transactionService;

    public RegisterFrame(AuthService authService, RideService rideService, TransactionService transactionService) {
        this.authService = authService;
        this.rideService = rideService;
        this.transactionService = transactionService;
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
        formTitle = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordLabel = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gojek App - Register");
        setResizable(false);

        contentPanel.setBackground(new java.awt.Color(236, 253, 245));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contentPanel.setLayout(new java.awt.BorderLayout());

        headerLabel.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(16, 185, 129));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Buat Akun Baru");
        contentPanel.add(headerLabel, java.awt.BorderLayout.NORTH);

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 213, 219)),
            javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25)));
        formPanel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints;

        formTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        formTitle.setForeground(new java.awt.Color(31, 41, 55));
        formTitle.setText("Daftar Akun");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 18, 0);
        formPanel.add(formTitle, gridBagConstraints);

        usernameLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(55, 65, 81));
        usernameLabel.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(usernameLabel, gridBagConstraints);

        usernameField.setColumns(20);
        usernameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 213, 219)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        formPanel.add(usernameField, gridBagConstraints);

        emailLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(55, 65, 81));
        emailLabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(emailLabel, gridBagConstraints);

        emailField.setColumns(20);
        emailField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 213, 219)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        formPanel.add(emailField, gridBagConstraints);

        passwordLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(55, 65, 81));
        passwordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(passwordLabel, gridBagConstraints);

        passwordField.setColumns(20);
        passwordField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 213, 219)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        formPanel.add(passwordField, gridBagConstraints);

        confirmPasswordLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        confirmPasswordLabel.setForeground(new java.awt.Color(55, 65, 81));
        confirmPasswordLabel.setText("Konfirmasi Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(confirmPasswordLabel, gridBagConstraints);

        confirmPasswordField.setColumns(20);
        confirmPasswordField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 213, 219)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        formPanel.add(confirmPasswordField, gridBagConstraints);

        registerButton.setBackground(new java.awt.Color(16, 185, 129));
        registerButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Daftar");
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        formPanel.add(registerButton, gridBagConstraints);

        loginButton.setBackground(new java.awt.Color(236, 253, 245));
        loginButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(16, 185, 129));
        loginButton.setText("Sudah punya akun? Masuk");
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        formPanel.add(loginButton, gridBagConstraints);

        contentPanel.add(formPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void styleButtons() {
        ButtonStyler.applySolid(registerButton, new java.awt.Color(16, 185, 129), java.awt.Color.WHITE);
        ButtonStyler.applySoft(loginButton, new java.awt.Color(236, 253, 245), new java.awt.Color(16, 185, 129), new java.awt.Color(16, 185, 129));
    }

    private void setupEnterKeyActions() {
        getRootPane().setDefaultButton(registerButton);

        usernameField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "focus-email");
        usernameField.getActionMap().put("focus-email", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                emailField.requestFocusInWindow();
            }
        });

        emailField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "focus-pass");
        emailField.getActionMap().put("focus-pass", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                passwordField.requestFocusInWindow();
            }
        });

        passwordField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "focus-confirm");
        passwordField.getActionMap().put("focus-confirm", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                confirmPasswordField.requestFocusInWindow();
            }
        });

        confirmPasswordField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "do-register");
        confirmPasswordField.getActionMap().put("do-register", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                handleRegister();
            }
        });
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        handleRegister();
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        openLoginFrame();
    }

    private void handleRegister() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Mohon isi semua field.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Konfirmasi password tidak sesuai.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean success = authService.register(username, email, password);
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Registrasi berhasil! Silakan login.", "Informasi", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            openLoginFrame();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Registrasi gagal. Username atau email mungkin sudah digunakan.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openLoginFrame() {
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(authService, rideService, transactionService);
            loginFrame.setVisible(true);
        });
        dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel formTitle;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration                   
}
