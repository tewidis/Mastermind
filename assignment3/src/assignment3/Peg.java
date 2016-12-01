package assignment3;

import java.util.Random;

import assignment3.Color;
import assignment3.Game;

public class Peg {
	private Color col;
	/**
	 * Makes a new peg given a String
	 */
	public Peg(String a)
	{
		col = new Color(a);
	}
	/**
	 * Returns a Peg object with a random String associated
	 */
	public static Peg generateRandomPeg()
	{
		Random rand = new Random();
		return new Peg(Game.PEG_TYPES[rand.nextInt(Game.PEG_TYPES.length)]);
	}
	/**
	 * Basic getter method
	 */
	public Color getCol()
	{
		return col;
	}
}
