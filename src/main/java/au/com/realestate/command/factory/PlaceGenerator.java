package au.com.realestate.command.factory;

import au.com.realestate.command.Place;
import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;

public class PlaceGenerator {
  private final Context context;

  public PlaceGenerator(Context context) {
    this.context = context;
  }

  public Place placeFrom(String input) {
    String commandRemovedInput = input.replace("PLACE", "");
    String[] positionArguments = commandRemovedInput.trim().split("\\s*,\\s*");

    Coordinates coordinates = getCoordinates(positionArguments);
    Direction direction = Direction.valueOf(positionArguments[2]);
    return new Place(Position.of(coordinates, direction), context);
  }

  private Coordinates getCoordinates(String[] positionArguments) {
    int x = Integer.parseInt(positionArguments[0]);
    int y = Integer.parseInt(positionArguments[1]);
    return  new Coordinates(x, y);
  }
}
