import java.util.ArrayList;
import java.util.Scanner;

public class valtoztatas {
    private static final Scanner scanner = new Scanner(System.in);
    public static void valtoztatas(ArrayList<tarsasjatek> tarsasjateks) {
        System.out.print("Kerem a valtoztatni valo aru szabvanyszamat: ");
        try {
            tarsasjatek tarsasjatek = kereso(tarsasjateks, scanner.nextInt());
            tarsasjateks.set(tarsasjateks.indexOf(tarsasjatek), new tarsasjatek(tarsasjatek.getSzabszam(),
                    hozzaad.beNev(), hozzaad.beRaktar()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public static tarsasjatek kereso(ArrayList<tarsasjatek> tarsasjateks, int szabszam) throws IllegalArgumentException {
        for (tarsasjatek tarsasjatek : tarsasjateks) {
            if (tarsasjatek.getSzabszam() == szabszam) {
                return tarsasjatek;
            }
        }
        throw new IllegalArgumentException("Nem letezo szabvanyszam: " + szabszam);
    }
}
