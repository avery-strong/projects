package questions;

public abstract class Question{
	public Question(String question, String answers, Character correctAns){
		this.question = question;
		this.answers = answers;
		this.correctAns = correctAns;
	}
	public Question(String question, String correctAnsStr){
		this.question = question;
		this.correctAnsStr = correctAnsStr;
	}
	public String getQuestion(){ return this.question; }
	public Character getCorrect(){ return this.correctAns; }
	public String getCorrectStr(){ return this.correctAnsStr; }
	public String getAnswers(){ return this.answers; }

	protected String question;
	protected Character correctAns;
	protected String correctAnsStr;
	protected String answers;
	
}