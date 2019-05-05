package EgeKuran.HomeworkBattleShip;
import java.util.Random;

public class AIPlayer extends Player {
private GameBoard enemyBoard= null; 
private Direction directionType;
private Random random = null;
private boolean isOutOfBounds;
private HumanPlayer humanPlayer;
	
	public AIPlayer() {
		super();
	}
	
	@Override
	public void placeShip(ShipType[] shipType) {
		
				
				for (ShipType shipTypes: shipType) {
					int countEmptySymbol=0;
					boolean isGridsEmpty;
					isOutOfBounds=true;
					while (isOutOfBounds) { 
						if (enemyBoard == null)// if board is initialized dont call a new board again
						{
							enemyBoard = new GameBoard();
						}
						if(humanPlayer == null) 
						{
							humanPlayer =new HumanPlayer();
						}
						//row
						random = new Random();
						int rowInput = random.nextInt(enemyBoard.getRow()) + 1;
						
						//column
						int columnInput = random.nextInt(enemyBoard.getColumn()) + 1;
					

						boolean directionInput = random.nextBoolean();
						if (directionInput) {
							directionType = Direction.HORIZONTAL;

						} else {
							directionType = Direction.VERTICAL;
						}
						
						//PLACING SHIPS
						int r =(rowInput - 1);
						int c = (columnInput - 1);	
					
						for (int row = 0; row < enemyBoard.getRow(); row++) 
						{
							for (int column = 0; column < enemyBoard.getColumn(); column++) 
							{
								
								if (r+ shipTypes.getSize() <= enemyBoard.getRow()	& c + shipTypes.getSize() <= enemyBoard.getColumn()) // Check the ship if in the board
								{
									//place the ship on an empty grid according to user input
									if (row == r & column == c & enemyBoard.gameBoard[row][column] == -1) {
										if (directionType == Direction.HORIZONTAL) // place the ship horizontally
										{
											for (int size = 0; size < shipTypes.getSize(); size++) {
												enemyBoard.gameBoard[row][column + size] = shipTypes.getSymbol();
												isOutOfBounds = false;
											}
										} else // place the ship vertically
										{
											for (int size = 0; size < shipTypes.getSize(); size++) {
												enemyBoard.gameBoard[row + size][column] = shipTypes.getSymbol();
												isOutOfBounds = false;
												//update ships symbol to the board
											}
										}

									}
									
								}
								else // ship is out of bounds 
								{
									isOutOfBounds=true;
								}
							}
						}
				}
			
		}
				enemyBoard.showBoard(this);
	}

	public GameBoard getEnemyBoard() {
		return enemyBoard;
	}

	@Override
	public void shoot() {
		
		int r =  random.nextInt(enemyBoard.getRow());
		
		int c = random.nextInt(enemyBoard.getColumn()) ;
		for (int row = 0; row <humanPlayer.getBoard().getRow(); row++) 
		{
			for (int column = 0; column < humanPlayer.getBoard().getColumn(); column++) 
			{
				if(r==row & c==column  ) 
				{
					if( humanPlayer.getBoard().gameBoard[row][column] !=-1)
						{humanPlayer.getBoard().gameBoard[row][column]=1;}//HIT
					else 
					{humanPlayer.getBoard().gameBoard[row][column]=0;} //MISS
				}	
			}
		}
		humanPlayer.getBoard().showBoard(humanPlayer);
		// TODO Auto-generated method stub
		
	
}
}
