package au.com.realestate;

import au.com.realestate.command.CommandFactory;
import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.report.ConsoleReport;

public class App {
    public static void main(String[] args) {
        Context context = Context.of(new Coordinates(5, 5));
        ConsoleReport consoleReport = new ConsoleReport();
        CommandFactory commandFactory = new CommandFactory(context, consoleReport);
        for (String input : args) {
            commandFactory.commandFor(input).execute();
        }
    }
}
