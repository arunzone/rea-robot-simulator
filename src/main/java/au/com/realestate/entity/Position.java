package au.com.realestate.entity;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Position {
  @NonNull
  private Coordinates coordinates;
  @NonNull
  private Direction direction;
}
