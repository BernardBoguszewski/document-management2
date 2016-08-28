package pl.com.bottega.documentmanagement.patterns.decorator;

import java.math.BigDecimal;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public class Milk extends CoffeeDecorator {


    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public BigDecimal cost() {
        return coffee.cost().add(new BigDecimal(1));
    }

    @Override
    public String name() {
        return coffee.name() + "with milk";
    }
}
