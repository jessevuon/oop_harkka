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
        if(playerclass.charAt(0) == 'w'){
            System.out.println("Warrior");
            LifeForm player = new LifeForm(playername, 10, 0, 10, 1);
        }
        if(playerclass.charAt(0) == 'r'){
            System.out.println("ranger");
            LifeForm player = new LifeForm(playername, 10, 0, 10, 2);
        }
        if(playerclass.charAt(0) == 'm'){
            System.out.println("mage");
            LifeForm player = new LifeForm(playername, 10, 10, 10, 3);
        }
        System.out.println("Your adventure begins!");
    }
}