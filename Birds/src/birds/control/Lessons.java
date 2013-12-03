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
    
    int less_index = 1;
    int bird_index = 1;
    
    
    public void Lessons() {
        this.less_index = 1;
        this.bird_index = 1;     
    }
    
    private String GetNameBird() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("name").item(0).getTextContent();
        
    }
    
    private String GetLatNameBird() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("latname").item(0).getTextContent();      
    }
    
    private String GetTrida() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("trida").item(0).getTextContent(); 
    }
    
    private String GetPodtrida() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("podtrida").item(0).getTextContent();    
    }
    
    private String GetRad() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("rad").item(0).getTextContent();      
    }
    
    private String GetCeled() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("celed").item(0).getTextContent();    
    }
    
    private String GetRod() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("rod").item(0).getTextContent();   
    }
    
    private String GetPopis() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("popis").item(0).getTextContent();    
    }
    
    private String GetImage() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("examples//lessons.xml"));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        Element elementroot = (Element) xpath.evaluate("//*[@idc="+Integer.toString(this.less_index)+"]", document, XPathConstants.NODE);
        Element element = (Element) xpath.evaluate("//*[@id="+Integer.toString(this.bird_index)+"]", elementroot, XPathConstants.NODE);
        return element.getElementsByTagName("image").item(0).getTextContent();
    }

    private void TakeLess(int i) {
        this.less_index = i;
    }
    
    private void TakeBird(int i) {
        this.bird_index = i;
    }
    
    private void NextLess() {
        this.less_index++; 
    }
    
    private void PreviousLess() {
        if ( this.less_index > 0 )
            this.less_index--;
    }
    
    private void NextBird() {
        this.bird_index++;
    }
    
    private void PreviousBird() {
        if ( this.bird_index > 0 )
            this.bird_index--;
    }
}
