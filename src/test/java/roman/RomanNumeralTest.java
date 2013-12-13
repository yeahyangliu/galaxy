package roman;

import org.junit.Test;
import roman.RomanNumber;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static roman.RomanNumber.*;

public class RomanNumeralTest {
    @Test
    public void shouldAssertRomanNumConversionToNumber() {

        int valueI = I.getValue();
        int valueV = V.getValue();
        int valueX = X.getValue();
        int valueL = L.getValue();
        int valueC = C.getValue();
        int valueD = D.getValue();
        int valueM = M.getValue();

        assertThat(valueI, is(1));
        assertThat(valueV, is(5));
        assertThat(valueX, is(10));
        assertThat(valueL, is(50));
        assertThat(valueC, is(100));
        assertThat(valueD, is(500));
        assertThat(valueM, is(1000));
    }

    @Test
    public void shouldGetEnumFromString() {
        RomanNumber value = getValueFromString("M");

        assertThat(value, is(M));
    }
}
