package org.example.SBA2Q2;

import java.text.DecimalFormat;

public class Football implements Sport {

    private int[] playerIds;

    public Football() {
        playerIds = new int[12];

        for (int pos = 1; pos < playerIds.length; pos++) {
            playerIds[pos] = 1;
        }

        System.out.println("A new football team has been formed");

    }


    @Override
    public void calculateAvgAge(int[] age) {

        double sum = 0;
        for (int a : age) {
            sum += a;
        }

        double avgAge = sum / age.length;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("The average age of the team is " + df.format(avgAge));

    }

    @Override
    public void retirePlayer(int id) {

        if (playerIds[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            playerIds[id] = -1;
            System.out.println("Player with id: " + id + " has retired");
        }

    }

    public void playerTransfer(int fee, int id) {

        if (playerIds[id] == -1) {
            System.out.println("Player has already retired");
        } else {
            playerIds[id] = -1;
            System.out.println("Player with id: " + id + " has been transferred with a fee of " + fee);
        }


    }


    // ================================================
    public static void main(String[] args) {
        Football f = new Football();

        int[] ages = {1, 2};
        f.calculateAvgAge(ages);

        f.retirePlayer(3);
        f .retirePlayer(3);

        f.playerTransfer(500, 2);

    }
}

