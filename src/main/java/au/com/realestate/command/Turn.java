package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;

import java.util.Map;

public class Turn {
  public void execute(Context context, Map<Direction, Direction> turnRegistry) {
    Position position = context.getPosition();
    if (position != null) {
      Direction direction = position.getDirection();
      position.setDirection(turnRegistry.get(direction));
    }
  }
}
