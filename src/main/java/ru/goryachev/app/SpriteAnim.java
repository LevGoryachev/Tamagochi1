package ru.goryachev.app;

import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnim extends Transition {

    private final ImageView imageView;
    private final int count; //кол-во кадров
    private final int columns;
    private final int offSetX;
    private final int offSetY;
    private final int width;
    private final int height;

    public SpriteAnim(ImageView imageView, Duration duration, int count, int columns, int offSetX, int offSetY, int width, int height) {
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
    }


    @Override
    protected void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count -1);
        final int x = (index % columns) * width +offSetX;
        final int y = (index / columns) * height +offSetY;
        imageView.setViewport(new Rectangle2D(x, y, width, height));

    }
}
