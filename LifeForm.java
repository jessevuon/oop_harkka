public class LifeForm {
    public String name;
    public int maxhp;
    public int hp;
    public int maxmana;
    public int mana;
    public int attack;
    public String fightclass; // 1-3 w,r,m
    public boolean alive; 

    public LifeForm(String name, int maxhp, int hp, int attack, int maxmana, int mana, String fightclass, boolean alive) {
        this.name = name;
        this.maxhp = hp;
        this.hp = hp;
        this.maxmana = maxmana;
        this.mana = mana;
        this.attack = attack;
        this.fightclass = fightclass;
        this.alive = alive;
      }
    public void takedamage(int damage) {
        this.hp = this.hp - damage;
        if (this.hp <= 0) {
            System.out.println(this.name + " is dead!");
            this.alive = false;
        }
    }
}
