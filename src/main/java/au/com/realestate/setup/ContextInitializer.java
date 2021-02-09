package au.com.realestate.setup;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;

import java.util.regex.Pattern;

public class ContextInitializer {

  private static final String X = "X";
  private static final String Y = "Y";
  private final Pattern integerPattern = Pattern.compile("\\d+");

  public Context context() {
    Integer defaultSize = 10;
    Integer x = numberFor(defaultSize, X);
    Integer y = numberFor(x, Y);
    return Context.of(new Coordinates(x, y));
  }

  private Integer numberFor(Integer defaultSize, String type) {
    if (System.getenv().containsKey(type)) {
      String xAxis = System.getenv(type);
      if (integerPattern.matcher(xAxis).matches()) {
        return Integer.valueOf(xAxis);
      }
    }
    return defaultSize;
  }
}
