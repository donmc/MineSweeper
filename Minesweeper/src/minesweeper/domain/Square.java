package minesweeper.domain;


public abstract class Square implements minesweeper.shared.ISquare{

	private int location;
	private boolean isCovered;
	private boolean isMarked;
	
	public Square(int location) {
		this.location = location;
		isCovered = true;
	}

	public void addNeighbor(Square s) {
	};
	
	public void uncover() {
		if (isCovered && !isMarked) {
			MineSweeper.getInstance().incrementUncoveredCount();
			isCovered = false;
			goNude();
		}
	}

	public abstract int getValue();

	public abstract void goNude();
	
	public boolean isCovered() {
		return isCovered;
	}

	public boolean isMarked() {
		return isMarked;  
	}

	public int getLocation() {
		return location;
	}

	public void mark() {
		if (isCovered) {
			isMarked = !isMarked;
			if(isMarked)
				MineSweeper.getInstance().decrementMineCounter();
		}
	}
}