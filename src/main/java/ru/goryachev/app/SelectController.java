package ru.goryachev.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SelectController {

    @FXML
    private void startHedgehog (ActionEvent event){
        System.out.println("button Hedgehog");
    }

    @FXML
    private void startCat (ActionEvent event){
        System.out.println("button cat");
    }

}
