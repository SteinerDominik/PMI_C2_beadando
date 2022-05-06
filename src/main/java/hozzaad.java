import java.util.ArrayList;
import java.util.Scanner;

public class hozzaad {
    private static final Scanner scanner = new Scanner(System.in);
    public static void hozzaadas(ArrayList<tarsasjatek> tarsasjatekok){
        tarsasjatekok.add(new tarsasjatek(beSzabszam(tarsasjatekok), beNev(), beRaktar()));
    }
    public static int beSzabszam(ArrayList<tarsasjatek> tarsasjatekok){
        int szabszam = -1;
        while (szabszam < 10000000 || szabszam > 99999999 && tarsasjatekok.contains(szabszam)) {
            System.out.print("Kerem az aru szabvanyszamat: ");
            try {
                szabszam = scanner.nextInt();
                if (tarsasjatekok.contains(szabszam)){
                    System.out.println("A megadott szabvanyszam már létezik a listában.");
                }
                if (szabszam < 10000000 || szabszam > 99999999) {
                    System.out.println("A szabvanyszam egy egesz 8 jegyu szamnak kell lennie.");
                }
            } catch (Exception e) {
                System.out.println("A szabvanyszam egy egesz 8 jegyu szamnak kell lennie.");
            }
            scanner.nextLine();
        }
        return szabszam;
    }
    public static String beNev(){
        System.out.print("Kerem az uj aru nevet: ");
        return scanner.nextLine();
    }
    public static int beRaktar(){
        int raktar = -1;
        while (raktar < 0) {
            System.out.print("Kerem az raktarban tarolt mennyiseget: ");
            try {
                raktar = scanner.nextInt();
                if (raktar < 0) {
                    System.out.println("A raktar mennyisegenek szama egy pozitiv egesz szamnak kell lennie.");
                }
            } catch (Exception e) {
                System.out.println("A raktar mennyisegenek szama egy pozitiv egesz szamnak kell lennie.");
            }
            scanner.nextLine();
        }
        return raktar;
    }
}
