import java.awt.*;

class TrafficLight {
    private static final Color[] LIGHT_COLORS = {Color.RED, Color.YELLOW, Color.GREEN};

    private int currentState;

    public TrafficLight() {
        currentState = 0;
    }

    public Color getCurrentColor() {
        return LIGHT_COLORS[currentState];
    }

    public void nextState() {
        currentState = (currentState + 1) % LIGHT_COLORS.length;
    }
}