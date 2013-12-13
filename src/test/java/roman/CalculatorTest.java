package roman;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static roman.Calculator.calculateValueOfString;


public class CalculatorTest {

    @Test
    public void shouldGetTheValueOfMM() {
        int stringValue = calculateValueOfString("MM");

        assertThat(stringValue, is(2000));
    }


    @Test
    public void shouldGetTheValueOfMCMXLIV() {
        int stringValue = calculateValueOfString("MCMXLIV");

        assertThat(stringValue, is(1944));
    }

    @Test
    public void shouldGetTheValueOfMMVI() {
        int stringValue = calculateValueOfString("MMVI");

        assertThat(stringValue, is(2006));
    }

}
