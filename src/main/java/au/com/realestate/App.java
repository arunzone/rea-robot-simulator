package au.com.realestate;

import au.com.realestate.command.factory.CommandFactory;
import au.com.realestate.command.factory.PlaceGenerator;
import au.com.realestate.entity.Context;
import au.com.realestate.report.ConsoleReport;
import au.com.realestate.repository.FileRepository;
import au.com.realestate.service.CommandFilter;
import au.com.realestate.service.CommandService;
import au.com.realestate.setup.ContextInitializer;

import java.util.List;

public class App {
    public static void main(String[] args) {
        CommandFactory commandFactory = getCommandFactory();
        commandInputs().forEach(command ->
            commandFactory.commandFor(command).execute());
    }

    private static CommandFactory getCommandFactory() {
        Context context = new ContextInitializer().context();
        ConsoleReport consoleReport = new ConsoleReport();
        PlaceGenerator placeGenerator = new PlaceGenerator(context);
        return new CommandFactory(context, consoleReport, placeGenerator);
    }

    private static List<String> commandInputs() {
        CommandService service = new CommandService(new FileRepository(), new CommandFilter());
        return service.getAllCommands();
    }
}
