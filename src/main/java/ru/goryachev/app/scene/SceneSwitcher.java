package ru.goryachev.app.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ru.goryachev.app.animalmodel.AnimalModel;
import ru.goryachev.app.animalmodel.AnimalModelling;
import ru.goryachev.app.behaviormodel.BehaviorModelling;
import ru.goryachev.app.behaviormodel.MoodAdjuster;
import ru.goryachev.app.controller.PlayController;
import ru.goryachev.app.mealmodel.MealModel;
import ru.goryachev.app.mealmodel.MealModelling;
import ru.goryachev.app.serializer.FileSerializer;
import ru.goryachev.app.serializer.Serializer;

import java.io.IOException;

public class SceneSwitcher {

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
        Serializer gameSerializer = new FileSerializer();
        AnimalModelling animalModel = new AnimalModel();
        MealModelling mealModel = new MealModel();
        BehaviorModelling moodAdjuster = new MoodAdjuster();
        PlayController controller = (PlayController)loader.getController();
        controller.setGameSerializer(gameSerializer);
        controller.setAnimalModel(animalModel);
        controller.setMealModel(mealModel);
        controller.setMoodAdjuster(moodAdjuster);
        animalModel.setGameSerializer(gameSerializer);//temporary solution
        moodAdjuster.setGameSerializer(gameSerializer);//temporary solution
 
        primaryStage.setTitle("Tamagochi");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 800, 475));
        primaryStage.show();
    }
}
