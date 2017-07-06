package de.theo.h4dd.components;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DivisionColumn extends Pane {

    @FXML
    private DivisionControl divisionControl1;
    @FXML
    private DivisionControl divisionControl2;
    @FXML
    private DivisionControl divisionControl3;
    @FXML
    private DivisionControl divisionControl4;
    @FXML
    private DivisionControl divisionControl5;

    private DivisionControl[] divisionControls;

    private int currentControlIndex;


    public DivisionColumn() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/divisionColumn.fxml"));
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
        divisionControls = new DivisionControl[]{divisionControl1, divisionControl2, divisionControl3, divisionControl4, divisionControl5};
        currentControlIndex = 0;
        currentControl().setOnMouseClicked(new ClickEventHandler());
    }

    private DivisionControl currentControl() {
        return divisionControls[currentControlIndex];
    }

    private class ClickEventHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            DivisionControl oldControl = currentControl();
            oldControl.switchToArmyIcon();
            oldControl.setOnMouseClicked(null);
            if (currentControlIndex < 4) {
                ++currentControlIndex;
                DivisionControl nextControl = currentControl();
                nextControl.setVisible(true);
                nextControl.setOnMouseClicked(this);
            }
        }
    }

}
