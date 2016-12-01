package assignment3;

import javax.swing.*;

public class IllegalGuessException extends Exception
{
	/**
	 * Custom exception for illegal guesses
	 * If the boolean is true, the exception was thrown due to a duplicate guess
	 * If false, the guess was not the correct length
	 */
	public IllegalGuessException(boolean dup)
	{
		if(dup)
		{
			JOptionPane.showMessageDialog(null, "You have already guessed this code. Guess again.", "INVALID GUESS", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Guess again.", "INVALID GUESS", JOptionPane.ERROR_MESSAGE);
		}
	}
}
