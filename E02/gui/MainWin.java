package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import pokemon.Pokemon;
import pokemon.Pokeballs;
import pokemon.Monster;

public class MainWin extends JFrame{

	public MainWin(String name){
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileName = new File("untitled.pokemon");
		setSize(500, 300);

		/***********************************
					Menu Bar
		***********************************/

		JMenuBar menu = new JMenuBar();

		// Create the Menu 
		JMenu file = new JMenu("File");
		JMenu create = new JMenu("Create");
		JMenu about = new JMenu("About");

		// Create the MenuItems
		JMenuItem open = new JMenuItem("Open");
		JMenuItem aNew = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save as");
		JMenuItem quit = new JMenuItem("Quit :(");
		JMenuItem hunt = new JMenuItem("Hunt");
		JMenuItem plus = new JMenuItem("Plus");
		JMenuItem minus = new JMenuItem("Minus");
		
		// Add ActionListeners to MenuItems
		open.addActionListener(event -> onOpenClick());
		aNew.addActionListener(event -> onNewClick());
		quit.addActionListener(event -> onQuitClick());
		save.addActionListener(event-> onSaveClick());
		saveAs.addActionListener(event -> onSaveAsClick());
		hunt.addActionListener(event -> onHuntClick());
		plus.addActionListener(event -> onPlusClick());
		minus.addActionListener(event -> onMinusClick());

		// Add MenuItems to Menu
		file.add(open);
		file.add(aNew);
		file.add(save);
		file.add(saveAs);
		file.add(quit);
		create.add(hunt);
		create.add(plus);
		create.add(minus);

		// Add Menu to MenuBar
		menu.add(file);
		menu.add(create);
		menu.add(about);

		setJMenuBar(menu);

		/***********************************
					Tool Bar
		***********************************/

		JToolBar toolbar = new JToolBar();

		// Create JButton
		bNew = new JButton(new ImageIcon("gui/resources/new_store.png"));
		bAbout = new JButton(new ImageIcon("gui/resources/about.png"));
		bPlus = new JButton(new ImageIcon("gui/resources/plus.png"));
		bMinus = new JButton(new ImageIcon("gui/resources/minus.png"));

		// Add ActionListeners
		bNew.addActionListener(event -> onNewClick());
		bPlus.addActionListener(event -> onPlusClick());
		bMinus.addActionListener(event -> onMinusClick());


		// Add JButton(s) to JToolBar
		toolbar.add(bNew);
		toolbar.add(Box.createHorizontalStrut(20));
		toolbar.add(bPlus);
		toolbar.add(bMinus);
		toolbar.add(Box.createHorizontalStrut(20));
		toolbar.add(bAbout);

		getContentPane().add(toolbar, BorderLayout.PAGE_START);

		/************************************
						Data
		************************************/

		// Create Image
		
		try{
			image = ImageIO.read(new File("gui/resources/pokemon_logo.png"));
		
		}catch(IOException e){/* Idk why but ImageIO throws an IOException so it has to be caught */ }
		
		// Convert Image to ImageIcon 
		// Image cant be passed to JLabel so we need to convert
		ImageIcon img = new ImageIcon(image.getScaledInstance(270, 100, Image.SCALE_DEFAULT));

		data = new JLabel(img);

		getContentPane().add(data, BorderLayout.LINE_START);

		// Status for message
		msg = new JLabel();
		add(msg, BorderLayout.PAGE_END);
	}

	protected void onOpenClick(){
		final JFileChooser fc = new JFileChooser(fileName);
		FileFilter pokeFiles = new FileNameExtensionFilter("Pokemon files", "pokemon");
		fc.addChoosableFileFilter(pokeFiles);
		fc.setFileFilter(pokeFiles);

		int result = fc.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			fileName = fc.getSelectedFile();
			
			try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
				monster = new Monster(br);
				pokemon = monster;
				
				updateDisplay();
			} catch(Exception e){
				JOptionPane.showMessageDialog(this,"Unable to open " 
					+ fileName 
					+ '\n' 
					+ e, "Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void onNewClick(){
		pokemon = new Pokemon("");
		updateDisplay();
	}

	protected void onSaveClick(){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			pokemon.save(bw);
		} catch(Exception e){
			JOptionPane.showMessageDialog(this, "Unable to open " 
								+ fileName 
								+ "\n" + e, "Failed", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void onSaveAsClick(){
		final JFileChooser fc = new JFileChooser(fileName);
		FileFilter pokeFiles = new FileNameExtensionFilter("Pokemon files", "pokemon");
		fc.addChoosableFileFilter(pokeFiles);
		fc.setFileFilter(pokeFiles);

		int result = fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			fileName = fc.getSelectedFile();
			if(!fileName.getAbsolutePath().endsWith(".pokemon"))
				fileName = new File(fileName.getAbsolutePath());
			onSaveClick();
		}
	}

	protected void onQuitClick(){ System.exit(0); } // Exit

	protected void onHuntClick(){
		try{
			String name = getString("Pokemon name");
			monster = new Monster(name, 0);
			pokemon = monster;
			updateDisplay();
		} catch (CancelDialogException e) { // ignore a Cancel
        } catch (Exception e) {
            msg.setText("Failed to create new Java: " + e.getMessage());
        }
	}

	protected void onPlusClick(){
		monster.incrementCount();
		updateDisplay();
	}

	protected void onMinusClick(){
		monster.decrementCount();
		updateDisplay();
	}

	protected class CancelDialogException extends Exception{
		public CancelDialogException(){
			super("Dialog cancelled");
		}
	}

	private String getString(String name) throws CancelDialogException{
		String newName = name;
		while(true){
			try{
				newName = JOptionPane.showInputDialog(this, newName);
				if(newName == null || newName.length() == 0)
					throw new CancelDialogException();
				break;
			} catch (CancelDialogException e) {
                throw e;  // Rethrow to signal Cancel was clicked
            } catch (Exception e) {
				newName = "No input entered";
			} // End try/catch
		} // End while

		return newName;
	}

	public void updateDisplay(){
		data.setText("<html>" + pokemon.toString()
										 .replaceAll("\n", "<br/>")
							  + "</html>");
	}

	private Image image;

	private JButton bPokemonLogo;
	private JButton bNew;
	private JButton bAbout;
	private JButton bPlus;
	private JButton bMinus;

	private JLabel data;
	private JLabel msg;

	private File fileName;

	private Pokemon pokemon; 
	private Monster monster;

	public static void main(String[] args){
		MainWin myApp = new MainWin("Ash Ketchum");
		myApp.setVisible(true);
	}
}