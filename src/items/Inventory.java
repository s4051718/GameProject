package items;

import java.util.ArrayList;
import java.util.Scanner;

import main.Game;

public class Inventory {

    private static Scanner scanner = new Scanner(System.in);
 
    private static ArrayList<Item> shopInventory = null;

    private static boolean shopping = true;

    public static void shop() {
        populateShopInventory();
        do {
            viewShopItems();            
        } while (shopping);
        Game.menu();
    }

    public static void populateShopInventory() {
        if (shopInventory == null) {
            shopInventory = new ArrayList<Item>();
            shopInventory.add(new Item("Health Potion", 5, 10)); 
            if (Game.pCharacter.getCharType().equals("Warrior")) {
                shopInventory.add(new Item("X Sword", 1, Game.pCharacter.getCoins() / 2));
            } else if (Game.pCharacter.getCharType().equals("Mage")) {
                shopInventory.add(new Item("X Staff", 1, Game.pCharacter.getCoins() / 2));
            } else {
                shopInventory.add(new Item("X Dagger", 1, Game.pCharacter.getCoins() / 2));
            }
        }
    }

    public static void viewShopItems() { 
            populateShopInventory();
            
            for (int index = 0; index < shopInventory.size(); index++) {
                System.out.println(shopInventory.get(index).toString());
            }

            System.out.println("Would you like to purchase anything? (Y)es or (N)o");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "Y":
                    purchaseItem();
                    break;
                case "N":
                    System.out.println("You opt not to purchase aything");
                    shopping = false;
                    return;
                default:
                    System.out.println("Not sure what you typed. Best not to purchase anything");
                    break;
            }
    }

    public static void purchaseItem() {
        System.out.printf("\nYou have %.2f coins\n\n", Game.pCharacter.getCoins());
        System.out.println("Enter the name of the product you wish to purchase");
        String itemSelect = scanner.nextLine();
        boolean found = false;
        double cost = 0.00; 
        int index = 0;
        int itemQty = 0;

        for (int i = 0; i < shopInventory.size(); i++) {
            if (itemSelect.equals(shopInventory.get(i).getItemName())) {
                found = true;
                cost = shopInventory.get(i).getCost();
                index = i;
                itemQty = shopInventory.get(i).getQty();
            }
        }

        if (found && Game.pCharacter.getCoins() >= cost && itemQty > 0){
            System.out.printf("\nThe item %s costs %.2f. You have %.2f. Would you like to purchase this item? [Y] [N]\n", itemSelect, cost, Game.pCharacter.getCoins());
            String pChoice = scanner.nextLine().toUpperCase();

            switch (pChoice) {
                case "Y":
                    System.out.println("Thank you for your purchase");
                    
                    int backpackIndex = findItemIndex(itemSelect);

                    if (backpackIndex != -1) {
                        int currentQty = Game.pBackpack.get(backpackIndex).getQty();
                        Game.pBackpack.get(backpackIndex).setQty(currentQty + 1);
                        
                    } else {
                        Game.pBackpack.add(new Item(itemSelect, 1, cost));
                    }
                    
                    if (itemSelect.equals("Chaos Blade") || itemSelect.equals("Great White Staff") || itemSelect.equals("Diamond Dagger")) {
                        Game.pCharacter.setWeapon(itemSelect);
                        Game.pCharacter.setWeaponDamage();
                        System.out.println("You equip your new " + itemSelect + "!");
                    }

                    Game.pCharacter.setCoins(Game.pCharacter.getCoins() - cost);
                    shopInventory.get(index).setQty(shopInventory.get(index).getQty()-1);
                    break;
                case "N":
                    System.out.println("....ok....");
                    break;
                default:
                    System.out.println("Not a valid input");
                    break;
            }
        } else if (found && Game.pCharacter.getCoins() < cost) {
            System.out.println("You dont have enough money to buy this");
        }
        else if (found == false || itemQty == 0) {
            System.out.println("Item " + itemSelect + " is not available");
        }

    }

    public static void viewBackpack() {
            System.out.println("Here is a list of items in your backpack");
            if (Game.pBackpack.isEmpty()) {
                System.out.println("Your backpack is empty.");
                return;
            }
            for (int i = 0; i < Game.pBackpack.size(); i++) {
                System.out.println(Game.pBackpack.get(i).toString());
            }
        }

    public static int findItemIndex(String itemName) {
        for (int i = 0; i < Game.pBackpack.size(); i++) {
            if (Game.pBackpack.get(i).getItemName().equals(itemName)) {
                return i;
            }
        }
        return -1;
    }

    public static int getHealthPotionCount() {
        int index = findItemIndex("Health Potion");
        if (index != -1) {
            return Game.pBackpack.get(index).getQty();
        }
        return 0;
    }

    public static void addHealthPotions(int quantity) {
        int index = findItemIndex("Health Potion");
        if (index != -1) {
            Item potions = Game.pBackpack.get(index);
            potions.setQty(potions.getQty() + quantity);
        } else {
            Game.pBackpack.add(new Item("Health Potion", quantity, 0)); 
        }
    }

    public static void useHealthPotion() {
        int index = findItemIndex("Health Potion");
        
        if (index != -1 && Game.pBackpack.get(index).getQty() > 0) {
            Item potions = Game.pBackpack.get(index);
            potions.setQty(potions.getQty() - 1);
            
            Game.pCharacter.setCurrentHealth(Game.pCharacter.getCurrentHealth() + 10);
            System.out.println("You use a health potion and restore 10 health!");
            System.out.println("Your health is now: " + Game.pCharacter.getCurrentHealth());

            if (potions.getQty() == 0) {
                Game.pBackpack.remove(index);
            }
        } else {
            System.out.println("You have no health potions to use!");
        }
    }
}