package items;

public class Item {
    private String itemName;
    private int qty;
    private double cost;

    public Item(String itemName, int qty, double cost) {
        this.itemName = itemName;
        this.qty = qty;
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%dx\t%s\t$%.2f", this.qty, this.itemName, this.cost);
    }
}    