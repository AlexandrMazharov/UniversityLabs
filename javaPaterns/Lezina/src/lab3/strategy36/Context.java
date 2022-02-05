package lab3.strategy36;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

public class Context {
    public Context() {
    }

    private Strategy strategy;

    public  void setStrategy(Strategy strategy) {
       this.strategy = strategy;
    }

    public  void correct(String oldFile, String newFile) throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
        strategy.correct(oldFile, newFile);
    }

}
