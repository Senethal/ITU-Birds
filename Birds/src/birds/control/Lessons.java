/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package birds.control;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Tom
 */
public class Lessons {
        
    public String GetNameBird(int id_less, int id_bird) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        
        return element.getElementsByTagName("name").item(0).getTextContent();
    }
    
    public String GetLatNameBird(int id_less, int id_bird) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("latname").item(0).getTextContent();      
    }
    
    public String GetTrida(int id_less, int id_bird) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("trida").item(0).getTextContent(); 
    }
    
    public String GetPodtrida(int id_less, int id_bird) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("podtrida").item(0).getTextContent();    
    }
    
    public String GetRad(int id_less, int id_bird) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("rad").item(0).getTextContent();      
    }
    
    public String GetCeled(int id_less, int id_bird) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("celed").item(0).getTextContent();    
    }
    
    public String GetRod(int id_less, int id_bird) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("rod").item(0).getTextContent();   
    }
    
    public String GetPopis(int id_less, int id_bird) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return FormatPop(element.getElementsByTagName("popis").item(0).getTextContent());    
    }
    
    public String FormatPop(String s) {
        
        String text;
        int delka = s.length();
        
        delka = delka/62;
        
        text = "\n" + "     ";
        
        for (int i = 0; i<delka ; i++) {
            text += s.substring(62*i,((62*i)+62));
            text += "\n" + "     ";
        }
        
        return text;
    }
    
    
    public String GetImage(int id_less, int id_bird) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(id_bird)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("image").item(0).getTextContent();
    }

    public int GetCount(int id_less) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(id_less)+"]", document, XPathConstants.NODE);

        return Integer.parseInt(elementroot.getElementsByTagName("count").item(0).getTextContent());
    }
    
}
