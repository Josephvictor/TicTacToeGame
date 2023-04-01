import java.util.Scanner;

public class TicTacToeApp {

	public static void main(String[] args) {
		
		char[][] board = new char[3][3];
		for(int row = 0; row<board.length;row++) {
			for(int col = 0; col<board[row].length;col++) {
				board[row][col] = ' ';
			}
		}
		
		char player = 'X';
		boolean isGameOver = false;
		int totalMoves = board.length * board[0].length;
		int gameMoves = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(!isGameOver) {
			printBoard(board);
			System.out.println("Player "+player+" make your move -->");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			
			if(board[row][col] == ' ') {
				
				board[row][col] = player;
				gameMoves++;
				
				isGameOver = haveWon(board,player);
				if(isGameOver) {
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Player "+player+" wins the game :) ");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					scanner.close();
				}else if(!isGameOver && gameMoves == totalMoves) {
					System.out.println("X--O *****DRAW****");
					isGameOver = true;
					scanner.close();
				}else {
					if(player == 'X') 	player = 'O';	
					else 				player = 'X';
				}
	
			}else {
				System.err.println("Wrong move.. Try again");
			}
		}
		
	}
	
	public static void printBoard(char[][] board) {
		
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] +" | ");
			}
			System.out.println();
		}
	}
	
	public static boolean haveWon(char[][] board, char player) {
		
		//check for same rows
		for(int row = 0; row < board.length; row++) {
			if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		
		//check for same columns
		for(int col = 0; col < board[0].length; col++) {
			if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		
		//check for diagonals
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
		
		//if not return false;
		return false;
	}
}
