import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static List<Integer> movesPlayedbyPlayer = new ArrayList<>();
	static List<Integer> movesPlayedbyAI = new ArrayList<>();
	private static String playerMark = "X";
	private static String aiMark = "O";

	public static void main(String[] args) {

		String[][] grid = { { "_", "|", "_", "|", "_" },
				{ "_", "|", "_", "|", "_" },
				{ "_", "|", "_", "|", "_" }, };

		List<String> movesAvailable = new ArrayList<>(
				List.of("1", "2", "3", "4", "5", "6", "7",
						"8", "9"));
		System.out.println(
				"Welcome to Tic-Tac-Toe \nYou will play as 'X' and the AI will play as 'O' \nGood luck!\n");

		displayGrid(grid);
		while (!movesAvailable.isEmpty()
				&& checkWinner(grid) == false) {
			makeMove(grid, movesAvailable);
			displayGrid(grid);
			checkWinner(grid);
			aiMakesMove(grid, movesAvailable);
			displayGrid(grid);
			checkWinner(grid);
		}
		System.out.println("Game Over!");
	}

	private static boolean checkWinner(String[][] grid) {

		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> middleRow = Arrays.asList(4, 5, 6);
		List<Integer> bottomRow = Arrays.asList(7, 8, 9);
		List<Integer> topCol = Arrays.asList(1, 4, 7);
		List<Integer> middleCol = Arrays.asList(2, 5, 8);
		List<Integer> bottomCol = Arrays.asList(3, 6, 9);
		List<Integer> cross1 = Arrays.asList(7, 5, 3);
		List<Integer> cross2 = Arrays.asList(1, 5, 9);

		List<List> winningConditions = new ArrayList<List>();

		winningConditions.add(topRow);
		winningConditions.add(topCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		winningConditions.add(middleCol);
		winningConditions.add(middleRow);
		winningConditions.add(bottomCol);
		winningConditions.add(bottomRow);

		for (List l : winningConditions) {
			if (movesPlayedbyPlayer.containsAll(l)) {
				System.out.println("\nYou Win!");
				return true;
			} else if (movesPlayedbyAI.containsAll(l)) {
				System.out.println("\nThe AI wins!");
				return true;
			}
		}
		return false;
	}

	private static void aiMakesMove(String[][] grid,
			List<String> movesAvailable) {

		Random rand = new Random();
		String aiMove = movesAvailable
				.get(rand.nextInt(movesAvailable.size()));

		move(grid, movesAvailable, aiMove, aiMark);
		System.out.println(
				"\nAI places an 'O' at " + aiMove + "\n");
	}

	private static void makeMove(String[][] grid,
			List<String> movesAvailable) {
		Scanner scan = new Scanner(System.in);
		String move = null;
		
		while(!movesAvailable.contains(move)) {
			System.out.println(
					"\nEnter the position on the grid you want to fill (1-9): ");
			move = scan.nextLine();
			
			if (movesAvailable.contains(move)) {
				move(grid, movesAvailable, move, playerMark);
				break;				
			}
			else {				
				continue;
			}
		}
	}	
		

	private static void move(String[][] grid,
			List<String> movesAvailable, String move,
			String mark) {
		switch (move) {
			case "1":
				grid[0][0] = mark;
				collectMoves(mark, 1);
				movesAvailable.remove("1");
				break;
			case "2":
				grid[0][2] = mark;
				collectMoves(mark, 2);
				movesAvailable.remove("2");
				break;
			case "3":
				grid[0][4] = mark;
				collectMoves(mark, 3);
				movesAvailable.remove("3");
				break;
			case "4":
				grid[1][0] = mark;
				collectMoves(mark, 4);
				movesAvailable.remove("4");
				break;
			case "5":
				grid[1][2] = mark;
				collectMoves(mark, 5);
				movesAvailable.remove("5");
				break;
			case "6":
				grid[1][4] = mark;
				collectMoves(mark, 6);
				movesAvailable.remove("6");
				break;
			case "7":
				grid[2][0] = mark;
				collectMoves(mark, 7);
				movesAvailable.remove("7");
				break;
			case "8":
				grid[2][2] = mark;
				collectMoves(mark, 8);
				movesAvailable.remove("8");
				break;
			case "9":
				grid[2][4] = mark;
				collectMoves(mark, 9);
				movesAvailable.remove("9");
				break;
			}	 
		} 	

	private static void collectMoves(String mark, int i) {
		if (mark == "X") {
			movesPlayedbyPlayer.add(i);
		} else if (mark == "O") {
			movesPlayedbyAI.add(i);
		}
	}

	private static void displayGrid(String[][] grid) {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				System.out.print(grid[r][c]);
			}
			System.out.println();
		}
	}

}
