package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CartScreenController implements Initializable {
    private final Store store;
    private final Cart cart;
    private final CartScreen cartScreen;

    private FilteredList<Media> filteredMedia;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediacategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotalCost;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    public CartScreenController(Store store, Cart cart, CartScreen cartScreen) {
        this.store = store;
        this.cart = cart;
        this.cartScreen = cartScreen;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), m -> true);
        tblMedia.setItems(filteredMedia);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        ToggleGroup filterCategory = new ToggleGroup();
        radioBtnFilterId.setToggleGroup(filterCategory);
        radioBtnFilterTitle.setToggleGroup(filterCategory);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<Media>) (obs, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } else {
                        btnPlay.setVisible(false);
                        btnRemove.setVisible(false);
                    }
                });

        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) c -> updateTotalCost());
        updateTotalCost();

        tfFilter.textProperty().addListener((obs, oldVal, newVal) -> showFilteredMedia());
        radioBtnFilterId.selectedProperty().addListener((obs, oldVal, newVal) -> showFilteredMedia());
        radioBtnFilterTitle.selectedProperty().addListener((obs, oldVal, newVal) -> showFilteredMedia());
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void updateTotalCost() {
        float total = 0;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        lblTotalCost.setText(String.format("%.2f $", total));
    }

    private void showFilteredMedia() {
        String filter = tfFilter.getText();
        if (filter == null) {
            filter = "";
        }
        final String keyword = filter.trim().toLowerCase();
        final boolean byId = radioBtnFilterId.isSelected();

        filteredMedia.setPredicate(media -> {
            if (keyword.isEmpty()) {
                return true;
            }
            if (byId) {
                return String.valueOf(media.getId()).contains(keyword);
            }
            return media.getTitle() != null && media.getTitle().toLowerCase().contains(keyword);
        });
    }

    @FXML
    void btnRemovePressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlayPressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable playable) {
            try {
                String details = playable.getPlayDescription();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, details, ButtonType.OK);
                alert.setHeaderText("Playing: " + selected.getTitle());
                alert.showAndWait();
            } catch (PlayerException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                alert.setHeaderText("Player Error");
                alert.showAndWait();
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed() {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Cart is empty.", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Place order and empty cart?", ButtonType.YES, ButtonType.NO);
        if (confirm.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            cart.emptyCart();
            updateTotalCost();
            Alert done = new Alert(Alert.AlertType.INFORMATION, "Order placed successfully.", ButtonType.OK);
            done.showAndWait();
        }
    }

    @FXML void viewStore() {
        cartScreen.switchToStore();
    }

    @FXML void viewCart() {
        // already on cart
    }

    @FXML void addBook() {
        cartScreen.switchToAddBook();
    }

    @FXML void addCd() {
        cartScreen.switchToAddCd();
    }

    @FXML void addDvd() {
        cartScreen.switchToAddDvd();
    }

    @FXML void exitApp() {
        System.exit(0);
    }
}
