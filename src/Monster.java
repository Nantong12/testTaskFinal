public class Monster extends Entity{

    int handsCount = 0;
    public Monster(int defence, int attack, int hp, int minDamage, int maxDamage, int handsCount) {
        super(defence, attack, hp, minDamage, maxDamage);
        if (handsCount > 0){
            this.handsCount = handsCount;
        }
    }


}
