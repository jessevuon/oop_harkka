import java.util.*;
public class GameStart extends Main {
    static Scanner scan = new Scanner(System.in);
    public static void start(){
        String playerclass;
        String playername;
        System.out.println("Welcome to the game!");
        System.out.println("Please type your name: ");
        playername = "jesse";
        // TODO uncomment playername = scan.nextLine();
        System.out.println("Choose a class: w for warrior, r for ranger, m for mage");
        // TODO uncomment playerclass = scan.nextLine();
        playerclass = "w";
        LifeForm player = new LifeForm(playername, 0, 0, 0, "pheasant");
        // Use switch case
        if(playerclass.charAt(0) == 'w'){
            System.out.println("Warrior");
            player = new LifeForm(playername, 10, 0, 10, "warrior");
        }
        if(playerclass.charAt(0) == 'r'){
            System.out.println("ranger");
            player = new LifeForm(playername, 10, 0, 10, "ranger");
        }
        if(playerclass.charAt(0) == 'm'){
            System.out.println("mage");
            player = new LifeForm(playername, 10, 10, 10, "mage");
        }
        System.out.println("Your adventure begins!");
        GamePlay.gameloop(player);
    }
}