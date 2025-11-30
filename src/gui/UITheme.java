package gui;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Shared theme helpers to give the app a Gojek-style visual without changing layout/logic.
 */
public final class UITheme {
    public static final Color GOJEK_GREEN = new Color(0x00AA13);
    public static final Color CARD_BG = new Color(255, 255, 255, 215);
    public static final Color SHADOW = new Color(0, 0, 0, 16);

    private UITheme() {
    }

    public static Font primaryFont(int style, int size) {
        Font fallback = new Font("Segoe UI", style, size);
        Font poppins = new Font("Poppins", style, size);
        return poppins.getFamily().equalsIgnoreCase("dialog") ? fallback : poppins;
    }

    public static JPanel createMapBackgroundPanel() {
        return new MapBackgroundPanel();
    }

    public static Border roundedBorder(int radius, Color borderColor) {
        return new CompoundBorder(new RoundedLineBorder(borderColor, 1, radius), new EmptyBorder(radius / 3, radius / 2, radius / 3, radius / 2));
    }

    public static Border cardBorder() {
        return new CompoundBorder(new LineBorder(new Color(255, 255, 255, 140), 1, true), new EmptyBorder(12, 12, 12, 12));
    }

    public static void applyTranslucentCard(JComponent component) {
        component.setOpaque(true);
        component.setBackground(CARD_BG);
        component.setBorder(cardBorder());
    }

    public static Icon rideIcon() {
        return new RouteIcon(GOJEK_GREEN, new Color(0, 0, 0, 90));
    }

    public static Icon carIcon() {
        return new RouteIcon(new Color(59, 130, 246), new Color(0, 0, 0, 90));
    }

    public static Color hoverColor(Color base) {
        return adjustBrightness(base, -0.08);
    }

    public static Color statusColor(String status) {
        if (status == null) return Color.DARK_GRAY;
        String normalized = status.toLowerCase();
        if (normalized.contains("complete") || normalized.contains("selesai")) {
            return new Color(34, 197, 94);
        }
        if (normalized.contains("cancel")) {
            return new Color(239, 68, 68);
        }
        return new Color(234, 179, 8);
    }

    private static Color adjustBrightness(Color color, double delta) {
        int r = clamp((int) (color.getRed() * (1 + delta)));
        int g = clamp((int) (color.getGreen() * (1 + delta)));
        int b = clamp((int) (color.getBlue() * (1 + delta)));
        return new Color(r, g, b, color.getAlpha());
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }

    /**
     * Light map-like background with subtle routes and pins.
     */
    private static class MapBackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            GradientPaint gradient = new GradientPaint(0, 0, new Color(244, 247, 245), w, h, new Color(234, 241, 237));
            g2.setPaint(gradient);
            g2.fillRect(0, 0, w, h);

            // Subtle route lines (minimal agar tidak terlalu ramai)
            g2.setStroke(new BasicStroke(1.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10f, 16f}, 0f));
            g2.setColor(new Color(0, 170, 19, 14));
            for (int i = -h; i < h * 2; i += 170) {
                g2.drawLine(0, i, w, i + 180);
            }
            for (int i = -w; i < w * 2; i += 190) {
                g2.drawLine(i, 0, i + 190, h);
            }

            g2.dispose();
        }
    }

    private static class RoundedLineBorder extends AbstractBorder {
        private final Color color;
        private final int thickness;
        private final int radius;

        RoundedLineBorder(Color color, int thickness, int radius) {
            this.color = color;
            this.thickness = thickness;
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int r = radius;
            int w = width - 1;
            int h = height - 1;
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRoundRect(x, y, w, h, r, r);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius / 3 + thickness, radius / 2 + thickness, radius / 3 + thickness, radius / 2 + thickness);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            Insets i = getBorderInsets(c);
            insets.set(i.top, i.left, i.bottom, i.right);
            return insets;
        }
    }

    private static class RouteIcon implements Icon {
        private final Color primary;
        private final Color shadow;
        private final int size = 18;

        RouteIcon(Color primary, Color shadow) {
            this.primary = primary;
            this.shadow = shadow;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.translate(x, y);

            g2.setColor(shadow);
            g2.fillOval(2, size - 4, size - 4, 4);

            g2.setColor(primary);
            g2.fillRoundRect(2, 2, size - 4, size - 6, 6, 6);

            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawLine(6, size - 10, size - 6, size - 10);
            g2.drawLine(6, 6, size / 2, size / 2 + 1);
            g2.drawLine(size - 6, 6, size / 2, size / 2 + 1);

            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }
    }
}
