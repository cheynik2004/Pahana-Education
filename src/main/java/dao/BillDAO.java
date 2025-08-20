package dao;

import model.Bill;
import util.DBConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    public boolean saveBill(Bill bill) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bills (bill_no, account_no, customer_name, item_id, item_name, quantity, price_per_unit, total_amount, generated_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, bill.getBillNo());
            ps.setInt(2, bill.getAccountNo());
            ps.setString(3, bill.getCustomerName());
            ps.setInt(4, bill.getItemId());
            ps.setString(5, bill.getItemName());
            ps.setInt(6, bill.getQuantity());
            ps.setDouble(7, bill.getPricePerUnit());
            ps.setDouble(8, bill.getTotalAmount());
            ps.setTimestamp(9, Timestamp.valueOf(bill.getGeneratedDate()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM bills ORDER BY generated_date DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setBillNo(rs.getString("bill_no"));
                bill.setAccountNo(rs.getInt("account_no"));
                bill.setCustomerName(rs.getString("customer_name"));
                bill.setItemId(rs.getInt("item_id"));
                bill.setItemName(rs.getString("item_name"));
                bill.setQuantity(rs.getInt("quantity"));
                bill.setPricePerUnit(rs.getDouble("price_per_unit"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setGeneratedDate(rs.getTimestamp("generated_date").toLocalDateTime());
                bills.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }

    public Bill getBillByBillNo(String billNo) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM bills WHERE bill_no = ?");
            ps.setString(1, billNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Bill bill = new Bill();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setBillNo(rs.getString("bill_no"));
                bill.setAccountNo(rs.getInt("account_no"));
                bill.setCustomerName(rs.getString("customer_name"));
                bill.setItemId(rs.getInt("item_id"));
                bill.setItemName(rs.getString("item_name"));
                bill.setQuantity(rs.getInt("quantity"));
                bill.setPricePerUnit(rs.getDouble("price_per_unit"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setGeneratedDate(rs.getTimestamp("generated_date").toLocalDateTime());
                return bill;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
