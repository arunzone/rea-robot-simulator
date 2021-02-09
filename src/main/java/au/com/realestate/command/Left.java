package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;

import java.util.Map;
import java.util.function.Consumer;

import static java.util.Map.entry;

public class Left implements Command {
  private final Context context;
  private final Map<Direction, Direction> leftTurnRegistry = Map.ofEntries(
      entry(Direction.NORTH, Direction.WEST),
      entry(Direction.SOUTH, Direction.EAST),
      entry(Direction.WEST, Direction.SOUTH),
      entry(Direction.EAST, Direction.NORTH)
  );

  public Left(Context context) {
    this.context = context;
  }

  public void execute() {
    Position position = context.getPosition();
    if (position != null) {
      Direction direction = position.getDirection();
      position.setDirection(leftTurnRegistry.get(direction));
    }
  }
}
