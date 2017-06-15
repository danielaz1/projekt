import java.util.ArrayList;

import game.Board;
import game.Colour;
import game.Move;
import game.Pawn;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;
import strategy.CaptureStrategy;
import strategy.RandomStrategy;
import strategy.StrategyContext;

public class Main {

	static Board board;
	static Player player1;
	static Player player2;

	public static void main(String[] args) {
		start();
		play();
	}

	private static void play() {

		boolean end = false;

		Player currentPlayer = player1;
		Player opponent = player2;
		board.printBoard();

		while (!end) {

			ArrayList<Move> moves = board.getListOfPossibleMoves(currentPlayer.getPawns());
			currentPlayer.setPossibleMoves(moves);
			Move currentMove = currentPlayer.getMove();
			while (currentMove == null) {
				System.out.println("Bledny ruch");
				currentMove = currentPlayer.getMove();
			}

			System.out.println(currentMove);
			for (Pawn pawn : currentPlayer.getPawns()) {
				if (pawn.getColumn() == currentMove.getCoords1().x && pawn.getRow() == currentMove.getCoords1().y) {
					pawn.setCoords(currentMove.getCoords2());
					break;
				}
			}

			if (currentMove.isRemove() == true) {
				for (Pawn pawn : opponent.getPawns()) {
					if (pawn.getColumn() == currentMove.getCoords2().x && pawn.getRow() == currentMove.getCoords2().y) {
						opponent.getPawns().remove(pawn);
						break;
					}
				}

			}

			boolean pawnOnLastLine;
			if (currentPlayer.getColour().equals(Colour.WHITE)) {
				pawnOnLastLine = (currentMove.getCoords2().y == board.getSize()-1);
			} else {
				pawnOnLastLine = (currentMove.getCoords2().y == 0);
			}
			board.printBoard();

			if (opponent.getPawns().isEmpty() || pawnOnLastLine) {
				System.out.println("Wygral gracz: " + currentPlayer.getColour());
				end = true;
			}

			if (currentPlayer.equals(player1)) {
				currentPlayer = player2;
				opponent = player1;
			} else {
				currentPlayer = player1;
				opponent = player2;
			}

		}
	}

	private static void start() {
		board = new Board();
		player1 = new HumanPlayer(board.getWhitePawns());
		//player2 = new ComputerPlayer(board.getBlackPawns(), new StrategyContext(new CaptureStrategy()));
		player2 = new ComputerPlayer(board.getBlackPawns(), new StrategyContext(new RandomStrategy()));
	}

}
