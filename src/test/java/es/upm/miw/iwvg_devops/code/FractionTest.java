package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void before() {
        this.fraction = new Fraction(2, 4);
    }

    @Test
    void testFractionWithoutParams() {
        this.fraction = new Fraction();
        assertEquals(1, this.fraction.getNumerator());
        assertEquals(1, this.fraction.getDenominator());
    }

    @Test
    void testFractionWithParams() {
        assertEquals(2, this.fraction.getNumerator());
        assertEquals(4, this.fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, this.fraction.decimal());
    }

    @Test
    void testIsProper() {
        assertTrue(this.fraction.isProper());
    }

    @Test
    void testIsImproper() {
        assertFalse(this.fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction otherFraction = new Fraction(1, 2);
        assertTrue(this.fraction.isEquivalent(otherFraction));
    }

    @Test
    void testAdd() {
        Fraction otherFraction = new Fraction(5, 3);
        assertEquals(13, this.fraction.add(otherFraction).getNumerator());
        assertEquals(6, this.fraction.add(otherFraction).getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction otherFraction = new Fraction(5, 3);
        assertEquals(5, this.fraction.multiply(otherFraction).getNumerator());
        assertEquals(6, this.fraction.multiply(otherFraction).getDenominator());
    }

    @Test
    void testDivide() {
        Fraction otherFraction = new Fraction(5, 3);
        assertEquals(3, this.fraction.divide(otherFraction).getNumerator());
        assertEquals(10, this.fraction.divide(otherFraction).getDenominator());
    }
}
