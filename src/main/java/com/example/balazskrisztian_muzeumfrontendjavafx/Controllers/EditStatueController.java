package com.example.balazskrisztian_muzeumfrontendjavafx.Controllers;

import com.example.balazskrisztian_muzeumfrontendjavafx.Controller;
import com.example.balazskrisztian_muzeumfrontendjavafx.MuseumApi;
import com.example.balazskrisztian_muzeumfrontendjavafx.Statue;
import javafx.event.ActionEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditStatueController extends Controller {
    @javafx.fxml.FXML
    private TextField tfPerson;
    @javafx.fxml.FXML
    private Spinner<Integer> spPrice;
    @javafx.fxml.FXML
    private Spinner<Integer> spHeight;
    private Statue toEdit;

    @javafx.fxml.FXML
    public void editStatueClick(ActionEvent actionEvent) {
        toEdit.setPerson(tfPerson.getText());
        toEdit.setHeight(spHeight.getValue());
        toEdit.setPrice(spPrice.getValue());

        try {
            Statue edited = MuseumApi.editStatue(toEdit);
            if (edited != null){
                alertWait("Sikeres módosítás");
                this.stage.close();
            } else {
                alert("Sikertelen módosítás");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Statue getToEdit() {
        return toEdit;
    }

    public void setToEdit(Statue toEdit) {
        this.toEdit = toEdit;
        setInitialValues();
    }

    private void setInitialValues() {
        tfPerson.setText(toEdit.getPerson());
        spHeight.getValueFactory().setValue(toEdit.getHeight());
        spPrice.getValueFactory().setValue(toEdit.getPrice());
    }
}
