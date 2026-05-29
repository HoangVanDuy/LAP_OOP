package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD to Store");
    }

    @Override
    protected JPanel createForm() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField tfTitle = addField(form, "Title:");
        JTextField tfCategory = addField(form, "Category:");
        JTextField tfDirector = addField(form, "Director:");
        JTextField tfLength = addField(form, "Length:");
        JTextField tfCost = addField(form, "Cost:");

        addSubmitButton(form, () -> {
            try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                int length = Integer.parseInt(tfLength.getText().trim());
                float cost = Float.parseFloat(tfCost.getText().trim());
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(this, "DVD added to store.");
                ScreenNavigator.openStore(store, cart);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return form;
    }
}
