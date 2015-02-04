package jfloodit;

import jfloodit.engine.JFloodItEngine;
import jfloodit.ui.JFloodItUi;

public class JFloodIt {
	public static void main(String[] args) {
		JFloodItEngine engine = new JFloodItEngine();
		JFloodItUi ui = new JFloodItUi(engine);
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}
}
