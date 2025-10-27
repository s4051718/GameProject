package main;

import java.util.ArrayList;
import java.util.Scanner;

import characters.GameCharacters;
import items.Item;
import navigation.GameNavigation;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    public static boolean gameRunning = true;

    public static GameCharacters pCharacter = new GameCharacters(null, null, 20, 20, 0, 0, null, 0, 0);
    public static ArrayList<Item> pBackpack = new ArrayList<Item>();

    public static void main(String[] args) {
        System.out.println("Welcome to the World of X\n");
        charCreate();
        adventureStart();
        do {
            menu();
        } while (gameRunning);
        System.out.println("\n--- GAME OVER ---");
    }

    public static void charCreate() {
        System.out.println("-----Player Character Creation-----");

        System.out.println("Please enter your name: ");
        pCharacter.setName(scanner.nextLine());

        boolean classChosen = false;

        do {
            System.out.println("\nPlease choose your character class: \n(W)arrior\n(M)age\n(R)ogue");
            String classEntered = scanner.nextLine().toUpperCase();

            switch (classEntered) {
                case "W":
                    pCharacter.setCharType("Warrior");
                    classChosen = true;
                    break;
                case "M":
                    pCharacter.setCharType("Mage");
                    classChosen = true;
                    break;
                case "R":
                    pCharacter.setCharType("Rogue");
                    classChosen = true;
                    break;
                default:
                    System.out.println("Please enter a valid input. Either W, M, or R");
            }
        
        } while (classChosen == false);
    }

    public static void adventureStart() {
        System.out.println("\nYou awaken in your house in The Village upon the bottom of the Misty Mountains...");
        System.out.println("\nToday is the day you leave for your quest. It's what you've been preparing your whole life for.");
        System.out.println("The evil Lich King in the Ice Castle atop the Misty Mountains has cast his evil shadow over the land for too long.");
        if (pCharacter.getCharType().equals("Warrior")) {
            System.out.println("\nBut before you begin your quest you must speak to the Blacksmith in his Forge.");
            pBackpack.add(new Item("Rusty Sword", 1, 5));
            pCharacter.setWeapon("Rusty Sword");
            System.out.println("He gives you a " + pCharacter.getWeapon());
            System.out.println("Might be wise to visit the tanner, young Warrior. Apparently he has a new backpack for you.");
        } else if (pCharacter.getCharType().equals("Mage")) {
            System.out.println("But before you begin your quest you must speak to the Sorceror in his Tower.");
            pBackpack.add(new Item("Short Staff", 1, 5));            
            pCharacter.setWeapon("Short Staff");
            System.out.println("He gives you the " + pCharacter.getWeapon());
            System.out.println("Might be prudent to visit the tanner, young Mage. Apparently he has a new backpack for you.");            
        } else if (pCharacter.getCharType().equals("Rogue")) {
            System.out.println("But before you begin your quest you must speak to the Guildmaster in the Thieves Guild.");
            pBackpack.add(new Item("Dull Dagger", 1, 5));                    
            pCharacter.setWeapon("Dull Dagger");
            System.out.println("He gives you a " + pCharacter.getWeapon());
            System.out.println("Might be wise to visit the tanner, young Theif. Apparently he has a new backpack for you.");            
        }
        System.out.println("You visit the tanner who gives you a strong leather backpack for your journeys.");
        pCharacter.setWeaponDamage();
    }

    public static void menu() {
        System.out.println("\n----------------------------------");
        System.out.println("What would you like to do: \n(1). Move throughout the world of X\n(2). Look into your backpack\n(3). Quit");

        try {
            int pChoice = scanner.nextInt();

            switch (pChoice) {
                case 1:
                    GameNavigation.navigation();
                    break;
                case 2:
                    items.Inventory.viewBackpack();
                    break;
                case 3:
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Please enter a valid input. Either 1, 2 or 3");
            }
        } catch (Exception e) { 
            System.out.println("Please enter a valid number (1, 2, or 3).");
            scanner.nextLine();
        }
    }

}