package ru.goryachev.app;

import java.io.*;

public class Recover implements Serializable {

    public Params readState () throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("condition.bin");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Params params = (Params) objIn.readObject();
        objIn.close();
        return params;

    }

}
