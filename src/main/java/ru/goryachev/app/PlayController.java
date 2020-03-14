package ru.goryachev.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PlayController {

    Image image = new Image(getClass().getResourceAsStream("/sprites_cat.png"));
    ImageView imagView = new ImageView(image);
    Animal animal = new Animal(imagView);

    @FXML
    Pane sp;

    @FXML
    private void setAnimTest (ActionEvent event){
        sp.getChildren().add(animal);
    }

}
