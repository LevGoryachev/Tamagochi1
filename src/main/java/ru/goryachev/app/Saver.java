package ru.goryachev.app;

import javafx.scene.control.TextField;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Saver  {

    public TextField userTxt;


    public Saver (TextField userTxt) throws IOException {
        this.userTxt = userTxt;

    }

    public void saveStatement () throws IOException {
        String strx = userTxt.getText();
        Textor txtx = new Textor(strx);

        FileOutputStream fileOut = new FileOutputStream("saverx");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(txtx);


        objOut.close();
    }

    public void dropStatement () throws IOException {
        String strx = null;
        Textor txtx = new Textor(strx);

        FileOutputStream fileOut = new FileOutputStream("saverx");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(txtx);


        objOut.close();
    }

}
