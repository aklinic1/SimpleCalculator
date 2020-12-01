package ba.unsa.etf.rpr.tutorijal06;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    public TextField txtField;
    private Double broj1, broj2;
    private String operacija = new String("");
    private Button lastButtonClicked =new Button();
    private String dajRezultat(){
        Double rezultat;
        if(operacija.equals("+")) rezultat = broj1 + broj2;
        else if(operacija.equals("-")) rezultat = broj1 - broj2;
        else if(operacija.equals("/")) rezultat = broj1 / broj2;
        else if(operacija.equals("x")) rezultat = broj1 * broj2;
        else rezultat = broj1 % broj2;
        return String.valueOf(rezultat);
    }

    public void bttnClick(ActionEvent actionEvent) {
        if(txtField.getText().equals("0") || lastButtonClicked.getId().equals("bttnEquals")) txtField.setText("");
        Button button = (Button)actionEvent.getSource();
        txtField.setText(txtField.getText() + button.getText());
        lastButtonClicked = button;
    }

    public void bttnEqualsClick(ActionEvent actionEvent) {
        broj2 = Double.valueOf(txtField.getText());
        txtField.setText(dajRezultat());
        obnoviDigitron();
        lastButtonClicked = (Button)actionEvent.getSource();
    }
    private void obnoviDigitron(){
        broj1 = Double.valueOf(txtField.getText());
    }

    public void bttnOperationClick(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        broj1 = Double.valueOf(txtField.getText());
        operacija = button.getText();
        txtField.setText("0");
        lastButtonClicked = button;
    }
}
