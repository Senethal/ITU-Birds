/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package birds.control;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author Tom
 */
public class Birdec {
    
    
    public String name;
    public String latname;
    public String trida;
    public String podtrida;
    public String rad;
    public String celed;
    public String rod;
    public String popis;
    public String image;
    
    public Birdec(int index_l, int index_b) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        Lessons Les = new Lessons();
        
        this.name = Les.GetNameBird();
        this.latname = Les.GetLatNameBird();
        this.trida = Les.GetTrida();
        this.podtrida = Les.GetPodtrida();
        this.rad =  Les.GetRad();
        this.celed = Les.GetCeled();
        this.rod = Les.GetRod();
        this.popis = Les.GetPopis();
        this.image = Les.GetImage();  
    }
    
    
}
