import java.util.ArrayList;
import java.util.Scanner;

public class torles {
    private static final Scanner scanner = new Scanner(System.in);
    public static void torles(ArrayList<tarsasjatek> tarsasjateks) {
        System.out.print("Kerem a szabvanyszamot, amely torlesre kerul: ");
        try {
            tarsasjateks.remove(valtoztatas.kereso(tarsasjateks, scanner.nextInt()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
