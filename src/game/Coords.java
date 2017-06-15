package game;

public class Coords {
	public int x;
	public int y;

	public Coords(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public Coords() {
	}

	@Override
	public String toString() {
		char c = (char) ('A' + x);
		return "" + c + (y + 1);
	}

}