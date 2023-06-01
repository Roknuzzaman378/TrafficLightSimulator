import javax.swing.*;
import java.awt.*;

class LightCircle extends JPanel {
    private static final int CIRCLE_SIZE = 80;
    private static final int BORDER_THICKNESS = 5;

    private Color color;
    private boolean isActive;

    public LightCircle(Color color) {
        this.color = color;
        isActive = false;

        setPreferredSize(new Dimension(CIRCLE_SIZE, CIRCLE_SIZE));
    }

    public void setActive(boolean active) {
        isActive = active;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = (getWidth() - CIRCLE_SIZE) / 2;
        int y = (getHeight() - CIRCLE_SIZE) / 2;

        g.setColor(Color.BLACK);
        g.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);

        if (isActive) {
            g.setColor(color);
            g.fillOval(x + BORDER_THICKNESS, y + BORDER_THICKNESS, CIRCLE_SIZE - BORDER_THICKNESS * 2, CIRCLE_SIZE - BORDER_THICKNESS * 2);
        }
    }
}
