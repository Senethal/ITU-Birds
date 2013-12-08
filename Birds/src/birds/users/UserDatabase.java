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

        Element Out = doc.createElement("Vysledek");
        Out.appendChild(doc.createTextNode("Nic"));
        user.appendChild(Out);                  
        
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
    
    public static void AddOut(int proc, String Name) throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException, TransformerException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml")); 
        
        
        NodeList nList = doc.getElementsByTagName("User");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;          
            
                if (Name == null ? eElement.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement.getElementsByTagName("Jmeno").item(0).getTextContent())) {
                    Element Out = (Element) eElement.getElementsByTagName("Vysledek").item(0);
                    eElement.removeChild(Out);
                        
                    Element vystup = doc.createElement("Vysledek");
                    vystup.appendChild(doc.createTextNode(Integer.toString(proc)));
                    eElement.appendChild(vystup);                            
                }
                    
            }     
        }       
   
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("examples//databaze.xml"));
        transformer.transform(source, result);      
    } 
    
    
    public static int AddTest(int proc, String Name) throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException, TransformerException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        int max = 0;
        int celkem = 0;
        
        
        
         NodeList nUser = doc.getElementsByTagName("User");
        
        for (int temp2 = 0; temp2 < nUser.getLength(); temp2++) {
            Node nNode2 = nUser.item(temp2);
            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement2 = (Element) nNode2;          
            
                if (Name == null ? eElement2.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement2.getElementsByTagName("Jmeno").item(0).getTextContent())) {
                    celkem = proc;        
                    NodeList nList = doc.getElementsByTagName("Testik");

                    if (nList != null ) {
                        max = Integer.parseInt(eElement2.getElementsByTagName("Maximum").item(0).getTextContent());
            
                        Element Delete = (Element) eElement2.getElementsByTagName("Maximum").item(0);
                        eElement2.removeChild(Delete);
                 
                        for (int temp = 0; temp < nList.getLength(); temp++) {
                             Node nNode = nList.item(temp);
                             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                
                                Element element = (Element) nNode;
                                celkem += Integer.parseInt(element.getTextContent());
                                if (Integer.toString(max).equals(element.getAttribute("Test"))) {
                                    max++;
                                    celkem = (celkem)/(max+1); 
                       
                                }   
                             }            
                        }        
                    }

                    Element Max = doc.createElement("Maximum");
                    Max.appendChild(doc.createTextNode(Integer.toString(max)));
                    eElement2.appendChild(Max); 
                        
                    Element pom = doc.createElement("Testik");
                    pom.appendChild(doc.createTextNode(Integer.toString(proc)));
                    pom.setAttribute("Test", Integer.toString(max));
                    eElement2.appendChild(pom);                  
                }
                    
            }       

        }
    
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("examples//databaze.xml"));
        transformer.transform(source, result); 
        
        return celkem;
    }
   
}
