package characters;

public class GameCharacters {

    private String name;
    private String charType;
    private int baseHealth;
    private int currentHealth;
    private double exp;
    private int level;
    private String weapon;
    private int weaponDamage;
    private double coins;

    public GameCharacters(String name, String charType, int baseHealth, int currentHealth, double exp, int level, String weapon, int weaponDamage,
            double coins) {
        this.name = name;
        this.charType = charType;
        this.baseHealth = baseHealth;
        this.currentHealth = currentHealth;
        this.exp = exp;
        this.level = level;
        this.weapon = weapon;
        this.weaponDamage = weaponDamage;
        this.coins = coins;
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

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
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
        } else if (this.weapon.equals("Chaos Blade")) {
            this.weaponDamage = 5;
        } else if (this.weapon.equals("Short Staff")) {
            this.weaponDamage = 1;
        } else if (this.weapon.equals("Great White Staff")) {
            this.weaponDamage = 5;
        } else if (this.weapon.equals("Dull Dagger")) {
            this.weaponDamage = 1;
        } else if (this.weapon.equals("Diamond Dagger")) {
            this.weaponDamage = 5;
        }
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public String toString() {
        return String.format(
                "\n--- Character Information ---\nName: %s\nType: %s\nHealth: %d\\%d\nLevel: %d\n-----------------------------",
                this.name, this.charType, this.currentHealth, this.baseHealth, this.level);
    }
}