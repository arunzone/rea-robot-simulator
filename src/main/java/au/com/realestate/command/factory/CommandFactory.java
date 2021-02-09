package au.com.realestate.command.factory;

import au.com.realestate.command.Command;
import au.com.realestate.command.Left;
import au.com.realestate.command.Move;
import au.com.realestate.command.Report;
import au.com.realestate.command.Right;
import au.com.realestate.command.factory.exception.InvalidCommandException;
import au.com.realestate.entity.Context;

import java.util.Map;
import java.util.function.Function;

import static java.lang.String.format;
import static java.util.Map.entry;

public class CommandFactory {
  private final Context context;
  private final au.com.realestate.report.Report report;
  private final PlaceGenerator placeGenerator;
  private final Map<String, Function<String, Command>> commandRegistry = Map.ofEntries(
      entry("PLACE", this::placeFrom),
      entry("MOVE", input -> move()),
      entry("LEFT", input -> left()),
      entry("RIGHT", input -> right()),
      entry("REPORT", input -> report())
  );

  public CommandFactory(Context context, au.com.realestate.report.Report report, PlaceGenerator placeGenerator) {
    this.context = context;
    this.report = report;
    this.placeGenerator = placeGenerator;
  }

  public Command commandFor(String input) {
    String command = input.trim().split("\\s+")[0];
    if (commandRegistry.containsKey(command)) {
      return commandRegistry.get(command).apply(input);
    }
    throw new InvalidCommandException(format("Invalid command: %s", input));
  }

  private Command placeFrom(String input) {
    return placeGenerator.placeFrom(input);
  }

  private Command report() {
    return new Report(context, report);
  }

  private Command move() {
    return new Move(context);
  }

  private Command left() {
    return new Left(context);
  }

  private Command right() {
    return new Right(context);
  }
}
