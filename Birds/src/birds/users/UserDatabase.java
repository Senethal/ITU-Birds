/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package birds.users;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;




/**
 *
 * @author Tom
 */
public class UserDatabase {
    
    public static void CreateDatabase() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();       
      
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Users"); //root element databazoveho souboru
        doc.appendChild(rootElement);
        
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("examples//databaze.xml"));
        transformer.transform(source, result); 
        
    }
    
    public static void AddUser(String name, String password) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml")); 
        
        Element rootElement = doc.getDocumentElement(); //root element databazoveho souboru
        
        Element user = doc.createElement("User"); //vytvoreni elementu uzivatele
        //user.appendChild(doc.createTextNode(String.valueOf(ID)));
        rootElement.appendChild(user);
        //ID++;
        
        Element Name = doc.createElement("Jmeno");
        Name.appendChild(doc.createTextNode(name));
        user.appendChild(Name);
        
        Element Pass = doc.createElement("Heslo");
        Pass.appendChild(doc.createTextNode(password));
        user.appendChild(Pass);  
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("examples//databaze.xml"));
        transformer.transform(source, result); 
        
    }
    
    public static String Get(String Name) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        
        NodeList nList = doc.getElementsByTagName("User");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;          
            
                if (Name == null ? eElement.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement.getElementsByTagName("Jmeno").item(0).getTextContent()))
                    return eElement.getElementsByTagName("Heslo").item(0).getTextContent(); // zde bude navrat neceho podle najiteho jmena nejspis statistika nejaka
                
            }     
        }       
        return null;
    }
    
    public static Boolean TestName(String Name) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        
        NodeList nList = doc.getElementsByTagName("User");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;          
            
                if (Name == null ? eElement.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement.getElementsByTagName("Jmeno").item(0).getTextContent()))
                    return true; // nalezlo toto prihlasovaci jmeno
            }     
        }       
        return false;   
    }

    public static Boolean TestPass(String Name, String Pass) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        
        NodeList nList = doc.getElementsByTagName("User");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;          
            
                if (Name == null ? eElement.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement.getElementsByTagName("Jmeno").item(0).getTextContent()))
                    if (Pass == null ? eElement.getElementsByTagName("Heslo").item(0).getTextContent() == null : Pass.equals(eElement.getElementsByTagName("Heslo").item(0).getTextContent()))
                        return true; // heslo existuje pro daneho usera                
            }     
        }       
        return false;   
    }
    
}
