package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected final Store store;
    protected final Cart cart;

    protected AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(new AimsMenuBar(store, cart, this).create());
        north.add(createHeader(title));
        cp.add(north, BorderLayout.NORTH);

        cp.add(createForm(), BorderLayout.CENTER);

        setTitle("AIMS - " + title);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createHeader(String title) {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl = new JLabel(title);
        lbl.setFont(new Font(lbl.getFont().getName(), Font.PLAIN, 36));
        lbl.setForeground(new Color(0, 255, 255));
        header.add(lbl);
        return header;
    }

    protected abstract JPanel createForm();

    protected JTextField addField(JPanel form, String label) {
        form.add(new JLabel(label));
        JTextField field = new JTextField(20);
        form.add(field);
        return field;
    }

    protected void addSubmitButton(JPanel form, Runnable onSubmit) {
        JButton submit = new JButton("Add to store");
        submit.addActionListener(e -> onSubmit.run());
        form.add(submit);
    }
}
