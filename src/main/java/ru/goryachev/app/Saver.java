package ru.goryachev.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Saver implements Serializable {


    public void writeState (int animalNo, int mood, long timePoint) throws IOException {

        Params params = new Params(animalNo, mood, timePoint);

        FileOutputStream fileOut = new FileOutputStream("condition.bin");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(params);
        objOut.close();
    }

    public void dropState () throws IOException {

        int animalNo = 0;
        int mood = 0;
        long timePoint = 0;

        Params params = new Params(animalNo, mood, timePoint);

        FileOutputStream fileOut = new FileOutputStream("condition.bin");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(params);
        objOut.close();
    }

}
