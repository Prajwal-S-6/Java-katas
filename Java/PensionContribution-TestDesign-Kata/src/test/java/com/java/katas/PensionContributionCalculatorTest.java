package com.java.katas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PensionContributionCalculatorTest {

    @ParameterizedTest
    @ValueSource(doubles = {0, -1000})
    void shouldThrowIllegalArgumentExceptionWhenSalaryIsLessThanZero(double salary) {

        assertThrows(IllegalArgumentException.class,
                () -> PensionContributionCalculator.calculatePensionContribution(BigDecimal.valueOf(salary), 5, new MidLevel(), FakePercentages.getStandardValues()));
    }

    @ParameterizedTest
    @CsvSource(value = {"1111.25 : 55.563", "1111.3 : 55.57", "1111.93 : 55.597"}, delimiter = ':', ignoreLeadingAndTrailingWhitespace = true)
    void shouldProvidePensionContributionWithHalfRounded(double salary, double expectedContribution) {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(salary),
                2,
                new JuniorEmployee(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(expectedContribution), finalSalary);
    }

    @Test
    void shouldGetMediumTenureBonusWhenTenureIsMoreThanFiveYearsAndLessThan15Years() {
        PensionContributionCalculator pensionContributionCalculator = new PensionContributionCalculator(new DataBaseAccessStub());
        BigDecimal finalSalary = pensionContributionCalculator.calculatePensionContribution(2);

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
    @CsvSource(value = {"15,110.0","14,95.0", "5,95.0", "4,75.0"})
    void shouldGetCorrectPercentOfPensionContributionForLeaderShipTeamWithVariousTenure(int tenure, double expectedContribution) {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(1000),
                tenure,
                new LeadershipTeam(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(expectedContribution), finalSalary);
    }

    @ParameterizedTest
    @CsvSource(value = {"15,85.0", "14,70.0", "5,70.0", "4,50.0"})
    void shouldGetCorrectPercentOfPensionContributionForJuniorTeamWithVariousTenure(int tenure, double expectedContribution) {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(1000),
                tenure,
                new JuniorEmployee(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(expectedContribution), finalSalary);
    }

    @ParameterizedTest
    @CsvSource(value = {"15:115.0","14:100.0", "5:100.0", "4:80.0"}, delimiter = ':')
    void shouldGetCorrectPercentOfPensionContributionForMidLevelTeamWithVariousTenure(int tenure, double expectedContribution) {
        BigDecimal finalSalary = PensionContributionCalculator.calculatePensionContribution(
                BigDecimal.valueOf(1000),
                tenure,
                new MidLevel(),
                FakePercentages.getStandardValues()
        );

        assertEquals(BigDecimal.valueOf(expectedContribution), finalSalary);
    }


    class DataBaseAccessStub implements DatabaseAccess {

        @Override
        public Employee getEmployeeById(int employeeId) {
            return new Employee(BigDecimal.valueOf(1000), 10, new MidLevel());
        }

        @Override
        public double lookupValue(String namedConstant) {
            return FakePercentages.getStandardValues().lookupValue(namedConstant);
        }
    }
}

