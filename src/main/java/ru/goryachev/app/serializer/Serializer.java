package ru.goryachev.app.serializer;

import java.io.IOException;

public interface Serializer {

	public void writeState (Params params) throws IOException;
	
	public void dropState () throws IOException;
	
	public Params readState () throws IOException, ClassNotFoundException;
	
}
