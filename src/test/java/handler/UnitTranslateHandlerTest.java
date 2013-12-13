package handler;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static handler.UnitTranslateHandler.getUnitRomanMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UnitTranslateHandlerTest {

    private UnitTranslateHandler handler;
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
        handler = new UnitTranslateHandler();
    }

    @Test
    public void shouldSetUnitWhenItDeclare() throws Exception {
        handler.interpret("glob is I");

        assertThat(getUnitRomanMap().size(), is(1));
    }

    @Test
    public void shouldPrintTranslateSuccessWhenInputIsCorrectly() throws Exception {
        handler.interpret("glob is I");

        assertThat(outputStream.toString().contains("translate glob to I successfully!"), is(true));
    }

    @Test
    public void shouldAskNextHandleToInterpretIfItCanNotBeenFind() throws Exception {
        MetalsUnitsCHandler metalsUnitsCHandler = mock(MetalsUnitsCHandler.class);
        handler.setNextHandler(metalsUnitsCHandler);

        handler.interpret("invalid input");

        verify(metalsUnitsCHandler).interpret("invalid input");
    }
}
