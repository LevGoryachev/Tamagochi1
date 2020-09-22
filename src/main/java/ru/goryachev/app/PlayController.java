package ru.goryachev.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import ru.goryachev.app.model.AnimalModel;
import ru.goryachev.app.model.MealModelling;
import ru.goryachev.app.model.MoodAdjuster;

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
    private VBox mainScene;

    @FXML
    private Pane paneNodeAnim;

    @FXML
    private Pane paneNodeApple;

    @FXML
    private Pane paneNodeSeaweed;

    @FXML
    private Pane paneNodeSausage;
    
    @FXML
    private Button choiceContinue;

    @FXML
    private Button choiceReset;
        

   // @FXML
   // public TextField userTxt = new TextField();

    private AnimalModel animalModel;
    private MealModelling mealModel;
    private MoodAdjuster moodAdjuster;
            
	private int animalNumber;
    private int mood;
    private long timePoint;
    
    private int mealChosen;
    
    private long timeEat;
    private Image img;
    private ImageView imagV;
    //private MoodReg moodAdjuster;

    //public static final long STARTDELAY = 10000;//wont need

    //private SceneSwitcher scSwitcher = new SceneSwitcher();
    
    SceneSwitcher scSwitcher = new SceneSwitcher();
    
    Saver saver = new Saver();
    
    private void changeBtnsForPlayField () {

        //Buttons for Welcome screen, hide animal buttons
        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        pickTurtle.setVisible(false);
        pickDog.setVisible(false);

        //Buttons for choice: continue or reset
        choiceContinue.setVisible(false);
        choiceReset.setVisible(false);
        
        //Buttons for Play screen, show food and play buttons
        playFun.setVisible(true);
        feedWApple.setVisible(true);
        feedWSeaweed.setVisible(true);
        feedWSausage.setVisible(true);
    }
    
    private void changeBtnsForContinue () {
    	
    	//Buttons for Welcome screen, hide animal buttons
        pickHedgehog.setVisible(false);
        pickCat.setVisible(false);
        pickTurtle.setVisible(false);
        pickDog.setVisible(false);
        
        //Buttons for choice: continue or reset
        choiceContinue.setVisible(true);
        choiceReset.setVisible(true);
    }
    
    
    
    //animals
    @FXML
    private void startHedgehog() throws IOException {
    	this.animalNumber = 1; //set an animal for game
    	animalModel.createAnimal(animalNumber);
    	this.img = animalModel.getImg();
    	this.imagV = animalModel.getImagV();
    	this.mealChosen = animalModel.getMealChosen();
    	paneNodeAnim.getChildren().add(animalModel.getAnimalAnimator());
       	moodAdjuster.setPaneMeal(paneNodeApple);//set a meal which this animal eats
       	moodAdjuster.decrTimeByTime(animalNumber, mood, paneNodeAnim, scSwitcher, img, imagV, choiceReset);//set behavior
        scSwitcher.sceneSwitch(mainScene);
    	changeBtnsForPlayField();
    }

    @FXML
    private void startCat() throws IOException {
    	this.animalNumber = 2; //set an animal for game
    	animalModel.createAnimal(animalNumber);
    	this.img = animalModel.getImg();
    	this.imagV = animalModel.getImagV();
    	this.mealChosen = animalModel.getMealChosen();
    	paneNodeAnim.getChildren().add(animalModel.getAnimalAnimator());
       	moodAdjuster.setPaneMeal(paneNodeSausage);//set a meal which this animal eats
       	moodAdjuster.decrTimeByTime(animalNumber, mood, paneNodeAnim, scSwitcher, img, imagV, choiceReset);//set behavior
        scSwitcher.sceneSwitch(mainScene);
    	changeBtnsForPlayField();
    }

    @FXML
    private void startTurtle() throws IOException {
    	this.animalNumber = 3; //set an animal for game
    	animalModel.createAnimal(animalNumber);
    	this.img = animalModel.getImg();
    	this.imagV = animalModel.getImagV();
    	this.mealChosen = animalModel.getMealChosen();
    	paneNodeAnim.getChildren().add(animalModel.getAnimalAnimator());
       	moodAdjuster.setPaneMeal(paneNodeSeaweed);//set a meal which this animal eats
       	moodAdjuster.decrTimeByTime(animalNumber, mood, paneNodeAnim, scSwitcher, img, imagV, choiceReset);//set behavior
        scSwitcher.sceneSwitch(mainScene);
    	changeBtnsForPlayField();
    }

    @FXML
    private void startDog() throws IOException {
    	this.animalNumber = 4; //set an animal for game
    	animalModel.createAnimal(animalNumber);
    	this.img = animalModel.getImg();
    	this.imagV = animalModel.getImagV();
    	this.mealChosen = animalModel.getMealChosen();
    	paneNodeAnim.getChildren().add(animalModel.getAnimalAnimator());
       	moodAdjuster.setPaneMeal(paneNodeSausage);//set a meal which this animal eats
       	moodAdjuster.decrTimeByTime(animalNumber, mood, paneNodeAnim, scSwitcher, img, imagV, choiceReset);//set behavior
        scSwitcher.sceneSwitch(mainScene);
    	changeBtnsForPlayField();
    }

    
    //playing
    @FXML
    private void playing () {
        if (this.moodAdjuster.getMood() < 440) {
            AnimalAnimator animal = new AnimalAnimator(this.moodAdjuster.getImagV(), this.moodAdjuster.getMood());
            GameAnimator walk = new GameAnimator();
            walk.movePlaying(animal, paneNodeAnim.getLayoutX(), paneNodeAnim.getLayoutY());
            paneNodeAnim.getChildren().add(animal);
        }
    }
    
    //fead
    @FXML
    private void apple() throws IOException {
    	int mealNumber = 1;    	
    	mealModel.createMeal(mealNumber, moodAdjuster, mealChosen);
        paneNodeApple.getChildren().clear();
        paneNodeApple.getChildren().add(mealModel.getImagV());
        if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            // check if the meal is appropriate for our animal 
            if (mealNumber == mealChosen) {
                this.moodAdjuster.increaser(animalNumber, paneNodeAnim, paneNodeApple, imagV);
            }
        }
    }

    @FXML
    private void seaweed() throws IOException {

    	int mealNumber = 2;    	
    	mealModel.createMeal(mealNumber, moodAdjuster, mealChosen);
    	paneNodeSeaweed.getChildren().clear();
    	paneNodeSeaweed.getChildren().add(mealModel.getImagV());
    	if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            // check if the meal is appropriate for our animal 
            if (mealNumber == mealChosen) {
                this.moodAdjuster.increaser(animalNumber, paneNodeAnim, paneNodeSeaweed, imagV);
            }
        }
    }

    @FXML
    private void sausage() throws IOException {

    	int mealNumber = 3;    	
    	mealModel.createMeal(mealNumber, moodAdjuster, mealChosen);
    	paneNodeSausage.getChildren().clear();
    	paneNodeSausage.getChildren().add(mealModel.getImagV());
    	if (timeEat <= System.currentTimeMillis()) {
            this.timeEat = System.currentTimeMillis() + 3000; //Set 5500 later

            // check if the meal is appropriate for our animal 
            if (mealNumber == mealChosen) {
                this.moodAdjuster.increaser(animalNumber, paneNodeAnim, paneNodeSausage, imagV);
            }
        }
    }

    //Buttons for choice (continue or reset):
    @FXML
    private void continueGame() throws IOException {
            	
    	animalModel.setMood(mood);
    	animalModel.createAnimal(animalNumber);
    	this.img = animalModel.getImg();
    	this.imagV = animalModel.getImagV();
    	this.mealChosen = animalModel.getMealChosen();
    	paneNodeAnim.getChildren().add(animalModel.getAnimalAnimator());
    	moodAdjuster.setTimePoint(timePoint);
    	moodAdjuster.setPaneMeal(paneNodeApple);//set a meal which this animal eats
       	moodAdjuster.decrTimeByTime(animalNumber, mood, paneNodeAnim, scSwitcher, img, imagV, choiceReset);//set behavior
    	
    	scSwitcher.sceneSwitch(mainScene);
    	changeBtnsForPlayField();
    }
    
    @FXML
    private void resetGame() throws IOException {
    	
    	saver.dropState();
    	
        SceneSwitcher scSwitcher = new SceneSwitcher();
        scSwitcher.sceneReset(choiceReset);
    }
 
    public void setAnimalModel(AnimalModel animalModel) {
		this.animalModel = animalModel;
	}
    
    public void setMealModel(MealModelling mealModel) {
		this.mealModel = mealModel;
	}
        
	public void setMoodAdjuster(MoodAdjuster moodAdjuster) {
		this.moodAdjuster = moodAdjuster;
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
	        if (animalNumber != 0) 
	        	this.changeBtnsForContinue ();
	    }
        
}


