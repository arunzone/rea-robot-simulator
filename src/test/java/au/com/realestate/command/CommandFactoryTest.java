package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;

class CommandFactoryTest {

  @Test
  void shouldReturnPlaceCommand() {
    Context context = Context.of(new Coordinates(1, 2));
    CommandFactory commandFactory = new CommandFactory(context);
    Command command = commandFactory.commandFor("PLACE 1,2,EAST");

    Position position = Position.of(new Coordinates(1, 2), Direction.EAST);
    MatcherAssert.assertThat(command, is(equalTo(new Place(position, context))));
  }

  @Test
  void shouldReturnNullForInvalidCommand() {
    Context context = Context.of(new Coordinates(1, 2));
    CommandFactory commandFactory = new CommandFactory(context);
    Command command = commandFactory.commandFor("SET 1,2,EAST");

    MatcherAssert.assertThat(command, is(nullValue()));
  }
}
