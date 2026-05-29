package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput, tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));
        cp.add(new JLabel("Enter an integer:"));
        tfInput = new JTextField(10);
        tfInput.addActionListener(new TFInputListener(tfInput));
        cp.add(tfInput);
        cp.add(new JLabel("The sum in cents is:"));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);
        setTitle("Swing Accumulator");
        setSize(400, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingAccumulator::new);
    }

    private class TFInputListener implements ActionListener {
        private final JTextField source;

        public TFInputListener(JTextField source) {
            this.source = source;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int value = Integer.parseInt(source.getText());
            sum += value;
            tfOutput.setText(String.valueOf(sum));
        }
    }
}
