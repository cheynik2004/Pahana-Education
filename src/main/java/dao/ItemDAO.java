package dao;

import model.Item;
import util.DBConnection;
import java.sql.*;

public class ItemDAO {
    public boolean addItem(Item i) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO items(name, price_per_unit) VALUES (?, ?)"
            );
            ps.setString(1, i.getName());
            ps.setDouble(2, i.getPricePerUnit());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean updateItemPrice(int itemId, double newPrice) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE items SET price_per_unit=? WHERE item_id=?"
            );
            ps.setDouble(1, newPrice);
            ps.setInt(2, itemId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean deleteItem(int itemId) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM items WHERE item_id=?"
            );
            ps.setInt(1, itemId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public double getPrice(String itemName) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT price_per_unit FROM items WHERE name=?"
            );
            ps.setString(1, itemName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    public java.util.List<Item> getAllItems() {
        java.util.List<Item> items = new java.util.ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new Item(
                    rs.getInt("item_id"),
                    rs.getString("name"),
                    rs.getDouble("price_per_unit")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return items;
    }

    public Item getItem(int itemId) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items WHERE item_id=?");
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Item(
                    rs.getInt("item_id"),
                    rs.getString("name"),
                    rs.getDouble("price_per_unit")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
