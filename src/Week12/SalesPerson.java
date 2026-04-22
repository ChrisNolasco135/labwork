package Week12;
public class SalesPerson {
    private String name;
    private String city;
    private double commission;
    private double totalSales;

    // Constructor
    public SalesPerson(String name, String city, double commission, double totalSales) {
        this.name = name;
        this.city = city;
        this.commission = commission;
        this.totalSales = totalSales;
    }

    // Getters (optional but recommended)
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getCommission() {
        return commission;
    }

    public double getTotalSales() {
        return totalSales;
    }

    // Setters (optional if you need mutability)
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    // toString method
    @Override
    public String toString() {
        return "SalesPerson{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", commission=" + commission +
                ", totalSales=" + totalSales +
                '}';
    }
}
