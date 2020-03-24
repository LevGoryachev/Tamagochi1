package ru.goryachev.app;


import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;


public class GameAnim extends Pane {


    public void moveToMeal (Animal animal, Pane eatingMeal, double startX, double starY, double finishX, double finishY) throws InterruptedException {
            Path chaoticPath = new Path();
            chaoticPath.getElements().add(new MoveTo(startX - 200,starY));
            chaoticPath.getElements().add(new LineTo(finishX - 200,finishY));

            PathTransition trans = new PathTransition();
            trans.setDuration(Duration.millis(3000));
            trans.setPath(chaoticPath);
            trans.setCycleCount(2);
            trans.setAutoReverse(true);
            trans.setNode(animal);
            trans.play();


            /*ActionListener taskPerformer = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                            eatingMeal.getChildren().clear();
                    }
            };

            Timer t = new Timer(600, taskPerformer);
            t.start;*/

    }



}
