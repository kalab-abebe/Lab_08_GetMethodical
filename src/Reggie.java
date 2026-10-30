import java.util.Scanner;

public class Reggie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String ssn = SafeInput.getRegExString(in, "Enter your SSN (format: XXX-XX-XXXX)", "^\\d{3}-\\d{2}-\\d{4}$");
        String mNum = SafeInput.getRegExString(in, "Enter your UC Student M number (format: MXXXXX)", "^(M|m)\\d{5}$");
        String menuChoice = SafeInput.getRegExString(in, "Enter menu choice [O/S/V/Q]", "^[OoSsVvQq]$");

        System.out.println("\nSSN entered: " + ssn);
        System.out.println("M Number entered: " + mNum);
        System.out.println("Menu Choice entered: " + menuChoice);
    }
}