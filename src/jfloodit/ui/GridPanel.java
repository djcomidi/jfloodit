package jfloodit.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import jfloodit.FloodIt;

public class GridPanel extends JPanel {
	private static final long serialVersionUID = -6324041924679495268L;
	private Color[][] colors;

	public GridPanel(Color[][] colors) {
		this.colors = colors;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int block = this.getWidth() / FloodIt.GRID_SIZE;
		for (int row = 0; row < FloodIt.GRID_SIZE; row++) {
			for (int col = 0; col < FloodIt.GRID_SIZE; col++) {
				g.setColor(colors[row][col]);
				g.fillRect(row * block, col * block, block, block);
			}
		}
	}

	public void setColors(Color colors[][]) {
		this.colors = colors;
		this.repaint();
	}
}
