package au.com.realestate;

import au.com.realestate.command.factory.CommandFactory;
import au.com.realestate.command.factory.PlaceGenerator;
import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.report.ConsoleReport;

public class App {
    public static void main(String[] args) {
        Context context = Context.of(new Coordinates(5, 5));
        ConsoleReport consoleReport = new ConsoleReport();
        PlaceGenerator placeGenerator = new PlaceGenerator(context);
        CommandFactory commandFactory = new CommandFactory(context, consoleReport, placeGenerator);
        for (String input : args) {
            commandFactory.commandFor(input).execute();
        }
    }
}
