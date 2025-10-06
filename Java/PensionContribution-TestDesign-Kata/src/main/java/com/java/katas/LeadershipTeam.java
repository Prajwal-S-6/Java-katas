package com.java.katas;

class LeadershipTeam implements SeniorityLevel {
    @Override
    public double getPensionContributionBonus(SalaryContributionPercentages databaseAccess) {
        // BUG - fixed: Should be LEADERSHIP_TEAM_PERCENTAGE
        return databaseAccess.lookupValue(SalaryContributionPercentages.LEADERSHIP_TEAM_PERCENTAGE);
    }
}