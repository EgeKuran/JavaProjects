package EgeKuran.HomeworkBattleShip;

public enum ShipType {
	
	CARRIER(5,2),BATTLESHIP(4,3),CRUISER(3,4),SUBMARINE(3,5),DESTROYER(2,6);
	
	private int size;
	private int symbol;

	private ShipType(int size, int symbol) {
		this.size = size;
		this.symbol = symbol;
	}

	public int  getSize() {
		return size;
	}

	public int getSymbol() {
		return symbol;
	}
	

}
