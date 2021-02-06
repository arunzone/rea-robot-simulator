package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PlaceTest {
  @Test
  void shouldPlaceRobotInSpecificAxisAndDirection() {
    Coordinates coordinates = new Coordinates(1, 2);
    Position position = Position.of(coordinates, Direction.EAST);
    Context context = new Context();
    Place place = new Place(position, context);

    place.execute();

    assertThat(context.getPosition(), is(position));
  }

}
