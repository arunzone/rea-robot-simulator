package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Direction;

import java.util.Map;

import static java.util.Map.entry;

public class Right implements Command {
  private static final Map<Direction, Direction> TURN_REGISTRY = Map.ofEntries(
      entry(Direction.NORTH, Direction.EAST),
      entry(Direction.SOUTH, Direction.WEST),
      entry(Direction.WEST, Direction.NORTH),
      entry(Direction.EAST, Direction.SOUTH)
  );
  private final Context context;

  public Right(Context context) {
    this.context = context;
  }

  @Override
  public void execute() {
    new Turn().execute(context, TURN_REGISTRY);
  }
}
