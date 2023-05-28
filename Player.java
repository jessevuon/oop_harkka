import java.util.*;
public class Player extends LifeForm {
    static Scanner scan = new Scanner(System.in);
    int experience;
    int level;
    public Player(String name, int hp, int attack, int mana, String fightclass, boolean alive, int experience, int level){
        super(name, hp, attack, mana, fightclass, alive);
        this.experience = experience;
        this.level = level;
    }
    public void gainexperience(int experiencegain){ // TODO: implement this to work with other classes
        this.experience = this.experience + experiencegain;
        if (this.experience >= 100){
            levelup();
            this.experience = this.experience - 100;
        }
    }
    public void levelup(){
        String stat = "";
        this.level = this.level + 1;
        System.out.println("You have levelled up!");
        System.out.println("Please choose which stat you would like to upgrade: h=hp, a=attack, m=mana");
        stat = scan.nextLine();
        if(stat.charAt(0) == 'h'){
            this.hp = this.hp + 10;
        }
        if(stat.charAt(0) == 'a'){
            this.attack = this.attack + 5;
        }
        if(stat.charAt(0) == 'm'){
            this.mana = this.mana + 5;
        }
    }
}
