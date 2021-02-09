package au.com.realestate.command.factory;

import au.com.realestate.command.Command;
import au.com.realestate.command.Left;
import au.com.realestate.command.Move;
import au.com.realestate.command.Place;
import au.com.realestate.command.Report;
import au.com.realestate.command.Right;
import au.com.realestate.command.factory.exception.InvalidCommandException;
import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommandFactoryTest {
  private final Context context = Context.of(new Coordinates(1, 2));

  @Test
  void shouldReturnPlaceCommand() {
    PlaceGenerator placeGenerator = mock(PlaceGenerator.class);
    Place place = mock(Place.class);
    when(placeGenerator.placeFrom("PLACE 1,2,EAST")).thenReturn(place);
    CommandFactory commandFactory = new CommandFactory(context, null, placeGenerator);
    Command command = commandFactory.commandFor("PLACE 1,2,EAST");

    assertThat(command, is(place));
  }

  @Test
  void shouldThrowInvalidCommandException() {
    CommandFactory commandFactory = new CommandFactory(context, null, null);

    InvalidCommandException invalidCommandException = assertThrows(InvalidCommandException.class, () -> commandFactory.commandFor("UNKNOWN 1,2,EAST"));

    assertThat(invalidCommandException.getMessage(), is("Invalid command: UNKNOWN 1,2,EAST"));
  }

  @Test
  void shouldReturnReportCommand() {
    au.com.realestate.report.Report report = mock(au.com.realestate.report.Report.class);
    CommandFactory commandFactory = new CommandFactory(context, report, null);
    Command command = commandFactory.commandFor("REPORT");

    assertThat(command, is(samePropertyValuesAs(new Report(context, report))));
  }

  @Test
  void shouldReturnMoveCommand() {
    CommandFactory commandFactory = new CommandFactory(context, null, null);
    Command command = commandFactory.commandFor("MOVE");

    assertThat(command, is(samePropertyValuesAs(new Move(context))));
  }

  @Test
  void shouldReturnLeftCommand() {
    CommandFactory commandFactory = new CommandFactory(context, null, null);
    Command command = commandFactory.commandFor("LEFT");

    assertThat(command, is(samePropertyValuesAs(new Left(context))));
  }

  @Test
  void shouldReturnRightCommand() {
    CommandFactory commandFactory = new CommandFactory(context, null, null);
    Command command = commandFactory.commandFor("RIGHT");

    assertThat(command, is(samePropertyValuesAs(new Right(context))));
  }
}
