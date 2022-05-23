
public class ComputerOpponent {
 static String getMove() {
	 String move = "";
	 int computeMove = (int) (Math.random() * 3); 
	 switch (computeMove)
		{
			case 0: move = "Rock";
			case 1: move = "Paper";
			case 2: move = "Scissors";
		}
	 return move;
	
}
}
