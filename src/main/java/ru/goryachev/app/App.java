package ru.goryachev.app;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class App extends Application {

	
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("run for test");
          
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/playing.fxml"));
        Parent root = (Parent)loader.load();
        PlayController controller = (PlayController)loader.getController();
        
        		
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


