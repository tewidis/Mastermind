/**
 * NAMES: Tanner Widis, Kenneth Lee
 * UTEID: tew635, kel348
 * DATE: 3/6/2015
 * LAB SECTION: 16010
 */
package assignment3;

import javax.swing.*;

import assignment3.Game;

public class Start {
	/**
	 * Takes user input to start the game
	 * Checks for win or loss and asks to play again
	 * If user wants to play, calls runGame
	 */
	public static void main(String args[])
	{
		String message = "You have " + Game.NUM_GUESSES + " guesses to figure out the secret code or "
				+ "you lose the game. Are you ready to play? ";
		String title = "Ready to play?";
		int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		while(reply == JOptionPane.YES_OPTION)
		{
			Game newGame = new Game(true);
			newGame.runGame();
			if(Game.WIN)
			{
				title = "You win!";
				message = "Play again?";
				reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				Game.WIN = false;
			}
			else
			{
				title = "You lose!";
				message = "Play again?";
				reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
			}
		}
	}
}
