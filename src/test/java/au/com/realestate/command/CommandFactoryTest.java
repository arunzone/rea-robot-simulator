package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

class CommandFactoryTest {
  private final Context context = Context.of(new Coordinates(1, 2));

  @Test
  void shouldReturnPlaceCommand() {
    CommandFactory commandFactory = new CommandFactory(context, null);
    Command command = commandFactory.commandFor("PLACE 1,2,EAST");

    Position position = Position.of(new Coordinates(1, 2), Direction.EAST);
    assertThat(command, is(equalTo(new Place(position, context))));
  }

  @Test
  void shouldReturnNullForInvalidCommand() {
    CommandFactory commandFactory = new CommandFactory(context, null);
    Command command = commandFactory.commandFor("SET 1,2,EAST");

    assertThat(command, is(nullValue()));
  }

  @Test
  void shouldReturnReportCommand() {
    Report report = mock(Report.class);
    CommandFactory commandFactory = new CommandFactory(context, report);
    Command command = commandFactory.commandFor("REPORT");

    assertThat(command, is(report));
  }
}
