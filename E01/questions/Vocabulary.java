package questions;

public  class Vocabulary extends Question{
	public Vocabulary(String question, String answers, Character correctAns){
		super(question, answers, correctAns);
	}
	public Vocabulary(String question, String correctAns){
		super(question, correctAns);
	}
	@Override
	public String toString(){ return this.question; }
}

/*
	Concept I'm having trouble with

	I want to pass a word list that has the answer choices into 
	Vocabulary class but I dont not want to pass to every object
	created. Feels like I should just print the enumerated type
	in Exam.java instead. vocabAns is where I planned to store but
	no longer certain.

*/