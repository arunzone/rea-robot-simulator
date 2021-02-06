package au.com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class Coordinates {
  @NonNull
  private int x;
  @NonNull
  private int y;
}
