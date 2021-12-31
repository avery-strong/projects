package exam;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import questions.Multiple;
import questions.MultiQuestions;
import questions.Question;
import questions.Vocabulary;
import questions.VocabQuestions;


public class Exam{
	public static void multi(){
		/*
			*********MULTIPLE CHOICE QUESTIONS**********
		*/

		Scanner in = new Scanner(System.in);
		ArrayList<Question> examMulti = new ArrayList<>();

		// Create Multiple objects to fill examMulti
		for(MultiQuestions a : MultiQuestions.values())
			examMulti.add( new Multiple(a.getQuestion(), a.getAnswers(), a.getCorrect()));

		// Print our question, ask for user answer, and print result
		// Feel like this could all be done in the for loop above as well
		for(int i = 0; i < examMulti.size(); i++){
			System.out.print("\n" + (i + 1) + ". ");
			System.out.print(examMulti.get(i).toString() 
							+ "\n\nYour answer: ");

			Character c01 = Character.toLowerCase(examMulti.get(i).getCorrect());
			Character c02 = Character.toLowerCase(in.next().charAt(0));

			boolean equivalent = c01.equals(c02);

			try{
				if(equivalent == false)
					throw new IllegalArgumentException("Invalid Answer");
			}catch(Exception e){
				System.err.println(e.getMessage());
				System.exit(-1);
			}

			System.out.println("\nCorrect!");
		}
	}

	public static void vocab(){
		/*
			*********Vocabulary QUESTIONS**********
		*/
		Scanner in = new Scanner(System.in);
		ArrayList<Question> examVocab = new ArrayList<>();

		// Print our word bank to choose from
		// Will add this feature in later

		// Create Vocabulary objects to fill examVocab
		for(VocabQuestions a : VocabQuestions.values())
			examVocab.add( new Vocabulary(a.getQuestion(), a.getCorrect()));
		
		// print our question, ask user for answer, and print result
		for(int i = 0; i < examVocab.size(); i++){
			System.out.println((i + 1) + ". " + examVocab.get(i).toString() + "?");

			System.out.println("\nYour answer: ");


			String s01 = examVocab.get(i).getCorrectStr();
			String s02 = in.nextLine();
			s01.toLowerCase();
			s02.toLowerCase();

			boolean equivalent = s01.equals(s02);

			try{
				if(equivalent == false)
					throw new IllegalArgumentException("Invalid Answer");
			}catch(Exception e){
				System.err.println(e.getMessage());
				System.exit(-1);
			}

			System.out.println("\nCorrect!");

		}
	}
	
	public static void main(String[] args){
		Exam exam = new Exam();
		exam.multi();
		exam.vocab();
	}
}
