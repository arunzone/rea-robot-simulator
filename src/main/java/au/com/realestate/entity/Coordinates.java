package au.com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Coordinates {
  @NonNull
  private int x;
  @NonNull
  private int y;
}
