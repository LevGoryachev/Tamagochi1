package ru.goryachev.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Recover {

    public int readState () throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("condition.bin");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        int newNo = (int) objIn.readObject();
        objIn.close();
        return newNo;

    }

}
