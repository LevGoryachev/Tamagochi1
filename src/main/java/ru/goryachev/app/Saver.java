package ru.goryachev.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Saver implements Serializable {

    public Saver () throws IOException {
    }

    public void writeState (int animalNo, int mood) throws IOException {

        HashMap<String, Integer> hMap = new HashMap();
        hMap.put("condition", animalNo);
        hMap.put("mood", mood);

        FileOutputStream fileOut = new FileOutputStream("condition.bin");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(hMap);
        objOut.close();
    }

    public void dropState () throws IOException {

        HashMap<String, Integer> hMap = new HashMap();
        hMap.put("condition", 0);
        hMap.put("mood", 0);

        FileOutputStream fileOut = new FileOutputStream("condition.bin");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(hMap);
        objOut.close();
    }

}
