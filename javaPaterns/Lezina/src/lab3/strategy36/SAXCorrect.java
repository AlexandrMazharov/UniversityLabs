package lab3.strategy36;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.IOException;

public class SAXCorrect extends DefaultHandler implements Parser, Strategy {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    private Student student = new Student();


    private StringBuilder data = null;

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            student.setName(atts.getValue("lastname"));

        } else if (qName.equalsIgnoreCase("subject")) {
            title = atts.getValue("title");
            mark = atts.getValue("mark");

            bsubj = true;
        } else if (qName.equalsIgnoreCase("average")) {
            //  average= Double.valueOf(atts.getValue("title"));
            baverage = true;
        }
        data = new StringBuilder();

    }

    String title;
    String mark;

    private boolean bsubj = false;
    private boolean baverage = false;

    private Double summ = 0.0;
    private int count = 0;

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (bsubj) {

            student.addCource(title, Double.parseDouble(mark));
            summ = summ + Double.valueOf(mark);
            count++;
            bsubj = false;
        } else if (baverage) {
            readAverage = Double.parseDouble(String.valueOf(data));
            student.setAverage(readAverage);


        }

    }

    private double readAverage;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));

    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
        System.out.println("read" + readAverage);

        double realAverage = summ / count;
        System.out.println("real" + realAverage);
        if (realAverage != readAverage) {
            student.setAverage(realAverage);
            System.out.println("Stop parse XML...");
            try {
                DomCorrect.writeDataXML(student, newFile);
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            }

        }
    }

    private static  String newFile;
    @Override
    public void correct(String oldFile, String newFile) throws ParserConfigurationException, IOException, SAXException {
        this.newFile = newFile;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = saxParserFactory.newSAXParser();
        SAXCorrect handler = new SAXCorrect();

        saxParser.parse(new File(oldFile), handler);


    }
}
