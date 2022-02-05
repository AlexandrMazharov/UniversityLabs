package lab3.strategy36;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerConfigurationException {
        //передать как пареметры команднйо строки
        String oldFile;//= "C:\\Users\\Alexander\\Desktop\\testTask\\Lezina\\src\\lab3\\strategy6\\person.xml";
        String newFile;//= "newDomFile.xml";
        String newFileSAX;//= "newSAXFile.xml";

        oldFile = args[0];
        newFile = args[1];
        newFileSAX = args[2];
        //    DomCorrect domCorrect = new DomCorrect();
        //  domCorrect.correct(oldFile,newFile);
        Context context = new Context();
        context.setStrategy(new SAXCorrect());
        context.correct(oldFile, newFileSAX);

        //print employee information


    }
}
