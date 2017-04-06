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
     * segir til um hvorn dagskrárlistann verið er að stýra; true ef dagskrá "morgundagsins"
     */
    private boolean aMorgun;
    /**
     * fjoldiSmella er hve oft atriði hefur verið valið
     */
    private int fjoldiSmella;
    
    /**
     * 
     * @param adalGlugginn dagskrárgluginn sem kallað er á úr
     * @param aMorgun boolean sem segir til um hvorn dagskrárlistann verið er að stýra, true ef dagskrá "morgundagsins"
     */
    public StyringComboBox(AdalDagskra adalGlugginn, boolean aMorgun){
        dagskrarGlugginn = adalGlugginn;
        fjoldiSmella = 0;
        this.aMorgun = aMorgun;
    }
    
    /**
     * þegar klukkustund er valin úr comboboxinu þá eru bara sýndir dagskrárliðir sem byrja á þeirri klukkustund
     * @param event 
     */
    @Override
    public void actionPerformed(ActionEvent event){
     
        JComboBox cb = (JComboBox)event.getSource();
        String klukkustund = (String)cb.getSelectedItem();
        dagskrarGlugginn.filterEftirKlst(klukkustund, aMorgun);
 
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
    
    /**
     * @return the aMorgun
     */
    public boolean isaMorgun() {
        return aMorgun;
    }

    /**
     * @param aMorgun the aMorgun to set
     */
    public void setaMorgun(boolean aMorgun) {
        this.aMorgun = aMorgun;
    }

    
}
