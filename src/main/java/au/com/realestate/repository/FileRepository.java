package au.com.realestate.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.lang.String.format;

public class FileRepository implements CommandRepository{
  private final String inputFileName;

  public FileRepository(String inputFileName) {
    this.inputFileName = inputFileName;
  }

  @Override
  public List<String> read() {
    try {
      Path path = Path.of(fileName());
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw  new InvalidInputFileException(format("Invalid input file: %s", inputFileName));
    }
  }

  private String fileName() {
    String fileName = "src/test/resources/input.txt";
    if(inputFileName == null){
      return fileName;
    }
    return inputFileName;
  }
}
