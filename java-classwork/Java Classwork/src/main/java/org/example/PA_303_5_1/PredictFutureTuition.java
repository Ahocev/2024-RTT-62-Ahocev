package org.example.PA_303_5_1;

public class PredictFutureTuition {

    public static void main(String[] args) {

        // Suppose the tuition for a university is $10,000 for the current year and increases by 7 percent every year.
        // In how many years will the tuition be doubled?
        double tuition = 10000;
        final double END = 20000;
        int years = 0;

        for (; tuition < END; years++) {
            tuition *= 1.07;
        }
        System.out.println(years);
    }
}
