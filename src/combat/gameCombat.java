package combat;

import java.util.Scanner;
import java.util.Random;

import main.game;
import characters.gameCharacters;

public class gameCombat {
    private static Scanner scanner = new Scanner(System.in); 
    public static Random diceRoll = new Random();
    public static boolean fightWon;    

    public static void combatMethod (gameCharacters player, gameCharacters enemy) {

        int tempPlayerHealth, tempEnemyHealth;
        int playerAttackRoll = 0;
        int enemyAttackRoll = 0;
        boolean flee = false;
        boolean fightOn = true;   

        while (fightOn) {
            System.out.println("\nWhat would you like to do?: ");
            System.out.println("1. Fight\n2. Run ");
            if (player.getHealthPotions() > 0) {
                System.out.println("3. Use Potions");
            }
            int choice = scanner.nextInt(); 
            switch (choice) {
                case 1:
                    System.out.printf("\nYou attempt to hit %s\n", enemy.getName());
                    if (player.getLevel() == 1) {
                        playerAttackRoll = diceRoll.nextInt(3) + player.getWeaponDamage();                        
                    }
                    else if (player.getLevel() == 2) {
                        playerAttackRoll = diceRoll.nextInt(4) + player.getWeaponDamage();                        
                    }        
                    else if (player.getLevel() == 3) {
                        playerAttackRoll = diceRoll.nextInt(5) + player.getWeaponDamage();                        
                    }                                     
                    else if (player.getLevel() == 4) {
                        playerAttackRoll = diceRoll.nextInt(6) + player.getWeaponDamage(); 
                    }                      
                    else if (player.getLevel() == 5) {
                        playerAttackRoll = diceRoll.nextInt(7) + player.getWeaponDamage();      
                    }                                   
                    if (playerAttackRoll <= 0) {
                        System.out.printf("\nYou failed to hit %s\n", enemy.getName());
                    } 
                    else {
                        System.out.printf("\nYou hit %s for %d\n", enemy.getName(), playerAttackRoll);
                        tempEnemyHealth = enemy.getHealth() - playerAttackRoll;
                        enemy.setHealth(tempEnemyHealth);
                    }
                    if (enemy.getHealth() > 0) {
                        System.out.printf("\nThe %s attempts to hit you\n", enemy.getName());
                        if (enemy.getLevel() == 1) {
                            enemyAttackRoll = diceRoll.nextInt(2);
                        } 
                        else if (enemy.getLevel() == 2) {
                            enemyAttackRoll = diceRoll.nextInt(3);
                        }                        
                        else if (enemy.getLevel() == 3) {
                            enemyAttackRoll = diceRoll.nextInt(4);
                        }     
                        else if (enemy.getLevel() == 4) {
                            enemyAttackRoll = diceRoll.nextInt(5);
                        }                            
                        else if (enemy.getLevel() == 5) {
                            enemyAttackRoll = diceRoll.nextInt(5);
                        } 
                        if (enemyAttackRoll <= 0) {
                            System.out.printf("\nThe %s failed to hit you\n", enemy.getName());
                        } 
                        else {
                            System.out.printf("\nThe %s hit you for %d\n", enemy.getName(), enemyAttackRoll);
                            tempPlayerHealth = player.getHealth() - enemyAttackRoll;
                            player.setHealth(tempPlayerHealth);
                        }
                        System.out.printf("\nYou have %d health remaining\n", player.getHealth());
                        System.out.printf("\nThe %s has %d heatlh remaining\n", enemy.getName(), enemy.getHealth());
                    }
                    break;   
                case 2:
                    flee = diceRoll.nextBoolean();
                    if (flee) {
                        System.out.println("You flee the battle");
                        fightOn = false;
                        game.gameRunning = true;
                    } 
                    else {
                        System.out.println("You failed to flee...");
                        System.out.printf("\nThe %s attempts to hit you\n", enemy.getName());
                        enemyAttackRoll = diceRoll.nextInt(6);
                        if (enemyAttackRoll <= 0) {
                            System.out.printf("\nThe %s failed to hit you\n", enemy.getName());
                        } else {
                            System.out.printf("\nYou hit %s for %d\n", enemy.getName(), enemyAttackRoll);
                            tempPlayerHealth = player.getHealth() - enemyAttackRoll;
                            player.setHealth(tempPlayerHealth);
                        }
                        System.out.printf("\nYou have %d health remaining\n", player.getHealth());
                    }
                    break;
                case 3:
                    player.setHealth(player.getHealth() + 10);
                    player.setHealthPotions(player.getHealthPotions() - 1);
                    System.out.println("You use a health potion and restore 10 health!");
                    System.out.println("Your health is now: " + player.getHealth());
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;     
                }        
            if (player.getHealth() <= 0){
                fightOn = false;
                game.gameRunning = false;
                System.out.printf("\nYou died");
                break;
            }
            if (enemy.getHealth() <= 0){
                fightOn = false;
                fightWon = true;
                System.out.printf("\nYou won! Well Done!");              
                break;
            }
        }
    }                 
}