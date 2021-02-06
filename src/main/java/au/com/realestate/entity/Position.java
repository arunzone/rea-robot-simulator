package au.com.realestate.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Data
public class Position {
  @NonNull
  private Coordinates coordinates;
  @NonNull
  private Direction direction;
}
