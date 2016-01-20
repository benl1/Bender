package objects.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import objects.bot.Bot;
import objects.graphics.Gui;

public class Keys implements KeyListener {

	private Gui gui;
	private Bot botInFocus;

	public Keys(Gui gui) {
		this.gui = gui;
		if (gui.isBase()) {
			botInFocus = gui.getBot();
		}
		else {
			botInFocus = gui.getBot(1);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) botInFocus.moveRight();
		if (e.getKeyCode() == KeyEvent.VK_LEFT) botInFocus.moveLeft();
		if (e.getKeyCode() == KeyEvent.VK_UP) botInFocus.moveUp();
		if (e.getKeyCode() == KeyEvent.VK_DOWN) botInFocus.moveDown();
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void setBotInFocus(Bot botInFocus) {
		this.botInFocus = botInFocus;
	}
}
