package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class Rahmen_11_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font f1 = new Font("Arial", Font.PLAIN, 13);
	private static boolean jButtonZeichneIsSelected = false;
	private double oldY = 0;
	private JButton btnNewButton;
	private JPanel panel;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				Rahmen_11_Frame inst = new Rahmen_11_Frame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub	
					}

					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_F5) {
							jButtonZeichneIsSelected = !jButtonZeichneIsSelected;
							inst.repaint();
						}

					}
				});
			}
		});
	}

	public Rahmen_11_Frame() {
		super();
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600, 700);
		setTitle("Graph Ding und so");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("Draw!");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jButtonZeichneActionPerformed(e);
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		panel = new panelDraw();
		getContentPane().add(panel, BorderLayout.CENTER);
		

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	private void jButtonZeichneActionPerformed(ActionEvent evt) {
		jButtonZeichneIsSelected = true;
		this.repaint();
	}
	
	private class panelDraw extends JPanel {
		
		public panelDraw() {
			getContentPane().setBackground(new java.awt.Color(0, 205, 0));
			setBounds(44, 442, 161, 205);
			setLayout(null);
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);

			int width = getWidth();
			int height = getHeight();

			//Koodinatenkreuz zeichen
			g.setColor(Color.black);
			g.drawLine(0, height/2-4, width, height/2-4);
			g.drawLine(width/2, 0, width/2, height);

			//Beschriftung der Achsen
			g.setFont(f1);
			g.drawString("x", width-20, height/2-5);
			for(int i = -15; i <= 15; i++) {
				String str = String.valueOf(i);
				if ( i != 0) {
					g.drawString("|" + str, width/2 + i * 50, height/2+10);				
				}
			}
			g.drawString("y", width/2-10, 40);
			for(int i = 10; i >= -10; i--) {
				if (i != 0) {
					//String str = String.valueOf(i); // Werte als String
					g.drawString("- " + i, width/2, ((-i * 50) + height/2));				
				}
			}
			if (jButtonZeichneIsSelected) {
				int counter = 50;
				for(double x = -15; x <= 15; x = x + 0.001) {
					double y = (x * x) + x - 6;
					if ((oldY > 0 && y < 0) || (oldY < 0 && y > 0) || y == 0) {
						g.drawString("Nullstelle bei: " + x, 50, counter);
						counter += 50;
					}
					g.drawString("'", (int) (width/2 + (x * 50)), height/2 - (int) (y * 50));
					oldY = y;

				}
			}
			jButtonZeichneIsSelected = false;
		}
	}
}
