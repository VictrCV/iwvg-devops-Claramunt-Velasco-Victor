package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {

    @Test
    void testFindUserFamilyNameBySomeImproperFraction() {
        assertEquals(List.of("Fernandez", "Blanco", "López", "Torres", "Blanco", "Torres"), new Searches().findUserFamilyNameBySomeImproperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        assertEquals(-1, new Searches().findFirstProperFractionByUserId("2").getNumerator());
        assertEquals(5, new Searches().findFirstProperFractionByUserId("2").getDenominator());
    }

    @Test
    void testFindFractionDivisionByUserId(){
        assertEquals(-4, new Searches().findFractionDivisionByUserId("3").getNumerator());
        assertEquals(5, new Searches().findFractionDivisionByUserId("3").getDenominator());
    }

    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction(){
        assertEquals(List.of("F.", "B.", "L.", "B."), new Searches().findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList()));
    }

}
