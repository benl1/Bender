package objects.bot;

import java.awt.Image;
import javax.imageio.ImageIO;
import objects.graphics.Gui;

public class Bot {
	private Gui gui;

	private int m_x, m_y;
	private Image sprite = null;
	private static int botType = 114;
	private static int startY = 30;

	private static int botCount = 0;

	public Bot(Gui gui) {
		if (botCount % 5 == 0 && botCount != 0) {
			m_x = 30;
			startY += 119;
			botCount = 0;
		}
		m_x = 30 + (botCount * 159);
		m_y = startY;
		this.gui = gui;

		try {
			sprite = ImageIO.read(getClass().getResource("/res/Bender.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		sprite = sprite.getScaledInstance(Gui.spriteXSize, Gui.spriteYSize, 0);

		botCount++;
	}

	public Bot(int x, int y) {
		m_x = x;
		m_y = y;
	}
	
	private boolean checkBounds(int x, int y){
		if ((x > 0 && x < 800) && (y > 0 && y < 600)){
			return true;
		}
		else return false;
	}

	public void moveRight() {
		if (checkBounds(m_x + 159, m_y)) m_x += 159;
		gui.repaint();
	}

	public void moveRight(int steps) {
		m_x += steps * 159;
	}

	public void moveLeft() {
		if (checkBounds(m_x - 159, m_y)) m_x -= 159;
		gui.repaint();
	}

	public void moveLeft(int steps) {
		m_x -= steps * 159;
		gui.repaint();
	}

	public void moveUp() {
		if (checkBounds(m_x, m_y - 119)) m_y -= 119;
		gui.repaint();
	}

	public void moveUp(int steps) {
		m_y -= steps * 119;
		gui.repaint();
	}

	public void moveDown() {
		if (checkBounds(m_x, m_y + 119)) m_y += 119;
		gui.repaint();
	}

	public void moveDown(int steps) {
		m_y += 119;
		gui.repaint();
	}

	public int getX() {
		return m_x;
	}

	public int getY() {
		return m_y;
	}

	public void setType(int type) {
		botType = type;
	}

	public int getType() {
		return botType;
	}

	public Image getSprite() {
		return sprite;
	}

	public boolean intersectsWith(int x, int y){
		int xsquareStart = m_x-26;
		int xsquareEnd = m_x + 129;
		int ysquareStart = m_y - 30;
		int ysquareEnd = m_y + 122;
		if ((x >= xsquareStart && x <= xsquareEnd) && (y >= ysquareStart && y <= ysquareEnd)){
			return true;
		}
		return false;
	}

	public void printBot() {
		System.out.println("The bots coordinates are: " + this.m_x + ", " + this.m_y + ".");
	}
}
