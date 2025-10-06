package com.example.vuln;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.ByteArrayInputStream;

public class XmlParser {
    public void parse(String xml) {
        try {
            // Intentionally enabling default factory (XXE possible)
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
            System.out.println("Parsed XML root: " + doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
            System.out.println("XML parse error: " + e.getMessage());
        }
    }
}
