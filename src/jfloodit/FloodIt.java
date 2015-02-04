package jfloodit;

import java.awt.Color;

public interface FloodIt {
	public static final int COLOR_BUTTON_SIZE = 42;
	public static final int GRID_SIZE = 14;
	public static final int MAX_TURNS = 25;
	public static final int WINDOW_HEIGHT = 602;
	public static final int WINDOW_WIDTH = 720;

	public static final String TURN_FORMAT = "Turn : %d / 25";
	public static final String TXT_NEW_GAME = "New Game";
	public static final String TXT_QUIT = "Exit";
	public static final String TXT_WINNER = "You won!";
	public static final String TXT_LOSER = "You loose!";
	public static final String WINDOW_TITLE = "jFloodIt";

	public static final Color[] COLORS = { Color.BLUE, Color.RED, Color.GREEN,
			Color.YELLOW, Color.PINK, Color.MAGENTA };

	public static enum GameState {
		ACTIVE, WINNER, LOSER
	};
}
