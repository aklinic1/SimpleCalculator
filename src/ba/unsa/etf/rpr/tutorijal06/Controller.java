package ba.unsa.etf.rpr.tutorijal06;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label display;

    private Double broj1, broj2;
    private String operacija = new String("");
    private Button lastButtonClicked = new Button();

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
        if(display.getText().equals("0")) display.setText("");
        if(lastButtonClicked.getId() != null)
            if (lastButtonClicked.getId().equals("equalsBtn"))
                display.setText("");
        Button button = (Button)actionEvent.getSource();
        display.setText(display.getText() + button.getText());
    }

    public void bttnEqualsClick(ActionEvent actionEvent) {
        broj2 = Double.valueOf(display.getText());
        display.setText(dajRezultat());
        obnoviDigitron();
        lastButtonClicked = (Button)actionEvent.getSource();
    }
    private void obnoviDigitron(){
        broj1 = Double.valueOf(display.getText());
    }

    public void bttnOperationClick(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        broj1 = Double.valueOf(display.getText());
        operacija = button.getText();
        display.setText("0");
        lastButtonClicked = button;
    }
}
