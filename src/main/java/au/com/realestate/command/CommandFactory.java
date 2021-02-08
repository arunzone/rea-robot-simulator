package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;

import java.util.Map;
import java.util.function.Function;

import static java.util.Map.entry;

public class CommandFactory {
  private final Context context;
  private final au.com.realestate.report.Report report;
  private final Map<String, Function<String, Command>> commandRegistry;

  public CommandFactory(Context context, au.com.realestate.report.Report report) {
    this.context = context;
    this.report = report;
    commandRegistry = Map.ofEntries(
        entry("PLACE", this::placeFrom),
        entry("REPORT", input -> report())
    );
  }

  public Command commandFor(String input) {
    String command = input.split(" ")[0];
    if(commandRegistry.containsKey(command)) {
      return commandRegistry.get(command).apply(input);
    }
    return () -> System.out.printf("Invalid command: %s\n", input);
  }

  private Place placeFrom(String input) {
    String positionArgumentText = input.split(" ")[1];
    String[] positionArguments = positionArgumentText.split(",");

    int x = Integer.parseInt(positionArguments[0]);
    int y = Integer.parseInt(positionArguments[1]);
    Direction direction = Direction.valueOf(positionArguments[2]);
    Coordinates coordinates = new Coordinates(x, y);
    return new Place(Position.of(coordinates, direction), context);
  }

  private Command report(){
    return new Report(context, report);
  }

}
