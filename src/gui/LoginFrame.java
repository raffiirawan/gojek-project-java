package gui;

import model.User;
import service.AuthService;
import service.RideService;
import service.TransactionService;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class LoginFrame extends javax.swing.JFrame {

    private final AuthService authService;
    private final RideService rideService;
    private final TransactionService transactionService;

    public LoginFrame(AuthService authService, RideService rideService, TransactionService transactionService) {
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
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gojek App - Login");
        setResizable(false);

        contentPanel.setBackground(new java.awt.Color(245, 246, 250));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        contentPanel.setLayout(new java.awt.BorderLayout());

        headerLabel.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(34, 197, 94));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Selamat Datang di Gojek App");
        contentPanel.add(headerLabel, java.awt.BorderLayout.NORTH);

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 231, 235)),
            javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25)));
        formPanel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints;

        formTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        formTitle.setForeground(new java.awt.Color(31, 41, 55));
        formTitle.setText("Masuk Akun");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        formPanel.add(formTitle, gridBagConstraints);

        usernameLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(75, 85, 99));
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

        passwordLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(75, 85, 99));
        passwordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(passwordLabel, gridBagConstraints);

        passwordField.setColumns(20);
        passwordField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 213, 219)),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 18, 0);
        formPanel.add(passwordField, gridBagConstraints);

        loginButton.setBackground(new java.awt.Color(34, 197, 94));
        loginButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Masuk");
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        formPanel.add(loginButton, gridBagConstraints);

        registerButton.setBackground(new java.awt.Color(243, 244, 246));
        registerButton.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        registerButton.setForeground(new java.awt.Color(31, 41, 55));
        registerButton.setText("Belum punya akun? Daftar");
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        formPanel.add(registerButton, gridBagConstraints);

        contentPanel.add(formPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(440, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void styleButtons() {
        ButtonStyler.applySolid(loginButton, new java.awt.Color(34, 197, 94), java.awt.Color.WHITE);
        ButtonStyler.applySoft(registerButton, new java.awt.Color(243, 244, 246), new java.awt.Color(31, 41, 55), new java.awt.Color(209, 213, 219));
    }

    private void setupEnterKeyActions() {
        getRootPane().setDefaultButton(loginButton);

        usernameField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "focus-pass");
        usernameField.getActionMap().put("focus-pass", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                passwordField.requestFocusInWindow();
            }
        });

        passwordField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "do-login");
        passwordField.getActionMap().put("do-login", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                performLogin();
            }
        });
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        performLogin();
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        openRegisterFrame();
    }

    private void performLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Username dan password harus diisi.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        User user = authService.login(username, password);
        if (user != null) {
            java.awt.EventQueue.invokeLater(() -> {
                MainMenuFrame mainMenuFrame = new MainMenuFrame(authService, rideService, transactionService, user);
                mainMenuFrame.setVisible(true);
            });
            dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Login gagal. Periksa kembali kredensial Anda.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openRegisterFrame() {
        java.awt.EventQueue.invokeLater(() -> {
            RegisterFrame registerFrame = new RegisterFrame(authService, rideService, transactionService);
            registerFrame.setVisible(true);
        });
        dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel contentPanel;
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
