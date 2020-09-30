package ru.goryachev.app.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileSerializer implements Serializer {
		
	@Override
	public void writeState(Params params) throws IOException {
			
	    FileOutputStream fileOut = new FileOutputStream("condition.bin");
	    ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
	    objOut.writeObject(params);
	    objOut.close();
	    System.out.println("SAVED");    
	}

	@Override
	public void dropState() throws IOException {
		
        Params params = new Params(0, 0, 0);
        		
		FileOutputStream fileOut = new FileOutputStream("condition.bin");
	    ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
	    objOut.writeObject(params);
	    objOut.close();
	    System.out.println("DROP SCENE");
	}
	
	@Override
	public Params readState() throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream("condition.bin");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Params params = (Params) objIn.readObject();
        objIn.close();
        return params;
	}
}
