/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package birds.control;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Tom
 */
public class Tests {
    
    protected String[] Questions; 
    protected String[][] Answers;
    protected String[] Users_A;
    protected String[] Rights_A;
    public int Diff = 0;
    
    protected int maxim = 10;
    protected int index;
 
    
    public Tests() throws ParserConfigurationException, SAXException, IOException {       
        int[] Test = new int[maxim];
        this.Questions = new String[maxim];
        this.Answers = new String[maxim][4];
        this.Users_A = new String[maxim];
        this.Rights_A = new String[maxim];
        this.index = 0;
        
        for (int i =0; i<10; i++) {
            Test[i] = this.Generate(Test);
            this.Fill(i,Test[i]);
        }      
    }
     
/**
 * Metoda, ktera nahodne generujicich cisel
 * @param pole
 * @return 
 */
    private int Generate(int[] pole) {
            
        int value;
        value = (int)(Math.random()*19+1);
        
        for (int i = 0;i<10;i++) {
            if (pole[i] == value) {
                value = (int)(Math.random()*19+1);
                i = 0;
            }   
        }         
        return value;       
    }  

/**
 * Metoda naplni prislusna pole pro spravnou funkci testu
 * 
     * @param index
     * @param id
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
 */    
    private void Fill(int index,int id) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder(); 
        Document doc = builder.parse(new File("examples//question.xml")); 
            
        NodeList nList = doc.getElementsByTagName("question");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                
                Element element = (Element) nNode;
                
                if (Integer.toString(id).equals(element.getAttribute("id"))) {
                    this.Questions[index] = element.getElementsByTagName("quest").item(0).getTextContent();
                    
                    NodeList nList2 = element.getElementsByTagName("ans");
                        for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
                            Node nNode2 = nList2.item(temp2);
                            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                                Element elem = (Element) nNode2;
                                
                                if ("A".equals(elem.getAttribute("id")))
                                    this.Answers[index][0] = elem.getTextContent();
                            
                                if ("B".equals(elem.getAttribute("id")))
                                    this.Answers[index][1] = elem.getTextContent();
                                
                                if ("C".equals(elem.getAttribute("id")))
                                    this.Answers[index][2] = elem.getTextContent();
                            
                                if ("D".equals(elem.getAttribute("id")))
                                    this.Answers[index][3] = elem.getTextContent();
                            }  
                        }   
                        
                    this.Rights_A[index] = element.getElementsByTagName("rigans").item(0).getTextContent();
                }   
            }            
        }      
    }
    
    protected String NextQuestion() {
        this.index++;
        return this.Questions[this.index];
    }
    
    protected String PreviousQuestion() {
        this.index--;
        return this.Questions[this.index];        
    }

    protected String GetQuestion() {
        return this.Questions[this.index]; 
    }
        
    protected void SaveAnswer(String answer) {
       this.Users_A[this.index] = answer;
    }
    
    protected String[] GetAnswers() {
        String[] ret_val = new String[4];
        
        for (int i = 0; i<4; i++) {
            ret_val[i] = this.Answers[this.index][i]; 
        }      
        return ret_val;
    }
    
}

