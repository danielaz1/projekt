package game;

public class Move {
	
	private Coords coords1=new Coords();
	private Coords coords2=new Coords();
	
	boolean remove;

	
	
	public Move(Coords coords1, Coords coords2, boolean remove) {
		this.coords1 = coords1;
		this.coords2 = coords2;
		this.remove = remove;
	}



	public Coords getCoords1() {
		return coords1;
	}



	public Coords getCoords2() {
		return coords2;
	}



	public boolean isRemove() {
		return remove;
	}



	@Override
	public String toString() {
		return "" + coords1 + "->" + coords2;
	}

	
	
}
