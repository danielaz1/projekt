package player;

import java.util.ArrayList;
import java.util.Scanner;

import game.Colour;
import game.Coords;
import game.Move;
import game.Pawn;

public class HumanPlayer extends Player {

	public HumanPlayer(ArrayList<Pawn> pawns) {
		super(pawns);
		this.colour = Colour.WHITE;
	}

	@Override
	public Move getMove() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.findInLine("[A-Z][0-9]");
		Coords coords1 = getCoordsFromString(str);

		str = scanner.findInLine("[A-Z][0-9]");
		Coords coords2 = getCoordsFromString(str);
		// scanner.close();

		for (Move move : possibleMoves) {
			if (move.getCoords1().x == coords1.x && move.getCoords1().y == coords1.y) {
				if (move.getCoords2().x == coords2.x && move.getCoords2().y == coords2.y) {
					return move;
				}
			}
		}
		return null;

	}

	private Coords getCoordsFromString(String str) {
		Coords coords = new Coords(str.charAt(0) - 'A', str.charAt(1) - '0' - 1);
		return coords;
	}
}
