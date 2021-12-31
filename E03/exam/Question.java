package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

import java.util.StringTokenizer;

public abstract class Question{

	/**************************************************
						Constructors
	**************************************************/

	// Multiple Choice
	public Question(String question, String answer, String correct){
		this.question = question;
		this.answer = answer;					// Answer is going to be a string of multiple answers to be parsed in Multiple constructor
		this.correct = correct;					// Correct is passed from Multi enumerated
	}

	// Vocabulary
	public Question(String question, String answer){
		this.question = question;
		this.answer = answer;
	}

	// Reading
	public Question(String buffer, BufferedReader in) throws IOException{
		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
		this.question = multiTokenizer.nextToken();
		this.answer = multiTokenizer.nextToken();
	}

	public void save(BufferedWriter out) throws IOException{
		out.write("" + question + '|' + answer + '\n');
	}

	public String getAnswer(){ return this.answer; }

	@Override
	public String toString(){ return this.question; }

	/**************************************************
						Attributes
	**************************************************/

	protected String question;
	protected String answer;
	protected String correct;				// Used for multiple Choice
}