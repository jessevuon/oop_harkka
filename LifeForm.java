public class LifeForm {
    public String name;
    public int hp;
    public int mana;
    public int attack;
    public int fightclass; // 1-3 w,r,m

    public LifeForm(String name, int hp, int mana, int attack, int fightclass) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.attack = attack;
        this.fightclass = fightclass;
      }
}
