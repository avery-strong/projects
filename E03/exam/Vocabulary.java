package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Vocabulary extends Question{
	public Vocabulary(String question, String answer){
		super(question, answer);
	}

	public Vocabulary(String buffer, BufferedReader in) throws IOException{
		super(buffer, in);
	}

	@Override
	public void save(BufferedWriter out) throws IOException{
		out.write("" + "Vocabulary" + "|" + question + '|' + answer + '\n');
	}

	@Override
	public String toString(){ return this.question; }
}
