import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XmlRelated {
    public static ArrayList<tarsasjatek> readTarsasjatekokFromXml(String filepath) {
        ArrayList<tarsasjatek> tarsasjateks = new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filepath);
            Element rootElement = document.getDocumentElement();
            NodeList childNodeList = rootElement.getChildNodes();
            Node node;
            for (int i = 0; i < childNodeList.getLength(); i++) {
                node = childNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childNodesOfUserTag = node.getChildNodes();
                    String szabszam = "", nev = "", raktar = "";
                    for (int j = 0; j < childNodesOfUserTag.getLength(); j++) {
                        Node childNodeOfUserTag = childNodesOfUserTag.item(j);
                        if (childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE) {
                            switch (childNodeOfUserTag.getNodeName()) {
                                case "szabszam" -> szabszam = childNodeOfUserTag.getTextContent();
                                case "nev" -> nev = childNodeOfUserTag.getTextContent();
                                case "raktar" -> raktar = childNodeOfUserTag.getTextContent();
                            }
                        }
                    }
                    tarsasjateks.add(new tarsasjatek(Integer.parseInt(szabszam), nev, Integer.parseInt(raktar)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tarsasjateks;
    }
    public static void saveTarsasjatekokToXml(ArrayList<tarsasjatek> tarsasjateks, String filepath) {
        try {
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("tarsasjatekok");
            document.appendChild(rootElement);

            for (tarsasjatek tarsasjatek : tarsasjateks) {
                Element userElement = document.createElement("tarsasjatek");
                rootElement.appendChild(userElement);
                createChildElement(document, userElement, "szabszam", String.valueOf(tarsasjatek.getSzabszam()));
                createChildElement(document, userElement, "nev", tarsasjatek.getNev());
                createChildElement(document, userElement, "raktar", String.valueOf(tarsasjatek.getRaktar()));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(filepath));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createChildElement(Document document, Element parent,
                                           String tagName, String text) {
        Element element = document.createElement(tagName);
        element.setTextContent(text);
        parent.appendChild(element);
    }
}
