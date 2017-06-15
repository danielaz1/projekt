package strategy;

import java.util.ArrayList;

import game.Move;

public interface IStrategy {

	public Move chooseMove(ArrayList<Move> possibleMoves);

}
