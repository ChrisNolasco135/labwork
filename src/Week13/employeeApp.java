package Week13;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

public class employeeApp {

    public static void main(String[] args) {

        List<Employee> employeesList = new ArrayList<>();

        try {
            // 🔹 JDBC connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/labwork13",
                    "root",
                    "Harr8009"
            );

            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT id, name, salary FROM employees"
            );

            ResultSet rs = stmt.executeQuery();

            // 🔹 Convert ResultSet → List (no explicit loop)
            employeesList = StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(
                            new Iterator<Employee>() {
                                public boolean hasNext() {
                                    try { return rs.next(); }
                                    catch (SQLException e) { throw new RuntimeException(e); }
                                }

                                public Employee next() {
                                    try {
                                        return new Employee(
                                                rs.getInt("id"),
                                                rs.getString("name"),
                                                rs.getDouble("salary")
                                        );
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            },
                            Spliterator.ORDERED
                    ),
                    false
            ).collect(Collectors.toList());

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 🔹 SINGLE STREAM PIPELINE (no loops)
        employeesList.stream()
                .map(e -> new Employee(
                        e.getId(),
                        e.getName(),
                        e.getSalary() > 50000
                                ? e.getSalary() * 0.85   // 15% tax
                                : e.getSalary() * 0.90   // 10% tax
                ))
                .map(e -> e.getName() + " : $" + String.format("%.2f", e.getSalary()))
                .forEach(System.out::println);
    }
}

// 🔹 Employee class
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + " " + name + " $" + salary;
    }
}
