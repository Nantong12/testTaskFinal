public class Player extends Entity{

    int healthCount = 4;
    int addingHeathPoint = 0;
    public Player(int defence, int attack, int hp, int minDamage, int maxDamage) {
        super(defence, attack, hp, minDamage, maxDamage);
        this.addingHeathPoint = (int) (hp * 0.3); //Просто округляем до меньшего
    }
    public void healing(){
        hp += addingHeathPoint;
        healthCount -= 1;
    }


}
