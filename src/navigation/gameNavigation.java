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

    public static void adventureStart() {
            System.out.println("\nYou are in the Starting Village. It feels safe here.");   
            System.out.println("Today is the day you leave for your quest. It's what you've been preparing your whole life for.");
            System.out.println("The evil Lich King in the Ice Castle atop the Misty Mountains has cast his evil shadow over the land for too long.");  
            if (game.pCharacter.getCharType().equals("Warrior")) {
                System.out.println("But before you begin your quest you must speak to the Blacksmith in his Forge.");
                game.pCharacter.setWeapon("Rusty Sword");
                System.out.println("He gives you a " + game.pCharacter.getWeapon());
                         
            }
            else if (game.pCharacter.getCharType().equals("Mage")) {
                System.out.println("But before you begin your quest you must speak to the Sorceror in his Tower.");            
                game.pCharacter.setWeapon("Short Staff");      
                System.out.println("He gives you the " + game.pCharacter.getWeapon());                         
            }
            else if (game.pCharacter.getCharType().equals("Rogue")) {
                System.out.println("But before you begin your quest you must speak to the Guildmaster in the Thieves Guild.");            
                game.pCharacter.setWeapon("Dull Dagger");
                System.out.println("He gives you a " + game.pCharacter.getWeapon());                                     
            } 
            game.pCharacter.setWeaponDamage();   
        }

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

        int enemyType = diceRoll.nextInt(6); 
        if (enemyType % 2 == 0) {
            gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 1, null, 0, 0, 0);  
            System.out.printf("\nA %s appears! \n", enemy.getName());
            System.out.println(enemy);
            gameCombat.combatMethod(game.pCharacter, enemy);
            // Thinking of incorporating an experience counter that will gain levels when experience hits certain targets 
            // for example if level 1 experience = 0, when an enemy is slain if enemy level 1 add X experience to counter 
            // when an enemy is slain if enemy level 2 add Y experience to counter 
            // when experience equals Z level up, 
            // if (gameCombat.fightWon = true) {
            //     game.pCharacter.setLevel(game.pCharacter.getLevel() + 1);
            //     System.out.println("You gained a level!");
            //     System.out.println("You are now level " + game.pCharacter.getLevel() + "!");  
            // }                 
        } 
        else {
            gameCharacters enemy = new gameCharacters("Wolf", "Beast", 10, 1, null, 0, 0, 0);       
            System.out.printf("\nA %s appears! \n", enemy.getName());
            System.out.println(enemy);
            gameCombat.combatMethod(game.pCharacter, enemy);   
            // Thinking of incorporating an experience counter that will gain levels when experience hits certain targets 
            // for example if level 1 experience = 0, when an enemy is slain if enemy level 1 add X experience to counter 
            // when an enemy is slain if enemy level 2 add Y experience to counter 
            // when experience equals Z level up,               
            // if (gameCombat.fightWon = true) {
            //     game.pCharacter.setLevel(game.pCharacter.getLevel() + 1);
            //     System.out.println("You gained a level!");         
            //     System.out.println("You are now level " + game.pCharacter.getLevel() + "!");                       
            // }                                       
        } 
    }

    public static void location130() {
        System.out.println("You are in the Forest. The trees loom over you ominously.");
        
        gameCharacters monster = new gameCharacters("Dryad", "Monster", 10, 1, null, 0, 0, 0);
        System.out.printf("A %s appears! \n", monster.getName());
        System.out.println(monster);
        gameCombat.combatMethod(game.pCharacter, monster);
    }

    public static void location140() {
        System.out.println("You are in the Forest. The trees loom over you ominously.");   

        gameCharacters monster = new gameCharacters("Treant", "Monster", 15, 2, null, 0, 0, 0);
        System.out.printf("A %s appears! \n", monster.getName());
        System.out.println(monster);
        gameCombat.combatMethod(game.pCharacter, monster);            
    }

    public static void location150() {
        System.out.println("A wide, fast-flowing river blocks your path.");  
        // Guessing game                  
    }

    public static void location210() {
        System.out.println("You are in an uncharted part of the wilderness.");  

        int enemyType = diceRoll.nextInt(6); 
        if (enemyType % 2 == 0) {
            gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 1, null, 0, 0, 0);  
            System.out.printf("A %s appears! \n", enemy.getName());
            System.out.println(enemy);
            gameCombat.combatMethod(game.pCharacter, enemy);                   
        } 
        else {
            gameCharacters enemy = new gameCharacters("Wolf", "Beast", 10, 1, null, 0, 0, 0);       
            System.out.printf("A %s appears! \n", enemy.getName());
            System.out.println(enemy);
            gameCombat.combatMethod(game.pCharacter, enemy);                                
        }
    }

    public static void location220() {
        System.out.println("You are in an uncharted part of the wilderness.");

        int enemyType = diceRoll.nextInt(6); 
        if (enemyType % 2 == 0) {
            gameCharacters enemy = new gameCharacters("Bandit", "Human", 10, 1, null, 0, 0, 0);  
            System.out.printf("A %s appears! \n", enemy.getName());
            System.out.println(enemy);
            gameCombat.combatMethod(game.pCharacter, enemy);                   
        } 
        else {
            gameCharacters enemy = new gameCharacters("Wolf", "Beast", 10, 1, null, 0, 0, 0);       
            System.out.printf("A %s appears! \n", enemy.getName());
            System.out.println(enemy);
            gameCombat.combatMethod(game.pCharacter, enemy);                                
        }                    
    }

    public static void location230() {
        System.out.println("You are in the Forest. The trees loom over you ominously.");  

        gameCharacters monster = new gameCharacters("Dryad", "Monster", 10, 1, null, 0, 0, 0);
        System.out.printf("A %s appears! \n", monster.getName());
        System.out.println(monster);
        gameCombat.combatMethod(game.pCharacter, monster);              
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
        // Reward for guessing game, at this stage the player is going to be very weak so maybe a health potion or two      
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
        System.out.println("A old hut barely stands amid the smoky marsh fumes. A cackle can be heard inside.");  
        // "Witches of the Swamp" shop, potions and the upgraded weapon related to the players class.      
    }

    public static void location350() {
        System.out.println("You have entered a murky Swamp. The air is thick and humid.");     

        gameCharacters ogre = new gameCharacters("Shreik", "Ogre", 25, 3, null, 0, 0, 0);
        System.out.printf("A %s appears! \n", ogre.getName());
        System.out.println(ogre);
        gameCombat.combatMethod(game.pCharacter, ogre);     
        
        // When the Ogre is beaten some text like you slain the Ogre but his annoying sidekick Donkey exits the Ogre's hut, seeking revenge!
        gameCharacters donkey = new gameCharacters("Eddie", "Donkey", 15, 2, null, 0, 0, 0);
        System.out.println("Oh my god you killed my ogre! Now face the wrath of the donkey!");
        System.out.printf("A %s appears! \n", donkey.getName());
        System.out.println(donkey);
        gameCombat.combatMethod(game.pCharacter, donkey);         
    }         

    public static void location410() {
        System.out.println("The air grows cold as you enter the frozen Tundra.");      
        // Gatekeeper fight, drops the key to the Ice Castle           
    }

    public static void location420() {
        System.out.println("You are in the dark and echoing Mountain Mines.");             
    }

    public static void location430() {
        System.out.println("You are in the dark and echoing Mountain Mines.");     
    }

    public static void location440() {
        if (currentLocation == 440) {
            System.out.println("You are in the dark and echoing Mountain Mines.");               
        }
        else if (tempLocation == 340) {
            System.out.println("A steep unscalable mountain blocks your path"); 
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;                              
        } else if (tempLocation == 450) {
            System.out.println("A steep unscalable mountain blocks your path. Continue (N)orth up the mountain path!"); 
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;                  
        } else if (tempLocation == 540) {
            System.out.println("You cannot enter the mines from the overpass, you have made your choice, you must push forward!"); 
            System.out.println("You stay at " + tempLocation);
            currentLocation = tempLocation;              
        }
    }

    public static void location450() {
        System.out.println("A single lantern cuts through the mist at a weathered outpost, the last stop before the mountain.");
        // Might have the option to heal the player to full health at an Inn before the final stretch because I'm thinking the Pass and Mines should have very tough enemies
    }         

    public static void location510() {
        System.out.println("You have reached the magnificent and deadly Ice Castle.");        
        // Lich King final boss battle 
    }

    public static void location520() {
        System.out.println("You are navigating a treacherous, windy Mountain Pass.");   
    }

    public static void location530() {
        System.out.println("You are navigating a treacherous, windy Mountain Pass.");         
    }

    public static void location540() {
        System.out.println("You are navigating a treacherous, windy Mountain Pass."); 
    }

    public static void location550() {
        System.out.println("You have reached the Mountain Entrance. \nThere are two ways through the mountain, do you \n(1) go through the dark and echoeing mines of the mountain or \n(2) go through the treacherous, windy mountain pass. ");
        int mountainChoice = scanner.nextInt();
        scanner.nextLine();
        if (mountainChoice == 1) {
            currentLocation = 440;
            goToLocation(currentLocation);
        } else if (mountainChoice == 2) {
            currentLocation = 540;
            goToLocation(currentLocation);
        } else {
            System.out.println("You must make a choice! There's no turning back now!");
        }
        
    }           

}