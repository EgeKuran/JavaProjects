package EgeKuran.HomeworkBattleShip;
import java.util.Scanner;

public class HumanPlayer extends Player{
	private Scanner scan = new Scanner(System.in);
	private Direction directionType;
	private GameBoard board =null;
	private boolean isOutOfBounds;
	private AIPlayer aIPlayer;
	
	public HumanPlayer() {
		super();
		
	}

	@Override
	public void placeShip(ShipType[]shipType) {
		
		for (ShipType shipTypes: shipType) {
			switch (shipTypes) {
			case CARRIER:
				System.out.println("Enter the coordinates for the CARRIER:(Size=5)");
				break;			
			case BATTLESHIP:
				System.out.println("Enter the coordinates for the BATTLESHIP:(Size=4)");
				break;
			case SUBMARINE:
				System.out.println("Enter the coordinates for the SUBMARINE:(Size=3)");
				break;
			case CRUISER:
				System.out.println("Enter the coordinates for the CRUISER:(Size=3)");
				break;
			case DESTROYER:
				System.out.println("Enter the coordinates for the DESTROYER:(Size=2)");
				break;
			}
			isOutOfBounds=true;
			while (isOutOfBounds) {
				if (board == null)// if board is initialized dont call a new board again
				{
					board = new GameBoard();
				}
				if(aIPlayer == null) 
				{
					aIPlayer = new AIPlayer();
				}
				
				//row
				System.out.println("ROW: ");
				String rowInput = scan.next();
				//column
				System.out.println("COLUMN");
				String columnInput = scan.next();
				boolean directionInputCheck = false;

				while (!directionInputCheck) 
				{
					System.out.println("Do you want to place the ship horizontal or vertical? H/V");
					String directionInput = scan.next();
					if (directionInput.equalsIgnoreCase("H")) {
						directionType = Direction.HORIZONTAL;
						directionInputCheck = true;
					} else if (directionInput.equalsIgnoreCase("V")) {
						directionType = Direction.VERTICAL;
						directionInputCheck = true;
					} else {
						System.out.println("Please enter \"H\" for Horizontal and \"V\" for Vertical");
						directionInputCheck = false;
					}
				}
				//PLACING SHIPS
				int r = (Integer.parseInt(rowInput) - 1);
				int c = (Integer.parseInt(columnInput) - 1);
				
				for (int row = 0; row < board.getRow(); row++) 
				{
					for (int column = 0; column < board.getColumn(); column++) 
					{
						
						if (r+ shipTypes.getSize() <= board.getRow()	& c + shipTypes.getSize() <= board.getColumn()) // Check the ship if in the board
						{
							//place the ship on an empty grid according to user input
							if (row == r & column == c & board.gameBoard[row][column] == -1) {
								if (directionType == Direction.HORIZONTAL) // place the ship horizontally
								{
									for (int size = 0; size < shipTypes.getSize(); size++) {
										board.gameBoard[row][column + size] = shipTypes.getSymbol();
										isOutOfBounds = false;
									}
								} else // place the ship vertically
								{
									for (int size = 0; size < shipTypes.getSize(); size++) {
										board.gameBoard[row + size][column] = shipTypes.getSymbol();
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
		System.out.println("All of your ships are in place!");
		board.showBoard(this);
	}

	@Override
	public void shoot() {
		
		try {
			System.out.println("Where do you want to shoot?");
			System.out.println("Row:");
			int r = scan.nextInt()-1;
			System.out.println("Column:");
			int c = scan.nextInt() -1;
			for (int row = 0; row < board.getRow(); row++) 
			{
				for (int column = 0; column < board.getColumn(); column++) 
				{
					if(r==row & c==column  ) 
					{
						
						if(aIPlayer.getEnemyBoard().getGameBoard(aIPlayer)[row][column] != -1  )
							{aIPlayer.getEnemyBoard().getGameBoard(aIPlayer)[row][column]=1;}//HIT
						else 
						{aIPlayer.getEnemyBoard().getGameBoard(aIPlayer)[row][column]=0;} //MISS
					}	
				}
			}
			board.showBoard(aIPlayer);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public GameBoard getBoard() {
		return board;
	}
}
