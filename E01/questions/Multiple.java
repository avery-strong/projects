package questions;

import java.util.StringTokenizer;

public class Multiple extends Question{
	public Multiple(String question, String answers, Character correctAns){
		super(question, answers, correctAns);

		StringTokenizer multiTokenizer = new StringTokenizer(answers, "|");

		for(int i = 0; i < 4; i++){
			this.ans_array[i] = multiTokenizer.nextToken();
		}
	}
	@Override
	public String toString(){
		System.out.println(this.question);

		for(int i = 0; i < ans_array.length; i++){
			System.out.print(
				"\n"
				+ "        "
				+ (char)(65 + i)
				+ ". "
				+ ans_array[i]);
		}
		return "";
	}

	private String[] ans_array = new String[4];
}