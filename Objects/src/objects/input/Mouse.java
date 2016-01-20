package objects.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import objects.graphics.Gui;

public class Mouse implements MouseListener {
	
	private int x, y;
	Gui gui;
	
	public Mouse(Gui gui){
		this.gui = gui;
	}
	
	public void mouseClicked(MouseEvent e) {
		gui.newFocusBot(e.getX(), e.getY());
	}

	
	public void mouseEntered(MouseEvent arg0) {
	
		
	}

	
	public void mouseExited(MouseEvent arg0) {
	
		
	}

	
	public void mousePressed(MouseEvent arg0) {
	
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
	
		
	}

}
