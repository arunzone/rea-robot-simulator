package au.com.realestate.repository;

public class InvalidInputFileException extends RuntimeException {
  public InvalidInputFileException(String message) {
    super(message);
  }
}
