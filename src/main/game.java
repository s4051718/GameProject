package main;
import java.util.Scanner;

import characters.gameCharacters;
import navigation.gameNavigation;

public class game {
        private static Scanner scanner = new Scanner(System.in);       
        public static boolean gameRunning = true;

        public static gameCharacters pCharacter = new gameCharacters(null, null, 10, 1, null, 0, 0, 0);

    public static void main(String[] args) {
        System.out.println("Welcome to the World of X\n");
        charCreate();
        adventureStart();
        do {
            gameNavigation.navigation();
        } while (gameRunning);
        System.out.println("\n--- GAME OVER ---");
    }

    public static void charCreate() {
        System.out.println("--Player Character Creation--");
        System.out.println("Please enter your name: ");
        pCharacter.setName(scanner.nextLine());
        System.out.println("Please choose your character class: \n (W)arrior\n (M)age \n (R)ogue");
        String classEntered = "F";
        
        while (!classEntered.equals("W") && !classEntered.equals("M") && !classEntered.equals("R")) {
                classEntered = scanner.nextLine().toUpperCase();
            switch (classEntered) {
                case "W":
                    pCharacter.setCharType("Warrior");
                    break;
                case "M":
                    pCharacter.setCharType("Mage");            
                    break;
                case "R":
                    pCharacter.setCharType("Rogue");            
                    break;
                default:
                    System.out.println("That is not a valid Character Class. Please enter W/w, M/m, or R/r");
                    break;
            }
        }
        System.out.println(pCharacter);        
    }

    public static void adventureStart() {
            System.out.println("\nYou awaken in your house in The Village upon the bottom of the Misty Mountains");   
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
    
}