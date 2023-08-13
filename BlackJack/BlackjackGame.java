import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random; 

/**
 * A class that acts as view of game.
 * @author Harjot, 2023
*/

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	boolean loop=true;

        System.out.println("Welcome to Blackjack!");
	System.out.println("");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
	 System.out.println("");
       while(loop){
	System.out.println("Login to start the game");
	System.out.println("");
	System.out.println("Enter the username");
	String username1= scanner.nextLine();

	System.out.println("Enter the password");
	String password1= scanner.nextLine();
	
	 if(username.equals(username1) && password.equals(password1)){
	
        	Game game = new Game(username, password);
        	game.startGame();

        	game.playerTurn(scanner);
        	game.dealerTurn();
        	game.declareWinner();
		
		System.out.println("Do you want to continue the game(yes/no)");
		String ans=scanner.nextLine().toUpperCase();
		if(ans.equals("YES")){
		 loop=true;
		}
		else{
		 System.out.println("Exiting!!");
		  loop=false;
		}
	 }
	 else{ loop=true;}
       }
	 scanner.close();
      }
	
    }
      
