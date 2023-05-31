public class LifeForm {
    public String name;
    public int maxhp;
    public int hp;
    public int maxmana;
    public int mana;
    public int attack;
    public String fightclass;
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
    public boolean mageattack(LifeForm creature){
        if (creature.fightclass == "mage"){
            this.mana = this.mana - 5;
        }
        else
        {
            return true;
        }
        if (this.mana <= 0)
        {
            System.out.println("You are out of mana and can not attack!");
            return false;
        }
        else{
            return true;
        }
    }
    public void takedamage(int damage) {
        this.hp = this.hp - damage;
        if (this.hp <= 0) {
            System.out.println(this.name + " is dead!");
            this.alive = false;
        }
    }
}
