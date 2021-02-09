package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class LeftTest {
  private Context context = Context.of(new Coordinates(2, 2));
  private Coordinates coordinates = new Coordinates(1, 1);

  @Test
  void shouldTurnLeftFromNorthToWest() {
    context.setPosition(Position.of(coordinates, Direction.NORTH));
    Left left = new Left(context);

    left.execute();

    Position position = Position.of(coordinates, Direction.WEST);
    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldTurnLeftFromWestToSouth() {
    context.setPosition(Position.of(coordinates, Direction.WEST));
    Left left = new Left(context);

    left.execute();

    Position position = Position.of(coordinates, Direction.SOUTH);
    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldTurnLeftFromSouthToEast() {
    context.setPosition(Position.of(coordinates, Direction.SOUTH));
    Left left = new Left(context);

    left.execute();

    Position position = Position.of(coordinates, Direction.EAST);
    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldTurnLeftFromEastToNorth() {
    context.setPosition(Position.of(coordinates, Direction.EAST));
    Left left = new Left(context);

    left.execute();

    Position position = Position.of(coordinates, Direction.NORTH);
    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldNotTakeAnyAction() {
    Left left = new Left(context);

    left.execute();

    assertThat(context, is(context));
  }

}
