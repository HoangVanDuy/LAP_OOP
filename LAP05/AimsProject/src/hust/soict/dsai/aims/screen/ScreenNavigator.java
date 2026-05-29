package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public final class ScreenNavigator {
    private ScreenNavigator() {
    }

    public static void openStore(Store store, Cart cart) {
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }

    public static void openCart(Store store, Cart cart) {
        SwingUtilities.invokeLater(() -> new CartScreen(store, cart));
    }

    public static void openAddBook(Store store, Cart cart) {
        SwingUtilities.invokeLater(() -> new AddBookToStoreScreen(store, cart));
    }

    public static void openAddCd(Store store, Cart cart) {
        SwingUtilities.invokeLater(() -> new AddCompactDiscToStoreScreen(store, cart));
    }

    public static void openAddDvd(Store store, Cart cart) {
        SwingUtilities.invokeLater(() -> new AddDigitalVideoDiscToStoreScreen(store, cart));
    }
}
