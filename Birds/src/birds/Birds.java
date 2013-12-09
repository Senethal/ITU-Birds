/*
 * Projekt ITU
 * Výukový program na znalost ptáků
 * Hlavni okno obsahujici jednotlive obrazovky
 * a funkce pro jejich rizeni
 * 
 */
package birds;

import birds.control.Tests;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lukas
 */
public class Birds extends javax.swing.JFrame {

    /**
     * Creates new form Birds
     */
    public Birds() {
        super();
        initComponents();
        
        //Zneviditelnovani ostatnich oken
        this.hlavniMenu.setVisible(false);
        this.regObrazovka.setVisible(false);
        this.vyberTestuObrazovka.setVisible(false);
        this.klasickyTestObrazovka.setVisible(false);
        this.lekceObrazovka.setVisible(false);
        this.obrazTestObrazovka.setVisible(false);
        this.statistikyObrazovka.setVisible(false);
        ////////////////////////////////////////////////////
        
        //Pridavani odkazu na okno jednotlivym obrazovkam
        this.hlavniMenu.addFrame(this);
        this.prihlObrazovka.addFrame(this);
        this.regObrazovka.addFrame(this);
        this.vyberTestuObrazovka.addFrame(this);
        this.klasickyTestObrazovka.addFrame(this);
        this.lekceObrazovka.addFrame(this);
        this.obrazTestObrazovka.addFrame(this);
        this.statistikyObrazovka.addFrame(this);
        ////////////////////////////////////////////////////
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vrstva = new javax.swing.JLayeredPane();
        regObrazovka = new birds.screens.RegistrationScreen();
        hlavniMenu = new birds.screens.MainMenu();
        vyberTestuObrazovka = new birds.screens.TestChooseScreen();
        lekceObrazovka = new birds.screens.LessonScreen();
        try {
            klasickyTestObrazovka = new birds.screens.ClassicTestScreen();
        } catch (javax.xml.parsers.ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (org.xml.sax.SAXException e2) {
            e2.printStackTrace();
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
        try {
            obrazTestObrazovka = new birds.screens.PictureTestScreen();
        } catch (javax.xml.parsers.ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (org.xml.sax.SAXException e2) {
            e2.printStackTrace();
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
        prihlObrazovka = new birds.screens.LoginSreen();
        try {
            statistikyObrazovka = new birds.screens.StatisticScreen();
        } catch (javax.xml.parsers.ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (org.xml.sax.SAXException e2) {
            e2.printStackTrace();
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        vrstva.add(regObrazovka);
        regObrazovka.setBounds(0, 0, 1100, 720);
        vrstva.add(hlavniMenu);
        hlavniMenu.setBounds(0, 0, 1000, 700);
        vrstva.add(vyberTestuObrazovka);
        vyberTestuObrazovka.setBounds(0, 0, 1000, 700);
        vrstva.add(lekceObrazovka);
        lekceObrazovka.setBounds(0, 0, 1000, 700);
        vrstva.add(klasickyTestObrazovka);
        klasickyTestObrazovka.setBounds(0, 0, 1000, 700);
        vrstva.add(obrazTestObrazovka);
        obrazTestObrazovka.setBounds(0, 0, 1000, 700);
        vrstva.add(prihlObrazovka);
        prihlObrazovka.setBounds(0, 0, 1100, 700);
        vrstva.add(statistikyObrazovka);
        statistikyObrazovka.setBounds(0, 0, 1000, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vrstva, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vrstva, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Birds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Birds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Birds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Birds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Birds b = new Birds();
                b.setVisible(true);
            }
        });
    }
    
    
    /******************************************
     * Funkce pro nastavovani viditelnosti oken
     ******************************************/
    
    public void setHlavniMenuVisible(boolean b) {
        this.hlavniMenu.setVisible(b);
    }

    public void setprihlObrazovkaVisible(boolean b) {
        this.prihlObrazovka.setVisible(b);
    }
    
    public void setregObrazovkaVisible(boolean b) {
        this.regObrazovka.setVisible(b);
    }
    
    public void setvyberTestuObrazovkaObrazovkaVisible(boolean b) {
        this.vyberTestuObrazovka.setVisible(b);
    }
    
    public void setklasickyTestObrazovkaVisible(boolean b) {
        this.klasickyTestObrazovka.setVisible(b);
    }
    
    public void setlekceObrazovkaVisible(boolean b) {
        this.lekceObrazovka.setVisible(b);
    }
    
    public void setobrazTestObrazovkaVisible(boolean b) {
        this.obrazTestObrazovka.setVisible(b);
    }
    
    public void setstatistikyObrazovkaVisible(boolean b) throws ParserConfigurationException, SAXException, IOException {
        this.statistikyObrazovka.setVisible(b);
        this.statistikyObrazovka.Omg();
    }
   /*********************************************/ 
    
    public void setUserName(String name){
        this.UserName = name;
    }
    
    public String getUserName(){
        return this.UserName;
    }
    
    public void setTypeTest(int type){
        this.TestType = type;
    }
   
    public void setLesson(int lesson){
        this.lesson = lesson;
    }
    
    public void createNewClassic(){
        Tests t = null;
        try {
            t = new Tests(this.lesson, this.TestType);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Birds.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.klasickyTestObrazovka.createTest(t);
    }
    
    public void createNewPicture(){
        Tests t = null;
        try {
            t = new Tests(this.lesson, this.TestType);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Birds.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.obrazTestObrazovka.createTest(t);
    }
   
    private int lesson = 0; 
    private int TestType = 0; // 1- klasicky test 2- poznavaci test 3- doplnovaci test
    private String UserName;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private birds.screens.MainMenu hlavniMenu;
    private birds.screens.ClassicTestScreen klasickyTestObrazovka;
    private birds.screens.LessonScreen lekceObrazovka;
    private birds.screens.PictureTestScreen obrazTestObrazovka;
    private birds.screens.LoginSreen prihlObrazovka;
    private birds.screens.RegistrationScreen regObrazovka;
    private birds.screens.StatisticScreen statistikyObrazovka;
    private javax.swing.JLayeredPane vrstva;
    private birds.screens.TestChooseScreen vyberTestuObrazovka;
    // End of variables declaration//GEN-END:variables
}
