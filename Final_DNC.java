import java.util.Arrays;
import java.util.Scanner;

public class Final_DNC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String board[][] = new String[3][3];
		Scanner name = new Scanner(System.in);
		Scanner coordinate = new Scanner(System.in);
		int size = board.length;
		int turn = 0;
		int openSpaces = 9;
		Boolean gameDone = false;
		Boolean coordinateValid = true;
		// Player 0 = 0 & Player 1 = 1
		System.out.println("Please enter the first player's name");
		String player0 = name.next();
		System.out.println("Please enter the second player's name");
		String player1 = name.next();
		//Player 0 = X and Player 1 = O
		//Setting all strings in the board to a dash
		for( int i = 0; i < size; i++) {
			for( int j = 0; j < size; j++) {
				board[i][j] = "-";
			}
		}
		printArray(board);
		while(openSpaces != 0 && !gameDone) {
			String currValue = "blah";
			System.out.println("Please enter the x coordinate - (0,1,2)");
			int x = coordinate.nextInt();
			System.out.println("Please enter the y coordinate- (0,1,2)");
			int y = coordinate.nextInt();
			if(x<=2 && y<=2) {
				currValue = board[x][y];
			}else {
				currValue = "blah";
			}
			if(currValue == "-") {
				if(turn == 0) {
					board[y] [x] = "X";
				}else {
					board[y][x] = "O";
				}
				if(checkWinner(board,turn, x, y)){
					if(turn ==0) {
						System.out.println("Congratulations " + player0 + " won!");
						printArray(board);
					}else {
						System.out.println("Congratulations " + player1 + " won!");
						printArray(board);
					}
					gameDone=true;
				}else {
					if(turn == 0) {
						System.out.println("It is now " + player1 + "'s turn");
						turn = 1;
					} else {
						System.out.println("It is now " + player0 + "'s turn");
						turn = 0;
					}
					printArray(board);
				}
				coordinateValid = true;
			}else {
				coordinateValid = false;
				System.out.println("Invalid Coordinate - Please re-enter");
			}
		}
			if(coordinateValid) {
				openSpaces--;
			}
		}	
		
		


	public static Boolean checkWinner(String[][] board, int turn , int x, int y){
		String currValue;
		int sumrow  = 0;
		int sumcol = 0;
		int sumdiagb = 0;
		if(turn == 0) {
			currValue = "X";
		} else {
			currValue = "O";
		}
		
		for( int i = 0; i< board.length; i++) {

			for(int j = 0; j< board.length; j++) {
				if(board[i][j] == currValue) {
					sumrow++;
				}else if(board[j][i] == currValue){
					sumcol++;
				}
			}
			if(board[i][i] == currValue) {
				sumdiagb++;
			}
			if(sumrow ==3 || sumcol ==3 || sumdiagb == 3) {
				return true;
			} else {
				sumrow = 0;
				sumcol = 0;
			}
		}
		if(currValue == board[0][2] && currValue == board[1][1] && currValue == board[2][0] ) {
			return true;
		}
		return false;
	}
	
	public static void printArray(String[][] board) {
		System.out.println("   0, 1, 2");
		for(int i = 0; i < board.length; i++) {
			System.out.print(i + " ");
			System.out.println(Arrays.toString(board[i]));	
		}
	}
	
	
	
}
