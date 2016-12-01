package assignment3;

import assignment3.Peg;
import assignment3.Game;

public class Code {
	private Peg[] code;
	/**
	 * Generates a random code if rand is true
	 * Makes empty code otherwise
	 */
	public Code(boolean rand)
	{
		code = new Peg[Game.NUM_PEGS];
		if(rand)
		{
			for(int i = 0; i < Game.NUM_PEGS; i++)
			{
				code[i] = Peg.generateRandomPeg();
			}
		}
	}
	/**
	 * Basic getter method
	 */
	public Peg[] getCode()
	{
		return code;
	}
	/**
	 * Basic setter method
	 */
	public void setCode(String s)
	{
		for(int i = 0; i < Game.NUM_PEGS; i++)
		{
			this.code[i] = new Peg(s.substring(i, i + 1));
		}
	}
	/**
	 * Turns a code into a string for easier manipulation
	 */
	public String makeString()
	{
		String ret = new String();
		for(int i = 0; i < Game.NUM_PEGS; i++)
		{
			ret = ret.concat(this.code[i].getCol().getIdent());
		}
		return ret;
	}
}
