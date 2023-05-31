import java.util.*;
public class GameStart extends Main {
    static Scanner scan = new Scanner(System.in);
    public static void start(){
        String playerclass;
        String playername;
        System.out.println("Welcome to the game!");
        System.out.println("Please type your name: ");
        playername = scan.nextLine();
        System.out.println("Choose a class: w for warrior, r for ranger, m for mage");

        playerclass = scan.nextLine();
        Player player = new Player(playername, 0, 0, 0, 0, 0, "pheasant", true, 0, 0);
        if(playerclass.charAt(0) == 'w'){
            System.out.println("Warrior");
            player = new Player(playername, 100, 100, 20, 0, 0, "warrior", true, 0, 1);
        }
        if(playerclass.charAt(0) == 'r'){
            System.out.println("ranger");
            player = new Player(playername, 70, 70, 30, 0, 0, "ranger", true, 0, 1);
        }
        if(playerclass.charAt(0) == 'm'){
            System.out.println("mage");
            player = new Player(playername, 50, 50, 40, 15, 15, "mage", true, 0, 1);
        }
        else {
            System.out.println("Please input one of the requested characters");   
        }
        System.out.println("Your adventure begins!");
        System.out.println("To reach the Demon Lord you need to be at least level 5, you can kill the Demon Lords minions to gain experience.");
        GamePlay.gameloop(player);
    }
}