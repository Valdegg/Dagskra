/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.dagskra.gogn;

//import java.util.ArrayList;
 import is.hi.dagskra.vinnsla.DagskraKatalogur;
import javax.swing.DefaultListModel;

/**
 * model sem birt er í JList, geymir lista af dagskrárliðum
 * @author Valdimar Ágúst vae11@hi.is
 */
public class DagskraModel extends DefaultListModel {


    /*
    * geymir gögnin fyrir dagskrána 
    */    
    private DagskraKatalogur dagskrain;
    
    /**
     * smiðu
     */
    public DagskraModel(){
        dagskrain = new DagskraKatalogur();
        
    }

        /**
     * @return the dagskrain
     */
    public DagskraKatalogur getDagskrain() {
        return dagskrain;
    }

    /**
     * @param dagskrain the dagskrain to set
     */
    public void setDagskrain(DagskraKatalogur dagskrain) {
        this.dagskrain = dagskrain;
    }
    

    
}
