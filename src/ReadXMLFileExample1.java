import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFileExample1
{
    public static void main(String[] argv)
    {
        class Runner {
            public Runner(String webId, Integer raceNo, String category, String fName, String sName, String name) {
            }
        }
        try
        {
//creating a constructor of file class and parsing an XML file
            File file = new File("C:/Temp/Runners.xml");
//an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Runner");
// nodeList is not iterable, so we are using for loop
            List<Runner> runners =  new ArrayList<>();

            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
//                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
//                    System.out.println("Website ID: "+ eElement.getElementsByTagName("website_id").item(0).getTextContent());
                    String webId = eElement.getElementsByTagName("website_id").item(0).getTextContent();
//                    System.out.println("Race Number: "+ eElement.getElementsByTagName("race_number").item(0).getTextContent());
                    Integer raceNo = Integer.valueOf(eElement.getElementsByTagName("race_number").item(0).getTextContent());
//                    System.out.println("Category: "+ eElement.getElementsByTagName("category").item(0).getTextContent());
                    String category = eElement.getElementsByTagName("category").item(0).getTextContent();
//                    System.out.println("First Name: "+ eElement.getElementsByTagName("first_name").item(0).getTextContent());
                    String fName = eElement.getElementsByTagName("first_name").item(0).getTextContent();
//                    System.out.println("Last Name: "+ eElement.getElementsByTagName("SNAME").item(0).getTextContent());
                    String sName = eElement.getElementsByTagName("SNAME").item(0).getTextContent();
//                    System.out.println("Name: "+ eElement.getElementsByTagName("NAME").item(0).getTextContent());
                    String name = eElement.getElementsByTagName("NAME").item(0).getTextContent();
                    runners.add(new Runner(webId, raceNo, category, fName, sName, name));
//                    System.out.println("\nNode Name :" + runners.toArray().length);
                    Integer r_aceno = 666;
                    if (r_aceno.equals(raceNo)) {
                        System.out.println("Name: "+name);
                        System.out.println("webId: "+webId);
                        System.out.println("fName: "+fName);
                        System.out.println("sName: "+sName);
                        System.out.println("raceNo: "+raceNo);
//                        System.out.println(runnerObj.get("surname"));
//                        System.out.println(runnerObj.get("firstname"));
//                        System.out.println(runnerObj.get("webId"));
                    }
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
//        runners.stream().filter(beach -> "Dor".equals(runner.getName()));

    }
}