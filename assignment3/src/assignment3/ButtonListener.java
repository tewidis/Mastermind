package assignment3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import assignment3.Game;

public class ButtonListener extends Start implements ActionListener
{
	/**
	 * Listens to each JButton to take input
	 * Sets input button color
	 */
	public void actionPerformed(ActionEvent ae)
	{
		String action = ae.getActionCommand();
		if(action.equals("History")) 
		{
			Game.SUBMITTED = true;
			Game.SHOW_HISTORY = true;
			return;
		}
		if(action.equals("Submit"))
		{
			Game.setCount(1); 
			Game.in[0].setBackground(null);
			Game.in[1].setBackground(null);
			Game.in[2].setBackground(null);
			Game.in[3].setBackground(null);
			Game.in[4].setBackground(null);
			Game.SUBMITTED = true;
			return;
		}
		if(action.equals("Blue")) 
		{ 
			Game.text.setText(Game.text.getText().concat("B"));
			switch(Game.getCount())
			{
				case(1): { Game.in[0].setBackground(Game.toAWTColor(Color.BLUE)); break; }
				case(2): { Game.in[1].setBackground(Game.toAWTColor(Color.BLUE)); break; }
				case(3): { Game.in[2].setBackground(Game.toAWTColor(Color.BLUE)); break; }
				case(4): { Game.in[3].setBackground(Game.toAWTColor(Color.BLUE)); break; }
				case(5): { Game.in[4].setBackground(Game.toAWTColor(Color.BLUE)); break; }
			}
		}
		if(action.equals("Green")) 
		{ 
			Game.text.setText(Game.text.getText().concat("G")); 
			switch(Game.getCount())
			{
				case(1): { Game.in[0].setBackground(Game.toAWTColor(Color.GREEN)); break; }
				case(2): { Game.in[1].setBackground(Game.toAWTColor(Color.GREEN)); break; }
				case(3): { Game.in[2].setBackground(Game.toAWTColor(Color.GREEN)); break; }
				case(4): { Game.in[3].setBackground(Game.toAWTColor(Color.GREEN)); break; }
				case(5): { Game.in[4].setBackground(Game.toAWTColor(Color.GREEN)); break; }
			}
		}
		if(action.equals("Orange")) 
		{ 
			Game.text.setText(Game.text.getText().concat("O")); 
			switch(Game.getCount())
			{
				case(1): { Game.in[0].setBackground(Game.toAWTColor(Color.ORANGE)); break; }
				case(2): { Game.in[1].setBackground(Game.toAWTColor(Color.ORANGE)); break; }
				case(3): { Game.in[2].setBackground(Game.toAWTColor(Color.ORANGE)); break; }
				case(4): { Game.in[3].setBackground(Game.toAWTColor(Color.ORANGE)); break; }
				case(5): { Game.in[4].setBackground(Game.toAWTColor(Color.ORANGE)); break; }
			}
		}
		if(action.equals("Purple")) 
		{ 
			Game.text.setText(Game.text.getText().concat("P")); 
			switch(Game.getCount())
			{
				case(1): { Game.in[0].setBackground(Game.toAWTColor(Color.PURPLE)); break; }
				case(2): { Game.in[1].setBackground(Game.toAWTColor(Color.PURPLE)); break; }
				case(3): { Game.in[2].setBackground(Game.toAWTColor(Color.PURPLE)); break; }
				case(4): { Game.in[3].setBackground(Game.toAWTColor(Color.PURPLE)); break; }
				case(5): { Game.in[4].setBackground(Game.toAWTColor(Color.PURPLE)); break; }
			}
		}
		if(action.equals("Red")) 
		{ 
			Game.text.setText(Game.text.getText().concat("R")); 
			switch(Game.getCount())
			{
				case(1): { Game.in[0].setBackground(Game.toAWTColor(Color.RED)); break; }
				case(2): { Game.in[1].setBackground(Game.toAWTColor(Color.RED)); break; }
				case(3): { Game.in[2].setBackground(Game.toAWTColor(Color.RED)); break; }
				case(4): { Game.in[3].setBackground(Game.toAWTColor(Color.RED)); break; }
				case(5): { Game.in[4].setBackground(Game.toAWTColor(Color.RED)); break; }
			}
		}
		if(action.equals("Yellow")) 
		{ 
			Game.text.setText(Game.text.getText().concat("Y")); 
			switch(Game.getCount())
			{
				case(1): { Game.in[0].setBackground(Game.toAWTColor(Color.YELLOW)); break; }
				case(2): { Game.in[1].setBackground(Game.toAWTColor(Color.YELLOW)); break; }
				case(3): { Game.in[2].setBackground(Game.toAWTColor(Color.YELLOW)); break; }
				case(4): { Game.in[3].setBackground(Game.toAWTColor(Color.YELLOW)); break; }
				case(5): { Game.in[4].setBackground(Game.toAWTColor(Color.YELLOW)); break; }
			}
		}
		if(action.equals("Maroon")) 
		{ 
			Game.text.setText(Game.text.getText().concat("M")); 
			switch(Game.getCount())
			{
				case(1): { Game.in[0].setBackground(Game.toAWTColor(Color.MAROON)); break; }
				case(2): { Game.in[1].setBackground(Game.toAWTColor(Color.MAROON)); break; }
				case(3): { Game.in[2].setBackground(Game.toAWTColor(Color.MAROON)); break; }
				case(4): { Game.in[3].setBackground(Game.toAWTColor(Color.MAROON)); break; }
				case(5): { Game.in[4].setBackground(Game.toAWTColor(Color.MAROON)); break; }
			}
		}
		Game.setCount(Game.getCount() + 1);
	}
}