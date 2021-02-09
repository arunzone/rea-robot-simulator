package au.com.realestate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(SystemStubsExtension.class)
public class AppTest {
    @SystemStub
    private EnvironmentVariables environmentVariables;

    @Test
    public void shouldDisplayPlacedStateInConsole() throws Exception {
        String text = tapSystemOut(() -> {
            App.main(new String[]{});
        });

        assertThat(text, is("Expected output\n\t3,3,NORTH"));
    }

    @Test
    public void shouldHandleException() throws Exception {
        environmentVariables.set("INPUT_FILE", "yeah");
        String text = tapSystemOut(() -> {
            new App().main(new String[]{});
        });

        assertThat(text, is("Invalid input file: yeah\n"));
    }
}
