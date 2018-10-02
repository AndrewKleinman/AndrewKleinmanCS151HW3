import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
public class paintCircle extends JFrame{
	Color color = Color.RED;
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	
	
	public paintCircle() {
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Panel p = new Panel();
		p.setBackground(Color.WHITE);
		JButton b1 = new JButton("Red");
		JButton b2 = new JButton("Green");
		JButton b3 = new JButton("Blue");
		p.add(b1);
		b1.addActionListener(event -> {
			color = (Color.RED);
			repaint();}
			);
		p.add(b2);
		b2.addActionListener(event -> {
			color = (Color.GREEN);
			repaint();}
			);
		p.add(b3);
		b3.addActionListener(event -> {
			color = (Color.BLUE);
			repaint();}
			);
		this.add(p,BorderLayout.SOUTH);
		}
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(200, 200, 100, 100);
	}
	public void repaint(Graphics g) {
		paintCircle p = new paintCircle();
		p.paint(null);
	}
	public static void main(String[]args)
	{
		paintCircle p = new paintCircle();
		p.repaint();
		
		
	}	
}
