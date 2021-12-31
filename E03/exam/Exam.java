package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam{
	/**************************************************
						Constructors
	**************************************************/
	public Exam(String title){
		this.examVocab = new ArrayList<>();
		this.examMultiple = new ArrayList<>();
		this.title = title;
		this.incorrectCount = 0;
	}

	public Exam(String buffer, BufferedReader in) throws IOException{
		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
		this.examVocab = new ArrayList<>();
		this.title = multiTokenizer.nextToken();
		multiTokenizer.nextToken();			// Parse for our questionCount but we dont need to save
		this.incorrectCount = Integer.parseInt(multiTokenizer.nextToken());
		
	}

	/**************************************************
					Vocabulary Methods
	**************************************************/

	public void addVocab(Vocabulary v){ examVocab.add(v); }
	public Vocabulary getVocabQuestion(int i){ return examVocab.get(i); }
	public ArrayList<Vocabulary> getVocab(){ return examVocab; }
	public int numberOfVocab(){ return examVocab.size(); }


	/**************************************************
				Multiple Choice Methods
	**************************************************/

	public void addMultiple(Multiple m){ examMultiple.add(m); }
	public Multiple getMultipleQuestion(int i){ return examMultiple.get(i); }
	public ArrayList<Multiple> getMultiple(){ return examMultiple; }
	public int numberOfMultiple(){ return examMultiple.size(); }

	/**************************************************
						Setters
	**************************************************/

	public void save(BufferedWriter out) throws IOException{
		out.write("" + title + '|' + examVocab.size() + '|' + incorrectCount + '|' + getGrade() + '\n');
	}

	public void incrementIncorrect(){ incorrectCount++; }


	/**************************************************
						Getters
	**************************************************/

	public int getIncorrect(){ return incorrectCount; }
	

	public double getGrade(){ 
		int numQuestions = examVocab.size() + examMultiple.size();

		if(incorrectCount == 0) return 100;

		if(examVocab.size() == 0 && examMultiple.size() == 0) return 0;

		return (double) 1/100 * (1 - incorrectCount/numQuestions);
	}

	@Override
	public String toString(){
		String result = "";
		for(int i=0; i<examVocab.size(); i++)
			result += examVocab.get(i) + "\n";

		return result;
	}

	/**************************************************
						Attributes
	**************************************************/

	private ArrayList<Vocabulary> examVocab;
	private ArrayList<Multiple> examMultiple;
	private static int incorrectCount;
	private String title;
}