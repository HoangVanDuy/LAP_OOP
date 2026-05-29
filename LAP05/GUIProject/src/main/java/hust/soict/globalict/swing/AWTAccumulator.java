package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput, tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));
        add(new Label("Enter an integer:"));
        tfInput = new TextField(10);
        tfInput.addActionListener(new TFInputListener(tfInput));
        add(tfInput);
        add(new Label("The sum in cents is:"));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);
        setTitle("AWT Accumulator");
        setSize(400, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    private class TFInputListener implements ActionListener {
        private final TextField source;

        public TFInputListener(TextField source) {
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
