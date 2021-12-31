package pokemon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Pokemon{
	public Pokemon(String name){
		this.name = name;
	}

	public Pokemon(BufferedReader in) throws IOException{
		this.name = in.readLine();
	} 

	public void save(BufferedWriter out) throws IOException{
		out.write("" + name + "\n");
	}

	@Override
	public String toString(){
		return name;
	}

	protected String name;
}