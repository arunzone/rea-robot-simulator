package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;

import java.util.Map;
import java.util.function.Consumer;

import static java.util.Map.entry;

public class Move implements Command {
  private final Context context;
  private final Map<Direction, Consumer<Coordinates>> moveRegistry = Map.ofEntries(
      entry(Direction.NORTH, this::moveNorth),
      entry(Direction.SOUTH, this::moveSouth),
      entry(Direction.WEST, this::moveWest),
      entry(Direction.EAST, this::moveEast)
  );

  public Move(Context context) {
    this.context = context;
  }

  public void execute() {
    Position position = context.getPosition();
    if (position != null) {
      Direction direction = position.getDirection();
      moveRegistry.get(direction).accept(position.getCoordinates());
    }
  }

  private void moveNorth(Coordinates coordinates) {
    int y = coordinates.getY();
    if (context.getBoundary().getY() > y) {
      coordinates.setY(y + 1);
    }
  }

  private void moveSouth(Coordinates coordinates) {
    int y = coordinates.getY();
    if (y > 0) {
      coordinates.setY(y - 1);
    }
  }

  private void moveEast(Coordinates coordinates) {
    int x = coordinates.getX();
    if (context.getBoundary().getX() > x) {
      coordinates.setX(x + 1);
    }
  }

  private void moveWest(Coordinates coordinates) {
    int x = coordinates.getX();
    if (x > 0) {
      coordinates.setX(x - 1);
    }
  }

}
