package strategy;

import java.util.ArrayList;
import java.util.Random;

import game.Move;

public class RandomStrategy implements IStrategy {

	@Override
	public Move chooseMove(ArrayList<Move> possibleMoves) {
		int listSize = possibleMoves.size();
		int random = new Random().nextInt(listSize);
		return possibleMoves.get(random);
	}

}
