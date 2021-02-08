package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MoveTest {
  @Test
  void shouldIncrementYIfFacingNorth() {
    Context context = Context.of(new Coordinates(5, 5));
    context.setPosition(Position.of(new Coordinates(0, 0), Direction.NORTH));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(0, 1), Direction.NORTH)));
  }

  @Test
  void shouldNotIncrementYWhenReachedBoundary() {
    Context context = Context.of(new Coordinates(1, 1));
    context.setPosition(Position.of(new Coordinates(0, 1), Direction.NORTH));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(0, 1), Direction.NORTH)));
  }

  @Test
  void shouldNotIncrementYWhenNotPlaced() {
    Context context = Context.of(new Coordinates(1, 1));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(nullValue()));
  }

  @Test
  void shouldIncrementXIfFacingEast() {
    Context context = Context.of(new Coordinates(5, 5));
    context.setPosition(Position.of(new Coordinates(0, 0), Direction.EAST));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(1, 0), Direction.EAST)));
  }

  @Test
  void shouldNotIncrementXWhenReachedBoundary() {
    Context context = Context.of(new Coordinates(1, 1));
    context.setPosition(Position.of(new Coordinates(1, 0), Direction.EAST));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(1, 0), Direction.EAST)));
  }

  @Test
  void shouldIDecrementYIfFacingSouth() {
    Context context = Context.of(new Coordinates(5, 5));
    context.setPosition(Position.of(new Coordinates(0, 1), Direction.SOUTH));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(0, 0), Direction.SOUTH)));
  }

  @Test
  void shouldNotDecrementYWhenReachedBoundary() {
    Context context = Context.of(new Coordinates(1, 1));
    context.setPosition(Position.of(new Coordinates(1, 0), Direction.SOUTH));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(1, 0), Direction.SOUTH)));
  }

  @Test
  void shouldDecrementXIfFacingWest() {
    Context context = Context.of(new Coordinates(5, 5));
    context.setPosition(Position.of(new Coordinates(1, 0), Direction.WEST));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(0, 0), Direction.WEST)));
  }

  @Test
  void shouldNotDecrementXWhenReachedBoundary() {
    Context context = Context.of(new Coordinates(1, 1));
    context.setPosition(Position.of(new Coordinates(0, 1), Direction.WEST));
    Move move = new Move(context);

    move.execute();

    assertThat(context.getPosition(), is(Position.of(new Coordinates(0, 1), Direction.WEST)));
  }

}
