package main;
import java.util.Scanner;

import characters.gameCharacters;
import navigation.gameNavigation;

public class game {
        private static Scanner scanner = new Scanner(System.in);       
        public static boolean gameRunning = true;

        public static gameCharacters pCharacter = new gameCharacters(null, null, 40, 1, null, 0, 0, 0);

    public static void main(String[] args) {
        System.out.println("Welcome to the World of X\n");
        charCreate();
        gameNavigation.adventureStart();
        do {
            gameNavigation.navigation();
        } while (gameRunning);
        System.out.println("--- GAME OVER ---");
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
}
