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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

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

        Element Max = doc.createElement("Maximum");
        Max.appendChild(doc.createTextNode("0"));
        user.appendChild(Max);        
        
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
    
    
    public static int AddTest(int proc, String Name, int less, int type) throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException, TransformerException {
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
                    NodeList nList = eElement2.getElementsByTagName("Testik");
                    
                    if (nList != null ) {
                        max = Integer.parseInt(eElement2.getElementsByTagName("Maximum").item(0).getTextContent());
            
                        Element Delete = (Element) eElement2.getElementsByTagName("Maximum").item(0);
                        eElement2.removeChild(Delete);
                 
                        for (int temp = 0; temp < nList.getLength(); temp++) {
                             Node nNode = nList.item(temp);
                             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                
                                Element element = (Element) nNode;
                                celkem += Integer.parseInt(element.getTextContent().substring(1,3));
                                if (Integer.toString(max).equals(element.getTextContent().substring(0,1))) {
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
                    String text;
                    
                    if ( proc == 0 )
                        text = Integer.toString(max) + Integer.toString(proc) + "0" + Integer.toString(less) + Integer.toString(type);
                    else
                        text = Integer.toString(max) + Integer.toString(proc) + Integer.toString(less) + Integer.toString(type);
                    
                    pom.appendChild(doc.createTextNode(text));
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
   
    public static String TypLess(int ID, String Name) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));  
        NodeList nUser = doc.getElementsByTagName("User");
        
        for (int temp2 = 0; temp2 < nUser.getLength(); temp2++) {
            Node nNode2 = nUser.item(temp2);
            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement2 = (Element) nNode2;          
            
                if (Name == null ? eElement2.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement2.getElementsByTagName("Jmeno").item(0).getTextContent())) {
                    NodeList nTest = eElement2.getElementsByTagName("Testik");
                    
                    for (int temp = 0; temp < nTest.getLength(); temp++) {
                        if (Integer.toString(ID).equals(eElement2.getElementsByTagName("Testik").item(temp).getTextContent().substring(0,1))) { 
                            return eElement2.getElementsByTagName("Testik").item(temp).getTextContent().substring(3, 4);
                        }
                    }  
                }
            }
        } 
        return null;
    }
    
    public static String TypTest(int ID, String Name) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        NodeList nUser = doc.getElementsByTagName("User");
        
        for (int temp2 = 0; temp2 < nUser.getLength(); temp2++) {
            Node nNode2 = nUser.item(temp2);
            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement2 = (Element) nNode2;          
            
                if (Name == null ? eElement2.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement2.getElementsByTagName("Jmeno").item(0).getTextContent())) {
                    NodeList nTest = eElement2.getElementsByTagName("Testik");
                    
                    for (int temp = 0; temp < nTest.getLength(); temp++) {
                        Node nNode1 = nUser.item(temp2);
                        if (nNode1.getNodeType() == Node.ELEMENT_NODE) {  
                            Element eElement1 = (Element) nNode1;
                            if (Integer.toString(ID).equals(eElement1.getElementsByTagName("Testik").item(temp).getTextContent().substring(0,1))) { 
                                return eElement1.getElementsByTagName("Testik").item(temp).getTextContent().substring(4, 5);
                             } 
                        }    
                    }
                
                }
            }
        }
        return "0";
    }
    
    public static String GetResult(int ID, String Name) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        NodeList nUser = doc.getElementsByTagName("User");
        
        for (int temp2 = 0; temp2 < nUser.getLength(); temp2++) {
            Node nNode2 = nUser.item(temp2);
            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement2 = (Element) nNode2;          
            
                if (Name == null ? eElement2.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement2.getElementsByTagName("Jmeno").item(0).getTextContent())) {
                    NodeList nTest = eElement2.getElementsByTagName("Testik");
                    
                    for (int temp = 0; temp < nTest.getLength(); temp++) {
                        Node nNode1 = nUser.item(temp2);
                        if (nNode1.getNodeType() == Node.ELEMENT_NODE) {  
                            if (Integer.toString(ID).equals(eElement2.getElementsByTagName("Testik").item(temp).getTextContent().substring(0,1))) { 
                                return eElement2.getElementsByTagName("Testik").item(temp).getTextContent().substring(1, 3);
                             } 
                        }    
                    }
                
                }
            }
        }
        return "0";
    }  
    
    public static int GetMax(String Name) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        NodeList nUser = doc.getElementsByTagName("User");
        
        for (int temp2 = 0; temp2 < nUser.getLength(); temp2++) {
            Node nNode2 = nUser.item(temp2);
            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement2 = (Element) nNode2;          
            
                if (Name == null ? eElement2.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement2.getElementsByTagName("Jmeno").item(0).getTextContent())) {
                    return Integer.parseInt(eElement2.getElementsByTagName("Maximum").item(0).getTextContent());
                }
            }
        }
        return 0;
    }
    
    public static String GetVysledek(String Name) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//databaze.xml"));
        NodeList nUser = doc.getElementsByTagName("User");
        
        for (int temp2 = 0; temp2 < nUser.getLength(); temp2++) {
            Node nNode2 = nUser.item(temp2);
            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement2 = (Element) nNode2;          
            
                if (Name == null ? eElement2.getElementsByTagName("Jmeno").item(0).getTextContent() == null : Name.equals(eElement2.getElementsByTagName("Jmeno").item(0).getTextContent())) {
                    return eElement2.getElementsByTagName("Vysledek").item(0).getTextContent();
                }
            }
        }
        return "0";
    }
    
}