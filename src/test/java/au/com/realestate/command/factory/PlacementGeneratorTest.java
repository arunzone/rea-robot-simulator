package au.com.realestate.command.factory;

import au.com.realestate.command.Place;
import au.com.realestate.entity.Context;
import au.com.realestate.entity.Coordinates;
import au.com.realestate.entity.Direction;
import au.com.realestate.entity.Position;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

class PlaceGeneratorTest {

  @Test
  void shouldReturnPlaceCommand() {
    Context context = mock(Context.class);
    PlaceGenerator placeGenerator = new PlaceGenerator(context);

    Place place = placeGenerator.placeFrom("PLACE 1,2,EAST");

    Position position = Position.of(new Coordinates(1, 2), Direction.EAST);
    assertThat(place, is(samePropertyValuesAs(new Place(position, context))));
  }

  @Test
  void shouldReturnPlaceCommandHavingExtraSpaceBetweenCommandAndInput() {
    Context context = mock(Context.class);
    PlaceGenerator placeGenerator = new PlaceGenerator(context);

    Place place = placeGenerator.placeFrom("PLACE     1,2,EAST");

    Position position = Position.of(new Coordinates(1, 2), Direction.EAST);
    assertThat(place, is(samePropertyValuesAs(new Place(position, context))));
  }

  @Test
  void shouldReturnPlaceCommandHavingExtraSpaceBetweenCoordinates() {
    Context context = mock(Context.class);
    PlaceGenerator placeGenerator = new PlaceGenerator(context);

    Place place = placeGenerator.placeFrom("PLACE     1, 2 , EAST");

    Position position = Position.of(new Coordinates(1, 2), Direction.EAST);
    assertThat(place, is(samePropertyValuesAs(new Place(position, context))));
  }
}
