package pl.com.bottega.documentmanagement.patterns.decorator;

import java.math.BigDecimal;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public class SmallCoffee implements Coffee {

    String name = "Small Coffee";
    BigDecimal cost = new BigDecimal(2);

    @Override
    public BigDecimal cost() {
        return cost;
    }

    @Override
    public String name() {
        return name;
    }

    public SmallCoffee(CoffeeDecorator... coffeeDecorator) {

    }
}
