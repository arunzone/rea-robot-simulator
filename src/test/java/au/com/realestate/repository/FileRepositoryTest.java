package au.com.realestate.repository;

import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileRepositoryTest {
  @Test
  void shouldReturnDefaultFileContent() {
    FileRepository fileRepository = new FileRepository();
    List<String> commands = fileRepository.read();

    assertThat(commands, IsIterableContainingInOrder.contains(
        "PLACE 1,2,EAST",
        "MOVE",
        "MOVE",
        "LEFT",
        "MOVE",
        "REPORT"));
  }

  @Test
  void shouldReturnGivenFileContent() throws Exception {
    FileRepository fileRepository = new FileRepository();
    List<String> commands = SystemLambda.withEnvironmentVariable(FileRepository.INPUT_FILE, "src/test/resources/simple-input.txt")
        .execute(() -> fileRepository.read());

    assertThat(commands, IsIterableContainingInOrder.contains(
        "PLACE 0,0,NORTH",
        "MOVE",
        "REPORT"));
  }

  @Test
  void shouldThrowExceptionWhenNotAFile() {
    FileRepository fileRepository = new FileRepository();

    InvalidInputFileException invalidInputFileException = assertThrows(InvalidInputFileException.class, () -> {
      SystemLambda.withEnvironmentVariable(FileRepository.INPUT_FILE, "unavailable")
          .execute(() -> fileRepository.read());
    });

    assertThat(invalidInputFileException.getMessage(), is("Invalid input file: unavailable"));
  }

}
