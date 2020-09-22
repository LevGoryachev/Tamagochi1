package ru.goryachev.app.mealmodel;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class MealAnimator {

    public void fadeMeal(ImageView meal) {

        FadeTransition removeMeal = new FadeTransition();
            removeMeal.setDuration(Duration.millis(3000));
            removeMeal.setDelay(Duration.millis(8000));
            removeMeal.setFromValue(1.0);
            removeMeal.setToValue(0.0);
            removeMeal.setNode(meal);
            removeMeal.play();
    }

    public void removeMeal(Pane meal) {

        long expiredTime = System.currentTimeMillis() + 2000;

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                if (expiredTime <= System.currentTimeMillis()) {
                    meal.getChildren().clear();
                    this.stop();
                }
            }
        };
        timer.start();
    }
}