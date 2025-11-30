package gui;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Utility helper to ensure buttons keep a solid, visible style across platforms.
 */
public final class ButtonStyler {

    private ButtonStyler() {
    }

    public static void applySolid(JButton button, Color background, Color foreground) {
        apply(button, background, foreground, background.darker(), 6, 10);
    }

    public static void applySoft(JButton button, Color background, Color foreground, Color borderColor) {
        apply(button, background, foreground, borderColor, 6, 10);
    }

    private static void apply(JButton button, Color background, Color foreground, Color borderColor, int padding, int radius) {
        button.setBackground(background);
        button.setForeground(foreground);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setRolloverEnabled(true);
        button.setFont(UITheme.primaryFont(button.getFont().getStyle(), button.getFont().getSize()));
        button.setMargin(new java.awt.Insets(padding / 2, padding, padding / 2, padding));

        Border paddingBorder = new EmptyBorder(padding / 2, padding, padding / 2, padding);

        button.setBorder(new javax.swing.border.CompoundBorder(
                UITheme.roundedBorder(radius, borderColor),
                paddingBorder
        ));

        Color hoverColor = UITheme.hoverColor(background);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
                button.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(background);
                button.repaint();
            }
        });

        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(java.awt.Graphics g, javax.swing.JComponent c) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                Color fill = button.getBackground();
                g2.setColor(new Color(0, 0, 0, 20));
                g2.fillRoundRect(1, 3, c.getWidth() - 2, c.getHeight() - 3, radius, radius);
                g2.setColor(fill);
                g2.fillRoundRect(0, 0, c.getWidth() - 3, c.getHeight() - 4, radius, radius);
                g2.dispose();
                super.paint(g, c);
            }
        });
    }
}
