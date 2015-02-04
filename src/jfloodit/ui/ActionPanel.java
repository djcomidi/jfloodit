package jfloodit.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import jfloodit.FloodIt;

public class ActionPanel extends JPanel {
	private static final long serialVersionUID = 8347397630502279557L;
	private JFloodItUi parent;
	private JButton btnNewGame;
	private JButton btnQuit;
	private JLabel lblTurn;
	private ColorButton cbtns[];

	public ActionPanel(JFloodItUi parent) {
		this.parent = parent;
		createComponents();
		placeComponents();
		addListeners();
	}

	private void createComponents() {
		cbtns = new ColorButton[6];
		for (int i = 0; i < 6; i++) {
			cbtns[i] = new ColorButton(FloodIt.COLORS[i]);
		}
		lblTurn = new JLabel("", SwingConstants.CENTER);
		setTurn(1);
		btnNewGame = new JButton(FloodIt.TXT_NEW_GAME);
		btnQuit = new JButton(FloodIt.TXT_QUIT);
	}

	private void placeComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 2, 5, 2);
		gbc.fill = GridBagConstraints.BOTH;
		for (int i = 0; i < 6; i++) {
			gbc.gridx = i % 3;
			gbc.gridy = i / 3;
			this.add(cbtns[i], gbc);
		}
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(lblTurn, gbc);
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.CENTER;
		this.add(btnNewGame, gbc);
		gbc.gridy = 4;
		this.add(btnQuit, gbc);
		gbc.gridy = 5;
		gbc.weighty = 1;
		this.add(new JPanel(), gbc);
	}

	private void addListeners() {
		MouseListener ml = new ColorListener();
		for (ColorButton cbtn : cbtns) {
			cbtn.addMouseListener(ml);
		}
		ActionListener al = new ButtonListener();
		btnQuit.addActionListener(al);
		btnNewGame.addActionListener(al);
	}

	private class ColorListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				ColorButton btn = (ColorButton) e.getSource();
				parent.floodWith(btn.getColor());
			}
		}
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnQuit)) {
				System.exit(0);
			} else if (e.getSource().equals(btnNewGame)) {
				parent.newGame();
			}
		}
	}

	public void setTurn(int turn) {
		lblTurn.setText(String.format(FloodIt.TURN_FORMAT, turn));
	}

}
