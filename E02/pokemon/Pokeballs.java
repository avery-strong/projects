package pokemon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Pokeballs{
	public Pokeballs(String name){
		this.trainerName = name;
		this.pokedex = new ArrayList<>();
	}

	public Pokeballs(BufferedReader in) throws IOException{
		this.trainerName = in.readLine();
		this.pokedex = new ArrayList<>();
	}

	public void save(BufferedWriter out) throws IOException{
		out.write("" + trainerName + "\n");
	}

	public void addPokemon(Pokemon p){
		pokedex.add(p);
	}

	public int numberOfBalls(){ // lol
		return pokedex.size();
	}

	public Pokemon getPokemon(int n){
		return pokedex.get(n);
	}

	@Override
	public String toString(){
		String result = trainerName + "\n";
		for(int i = 0; i < pokedex.size(); i++)
			result += pokedex.get(i) + "\n";
		return result;
	}

	private String trainerName;
	private ArrayList<Pokemon> pokedex;
}