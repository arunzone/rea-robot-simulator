package au.com.realestate.setup;

import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;

@ExtendWith(SystemStubsExtension.class)
class ContextInitializerTest {
  @SystemStub
  private EnvironmentVariables environmentVariables;

  @Test
  void shouldReturnDefaultBoardSize10x10() {
    ContextInitializer contextInitializer = new ContextInitializer();
    Context context = contextInitializer.context();

    Context expectedContext = Context.of(new Coordinates(10, 10));
    assertThat(context, is(samePropertyValuesAs(expectedContext)));
  }

  @Test
  void shouldReturnBoardSize5x5SetInEnv() {
    environmentVariables.set("X", "5");
    environmentVariables.set("Y", "5");
    ContextInitializer contextInitializer = new ContextInitializer();
    Context context = contextInitializer.context();

    Context expectedContext = Context.of(new Coordinates(5, 5));
    assertThat(context, is(samePropertyValuesAs(expectedContext)));
  }

  @Test
  void shouldReturnBoardSize5x5SWhenOnlyXisSet() {
    environmentVariables.set("X", "5");
    ContextInitializer contextInitializer = new ContextInitializer();
    Context context = contextInitializer.context();

    Context expectedContext = Context.of(new Coordinates(5, 5));
    assertThat(context, is(samePropertyValuesAs(expectedContext)));
  }

  @Test
  void shouldReturnBoardSize5x7() {
    environmentVariables.set("X", "4");
    environmentVariables.set("Y", "8");
    ContextInitializer contextInitializer = new ContextInitializer();
    Context context = contextInitializer.context();

    Context expectedContext = Context.of(new Coordinates(4, 8));
    assertThat(context, is(samePropertyValuesAs(expectedContext)));
  }
}
