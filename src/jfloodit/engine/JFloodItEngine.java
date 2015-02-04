package jfloodit.engine;

import java.awt.Color;
import java.util.Random;
import jfloodit.FloodIt;
import jfloodit.FloodIt.GameState;

public class JFloodItEngine {
	private Color[][] gridColors = new Color[FloodIt.GRID_SIZE][FloodIt.GRID_SIZE];
	private boolean[][] visited = new boolean[FloodIt.GRID_SIZE][FloodIt.GRID_SIZE];
	private int turn = 1;
	private GameState gameState;

	public JFloodItEngine() {
		gridColors = new Color[FloodIt.GRID_SIZE][FloodIt.GRID_SIZE];
		newGame();
	}

	public void floodWith(Color newColor) {
		if (gameState == GameState.ACTIVE) {
			floodStart(newColor);
			turn++;
			updateGameState();
		}
	}

	public void newGame() {
		Random random = new Random();
		for (int row = 0; row < FloodIt.GRID_SIZE; row++) {
			for (int col = 0; col < FloodIt.GRID_SIZE; col++) {
				gridColors[row][col] = FloodIt.COLORS[random
						.nextInt(FloodIt.COLORS.length)];
			}
		}
		gameState = GameState.ACTIVE;
		turn = 1;
	}

	public Color[][] getGridColors() {
		return gridColors;
	}

	public int getTurn() {
		return turn;
	}

	private boolean isSolved() {
		boolean bSolved = true;
		Color clr = gridColors[0][0];
		for (int row = 0; row < FloodIt.GRID_SIZE && bSolved; row++) {
			for (int col = 0; col < FloodIt.GRID_SIZE && bSolved; col++) {
				bSolved = clr.equals(gridColors[row][col]);
			}
		}
		return bSolved;
	}

	private void updateGameState() {
		if (isSolved()) {
			gameState = GameState.WINNER;
		} else if (turn < FloodIt.MAX_TURNS) {
			gameState = GameState.ACTIVE;
		} else {
			gameState = GameState.LOSER;
		}
	}

	private void floodStart(Color newColor) {
		for (int row = 0; row < FloodIt.GRID_SIZE; row++) {
			for (int col = 0; col < FloodIt.GRID_SIZE; col++) {
				visited[row][col] = false;
			}
		}
		flood(0, 0, gridColors[0][0], newColor);
	}

	private void flood(int row, int col, Color oldColor, Color newColor) {
		if (!visited[row][col]) {
			visited[row][col] = true;
			if (gridColors[row][col].equals(oldColor)) {
				gridColors[row][col] = newColor;
				if (row > 0) {
					flood(row - 1, col, oldColor, newColor);
				}
				if (row < FloodIt.GRID_SIZE - 1) {
					flood(row + 1, col, oldColor, newColor);
				}
				if (col > 0) {
					flood(row, col - 1, oldColor, newColor);
				}
				if (col < FloodIt.GRID_SIZE - 1) {
					flood(row, col + 1, oldColor, newColor);
				}
			}
		}
	}

	public GameState getGameState() {
		return gameState;
	}
}
