package lab3.strategy36;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

public interface Strategy {

    void correct(String oldFile, String newFile) throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException;
}
