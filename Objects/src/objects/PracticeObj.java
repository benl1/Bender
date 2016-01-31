package objects;

import objects.bot.Bot;
import objects.graphics.Gui;

public class PracticeObj {
	
	public static void main(String[] args){
		Gui gui = new Gui();
		//Ex. Gui gui = new Gui(4);, this would make a screen with 4 bots on it
		Bot b = gui.getBot(); //gets single bot on screen
		//Ex. Bot b = gui.getBot(x), if using more than one bot, you can use getBot(int x) to get a reference to the xth bot on the screen (goes left to right) 
		moveBot(b);
		int x = 5;
		
		/*The code above just starts up the gui and creates a single bot.
		 * The constructor can also take in an integer and it will display however many bots are specified
		 * I haven't put in animation yet so for now it just skips the bot instantly to whatever box it should be in
		 * Moving is just moveRight, moveLeft ect..., these methods can also take an int to take more than one step at once
		 * FUN SIDE NOTE*: The arrow keys can be used to move the bot.
		 * Also*, if you choose to have more than one bot, click on whichever bot you want to move and the arrow keys will then control that bot
		 *  
		 */
		int j = 6;
		
	}
	
	private static void moveBot(Bot b){
		
	}
	
}
