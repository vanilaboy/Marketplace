/**
 * Created by root on 16.12.17 with love.
 */
public class Staff {

    private String name;
    private String pathToImage;
    private String about;
    private String shortAbout;
    private double cost;
    private double newCost = 0;

    public Staff(String name, String path, String a, double cst, double newcst, String sA) {
        this.name = name;
        pathToImage = path;
        about = a;
        cost = cst;
        newCost = newcst;
        shortAbout = sA;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public String getAbout() {
        return about;
    }

    public String getShortAbout() {
        return shortAbout;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getNewCost() {
        return newCost;
    }

    public void doSale(float newCost) {
        this.newCost = newCost;
    }

    @Override
    public String toString() {
        return name + ";;;;;;;;;;" +
                pathToImage + ";;;;;;;;;;" +
                about + ";;;;;;;;;;" +
                shortAbout + ";;;;;;;;;;" +
                cost + ";;;;;;;;;;" +
                newCost;
    }
}
