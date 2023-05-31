import java.util.*;
public class GamePlay{
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    public static void showstats(LifeForm creature){
        System.out.println("Name: " + creature.name + ", Health: " + creature.hp + "/" + creature.maxhp + ", Attack power: " + creature.attack + ", Mana: " + creature.mana + "/" + creature.maxmana + ", Class: " + creature.fightclass);
    }
    public static void gameloop(Player player) {
        String rest;
        boolean fightdemonlord = false;
        while (true){
            if (player.level >= 5){
                System.out.println("Would you like to fight the Demon Lord? y/n?");
                rest = scan.nextLine();
                if(rest.charAt(0) == 'y'){
                    fightdemonlord = true;
                }
            }
            System.out.println("You move forward");
            Encounter.encounter(player, fightdemonlord);
            showstats(player);
            System.out.println("Would you like to rest? y/n?");
            rest = scan.nextLine();
            if(rest.charAt(0) == 'y'){
                player.rest(player);
                showstats(player);
            }
        }
}
}

