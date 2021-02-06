package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Position;

public class Place {
  private final Position position;
  private final Context context;

  public Place(Position position, Context context) {
    this.position = position;
    this.context = context;
  }

  public void execute() {
    boolean safeXAxis = context.getBoundary().getX() >= position.getCoordinates().getX();
    boolean safeYAxis = context.getBoundary().getY() >= position.getCoordinates().getY();
    if (safeXAxis && safeYAxis) {
      context.setPosition(position);
    }
  }
}
