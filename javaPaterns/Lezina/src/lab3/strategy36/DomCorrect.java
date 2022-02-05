package lab3.strategy36;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DomCorrect implements Parser , Strategy {
    private Document document;
    private StringBuilder stringBuilder;
    private static Student student = new Student();//


    @Override
    public void correct(String oldFile, String newFile) throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(new File(oldFile));
        org.w3c.dom.Element root = document.getDocumentElement();


        Double readAverage = Double.valueOf(root.getElementsByTagName("average").item(0).getTextContent());
        //String readAverage = String.valueOf(root.getElementsByTagName("average").item(0).getTextContent());

        NodeList elements = document.getDocumentElement().getElementsByTagName("subject");
        int count = elements.getLength();

        Student readStudent = new Student();
        readStudent.setName(root.getAttribute("lastname"));
        readStudent.setAverage(readAverage);
        Double summ = 0.0;

        for (int i = 0; i < count; i++) {
            Node e = elements.item(i);
            NamedNodeMap atributes = e.getAttributes();
            String mark = atributes.getNamedItem("mark").getNodeValue();
            String title = atributes.getNamedItem("title").getNodeValue();
            readStudent.addCource(title, Double.parseDouble(mark));
            summ = summ + Double.valueOf(mark);
        }
        double realAverage = summ / count;
        System.out.println("read Average:" + readAverage);
        System.out.println("realAverage:" + realAverage);
        if (readAverage != realAverage) {
            System.out.println("read != real");
            readStudent.setAverage(realAverage);
            writeDataXML(readStudent, newFile);
        } else {
            System.out.println("realAverage==readAverage");
        }
    }

    public static void writeDataXML(Student student, String newFilee) throws TransformerConfigurationException {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        Document doc = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.newDocument();

            Element e_root = doc.createElement("student");
            String name = student.getName();
            e_root.setAttribute("lastname", name);
            doc.appendChild(e_root);
            for (int i = 0; i < student.getCources().size(); i++) {
                Element e_users = doc.createElement("subject");
                e_users.setAttribute("title", student.getCourseName(i));
                e_users.setAttribute("mark", String.valueOf(student.getCourseRes(i)));
                e_root.appendChild(e_users);
            }
            Element average = doc.createElement("average");
            average.setTextContent(String.valueOf(student.getAverage()));
            e_root.appendChild(average);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            // Сохраняем Document в XML-файл
            if (doc != null)
                writeDocument(doc, newFilee);
        }
    }

    public static void writeDocument(Document document, String pathh)
            throws TransformerFactoryConfigurationError, TransformerConfigurationException {
        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance()
                    .newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(pathh);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }


}
