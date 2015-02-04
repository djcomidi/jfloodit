package jfloodit.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;
import jfloodit.FloodIt;

public class ColorButton extends JPanel {
	private static final long serialVersionUID = 6424504345836077333L;
	private Color color;

	public ColorButton(Color color) {
		this.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.setColor( color );
		// g.fillOval( 0, 0, this.getWidth(), this.getHeight() );
		Graphics2D g2d = (Graphics2D) g;
		int r = Math.min(this.getWidth(), this.getHeight()) / 2;
		int midX = this.getWidth() / 2;
		int midY = this.getHeight() / 2;
		Paint paint = new GradientPaint(midX - r, midY + r, Color.WHITE, midX
				+ r, midY - r, color);
		g2d.setPaint(paint);
		g2d.fillOval(midX - r, midY - r, 2 * r, 2 * r);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(FloodIt.COLOR_BUTTON_SIZE,
				FloodIt.COLOR_BUTTON_SIZE);
	}

	public Color getColor() {
		return color;
	}
}
