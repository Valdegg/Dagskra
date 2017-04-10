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
 * Klasi sem er listener fyrir þegar stak er valið úr listanum jDagskrarLidir/jDagskrarLidirMrg í AdalDagskra
 * @author Valdimar Ágúst Eggertsson 
 */
public class StyringListi implements ListSelectionListener {

    /**
     * dagskráin sem hefur listann sem er stýrt 
     */
    private final AdalDagskra dagskrarGlugginn;
    private Root.Results dagskrarlidur;
    /**
     * segir til um hvorum dagskrárlistanum verið er að stýra 
     * true ef listinn er jDagskrarLidirMrg, false ef jDagskrarLidir
     */    
    private boolean aMorgun;
    
    
    /**
     * Býr til listener fyrir lista í glugganum dagskrain
     * @param dagskrain dagskrarglugginn sem kallað er úr
     * @param aMorgun true ef listinn er jDagskrarLidirMrg, false ef jDagskrarLidir
     */ 
    public StyringListi(AdalDagskra dagskrain, boolean aMorgun){
        dagskrarGlugginn = dagskrain;
        this.aMorgun = aMorgun;        
        
    }
   
    /**
     * Event handler fyrir þegar stak í listanum er valið. Mismunandi hegðun eftir hvort Skoða, Bæta eða Eyða hafi verið valið.
     * <p>
     * Skoða: Birtir í dialog upplýsingar um valinn dagskrárlið.
     * Bæta: Bætir upplýsingar um valinn dagskrárlið í Mína Dagskrá
     * Eyða: Eyðir upplýsingum um valinn dagskrárlið úr listanum sem verið er að stýra.
     * </p>
     * @param event 
     */
    @Override
    public void valueChanged(ListSelectionEvent event){

        ListSelectionModel lsm = (ListSelectionModel)event.getSource();  // af hverju kasta? því getSource skilar Object
        int index = lsm.getMinSelectionIndex();   // indexið í listanum
       
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
            }
            if (dagskrarGlugginn.isBaetaLid()){
                // smellt hefur verið á bæta lið í mína dagskrá 
                dagskrarGlugginn.baetaLidVidMina(index,aMorgun);
                dagskrarGlugginn.sortDagskra(aMorgun);
                dagskrarGlugginn.setBaetaLid(false);
                
            }
            if (dagskrarGlugginn.isSkodaLid()){

                synaDagskrarLid(index, aMorgun);
                dagskrarGlugginn.setSkodaLid(false);
                
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
     * eftirá er stadfestaEyda true/false eftir hvað efur verið valið
     */
    private void opnaStadfestingarGlugga(){
        StadfestaEydinguGluggi stadfestingarGluggi = new StadfestaEydinguGluggi(dagskrarGlugginn,true);
        stadfestingarGluggi.setVisible(true);        
    }


        
}
