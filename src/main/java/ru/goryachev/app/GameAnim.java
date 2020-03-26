package ru.goryachev.app;


import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;


public class GameAnim extends Pane {


    public void moveToMeal (Animal animal, ImageView eatingMeal, double startX, double starY, double finishX, double finishY) {

            Path chaoticPath = new Path();
            chaoticPath.getElements().add(new MoveTo(startX - 200,starY));
            chaoticPath.getElements().add(new LineTo(finishX - 200,finishY));

            PathTransition moveTo = new PathTransition();
            moveTo.setDuration(Duration.millis(3000));
            moveTo.setPath(chaoticPath);
            moveTo.setCycleCount(2);
            moveTo.setAutoReverse(true);
            moveTo.setNode(animal);
            moveTo.play();

            MealAnim removeMeal = new MealAnim();
            removeMeal.clearMeal(eatingMeal);
    }

}
