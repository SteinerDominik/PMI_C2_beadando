import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        String filepath = "src/main/resources/Tarsasjatekok.xml";
        ArrayList<tarsasjatek> tarsasjatekok = XmlRelated.readTarsasjatekokFromXml(filepath);
        menu.menupont(tarsasjatekok);
        XmlRelated.saveTarsasjatekokToXml(tarsasjatekok, filepath);
    }
}