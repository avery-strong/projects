package pokemon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pokeballs{
	public Pokeballs(String trainerName){ 
		this.trainerName = trainerName; 
		team = new ArrayList<>();
	}

	// BufferedReader is entirely unnecessary but used for different parameters for constructors
	public Pokeballs(String buffer, BufferedReader in){			
		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
		this.trainerName = multiTokenizer.nextToken();
		// We wont actually read in the ArrayList size 

		team = new ArrayList<>();
	}

	/*********************
			Methods
	*********************/

	public void save(BufferedWriter out) throws IOException{
		out.write("" + trainerName + '|' + team.size() + '\n');
	}

	public void addPokemon(Pokemon pokemon){ team.add(pokemon); }

	public String getTrainerName(){ return trainerName; }
	public Pokemon getPokemon(int i){ return team.get(i); }
	public int numberOfPokemon(){ return team.size(); }

	/*********************
			Attributes
	*********************/

	private String trainerName;
	ArrayList<Pokemon> team;
}