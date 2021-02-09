package au.com.realestate.service;

import au.com.realestate.repository.CommandRepository;

import java.util.List;

public class CommandService {
  private final CommandRepository commandRepository;

  public CommandService(CommandRepository commandRepository) {

    this.commandRepository = commandRepository;
  }

  public List<String> getAllCommands() {
    return commandRepository.read();
  }
}
