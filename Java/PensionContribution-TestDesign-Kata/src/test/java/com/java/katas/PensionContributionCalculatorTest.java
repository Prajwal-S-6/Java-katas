package com.java.katas;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

// TODO: Rename this class to something more appropriate and write some tests here
public class PensionContributionCalculatorTest {

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSalaryIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> PensionContributionCalculator.calculatePensionContribution(BigDecimal.ZERO, 5, new MidLevel(), FakePercentages.getStandardValues()));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSalaryIsLessThanZero() {
        assertThrows(IllegalArgumentException.class,
                () -> PensionContributionCalculator.calculatePensionContribution(BigDecimal.valueOf(-300), 5, new MidLevel(), FakePercentages.getStandardValues()));
    }

    @Test
    void shouldGetMediumTenureBonusWhenTenureIsMoreThanFiveYearsAndLessThan15Years() {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(100),
                10,
                new MidLevel(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(100.0), finalSalary);
    }



}