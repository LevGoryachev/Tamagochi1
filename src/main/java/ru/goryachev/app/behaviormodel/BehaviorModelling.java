package ru.goryachev.app.behaviormodel;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import ru.goryachev.app.scene.SceneSwitcher;
import ru.goryachev.app.serializer.Serializer;

public interface BehaviorModelling {

	public void increaser(int animalNumber, Pane paneNodeAnim, Pane paneMeal, ImageView imagV) throws IOException;
	
	public void decreaser(int animalNumber, Pane paneNodeAnim, SceneSwitcher scSwitcher,Image img, ImageView imagV, Button choiceReset) throws IOException;
	
	public void increaseByMeal (int animalNumber, Pane paneNodeAnim, Pane paneMeal, ImageView imagV, int mealNumber, int mealChosen);
	
	public void decrTimeByTime (int animalNumber, int mood, Pane paneNodeAnim, SceneSwitcher scSwitcher,Image img, ImageView imagV, Button choiceReset);
	
	
	public void increaseMood() throws IOException;
    
    public void decreaseMood() throws IOException;
        
    public int getMood();

    public ImageView getImagV();
    
    public void setGameSerializer(Serializer gameSerializer);
    
	public void setTimePoint(long timePoint);
	
}
