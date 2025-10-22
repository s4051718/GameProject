package characters;

public class gameCharacters {

    private String name;
    private String charType;
    private int health;
    private int level;
    private String weapon;
    private int weaponDamage;
    private int coins;
    private int healthPotions;

    public gameCharacters(String name, String charType, int health, int level, String weapon, int weaponDamage,
            int coins, int healthPotions) {
        this.name = name;
        this.charType = charType;
        this.health = health;
        this.level = level;
        this.weapon = weapon;
        this.weaponDamage = weaponDamage;
        this.coins = coins;
        this.healthPotions = healthPotions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage() {
        if (this.weapon.equals("Rusty Sword")) {
            this.weaponDamage = 1;
        } else if (this.weapon.equals("X Sword")) {
            this.weaponDamage = 5;
        } else if (this.weapon.equals("Short Staff")) {
            this.weaponDamage = 1;
        } else if (this.weapon.equals("X Staff")) {
            this.weaponDamage = 5;
        } else if (this.weapon.equals("Dull Dagger")) {
            this.weaponDamage = 1;
        } else if (this.weapon.equals("X Dagger")) {
            this.weaponDamage = 5;
        }
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getHealthPotions() {
        return healthPotions;
    }

    public void setHealthPotions(int healthPotions) {
        this.healthPotions = healthPotions;
    }

    public String toString() {
        return String.format(
                "--- Character Information ---\nName: %s\nType: %s\nHealth: %d\nLevel: %d\n-----------------------------",
                this.name, this.charType, this.health, this.level);
    }
}