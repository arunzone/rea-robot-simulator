package au.com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class Coordinates {
  private @NonNull Integer x;
  private @NonNull Integer y;
}
