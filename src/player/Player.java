package player;

import java.util.ArrayList;

import game.Colour;
import game.Move;
import game.Pawn;

public abstract class Player {

	protected ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	protected ArrayList<Move> possibleMoves = new ArrayList<Move>();

	protected Colour colour;

	public Player(ArrayList<Pawn> pawns) {
		this.pawns = pawns;
	}

	public ArrayList<Pawn> getPawns() {
		return pawns;
	}

	public void setPawns(ArrayList<Pawn> pawns) {
		this.pawns = pawns;
	}

	public ArrayList<Move> getPossibleMoves() {
		return possibleMoves;
	}

	public void setPossibleMoves(ArrayList<Move> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}

	public Colour getColour() {
		return colour;
	}

	public abstract Move getMove();

}
