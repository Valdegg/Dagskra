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
 * Listener fyrir comboboxin í AdalDagskra þar sem titill eða lýsing er valið 
 * @author Valdimar Ágúst vae11@hi.is
 */


public class StyringComboBoxTitillEdaLysing implements ActionListener {

    /**
     * glugginn sem comboboxið er í 
     */
    private final AdalDagskra dagskrarGlugginn;
    
    /**
     * segir til um hvorn dagskrárlistann verið er að stýra; true ef dagskrá "morgundagsins"
     */
    private boolean aMorgun;

     /**
     * 
     * @param adalGlugginn dagskrárgluginn sem kallað er á úr
     * @param aMorgun boolean sem segir til um hvorn dagskrárlistann verið er að stýra, true ef dagskrá "morgundagsins"
     */
    public StyringComboBoxTitillEdaLysing(AdalDagskra adalGlugginn, boolean aMorgun){
        dagskrarGlugginn = adalGlugginn;
        this.aMorgun = aMorgun;
    }
    
      /**
     * Stillir byTitle í AdalDagskra sem segir hvort jFilter eigi að leita eftir titli eða lýsingu.
     * þegar atriði (titill eða lýsing) er valið úr comboboxinu þá leitar jFilter/jFilterMrg eftir því
     * @param event 
     */
    @Override
    public void actionPerformed(ActionEvent event){
     
        JComboBox cb = (JComboBox)event.getSource();
        String leitadEftir = (String)cb.getSelectedItem();        
        
        if(aMorgun){
            if (leitadEftir.equals("Titill inniheldur...")){
                dagskrarGlugginn.setByTitleMrg(true);
            } else{
                dagskrarGlugginn.setByTitleMrg(false);
            }
        }else{
            if (leitadEftir.equals("Titill inniheldur...")){
                dagskrarGlugginn.setByTitle(true);
            } else{
                dagskrarGlugginn.setByTitle(false);
            }
        }
 
    }
    
    
}
