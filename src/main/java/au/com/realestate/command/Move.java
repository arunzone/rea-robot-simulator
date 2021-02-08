package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import lombok.NonNull;

public class Move implements Command {
  private final Context context;

  public Move(Context context) {
    this.context = context;
  }

  public void execute() {
    Position position = context.getPosition();
    if (position != null) {
      Direction direction = position.getDirection();
      moveNorth(direction, position.getCoordinates());
      moveEast(direction, position.getCoordinates());
    }

  }

  private void moveNorth(Direction direction, @NonNull Coordinates coordinates) {
    if (direction == Direction.NORTH) {
      int y = coordinates.getY();
      if (context.getBoundary().getY() > y) {
        coordinates.setY(y + 1);
      }
    }
  }

  private void moveEast(Direction direction, @NonNull Coordinates coordinates) {
    if (direction == Direction.EAST) {
      int x = coordinates.getX();
      if (context.getBoundary().getX() > x) {
        coordinates.setX(x + 1);
      }
    }
  }

}
