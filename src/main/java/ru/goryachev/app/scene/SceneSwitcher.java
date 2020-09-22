package ru.goryachev.app.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ru.goryachev.app.animalmodel.AnimalModel;
import ru.goryachev.app.behaviormodel.MoodAdjuster;
import ru.goryachev.app.controller.PlayController;
import ru.goryachev.app.mealmodel.MealModel;

import java.io.IOException;
import java.io.Serializable;

public class SceneSwitcher implements Serializable {

    public void sceneSwitch (VBox mSceneBGround) {

        BackgroundImage mainBGround= new BackgroundImage(new Image("/BackGround.jpg",800,425,true,false),
                BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        mSceneBGround.setBackground(new Background(mainBGround));

    }

    public void sceneReset (Button choiceReset) throws IOException {

        //close old window
        Stage primaryStage = (Stage) choiceReset.getScene().getWindow();
    	primaryStage.close();

        //open new window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/playing.fxml"));
        Parent root = (Parent)loader.load();
        AnimalModel animalModel = new AnimalModel();
        MealModel mealModel = new MealModel();
        MoodAdjuster moodAdjuster = new MoodAdjuster();
        PlayController controller = (PlayController)loader.getController();
        controller.setAnimalModel(animalModel);
        controller.setMealModel(mealModel);
        controller.setMoodAdjuster(moodAdjuster);
 
        primaryStage.setTitle("Tamagochi");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 800, 475));
        primaryStage.show();
    }
}
