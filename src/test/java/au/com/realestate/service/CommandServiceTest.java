package au.com.realestate.service;

import au.com.realestate.repository.CommandRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommandServiceTest {
  @Test
  void shouldGetAllCommands() {
    List<String> allCommands = List.of();
    CommandRepository commandRepository = mock(CommandRepository.class);
    when(commandRepository.read()).thenReturn(allCommands);
    CommandService commandService = new CommandService(commandRepository);

    List<String> commands = commandService.getAllCommands();

    MatcherAssert.assertThat(commands, is(allCommands));
  }

}
