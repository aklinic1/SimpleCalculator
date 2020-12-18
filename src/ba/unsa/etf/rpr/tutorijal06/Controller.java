package ba.unsa.etf.rpr.tutorijal06;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label display;
    @FXML
    private Label backupDisplay;
    @FXML
    private Button plusBtn;

    boolean ocistiDisplay = false;
    private double broj1, broj2;
    private String operacija1 = "", operacija2 = "";

    private Button lastButtonClicked = new Button();

    private String dajRezultat(String operacija){
        Double rezultat;
        if(operacija.equals("+")) rezultat = broj1 + broj2;
        else if(operacija.equals("-")) rezultat = broj1 - broj2;
        else if(operacija.equals("/")) rezultat = broj1 / broj2;
        else if(operacija.equals("x")) rezultat = broj1 * broj2;
        else rezultat = broj1 % broj2;
        return dajBrojZaIspis(rezultat);
    }
    private String dajBrojZaIspis(Double broj){
        if(broj == broj.intValue())
            return String.valueOf(broj.intValue());
        return String.valueOf(broj);

    }

    private void setBackupDisplay(String text){
        backupDisplay.setText(text);
    }

    private void setDisplay(String text){
        display.setText(text);
    }

    private boolean isOperationClick(Button buttonClicked){
        if(buttonClicked.getId() != null) {
            if (buttonClicked.getId().equals("plusBtn") || buttonClicked.getId().equals("minusBtn") ||
                    buttonClicked.getId().equals("equalsBtn") || buttonClicked.getId().equals("divideBtn") ||
                    buttonClicked.getId().equals("multiplyBtn"))
                return true;
        }
        return false;
    }

    public void bttnClick(ActionEvent actionEvent) {
       Button buttonClicked = (Button) actionEvent.getSource();

       if(lastButtonClicked.getId() != null) {
           if (isOperationClick(lastButtonClicked))
               display.setText("");
       }
       if(display.getText().equals("0"))
               setDisplay("");
       setDisplay(display.getText() + buttonClicked.getText());

        lastButtonClicked = buttonClicked;
    }

    public void bttnOperationClick(ActionEvent actionEvent) {
        Button buttonClicked = (Button) actionEvent.getSource();
        if(buttonClicked.getText().equals("c")){
            setDisplay("0");
            setBackupDisplay("");
            operacija1 = "";
            operacija2 = "";
        }
        else if(operacija1.equals("") || operacija1.equals("=")) {
            broj1 = Double.valueOf(display.getText());
            operacija1 = buttonClicked.getText();
            setBackupDisplay(display.getText() + operacija1);
        }
        else {
            broj2 = Double.valueOf(display.getText());
            operacija2 = buttonClicked.getText();
            setDisplay(dajRezultat(operacija1));
            setBackupDisplay(backupDisplay.getText() + dajBrojZaIspis(broj2) + operacija2);
            broj1 = Double.valueOf(display.getText());
            operacija1 = operacija2;
            operacija2 = "";
        }
        lastButtonClicked = buttonClicked;
    }
}
