package org.example;

public class Homework303_2_1 {

    public static void main(String[] args) {

        // Write a program that declares two integer variables,
        // assigns an integer to each, and
        // adds them together.
        // Assign the sum to a variable.
        // Print out the result.
        int num1 = 10;
        int num2 = 20;

        int sum = num1 + num2;
        System.out.println(sum);

        // Write a program that declares two double variables,
        // assigns a number to each,
        // and adds them together.
        // Assign the sum to a variable.
        // Print out the result.
        double d1 = 111.1d;
        double d2 = 222.2d;

        double dSum = d1 + d2;
        System.out.println(dSum);

        // Write a program that declares an integer variable and a double variable,
        // assigns numbers to each, and adds them together.
        // Assign the sum to a variable.
        // Print out the result.
        // What variable type must the sum be?
        // ^double for the decimal place

        int num3 = 12;
        double d3 = 123.2d;

        double dSum2 = num3 + d3;
        System.out.println(dSum2);

        // Write a program that declares two integer variables,
        // assigns an integer to each, and
        // divides the larger number by the smaller number.
        // Assign the result to a variable.
        // Print out the result.

        int x = 22;
        int y = 44;

        int z = y / x;
        System.out.println(z);

        // Now change the larger number to a decimal.
        // What happens? What corrections are needed?

        int a = 22;
        double b = 44.2;

        double c = b / (double)a;
        System.out.println(c);

        // Write a program that declares two double variables,
        // assigns a number to each, and
        // divides the larger by the smaller number.
        // Assign the result to a variable.
        // Print out the result.

        double d7 = 432.1;
        double d8 = 234.2;

        double d87 = d7 / d8;
        System.out.println(d87);

        // Now, cast the result to an integer.
        // Print out the result again.

        double d5 = 432.1;
        double d6 = 234.2;

        double d56 = d5 / d6;
        int d22 = (int)d56;
        System.out.println(d22);

        //Write a program that declares two integer variables, x and y, and
        // assigns the number 5 to x and the number 6 to y.
        // Declare a variable q and
        // assign y/x to it and print q.
        // Now, cast y to a double and
        // assign it to q. Print q again.

        int g = 5;
        int h = 6;
        var q = (double)h/g;
        System.out.println(q);

        // Write a program that declares a named constant and uses it in a calculation.
        // Print the result.

        final double j = 3.145;
        double k = 4.2;
        double jk = j + k;
        System.out.println(jk);

        // Write a program where you create three variables that represent products at a cafe.
        // The products could be beverages like coffee, cappuccino, espresso, green tea, etc.
        // Assign prices to each product.
        // Create two more variables called subtotal and totalSale and
        // complete an “order” for three items of the first product,
        // four items of the second product, and
        // two items of the third product.
        // Add them all together to calculate the subtotal.
        // Create a constant called SALES_TAX and
        // add sales tax to the subtotal to obtain the totalSale amount.
        // Be sure to format the results to two decimal places.

        double coffee = 4.50;
        double espresso = 2.50;
        double tea = 3.25;
        double subtotal = 3*coffee + 4*espresso + 2*tea;
        final double SALES_TAX = .10;
        double orderTax = subtotal*SALES_TAX;
        double totalSale = orderTax + subtotal;
        System.out.println(totalSale);




    }
}
