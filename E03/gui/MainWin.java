package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.Box;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import exam.Exam;
import exam.Multiple;
import exam.MultiQuestions;
import exam.Question;
import exam.Vocabulary;
import exam.VocabQuestions;


public class MainWin extends JFrame{

	/****************************************************
						Constructor
    ****************************************************/

	public MainWin(String title){
		super(title);
		exam = new Exam(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		fileName = new File("untitled.exam");
		
		/****************************
					Menu
    	****************************/

		JMenuBar menuBar = new JMenuBar();

		JMenu jFile = new JMenu("File");

		JMenuItem jNew    = new JMenuItem("New");
		JMenuItem jOpen   = new JMenuItem("Open");
		JMenuItem jSave   = new JMenuItem("Save");
		JMenuItem jSaveAs = new JMenuItem("Save As");
		JMenuItem jQuit   = new JMenuItem("Quit");

		JMenu jView = new JMenu("View");
		JMenuItem jGrade     = new JMenuItem("Grade");
		JMenuItem jGrades    = new JMenuItem("Grades");
		JMenuItem jQuestions = new JMenuItem("Questions");

		JMenu jPractice = new JMenu("Practice");
		JMenuItem jVocab    = new JMenuItem("Vocabulary");
		JMenuItem jMultiple = new JMenuItem("Multiple Choice");

		jFile.add(jNew);					// File
		jFile.add(jOpen);					// File
		jFile.add(jSave);					// File
		jFile.add(jSaveAs);					// File
		jFile.add(jQuit);					// File

		jView.add(jGrade);					// View
		jView.add(jGrades);					// View
		jView.add(jQuestions);				// View

		jPractice.add(jVocab);				// Practice
		jPractice.add(jMultiple);			// Practice


		//jNew   .addActionListener(event -> onNewClick());
		//jSave  .addActionListener(event -> onSaveClick());
		//jSaveAs.addActionListener(event -> onSaveAsClick());
		//jOpen  .addActionListener(event -> onOpenClick());

		//jQuestions.addActionListener(event -> onViewQuestionClick());
		jGrade    .addActionListener(event -> onGradeClick());

		jVocab   .addActionListener(event -> onVocabClick());
		jMultiple.addActionListener(event -> onMultipleClick());

		menuBar.add(jFile);
		menuBar.add(jView);
		menuBar.add(jPractice);

		setJMenuBar(menuBar);

		/****************************
					Data
    	****************************/

    	data = new JLabel();
    	data.setFont(new Font("Arial", Font.BOLD, 14));

    	String openingMessage = "Welcome to your " + title + " Exam Practice" 
    				 + "\n\n"
    				 + "Click either the Vocab icon or navigate to \"Practice > Test\" to test your Vocabulary knowledge."
    				 + '\n'
    				 + "Click either the Multiple Choice icon or navigate to \"Practice > Multiple Choice\" to test your Multiple Choice knowledge."
    				 + '\n'
    				 + "If you would like to see the results of your grade click the grade icon or navigate to \"View > Grade.\""
    				 + "\n\n"
    				 + "Good luck in all your endeavors!";

    	data.setText("<html><body style=\"word-wrap: break-word\">" + openingMessage.replaceAll("<","&lt;")
                                			  .replaceAll(">", "&gt;")
                                			  .replaceAll("\n", "<br/>")
                                			  + "</body></html>");



    	JScrollPane scrollPane = new JScrollPane(data);
    	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    	add(Box.createHorizontalStrut(20), BorderLayout.WEST);
    	add(scrollPane, BorderLayout.CENTER);

    	/****************************
				Visibility
    	****************************/

    	setVisible(true);		//Make our JFrame visible
	}

	/************************************************
                    File ActionListeners
    ************************************************/

    protected void onNewClick(){
    }
    
    protected void onSaveClick(){
    	try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
    		exam.save(bw);

    		for(int i = 0; i < exam.numberOfVocab(); i++)
    			exam.getVocabQuestion(i).save(bw);

    		for(int i = 0; i < exam.numberOfMultiple(); i++)
    			exam.getMultipleQuestion(i).save(bw);

    		bw.write("" + "end file" + '\n');
    	}catch(Exception e){
    		System.out.println("Shits fucked");
    	}
    }

    protected void onSaveAsClick(){
    	final JFileChooser fc = new JFileChooser(fileName);
    	FileFilter examFiles = new FileNameExtensionFilter("Exam files", "exam");
    	fc.addChoosableFileFilter(examFiles);
    	fc.setFileFilter(examFiles);

    	int result = fc.showSaveDialog(this);
    	if(result == JFileChooser.APPROVE_OPTION){
    		fileName = fc.getSelectedFile();
    		if(!fileName.getAbsolutePath().endsWith(".exam"))
    			fileName = new File(fileName.getAbsolutePath());
    		onSaveClick();
    	}
    }
 
    protected void onOpenClick(){
    	final JFileChooser fc = new JFileChooser(fileName);
    	FileFilter examFiles = new FileNameExtensionFilter("EXAM files", "exam");
    	fc.addChoosableFileFilter(examFiles);
    	fc.setFileFilter(examFiles);

    	int result = fc.showOpenDialog(this);
    	if(result  == JFileChooser.APPROVE_OPTION){
    		fileName = fc.getSelectedFile();
    		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
    			String buffer = br.readLine();

    			exam = new Exam(buffer, br);

    			buffer = br.readLine();

    			while(!buffer.equals("end file")){
    				StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");

    				String token = multiTokenizer.nextToken();

    				if(token.equals("Vocabulary"))
    					exam.addVocab(new Vocabulary(buffer, br));
    				
    				if(token.equals("Multiple Choice"))
    					exam.addMultiple(new Multiple(buffer, br));
    				
    				buffer = br.readLine();
    			}


    		}catch(Exception e){
    			System.out.println();
    		}
    	}
    }

	/**************************************************
					View ActionListeners
	***************************************************/

	protected void onViewQuestionClick(){
		updateDisplay(Display.EXAM);
	}

	protected void onGradeClick(){
		JLabel label = new JLabel();
		int numQuestions = exam.numberOfVocab() + exam.numberOfMultiple();
		int correct = numQuestions - exam.getIncorrect();

		String message = "Number of Quesions: " + numQuestions
						 + '\n' 
						 + "Correctly Answered: " + correct
						 + '\n' 
						 + "Grade: " + (int)exam.getGrade();

		label.setText("<html><body style=\"word-wrap: break-word\">" 
					 + message.replaceAll("<","&lt;")
                        .replaceAll(">", "&gt;")
                        .replaceAll("\n", "<br/>")
                     	+ "</body></html>");

		int result = JOptionPane.showConfirmDialog(
			this,
			label, 
			"Your Grade",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE);

		if(result != JOptionPane.OK_OPTION) return;
	}

	/**************************************************
					Practice ActionListeners
	***************************************************/

	protected void onVocabClick(){
		vocab();

		prompt =  new JLabel();
		for(int i = 0; i < exam.numberOfVocab(); i++){
			try{
				JPanel panel  = new JPanel(new BorderLayout());
				JPanel north  = new JPanel(new BorderLayout());
				JPanel center = new JPanel(new BorderLayout());
				JPanel south  = new JPanel(new BorderLayout());
				
				JLabel question  = new JLabel("<html>" + i + ". " + exam.getVocabQuestion(i).toString() + "</html>");
				objectAnswers = listVocab.toArray();
				JComboBox box = new JComboBox(objectAnswers);
	
				north .add(question, BorderLayout.NORTH);
				center.add(box, BorderLayout.NORTH);
				
				panel.add(question, BorderLayout.NORTH);
				panel.add(center, BorderLayout.CENTER);
				south.add(prompt, BorderLayout.NORTH );

				Object[] objects = {
					panel,
					south,
				};
				
				int result = JOptionPane.showConfirmDialog(
					this,
					objects,
					"Final Exam",
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);


				if(result != JOptionPane.OK_OPTION){
					for(int j = 0; j < listVocab.size(); j++)
						exam.incrementIncorrect();

					return;
				}

				// If ok was chosen and answered correct
				if(result == JOptionPane.OK_OPTION){
					listVocab.remove(box.getSelectedItem().toString());
					prompt.setText("");
				}

				// If answered incorrectly
				if(!checkAnswer(exam.getVocabQuestion(i).getAnswer(), box.getSelectedItem().toString()) && result == JOptionPane.OK_OPTION){
					String correctAnswer = "";
					for(int j = 0; j < exam.numberOfVocab(); j++){
						if(exam.getVocabQuestion(i).toString().equals(exam.getVocabQuestion(j).toString())){
							correctAnswer = exam.getVocabQuestion(j).getAnswer();
						}
					}
					throw new Exception("Incorrect" + '\n' + "Answer: " + correctAnswer);
				}

			}catch(Exception e){
				prompt.setText("<html>" + e.getMessage()
										  .replaceAll("<","&lt;")
                                 		  .replaceAll(">", "&gt;")
                                 		  .replaceAll("\n", "<br/>")
                              			  + "</html>");
			}
		}
	}

	protected void onMultipleClick(){
		multiple();

		prompt = new JLabel();
		for(int i = 0; i < exam.numberOfMultiple(); i++){
			try{
				JPanel panel  = new JPanel(new BorderLayout());
				JPanel north  = new JPanel(new BorderLayout());
				JPanel center = new JPanel(new BorderLayout());
				JPanel south  = new JPanel(new BorderLayout());

				JLabel question  = new JLabel("<html>" + (i+1) + ". " + exam.getMultipleQuestion(i).toString() + "</html>");
				JList textAnswer = new JList(exam.getMultipleQuestion(i).setAnswers());

				north.add(question, BorderLayout.NORTH);
				north.add(textAnswer, BorderLayout.CENTER);
				center.add(prompt, BorderLayout.NORTH);
				
				panel.add(north, BorderLayout.NORTH);
				panel.add(center, BorderLayout.CENTER);

				Object[] object = {
					panel
				};

				int result = JOptionPane.showConfirmDialog(
					this,
					object,
					"Multiple Choice",
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);

				if(result != JOptionPane.OK_OPTION){
					for(int j = 0; j < exam.getMultiple().size(); j++)
						exam.incrementIncorrect();

					return;
				}  

				if(result == JOptionPane.OK_OPTION) prompt.setText("");
				
				if(!checkAnswer(exam.getMultipleQuestion(i).getCorrect(), textAnswer.getSelectedValue().toString()))
					throw new Exception("Incorrect!");
				
				
			}catch(Exception e){
				prompt.setText("<html>" + e.getMessage()
										   .replaceAll("<","&lt;")
        	                         	   .replaceAll(">", "&gt;")
        	                         	   .replaceAll("\n", "<br/>")
        	                      		   + "</html>");
			}
		}
	}

	/**************************************************
					Vocabulary QUESTIONS
	***************************************************/

	protected void vocab(){
		
		listVocab = new ArrayList<>();

		// Create Vocabulary objects to fill examVocab
		for( VocabQuestions a : VocabQuestions.values() ){
			exam.addVocab(new Vocabulary(a.getQuestion(), a.getAnswer()));

			listVocab.add(a.getAnswer());
		}

		Collections.shuffle(listVocab, new Random());
		Collections.shuffle(exam.getVocab(), new Random());

		System.out.println(exam.numberOfVocab());
	}

    /**************************************************
					Multiple Choice QUESTIONS
	***************************************************/

	protected void multiple(){
		

		// Create Multiple objects to fill examMulti
		for(MultiQuestions a : MultiQuestions.values())
			exam.addMultiple( new Multiple(a.getQuestion(), a.getAnswers(), a.getCorrect()));
	}

	/**************************************************
						Utilities
	***************************************************/

	protected boolean checkAnswer(String correctAnswer, String userAnswer){
		if(userAnswer.equals(correctAnswer)) return true;

		exam.incrementIncorrect();

		return false;
	}

    // Utilities
    private void updateDisplay(Display display) {
        String e = "ERROR: Invalid display request: " + display;
        if(display == Display.EXAM) e = exam.toString();
        //if(display == Display.PEOPLE)  e = exam.peopleToString();
        //if(display == Display.ORDERS)  e = exam.ordersToString();
        data.setText("<html><body style=\"word-wrap: break-word\">" + e.replaceAll("<","&lt;")
                                 .replaceAll(">", "&gt;")
                                 .replaceAll("\n", "<br/>")
                              + "</body></html>");
    }
	
	public static void main(String[] args){
		MainWin myApp = new MainWin("Final");
		myApp.setVisible(true);
	}

	protected enum Display {EXAM};

	private String title;
	private File fileName;
	private JLabel data;
	private JLabel prompt;
	private Exam exam;

	Object[] objectAnswers;
	ArrayList<String> listVocab;
}
