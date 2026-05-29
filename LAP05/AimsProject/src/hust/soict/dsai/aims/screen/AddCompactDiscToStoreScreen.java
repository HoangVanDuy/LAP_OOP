package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");
    }

    @Override
    protected JPanel createForm() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField tfTitle = addField(form, "Title:");
        JTextField tfCategory = addField(form, "Category:");
        JTextField tfArtist = addField(form, "Artist:");
        JTextField tfCost = addField(form, "Cost:");
        JTextField tfTrackTitle = addField(form, "Track title (optional):");
        JTextField tfTrackLength = addField(form, "Track length (optional):");

        addSubmitButton(form, () -> {
            try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String artist = tfArtist.getText().trim();
                float cost = Float.parseFloat(tfCost.getText().trim());
                CompactDisc cd = new CompactDisc(title, category, cost, artist);

                String trackTitle = tfTrackTitle.getText().trim();
                if (!trackTitle.isEmpty()) {
                    int length = Integer.parseInt(tfTrackLength.getText().trim());
                    cd.addTrack(new Track(trackTitle, length));
                }

                store.addMedia(cd);
                JOptionPane.showMessageDialog(this, "CD added to store.");
                ScreenNavigator.openStore(store, cart);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return form;
    }
}
