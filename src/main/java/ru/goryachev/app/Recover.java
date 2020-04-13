package ru.goryachev.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Recover {

    public HashMap<String, Integer> readState () throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("condition.bin");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        HashMap reMap = (HashMap) objIn.readObject();

        objIn.close();

        return reMap;

    }

}
