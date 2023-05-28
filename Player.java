public class Player extends LifeForm {
    int experience;
    int level;
    public Player(String name, int hp, int attack, int mana, String fightclass, boolean alive, int experience, int level){
        super(name, hp, attack, mana, fightclass, alive);
        this.experience = experience;
        this.level = level;
    }
}
