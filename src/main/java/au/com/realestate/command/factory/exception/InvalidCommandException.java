package au.com.realestate.command.factory.exception;

public class InvalidCommandException extends RuntimeException{
  public InvalidCommandException(String message){
    super(message);
  }
}
