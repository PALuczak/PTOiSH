package pl.p.lodz.dmcs.ptoish;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Exercise6 {
    static String FILE = "pom.xml";

    public Exercise6(final String file) throws SAXException, IOException, ParserConfigurationException {
        final DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        final DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
        final Document doc = docBuilder.parse(new FileInputStream(file));
        final List<String> l = new ArrayList<String>();
        parse(doc, l, doc.getDocumentElement());
        System.out.println(l);
    }

    private void parse(final Document doc, final List<String> list, final Element e) {
        System.out.println(e.getTagName());
        final NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            final Node n = children.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                list.add(n.getNodeName());
                parse(doc, list, (Element) n);
            }
        }
    }

    public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException {
        new Exercise6(FILE);
        System.exit(0);
    }
}
