package strategy;

import java.util.ArrayList;

import game.Move;

public class CaptureStrategy implements IStrategy {

	@Override
	public Move chooseMove(ArrayList<Move> possibleMoves) {
		for (Move move : possibleMoves) {
			if (move.isRemove()) {
				return move;
			}
		}
		return possibleMoves.get(0);
	}

}
