package game;

import java.util.ArrayList;

public class Board {

	private ArrayList<Pawn> whitePawns = new ArrayList<Pawn>();
	private ArrayList<Pawn> blackPawns = new ArrayList<Pawn>();
	private static final int SIZE = 8;

	public Board() {
		for (int i = 0; i < SIZE; i++) {
			this.whitePawns.add(new Pawn(i, 0, Colour.WHITE));
			this.whitePawns.add(new Pawn(i, 1, Colour.WHITE));
			this.blackPawns.add(new Pawn(i, SIZE - 2, Colour.BLACK));
			this.blackPawns.add(new Pawn(i, SIZE - 1, Colour.BLACK));
		}
	}

	public ArrayList<Pawn> getWhitePawns() {
		return whitePawns;
	}

	public ArrayList<Pawn> getBlackPawns() {
		return blackPawns;
	}

	public void printBoard() {

		printLetters();
		Pawn[][] array = boardToArray();
		for (int i = SIZE - 1; i >= 0; i--) {
			System.out.print(i + 1);
			for (int j = 0; j < SIZE; j++) {
				Pawn currentPawn = array[i][j];
				String field = "-";
				if (currentPawn != null) {
					field = currentPawn.toString();
				}
				System.out.print(" " + field + " ");
			}
			System.out.print(i + 1 + "\n");
		}
		printLetters();
	}

	public Pawn[][] boardToArray() {

		Pawn[][] array = new Pawn[SIZE][SIZE];

		for (Pawn pawn : whitePawns) {
			array[pawn.getRow()][pawn.getColumn()] = pawn;
		}

		for (Pawn pawn : blackPawns) {
			array[pawn.getRow()][pawn.getColumn()] = pawn;
		}

		return array;
	}

	public int getSize() {
		return SIZE;
	}

	public ArrayList<Move> getListOfPossibleMoves(ArrayList<Pawn> pawnList) {
		Pawn[][] boardArray = boardToArray();
		ArrayList<Move> listOfMoves = new ArrayList<Move>();
		for (Pawn pawn : pawnList) {
			int x = pawn.getColumn();
			int y = pawn.getRow();
			Colour colour = pawn.getColour();
			if (colour.equals(Colour.WHITE)) {
				y++;
			} else {
				y--;
			}
			for (int i = -1; i < 2; i++) {

				if (x + i >= 0 && x + i < SIZE) {
					Pawn target = boardArray[y][x + i];
					if (target != null) {
						if (!target.getColour().equals(colour) && i != 0) {
							listOfMoves.add(
									new Move(new Coords(pawn.getColumn(), pawn.getRow()), new Coords(x + i, y), true));
						}
					} else {
						listOfMoves.add(
								new Move(new Coords(pawn.getColumn(), pawn.getRow()), new Coords(x + i, y), false));
					}
				}
			}
		}

		return listOfMoves;
	}

	public void printLetters() {
		String str = "  ";
		for (int i = 0; i < SIZE; i++) {
			str += (char) ('A' + i);
			str += "  ";
		}
		System.out.println(str);
	}

}
