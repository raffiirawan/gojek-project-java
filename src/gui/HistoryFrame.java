package gui;

import model.Transaction;
import model.User;
import service.AuthService;
import service.RideService;
import service.TransactionService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class HistoryFrame extends JFrame {
    private final AuthService authService;
    private final RideService rideService;
    private final TransactionService transactionService;
    private final User currentUser;

    private JTable historyTable;

    public HistoryFrame(AuthService authService, RideService rideService, TransactionService transactionService, User currentUser) {
        this.authService = authService;
        this.rideService = rideService;
        this.transactionService = transactionService;
        this.currentUser = currentUser;
        initUI();
        loadHistory();
    }

    private void initUI() {
        setTitle("Gojek App - Riwayat Transaksi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel contentPanel = UITheme.createMapBackgroundPanel();
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Riwayat Perjalanan", SwingConstants.LEFT);
        headerLabel.setFont(UITheme.primaryFont(Font.BOLD, 24));
        headerLabel.setForeground(new Color(30, 64, 175));
        contentPanel.add(headerLabel, BorderLayout.NORTH);

        historyTable = new JTable();
        historyTable.setRowHeight(30);
        historyTable.setFont(UITheme.primaryFont(Font.PLAIN, 14));
        historyTable.getTableHeader().setFont(UITheme.primaryFont(Font.BOLD, 14));
        historyTable.getTableHeader().setOpaque(true);
        historyTable.getTableHeader().setBackground(new Color(236, 244, 255));
        historyTable.getTableHeader().setForeground(new Color(30, 41, 59));
        historyTable.setFillsViewportHeight(true);
        historyTable.setShowGrid(false);
        historyTable.setOpaque(false);
        historyTable.setIntercellSpacing(new Dimension(0, 6));
        historyTable.setRowMargin(4);

        JScrollPane scrollPane = new JScrollPane(historyTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);

        JPanel tableCard = new JPanel(new BorderLayout());
        tableCard.setOpaque(false);
        tableCard.setBorder(UITheme.cardBorder());
        UITheme.applyTranslucentCard(tableCard);
        tableCard.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(tableCard, BorderLayout.CENTER);

        JButton backButton = new JButton("Kembali ke Menu");
        backButton.setFont(UITheme.primaryFont(Font.BOLD, 12));
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        ButtonStyler.applySolid(backButton, new Color(59, 130, 246), Color.WHITE);
        backButton.setIcon(UITheme.rideIcon());
        backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        backButton.setIconTextGap(8);
        backButton.addActionListener(e -> openMainMenu());

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setOpaque(false);
        footerPanel.add(backButton);
        contentPanel.add(footerPanel, BorderLayout.SOUTH);

        add(contentPanel);
    }

    private void loadHistory() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Tanggal", "Pickup", "Tujuan", "Layanan", "Tarif", "Status"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<Transaction> transactions = transactionService.getTransactionsByUser(currentUser.getId());
        for (Transaction transaction : transactions) {
            model.addRow(new Object[]{
                    transaction.getCreatedAt(),
                    transaction.getPickupLocation(),
                    transaction.getDestination(),
                    transaction.getVehicleType() == null ? "GoRide" : transaction.getVehicleType(),
                    "Rp" + String.format("%,.2f", transaction.getFare()),
                    transaction.getStatus()
            });
        }

        historyTable.setModel(model);
        historyTable.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (comp instanceof JLabel label) {
                    label.setFont(UITheme.primaryFont(Font.PLAIN, 13));
                    Color baseBg = (row % 2 == 0) ? new Color(255, 255, 255, 120) : new Color(255, 255, 255, 80);
                    label.setOpaque(true);
                    label.setBackground(isSelected ? new Color(224, 231, 255, 180) : baseBg);
                    if (column == 3) {
                        String type = String.valueOf(value);
                        label.setIcon("GoCar".equalsIgnoreCase(type) ? UITheme.carIcon() : UITheme.rideIcon());
                        label.setIconTextGap(8);
                        label.setHorizontalAlignment(SwingConstants.LEFT);
                    } else {
                        label.setIcon(null);
                        label.setHorizontalAlignment(SwingConstants.LEFT);
                    }

                    if (column == 5) {
                        Color statusColor = UITheme.statusColor(String.valueOf(value));
                        label.setForeground(statusColor);
                        label.setBorder(BorderFactory.createCompoundBorder(
                                UITheme.roundedBorder(12, new Color(255, 255, 255, 0)),
                                new EmptyBorder(4, 8, 4, 8)
                        ));
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                        label.setOpaque(true);
                        label.setBackground(new Color(statusColor.getRed(), statusColor.getGreen(), statusColor.getBlue(), 28));
                    } else {
                        label.setForeground(new Color(31, 41, 55));
                        label.setBorder(new EmptyBorder(4, 8, 4, 8));
                    }
                }
                return comp;
            }
        });
    }

    private void openMainMenu() {
        SwingUtilities.invokeLater(() -> {
            User refreshedUser = authService.getUserById(currentUser.getId());
            MainMenuFrame mainMenuFrame = new MainMenuFrame(authService, rideService, transactionService, refreshedUser);
            mainMenuFrame.setVisible(true);
        });
        dispose();
    }
}
