package au.com.realestate.service;

import au.com.realestate.repository.CommandRepository;

import java.util.List;

public class CommandService {
  private final CommandRepository commandRepository;
  private final CommandFilter commandFilter;

  public CommandService(CommandRepository commandRepository, CommandFilter commandFilter) {
    this.commandRepository = commandRepository;
    this.commandFilter = commandFilter;
  }

  public List<String> getAllCommands() {
    List<String> commands = commandRepository.read();
    return commandFilter.filterValid(commands);
  }
}
