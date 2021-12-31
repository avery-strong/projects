package pokemon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Pokemon{

	public Pokemon(String name, String type, int count){
		this.name = name;
		this.type = type;
		this.count = count;
	}

	public Pokemon(String buffer){
		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");

		this.name = multiTokenizer.nextToken();
		this.type = multiTokenizer.nextToken();
		this.count = Integer.parseInt(multiTokenizer.nextToken());
	}

	/*********************
			Methods
	*********************/

	public void save(BufferedWriter out) throws IOException{
		out.write("" + name + '|' + type + '|' + count + '\n');
	}

	public void increment(){ ++count; }
	public void decrement(){ --count; }

	public void setCount(int count){ this.count = count; }
	public void setName(String name){ this.name = name; }
	public void setType(String type){ this.type = type; }

	public int getCount(){ return this.count; }
	public String getName(){ return this.name; }
	public String getType(){ return this.type; }

	@Override
	public String toString(){
		String result = name + ": " + type 
			   			+ '\n' 
			   			+ "Count: " + count;
		return result;
	}

	/*********************
			Attributes
	*********************/

	private String name;
	private String type;
	private int count;
}