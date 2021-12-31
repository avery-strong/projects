package pokemon;

public class Test{
	public Test(String title){
		pokeballs = new Pokeballs(title);
		pokemon = new Pokemon("Dialga", "Steel/Dragon", 0);
		pokeballs.addPokemon(pokemon);

		String result = "";

		try{
			if(!pokeballs.getTrainerName().equals("Test"))
				result += "Pokeballs Name\n";
			if(!pokemon.getName().equals("Dialga"))
				result += "Pokemon Name\n";
			if(!pokemon.getType().equals("Steel/Dragon"))
				result += "Pokemon type\n";
			if(pokemon.getCount() != 0)
				result += "Pokemon Count\n";

			pokemon.setName("Pikachu");
			pokemon.setType("Electric");
			pokemon.setCount(1);

			if(!pokemon.getName().equals("Pikachu"))
				result += "Pokemon Name\n";
			if(!pokemon.getType().equals("Electric"))
				result += "Pokemon type\n";
			if(pokemon.getCount() != 1)
				result += "Pokemon Count\n";

			throw new Exception(result);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}

	public static void main(String[] args){
		Test myTest = new Test("Test");
	}

	private Pokeballs pokeballs;
	private Pokemon pokemon;
}