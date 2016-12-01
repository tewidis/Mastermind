package assignment3;

import java.awt.FlowLayout;

import javafx.scene.paint.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assignment3.Player;

public class Game {
	final static int NUM_GUESSES = 15;
	final static String[] HISTORY = new String[NUM_GUESSES];
	final static int NUM_PEGS = 5;
	final static String[] PEG_TYPES = {"B", "G", "O", "P", "R", "Y", "M"};
	static boolean SHOW_CODE;
	static boolean WIN = false;
	static boolean VALID_GUESS = false;
	static boolean SUBMITTED = false;
	static boolean SHOW_HISTORY = false;
	private Player player1;
	private static int counter = 1;
	
	public static JLabel text = new JLabel();
	static JLabel[] hist = new JLabel[NUM_GUESSES];
	static JLabel guessesLeft = new JLabel();
	static JButton[] in = new JButton[NUM_PEGS];
	static JButton[] out = new JButton[NUM_PEGS];
		
	/**
	 * Basic getter method
	 */
	public static int getCount()
	{
		return counter;
	}
	/**
	 * Basic setter method
	 */
	public static void setCount(int i)
	{
		counter = i;
		if(counter > 5)
		{
			counter = 1;
		}
	}
	/**
	 * Makes new player and initializes boolean to show the code for debugging or not
	 */
	public Game(boolean test)
	{
		player1 = new Player();
		SHOW_CODE = test;
	}
	/**
	 * Runs the game by getting input and checking for win
	 * Requires no input or output
	 */
	public void runGame()
	{
		initGUI();
		if(Game.SHOW_CODE)
		{
			System.out.println("The code is " + Board.secretCode.makeString());
		}
		for(int i = 0; i < NUM_GUESSES; i++)
		{
			int guesses = NUM_GUESSES - i;
			guessesLeft.setText("Guesses: " + guesses);
			while(!VALID_GUESS)
			{
				while(!SUBMITTED){
					try 
					{
						Thread.sleep(200);
					} 
					catch(InterruptedException e) { }
				}
				if(SHOW_HISTORY)
				{
					Board.showHistory(i);
					Game.text.setText("");
				}
				else
				{
					Player.getInput(i);
					Game.text.setText("");
				}
				SUBMITTED = false;
				SHOW_HISTORY = false;
			}
			VALID_GUESS = false;
			if(WIN)
			{
				i = NUM_GUESSES;
			}
		}
	}
	/**
	 * Converts a javafx Color to AWT color for more options
	 */
	public static java.awt.Color toAWTColor(javafx.scene.paint.Color fxColor)
    {
        return new java.awt.Color((float)fxColor.getRed(), (float)fxColor.getGreen(), (float)fxColor.getBlue(), (float)fxColor.getOpacity());
    }
	/**
	 * Initializes the GUI with all buttons and text
	 */
	public static void initGUI()
	{
		JFrame frame = new JFrame("Mastermind");
		frame.setSize(260, 600);
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		for(int i = 0; i < NUM_PEGS; i++)
		{
			out[i] = new JButton(" ");
			p.add(out[i]);
		}
		for(int i = 0; i < NUM_PEGS; i++)
		{
			in[i] = new JButton(" ");
			p.add(in[i]);
		}
		
		JButton B = new JButton("Blue");
		B.setBackground(toAWTColor(Color.BLUE));
		B.addActionListener(new ButtonListener());
		JButton G = new JButton("Green");
		G.setBackground(toAWTColor(Color.GREEN));
		G.addActionListener(new ButtonListener());
		JButton O = new JButton("Orange");
		O.setBackground(toAWTColor(Color.ORANGE));
		O.addActionListener(new ButtonListener());
		JButton P = new JButton("Purple");
		P.setBackground(toAWTColor(Color.PURPLE));
		P.addActionListener(new ButtonListener());
		JButton R = new JButton("Red");
		R.setBackground(toAWTColor(Color.RED));
		R.addActionListener(new ButtonListener());
		JButton Y = new JButton("Yellow");
		Y.setBackground(toAWTColor(Color.YELLOW));
		Y.addActionListener(new ButtonListener());
		JButton M = new JButton("Maroon");
		M.setBackground(toAWTColor(Color.MAROON));
		M.addActionListener(new ButtonListener());
		JButton History = new JButton("History");
		History.addActionListener(new ButtonListener());
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ButtonListener());
			
		p.add(B);
		p.add(G);
		p.add(O);
		p.add(P);
		p.add(R);
		p.add(Y);
		p.add(M);
		p.add(History);
		p.add(Submit);
		p.add(guessesLeft);
		for(int i = 0; i < NUM_GUESSES; i++)
		{
			hist[i] = new JLabel();
			p.add(hist[i]);
		}	
		frame.add(p);
		frame.setVisible(true);
	}
}

