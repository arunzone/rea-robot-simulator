package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PlaceTest {
  @Test
  void shouldPlaceRobotInSpecificAxisAndDirection() {
    Coordinates coordinates = new Coordinates(1, 2);
    Position position = Position.of(coordinates, Direction.EAST);
    Context context = Context.of(new Coordinates(5, 5));
    Place place = new Place(position, context);

    place.execute();

    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldIgnorePlacementOfRobotOutsideXAxisBoundary() {
    Coordinates coordinates = new Coordinates(6, 2);
    Position position = Position.of(coordinates, Direction.EAST);
    Context context = Context.of(new Coordinates(5, 5));
    Place place = new Place(position, context);

    place.execute();

    assertThat(context.getPosition(), is(nullValue()));
  }

  @Test
  void shouldIgnorePlacementOfRobotOutsideYAxisBoundary() {
    Coordinates coordinates = new Coordinates(2, 8);
    Position position = Position.of(coordinates, Direction.EAST);
    Context context = Context.of(new Coordinates(5, 5));
    Place place = new Place(position, context);

    place.execute();

    assertThat(context.getPosition(), is(nullValue()));
  }

}
