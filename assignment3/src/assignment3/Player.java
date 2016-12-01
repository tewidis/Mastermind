package assignment3;

import javafx.scene.paint.Color;
import assignment3.Board;
import assignment3.Code;
import assignment3.Game;

public class Player {
	static Code playerCode;
	static Board newBoard;
	/**
	 * Creates a Player with a code and board
	 */
	public Player()
	{
		playerCode = new Code(false);
		newBoard = new Board();
	}
	/** 
	 * Takes the number of guesses as a parameter
	 * Takes an input and checks if valid
	 * If so, checks to output black and white pegs, stores in history
	 * If not, prompts for another input
	 */
	public static void getInput(int guesses)
	{
		String temp = Game.text.getText();
		try
		{
			validGuess(guesses, temp);
		}
		catch(IllegalGuessException e)
		{
			return;
		}
		playerCode.setCode(temp);
		Game.VALID_GUESS = true;
		Game.HISTORY[guesses] = playerCode.makeString() + " " + Board.checkCode(playerCode.makeString());
		for(int i = 0; i < Game.NUM_PEGS; i++)
		{
			Game.out[i].setBackground(null);
		}
		int i = 0;
		for(int j = 0; j < Board.blackPegs; j++)
		{
			Game.out[i].setBackground(Game.toAWTColor(Color.BLACK));
			i++;
		}
		for(int j = 0; j < Board.whitePegs; j++)
		{
			Game.out[i].setBackground(Game.toAWTColor(Color.WHITE));
			i++;
		}
		if(Board.checkCode(playerCode.makeString()).equals(Game.NUM_PEGS + " black pegs"))
		{
			Game.WIN = true;
		}
		Game.text.setText("");
	}
	/**
	 * Checks if the input code is valid
	 * If it is not, throws an IllegalGuessException
	 */
	public static void validGuess(int guesses, String t) throws IllegalGuessException
	{
		boolean inString = false;
		if(t.length() != Game.NUM_PEGS)
		{
			throw new IllegalGuessException(false);
		}
		for(int i = 0; i < Game.NUM_PEGS; i++)
		{
			for(int j = 0; j < Game.PEG_TYPES.length; j++)
			{
				if(t.substring(i, i + 1).equals(Game.PEG_TYPES[j]))
				{
					inString = true;
				}
			}
			if(inString == false)
			{
				throw new IllegalGuessException(false);
			}
			inString = false;
		}
		for(int i = 0; i < guesses; i++)
		{
			if(t.equals(Game.HISTORY[i].substring(0, Game.NUM_PEGS)))
			{
				throw new IllegalGuessException(true);
			}
		}
	}
}
