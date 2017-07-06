package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Controller {

    @FXML
    private Pane mainPane;

    @FXML
    private ImageView bg;

    public Controller() {
    }

    @FXML
    public void initialize() {
        Image bgImage = new Image("images/division_designer_popup_bg.png");
        mainPane.setMaxWidth(bgImage.getWidth());
        mainPane.setMinWidth(bgImage.getWidth());
        mainPane.setMaxHeight(bgImage.getHeight());
        mainPane.setMinHeight(bgImage.getHeight());
        bg.setImage(bgImage);
    }


}
