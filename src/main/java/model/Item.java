package model;

public class Item {
    private int itemId;
    private String name;
    private double pricePerUnit;

    public Item() {}

    public Item(int itemId, String name, double pricePerUnit) {
        this.itemId = itemId;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }
}
