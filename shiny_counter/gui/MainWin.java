package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.Font;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import pokemon.Pokeballs;
import pokemon.Pokemon;

public class MainWin extends JFrame{
	
	/************************************************
                        Constructor
    ************************************************/

	public MainWin(String title){
		super(title);
		this.title = title;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		pokeballs = new Pokeballs(title);
		JPanel panel = new JPanel(new BorderLayout());
		fileName = new File("untitled.txt");

		/************************************************
							Menu
        ************************************************/

		JMenuBar menuBar = new JMenuBar();

		JMenu jFile = new JMenu("File");
		JMenuItem jNew    = new JMenuItem("New");
		JMenuItem jOpen   = new JMenuItem("Open");
		JMenuItem jSave   = new JMenuItem("Save");
		JMenuItem jSaveAs = new JMenuItem("Save As");
		JMenuItem jQuit   = new JMenuItem("Quit");

		JMenu jGame = new JMenu("Game");
		JMenuItem jHunt  = new JMenuItem("Hunt");
		JMenuItem jMinus = new JMenuItem("Minus");
		JMenuItem jPlus  = new JMenuItem("Plus");

		JMenu jHelp = new JMenu("Help");
		JMenuItem jAbout = new JMenuItem("About");

		jNew   .addActionListener(event -> onNewClick());			// File
		jOpen  .addActionListener(event -> onOpenClick());			// File
		jSave  .addActionListener(event -> onSaveClick());			// File
		jSaveAs.addActionListener(event -> onSaveAsClick());		// File
		jQuit  .addActionListener(event -> onQuitClick());			// File

		jHunt .addActionListener(event -> onHuntClick());			// Hunt
		jMinus.addActionListener(event -> onMinusClick());			// Hunt
		jPlus .addActionListener(event -> onPlusClick());			// Hunt

		jFile.add(jNew);
		jFile.add(jOpen);
		jFile.add(jSave);
		jFile.add(jSaveAs);
		jFile.add(jQuit);

		jGame.add(jHunt);
		jGame.add(jMinus);
		jGame.add(jPlus);

		jHelp.add(jAbout);

		menuBar.add(jFile);
		menuBar.add(jGame);
		menuBar.add(jHelp);
		
		setJMenuBar(menuBar);

		/************************************************
							Toolbar
        ************************************************/

        JToolBar toolBar = new JToolBar();

        JButton bMinus = new JButton(new ImageIcon("gui/resources/minus.png"));
        JButton bPlus  = new JButton(new ImageIcon("gui/resources/plus.png"));

        bMinus.addActionListener(event -> onMinusClick());
        bPlus.addActionListener(event -> onPlusClick());
        
		toolBar.add(bMinus);
        toolBar.add(bPlus);
        
        getContentPane().add(toolBar, BorderLayout.NORTH);

        /************************************************
							Data
        ************************************************/
		
		dataNorth = new JLabel();
		dataCenter = new JLabel();

		dataNorth.setFont(new Font("Arial", Font.BOLD, 14));
		dataCenter.setFont(new Font("Arial", Font.BOLD, 14));
        
        String openingMessage = "Good Luck Hunting";

        dataNorth.setText("<html>" 
        				+ "<body style=\"word-wrap: break-word\">" 
        					+ openingMessage.replaceAll("<","&lt;")
											.replaceAll(">", "&gt;")
											.replaceAll("\n", "<br/>")
						+ "</body>" 
					+ "</html>");

        panel.add(dataNorth, BorderLayout.NORTH);
        panel.add(dataCenter, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);

        /************************************************
							Visibility
        ************************************************/

        setVisible(true);
	}

	/************************************************
				File Action Listeners
    ************************************************/

	protected void onNewClick(){
		pokeballs = new Pokeballs(title);
		pokemon = new Pokemon("", "", 0);
		dataCenter.setText("");
	}

	protected void onOpenClick(){
		final JFileChooser fc = new JFileChooser(fileName);

		int result = fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			fileName = fc.getSelectedFile();

			try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
				String buffer = br.readLine();
				pokeballs = new Pokeballs(buffer, br);

				buffer = br.readLine();
				while(!buffer.equals("end file")){
					pokemon = new Pokemon(buffer);
					pokeballs.addPokemon(pokemon);
					buffer = br.readLine();
				}

				updateDisplay(Display.POKEMON);

			}catch(Exception e){}
		}
	}

	protected void onSaveClick(){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			pokeballs.save(bw);

			for(int i = 0; i < pokeballs.numberOfPokemon(); i++)
				pokeballs.getPokemon(i).save(bw);

			bw.write("" + "end file");
		}catch(Exception e){}
	}

	protected void onSaveAsClick(){
		final  JFileChooser fc = new JFileChooser(fileName);

		int result = fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			fileName = fc.getSelectedFile();
			onSaveClick();
		}
	}

	protected void onQuitClick(){ dispose(); }

    /************************************************
				Game Action Listeners
    ************************************************/

	protected void onHuntClick(){
		try{
			JPanel panel = new JPanel(new BorderLayout());
			JPanel north = new JPanel(new BorderLayout());
			JPanel center = new JPanel(new BorderLayout());
			JPanel south = new JPanel(new BorderLayout());
	
			JLabel name = new JLabel("Pokemon Name?");
			JTextField textName = new JTextField(20);
	
			north.add(name, BorderLayout.NORTH);
			north.add(textName, BorderLayout.CENTER);
	
			JLabel type = new JLabel("Pokemon Type?");
			JTextField textType = new JTextField(20);
	
			center.add(type, BorderLayout.NORTH);
			center.add(textType, BorderLayout.CENTER);
	
			JLabel count = new JLabel("Have you counted before? If not enter 0");
			JTextField textCount = new JTextField(20);
	
			south.add(count, BorderLayout.NORTH);
			south.add(textCount, BorderLayout.CENTER);
	
			panel.add(north, BorderLayout.NORTH);
			panel.add(center, BorderLayout.CENTER);
			panel.add(south, BorderLayout.SOUTH);
	
			Object[] objects = { panel };
	
			int result = JOptionPane.showConfirmDialog(
				null,
				objects,
				"Hunt",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
	
			if(result != JOptionPane.OK_OPTION)
				throw new Exception("I think you canceled. This try/catch was just for practice. If you're name is not Avery and you're reading this disregard. !!!!! *Men In Black Flash* !!!!!");
			
			else{
				pokemon = new Pokemon(textName.getText(), textType.getText(), Integer.parseInt(textCount.getText()));
				pokeballs.addPokemon(pokemon);
				updateDisplay(Display.POKEMON);
			}
		}catch(Exception e){
			dataCenter.setText("<html>" 
        				+ "<body style=\"word-wrap: break-word\">" 
        					+ e.getMessage().replaceAll("<","&lt;")
											.replaceAll(">", "&gt;")
											.replaceAll("\n", "<br/>")
						+ "</body>" 
					+ "</html>");
		}
	}

	protected void onMinusClick(){
		pokemon.decrement();
		updateDisplay(Display.POKEMON);
	}

    protected void onPlusClick(){
    	pokemon.increment();
		updateDisplay(Display.POKEMON);
    }

    /************************************************
                    	Utilities
    ************************************************/

    protected void updateDisplay(Display display){
    	String e = "ERROR: Fuck idk what happend!";
    	if(display == Display.POKEMON) e = pokemon.toString();

    	dataCenter.setText("<html>" 
        				+ "<body style=\"word-wrap: break-word\">" 
        					+ e.replaceAll("<","&lt;")
							   .replaceAll(">", "&gt;")
							   .replaceAll("\n", "<br/>")
						+ "</body>" 
					+ "</html>");
    }

	/************************************************
                    	Main
    ************************************************/

	public static void main(String[] args){
		MainWin myApp = new MainWin("Avery");
		myApp.setVisible(true);
	}

	private enum Display { POKEMON };

	private Pokeballs pokeballs;
	private Pokemon pokemon;

	private JLabel dataNorth;
	private JLabel dataCenter;

	private String title;

	private File fileName;
}