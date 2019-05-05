package EgeKuran.HomeworkBattleShip;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BattleShipGame {
	
	public static void main(String[] args) {
		boolean playAgain= true;
		boolean gameOver =false;
		Scanner scan = new Scanner(System.in);
	
		//DISPLAY THE GAME RULES-
		try(FileReader reader=new FileReader("C:/Users/MSÝ/Desktop/BattleShipRules.txt");) {
			StringBuilder buffer = new StringBuilder();
				int output =0;
				while((output =reader.read())!= -1)
				{
					buffer.append((char)output);					
				}
				JOptionPane.showMessageDialog(null,buffer );
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//-DISPLAY THE GAME RULES
	
		while(playAgain)
		{	
			int turnCounter =0;
			
			gameOver=false;
					
			
			AIPlayer compPlayer = new AIPlayer();
			HumanPlayer humanPlayer = new HumanPlayer();
	

			humanPlayer.placeShip(new ShipType[] {ShipType.BATTLESHIP,ShipType.CARRIER,ShipType.CRUISER,ShipType.DESTROYER, ShipType.SUBMARINE});
			compPlayer.placeShip(new ShipType[] {ShipType.BATTLESHIP,ShipType.CARRIER,ShipType.CRUISER,ShipType.DESTROYER, ShipType.SUBMARINE});
			
			
			
			while(!gameOver) 
			{
				turnCounter++;
				System.out.println("Turn:" + turnCounter);

				humanPlayer.shoot();
				compPlayer.shoot();
				
			// CONTROL IF GAME IS OVER-
				int counterHuman =0;
				int counterAI =0;
				for (int row = 0; row < humanPlayer.getBoard().getRow(); row++) 
				{
					for (int column = 0; column <humanPlayer.getBoard().getColumn(); column++) 
					{
				if(humanPlayer.getBoard().gameBoard[row][column] !=2 | humanPlayer.getBoard().gameBoard[row][column] !=3
						| humanPlayer.getBoard().gameBoard[row][column] !=4 | humanPlayer.getBoard().gameBoard[row][column] !=5 | humanPlayer.getBoard().gameBoard[row][column] !=6) 
				{
					counterHuman++;
				}
				
					}
				}
				if(counterHuman == (humanPlayer.getBoard().getRow())* (humanPlayer.getBoard().getColumn()) ) 
				{
					gameOver= true;
					System.out.println("You LOST!!");
				}
				
				
				for (int row = 0; row < compPlayer.getEnemyBoard().getRow(); row++) 
				{
					for (int column = 0; column <compPlayer.getEnemyBoard().getColumn(); column++) 
					{
				if(compPlayer.getEnemyBoard().gameBoard[row][column] !=2 | compPlayer.getEnemyBoard().gameBoard[row][column] !=3
						| compPlayer.getEnemyBoard().gameBoard[row][column] !=4 | compPlayer.getEnemyBoard().gameBoard[row][column] !=5 | compPlayer.getEnemyBoard().gameBoard[row][column] !=6) 
				{
					counterAI++;
				}
				
					}
				}
				if(counterAI == (compPlayer.getEnemyBoard().getRow())* (compPlayer.getEnemyBoard().getColumn()) ) 
				{
					gameOver= true;
					System.out.println("You WIN!!");
				}
			}
			
			
		
	
			//ask the player if playing again
			System.out.println("Do you want to play again?  Y/N");
			String setPlayAgain =scan.next();
			playAgain = setPlayAgain.equalsIgnoreCase("Y");
		
		}
		}
	}


