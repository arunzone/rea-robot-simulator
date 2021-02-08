package au.com.realestate.command;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

class CommandFactoryTest {
  private final Context context = Context.of(new Coordinates(1, 2));

  @Test
  void shouldReturnPlaceCommand() {
    CommandFactory commandFactory = new CommandFactory(context, null);
    Command command = commandFactory.commandFor("PLACE 1,2,EAST");

    Position position = Position.of(new Coordinates(1, 2), Direction.EAST);
    assertThat(command, is(samePropertyValuesAs(new Place(position, context))));
  }

  @Test
  void shouldDisplayMessageForInvalidCommand() throws Exception {
    CommandFactory commandFactory = new CommandFactory(context, null);
    Command command = commandFactory.commandFor("UNKNOWN 1,2,EAST");
    String text = tapSystemOut(() -> {
      command.execute();
    });

    assertThat(text, is("Invalid command: UNKNOWN 1,2,EAST\n"));
  }

  @Test
  void shouldReturnReportCommand() {
    au.com.realestate.report.Report report = mock(au.com.realestate.report.Report.class);
    CommandFactory commandFactory = new CommandFactory(context, report);
    Command command = commandFactory.commandFor("REPORT");

    assertThat(command, is(samePropertyValuesAs(new Report(context, report))));
  }

  @Test
  void shouldReturnMoveCommand() {
    CommandFactory commandFactory = new CommandFactory(context, null);
    Command command = commandFactory.commandFor("MOVE");

    assertThat(command, is(samePropertyValuesAs(new Move(context))));
  }
}
