package com.java.katas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Executable;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

// TODO: Rename this class to something more appropriate and write some tests here
public class PensionContributionCalculatorTest {


    @ParameterizedTest
    @ValueSource(longs = {0, -1000})
    void shouldThrowIllegalArgumentExceptionWhenSalaryIsLessThanZero(long salary) {
        assertThrows(IllegalArgumentException.class,
                () -> PensionContributionCalculator.calculatePensionContribution(BigDecimal.valueOf(salary), 5, new MidLevel(), FakePercentages.getStandardValues()));
    }

    @Test
    void shouldGetMediumTenureBonusWhenTenureIsMoreThanFiveYearsAndLessThan15Years() {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(1000),
                10,
                new MidLevel(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(100.0), finalSalary);
    }

    @Test
    void shouldGetLongTenureBonusWhenTenureIsFifteenYearsOrMore() {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(1000),
                15,
                new MidLevel(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(115.0), finalSalary);
    }

    @Test
    void shouldNotGetTenureBonusWhenTenureIsLessThanFiveYears() {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(1000),
                4,
                new MidLevel(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(80.0), finalSalary);
    }

    @ParameterizedTest
    @CsvSource(value = {"15,110.0", "10,95.0", "4,75.0"})
    void shouldGetCorrectPercentOfPensionContributionForLeaderShipTeamWithLongTenure(int tenure, double expectedSalary) {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(1000),
                tenure,
                new LeadershipTeam(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(expectedSalary), finalSalary);
    }



}