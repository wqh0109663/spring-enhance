package top.shownmmp.spring.enhance.project.java.base.knowledge.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2018-12-24 17:21
 */
public class XmlParser {
    public static void main(String[] args) throws Exception {
        try {
            String path = "src/main/java/top/shownmmp/spring/enhance/project/java/base/knowledge/xml/bean.xml";
            System.out.println(path);
            File file = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList list = doc.getElementsByTagName("bean");
            System.out.println("----------------------------");

            for (int i = 0; i < list.getLength(); i++) {
                Node nNode = list.item(i);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("id--"+eElement.getAttribute("id"));

                    System.out.println("class--"+eElement.getAttribute("class"));
                    NodeList property = eElement.getElementsByTagName("property");
                    for(int j = 0 ; j < property.getLength();j++){
                        Node item = property.item(j);
                        String nodeName = item.getNodeName();
                        System.out.println("nodeName:"+nodeName);
                        short nodeType = item.getNodeType();
                        System.out.println("nodeType--"+nodeType);
                        if (nodeType==Node.ELEMENT_NODE){
                            Element name = (Element) item;
                            System.out.println(" property name:---"+name.getAttribute("name"));
                            System.out.println("property value:---"+name.getAttribute("value"));

                        }
                    }
                    System.out.println("****");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
