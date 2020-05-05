package ru.goryachev.app;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Animal extends Pane {

    private ImageView imgView;
    private int count = 2;
    private int columns = 1;
    private int offsetX = 0;
    private int offsetY = 0;
    private int width = 200;
    private int height = 200;
    private SpriteAnim animation;

    public Animal (ImageView imgView, int ox) {
        this.offsetX = ox;
        this.imgView = imgView;
        imgView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
        animation = new SpriteAnim(imgView, Duration.millis(1000), count, columns, offsetX, offsetY, width, height);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        getChildren().addAll(imgView);
    }

}
