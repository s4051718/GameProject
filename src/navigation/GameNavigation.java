package navigation;

import java.util.Scanner;
import java.util.Random;

import characters.GameCharacters;
import combat.GameCombat;
import items.Item;
import items.Inventory;
import main.Game;

public class GameNavigation {
    public static Scanner scanner = new Scanner(System.in);
    public static Random diceRoll = new Random();
    private static int currentLocation = 110;
    private static int tempLocation;

    // Enemy Defeated Flags
    private static boolean location120EnemyDefeated = false;
    private static boolean location130EnemyDefeated = false;
    private static boolean location140EnemyDefeated = false;
    private static boolean location150GameCompleted = false;
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

        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Which direction would you like to go?");
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
                Game.gameRunning = false;
                break;
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
                    GameCharacters enemy = new GameCharacters("Bandit", "Human", 10, 10, 5, 1, null, 0, enemyType);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location120EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Wolf", "Monster", 10, 10, 5, 1, null, 0, 5);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location120EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location120EnemyDefeated == false && Game.gameRunning == true);
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
                    GameCharacters enemy = new GameCharacters("Dryad", "Monster", 10, 10, 10, 2, null, 0, 10);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location130EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Blight", "Monster", 10, 10, 10, 2, null, 0, 10);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location130EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location130EnemyDefeated == false && Game.gameRunning == true);
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
                GameCharacters enemy = new GameCharacters("Treant", "Monster", 15, 15, 15, 2, null, 0, 15);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                GameCombat.combatMethod(Game.pCharacter, enemy);
                if (enemy.getCurrentHealth() <= 0) {
                    location140EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");
                    System.out.printf("\nYou have %d\\%d health remaining\n", Game.pCharacter.getCurrentHealth(),
                            Game.pCharacter.getBaseHealth());
                    System.out.println(
                            "Clutched in the Treants branches is a map. You climb the dead monster and retreive it!");
                    Game.pBackpack.add(new Item("Map", 1, 0));
                    System.out.println("You obtained the Map of X!");
                }
            } while (location140EnemyDefeated == false && Game.gameRunning == true);
            location140EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location150() {

        if (location150GameCompleted == false) {
            System.out.println("A wide, fast-flowing river blocks your path.\n"
                    + "As voices echo from the water a Naiad rises from the river and speaks:\n"
                    + "Traveler, to cross this river safely, you must play my Game.");
            System.out.println(
                    "Guess my number between 1 and 10. Be wrong, and you will join me in the water. Be right and you have safe passage across the river.");
            int correctNumber = diceRoll.nextInt(10) + 1;
            do {
                System.out.print("\nEnter your guess: ");
                try {
                    int guess = scanner.nextInt();
                    scanner.nextLine();
                    if (guess < correctNumber) {
                        System.out.println("Your guess is too low!");
                        Game.pCharacter.setCurrentHealth(Game.pCharacter.getCurrentHealth() - 1);
                        System.out.printf("You now have: %d/%d health", Game.pCharacter.getCurrentHealth(),
                                Game.pCharacter.getBaseHealth());
                        if (Game.pCharacter.getCurrentHealth() <= 0) {
                            Game.gameRunning = false;
                            break;
                        }
                    } else if (guess > correctNumber) {
                        System.out.println("Your guess is too high!");
                        Game.pCharacter.setCurrentHealth(Game.pCharacter.getCurrentHealth() - 1);
                        System.out.printf("You now have: %d/%d health", Game.pCharacter.getCurrentHealth(),
                                Game.pCharacter.getBaseHealth());
                        if (Game.pCharacter.getCurrentHealth() <= 0) {
                            Game.gameRunning = false;
                            break;
                        }
                    } else {
                        System.out.println("You guessed correctly! The river parts and you cross safely.");
                        location150GameCompleted = true;
                        currentLocation = 250;
                        goToLocation(currentLocation);
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid input. A number from and including 1 to 10.");
                    scanner.nextLine();
                }
            } while (location150GameCompleted == false);
            location150GameCompleted = true;
        } else {
            System.out.println("The Naiad gives you safe passage through the river.");
        }
    }

    public static void location210() {
        System.out.println("You are in an uncharted part of the wilderness.");

        if (location210EnemyDefeated == false) {
            System.out.println("You sense danger!\n");
            do {
                int enemyType = diceRoll.nextInt(6);
                if (enemyType % 2 == 0) {
                    GameCharacters enemy = new GameCharacters("Bandit", "Human", 10, 10, 5, 1, null, 0, 5);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location210EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Wolf", "Monster", 10, 10, 5, 1, null, 0, 5);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location210EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location210EnemyDefeated == false && Game.gameRunning == true);
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
                    GameCharacters enemy = new GameCharacters("Bandit", "Human", 10, 10, 5, 1, null, 0, 5);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location220EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Wolf", "Monster", 10, 10, 5, 1, null, 0, 5);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location220EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location220EnemyDefeated == false && Game.gameRunning == true);
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
                    GameCharacters enemy = new GameCharacters("Dryad", "Monster", 10, 10, 10, 2, null, 0, 10);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location230EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Blight", "Monster", 10, 10, 10, 1, null, 0, 10);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location230EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location230EnemyDefeated == false && Game.gameRunning == true);
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
        System.out
                .println("You made it across the river safely.\nYou are on the far bank and the path continues north.");

        System.out.println("\nBefore you continue north The Naiad appears, and gives you 3 health potions.");
        System.out.println("Good luck on your journey");
        items.Inventory.addHealthPotions(3);
        System.out.println("You now have " + items.Inventory.getHealthPotionCount() + " potion(s).");
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
            System.out.println(
                    "You enter the old hut and three witches take form from the seeping smoke of the cauldron.");
            System.out.println("Purchase lead up text here:");
            Inventory.populateShopInventory();
            System.out.println("Would you like to:\n 1. Shop\n 2. View Backpack\n 3. Leave");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Inventory.shop();
                    break;
                case 2:
                    Inventory.viewBackpack();
                case 3:
                    currentLocation = 350;
                    goToLocation(currentLocation);
                default:
                    System.out.println("You must select a valid option");
                    break;
            }
        }
    }

    public static void location350() {
        System.out.println("You have entered a murky Swamp. The air is thick and humid.");

        if (location350EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                GameCharacters ogre = new GameCharacters("Shreik", "Monster", 25, 25, 20, 3, null, 0, 20);
                System.out.printf("A %s appears! \n", ogre.getName());
                System.out.println(ogre);
                GameCombat.combatMethod(Game.pCharacter, ogre);
                GameCombat.levelUp(Game.pCharacter, ogre);
                GameCombat.lootEnemy(Game.pCharacter, ogre);
                System.out.println("Oh my god you killed my ogre! Now face the wrath of the donkey!");
                GameCharacters donkey = new GameCharacters("Eddie", "Monster", 20, 20, 15, 2, null, 0, 25);
                System.out.println("An angry donkey appears! \n");
                System.out.println(donkey);
                GameCombat.combatMethod(Game.pCharacter, donkey);
                if (ogre.getCurrentHealth() <= 0 && donkey.getCurrentHealth() <= 0) {
                    location350EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");
                    GameCombat.levelUp(Game.pCharacter, donkey);
                    GameCombat.lootEnemy(Game.pCharacter, donkey);
                    System.out.printf("\nYou have %d\\%d health remaining\n", Game.pCharacter.getCurrentHealth(),
                            Game.pCharacter.getBaseHealth());
                }
            } while (location350EnemyDefeated == false && Game.gameRunning == true);
            location350EnemyDefeated = true;
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
    }

    public static void location410() {
        System.out.println("The air grows cold as you enter the frozen Tundra.");

        if (location350EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                GameCharacters enemy = new GameCharacters("The GateKeeper", "???", 100, 100, 100, 5, null, 0, 50);
                System.out.printf("%s appears! \n", enemy.getName());
                System.out.println(enemy);
                GameCombat.combatMethod(Game.pCharacter, enemy);
                if (enemy.getCurrentHealth() <= 0) {
                    location410EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");
                    GameCombat.levelUp(Game.pCharacter, enemy);
                    GameCombat.lootEnemy(Game.pCharacter, enemy);
                    System.out.printf("\nYou have %d\\%d health remaining\n", Game.pCharacter.getCurrentHealth(),
                            Game.pCharacter.getBaseHealth());
                }
            } while (location410EnemyDefeated == false && Game.gameRunning == true);
            location410EnemyDefeated = true;
            Game.pBackpack.add(new Item("Ice Castle Key", 1, 0));
            System.out.println("You received the Key to The Ice Castle!!");
        } else {
            System.out.println("The area is quiet and the path is clear.");
        }
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
                GameCharacters enemy = new GameCharacters("Balrog", "Monster", 75, 75, 50, 5, null, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                GameCombat.combatMethod(Game.pCharacter, enemy);
                if (enemy.getCurrentHealth() <= 0) {
                    location420EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");
                    GameCombat.levelUp(Game.pCharacter, enemy);
                    GameCombat.lootEnemy(Game.pCharacter, enemy);
                    System.out.printf("\nYou have %d\\%d health remaining\n", Game.pCharacter.getCurrentHealth(),
                            Game.pCharacter.getBaseHealth());
                }
            } while (location420EnemyDefeated == false && Game.gameRunning == true);
            location420EnemyDefeated = true;
            currentLocation = 410;
            goToLocation(currentLocation);
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
                    GameCharacters enemy = new GameCharacters("Orc", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location430EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Goblin", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location430EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location430EnemyDefeated == false && Game.gameRunning == true);
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
                    GameCharacters enemy = new GameCharacters("Orc", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location440EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Goblin", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location440EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location440EnemyDefeated == false && Game.gameRunning == true);
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
        if (location520EnemyDefeated == false) {
            System.out.println("You sense danger!");
            do {
                GameCharacters enemy = new GameCharacters("Frost Dragon", "Monster", 75, 75, 50, 5, null, 0, 0);
                System.out.printf("A %s appears! \n", enemy.getName());
                System.out.println(enemy);
                GameCombat.combatMethod(Game.pCharacter, enemy);
                if (enemy.getCurrentHealth() <= 0) {
                    location520EnemyDefeated = true;
                    System.out.println("\nThe enemy has been defeated");
                    GameCombat.levelUp(Game.pCharacter, enemy);
                    System.out.printf("\nYou have %d\\%d health remaining\n", Game.pCharacter.getCurrentHealth(),
                            Game.pCharacter.getBaseHealth());
                }
            } while (location520EnemyDefeated == false && Game.gameRunning == true);
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
                    GameCharacters enemy = new GameCharacters("Wight", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location530EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Wraith", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location530EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location530EnemyDefeated == false && Game.gameRunning == true);
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
                    GameCharacters enemy = new GameCharacters("Wight", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears!\n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location540EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);

                    }
                } else {
                    GameCharacters enemy = new GameCharacters("Wraith", "Monster", 50, 50, 40, 4, null, 0, 0);
                    System.out.printf("A %s appears! \n", enemy.getName());
                    System.out.println(enemy);
                    GameCombat.combatMethod(Game.pCharacter, enemy);
                    if (enemy.getCurrentHealth() <= 0) {
                        location540EnemyDefeated = true;
                        GameCombat.levelUp(Game.pCharacter, enemy);
                        GameCombat.lootEnemy(Game.pCharacter, enemy);
                    }
                }
            } while (location540EnemyDefeated == false && Game.gameRunning == true);
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

    // Beginnings of map implementation
    private static final int[][] ROOM_LOCATIONS = {
            { 1, 1 }, // Room 110
            { 1, 2 }, // Room 120
            { 1, 3 }, // Room 130
            { 1, 4 }, // Room 140
            { 1, 5 }, // Room 150
            { 2, 1 }, // Room 210
            { 2, 2 }, // Room 220
            { 2, 3 }, // Room 230
            { 2, 4 }, // Room 240
            { 2, 5 }, // Room 250
            { 3, 1 }, // Room 310
            { 3, 2 }, // Room 320
            { 3, 3 }, // Room 330
            { 3, 4 }, // Room 340
            { 3, 5 }, // Room 350
            { 4, 1 }, // Room 410
            { 4, 2 }, // Room 420
            { 4, 3 }, // Room 430
            { 4, 4 }, // Room 440
            { 4, 5 }, // Room 450
            { 5, 1 }, // Room 510
            { 5, 2 }, // Room 520
            { 5, 3 }, // Room 530
            { 5, 4 }, // Room 540
            { 5, 5 }, // Room 550
    };

    public static void viewMap() {
        int[] mapLocation = new int[5];
        int index = 0;

        int num = currentLocation;

        char pLocation = 'P';
        char noRoom = '-';
        char room = 'O';

        while (num > 0) {
            int digit = num % 10; // 22/10 remainder
            mapLocation[index] = digit;
            index++;
            num = num / 10;
        }

        for (int i = 0; i < mapLocation.length; i++) {
            System.out.printf("Index %d: %d", i, mapLocation[i]);
        }

        for (int i = 5; i > 0; i--) {
            System.out.println();
            System.out.println("---------------");

            for (int j = 1; j < 4; j++) {
                System.out.print("| ");

                if (mapLocation[2] == i && mapLocation[1] == j) {
                    System.out.print(pLocation);
                } else {
                    boolean isRoom = false;
                    for (int k = 0; k < ROOM_LOCATIONS.length; k++) {
                        if (ROOM_LOCATIONS[k][0] == i && ROOM_LOCATIONS[k][1] == j) {
                            isRoom = true;
                            break;
                        }
                    }
                    if (isRoom) {
                        System.out.print(room);
                    } else {
                        System.out.print(noRoom);
                    }
                }
                System.out.print(" |");
            }
            System.out.println("\n---------------");
        }
    }
}