package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private final Store store;
    private final Cart cart;

    public CartScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                CartScreenController controller = new CartScreenController(store, cart, this);
                loader.setController(controller);
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        setTitle("AIMS - View Cart");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void switchToStore() {
        setVisible(false);
        dispose();
        ScreenNavigator.openStore(store, cart);
    }

    void switchToAddBook() {
        setVisible(false);
        dispose();
        ScreenNavigator.openAddBook(store, cart);
    }

    void switchToAddCd() {
        setVisible(false);
        dispose();
        ScreenNavigator.openAddCd(store, cart);
    }

    void switchToAddDvd() {
        setVisible(false);
        dispose();
        ScreenNavigator.openAddDvd(store, cart);
    }
}
