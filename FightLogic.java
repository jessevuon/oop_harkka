public class FightLogic {
    public static int attack(LifeForm creature){
        int damage = 0;
        if (creature.mageattack(creature))
        {
            System.out.println(creature.name + " attacks!");
            int damageroll = Dice.roll(4);
            if (damageroll == 1){
                damage = 0; // Equals to miss
                System.out.println("Miss!");
            }
            else if (damageroll == 4){
                damage = (creature.attack * 2);
                System.out.println("Critical hit! Dealt " + damage + " damage!");
            }
            else {
                damage = creature.attack;
                System.out.println("Hit! Dealt " + damage + " damage!");

            }
        }
        return damage;
    }
    public static void flee(){
        System.out.println("You flee from the battle.");
    }
}
