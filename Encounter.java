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
    public static String enemytype(Player player) {
        String enemytype = "fetchling";
        int x = 0;
        int playerlevel = player.level;
        x = Dice.roll(3);
        if (x == 1){
            enemytype = "goblin";
            if (playerlevel < 3){
                enemytype = "goblin";
            }
            else {
                enemytype = "hobgoblin";
            }
        }
        else if (x == 2){
            if (playerlevel < 4){
                enemytype = "imp";
            }
            else {
                enemytype = "demon";
            }
        }
        else if (x == 3){
            if (playerlevel < 4){
                enemytype = "orc";
            }
            else {
                enemytype = "Uruk-hai"; // :)
            }
        }

        return enemytype;  
    }
    public static void encounter(Player player, Boolean fightdemonlord) {
        int experiencegain = 0;
        int x = Dice.roll(6);
        if (x > 1){
            experiencegain = fight(player, fightdemonlord);
        }
        else {
            experiencegain = sage(player);
        }
        player.gainexperience(experiencegain, player);
    }
    public static int sage(Player player) {
        int experiencegain = 0;
        System.out.println("You encounter a Sage!");
        System.out.println("Greetings adventurer! Are you on a quest to slay the Demon Lord? Allow me to assist you by giving you an aptitude boost!");
        experiencegain = Dice.roll(10)*5;
        System.out.println("You have gained " + experiencegain + " experience!");
        return experiencegain;
        }
    public static int fight(Player player, boolean fightdemonlord) {
        Boolean battle = true;
        int experiencegain = 0;
        String action = "";
        String yesno = "";
        enemytype(player);
        enemyclass();
        System.out.println("You encounter an enemy!");
        LifeForm enemy = new LifeForm(enemytype(player), (40+player.level*5), (40+player.level*5), 10+(player.level*5), 10+(player.level*5), 10+(player.level*5), enemyclass(), true);
        
        if (fightdemonlord == true)
        {
            enemy = new LifeForm("Demon Lord", (120+player.level*5), (120+player.level*5), 30+(player.level*5), 100+(player.level*5), 100+(player.level*5), enemyclass(), true);
        }
        experiencegain = enemy.hp * 2;
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
                experiencegain = experiencegain/40;
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
        else if (enemy.alive == false){
            if (fightdemonlord == true)
            {
                System.out.println("Congratulations! You have defeated the Demon Lord!");
                System.out.println("You are the hero of mankind!");
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
            else
            {
            System.out.println("You defeated the enemy!");
            System.out.println("You have gained " + experiencegain + " experience!");
            }
        }
    return experiencegain;
    }
}