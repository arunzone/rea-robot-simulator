package au.com.realestate.report;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ConsoleReportTest {
  @Test
  void shouldPrintOutputInConsole() throws Exception {
    String text = tapSystemOut(() -> {
      Context context = Context.of(new Coordinates(1, 2));
      context.setPosition(Position.of(new Coordinates(1, 2), Direction.EAST));
      new ConsoleReport().report(context);
    });

    assertThat(text, is("Expected output\n\t1,2,EAST"));
  }

}
