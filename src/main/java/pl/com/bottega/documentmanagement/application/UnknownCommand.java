package pl.com.bottega.documentmanagement.application;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public class UnknownCommand extends SpringCommand{

    @Override
    public void execute() {
        System.out.println("Sorry, I don't understand");
    }
}
