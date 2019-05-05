package EgeKuran.HomeworkBattleShip;

public class Ship {
	private String[] shipOrigin; // for placing the ships head at a point
	private Direction shipDirection; //For placing the rest of the ship ,after placing the ships head 
	private ShipType shipType;
	
	public Ship(String[] shipOrigin, Direction shipDirection, ShipType shipType) {
		super();
		this.shipOrigin = shipOrigin;
		this.shipDirection = shipDirection;
		this.shipType = shipType;
	}
	
	public String[] getShipOrigin() {
		return shipOrigin;
	}
	public Direction getShipDirection() {
		return shipDirection;
	}
	public ShipType getShipType() {
		return shipType;
	}
}
