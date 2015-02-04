package jfloodit.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jfloodit.FloodIt;
import jfloodit.engine.JFloodItEngine;

public class JFloodItUi extends JFrame {
	private static final long serialVersionUID = 6096196113851570415L;
	private JFloodItEngine engine;
	private ActionPanel pnlAction;
	private GridPanel pnlGrid;

	public JFloodItUi(JFloodItEngine engine) {
		super(FloodIt.WINDOW_TITLE);
		this.engine = engine;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setSize(FloodIt.WINDOW_WIDTH, FloodIt.WINDOW_HEIGHT);
		this.setResizable(false);
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());
		pnlAction = new ActionPanel(this);
		this.add(pnlAction, BorderLayout.WEST);
		pnlGrid = new GridPanel(engine.getGridColors());
		this.add(pnlGrid, BorderLayout.CENTER);
	}

	public void floodWith(Color c) {
		engine.floodWith(c);
		pnlAction.setTurn(engine.getTurn());
		pnlGrid.setColors(engine.getGridColors());
		switch (engine.getGameState()) {
		case WINNER:
			JOptionPane.showMessageDialog(null, FloodIt.TXT_WINNER,
					FloodIt.WINDOW_TITLE, JOptionPane.INFORMATION_MESSAGE);
			newGame();
			break;
		case LOSER:
			JOptionPane.showMessageDialog(null, FloodIt.TXT_LOSER,
					FloodIt.WINDOW_TITLE, JOptionPane.INFORMATION_MESSAGE);
			newGame();
			break;
		case ACTIVE:
			break;
		}
	}

	public void newGame() {
		engine.newGame();
		pnlAction.setTurn(engine.getTurn());
		pnlGrid.setColors(engine.getGridColors());
	}
}
