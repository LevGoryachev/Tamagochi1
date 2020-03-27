package ru.goryachev.app;


import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MealAnim {

    public void clearMeal(ImageView meal) {

            FadeTransition removeMeal = new FadeTransition();
            removeMeal.setDuration(Duration.millis(50));
            removeMeal.setDelay(Duration.millis(2000));
            removeMeal.setFromValue(1.0);
            removeMeal.setToValue(0.0);
            removeMeal.setNode(meal);
            removeMeal.play();
    }


}
