package game;

public class Pawn {

	private Coords coords = new Coords();
	private Colour colour;

	public Pawn(int x, int y, Colour colour) {

		this.coords.x = x;
		this.coords.y = y;
		this.colour = colour;
	}

	public int getColumn() {
		return coords.x;
	}

	public int getRow() {
		return coords.y;
	}

	public void setCoords(Coords coords) {
		this.coords = coords;
	}

	public Colour getColour() {
		return colour;
	}

	@Override
	public String toString() {
		return Colour.WHITE.equals(colour) ? "o" : "x";
	}

}
