package com.java.katas;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    public String print(Invoice invoice, Map<String, Play> plays) {
        StringBuilder result = new StringBuilder(String.format("Statement for %s\n", invoice.customer));

        int totalAmount = 0;
        int volumeCredits = 0;
        int thisAmount;
        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);
            thisAmount = perf.getAmount(play.type);
            volumeCredits += perf.getVolumeCredits(play.type);

            result.append(String.format("  %s: %s (%s seats)\n", play.name, getFormattedAmount(thisAmount), perf.audience));
            totalAmount += thisAmount;
        }
        result.append(String.format("Amount owed is %s\n", getFormattedAmount(totalAmount)));
        result.append(String.format("You earned %s credits\n", volumeCredits));
        return result.toString();
    }

    private String getFormattedAmount(int totalAmount) {
        return formatter.format(totalAmount / 100);
    }

}