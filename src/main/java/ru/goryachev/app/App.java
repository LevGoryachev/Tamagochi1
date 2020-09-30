package ru.goryachev.app;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ru.goryachev.app.animalmodel.AnimalModel;
import ru.goryachev.app.animalmodel.AnimalModelling;
import ru.goryachev.app.behaviormodel.BehaviorModelling;
import ru.goryachev.app.behaviormodel.MoodAdjuster;
import ru.goryachev.app.controller.PlayController;
import ru.goryachev.app.mealmodel.MealModel;
import ru.goryachev.app.mealmodel.MealModelling;
import ru.goryachev.app.serializer.FileSerializer;
import ru.goryachev.app.serializer.Serializer;


public class App extends Application {

		
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("run for test");
          
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

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                
            }
        });

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop is working");


    }

    public static void main(String[] args) {

        launch(args);
     
    }
}


