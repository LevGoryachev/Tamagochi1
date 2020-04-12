package ru.goryachev.app;


import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Recover {


    public int rec () throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("saverx");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        int newNo = (int) objIn.readObject();
        objIn.close();
        return newNo;
        //animalNo = newNo;

        //Textor txtx = (Textor) objIn.readObject();
        //String newStrX =  txtx.uTxt;
        //userTxt.setText(newStrX);

    }

}
