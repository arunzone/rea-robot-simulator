package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Direction;

import java.util.Map;

import static java.util.Map.entry;

public class Left implements Command {
  private static final Map<Direction, Direction> TURN_REGISTRY = Map.ofEntries(
      entry(Direction.NORTH, Direction.WEST),
      entry(Direction.SOUTH, Direction.EAST),
      entry(Direction.WEST, Direction.SOUTH),
      entry(Direction.EAST, Direction.NORTH)
  );
  private final Context context;

  public Left(Context context) {
    this.context = context;
  }

  @Override
  public void execute() {
    new Turn().execute(context, TURN_REGISTRY);
  }
}
