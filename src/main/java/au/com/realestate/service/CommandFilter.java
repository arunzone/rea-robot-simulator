package au.com.realestate.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class CommandFilter {

  public List<String> filterValid(List<String> commands) {
    Optional<String> placeOptional = IntStream.range(0, commands.size()).
        mapToObj(i -> commands.get(commands.size() - i - 1))
        .filter(command -> command.trim().startsWith("PLACE"))
        .findFirst();

    if (!placeOptional.isPresent()) {
      return List.of();
    }

    String LastPlaceCommand = placeOptional.get();
    int fromIndex = commands.lastIndexOf(LastPlaceCommand);
    return commands.subList(fromIndex, commands.size());
  }
}
