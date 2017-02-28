package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Rahmen_02_Frame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font f1 = new Font("Comic Sans MS", Font.BOLD, 20);
	private Font f2 = new Font("Tahoma", Font.BOLD, 12);

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				Rahmen_02_Frame inst = new Rahmen_02_Frame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Rahmen_02_Frame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		getContentPane().setBackground(new Color(255, 0, 0));
		this.setLayout(null);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//oben links soll Name stehen
		g.setColor(Color.green);
		g.setFont(f1);
		g.drawString("Jürgi Elfers", 50, 70);
		
		//Mittelpunkt einkreisen
		g.setColor(Color.yellow);
		g.drawString(".< Hier ist die Mitte!: ",  300, 250);
		g.fillOval(295, 245, 10, 10);
		
		//Koodinatenkreuz zeichen
		g.setColor(Color.black);
		g.drawLine(0, 250, 600, 250);
		g.drawLine(300, 0, 300, 500);
		
		//Beschriftung der Achsen
		g.setFont(f2);
		g.drawString("x", 580, 240);
		for(int i = -5; i <= 5; i++) {
			String str = String.valueOf(i);
			g.drawString("|" + str, 300 + i * 50, 260);
		}
		g.drawString("y", 290, 40);
		for(int i = 4; i >= -4; i--) {
			//String str = String.valueOf(i); // Werte als String
			g.drawString("-" + i, 300, ((-i * 50) + 260));
		}
		
		//Zeichnen von f(x) = x^2 - 1
		
		for(double x = -5; x <= 5; x = x + 0.0001) {
			double y = x * x - 1;
			//g.drawString("+", 300 + Integer.parseInt(String.valueOf((x * 50))), Integer.parseInt(String.valueOf((260 - (y * 50)))));
			g.drawString("+", (int) (300 + (x * 50)), 260 - (int) (y * 50));
		}
	}
	
	public interface runnable{
		public abstract void run();
	}
}