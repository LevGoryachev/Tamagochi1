package ru.goryachev.app;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Saver implements Serializable {

    public Saver () throws IOException {

    }

    public void writeState (int animalNo) throws IOException {

        FileOutputStream fileOut = new FileOutputStream("condition.bin");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(animalNo);
        objOut.close();
    }

    public void dropState () throws IOException {
        int animalNo = 0;
        FileOutputStream fileOut = new FileOutputStream("condition.bin");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(animalNo);
        objOut.close();
    }

}
