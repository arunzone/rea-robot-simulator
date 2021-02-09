package au.com.realestate.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.lang.String.format;

public class FileRepository implements CommandRepository{

  public static final String INPUT_FILE = "INPUT_FILE";

  @Override
  public List<String> read() {
    String fileName = fileName();
    try {
      Path path = Path.of(fileName);
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw  new InvalidInputFileException(format("Invalid input file: %s", fileName));
    }
  }

  private String fileName() {
    if(System.getenv().containsKey(INPUT_FILE)){
      return System.getenv().get(INPUT_FILE);
    }
    return "src/test/resources/input.txt";
  }
}
