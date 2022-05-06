import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    private static final Scanner scanner = new Scanner(System.in);
    public static void menupont(ArrayList<tarsasjatek> tarsasjateks){
        int choice = -1;
        while (choice != 0) {
            System.out.println("1 - Listazas\r\n2 - Hozzaadas\r\n3 - Valtoztatas\r\n" +
                    "4 - Torles\r\n0 - Kilepes");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Nem megfelelo opcio.");
            }
            scanner.nextLine();
            switch (choice) {
                case 1 -> listazas.listazas(tarsasjateks);
                case 2 -> hozzaad.hozzaadas(tarsasjateks);
                case 3 -> valtoztatas.valtoztatas(tarsasjateks);
                case 4 -> torles.torles(tarsasjateks);
            }
        }
    }
}
