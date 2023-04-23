import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GCFApp {

    private JFrame frame;
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JLabel gcfLabel;
    private JButton calculateButton;

    public GCFApp() {
        frame = new JFrame("GCF App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createInputPanel(), BorderLayout.CENTER);
        mainPanel.add(createOutputPanel(), BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        JLabel firstNumberLabel = new JLabel("First number:");
        firstNumberField = new JTextField();
        inputPanel.add(firstNumberLabel);
        inputPanel.add(firstNumberField);

        JLabel secondNumberLabel = new JLabel("Second number:");
        secondNumberField = new JTextField();
        inputPanel.add(secondNumberLabel);
        inputPanel.add(secondNumberField);

        return inputPanel;
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel();
        gcfLabel = new JLabel("");
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstNumber = Integer.parseInt(firstNumberField.getText());
                int secondNumber = Integer.parseInt(secondNumberField.getText());

                int gcf = getGcf(firstNumber, secondNumber);
                gcfLabel.setText("The greatest common factor of " + firstNumber + " and " + secondNumber + " is " + gcf);

                // Create a popup dialog to display the result.
                JDialog dialog = new JDialog(frame, "GCF Result");
                dialog.setSize(200, 100);
                dialog.setLocationRelativeTo(null);

                JLabel resultLabel = new JLabel("The greatest common factor of " + firstNumber + " and " + secondNumber + " is " + gcf);
                dialog.add(resultLabel);

                dialog.setVisible(true);
            }
        });
        outputPanel.add(gcfLabel);
        outputPanel.add(calculateButton);

        return outputPanel;
    }

    private int getGcf(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGcf(b, a % b);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GCFApp();
            }
        });
    }
}