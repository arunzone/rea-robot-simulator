package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RightTest {
  private final Context context = Context.of(new Coordinates(2, 2));
  private final Coordinates coordinates = new Coordinates(1, 1);

  @Test
  void shouldTurnRightFromNorthToEast() {
    context.setPosition(Position.of(coordinates, Direction.NORTH));
    Right right = new Right(context);

    right.execute();

    Position position = Position.of(coordinates, Direction.EAST);
    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldTurnRightFromWestToNorth() {
    context.setPosition(Position.of(coordinates, Direction.WEST));
    Right right = new Right(context);

    right.execute();

    Position position = Position.of(coordinates, Direction.NORTH);
    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldTurnRightFromSouthToWest() {
    context.setPosition(Position.of(coordinates, Direction.SOUTH));
    Right right = new Right(context);

    right.execute();

    Position position = Position.of(coordinates, Direction.WEST);
    assertThat(context.getPosition(), is(position));
  }

  @Test
  void shouldTurnRightFromEastToSouth() {
    context.setPosition(Position.of(coordinates, Direction.EAST));
    Right right = new Right(context);

    right.execute();

    Position position = Position.of(coordinates, Direction.SOUTH);
    assertThat(context.getPosition(), is(position));
  }


}
