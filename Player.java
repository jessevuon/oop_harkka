import java.util.*;
public class Player extends LifeForm {
    static Scanner scan = new Scanner(System.in);
    int experience;
    int level;

    public Player(String name, int maxhp, int hp, int attack, int maxmana, int mana, String fightclass, boolean alive, int experience, int level){
        super(name, maxhp, hp, attack, maxmana, mana, fightclass, alive);
        this.experience = experience;
        this.level = level;
    }
    public void gainexperience(int experiencegain, Player player){ // TODO: implement this to work with other classes
        this.experience = this.experience + experiencegain;
        if (this.experience >= 100){
            levelup(player);
            this.experience = this.experience - 100;
        }
    }
    public void rest(Player player){
        System.out.println("You rest to restore your hp and mana.");
        this.hp = this.maxhp;
        this.mana = this.maxmana;
    }
    public void levelup(Player player){
        String stat = "";

        this.level = this.level + 1;
        System.out.println("You have levelled up!");
        System.out.println("Please choose which stat you would like to upgrade: h=maxhp, a=attack, m=mana");
        stat = scan.nextLine();
        if(stat.charAt(0) == 'h'){
            this.maxhp = this.maxhp + 10;
        }
        if(stat.charAt(0) == 'a'){
            this.attack = this.attack + 5;
        }
        if(stat.charAt(0) == 'm'){
            this.mana = this.mana + 5;
        }
        System.out.println("Your stats are now: ");
    }
}
