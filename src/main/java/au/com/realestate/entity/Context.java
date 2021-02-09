package au.com.realestate.entity;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Context {
  @NonNull
  private final Coordinates boundary;
  private Position position;

  public Coordinates getBoundary() {
    return boundary;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
