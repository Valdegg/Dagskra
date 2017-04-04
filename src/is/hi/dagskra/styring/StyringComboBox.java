/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.dagskra.styring;
import is.hi.dagskra.vidmot.AdalDagskra;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;


/**
 * listener fyrir klukkustunda comboboxið í AdalDagskra
 * @author Valdimar Ágúst
 */
public class StyringComboBox implements ActionListener{


    private final AdalDagskra dagskrarGlugginn;
    /**
     * fjoldiSmella er hve oft atriði hefur verið valið
     */
    private int fjoldiSmella;
    
    public StyringComboBox(AdalDagskra adalGlugginn){
        dagskrarGlugginn = adalGlugginn;
        fjoldiSmella = 0;
    }
    
    /**
     * þegar klukkustund er valin úr comboboxinu þá eru bara sýndir dagskrárliðir sem byrja á þeirri klukkustund
     * @param event 
     */
    @Override
    public void actionPerformed(ActionEvent event){
     
        JComboBox cb = (JComboBox)event.getSource();
        String klukkustund = (String)cb.getSelectedItem();
        dagskrarGlugginn.filterEftirKlst(klukkustund);
 
    }
    
    /**
     * @return the fjoldiSmella
     */
    public int getFjoldiSmella() {
        return fjoldiSmella;
    }

    /**
     * @param fjoldiSmella the fjoldiSmella to set
     */
    public void setFjoldiSmella(int fjoldiSmella) {
        this.fjoldiSmella = fjoldiSmella;
    }
    
    
}
