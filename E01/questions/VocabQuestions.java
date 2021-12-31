package questions;

public enum VocabQuestions{
	q01("A derived class inheriting class members from two or more base classes", "multiple inheritance"),
	q02("Specifying a general interface while hiding implementation details", "abstraction"),
	q03("A special class member that creates and initializes an object from the class", "constructor"),
	q04("A named scope", "namespace"),
	q05("A data type that includes a fixed set of constant values called enumerators", "enumerated type"),
	q06("A variable declared in a narrower scope than that of a variable of the same name declared in a broader scope", "shadowing"),
	q07("An expression that, if false, indicates a program error", "assertion"),
	q08("An instance of a class containing a set of encapsulated data and associated methods", "object"),
	q09("A declaration that also fully specifies the entity declared", "definition"),
	q10("A data type that can typically be handled directly by the underlying hardware", "primitive type"),
	q11("A style of programming focused on the use of classes and class hierarchies", "oop"),
	q12("A method that changes the value of a private variable", "setter"),
	q13("An object created to represent an error or other unusual occurrence and then propagated via special mechanisms until caught by special handling code", "exception"),
	q14("The class from which members are inherited", "superclass"),
	q15("A template encapsulating data and code that manipulates it", "class");
	
	private VocabQuestions(String question, String correctAns){
		this.question = question;
		this.correctAns = correctAns;
	}

	public String getQuestion(){ return this.question; }
	public String getCorrect(){ return this.correctAns; }

	private String question;
	private String correctAns;
}