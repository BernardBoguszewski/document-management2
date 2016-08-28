package pl.com.bottega.documentmanagement.patterns.decorator;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
