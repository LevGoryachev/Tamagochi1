package ru.goryachev.app.serializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Recover {

    public Params readState () throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("condition.bin");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Params params = (Params) objIn.readObject();
        objIn.close();
        return params;

    }

}
