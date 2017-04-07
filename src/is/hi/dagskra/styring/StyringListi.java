/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.dagskra.styring;

import is.hi.dagskra.vidmot.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import is.hi.dagskra.gogn.Root;

/**
 * Klasi sem er listener fyrir þegar stak er valið úr listanum í AdalDagskra
 * @author Valdimar Ágúst Eggertsson 
 */
public class StyringListi implements ListSelectionListener {

    /**
     * dagskráin sem hefur listann sem er stýrt 
     */
    private final AdalDagskra dagskrarGlugginn;
    private Root.Results dagskrarlidur;
    private boolean aMorgun;
    
    
    /**
     * Býr til listener fyrir lista í glugganum dagskrain
     * @param dagskrain dagskrarglugginn sem kallað er úr
     * @param aMorgun true ef listinn er jDagskrarLidirMrg, false ef jDagskrarLidir
     */ 
    public StyringListi(AdalDagskra dagskrain, boolean aMorgun){
        dagskrarGlugginn = dagskrain;
        this.aMorgun = aMorgun;
        //prentaDagskrarlidi();
        
    }
   
    /**
     * Event handler fyrir þegar stak í listanum er valið. Birtir í dialog upplýsingar um valinn dagskrárlið.
     * 
     * @param event 
     */
    @Override
    public void valueChanged(ListSelectionEvent event){

        ListSelectionModel lsm = (ListSelectionModel)event.getSource();  // af hverju kasta? því getSource skilar Object
         int index = lsm.getMinSelectionIndex();   
         System.out.println(lsm);
       
        if(index != -1){
            // selection is non-empty
            
            if(dagskrarGlugginn.isEyda() ){
                
                opnaStadfestingarGlugga();
                
                if(dagskrarGlugginn.isStadfestaEyda()){
                    
                    
                    dagskrarGlugginn.eydaDagskrarLid(index,aMorgun);
                    lsm.removeIndexInterval(index, index);
                    dagskrarGlugginn.setEyda(false);                
                    dagskrarGlugginn.setStadfestaEyda(false);                                               
                    
                }           
            }else if (dagskrarGlugginn.isBaetaLid()){
                // smellt hefur verið á bæta lið í mína dagskrá 
                dagskrarGlugginn.baetaLidVidMina(index,aMorgun);
                dagskrarGlugginn.setBaetaLid(false);
                dagskrarGlugginn.sortDagskra(aMorgun);
               
                
            }else{
                synaDagskrarLid(index, aMorgun);
            }
        }
      
    }
    

    
    /**
     * opnar dialog með upplýsingar um valinn dagskrárlið
     * <p>
     * @param index indexið á dagskrárliðinn í dagskráliðalistanum
     * @param aMorgun true ef listinn er dagskrá morgundagsins, false ef dagskrá í dag
     */
    private void synaDagskrarLid(int index, boolean aMorgun){
         // búa til SkodaDagskrarLid glugga
        SkodaDagskrarLid dagskrargluggi = new SkodaDagskrarLid(dagskrarGlugginn, true);        
        // sækjum gögnin hingað og sendum inn í dialogið gegnum setjaGogn()
            // gögnin eru í listanum dagskrain.getDagskrarLidir
            // við vinnum bara með 1 dagskrárlið í einu, indexið á hann notum við svo til að velja réttan lið
        if(aMorgun){
            dagskrarlidur = dagskrarGlugginn.getDagskramodelMrg().getDagskrain().getDagskrarLidir().get(index);            
        }else{
            dagskrarlidur = dagskrarGlugginn.getDagskramodel().getDagskrain().getDagskrarLidir().get(index);
        }
        dagskrargluggi.setjaGogn(dagskrarlidur);
        dagskrargluggi.setVisible(true);
    }
    /**
     * Eyðir dagskrálið úr listanum jDagskrarLidir
     * @param lidurNr index á dagskráliðinn í dagskramodel
     */
    private void eydaDagskrarLid(int lidurNr){
        dagskrarGlugginn.eydaDagskrarLid(lidurNr,aMorgun);
        // dagskrárliðnum hefur verið eytt úr dagskrarGlugginn.dagskramodel
    }
 
    /**
     * Prentar út dagskráliðina í dagskrarGlugginn.dagskramodel
     */
    private void prentaDagskrarlidi(){
        
        System.out.println("Dagskrárliðir eftir að hefur verið eytt: \n"); 

        for(Root.Results dagskrarLidur : dagskrarGlugginn.getDagskramodel().getDagskrain().getDagskrarLidir()){
            System.out.println(dagskrarLidur.getTitle());
            System.out.println(dagskrarLidur.getStartTime());
        }
        System.out.println("\n");
    }
    /**
     * býr til StadfestaEydingu dialog glugga og opnar hann
     */
    private void opnaStadfestingarGlugga(){
        StadfestaEydinguGluggi stadfestingarGluggi = new StadfestaEydinguGluggi(dagskrarGlugginn,true);
        stadfestingarGluggi.setVisible(true);
        
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
