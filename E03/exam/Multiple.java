package exam;

import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Multiple extends Question{
	public Multiple(String question, String answers, String correct){
		super(question, answers, correct);

		StringTokenizer multiTokenizer = new StringTokenizer(answers, "|");
	}

	public Multiple(String buffer, BufferedReader in) throws IOException{
		super(buffer, in);

		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
 		
 		multiTokenizer.nextToken();							// Read Multiple Choice
		multiTokenizer.nextToken();							// Read Question		
		multiTokenizer.nextToken();							// Read Answer
		this.correct = multiTokenizer.nextToken();
	}

	@Override
	public void save(BufferedWriter out) throws IOException{
		out.write("" + "Multiple Choice" + "|" + question + '|' + answer + '|' + correct + '\n');
	}

	public String[] setAnswers(){
		String[] results = new String[4];
		StringTokenizer multiTokenizer = new StringTokenizer(this.answer, "|");

		results[0] = multiTokenizer.nextToken();
		results[1] = multiTokenizer.nextToken();
		results[2] = multiTokenizer.nextToken();
		results[3] = multiTokenizer.nextToken();

		return results;
	}

	public String getCorrect(){ return this.correct; }

	@Override
	public String toString(){ return this.question; }
}