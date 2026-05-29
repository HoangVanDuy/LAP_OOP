package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private final JButton[] btnNumbers = new JButton[10];
    private final JButton btnDelete = new JButton("DEL");
    private final JButton btnReset = new JButton("C");
    private final JTextField tfDisplay = new JTextField();

    public NumberGrid() {
        tfDisplay.setEditable(false);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(4, 4));
        cp.add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 4, 4));
        cp.add(panelButtons, BorderLayout.CENTER);

        addButtons(panelButtons);

        setTitle("Number Grid");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener listener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            btnNumbers[i].addActionListener(listener);
            panelButtons.add(btnNumbers[i]);
        }
        btnReset.addActionListener(listener);
        panelButtons.add(btnReset);
        btnNumbers[0] = new JButton("0");
        btnNumbers[0].addActionListener(listener);
        panelButtons.add(btnNumbers[0]);
        btnDelete.addActionListener(listener);
        panelButtons.add(btnDelete);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + command);
            } else if (command.equals("DEL")) {
                String text = tfDisplay.getText();
                if (!text.isEmpty()) {
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            } else if (command.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGrid::new);
    }
}
