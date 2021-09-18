package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void before() {
        this.fraction = new Fraction(2,4);
    }

    @Test
    void testFractionWithoutParams(){
        this.fraction = new Fraction();
        assertEquals(1, this.fraction.getNumerator());
        assertEquals(1, this.fraction.getDenominator());
    }

    @Test
    void testFractionWithParams(){
        assertEquals(2, this.fraction.getNumerator());
        assertEquals(4, this.fraction.getDenominator());
    }

    @Test
    void testDecimal(){
        assertEquals(0.5, this.fraction.decimal());
    }
}
