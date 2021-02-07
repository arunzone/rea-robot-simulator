package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;

public class CommandFactory {
  private final Context context;
  private final Report report;

  public CommandFactory(Context context, Report report) {
    this.context = context;
    this.report = report;
  }

  public Command commandFor(String input) {
    if (input.trim().startsWith("PLACE")) {
      String positionArgumentText = input.split(" ")[1];
      String[] positionArguments = positionArgumentText.split(",");

      int x = Integer.parseInt(positionArguments[0]);
      int y = Integer.parseInt(positionArguments[1]);
      Direction direction = Direction.valueOf(positionArguments[2]);
      Coordinates coordinates = new Coordinates(x, y);
      return new Place(Position.of(coordinates, direction), context);
    }

    if (input.trim().equals("REPORT")) {
      return report;
    }
    return null;
  }
}
