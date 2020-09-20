package ru.goryachev.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import ru.goryachev.app.model.AnimalModel;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;





public class PlayController implements Serializable, Initializable {

    @FXML
    private Button pickHedgehog;

    @FXML
    private Button pickCat;

    @FXML
    private Button pickTurtle;

    @FXML
    private Button pickDog;

    @FXML
    private Button playFun;

    @FXML
    private Button feedWApple;

    @FXML
    private Button feedWSeaweed;

    @FXML
    private Button feedWSausage;

    @FXML
    private Button resetBtn;

    @FXML
    private VBox mainScene;

    @FXML
    private Pane paneNodeAnim;

    @FXML
    private Pane paneNodeApple;

    @FXML
    private Pane paneNodeSeaweed;

    @FXML
    private Pane paneNodeSausage;

   // @FXML
   // public TextField userTxt = new TextField();

    private AnimalModel animalModel;
    
        
    private int animalNumber;
    private int mood;
    private long timePoint;
    private long timeEat;
    private Image img;
    private ImageView imagV;
    private MoodReg moodAdjuster;

    public static final long STARTDELAY = 10000;//wont need

    private SceneSwitcher scSwitcher = new SceneSwitcher();
    Saver saver = new Saver();//wont need
    
    public void setAnimalModel(AnimalModel animalModel) {
		this.animalModel = animalModel;
	}


    private void btnVisibility () {

        //Welcome screen, hide animal buttons
        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        pickTurtle.setVisible(false);
        pickDog.setVisible(false);

        //Play screen, show food and play buttons
        playFun.setVisible(true);
        feedWApple.setVisible(true);
        feedWSeaweed.setVisible(true);
        feedWSausage.setVisible(true);
        //resetBtn.setVisible(true);
    }
    
    //animals
    @FXML
    private void startHedgehog() throws IOException {
        
    	this.animalNumber = 1;
    	animalModel.initAnimal(animalNumber, paneNodeAnim, paneNodeApple, mainScene, resetBtn);
    	this.moodAdjuster = animalModel.getMoodAdjuster();
    	btnVisibility();
    	
    }

    @FXML
    private void startCat() throws IOException {

    	this.animalNumber = 2;
    	animalModel.initAnimal(animalNumber, paneNodeAnim, paneNodeApple, mainScene, resetBtn);
    	this.moodAdjuster = animalModel.getMoodAdjuster();
    	btnVisibility();
    	
    }

    @FXML
    private void startTurtle() throws IOException {

    	this.animalNumber = 3;
    	animalModel.initAnimal(animalNumber, paneNodeAnim, paneNodeApple, mainScene, resetBtn);
    	this.moodAdjuster = animalModel.getMoodAdjuster();
    	btnVisibility();
    	
    }

    @FXML
    private void startDog() throws IOException {

    	this.animalNumber = 4;
    	animalModel.initAnimal(animalNumber, paneNodeAnim, paneNodeApple, mainScene, resetBtn);
    	this.moodAdjuster = animalModel.getMoodAdjuster();
    	btnVisibility();
    	
    }

    
    //playing
    @FXML
    private void playing (ActionEvent event) {
        if (this.moodAdjuster.getMood() < 440) {
            Animal animal = new Animal(this.moodAdjuster.getImagV(), this.moodAdjuster.getMood());
            GameAnim j = new GameAnim();
            j.movePlaying(animal, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY());
            paneNodeAnim.getChildren().add(animal);
        }
    }
    //meal
    @FXML
    private void apple(ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_apple.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(75);
        imagView.setFitWidth(75);
        paneNodeApple.getChildren().clear();
        paneNodeApple.getChildren().add(imagView);
        if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            // the numbers of animals, who eat this meal
            if (animalNumber == 1) {
                this.moodAdjuster.increaser();
            }

        }
        MealAnim expiredMeal = new MealAnim();
        expiredMeal.fadeMeal(imagView);
    }

    @FXML
    private void seaweed(ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_seaweed.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(100);
        imagView.setFitWidth(100);
        paneNodeSeaweed.getChildren().clear();
        paneNodeSeaweed.getChildren().add(imagView);
        if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            // the numbers of animals, who eat this meal
            if (animalNumber == 3) {
                this.moodAdjuster.increaser();
            }
        }
        MealAnim expiredMeal = new MealAnim();
        expiredMeal.fadeMeal(imagView);
    }

    @FXML
    private void sausage(ActionEvent event) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("/meal_sausage.png"));
        ImageView imagView = new ImageView(image);
        imagView.setFitHeight(125);
        imagView.setFitWidth(125);
        paneNodeSausage.getChildren().clear();
        paneNodeSausage.getChildren().add(imagView);
        if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            // the numbers of animals, who eat this meal
            if (animalNumber == 2) {
                this.moodAdjuster.increaser();
            }
            if (animalNumber == 4) {
                this.moodAdjuster.increaser();
            }
        }
        MealAnim expiredMeal = new MealAnim();
        expiredMeal.fadeMeal(imagView);
    }

    // Buttons for checking
    @FXML
    private void resetGame(ActionEvent event) throws IOException {
        SceneSwitcher scSwitcher = new SceneSwitcher();
        scSwitcher.sceneReset(resetBtn);
    }


	public Pane getPaneNodeAnim() {
		return paneNodeAnim;
	}


	public VBox getMainScene() {
		return mainScene;
	}



	 @Override
	    public void initialize(URL url, ResourceBundle resourceBundle) {
	    	
	        try {
	            Recover recover = new Recover();
	            this.animalNumber = recover.readState().getAnimalNo();
	            this.mood = recover.readState().getMood();
	            this.timePoint = recover.readState().getTimePoint();

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Initialize check No " + animalNumber);
	        System.out.println("Initialize TimePoint: " + timePoint);
	        System.out.println("Initialize Mood: " + mood);
	        switch (animalNumber) {
	        
	            case 1:
	                try {
	                    startHedgehog();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            break;

	            case 2:
	                try {
	                    startCat();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            break;
	            
	            case 3:
	                try {
	                    startTurtle();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            break;
	                
	            case 4:
	                try {
	                    startDog();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            break;
	        }

	    }
        
    
    
    
    
   /* 
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
        try {
            Recover recover = new Recover();
            this.animalNumber = recover.readState().getAnimalNo();
            this.mood = recover.readState().getMood();
            this.timePoint = recover.readState().getTimePoint();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Initialize check No " + animalNumber);
        System.out.println("Initialize TimePoint: " + timePoint);
        System.out.println("Initialize Mood: " + mood);
        switch (animalNumber) {
        
            case 1:
                try {
                    startHedgehog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            break;

            case 2:
                try {
                    startCat();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            break;
            
            case 3:
                try {
                    startTurtle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            break;
                
            case 4:
                try {
                    startDog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            break;
        }

    }
  */  

}


