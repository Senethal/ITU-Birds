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
    
    public int less_index = 1;
    public int bird_index = 1;
    
    
    public void Lessons() {
        this.less_index = 1;
        this.bird_index = 1;     
    }
    
    public String GetNameBird() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("name").item(0).getTextContent();  
    }
    
    public String GetLatNameBird() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idl="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("latname").item(0).getTextContent();      
    }
    
    public String GetTrida() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("trida").item(0).getTextContent(); 
    }
    
    public String GetPodtrida() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("podtrida").item(0).getTextContent();    
    }
    
    public String GetRad() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("rad").item(0).getTextContent();      
    }
    
    public String GetCeled() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("celed").item(0).getTextContent();    
    }
    
    public String GetRod() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("rod").item(0).getTextContent();   
    }
    
    public String GetPopis() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("popis").item(0).getTextContent();    
    }
    
    public String GetImage() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("image").item(0).getTextContent();
    }

    public void TakeLess(int i) {
        this.less_index = i;
    }
    
    public void TakeBird(int i) {
        this.bird_index = i;
    }
    
    public void NextLess() {
        this.less_index++; 
    }
    
    public void PreviousLess() {
        if ( this.less_index > 0 )
            this.less_index--;
    }
    
    public void NextBird() {
        this.bird_index++;
    }
    
    public void PreviousBird() {
        if ( this.bird_index > 0 )
            this.bird_index--;
    }
}
