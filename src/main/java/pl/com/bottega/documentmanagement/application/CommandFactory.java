package pl.com.bottega.documentmanagement.application;

/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
public interface CommandFactory {

    Command createCommand(String command);

}
