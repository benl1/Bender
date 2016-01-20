package objects.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.bot.Bot;
import objects.input.Keys;
import objects.input.Mouse;

public class Gui extends JPanel {

	private static final long serialVersionUID = 1L;
	private Bot bot;
	private JFrame frame;
	private Keys key;
	private Bot[] m_bot; // m for many

	private boolean base = true; //default constructor
	private final int height = 600;
	private final int width = 800;

	public static final int spriteXSize = 90;
	public static final int spriteYSize = 80;

	public Gui() {
		this.bot = new Bot(this);
		key = new Keys(this);
		m_bot = new Bot[0];
		setFrame(null, 0);
	}

	public Gui(int numOfBots) {
		m_bot = new Bot[0];
		base = false;
		m_bot = new Bot[numOfBots];
		for (int i = 0; i < numOfBots; i++) {
			m_bot[i] = new Bot(this);
		}
		key = new Keys(this);
		Mouse mouse = new Mouse(this);
		setFrame(mouse, 1);

	}

	private void setFrame(Mouse mouse, int useMouse) {
		frame = new JFrame();
		frame.add(this);
		setPreferredSize(new Dimension(800, 600));
		frame.setTitle("Bot!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(key);
		if (useMouse == 1) frame.addMouseListener(mouse);
		frame.setVisible(true);
	}

	private void setMap(Graphics g) {
		g.setColor(Color.BLUE);
		for (int x = 0; x <= 800; x += 159) {
			g.fillRect(x, 0, 5, height);
		}

		for (int y = 0; y <= 600; y += 119) {
			g.fillRect(0, y, width, 5);
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setMap(g);
		if (m_bot.length == 0) {
			g.drawImage(bot.getSprite(), bot.getX(), bot.getY(), null);
		}
		if (m_bot.length > 0) {
			for (int i = 0; i < m_bot.length; i++) {
				g.drawImage(m_bot[i].getSprite(), m_bot[i].getX(), m_bot[i].getY(), null);
			}
		}
	}

	public boolean isBase() {
		return base;
	}

	public Bot getBot() {
		return bot;

	}

	public Bot getBot(int botNum) {
		return m_bot[botNum - 1];
	}

	public void newFocusBot(int x, int y) {
		for (int i = 0; i < m_bot.length; i++) {
			if ((m_bot[i]).intersectsWith(x, y)) {
				key.setBotInFocus(m_bot[i]);
			}
		}
	}
}
