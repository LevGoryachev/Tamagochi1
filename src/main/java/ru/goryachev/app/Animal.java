package ru.goryachev.app;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Animal extends Pane {

    //private final Image IMAGE = new Image(getClass().getResourceAsStream("sprites_hedgehog.png"));
    ImageView imgView;
    int count = 2;
    int columns = 4;
    int offsetX = 10;
    int offsetY = 0;
    int width = 200;
    int height = 200;
    int score = 0;
    SpriteAnim animation;

    public Animal (ImageView imgView) {
        this.imgView = imgView;
        imgView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation = new SpriteAnim(imgView, Duration.millis(3000), count, columns, offsetX, offsetY, width, height);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        getChildren().addAll(imgView);
    }


}
