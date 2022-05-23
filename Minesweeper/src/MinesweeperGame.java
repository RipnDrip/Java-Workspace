//package cs1302.game;

//import java.lang.StringIndexOutOfBoundsException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the {@code Minesweeper} class that runs the Minesweeper game.
 */
public class MinesweeperGame {
	private int roundNum = 0;
	private int score = 0;
	private int row = 0;
	private int col = 0;
	private int playerRow = 0;
	private int playerCol = 0;
	private int mineNum = 0;
	private int adjacentMines = 0;

	private String location = "";
	private String realCommand = "";
	private String realLocation = "";
	private String realRows = "";
	private String realCols = "";
	private String cols = "";
	private String [][] mineMap;
	private String [][] playerMap;

	private boolean done = false;

	/**
	 * This is the constuctor takes input through the {@code seed} where the conditions for
	 * the game is stored.
	 * 
	 * @param seed This is where the game conditions are set.
	 */
	public MinesweeperGame(String seed) {

		try {
			Scanner config = new Scanner(new File(seed));
			row = config.nextInt();
			col = config.nextInt();
			mineNum =config.nextInt();

			if ((row < 5) || (col < 5)) {
				System.out.println("Seedfile Value Error: Cannot " +
						"create a mine field with that many rows and/or columns!");
				System.exit(3);
			}

			this.mineMap = new String [row][col];

			int a = 0,
			b = 0;
			while (config.hasNext()) {
				a = config.nextInt();
				b = config.nextInt();
				this.mineMap[a][b] = "Mine";
			} // For

		} catch (FileNotFoundException e) {

			if (seed == null) {
				System.err.println(e);
				e.printStackTrace();
				System.out.println("Seedfile Not Found Error: "
						+ "Cannot create game with " + seed
						+ ", because it cannot be be found or cannot be read due to permission.\n");
				System.exit(1);
			}

			if (mineNum > (row * col )) {
				System.err.println(e);
				e.printStackTrace();
				System.out.println("Seedfile Format Error: Cannot create a mine field  with that many rows and/or colmuns.");
				System.exit(3);
			}

		} catch (InputMismatchException ime) {
			System.err.println(ime);
			ime.printStackTrace();
			System.out.println("Seedfile Format Error: Cannot create game with " + seed
					+ ", because it is not formatted correctly.");
			System.exit(1);

		}
	} // Constructor

	/**
	 * Creates the map field for the player.
	 */
	public void createPlayerMap() {
		String [][] playerMap = new String [row][col];
		for (int l = 0; l < row; l++) {
			for (int m = 0; m < col; m++) {
			}
		}
		this.playerMap = playerMap;
	} // createPlayerMap

	/**
	 * The {@code printWelcome} is the  method that prints the welcome bannner.
	 */
	public void printWelcome() {
		System.out.println("     _\r\n" + 
				"  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __\r\n" + 
				" /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|\r\n" + 
				"/ /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |\r\n" + 
				"\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|\r\n" + 
				"                 A L P H A   E D I T I O N |_| v2020.sp");
	} // print Welcome

	/**
	 * This the {@code printMineField} method that is 
	 * meant to print out the minefield for the Minesweeper game,
	 * prior to making any moves.
	 */
	public void printMineField() {
		int xPlane = 0;
		int yPlane = 0;
		String empty = " ";
		String format = " |%3s";
		System.out.print("\n");
		System.out.println("Rounds Completed: " + this.roundNum);
		System.out.print("\n");

		for (int a = 0;a < row; a++) {
			System.out.print(yPlane++);
			if (a == 10) {
				format = "|%4s";
			}
			for (int b = 0; b < col; b++) {
				System.out.print(String.format(format, empty));
			}
			if (a < 10) {
				System.out.print(" |");
			} else if (a >= 10) {
				System.out.print("|");
			}
			System.out.print("\n");
		}

		String xFormat = "%5d";
		String newXFormat = " %5d";   
		for (int x = 0;x < col;x++ ) {
			if (x == 10) {
				System.out.print(String.format(newXFormat, xPlane++));
			} else {
				System.out.print(String.format(xFormat, xPlane++));
			}
		}

		System.out.print("\n\nminesweeper-alpha: ");
	} // printMineField

	/**
	 * This method is used to prompt the user to make a move and take input.
	 *
	 */
	public void promptUser() {
		Scanner input = new Scanner(System.in);
			String command = "";
		String result = "";
		String tr = "";
		command = input.nextLine();
		String [] commandArray = new String [command.length()];

		for (int j = 0;j < command.length(); j++) {
			result += command.charAt(j);
			commandArray[j] = result.substring(j);
		}

		if (result.length() == 1 && (result.equalsIgnoreCase("q") || result.equalsIgnoreCase("h"))) {
			this.realCommand = result;
		} else if (result.length() < 4) {
			if(!(tr.equalsIgnoreCase("reveal") || tr.equalsIgnoreCase("r") ||
					tr.equalsIgnoreCase("mark") || tr.equalsIgnoreCase("m") ||
					tr.equalsIgnoreCase("guess") || tr.equalsIgnoreCase("g") ||
					tr.equalsIgnoreCase("quit") || tr.equalsIgnoreCase("q") ||
					tr.equalsIgnoreCase("help") || tr.equalsIgnoreCase("h")) ||
					tr.equalsIgnoreCase("nofog") || tr.equalsIgnoreCase("help") || 
					tr.equalsIgnoreCase("h")) {
				System.out.println("Command not recognized!");
				promptUser();
				return;
			} else {
				promptUser();
				return;
			}
		} else {
			tr = result.trim();	

			if (tr.equalsIgnoreCase("nofog")) {
				this.realCommand = "nofog";
				this.roundNum++;
				revealMines();
				return;
			}

			if (tr.equalsIgnoreCase("help") || tr.equalsIgnoreCase("h")) {
				this.realCommand = tr;
				return;
			}

			if (tr.length() == 1) {
				this.realCommand = tr.substring(0, tr.indexOf(" "));            
				if (this.realCommand.equalsIgnoreCase("guess") || this.realCommand.equalsIgnoreCase("g")) {
					this.realCommand = "?";

				} else if (this.realCommand.equalsIgnoreCase("mark") || this.realCommand.equalsIgnoreCase("m")) {
					this.realCommand = "F";

				} else if (this.realCommand.equalsIgnoreCase("reveal") || this.realCommand.equalsIgnoreCase("r")) {

					for (int a = 0;a < row; a++) {
						for (int b = 0;b < col;b ++) {
							if ((mineMap[a][b] != "Mine") && ((a == playerRow) && (b == playerCol))) {

							} else if ((mineMap[a][b] == "Mine") && 
									((a == playerRow) && (b == playerCol)) && 
									(this.realCommand.equalsIgnoreCase("reveal") ||
											this.realCommand.equalsIgnoreCase("r"))) {
								isLost();
								printLoss();
							}
						}   
					} // Check playerMap and mineMap

					checkAdjacentMines();
					this.realCommand = Integer.toString(this.adjacentMines);
				}  else if (this.realCommand.equalsIgnoreCase("help") || this.realCommand.equalsIgnoreCase("h")) {
					this.realCommand = "";
				}
				if (this.realCommand.equalsIgnoreCase("nofog")) {
					this.realCommand = "< >";
				}
			} else {

				this.realCommand = tr.trim().substring(0, tr.indexOf(" "));
				this.location = tr.substring(tr.trim().indexOf(" "), tr.length());
				this.realLocation = location.trim();

				if (this.realLocation.length() < 3) {
					System.out.println("Command not recognized!");
					promptUser();
					return;
				}

				this.realRows = realLocation.substring(0,1);
				this.cols = realLocation.substring(realLocation.trim().indexOf(" "), realLocation.length());
				this.realCols  = cols.trim();
				
				try {
				this.playerRow = Integer.parseInt(realRows);
				this.playerCol = Integer.parseInt(realCols);
				} catch (NumberFormatException nfe) {
					System.out.println("Command not recognized!");
					promptUser();
				}
				
				if (this.playerRow > this.row || this.playerCol > this.col) {
					System.out.println("Out of bounds.");
					promptUser();
				}

				if (this.realCommand.equalsIgnoreCase("guess") || this.realCommand.equalsIgnoreCase("g")) {
					this.realCommand = "?";
				} else if (this.realCommand.equalsIgnoreCase("mark") || this.realCommand.equalsIgnoreCase("m")) {
					this.realCommand = "F";
				} else if (this.realCommand.equalsIgnoreCase("reveal") || this.realCommand.equalsIgnoreCase("r")) {
					for (int a = 0;a < row; a++) {
						for (int b = 0;b < col;b ++) {
							if ((mineMap[a][b] == "Mine") && ((a == playerRow) && (b == playerCol)) &&
									(this.realCommand.equalsIgnoreCase("reveal") ||
											this.realCommand.equalsIgnoreCase("r"))) {
								isLost();
								printLoss();
							}
						}   
					} // Check playerMap and mineMap

					checkAdjacentMines();
					this.realCommand = Integer.toString(this.adjacentMines);
				} else if (this.realCommand.equalsIgnoreCase("help") || this.realCommand.equalsIgnoreCase("h")) {
					this.realCommand = "";
				}

				if (this.realCommand.equalsIgnoreCase("nofog")) {
					this.realCommand = "< >";
				}

			} // else		
		} // if/else

		if (this.realCommand.equalsIgnoreCase("quit") || this.realCommand.equalsIgnoreCase("q")) {
			System.out.println("Quitting the game....\nBye!");
			System.exit(0);
		}
	} // promptUser

	/**
	 * Method used to progress through the game.
	 *
	 */
	public void play() {
		printWelcome();
		printMineField();
		while (this.done == false) {
			if (this.roundNum == 0) {
				createPlayerMap();
			}
			promptUser();
			this.roundNum++;
			if (this.realCommand.equalsIgnoreCase("help") || this.realCommand.equalsIgnoreCase("h")) {
				System.out.println("Commands Available...\n" +
						"- Reveal: r/reveal row col\n" +
						"- Mark: m/mark   row col\n"  +
						"- Guess: g/guess  row col\n" +
						"- Help: h/help\n" +
						"- Quit: q/quit");   
			}
			
			if (this.realCommand.equalsIgnoreCase("nofog")) {
				this.roundNum--;
			} else {
				updateMineField();
				printEverything();	
			}
		}
	} // play

	/**
	 * Updates minefield as the player makes moves.
	 */
	public void updateMineField() {
		for (int l = 0; l < row; l++) {
			for (int m = 0;m < col; m++) {
				if (l == this.playerRow && m == this.playerCol) {


					if (this.playerMap[l][m] == "mark" || this.playerMap[l][m] == "m"
							|| this.playerMap[l][m] == "guess" || this.playerMap[l][m] == "g" ||
							this.playerMap[l][m] == "reveal" || this.playerMap[l][m] == "r" ||
							this.playerMap[l][m] == "help" || this.playerMap[l][m] == "h" ||
							this.playerMap[l][m] == "no fog") {

						if (this.realCommand.equalsIgnoreCase("help") || this.realCommand.equalsIgnoreCase("h")) {
							this.realCommand = "";
						}
						this.playerMap[l][m] += " " + this.realCommand;

					} else {
						if (this.playerMap[l][m] == "no fog") {
							this.playerMap[l][m] = null;
						} else if (this.realCommand.equalsIgnoreCase("help") || this.realCommand.equalsIgnoreCase("h")) {
						} else {
							this.playerMap[l][m] = this.realCommand;
						}
					}
				}
			}
		} // fills playerMap

		for (int a = 0;a < row; a++) {
			for (int b = 0;b < col;b ++) {
				if ((mineMap[a][b] != "Mine") && ((a == playerRow) && (b == playerCol))) {
					System.out.println("");
				} else if ((mineMap[a][b] == "Mine") && ((a == playerRow) && (b == playerCol)) &&
						(this.realCommand.equalsIgnoreCase("reveal") ||
								this.realCommand.equalsIgnoreCase("r"))) {
					isLost();
					printLoss();
				}
			}   
		} // Check playerMap and mineMap
		
		if (this.done == true) {
			printWin();
		}
	} // updateMineField

	/**
	 * Prints the entire map excluding the mines.
	 */
	public void printEverything() {     
		int xPlane = 0;
		int yPlane = 0;
		String empty = " ";
		String format = " |%3s";

		System.out.print("\n");
		System.out.println("Rounds Completed: " + this.roundNum);
		System.out.print("\n");

		for (int a = 0;a < row; a++) {
			System.out.print(yPlane++);
			if (a == 10) {
				format = "|%4s";
			}
			for (int b = 0; b < col; b++) {

				if (this.playerMap[a][b] == null) {
					System.out.print(String.format(format, empty));
				}
				if ((this.playerMap[a][b] != null) && 
						!(this.playerMap[a][b] == "help" || this.playerMap[a][b] == "")) {
					System.out.print(String.format(format, this.playerMap[a][b]));
				}
			}
			if (a < 10) {
				System.out.print(" |");
			} else if (a >= 10) {
				System.out.print("|");
			}
			System.out.print("\n");
		}
		String xFormat = "%5d";
		String newXFormat = " %5d";   
		for (int x = 0;x < col;x++ ) {
			if (x == 10) {
				System.out.print(String.format(newXFormat, xPlane++));
			} else {
				System.out.print(String.format(xFormat, xPlane++));
			}
		}
		System.out.print("\n\nminesweeper-alpha: ");



	} // printEverything

	/**
	 * Confirms that the game has been won.
	 *
	 * @return true.
	 */
	public boolean isWon() {
		int confirmedMark = 0;
		int rCounter = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (this.playerMap[i][j] != null) {
				} else {
					return this.done;
				}
			}
		}

		//check
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((this.mineMap[i][j] != "Mine" || this.mineMap[i][j] == null) &&
						(this.playerMap[i][j] == "reveal" || this.playerMap[i][j] == "r")) {
					rCounter++;
				}
				if (this.mineMap[i][j] == "Mine" && (this.playerMap[i][j] == "mark" || this.playerMap[i][j] == "m")) {
					confirmedMark++;
				}
				if (confirmedMark == this.mineNum && (rCounter == (row * col - this.mineNum))) {
					this.done = true;
				}
			}
		}
		return this.done;
	} // isWon

	/**
	 * Confirms that the game is lost.
	 *
	 * @return true.
	 */

	public boolean isLost() {
		return true;
	}

	/**
	 * Message to be printed when game is won. 
	 */
	public void printWin() {
		System.out.println("\r\n" + 
				"░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░ \"So Doge\"\r\n" + 
				" ░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░\r\n" + 
				" ░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░ \"Such Score\"\r\n" + 
				" ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░\r\n" + 
				" ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░ \"Much Minesweeping\"\r\n" + 
				" ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░\r\n" + 
				" ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░ \"Wow\"\r\n" + 
				" ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░\r\n" + 
				" ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░\r\n" + 
				" ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░\r\n" + 
				" ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░\r\n" + 
				" ▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌\r\n" + 
				" ▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░\r\n" + 
				" ░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░\r\n" + 
				" ░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░\r\n" + 
				" ░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░\r\n" + 
				" ░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░ CONGRATULATIONS!\r\n" + 
				" ░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░ YOU HAVE WON!\r\n" + 
				" ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░ SCORE" + this.score);
		System.exit(0);
	}

	/**
	 * Message to be printed when the game is lost.
	 */
	public void printLoss() {
		System.out.println("\r\n" + 
				" Oh no... You revealed a mine!\r\n" + 
				"  __ _  __ _ _ __ ___   ___    _____   _____ _ __\r\n" + 
				" / _` |/ _` | '_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ '__|\r\n" + 
				"| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ |\r\n" + 
				" \\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|\r\n" + 
				" |___/");
		System.exit(0);
	} // printLoss

	/**
	 * Calculates score while the player plays the game.
	 */
	public void calculateScore() {
		int score = 0;
		score = 100 * this.row * this.col / this.roundNum;
		this.score = score;
	} // calculateScore

	/**
	 * Checks for mines around where the player makes a move.
	 */
	public void checkAdjacentMines() {
		int adjacentMines = 0;
		for (int a = 0 ; a < row ; a++) {
			for (int b = 0 ; b < col ; b ++) {
				if (a == playerRow && b == playerCol) {
					if (a < row && playerRow+1 != row && mineMap[playerRow + 1][playerCol] == "Mine") {
						adjacentMines++;
					} 			
					if (a != 0 && mineMap[playerRow - 1][playerCol] == "Mine") {
						adjacentMines++;
					}
					if (b < col && playerCol+1 != col && mineMap[playerRow][playerCol + 1] == "Mine") {
						adjacentMines++;
					}          					
					if (b != 0 && mineMap[playerRow][playerCol - 1] == "Mine") {
						adjacentMines++;
					}

					if (a < row && b != 0 && playerRow+1 != row && mineMap[playerRow + 1][playerCol - 1] == "Mine") {
						adjacentMines++;
					}

					if (a != 0 && b < col && playerCol+1 != col && mineMap[playerRow - 1][playerCol + 1] == "Mine") {
						adjacentMines++;
					}
					if (a != 0 && b != 0 && mineMap[playerRow - 1][playerCol - 1] == "Mine") {
						adjacentMines++;
					}
					if (a < row && b < col && playerRow+1 != row && playerCol+1 != col && mineMap[playerRow + 1][playerCol + 1] == "Mine") {
						adjacentMines++;
					}
				} // if
			} // b
		} // a
		this.adjacentMines = adjacentMines;
	} // check adjacent mines

	/**
	 * This method reveals map with mines for 
	 * the 'no fog' command.
	 */
	public void revealMines() {
		int xPlane = 0;
		int yPlane = 0;
		String empty = " ";
		String format = " |%3s";
		String bomb = "< >";
		String markAndMine = "<F>";
		String guessAndMine = "<?>";

		System.out.print("\n");
		System.out.println("Rounds Completed: " + this.roundNum);
		System.out.print("\n");

		for (int a = 0;a < row; a++) {
			System.out.print(yPlane++);
			if (a == 10) {
				format = "|%4s";
			}
			for (int b = 0; b < col; b++) {

				if (this.playerMap[a][b] == null && this.mineMap[a][b] == "Mine") {
					System.out.print(String.format(format, bomb));
				} else if (this.playerMap[a][b] == null && this.mineMap[a][b] != "Mine") {
					System.out.print(String.format(format, empty));
				} else if (this.mineMap[a][b] == "Mine" && this.playerMap[a][b] == "F") {
					System.out.print(String.format(format, markAndMine));
				} else if (this.mineMap[a][b] == "Mine" && this.playerMap[a][b] == "?") {
					System.out.print(String.format(format, guessAndMine));
				} else {
					System.out.print(String.format(format, this.playerMap[a][b]));
				}
			}
			if (a < 10) {
				System.out.print(" |");
			} else if (a >= 10) {
				System.out.print("|");
			}
			System.out.print("\n");
		}

		String xFormat = "%5d";
		String newXFormat = " %5d";   
		for (int x = 0;x < col;x++ ) {
			if (x == 10) {
				System.out.print(String.format(newXFormat, xPlane++));
			} else {
				System.out.print(String.format(xFormat, xPlane++));
			}
		}
		System.out.print("\n\nminesweeper-alpha: ");

	} // revealMines

} // Minesweeper
