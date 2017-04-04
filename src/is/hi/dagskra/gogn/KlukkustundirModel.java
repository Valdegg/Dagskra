/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.dagskra.gogn;
import javax.swing.DefaultComboBoxModel;
import java.util.ArrayList;
import is.hi.dagskra.vidmot.AdalDagskra;


/**
 * model hluti comboboxins þar sem notandi getur leitað eftir klukkstundum
 * @author Valdimar Ágúst Eggertsson
 */
public class KlukkustundirModel extends DefaultComboBoxModel<String>{

    
    // hef tilviksbreytu sem geymir gögnin
    
    /**
     * táknar klukkustundirnar sem dagskrárliðirnir eru á
     * gætum gert forrit sem skoðar StartTime á þeim og finnur bilið sem það liggur á
     * en sjáum að það er frá kl 17 til kl 00
     */
   

    public KlukkustundirModel(String[] klukkustundir){
        super();

    }
    
  
    
}
