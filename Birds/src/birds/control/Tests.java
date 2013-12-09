/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package birds.control;

import birds.users.UserDatabase;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Tom
 */
public class Tests {
    
    public String[] Questions; 
    public String[][] Answers;
    public String[] Users_A;
    public String[] Rights_A;
    public int Diff = 0;
    
    public int maxim = 10;
    public int index;
 
    
    public Tests(int Less, int TypeTest) throws ParserConfigurationException, SAXException, IOException {       
        int[] Test = new int[maxim];
        this.Questions = new String[maxim];
        this.Answers = new String[maxim][4];
        this.Users_A = new String[maxim];
        this.Rights_A = new String[maxim];
        this.index = 0;
        
        for (int i =0; i<10; i++) {
            if (TypeTest == 1) {
                Test[i] = this.Generate(Test, Less);
                this.Fill(i,Test[i], TypeTest);  
            }
            else if (TypeTest == 2) {
                Test[i] = this.GenerateImage(Test);
                this.Fill(i,Test[i], TypeTest);     
            }

        }      
    }
     
/**
 * Metoda, ktera nahodne generujicich cisel
 * @param pole
 * @return 
 */
    private int Generate(int[] pole, int TypeLess) {
            
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
 * Metoda, ktera nahodne generujicich cisel
 * @param pole
 * @return 
 */
    private int GenerateImage(int[] pole) {
            
        int value;
        value = (int)(Math.random()*24+1);
        
        for (int i = 0;i<10;i++) {
            if (pole[i] == value) {
                value = (int)(Math.random()*24+1);
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
    private void Fill(int index,int id, int Type) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
        domFactory.setIgnoringComments(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = null;
        if (Type == 1) { 
            doc = builder.parse(new File("examples//question.xml")); 
        }
        else if (Type == 2) {
            doc = builder.parse(new File("examples//questionO.xml")); 
        }
        
        NodeList nList = doc.getElementsByTagName("question");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                
                Element element = (Element) nNode;
                
                if (Integer.toString(id).equals(element.getAttribute("id"))) {
                    this.Questions[index] = Format(element.getElementsByTagName("quest").item(0).getTextContent());
                    this.Answers[index][0] = element.getElementsByTagName("ansA").item(0).getTextContent();
                    this.Answers[index][1] = element.getElementsByTagName("ansB").item(0).getTextContent();
                    this.Answers[index][2] = element.getElementsByTagName("ansC").item(0).getTextContent();
                    this.Answers[index][3] = element.getElementsByTagName("ansD").item(0).getTextContent();  
                    this.Rights_A[index] = element.getElementsByTagName("rigans").item(0).getTextContent();
                }   
            }            
        }      
    }
///////////////////////////////////////////////////////////////////////////////////////////////// 
   
    public String Format(String s) {
        
        String text;
        
        text = "\n" + "\n" + "\n";
        text += "                     " + s + "\n";

        
        return text;
    }
    
    public void NextQuestion() {
        if (this.index < this.maxim)
            this.index++;
    }
    
    public void PreviousQuestion() {
        if (this.index > 0)
            this.index--;       
    }
    
    public String GetQuestion() {
        return this.Questions[this.index]; 
    }
        
    public void SaveAnswer(String answer) {
       this.Users_A[this.index] = answer;
    }
    
    public String GetAnswerA() {
        return this.Answers[this.index][0];      
    }
    
    public String GetAnswerB() {
        return this.Answers[this.index][1];      
    }
    
    public String GetAnswerC() {
        return this.Answers[this.index][2];      
    }
    
    public String GetAnswerD() {
        return this.Answers[this.index][3];      
    }
    
    public String GetUserAns() {
        return this.Users_A[this.index];
    }
    public void Evaluate(String Name) throws ParserConfigurationException, SAXException, IOException, TransformerException {
    
        int rights = 0;
        
        for (int i = 0; i < this.maxim; i++ ) {
            if (this.Rights_A[i].equals(this.Users_A[i])) {
                rights++;
            }   
        }
         
        rights = rights*this.maxim; 
        
        rights = UserDatabase.AddTest(rights, Name);
        UserDatabase.AddOut(rights, Name);
        
    }
    
}

