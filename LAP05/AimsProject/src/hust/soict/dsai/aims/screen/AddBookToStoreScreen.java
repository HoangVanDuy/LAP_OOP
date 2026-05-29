package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store");
    }

    @Override
    protected JPanel createForm() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField tfTitle = addField(form, "Title:");
        JTextField tfCategory = addField(form, "Category:");
        JTextField tfCost = addField(form, "Cost:");
        JTextField tfAuthors = addField(form, "Authors (comma-separated):");

        addSubmitButton(form, () -> {
            try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                float cost = Float.parseFloat(tfCost.getText().trim());
                Book book = new Book(title, category, cost);
                for (String author : tfAuthors.getText().split(",")) {
                    String name = author.trim();
                    if (!name.isEmpty()) {
                        book.addAuthor(name);
                    }
                }
                store.addMedia(book);
                JOptionPane.showMessageDialog(this, "Book added to store.");
                ScreenNavigator.openStore(store, cart);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost value.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return form;
    }
}
