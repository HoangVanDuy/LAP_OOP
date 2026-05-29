package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.ScreenNavigator;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;

import javax.swing.*;

public class Aims {
    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void main(String[] args) {
        initData();
        Platform.startup(() -> {});
        SwingUtilities.invokeLater(() -> ScreenNavigator.openStore(store, cart));
    }

    public static void playMediaSafe(Playable playable, String title) {
        try {
            playable.play();
        } catch (PlayerException e) {
            System.err.println("PlayerException: " + e.getMessage());
            System.err.println(e.toString());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Cannot play: " + title,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void addMediaToCartSafe(Media media) {
        try {
            cart.addMedia(media);
        } catch (LimitExceededException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Cart full",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void initData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "DVD", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "DVD", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD", "Animation", 18.99f);
        store.addMedia(dvd3);

        Book book1 = new Book("Harry Potter", "BOOK", 20.0f);
        store.addMedia(book1);

        CompactDisc cd1 = new CompactDisc("Adele 21", "CD", "Adele", 15.0f, "Adele");
        cd1.addTrack(new Track("Rolling in the Deep", 228));
        cd1.addTrack(new Track("Someone Like You", 285));
        store.addMedia(cd1);
    }
}
