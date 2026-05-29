package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
public class AimsMenuBar {
  private final Store store;
  private final Cart cart;
  private final JFrame currentFrame;

  public AimsMenuBar(Store store, Cart cart, JFrame currentFrame) {
    this.store = store;
    this.cart = cart;
    this.currentFrame = currentFrame;
  }

  public JMenuBar create() {
    JMenuBar menuBar = new JMenuBar();

    JMenu menuStore = new JMenu("Store");
    menuBar.add(menuStore);

    JMenuItem viewStore = new JMenuItem("View Store");
    viewStore.addActionListener(e -> switchScreen(() -> ScreenNavigator.openStore(store, cart)));
    menuStore.add(viewStore);

    JMenuItem viewCart = new JMenuItem("View Cart");
    viewCart.addActionListener(e -> switchScreen(() -> ScreenNavigator.openCart(store, cart)));
    menuStore.add(viewCart);

    JMenu updateStore = new JMenu("Update Store");
    menuStore.add(updateStore);

    JMenuItem addBook = new JMenuItem("Add Book");
    addBook.addActionListener(e -> switchScreen(() -> ScreenNavigator.openAddBook(store, cart)));
    updateStore.add(addBook);

    JMenuItem addCd = new JMenuItem("Add CD");
    addCd.addActionListener(e -> switchScreen(() -> ScreenNavigator.openAddCd(store, cart)));
    updateStore.add(addCd);

    JMenuItem addDvd = new JMenuItem("Add DVD");
    addDvd.addActionListener(e -> switchScreen(() -> ScreenNavigator.openAddDvd(store, cart)));
    updateStore.add(addDvd);

    JMenuItem exit = new JMenuItem("Exit");
    exit.addActionListener(e -> System.exit(0));
    menuStore.add(exit);

    return menuBar;
  }

  private void switchScreen(Runnable opener) {
    currentFrame.setVisible(false);
    currentFrame.dispose();
    opener.run();
  }
}
