package ba.unsa.etf.rpr.tutorijal06;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.awt.*;

public class Controller {
    public TextField txtField;

    public void bttnClick(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        txtField.setText(txtField.getText() + button.getText());
    }

    public void bttnEqualsClick(ActionEvent actionEvent) {

    }

    public void bttnActionClick(ActionEvent actionEvent) {
    }
}
