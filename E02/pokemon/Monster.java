package pokemon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Monster extends Pokemon{
	public Monster(String name, int count){
		super(name);
		this.count = count;
	}

	public Monster(BufferedReader in) throws IOException{
		super(in);
		this.count = Integer.parseInt(in.readLine());
	}
	
	public void save(BufferedWriter out) throws IOException{
		out.write("" + name + "\n");
		out.write("" + count + "\n");
	}

	public void incrementCount(){ count++; }

	public void decrementCount(){ count--; }

	@Override
	public String toString(){
		String result = name;
		result += "\n"
			 + "count: "
			 + Integer.toString(count);

		return result;
	}

	protected int count;
}