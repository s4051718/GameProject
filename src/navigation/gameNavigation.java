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
        System.out.println("You are in an uncharted part of the wilderness.\n");
        if (location120EnemyDefeated == false) {
            System.out.println("You sense danger!\n");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location120EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Wolf", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location120EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
                    }
                }
            } while (location120EnemyDefeated == false && game.gameRunning == true);
            location120EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location130() {
        System.out.println("You are in the Forest. The trees loom over you ominously.");

        if (location130EnemyDefeated == false) {
            System.out.println("You sense danger!\n");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Dryad", "Monster", 10, 10, 10, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location130EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Blight", "Monster", 10, 10, 10, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location130EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
                gameCharacters enemy = new gameCharacters("Treant", "Monster", 15, 15, 15, 2, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName()); 
                System.out.println(enemy);
                gameCombat.combatMethod(game.pCharacter, enemy);
                if (enemy.getCurrentHealth() <= 0) {
                    location140EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");          
                    System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
                }
            } while (location140EnemyDefeated == false && game.gameRunning == true);
            location140EnemyDefeated = true;         
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location150() {
            System.out.println("A wide, fast-flowing river blocks your path.");
            System.out.println("Suddenly, a mysterious voice echoes from the water.");
            System.out.println("Traveler, to cross this river safely, you must prove your worth.");
            System.out.println("Guess my number between 1 and 10. Be wrong, and the river will take some of your strength.");

            int correctNumber = diceRoll.nextInt(10) + 1;
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            scanner.nextLine();

            if (guess == correctNumber) {
                System.out.println("You guessed correctly! The river parts and you cross safely.");
                currentLocation = 250; // crosses the river successfully
                goToLocation(currentLocation);
            } else {
                System.out.println("Wrong! The river surges and you take damage.");
                game.pCharacter.setHealth(game.pCharacter.getHealth() - 5);
                System.out.println("You lose 5 health. Remaining health: " + game.pCharacter.getHealth());
                System.out.println("You are swept back to the previous area.");
                currentLocation = tempLocation; // sends them back
            }



    }

    public static void location210() {
        System.out.println("You are in an uncharted part of the wilderness.");

        if (location210EnemyDefeated == false) {
            System.out.println("You sense danger!\n");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location210EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Wolf", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location210EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
            System.out.println("You sense danger!\n");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location220EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Wolf", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location220EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
            System.out.println("You sense danger!\n");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Dryad", "Monster", 10, 10, 10, 2, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location230EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Blight", "Monster", 10, 10, 10, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location230EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
        System.out.println("You made it across the river safely.");

        System.out.println("A friendly wizard appears and gives you 3 health potions.");
        game.pCharacter.setHealthPotions(game.pCharacter.getHealthPotions() + 3);

        System.out.println("You now have " + game.pCharacter.getHealthPotions() + " potion(s).");
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
            System.out.println(
                    "You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else {
            System.out.println("A old hut barely stands amid the smoky marsh fumes. A cackle can be heard inside.");
        }
        // "Witches of the Swamp" shop, potions and the upgraded weapon related to the
        // players class.
    }

    public static void location350() {
        System.out.println("You have entered a murky Swamp. The air is thick and humid.");

        if (location350EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                gameCharacters ogre = new gameCharacters("Shreik", "Monster", 25, 25, 5, 3, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", ogre.getName());
                System.out.println(ogre);
                gameCombat.combatMethod(game.pCharacter, ogre);
                System.out.println("Oh my god you killed my ogre! Now face the wrath of the donkey!");
                gameCharacters donkey = new gameCharacters("Eddie", "Monster", 20, 20, 5, 2, null, 0, 0, 0);
                System.out.println("An angry donkey appears! \n");
                System.out.println(donkey);
                gameCombat.combatMethod(game.pCharacter, donkey);
                if (ogre.getCurrentHealth() <= 0 && donkey.getCurrentHealth() <= 0) {
                    location350EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");     
                    gameCombat.levelUp(game.pCharacter, ogre);                             
                    System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
        if (tempLocation == 410) {
            System.out.println("This the beginning of the end you must push (N)orth into the Lich Kings Ice Castle");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (location420EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                gameCharacters enemy = new gameCharacters("Balrog", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                gameCombat.combatMethod(game.pCharacter, enemy);
                if (enemy.getCurrentHealth() <= 0) {
                    location420EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated"); 
                    gameCombat.levelUp(game.pCharacter, enemy);                                 
                    System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
                    currentLocation = 410;
                    goToLocation(currentLocation);
                }
            } while (location420EnemyDefeated == false && game.gameRunning == true);
            location420EnemyDefeated = true;         
        }
    }

    public static void location430() {

        if (tempLocation == 530) {
            System.out.println(
                    "You cannot enter the mines from the overpass, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (location430EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Orc", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location430EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Goblin", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location430EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
            System.out.println(
                    "You cannot enter the mines from the overpass, you have made your choice, you must push forward!");
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
                gameCharacters enemy = new gameCharacters("Orc", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location440EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Goblin", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location440EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
            System.out.println(
                    "You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else {
            System.out.println(
                    "A single lantern cuts through the mist at a weathered outpost, the last stop before the mountain.");
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
                gameCharacters enemy = new gameCharacters("Frost Dragon", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                gameCombat.combatMethod(game.pCharacter, enemy);
                if (enemy.getCurrentHealth() <= 0) {
                    location520EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated"); 
                    gameCombat.levelUp(game.pCharacter, enemy);                                 
                    System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
                    currentLocation = 410;
                    goToLocation(currentLocation);
                }
            } while (location520EnemyDefeated == false && game.gameRunning == true);
            location520EnemyDefeated = true;
            currentLocation = 410;
            goToLocation(currentLocation);
        }
    }

    public static void location530() {

        if (tempLocation == 430) {
            System.out.println(
                    "You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (currentLocation == 530 && location530EnemyDefeated == false) {
            System.out.println("You are navigating a treacherous, windy Mountain Pass.");
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Wight", "Human", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location530EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Wraith", "Human", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location530EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
            System.out.println(
                    "You cannot climb to the overpass from the mines, you have made your choice, you must push forward!");
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;
        } else if (currentLocation == 540 && location540EnemyDefeated == false) {
            System.out.println("You enter the treacherous, windy Mountain Pass.");
            System.out.println("You sense danger!");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                gameCharacters enemy = new gameCharacters("Wight", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location540EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");
                        gameCombat.levelUp(game.pCharacter, enemy);                           
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());

                    }
                } else {
                gameCharacters enemy = new gameCharacters("Wraith", "Monster", 10, 10, 5, 1, null, 0, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    gameCombat.combatMethod(game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location540EnemyDefeated = true;
                        System.out.println("\nThe enemy has been defeated");   
                        gameCombat.levelUp(game.pCharacter, enemy);                                              
                        System.out.printf("\nYou have %d\\%d health remaining\n",  game.pCharacter.getCurrentHealth(),game.pCharacter.getBaseHealth());
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
            System.out.println(
                    "You have reached the Mountain Entrance. \nThere are two ways through the mountain, do you \n(1) go through the treacherous, windy mountain pass or \n(2) go through the dark and echoeing mines of the mountain.");
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
