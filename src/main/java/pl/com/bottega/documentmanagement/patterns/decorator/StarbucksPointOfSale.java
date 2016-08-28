package pl.com.bottega.documentmanagement.patterns.decorator;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public class StarbucksPointOfSale {

    public static void main(String[] args) {

        Coffee coffee = new SmallCoffee();
        coffee = new Milk(coffee);
        coffee = new Syrup(coffee);
        System.out.println(coffee.cost());
    }
}
