package au.com.realestate.report;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;

public class ConsoleReport implements Report {
  public void report(Context context) {
    System.out.println("Expected output");
    Position position = context.getPosition();
    Coordinates coordinates = position.getCoordinates();
    Direction direction = position.getDirection();
    System.out.printf("\t%d,%d,%s", coordinates.getX(), coordinates.getY(), direction.name());
  }
}
