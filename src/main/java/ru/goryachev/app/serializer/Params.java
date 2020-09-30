package ru.goryachev.app.serializer;

import java.io.Serializable;

public class Params implements Serializable {

    private int animalNo;
    private int mood;
    private long timePoint;

    public Params (int animalNo, int mood, long timePoint) {
        this.animalNo = animalNo;
        this.mood = mood;
        this.timePoint = timePoint;
    }

    public int getAnimalNo() {
        return animalNo;
    }

    public int getMood() {
        return mood;
    }

    public long getTimePoint() {
        return timePoint;
    }

	public void changeParameters(int animalNo, int mood, long timePoint) {
		this.animalNo = animalNo;
		this.mood = mood;
		this.timePoint = timePoint;
	}
    
    
}
