package strategy;

import java.util.ArrayList;

import game.Move;

public class StrategyContext {

	private IStrategy strategy;

	public StrategyContext(IStrategy strategy) {
		this.strategy = strategy;
	}

	public Move executeStrategy(ArrayList<Move> possibleMoves) {
		return strategy.chooseMove(possibleMoves);
	}

}
