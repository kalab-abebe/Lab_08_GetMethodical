import java.util.Scanner;

public class SafeInput {

    /**
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Prompts the user to input any integer. Bullet-proofed against non-integer inputs.
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear newline
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. You entered: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Prompts the user to input any double value. Bullet-proofed against non-double inputs.
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0.0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear newline
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double. You entered: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Prompts the user to input an integer within a specified inclusive range.
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear newline
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range [" + low + " - " + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer. You entered: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Prompts the user to input a double value within a specified inclusive range.
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0.0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear newline
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Value is out of range [" + low + " - " + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double. You entered: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Gets a Yes or No confirmation [Y/N] returning true for yes and false for no.
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean retVal = false;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter [Y/N]. You entered: " + response);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Prompts the user to input a String that matches a specified RegEx pattern.
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                done = true;
            } else {
                System.out.println("Invalid input. Please match the pattern: " + regEx);
            }
        } while (!done);
        return response;
    }

    /**
     * Creates a pretty header of 60 characters wide with a centered message.
     */
    public static void prettyHeader(String msg) {
        int totalWidth = 60;

        // Print top row of 60 asterisks
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Calculate centering for middle row (3 stars on each end = 6 chars, leaving 54 chars)
        int msgLength = msg.length();
        int totalPadding = totalWidth - 6 - msgLength;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        System.out.print("***");
        for (int i = 0; i < leftPadding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightPadding; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print bottom row of 60 asterisks
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}