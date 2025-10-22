package navigation;

import java.util.Scanner;
import java.util.Random;

import characters.gameCharacters;
import combat.gameCombat;
import main.game;

public class gameNavigation {
    public static Scanner scanner = new Scanner(System.in);
    public static Random diceRoll = new Random();
    private static int currentLocation = 110;
    private static int tempLocation;

    // Enemy Defeated Flags
    private static boolean location120EnemyDefeated = false;
    private static boolean location130EnemyDefeated = false;
    private static boolean location140EnemyDefeated = false;
    private static boolean location150EGameCompleted = false;
    private static boolean location210EnemyDefeated = false;
    private static boolean location220EnemyDefeated = false;
    private static boolean location230EnemyDefeated = false;
    private static boolean location350EnemyDefeated = false;
    private static boolean location410EnemyDefeated = false;
    private static boolean location420EnemyDefeated = false;
    private static boolean location430EnemyDefeated = false;
    private static boolean location440EnemyDefeated = false;
    private static boolean location510EnemyDefeated = false;
    private static boolean location520EnemyDefeated = false;
    private static boolean location530EnemyDefeated = false;
    private static boolean location540EnemyDefeated = false;

    public static void navigation() {
        tempLocation = currentLocation;

        System.out.println("\nWhich direction would you like to go?");
        System.out.println("(N)orth, (S)outh, (E)ast, or (W)est. Type '(Q)uit' to exit.");
        String directionEntered = scanner.nextLine().toUpperCase();

        switch (directionEntered) {
            case "N":
                currentLocation = currentLocation + 100;
                goToLocation(currentLocation);
                break;
            case "S":
                currentLocation = currentLocation - 100;
                goToLocation(currentLocation);
                break;
            case "E":
                currentLocation = currentLocation + 10;
                goToLocation(currentLocation);
                break;
            case "W":
                currentLocation = currentLocation - 10;
                goToLocation(currentLocation);
                break;
            case "Q":
                System.out.println("You have chosen to quit the game, goodbye!");
                game.gameRunning = false;
            default:
                System.out.println("Invalid direction! Please enter N/n, S/s, E/e or W/w");
                return;
        }
    }

    public static void goToLocation(int locationEntered) {
        System.out.println("\n--- You are at location " + currentLocation + " ---");

        switch (locationEntered) {
            case 110:
                location110();
                break;
            case 120:
                location120();
                break;
            case 130:
                location130();
                break;
            case 140:
                location140();
                break;
            case 150:
                location150();
                break;
            case 210:
                location210();
                break;
            case 220:
                location220();
                break;
            case 230:
                location230();
                break;
            case 240:
                location240();
                break;
            case 250:
                location250();
                break;
            case 310:
                location310();
                break;
            case 320:
                location320();
                break;
            case 330:
                location330();
                break;
            case 340:
                location340();
                break;
            case 350:
                location350();
                break;
            case 410:
                location410();
                break;
            case 420:
                location420();
                break;
            case 430:
                location430();
                break;
            case 440:
                location440();
                break;
            case 450:
                location450();
                break;
            case 510:
                location510();
                break;
            case 520:
                location520();
                break;
            case 530:
                location530();
                break;
            case 540:
                location540();
                break;
            case 550:
                location550();
                break;
            default:
                System.out.println("There is no path forward this way!");
                currentLocation = tempLocation;
                break;
        }
    }

    public static void location110() {
        System.out.println("You are back home, safe in the village");
    }

    public static void location120() {
        System.out.println("You are in an uncharted part of the wilderness.");
        if (location120EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location120EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");  
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth());  
                        // You gained X XP if level == 1 && xp == 10 level up!                                                                  
                    }
                } else if (location120EnemyDefeated == false && game.gameRunning == true) {
                    gameCharacters enemy = new gameCharacters("Wolf", "Beast", 10, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location120EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");    
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                               
                    }                    
                }
            } while (location120EnemyDefeated == false && game.gameRunning == true);
            location120EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
        // Thinking of incorporating an experience counter that will gain levels when
        // experience hits certain targets
        // for example if level 1 experience = 0, when an enemy is slain if enemy level
        // 1 add X experience to counter
        // when an enemy is slain if enemy level 2 add Y experience to counter
        // when experience equals Z level up,
        // if (gameCombat.fightWon = true) {
        // game.pCharacter.setLevel(game.pCharacter.getLevel() + 1);
        // System.out.println("You gained a level!");
        // System.out.println("You are now level " + game.pCharacter.getLevel() + "!");
        // }
    }

    public static void location130() {
        System.out.println("You are in the Forest. The trees loom over you ominously.");

        if (location130EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Dryad", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location130EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");     
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                           
                    }
                } else if (location120EnemyDefeated == false && game.gameRunning == true) {
                    gameCharacters enemy = new gameCharacters("Blight", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location130EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");       
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                             
                    }                    
                }
            } while (location130EnemyDefeated == false && game.gameRunning == true);
            location130EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location140() {
        System.out.println("You are in the Forest. The trees loom over you ominously.");

        if (location140EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                gameCharacters enemy = new gameCharacters("Treant", "Monster", 20, 3, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                gameCombat.combatMethod(game.pCharacter, enemy);
                if (enemy.getHealth() <= 0) {
                    location140EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");    
                    System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                    // You gained X XP if level == 1 && xp == 10 level up!                                    
                }
            } while (location140EnemyDefeated == false && game.gameRunning == true);
            location140EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location150() {
        System.out.println("A wide, fast-flowing river blocks your path.");
        // Guessing game
    }

    public static void location210() {
        System.out.println("You are in an uncharted part of the wilderness.");

        if (location210EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location210EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");  
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                 
                    }
                } else {
                    gameCharacters enemy = new gameCharacters("Wolf", "Beast", 10, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location210EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");     
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                              
                    }
                }
            } while (location210EnemyDefeated == false && game.gameRunning == true);
            location210EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location220() {
        System.out.println("You are in an uncharted part of the wilderness.");

        if (location220EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location220EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                
                    }
                } else {
                    gameCharacters enemy = new gameCharacters("Wolf", "Beast", 10, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location220EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");  
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                 
                    }
                }
            } while (location220EnemyDefeated == false && game.gameRunning == true);
            location220EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location230() {
        System.out.println("You are in the Forest. The trees loom over you ominously.");

        if (location230EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Dryad", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location230EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");               
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                    
                    }
                } else {
                    gameCharacters enemy = new gameCharacters("Blight", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location230EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");  
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                 
                    }
                }
            } while (location230EnemyDefeated == false && game.gameRunning == true);
            location230EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location240() {
        if (tempLocation == 230 || tempLocation == 140) {
            System.out.println("The forest is too dense you must turn back!");
            System.out.println("You go back to " + tempLocation);
            currentLocation = tempLocation;
        } else if (tempLocation == 250) {
            System.out.println("Enter the dense end of the forest?! No, You must push (N)orth!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (tempLocation == 340) {
            System.out.println("Enter the dense end of the forest?! Are you crazy?!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        }
    }

    public static void location250() {
        System.out.println("You are on the far bank of the river, the path continues north.");
        // Reward for guessing game, at this stage the player is going to be very weak
        // so maybe a health potion or two
    }

    public static void location310() {
        System.out.println("A steep unscalable mountain blocks your path.");
        System.out.println("You stay at " + tempLocation);
        currentLocation = tempLocation;
    }

    public static void location320() {
        System.out.println("A steep unscalable mountain blocks your path.");
        System.out.println("You stay at " + tempLocation);
        currentLocation = tempLocation;
    }

    public static void location330() {
        System.out.println("A steep unscalable mountain blocks your path.");
        System.out.println("You stay at " + tempLocation);
        currentLocation = tempLocation;
    }

    public static void location340() {
        
        if (tempLocation == 440) {
            System.out.println("You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;       
        } else {
            System.out.println("A old hut barely stands amid the smoky marsh fumes. A cackle can be heard inside.");
        }
        // "Witches of the Swamp" shop, potions and the upgraded weapon related to the players class.
    }

    public static void location350() {
        System.out.println("You have entered a murky Swamp. The air is thick and humid.");

        if (location350EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                gameCharacters ogre = new gameCharacters("Shreik", "Ogre", 25, 4, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", ogre.getName());
                System.out.println(ogre);
                gameCombat.combatMethod(game.pCharacter, ogre);
                System.out.println("Oh my god you killed my ogre! Now face the wrath of the donkey!");
                gameCharacters donkey = new gameCharacters("Eddie", "Donkey", 15, 2, null, 0, 0, 0);
                System.out.printf("An angry donkey appears! \n", donkey.getName());
                System.out.println(donkey);
                gameCombat.combatMethod(game.pCharacter, donkey);
                    if (ogre.getHealth() <= 0 && donkey.getHealth() <= 0) {
                        location350EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");                        
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                           
                    }
            } while (location350EnemyDefeated == false && game.gameRunning == true);

            location350EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location410() {
        System.out.println("The air grows cold as you enter the frozen Tundra.");
        // Gatekeeper fight, drops the key to the Ice Castle
    }

    public static void location420() {
        System.out.println("You are in the dark and echoing Mountain Mines.");
        // Mines mini-boss
        if (tempLocation == 410) {
            System.out.println("This the beginning of the end you must push (N)orth into the Lich Kings Ice Castle");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (location420EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                gameCharacters enemy = new gameCharacters("Balrog", "Beast", 25, 5, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                gameCombat.combatMethod(game.pCharacter, enemy);
                if (enemy.getHealth() <= 0) {
                    location420EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");   
                    System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                    // You gained X XP if level == 1 && xp == 10 level up!                                        
                    currentLocation = 410;
                    goToLocation(currentLocation);
                }
            } while (location420EnemyDefeated == false && game.gameRunning == true);
            location420EnemyDefeated = true;
        }
    }

    public static void location430() {

        if (tempLocation == 530) {
            System.out.println("You cannot enter the mines from the overpass, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (location430EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Orc", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location430EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");        
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                           
                    }
                } else {
                    gameCharacters enemy = new gameCharacters("Goblin", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location430EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                
                    }
                }
            } while (location430EnemyDefeated == false && game.gameRunning == true);
            location430EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location440() {

        if (tempLocation == 450) {
            System.out.println("A steep unscalable mountain blocks your path. Continue (N)orth up the mountain path!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation; 
        } else if (tempLocation == 540) {
            System.out.println("You cannot enter the mines from the overpass, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (tempLocation == 340) {
            System.out.println("A steep unscalable mountain blocks your path");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;                 
        } else if (currentLocation == 440 && location440EnemyDefeated == false) {
            System.out.println("You are in the dark and echoing Mountain Mines.");
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Orc", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location440EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated"); 
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                  
                    }
                } else {
                    gameCharacters enemy = new gameCharacters("Goblin", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location440EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");    
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                               
                    }
                }
            } while (location440EnemyDefeated == false && game.gameRunning == true);
            location440EnemyDefeated = true;
        } else {
            System.out.println("You are in the dark and echoing Mountain Mines.");
            System.out.println("The path is clear.");
        }
    }

    public static void location450() {

        if (tempLocation == 440) {
            System.out.println("You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;  
        } else {
            System.out.println("A single lantern cuts through the mist at a weathered outpost, the last stop before the mountain.");
        }
        // Might have the option to heal the player to full health at an Inn before the
        // final stretch because I'm thinking the Pass and Mines should have very tough
        // enemies
    }

    public static void location510() {
        System.out.println("You have reached the magnificent and deadly Ice Castle.");
        // Lich King final boss battle
    }

    public static void location520() {
        System.out.println("You are navigating a treacherous, windy Mountain Pass.");
        // Mountain Pass mini-boss
        if (location520EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                gameCharacters enemy = new gameCharacters("Frost Dragon", "Beast", 25, 5, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                gameCombat.combatMethod(game.pCharacter, enemy);
                if (enemy.getHealth() <= 0) {
                    location520EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");    
                    System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                    // You gained X XP if level == 1 && xp == 10 level up!                                       
                }
            } while (location520EnemyDefeated == false && game.gameRunning == true);
            location520EnemyDefeated = true;
            currentLocation = 410;
            goToLocation(currentLocation);
        }
    }

    public static void location530() {

        if (tempLocation == 430) {
            System.out.println("You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        }         
        else if (currentLocation == 530 && location530EnemyDefeated == false) {
            System.out.println("You are navigating a treacherous, windy Mountain Pass.");
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Soldier of Ice", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location530EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");  
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                 
                    }
                } else {
                    gameCharacters enemy = new gameCharacters("Frozen Zombie", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location530EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");    
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                               
                    }
                }
            } while (location530EnemyDefeated == false && game.gameRunning == true);
            location530EnemyDefeated = true;
        } else {
            System.out.println("You are navigating a treacherous, windy Mountain Pass.");
            System.out.println("The path is clear.");
        }
    }

    public static void location540() {

        if (tempLocation == 440) {
            System.out.println("You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (currentLocation == 540 && location540EnemyDefeated == false) {
            System.out.println("You enter the treacherous, windy Mountain Pass.");
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    gameCharacters enemy = new gameCharacters("Soldier of Ice", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location540EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");     
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                              
                    }
                } else {
                    gameCharacters enemy = new gameCharacters("Frozen Zombie", "Monster", 15, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getHealth() <= 0) {
                        location540EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        System.out.printf("\nYou have %d health remaining\n", game.pCharacter.getHealth()); 
                        // You gained X XP if level == 1 && xp == 10 level up!                                                
                    }
                }
            } while (location540EnemyDefeated == false && game.gameRunning == true);
            location540EnemyDefeated = true;
        } else {
            System.out.println("You are navigating a treacherous, windy Mountain Pass.");
            System.out.println("The path is clear.");
        }
    }

    public static void location550() {

        if (tempLocation == 540) {
            System.out.println("You cannot go back now. You have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else {
            currentLocation = 550;
            System.out.println("You have reached the Mountain Entrance. \nThere are two ways through the mountain, do you \n(1) go through the treacherous, windy mountain pass or \n(2) go through the dark and echoeing mines of the mountain.");
            int mountainChoice = scanner.nextInt();
            scanner.nextLine();
            tempLocation = currentLocation;
            if (mountainChoice == 1) {
                currentLocation = 540;
                goToLocation(currentLocation);
            } else if (mountainChoice == 2) {
                currentLocation = 440;
                goToLocation(currentLocation);
            } else {
                System.out.println("You must make a choice! There's no turning back now!");
            }
        }
    }

}