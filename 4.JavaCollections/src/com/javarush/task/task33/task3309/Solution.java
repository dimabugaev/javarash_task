package com.javarush.task.task33.task3309;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, TransformerException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        //StringWriter writer = new StringWriter();
        //XMLStreamWriter writer = new IndentingXMLStreamWriter();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, document);

        //Node root = document.getDocumentElement();
        NodeList nodeList = document.getElementsByTagName(tagName);

//        if (nodeList.getLength() == 0)
//        {
//            StringWriter writer = new StringWriter();
//            marshaller.marshal(obj, writer);
//            return writer.toString();
//        }

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (tagName.equals(node.getNodeName())){
                node.getParentNode().insertBefore(document.createComment(comment), node);
                //node.getParentNode().insertBefore(document.createTextNode("\n"), node);

                //Node firstChild = node.getFirstChild();
//                boolean s= firstChild.getTextContent().matches(".*[<>&'\"].*");
//                if (node.getFirstChild().equals(Node.TEXT_NODE)&&s)
//                {
//                    //node.replaceChild(cdataSection, firstChild);
//                    if (node.getNodeName().equals(tagName)) {
//                        Comment com = document.createComment(comment);
//                        node.getParentNode().insertBefore(com, node);
//                    }
//                    replaceTextWithCDATA(node, document);
//                }
            }
        }

        StringWriter sw = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        transformer.transform(new DOMSource(document), new StreamResult(sw));

        String result = sw.toString();

//        result = result.replaceAll("&amp;", "&");
//        result = result.replaceAll("&quot;", "\"");
//        result = result.replaceAll("&lt;", "<");
//        result = result.replaceAll("&gt;", ">");
//        result = result.replaceAll("&apos;", "'");

        return result;
    }

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, TransformerException {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }

    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }
}
