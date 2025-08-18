package dao;

import model.Customer;
import util.DBConnection;
import java.sql.*;

public class CustomerDAO {
    public boolean addCustomer(Customer c) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO customers VALUES (?, ?, ?, ?, ?)"
            );
            ps.setInt(1, c.getAccountNo());
            ps.setString(2, c.getName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getTelephone());
            ps.setInt(5, c.getUnitsConsumed());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean updateCustomer(Customer c) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE customers SET name=?, address=?, telephone=?, units_consumed=? WHERE account_no=?"
            );
            ps.setString(1, c.getName());
            ps.setString(2, c.getAddress());
            ps.setString(3, c.getTelephone());
            ps.setInt(4, c.getUnitsConsumed());
            ps.setInt(5, c.getAccountNo());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public int getUnitsConsumed(int accountNo) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT units_consumed FROM customers WHERE account_no=?"
            );
            ps.setInt(1, accountNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    public Customer getCustomer(int accountNo) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM customers WHERE account_no=?"
            );
            ps.setInt(1, accountNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getInt("account_no"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("telephone"),
                    rs.getInt("units_consumed")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public boolean deleteCustomer(int accountNo) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM customers WHERE account_no=?");
            ps.setInt(1, accountNo);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public java.util.List<Customer> getAllCustomers() {
        java.util.List<Customer> customers = new java.util.ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(
                    rs.getInt("account_no"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("telephone"),
                    0
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return customers;
    }
}
