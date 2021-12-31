package exam;

public enum VocabQuestions{
	q01("A derived class inheriting class members from two or more base classes", "multiple inheritance"),
	q02("Specifying a general interface while hiding implementation details", "abstraction"),
	q03("A special class member that creates and initializes an object from the class", "constructor"),
	q04("A named scope", "namespace"),
	q05("A data type that includes a fixed set of constant values called enumerators", "enumerated type"),
	q06("A variable declared in a narrower scope than that of a variable of the same name declared in a broader scope", "shadowing"),
	q07("An expression that, if false, indicates a program error", "assertion"),
	q08("An instance of a class containing a set of encapsulated data and associated methods", "Object"),
	q09("A declaration that also fully specifies the entity declared","Definition"),
	q10("A data type that can typically be handled directly by the underlying hardware", "primitive type"),
	q11("A style of programming focused on the use of classes and class hierarchies", "oop"),
	q12("A method that changes the value of a private variable", "setter"),
	q13("An object created to represent an error or other unusual occurrence and then propagated via special mechanisms until caught by special handling code", "exception"),
	q14("The class from which members are inherited", "Superclass"),
	q15("A template encapsulating data and code that manipulates it", "class"),
	q16("The provision of a single interface to multiple derived classes, enabling the same method call to invoke different derived methods to generate different results", "Polymorphism"),
	q17("Reuse and extension of fields and method implementations from another class", "Inheritance"),
	q18("Bundling data and code into a restricted container", "Encapsulation"),
	q19("a reference type containing only constants, method signatures, default methods, static methods, and nested types", "Interface"),
	q20("An encapsulated bundle of data and code (e.g., an instance of a program is a process; an instance of a class is an object)", "Instance"),
	q67("The common mistake of attempting to include far too many features in (typcially) version 2.0, causing catastrophic schedule slips", "Second System Effect"),
	q22("A block of memory associated with a symbolic name that contains a primitive data value or the address of an object instance", "Variable"),
	q23("A short string representing a mathematical, logical, or machine control action", "Operator"),
	q24("A managed memory technique that tracks the number of references to allocated memory, so that the memory can be freed when the count reaches zero", "Refrence Counter"),
	q25("In program that runs in managed memory systems to free unreferenced memory", "Garbage Collector"),
	q26("A class member variable (also called a \"field\")", "Attribute"),
	q27("A special class member that cleans up when an object is deleted (not supported by Java)", "Destructor"),
	q28("A function that manipulates data in a class", "Method"),
	q29("A method that returns the value of a private variable", "Getter"),
	q30("A user interface component should behave as the users expect it to behave", "Principle of Least  Astonishment"),
	q31("The class inheriting members", "Subclass"),
	q32("A class that cannot be instantiated", "Abstract Class"),
	q33("A method declared with no implementation", "Abstract Method"),
	q34("A subclass replacing its superclass’ implementation of a method", "Override"),
	q35("A grouping of related types providing access protection and namespace management", "Package"),
	q36("A statement that introduces a name with an associated type into a scope", "Declaration"),
	q37("The process of identifying and specifying subclasses from a base class.", "Specialization"),
	q38("Scratch memory for a thread of execution (in Java, e.g., int i=5;)", "Stack"),
	q39("Memory shared by all threads of execution for dynamic allocation (in Java e.g., Foo f = new Foo();)", "Heap"),
	q40("Memory for declarations outside of any class or function scope", "Global"),
	q41("Read-only memory for machine instructions", "Code"),
	q42("A procedure for solving a specific problem, expressed in terms of an ordered set of actions to execute", "Algorithm"),
	q43("A Java construct representing a method or class in terms of generic types", "Generic"),
	q44("Writing algorithms in terms of types that are specified as parameters during instantiation or invocation", "Generic Programming"),
	q45("A standard library abstraction for objects referring to elements of a container", "Iterator"),
	q46("Performing 2 or more algorithms (as it were) simultaneously", "Concurrency"),
	q47("A self-contained execution environment including its own memory space", "Process"),
	q48("An independent path of execution within a process, running concurrently (as it appears) with other threads within a shared memory space", "Thread"),
	q49("An algorithm that can be paused while executing, and then safely executed by a different thread", "Reentrant"),
	q50("(contraction of \"mutual exclusion\") An object that prevents two properly written threads from concurrently accessing a shared resource", "Mutex"),
	q51("The ability to control the access of multiple threads to any shared resource", "Synchronized"),
	q52("Code for which specified assertions are guaranteed to be true (often, a class in which attributes cannot change after instantiation)", "Invariant"),
	q53("Ensuring that a program operates on clean, correct and useful data", "Data Validation"),
	q54("Algorithmically enforceable constraints on the correctness, meaningfulness, and security of input data", "Validation Rules"),
	q55("The task of keeping a system consisting of many versions well organized", "Version Control"),
	q56("A second distinct development path within the same organization and often within the same version control system", "Branch"),
	q57("A second distinct and independent development path undertaken (often by a different organization) to create a unique product", "Fork"),
	q58("A reference point in a version control system, using indicating completion and approval of a product release and sometimes used to support a fork", "Baseline"),
	q59("The standard visual modeling language used to describe, specify, design, and document the structure and behavior of object-oriented systems", "Unified Modeling Language (UML)"),
	q60("Prioritizing individuals and interactions, frequent delivery of working software, customer collaboration, and flexible response to change", "Agile Process"),
	q61("Separating software development into long, discrete phases such as Requirements, Design, Implementation, Verification, and Validation", "Waterfall Process"),
	q62("Defines the inheritance relationships between a set of classes", "Class Hierarchy"),
	q63("A collection of classes designed to be used together efficiently", "Class Library"),
	q64("The process of extracting shared characteristics from two or more classes, and combining them into a generalized base class.", "Generalization");
	
	
	private VocabQuestions(String question, String answer){
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion(){ return this.question; }
	public String getAnswer(){ return this.answer; }

	private String question;
	private String answer;
}