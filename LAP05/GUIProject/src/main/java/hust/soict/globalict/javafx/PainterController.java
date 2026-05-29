package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController implements Initializable {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioPen;

    @FXML
    private RadioButton radioEraser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        javafx.scene.control.ToggleGroup toolToggleGroup = new javafx.scene.control.ToggleGroup();
        radioPen.setToggleGroup(toolToggleGroup);
        radioEraser.setToggleGroup(toolToggleGroup);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color color = radioEraser.isSelected() ? Color.WHITE : Color.BLACK;
        Circle dot = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(dot);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}
