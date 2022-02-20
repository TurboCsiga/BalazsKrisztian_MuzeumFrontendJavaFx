package com.example.balazskrisztian_muzeumfrontendjavafx.Controllers;

import com.example.balazskrisztian_muzeumfrontendjavafx.Controller;
import com.example.balazskrisztian_muzeumfrontendjavafx.MuseumApi;
import com.example.balazskrisztian_muzeumfrontendjavafx.Statue;
import javafx.event.ActionEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AddStatueController extends Controller {
    @javafx.fxml.FXML
    private TextField tfPerson;
    @javafx.fxml.FXML
    private Spinner<Integer> spHeight;
    @javafx.fxml.FXML
    private Spinner<Integer> spPrice;


    @javafx.fxml.FXML
    public void addStatueClick(ActionEvent actionEvent) {
        try {
            Statue s = new Statue(
                    0,
                    tfPerson.getText(),
                    spHeight.getValue(),
                    spPrice.getValue());
            Statue created = MuseumApi.addStatue(s);
            if (created != null){
                alert("Szobor hozzáadás sikeres");
            } else {
                alert("Szobor hozzáadás sikeretelen");
            }
        } catch (Exception e) {
            writeError(e);
        }
    }
}