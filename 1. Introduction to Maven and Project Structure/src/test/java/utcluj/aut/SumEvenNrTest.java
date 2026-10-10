package utcluj.aut;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumEvenNrTest
{
    @Test
    public void testSumEvenNr()
    {
        assertEquals(2, SumEvenNr.suma_pare(1));
        assertEquals(6, SumEvenNr.suma_pare(2));
        assertEquals(12, SumEvenNr.suma_pare(3));
    }
}
