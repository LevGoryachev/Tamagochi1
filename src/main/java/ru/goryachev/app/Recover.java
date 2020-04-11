package ru.goryachev.app;


import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Recover {


    public void rec (TextField userTxt) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("saverx");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Textor txtx = (Textor) objIn.readObject();
        String newStrX =  txtx.uTxt;
        userTxt.setText(newStrX);
        objIn.close();
    }

}
