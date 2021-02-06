package au.com.realestate.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Data
public class Context {
  @NonNull
  private Coordinates boundary;
  private Position position;
}
