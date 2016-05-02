package swingui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;

public class CellAutoCanvas extends Canvas {

	public CellAutoCanvas() {
	}

	public CellAutoCanvas(GraphicsConfiguration arg0) {
		super(arg0);
	}
	
	public void paint(Graphics g) {
		drawCellularAutomation(g);
	}
		
	public void drawCellularAutomation(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
		
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0, 300, 200);
	
		g2d.setColor(Color.BLUE);
		g2d.drawString("Hellow world 2D", 10, 20);
			
		g2d.setColor(Color.RED);
		g2d.drawLine(0, 0, size.width, size.height);;	
	
		for(int i = 10;i < 200; i += 20){
			paintRect(g2d, i, 20, 10, Color.BLUE);
		}
	}
	
	public void paintRect(Graphics2D g2d,int x,int y,int size,Color color) {
		g2d.setColor(color);
		g2d.fillRect(x, y, size, size);
	}

}
