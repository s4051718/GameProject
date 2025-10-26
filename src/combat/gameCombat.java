package combat;

import java.util.Scanner;
import java.util.Random;

import main.game;
import characters.gameCharacters;

public class gameCombat {
    private static Scanner scanner = new Scanner(System.in);
    public static Random diceRoll = new Random();
    public static boolean fightWon;

    public static void combatMethod(gameCharacters player, gameCharacters enemy) {
        
        int tempPlayerHealth, tempEnemyHealth;
        int playerAttackRoll = 0;
        int enemyAttackRoll = 0;
        boolean flee = false;
        boolean fightOn = true;

        while (fightOn) {
            System.out.println("\nWhat would you like to do?: ");
            System.out.println("1. Fight\n2. Run ");
            if (player.getHealthPotions() > 0) {
                System.out.println("3. Use Potion");
            }
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("\nYou attempt to hit %s\n", enemy.getName());
                    if (player.getLevel() == 0) {
                        playerAttackRoll = diceRoll.nextInt(2) + player.getWeaponDamage();
                    } else if (player.getLevel() == 1) {
                        playerAttackRoll = diceRoll.nextInt(3) + player.getWeaponDamage();
                    } else if (player.getLevel() == 2) {
                        playerAttackRoll = diceRoll.nextInt(4) + player.getWeaponDamage();
                    } else if (player.getLevel() == 3) {
                        playerAttackRoll = diceRoll.nextInt(5) + player.getWeaponDamage();
                    } else if (player.getLevel() == 4) {
                        playerAttackRoll = diceRoll.nextInt(6) + player.getWeaponDamage();
                    } else if (player.getLevel() == 5) {
                        playerAttackRoll = diceRoll.nextInt(7) + player.getWeaponDamage();
                    }
                    if (playerAttackRoll <= 0) {
                        System.out.printf("\nYou failed to hit %s\n", enemy.getName());
                    } else {
                        System.out.printf("\nYou hit %s for %d\n", enemy.getName(), playerAttackRoll);
                        tempEnemyHealth = enemy.getCurrentHealth() - playerAttackRoll;
                        enemy.setCurrentHealth(tempEnemyHealth);
                    }
                    if (enemy.getCurrentHealth() > 0) {
                        System.out.printf("\nThe %s attempts to hit you\n", enemy.getName());
                        if (enemy.getLevel() == 1) {
                            enemyAttackRoll = diceRoll.nextInt(2);
                        } else if (enemy.getLevel() == 2) {
                            enemyAttackRoll = diceRoll.nextInt(3);
                        } else if (enemy.getLevel() == 3) {
                            enemyAttackRoll = diceRoll.nextInt(4);
                        } else if (enemy.getLevel() == 4) {
                            enemyAttackRoll = diceRoll.nextInt(5);
                        } else if (enemy.getLevel() == 5) {
                            enemyAttackRoll = diceRoll.nextInt(5);
                        }
                        if (enemyAttackRoll <= 0) {
                            System.out.printf("\nThe %s failed to hit you\n", enemy.getName());
                        } else {
                            System.out.printf("\nThe %s hit you for %d\n", enemy.getName(), enemyAttackRoll);
                            tempPlayerHealth = player.getCurrentHealth() - enemyAttackRoll;
                            player.setCurrentHealth(tempPlayerHealth);
                        }
                        System.out.printf("\nYou have %d health remaining\n", player.getCurrentHealth());
                        System.out.printf("\nThe %s has %d heatlh remaining\n", enemy.getName(), enemy.getCurrentHealth());
                    }
                    break;
                case 2:
                    flee = diceRoll.nextBoolean();
                    if (flee) {
                        System.out.println("You flee the battle");
                        fightOn = false;
                        game.gameRunning = true;
                    } else {
                        System.out.println("You failed to flee...");
                        System.out.printf("\nThe %s attempts to hit you\n", enemy.getName());
                        enemyAttackRoll = diceRoll.nextInt(6);
                        if (enemyAttackRoll <= 0) {
                            System.out.printf("\nThe %s failed to hit you\n", enemy.getName());
                        } else {
                            System.out.printf("\nYou hit %s for %d\n", enemy.getName(), enemyAttackRoll);
                            tempPlayerHealth = player.getCurrentHealth() - enemyAttackRoll;
                            player.setCurrentHealth(tempPlayerHealth);
                        }
                        System.out.printf("\nYou have %d health remaining\n", player.getCurrentHealth());
                    }
                    break;
                case 3:
                    player.setCurrentHealth((player.getCurrentHealth() + 10));
                    player.setHealthPotions(player.getHealthPotions() - 1);
                    System.out.println("You use a health potion and restore 10 health!");
                    System.out.println("Your health is now: " + player.getCurrentHealth());
                    System.out.printf("\nThe %s attempts to hit you\n", enemy.getName());
                    if (enemy.getCurrentHealth() > 0) {
                        System.out.printf("\nThe %s attempts to hit you\n", enemy.getName());
                        if (enemy.getLevel() == 1) {
                            enemyAttackRoll = diceRoll.nextInt(2);
                        } else if (enemy.getLevel() == 2) {
                            enemyAttackRoll = diceRoll.nextInt(3);
                        } else if (enemy.getLevel() == 3) {
                            enemyAttackRoll = diceRoll.nextInt(4);
                        } else if (enemy.getLevel() == 4) {
                            enemyAttackRoll = diceRoll.nextInt(5);
                        } else if (enemy.getLevel() == 5) {
                            enemyAttackRoll = diceRoll.nextInt(5);
                        }
                        if (enemyAttackRoll <= 0) {
                            System.out.printf("\nThe %s failed to hit you\n", enemy.getName());
                        } else {
                            System.out.printf("\nThe %s hit you for %d\n", enemy.getName(), enemyAttackRoll);
                            tempPlayerHealth = player.getCurrentHealth() - enemyAttackRoll;
                            player.setCurrentHealth(tempPlayerHealth);
                        }     
                    }               
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
            if (player.getCurrentHealth() <= 0) {
                fightOn = false;
                game.gameRunning = false;
                System.out.printf("\nYou died");
                break;
            }
            if (enemy.getCurrentHealth() <= 0) {
                fightOn = false;
                fightWon = true;
                System.out.printf("\nYou won! Well Done!");
                break;
            }
        }
    }

    public static void levelUp(gameCharacters player, gameCharacters enemy) {
        player.setExp(player.getExp() + enemy.getExp());
        if (player.getExp() >= 100 && player.getLevel() < 5) {
            player.setLevel(5);
            player.setBaseHealth(player.getBaseHealth() + 10);  
            System.out.println("You gained a level!");
            System.out.println("Your base health went up!");            
            if (player.getCurrentHealth() <= 10) {
                player.setCurrentHealth((player.getCurrentHealth() + 1));      
                System.out.println("Your level up heals you slightly");                                
            }                    
        } else if (player.getExp() >= 75 && player.getLevel() < 4) {
            player.setLevel(4);
            player.setBaseHealth(player.getBaseHealth() + 10);  
            System.out.println("You gained a level!");
            System.out.println("Your base health went up!");            
            if (player.getCurrentHealth() <= 10) {
                player.setCurrentHealth((player.getCurrentHealth() + 1));                    
                System.out.println("Your level up heals you slightly");                  
            }                    
        } else if (player.getExp() >= 50 && player.getLevel() < 3) {
            player.setLevel(3);
            player.setBaseHealth(player.getBaseHealth() + 10);  
            System.out.println("You gained a level!");
            System.out.println("Your base health went up!");            
            if (player.getCurrentHealth() <= 10) {
                player.setCurrentHealth((player.getCurrentHealth() + 1));   
                System.out.println("Your level up heals you slightly");                                   
            }                    
        } else if (player.getExp() >= 25 && player.getLevel() < 2) {
            player.setLevel(2);
            player.setBaseHealth(player.getBaseHealth() + 10);  
            System.out.println("You gained a level!");
            System.out.println("Your base health went up!");            
            if (player.getCurrentHealth() <= 10) {
                player.setCurrentHealth((player.getCurrentHealth() + 1));        
                System.out.println("Your level up heals you slightly");                            
            }                    
        } else if (player.getExp() >= 10 && player.getLevel() < 1) {
            player.setLevel(1);
            player.setBaseHealth(player.getBaseHealth() + 10);  
            System.out.println("You gained a level!");
            System.out.println("Your base health went up!");
            if (player.getCurrentHealth() <= 10) {
                player.setCurrentHealth((player.getCurrentHealth() + 1));
                System.out.println("Your level up heals you slightly");
            }              
        } else {
            System.out.printf("You have %.1f experience!", player.getExp());
        }
    }

    public static void lootEnemy(gameCharacters player, gameCharacters enemy) {
        player.setCoins(player.getCoins() + enemy.getCoins());
        player.setHealthPotions(player.getHealthPotions() + enemy.getHealthPotions());     
    }
}