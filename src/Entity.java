public class Entity {
    int attack = 0;
    int defence = 0;
    int hp = 0;
    int minDamage = 0;
    int maxDamage = 0;

    public Entity(int defence, int attack, int hp, int minDamage, int maxDamage) {
        if (defence >= 1 && defence <= 30){
            this.defence = defence;
        } else{
            System.out.println("Защита должна находиться в интервале от 1 до 30.");
        }
        if (attack >= 1 && attack <= 30){
            this.attack = attack;
        }else{
            System.out.println("Атака должна находиться в интервале от 1 до 30.");
        }
        if (hp > 0){
            this.hp = hp;
        }else{
            System.out.println("Здоровье должно быть больше 0.");
        }

        if (minDamage <= maxDamage){
            this.maxDamage = maxDamage;
            this.minDamage = minDamage;
        }else{
            System.out.println("Минимальный урон должен быть меньше максимального.");
        }
    }

}
