package exam;

public enum MultiQuestions{
	q01("For dynamic polymorphism in Java to work,",
	 	"a superclass variable must contain a subclass object with overidden methods|a pointer variable must contain a subclass object|a subclass variable must contain a superclass object with overidden methods|the subclass method must be annotated with @Override",
	  	"a superclass variable must contain a subclass object with overidden methods"),
	q02("To advance iterator it ot the next element in a collection, write",
		"next(it)|it.next()|Iterator.next(it)|++it",
		"it.next()"),
	q03("Given class Foo with method void f(String s), to start a new thread running method f with parameter \"Hello, Threads\", write",
		"new Thread(() -> f(\"Hello, Threads\"));|new Thread(new Runnable(f(\"Hello, Threads\"));|new Thread(new Runnable -> f(\"Hello, Threads\"));|new Thread(f(\"Hello, Threads\"));",
		"new Thread(() -> f(\"Hello, Threads\"));"),
	q04("To use a class type with a SortedSet (HashSet) or as the key for a SortedMap (HashMap), override",
		"equals and compareTo|compareTo and toString|clone|equals and hashCode",
		"equals and hashCode"),
	q05("Which of the following is NOT a subclass of interface Collection?",
		"Set|Map|Deque|List",
		"Map"),
	q06("To obtain the value for key \"exam\" in HashMap<String, Double> grades, write",
		"grades.find(\"exam\")|grades[\"exam\"]|grades.get(\"exam\")|grades.key(\"exam\")",
		"grades.get(\"exam\")"),
	q07("For ArrayList v, to obtain an iterator pointing to element v[0], write",
		"v.iterator()|v.begin()|v.first()|new ArrayList.iterator(v)",
		"v.iterator()"),
	q08("To join a running thread name t1 to the current thread, write",
		"t1->join_thread();|join(t1);|t1.join();|this->join_thread(t1);",
		"t1.join();"),
	q09("To remove all elements from ArrayList al, write",
		"for(var e : al) al.remove(e);|al.clear();|al.remove(al)|Any of these will work",
		"Any of these will work"),
	q10("To convert ArrayList<String> strings to an array of String, write",
		"String[] s; for(String v : strings) s.add(v);|al.toArray()|(String[]) al|String[] s = new String[](v for v in strings",
		"al.toArray()"),
	q11("To compile a Java class Mandlebrot that uses threads, use the bash command",
		"javac -classpath Thread Mandelbrot.java|javac +threads Mandelbrot.java|javac -pthread Mandelbrot.java|javac Mandelbrot.java",
		"javac Mandelbrot.java"),
	q12("Which is TRUE about Java lambdas?",
		"A return statement is required|If the value of the lambda expression is the return type, return may be omitted|If no parameters are needed, the parentheses can be omitted|Parameter types, if any, are required",
		"If the value of the lambda expression is the return type, return may be omitted"),
	q13("To constrain a generic type to classes of type Integer or its superclasses, write",
		"void addNumbers(List<? superclass Integer> list)|void addNumbers(List<? extends Integer> list)|void addNumbers(List<? implements Integer> list)|void addNumbers(List<? super Integer> list)",
		"void addNumbers(List<? super Integer> list)"),
	q14("A ListIterator is like an Iterator except",
		"ListIterator is bidirectional and includes a previous() method, among others|ListIterator works with Map (HashedMap)|ListIterator is another name for Iterator - they are the same|ListIterator works with a List (LinkedList)",
		"ListIterator is bidirectional and includes a previous() method, among others"),
	q15("Which is true about Java generics?",
		"Generics may be declared with only a single generic type|Generics must be defined in the Java Standard Library|Generics are abstract|Generics may only be instanced using primitive generic types",
		"Generics are abstract"),
	q16("Which of these types is defined as a generic?",
		"void|ArrayList|Thread|Int",
		"ArrayList"),
	q17("To sort an ArrayList al, write",
		"al.sort();|ArrayList<> alSorted = al.sort();|ArrayList.sort(al);|Collections.sort(al);",
		"Collections.sort(al);"),
	q18("Which method in class Super could be polymorphically called in its derived classes?",
		"void bar()|@Override public void bar()|private void bar()|All of the above",
		"All of the above"),
	q19("Java allows generics to be defined as classes or",
		"enums|methods|variables|interfaces",
		"methods"),
	q20("Thread.sleep(10) will",
		"pause the current thread for 10 or more milliseconds|join the current thread to the main thread in about 10 milliseconds|pause the current thread for exactly 10 milliseconds|create a new thread in under 10 milliseconds",
		"pause the current thread for 10 or more milliseconds");

	private MultiQuestions(String question, String answers, String correct){ 
		this.question = question; 
		this.answers = answers;
		this.correct = correct;
	}
	public String getQuestion(){ return this.question; }
	public String getAnswers(){ return this.answers; }
	public String getCorrect(){ return this.correct; }

	private String question;
	private String answers;
	private String correct;
}