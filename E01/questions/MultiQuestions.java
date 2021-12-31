package questions;

public enum MultiQuestions{
	q01("___ Java handles multiple inheritance using", 
		"Aggregation|Polymorphism|Abstract encapsulation|Interfaces", 'd'), 
	q02("___ The main method in class Gradebook can access which method in class Grade?", 
		"private double average()|public double average()|protected double average()|All of the above", 'b'), 
	q03("___ The default destructor for class Account in Java is declared as", 
		"public static destructor Account();|public void ~Account() {};|public destructor Account()|public ~Account() {};", 'd'), 
	q04("___ To compare the value of int a and int b in Java, write", 
		"a == b|a equals b|a.equals(b)|.==(b)", 'a'), 
	q05("___ One advantage of a Java ArrayList over a traditional array is", 
		"The ArrayList size can change dynamically while the array size is fixed when defined|They are the same - ArrayList is just the object-oriented name for a traditional array|The ArrayList is faster than an array|The ArrayList can be used with a for-next loop| but an array cannot", 'a'), 
	q06("___ To throw an exception for bad dates, write", 
		"throw new Exception = \"bad dates\";|throw{Exception \"bad dates\"};|throw new Exception(\"bad dates\");|throw \"bad dates\" as new Exception();", 'c'), 
	q07("___ Of the four arrows shown in the diagram above, the only one NOT a valid UML class relationship is", 
		"The open diamond|The closed arrow|The open arrow|The closed diamond", 'b'), 
	q08("___ In Java, we would convert a String s to all upper case letters using", 
		"for(char c : s) c.toUpperCase();|String.toUpperCase(s);|s.toUpperCase();|toUpperCase(s);", 'c'), 
	q09("___ To invoke target \"clean\" in the local build.xml from the bash shell, type", 
		"ant clean|./clean|ant.clean()|clean", 'a'), 
	q10("___ Once class Animal has been declared, it may be instanced using", 
		"Animal canis(\"Fido\");|Animal canis = new Animal(\"Fido\");|Animal canis = Animal(\"Fido\");|All of these are valid", 'b'), 
	q11("___ In the UML, an abstract method is shown with", 
		"italics|underline|bold|strikethrough", 'a'), 
	q12("___ The Java default constructor for class BigInt can chain to an overloaded constructor using", 
		"this(42);|BigInt(42);|this.BigInt(42);|(Java does not support constructor chaining)", 'a'), 
	q13("___ Java is", 
		"Pass by value|Pass by pointer|Pass by reference|All of the above", 'a'), 
	q14("___ In the UML a class is represented by", 
		"A cloud|A rectangle|A triangle|An elipse", 'b'), 
	q15("___ To print \"Hello world!\" to the console in Java, write", 
		"printf(\"Hello world!\\n\");|System.out.println(\"Hello world!\");|System.console.out(\"Hello world!\\n\");|std::cout << \"Hello world!\\n\";", 'b');

	private MultiQuestions(String question, String answers, Character correctAns){ 
		this.question = question; 
		this.answers = answers;
		this.correctAns = correctAns;
	}
	public String getQuestion(){ return this.question; }
	public String getAnswers(){ return this.answers; }
	public Character getCorrect(){ return this.correctAns; }

	private String question;
	private String answers;
	private Character correctAns;
}