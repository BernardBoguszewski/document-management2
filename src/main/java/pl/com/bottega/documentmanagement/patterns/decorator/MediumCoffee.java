package pl.com.bottega.documentmanagement.patterns.decorator;

import java.math.BigDecimal;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public class MediumCoffee implements Coffee {

    String name = "Medium Coffee";
    BigDecimal cost = new BigDecimal(3.5);

    @Override
    public BigDecimal cost() {
        return cost;
    }

    @Override
    public String name() {
        return name;
    }
}
