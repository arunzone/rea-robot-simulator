package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class TurnTest {

  @Test
  void shouldNotTakeAnyAction() {
    Turn turn = new Turn();

    Context context = Context.of(new Coordinates(1, 1));
    turn.execute(context, null);

    assertThat(context, is(context));
  }

  @Test
  void shouldSetTurnedDirection() {
    Turn turn = new Turn();

    Coordinates coordinates = new Coordinates(1, 1);
    Position position = Position.of(coordinates, Direction.NORTH);
    Context context = Context.of(coordinates);
    context.setPosition(position);

    Map<Direction, Direction> turnRegistry = Map.ofEntries(
        entry(Direction.NORTH, Direction.WEST));
    turn.execute(context, turnRegistry);

    assertThat(context.getPosition().getDirection(), is(Direction.WEST));
  }


}
