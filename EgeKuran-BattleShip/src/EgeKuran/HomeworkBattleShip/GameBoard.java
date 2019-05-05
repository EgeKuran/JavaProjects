package EgeKuran.HomeworkBattleShip;

public class GameBoard {

	private final int  row = 10;
	private final int column = 10;
	int[][] gameBoard= new int[this.getRow()][this.getColumn()] ;
	
	
	public GameBoard() {
		for(int row=0 ; row < this.getRow() ; row++ )
		{ for(int column=0 ; column <this.getColumn() ; column++ ) {
            this.gameBoard[row][column]=-1;}}
	}
	
	public int[][] getGameBoard(Player player) {
		
		if(player instanceof HumanPlayer)
		{
		return new HumanPlayer().getBoard().gameBoard;}
		return new AIPlayer().getEnemyBoard().gameBoard;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	
	public void showBoard(Player player){
		if(player instanceof HumanPlayer) 
		{
			System.out.println("---YOUR BOARD---");
			for(int i =0; i < getColumn(); i ++) 
			{
				System.out.print("\t" + (i+1) + " ");
			}
	        		
	        
	        System.out.println();
	        
	        for(int row=0 ; row < this.getRow() ; row++ ){
	            System.out.print((row+1)+"");
	            for(int column=0 ; column < this.getColumn() ; column++ ){
	            	
	                if(this.gameBoard[row][column]==-1){
	                    System.out.print("\t"+"~"); // Empty
	                }else if(this.gameBoard[row][column]==0){
	                    System.out.print("\t"+"*"); // Miss
	                }else if(this.gameBoard[row][column]==1){
	                    System.out.print("\t"+"X");// Hit
	                }
	                else if(this.gameBoard[row][column]==2)//Carrier Ship Symbol
	                		{
	                	System.out.print("\t" + "C");
	                		}
	                else if(this.gameBoard[row][column]==3)// BattleShip Symbol
	        		{
	                	System.out.print("\t" + "B");
	        		}
	                else if(this.gameBoard[row][column]==4)
	        		{
	                	System.out.print("\t" + "R");// Cruiser Ship Symbol
	        		}
	                else if(this.gameBoard[row][column]==5)
	        		{
	                	System.out.print("\t" + "S");// Submarine Ship Symbol
	        		}
	                else if(this.gameBoard[row][column]==6)
	        		{
	                	System.out.print("\t" + "D");// Destroyer Ship Symbol
	        		}
	            }
	            	System.out.println();
	        }

		}
		if (player instanceof AIPlayer) {
			System.out.println("---ENEMY BOARD---");
			for(int i =0; i < getColumn(); i ++) 
			{
				System.out.print("\t" + (i+1) + " ");
			}
	        		
	        
	        System.out.println();
	        
	        for(int row=0 ; row < this.getRow() ; row++ ){
	            System.out.print((row+1)+"");
	            for(int column=0 ; column < this.getColumn() ; column++ ){
	            	
	                if(this.gameBoard[row][column]==-1){
	                    System.out.print("\t"+"~"); // Empty
	                }else if(this.gameBoard[row][column]==0){
	                    System.out.print("\t"+"*"); // Miss
	                }else if(this.gameBoard[row][column]==1){
	                    System.out.print("\t"+"X");// Hit
	                }
	                else if(this.gameBoard[row][column]==2)//Carrier Ship Symbol
	                		{
	                	System.out.print("\t" + "~");
	                		}
	                else if(this.gameBoard[row][column]==3)// BattleShip Symbol
	        		{
	                	System.out.print("\t" + "~");
	        		}
	                else if(this.gameBoard[row][column]==4)
	        		{
	                	System.out.print("\t" + "~");// Cruiser Ship Symbol
	        		}
	                else if(this.gameBoard[row][column]==5)
	        		{
	                	System.out.print("\t" + "~");// Submarine Ship Symbol
	        		}
	                else if(this.gameBoard[row][column]==6)
	        		{
	                	System.out.print("\t" + "~");// Destroyer Ship Symbol
	        		}
	            }
	            	System.out.println();
	        }

		}

		
    }
	    
	}
	

