import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesPersonStreamApp {

    public static void main(String[] args) {

        List<SalesPerson> salesPersonList = new ArrayList<>();

        String url = "jdbc:mariadb://localhost:3306/labwork12";
        String user = "root";
        String password = "Harr8009";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                "SELECT s.name, s.city, s.commission, " +
                "IFNULL(SUM(o.purchase_amt), 0) AS totalSales " +
                "FROM salesman s " +
                "LEFT JOIN orders o ON s.salesman_id = o.salesman_id " +
                "GROUP BY s.salesman_id, s.name, s.city, s.commission")) {

            while (rs.next()) {
                salesPersonList.add(
                        new SalesPerson(
                                rs.getString("name"),
                                rs.getString("city"),
                                rs.getDouble("commission"),
                                rs.getDouble("totalSales")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 1. Print names + total earnings

        System.out.println("\n=== Total Earnings ===");
        System.out.printf("%-15s %-15s%n", "Name", "Total Earnings");
        System.out.println("--------------------------------");

        salesPersonList.stream()
                .forEach(sp ->
                        System.out.printf("%-15s $%-15.2f%n",
                                sp.getName(),
                                sp.getTotalSales()
                        )
                );

        // 2. Print names + total commissions

        System.out.println("\n=== Total Commissions ===");
        System.out.printf("%-15s %-15s%n", "Name", "Commission Earned");
        System.out.println("--------------------------------");

        salesPersonList.stream()
                .map(sp -> new Object[]{
                        sp.getName(),
                        sp.getTotalSales() * sp.getCommission()
                })
                .forEach(obj ->
                        System.out.printf("%-15s $%-15.2f%n",
                                obj[0],
                                (double) obj[1]
                        )
                );
    }
}