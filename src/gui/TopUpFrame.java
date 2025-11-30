package gui;

import model.User;
import service.AuthService;
import service.RideService;
import service.TransactionService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class TopUpFrame extends JFrame {
    private final AuthService authService;
    private final RideService rideService;
    private final TransactionService transactionService;
    private final User currentUser;

    private JTextField amountField;

    public TopUpFrame(AuthService authService, RideService rideService, TransactionService transactionService, User currentUser) {
        this.authService = authService;
        this.rideService = rideService;
        this.transactionService = transactionService;
        this.currentUser = currentUser;
        initUI();
        setupEnterKeyActions();
    }

    private void initUI() {
        setTitle("Gojek App - Top Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        contentPanel.setBackground(new Color(255, 247, 237));

        JLabel headerLabel = new JLabel("Top Up Saldo", SwingConstants.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        headerLabel.setForeground(new Color(245, 158, 11));
        contentPanel.add(headerLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(251, 191, 36), 1),
                new EmptyBorder(25, 25, 25, 25)));

        JLabel saldoLabel = new JLabel("Saldo saat ini: Rp" + String.format("%,.2f", currentUser.getSaldo()));
        saldoLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        saldoLabel.setForeground(new Color(217, 119, 6));
        saldoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(saldoLabel);
        formPanel.add(Box.createVerticalStrut(20));

        formPanel.add(createLabeledField("Nominal Top Up", amountField = new JTextField()));
        formPanel.add(Box.createVerticalStrut(20));

        JButton topUpButton = createPrimaryButton("Top Up");
        topUpButton.addActionListener(e -> handleTopUp());
        formPanel.add(topUpButton);
        formPanel.add(Box.createVerticalStrut(15));

        JButton backButton = createSecondaryButton("Kembali");
        backButton.addActionListener(e -> openMainMenu());
        formPanel.add(backButton);

        contentPanel.add(formPanel, BorderLayout.CENTER);
        add(contentPanel);
    }

    private JPanel createLabeledField(String labelText, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(new Color(180, 83, 9));
        panel.add(label);
        panel.add(Box.createVerticalStrut(6));

        field.setPreferredSize(new Dimension(200, 40));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(253, 186, 116), 1),
                new EmptyBorder(8, 10, 8, 10)));
        panel.add(field);
        return panel;
    }

    private JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(170, 38));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        ButtonStyler.applySolid(button, new Color(245, 158, 11), Color.WHITE);
        return button;
    }

    private JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(170, 34));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));
        button.setFont(new Font("SansSerif", Font.PLAIN, 12));
        ButtonStyler.applySoft(button, new Color(254, 243, 199), new Color(180, 83, 9), new Color(253, 186, 116));
        return button;
    }

    private void handleTopUp() {
        String amountText = amountField.getText().trim();
        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nominal top up.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan nominal yang valid.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double newSaldo = currentUser.getSaldo() + amount;
        boolean success = authService.updateSaldo(currentUser.getId(), newSaldo);
        if (success) {
            currentUser.setSaldo(newSaldo);
            JOptionPane.showMessageDialog(this, "Top up berhasil!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            openMainMenuWithRefresh();
        } else {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui saldo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openMainMenu() {
        SwingUtilities.invokeLater(() -> {
            MainMenuFrame mainMenuFrame = new MainMenuFrame(authService, rideService, transactionService, currentUser);
            mainMenuFrame.setVisible(true);
        });
        dispose();
    }

    private void openMainMenuWithRefresh() {
        SwingUtilities.invokeLater(() -> {
            User refreshedUser = authService.getUserById(currentUser.getId());
            MainMenuFrame mainMenuFrame = new MainMenuFrame(authService, rideService, transactionService, refreshedUser);
            mainMenuFrame.setVisible(true);
        });
        dispose();
    }

    private void setupEnterKeyActions() {
        getRootPane().setDefaultButton(null);
        if (amountField != null) {
            amountField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "do-topup");
            amountField.getActionMap().put("do-topup", new AbstractAction() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    handleTopUp();
                }
            });
        }
    }
}
