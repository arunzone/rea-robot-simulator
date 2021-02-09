package au.com.realestate;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest
{
    @Test
    public void shouldDisplayPlacedStateInConsole() throws Exception {
        String text = tapSystemOut(() -> {
            new App().main(new String[]{});
        });

        assertThat(text, is("Expected output\n\t3,3,NORTH"));
    }
}
