import java.util.*;
public class Encounter {
    static Scanner scan = new Scanner(System.in);
    public static String enemyclass() {
        String enemyclass = "pheasant";
        int x = Dice.roll(3);
        if (x == 1){
            enemyclass = "warrior";
        }
        else if (x == 2){
            enemyclass = "ranger";
        }
        else if (x == 3){
            enemyclass = "mage";
        }
        return enemyclass;    
    }
    public static String enemytype() {
        String enemytype = "fetchling";
        int x = Dice.roll(3);
        if (x == 1){
            enemytype = "goblin";
        }
        else if (x == 2){
            enemytype = "hobgoblin";
        }
        else if (x == 3){
            enemytype = "demon";
        }
        return enemytype;  
    }
    public static void encounter(LifeForm player) {
        int x = Dice.roll(6);
        if (x > 1){
            fight(player);
        }
        else {
            sage(player);
        }
    }
    public static void sage(LifeForm player) {
        System.out.println("You encounter a Sage!");
        System.out.println("Greetings adverturer! Are you on a quest to slay the Demon Lord? Allow me to assist you by giving you an aptitude boost!");
        System.out.println("You have gained exprience!");
    }
    public static void fight(LifeForm player) {
        Boolean battle = true;
        String action = "";
        String yesno = "";
        enemytype();
        enemyclass();
        System.out.println("You encounter an enemy!");
        LifeForm enemy = new LifeForm(enemytype(), 50, 10, 10, enemyclass(), true);
        GamePlay.showstats(enemy);
        while (battle == true) {
            System.out.println("Do you want to attack or flee?");
            System.out.println("a/f?");
            action = scan.nextLine();
            if(action.charAt(0) == 'a'){
                enemy.takedamage(FightLogic.attack(player)); // Enemy takes damage when player attacks and vice versa. Player attacks first.
                if (enemy.alive & player.alive == true){
                    player.takedamage(FightLogic.attack(enemy));
                }
                if ((enemy.alive & player.alive) == false){
                    battle = false;
                }
            }
            else if(action.charAt(0) == 'f'){
                FightLogic.flee();
                battle = false;
            }
            else {
                System.out.println("Please input one of the requested characters.");   
            }
        }
        if (player.alive == false){
            System.out.println("Game over!");
            System.out.println("Would you like to start a new game?");
            System.out.println("y/n?");
            yesno = scan.nextLine();
            if(yesno.charAt(0) == 'y'){
                GameStart.start();
            }
            else if(yesno.charAt(0) == 'n'){
                System.exit(0);
            }
    }
    }
}