import java.util.Random;
import java.util.Scanner;

public class Game {


    public static void play(){
        boolean monstersAlive = true;
        int hpAdding = 0;
        int value = 0;
        int action = 0;
        int modifier = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Напишите числовое значение защиты, затем атаки, затем количество здоровья, " +
                "минимальное и маскимальное значение урона вашего герояю.");
        Player player = new Player(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Напишите, сколько врагов вам будет противостоять.");
        int monsterCount = sc.nextInt();
        System.out.println("Напишите числовое значение защиты, затем атаки, затем количество здоровья, " +
                "минимальное и маскимальное значение урона, а так же количество рук монстра.");
        Monster monster = new Monster(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        for (int i = 0; i < monsterCount; i++){
            while (monstersAlive){
                System.out.println("Введите, вы атакуете (0) или защищаетесь (1).");
                action = sc.nextInt();
                System.out.println("Вам нужно восстановить здоровье? Сделать это можно 4 раза максимум. Да (1), Нет(0).");
                hpAdding = sc.nextInt();
                if (hpAdding == 1){
                    player.healing();
                }
                switch (action){
                    case (0):
                        if (player.attack > monster.defence){
                            modifier = player.attack - monster.defence + 1;
                            System.out.println(modifier);
                        } else {
                            modifier = 1;
                        }
                        for (int j = 0; j < modifier; j++) {
                            value = random();
                            if (value >= 5){
                                monster.hp -= (int) ((Math.random() * (player.maxDamage- player.minDamage)) + player.minDamage);
                                System.out.println(monster.hp);
                                break;
                            }
                        }
                        break;
                    case (1):
                        if (monster.attack > player.defence){
                            modifier = monster.attack - player.defence + 1;
                            System.out.println(modifier);
                        } else {
                            modifier = 1;
                        }
                        for (int j = 0; j < modifier; j++) {
                            value = random();
                            if (value >= 5){
                                player.hp -= ((int) ((Math.random() * (monster.maxDamage- monster.minDamage)) + monster.minDamage) * monster.handsCount);
                                System.out.println(player.hp);
                                break;
                            }
                        }

                }
                if (monster.hp <= 0){
                    System.out.println("Монстр убит.");
                    if (i != monsterCount - 1){
                        System.out.println("Напишите числовое значение защиты, затем атаки, затем количество здоровья, " +
                                "минимальное и маскимальное значение урона, а так же количество рук монстра.");
                        monster = new Monster(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                    }
                    monstersAlive = false;

                }
                if(player.hp <= 0){
                    System.out.println("Вы проиграли.");
                    monstersAlive = false;
                }
            }

        }
    }

    public static int random(){
        return (int) (Math.random() * 5) + 1;
    }
}

//final
