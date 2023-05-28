import java.util.*;
public class GamePlay{
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    private static void createcharacter(){
        
    }
    public static void showstats(LifeForm creature){
        System.out.println("Name: " + creature.name + ", Health: " + creature.hp + ", Attack power: " + creature.attack + ", Mana: " + creature.mana + ", Class: " + creature.fightclass);
    }
    public static void gameloop(LifeForm player) {
        showstats(player);
        System.out.println("You move forward");
        Encounter.encounter(player);
        
}
}

