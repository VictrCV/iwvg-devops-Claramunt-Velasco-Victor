package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    private User user;

    @BeforeEach
    void before() {
        List<Fraction> list = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions = new ArrayList<>(list);
        this.user = new User("1", "Ada", "Lovelace", fractions);
    }

    @Test
    void testUserWithoutParams() {
        this.user = new User();
        assertNull(this.user.getId());
        assertNull(this.user.getName());
        assertNull(this.user.getFamilyName());
        assertEquals(new ArrayList<>(), this.user.getFractions());
    }

    @Test
    void testUserWithParams() {
        assertEquals("1", this.user.getId());
        assertEquals("Ada", this.user.getName());
        assertEquals("Lovelace", this.user.getFamilyName());
        assertEquals(3, this.user.getFractions().size());
    }

    @Test
    void testAddFraction() {
        this.user.addFraction(new Fraction());
        assertEquals(4, this.user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("Ada Lovelace", this.user.fullName());
    }

    @Test
    void testNameInitial() {
        assertEquals("A.", this.user.nameInitial());
    }

    @Test
    void testFamilyNameInitial() {
        assertEquals("L.", this.user.familyNameInitial());
    }
}
