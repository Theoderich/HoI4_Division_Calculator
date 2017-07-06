package de.theo.h4dd.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DivisionControl extends Pane {

    private static final Image IMAGE_INFANTRY = new Image("images/unit_infantry_icon.png");
    private static final Image IMAGE_PLUS = new Image("images/new_regiment_slot.png");
    @FXML
    private ImageView division_icon_bg;
    @FXML
    private ImageView division_icon;

    public DivisionControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/division.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void initialize() {
        division_icon.setImage(IMAGE_PLUS);
        Image division_bg = new Image("images/div_unit_item_bg.png");
        division_icon_bg.setImage(division_bg);
    }

    public void switchToArmyIcon() {
        double halfWidth = IMAGE_INFANTRY.getWidth() / 2.0;
        Rectangle2D divisionIconViewPort = new Rectangle2D(0, 0, halfWidth, IMAGE_INFANTRY.getHeight());
        division_icon.setViewport(divisionIconViewPort);
        division_icon.setImage(IMAGE_INFANTRY);
    }
}
