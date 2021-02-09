package au.com.realestate.service;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

class CommandFilterTest {

  @Test
  void shouldReturnZeroCommandsIfPlaceIsNotFound() {
    List<String> commands = List.of("MOVE", "RIGHT", "REPORT");

    CommandFilter commandFilter = new CommandFilter();

    List<String> validCommands = commandFilter.filterValid(commands);

    assertThat(validCommands, is(empty()));
  }

  @Test
  void shouldReturnCommandsFromOnlyLastPlace() {
    List<String> commands = List.of("MOVE", "PLACE 1,2,NORTH", "RIGHT", "PLACE 1,2,NORTH", "REPORT");

    CommandFilter commandFilter = new CommandFilter();

    List<String> validCommands = commandFilter.filterValid(commands);

    assertThat(validCommands, IsIterableContainingInOrder.contains("PLACE 1,2,NORTH", "REPORT"));
  }


}
