package au.com.realestate;

import au.com.realestate.command.CommandFactory;
import au.com.realestate.command.Report;
import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.report.ConsoleReport;

public class App {
    public static void main(String[] args) {
        Context context = Context.of(new Coordinates(5, 5));
        Report report = new Report(context, new ConsoleReport());
        CommandFactory commandFactory = new CommandFactory(context, report);
        for (String input : args) {
            commandFactory.commandFor(input).execute();
        }
    }
}
