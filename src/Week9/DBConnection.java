package Week9;
import java.sql.*;
import java.util.ArrayList;

class Sales {
    int orderNumber;
    String customerName;
    String customerCity;
    String salesmanName;
    double amount;
    double commissionAmount;

    // Constructor
    public Sales(int orderNumber, String customerName, String customerCity,
                 String salesmanName, double amount, double commissionRate) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.customerCity = customerCity;
        this.salesmanName = salesmanName;
        this.amount = amount;
        this.commissionAmount = amount * commissionRate;
    }

    @Override
    public String toString() {
        return "Order #" + orderNumber +
               " | Customer: " + customerName +
               " (" + customerCity + ")" +
               " | Salesman: " + salesmanName +
               " | Amount: $" + amount +
               " | Commission: $" + commissionAmount;
    }
}

public class DBConnection {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java DBConnection <username> <password> <database>");
            return;
        }

        String username = args[0];
        String password = args[1];
        String database = args[2];

        String url = "jdbc:mariadb://localhost:3306/" + database;

        ArrayList<Sales> salesList = new ArrayList<>();

        try {
            // Load MariaDB driver (optional for newer JDBC, but safe)
            Class.forName("org.mariadb.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);

            String query = """
                SELECT 
                    o.order_no,
                    c.customer_name,
                    c.city,
                    s.name,
                    o.purchase_amt,
                    s.commission
                FROM orders o
                JOIN customer c ON o.customer_id = c.customer_id
                JOIN salesman s ON o.salesman_id = s.salesman_id
            """;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int orderNo = rs.getInt("order_no");
                String custName = rs.getString("customer_name");
                String custCity = rs.getString("city");
                String salesmanName = rs.getString("name");
                double amount = rs.getDouble("purchase_amt");
                double commissionRate = rs.getDouble("commission");

                Sales sale = new Sales(orderNo, custName, custCity,
                                       salesmanName, amount, commissionRate);

                salesList.add(sale);
            }

            // Print results
            for (Sales s : salesList) {
                System.out.println(s);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
