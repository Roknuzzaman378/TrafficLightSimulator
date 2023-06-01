import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame {
    private TrafficLight trafficLight;

    private JPanel lightPanel;
    private LightCircle redCircle, yellowCircle, greenCircle;
    private JButton startButton;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setSize(200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        trafficLight = new TrafficLight();

        lightPanel = new JPanel();
        lightPanel.setLayout(new GridLayout(3, 1));

        redCircle = new LightCircle(Color.RED);
        yellowCircle = new LightCircle(Color.YELLOW);
        greenCircle = new LightCircle(Color.GREEN);

        lightPanel.add(redCircle);
        lightPanel.add(yellowCircle);
        lightPanel.add(greenCircle);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startSimulation();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(lightPanel, BorderLayout.CENTER);
        mainPanel.add(startButton, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    private void startSimulation() {
        startButton.setEnabled(false);

        Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trafficLight.nextState();
                updateLightColors();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    private void updateLightColors() {
        Color currentColor = trafficLight.getCurrentColor();

        redCircle.setActive(currentColor == Color.RED);
        yellowCircle.setActive(currentColor == Color.YELLOW);
        greenCircle.setActive(currentColor == Color.GREEN);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TrafficLightSimulator simulator = new TrafficLightSimulator();
                simulator.setVisible(true);
            }
        });
    }
}