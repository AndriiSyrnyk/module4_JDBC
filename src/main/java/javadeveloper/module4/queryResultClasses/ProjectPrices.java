package javadeveloper.module4.queryResultClasses;

public class ProjectPrices {
    private String name;
    private int price;

    public ProjectPrices(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
