public class CtoFTableDisplay {

    public static double CtoF(double Celsius) {
        return (Celsius * 9.0 / 5.0) + 32.0;
    }

    public static void main(String[] args) {
        System.out.println("Celsius | Fahrenheit");
        System.out.println("---------------------");
        for (int c = -100; c <= 100; c++) {
            double f = CtoF(c);
            System.out.printf("%7d | %10.2f\n", c, f);
        }
    }
}