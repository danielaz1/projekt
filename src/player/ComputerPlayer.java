package player;

import java.util.ArrayList;

import game.Colour;
import game.Move;
import game.Pawn;
import strategy.StrategyContext;

public class ComputerPlayer extends Player {

	private StrategyContext strategy;

	public ComputerPlayer(ArrayList<Pawn> pawns, StrategyContext strategy) {
		super(pawns);
		this.strategy = strategy;
		this.colour = Colour.BLACK;
	}

	@Override
	public Move getMove() {
		return this.strategy.executeStrategy(possibleMoves);
	}

}
