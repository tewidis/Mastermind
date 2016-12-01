package assignment3;

import assignment3.Code;
import assignment3.Game;

public class Board {
	static Code secretCode;
	static int blackPegs = 0;
	static int whitePegs = 0;
	public Board()
	{
		secretCode = new Code(true);
	}
	/** 
	 * Takes a code string as a parameter
	 * Returns a string indicating the number of black and white pegs
	 * Also updates blackPegs and whitePegs
	 */
	public static String checkCode(String s1)
	{
		blackPegs = 0;
		whitePegs = 0;
		String temp = secretCode.makeString();
		if(temp.equals(s1))
		{
			return Game.NUM_PEGS + " black pegs";
		}
		for(int i = 0; i < Game.NUM_PEGS; i++)
		{
			if(temp.substring(i, i + 1).equals(s1.substring(i, i + 1)))
			{
				blackPegs++;
				char[] a = s1.toCharArray();
				char[] b = temp.toCharArray();
				a[i] = '-';
				b[i] = '-';
				s1 = new String(a);
				temp = new String(b);
			}	
		}
		for(int i = 0; i < Game.NUM_PEGS; i++)
		{
			for(int j = 0; j < Game.NUM_PEGS; j++)
			{
				if(temp.substring(i, i + 1).equals(s1.substring(j, j + 1)))
				{
					if(!(temp.substring(i, i + 1).equals("-")))
					{
						whitePegs++;
						char[] a = s1.toCharArray();
						char[] b = temp.toCharArray();
						a[j] = '-';
						b[i] = '-';
						s1 = new String(a);
						temp = new String(b);
					}
				}
			}
		}
		return String.valueOf(blackPegs) + " black peg(s) and " + String.valueOf(whitePegs) + " white peg(s)";
	}
	/** 
	 * Outputs all previous guesses and results
	 *  Takes the number of guesses already used as a parameter
	 */
	public static void showHistory(int i)
	{
		for(int j = 0; j < i; j++)
		{
			Game.hist[j].setText(Game.HISTORY[j]);
		}
	}
}
