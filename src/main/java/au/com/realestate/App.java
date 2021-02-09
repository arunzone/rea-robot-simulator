package au.com.realestate;

import au.com.realestate.command.factory.CommandFactory;
import au.com.realestate.command.factory.PlaceGenerator;
import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.report.ConsoleReport;
import au.com.realestate.repository.FileRepository;
import au.com.realestate.service.CommandService;

public class App {
    public static void main(String[] args) {
        Context context = Context.of(new Coordinates(5, 5));
        CommandService service =  new CommandService(new FileRepository(null));
        ConsoleReport consoleReport = new ConsoleReport();
        PlaceGenerator placeGenerator = new PlaceGenerator(context);
        CommandFactory commandFactory = new CommandFactory(context, consoleReport, placeGenerator);
        service.getAllCommands().forEach( command -> commandFactory.commandFor(command).execute());
    }
}
