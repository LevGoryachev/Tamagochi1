package ru.goryachev.app;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Animal extends Pane {

    ImageView imgView;
    int count = 2;
    int columns = 1;
    int offsetX = 0;
    int offsetY = 0;
    int width = 200;
    int height = 200;
    int score = 0;
    SpriteAnim animation;

    public Animal (ImageView imgView, int ox) {
        this.offsetX = ox;
        this.imgView = imgView;
        imgView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation = new SpriteAnim(imgView, Duration.millis(2000), count, columns, offsetX, offsetY, width, height);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        getChildren().addAll(imgView);
    }



}
