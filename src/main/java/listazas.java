import java.util.ArrayList;
public class listazas {
    public static void listazas(ArrayList<tarsasjatek> tarsasjatekok){
        for (tarsasjatek tarsasjatek : tarsasjatekok){
            System.out.println("Szabvanyszam: " + tarsasjatek.getSzabszam() +
                    " Nev: " + tarsasjatek.getNev() +
                    " Raktarban tarolt mennyiseg: " + tarsasjatek.getRaktar());
        }
    }
}
