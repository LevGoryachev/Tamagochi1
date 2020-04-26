package ru.goryachev.app;

import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class GameAnim extends Pane {

    public void moveToMeal (Animal animal, Pane eatingMeal, double startX, double starY, double finishX, double finishY) {

            Path chaoticPath = new Path();
            chaoticPath.getElements().add(new MoveTo(startX - 200,starY + 50));
            chaoticPath.getElements().add(new LineTo(finishX - 200,finishY));

            PathTransition moveTo = new PathTransition();
            moveTo.setDuration(Duration.millis(3000));
            moveTo.setPath(chaoticPath);
            moveTo.setCycleCount(2);
            moveTo.setAutoReverse(true);
            moveTo.setNode(animal);
            moveTo.play();

            MealAnim eatenMeal = new MealAnim();
            eatenMeal.removeMeal(eatingMeal);
    }

        public void movePlaying (Animal animal, double startX, double starY) {

                Path chaoticPath = new Path();
                chaoticPath.getElements().add(new MoveTo(startX - 200,starY + 50));
                chaoticPath.getElements().add(new LineTo(startX - 300,starY + 60));
                chaoticPath.getElements().add(new LineTo(startX - 50,starY + 150));
                chaoticPath.getElements().add(new LineTo(startX + 100,starY + 50));
                chaoticPath.getElements().add(new LineTo(startX - 0,starY + 20));
                chaoticPath.getElements().add(new LineTo(startX - 250,starY + 60));
                chaoticPath.getElements().add(new LineTo(startX - 200,starY + 50));

                PathTransition moveTo = new PathTransition();
                moveTo.setDuration(Duration.millis(5000));
                moveTo.setPath(chaoticPath);
                moveTo.setCycleCount(1);
                moveTo.setAutoReverse(true);
                moveTo.setNode(animal);
                moveTo.play();
        }
}
