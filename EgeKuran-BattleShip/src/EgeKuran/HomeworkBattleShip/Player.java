package EgeKuran.HomeworkBattleShip;

public abstract class Player {
	ShipType shipType;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void placeShip(ShipType[] shiptype );
	public abstract void shoot();

}
