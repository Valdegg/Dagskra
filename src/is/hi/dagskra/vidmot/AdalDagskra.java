
package is.hi.dagskra.vidmot;

import is.hi.dagskra.gogn.DagskraModel;
import is.hi.dagskra.vinnsla.DagskraKatalogur;
import is.hi.dagskra.gogn.Root;
import is.hi.dagskra.styring.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

import java.util.Collections;
import java.util.Iterator;
import javax.swing.SpinnerDateModel;



/**
 * Aðal klasinn. viðmótsglugginn sem birtir dagskrána og býr til og notar hlutina af hinum klösunum
 * @author Valdimar Ágúst Eggertsson vae11@hi.is
 * 
 */
public class AdalDagskra extends javax.swing.JFrame {

    /**
     * @return the eyddirLidirMrg
     */
    public ArrayList<Root.Results> getEyddirLidirMrg() {
        return eyddirLidirMrg;
    }

    /**
     * @param eyddirLidirMrg the eyddirLidirMrg to set
     */
    public void setEyddirLidirMrg(ArrayList<Root.Results> eyddirLidirMrg) {
        this.eyddirLidirMrg = eyddirLidirMrg;
    }

    /**
     * @return the eyddirLidir
     */
    public ArrayList<Root.Results> getEyddirLidir() {
        return eyddirLidir;
    }

    /**
     * @param eyddirLidir the eyddirLidir to set
     */
    public void setEyddirLidir(ArrayList<Root.Results> eyddirLidir) {
        this.eyddirLidir = eyddirLidir;
    }

    /**
     * @return the jMinDagskra
     */
    public javax.swing.JPanel getjMinDagskra() {
        return jMinDagskra;
    }

    /**
     * @param jMinDagskra the jMinDagskra to set
     */
    public void setjMinDagskra(javax.swing.JPanel jMinDagskra) {
        this.jMinDagskra = jMinDagskra;
    }

 
    /**
     * upprunalegu gögnin sem hlaðið er inn fyrir lista dagskránnar í dageru geymd í dagskrain
     */ 
    private DagskraKatalogur dagskrain; 
    /**
     * dagskramodel er modelið fyrir jDagskrarLidir
     * ( gögnin eru geymd sem dagskramodel sem er DefaultListModel )
     */
    private DagskraModel dagskramodel;
         
    /**
     * upprunalegu gögnin sem hlaðið er inn fyrir lista "morgundagsins" eru geymd í dagskrainMrg
     */ 
    private DagskraKatalogur dagskrainMrg; 
    
    
    
    /**
     * dagskramodelMrg er modelið fyrir jDagskrarLidirMrg
     * ( gögnin eru geymd sem  dagskramodelMrg sem er DefaultListModel )
     */
    private DagskraModel dagskramodelMrg;
    
    /**
     * dagskramodelMrg er modelið fyrir jMinDagskraIDag
     * ( gögnin eru geymd sem dagskramodelMinIdag sem er DefaultListModel )
     */
    private DagskraModel dagskramodelMinIDag;
    
    /**
     * dagskramodelMrg er modelið fyrir jMinDagskraMrg
     * ( gögnin eru geymd sem dagskramodelMinMrg sem er DefaultListModel )
     */
    private DagskraModel dagskramodelMinMrg;
    
    /**
     * liðir sem hefur verið eytt
     */
    private ArrayList<Root.Results> eyddirLidir = new ArrayList<>();

/**
     * liðir sem hefur verið eytt
     */
    private ArrayList<Root.Results> eyddirLidirMrg = new ArrayList<>();
    
    
// 
    
    /**
     * ef true þá búið að smella á hnappinn og ekki búið að smella á dagskrárlið til að eyða
     */
    private boolean eyda = false;
    
    /**
     * ef true þá búið að ýta á ok í eyðingar staðfestingarglugga og verið að fara að eyða breytunni
     */
    private boolean stadfestaEyda = false;
    
    /**
     * ef true þá búið að smella á hnappinn og ekki búið að smella á dagskrárlið til að bæta í Mína Dagskrá
     */
    private boolean baetaLid = false;
    
    /**
     * ef true þá búið að smella á hnappinn og ekki búið að smella á dagskrárlið til að skoða 
     */
    private boolean skodaLid = false;
    
    
    /**
     * hvort leitað sé í jFilter eftir titli eða ekki 
     */
    private boolean byTitle = true;
   
    /**
     * hvort leitað sé í jFilterMrg eftir titli í dagskrá morgundagsins eða ekki 
     */
    private boolean byTitleMrg = true;
 
    
    
//// Models
    
    /**
     * modelið fyrir jInnanKlst
     */
    private DefaultComboBoxModel klstmodel;
    
    /**
     * modelið fyrir jInnanKlstMrg
     */
    private DefaultComboBoxModel klstmodelMrg;
    
    
    /**
     * modelið fyrir jTitillEdaLysing
     */
    private DefaultComboBoxModel titillEdaLysingModel;

    /**
     * modelið fyrir jTitillEdaLysingMrg
     */
    private DefaultComboBoxModel titillEdaLysingModelMrg;
    
    
//// Listeners 
    
    /**
     * listener með event handler fyrir jInnanKlst
     */
    private StyringComboBox styringComboBox;
    /**
     * listener með event handler fyrir jInnanKlstMrg
     */
    private StyringComboBox styringComboBoxMrg;

    /**
     * listener með event handler fyrir jTitillEdaLysing 
     */
    private StyringComboBoxTitillEdaLysing styringComboBoxTitillEdaLysing;

        /**
     * listener með event handler fyrir jTitillEdaLysingMrg
     */
    private StyringComboBoxTitillEdaLysing styringComboBoxTitillEdaLysingMrg;
  
    
//// getters og setters
    
    /**
     * @return the skodaLid
     */
    public boolean isSkodaLid() {
        return skodaLid;
    }

    /**
     * @param skodaLid the skodaLid to set
     */
    public void setSkodaLid(boolean skodaLid) {
        this.skodaLid = skodaLid;
    }

    /**
     * @return the byTitle
     */
    public boolean isByTitle() {
        return byTitle;
    }

    /**
     * @param byTitle the byTitle to set
     */
    public void setByTitle(boolean byTitle) {
        this.byTitle = byTitle;
    }

    /**
     * @return the byTitleMrg
     */
    public boolean isByTitleMrg() {
        return byTitleMrg;
    }

    /**
     * @param byTitleMrg the byTitleMrg to set
     */
    public void setByTitleMrg(boolean byTitleMrg) {
        this.byTitleMrg = byTitleMrg;
    }


    
    /**
     * @return the baetaLid
     */
    public boolean isBaetaLid() {
        return baetaLid;
    }

    /**
     * @param baetaLid the baetaLid to set
     */
    public void setBaetaLid(boolean baetaLid) {
        this.baetaLid = baetaLid;
    }


    /**
     * @return the eyda
     */
    public boolean isEyda() {
        return eyda;
    }

    /**
     * @param eyda the eyda to set
     */
    public void setEyda(boolean eyda) {
        this.eyda = eyda;
    }    
    
    /**
     * @return the stadfestaEyda
     */
    public boolean isStadfestaEyda() {
        return stadfestaEyda;
    }

    /**
     * @param stadfestaEyda the stadfestaEyda to set
     */
    public void setStadfestaEyda(boolean stadfestaEyda) {
        this.stadfestaEyda = stadfestaEyda;
        
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
    /**
     * @return the dagskramodel
     */
    public DagskraModel getDagskramodel() {
        return dagskramodel;
    }

    /**
     * @param dagskramodel the dagskramodel to set
     */
    public void setDagskramodel(DagskraModel dagskramodel) {
        this.dagskramodel = dagskramodel;
    }
 
        /**
     * @return the dagskramodelMrg
     */
    public DagskraModel getDagskramodelMrg() {
        return dagskramodelMrg;
    }

    /**
     * @param dagskramodelMrg the dagskramodelMrg to set
     */
    public void setDagskramodelMrg(DagskraModel dagskramodelMrg) {
        this.dagskramodelMrg = dagskramodelMrg;
    }




    /**
     * @return the dagskrainMrg
     */
    public DagskraKatalogur getDagskrainMrg() {
        return dagskrainMrg;
    }

    /**
     * @param dagskrainMrg the dagskrainMrg to set
     */
    public void setDagskrainMrg(DagskraKatalogur dagskrainMrg) {
        this.dagskrainMrg = dagskrainMrg;
    }
 /**
     * @return the dagskramodelMinIDag
     */
    public DagskraModel getDagskramodelMinIDag() {
        return dagskramodelMinIDag;
    }

    /**
     * @param dagskramodelMinIDag the dagskramodelMinIDag to set
     */
    public void setDagskramodelMinIDag(DagskraModel dagskramodelMinIDag) {
        this.dagskramodelMinIDag = dagskramodelMinIDag;
    }

    /**
     * @return the dagskramodelMinMrg
     */
    public DagskraModel getDagskramodelMinMrg() {
        return dagskramodelMinMrg;
    }

    /**
     * @param dagskramodelMinMrg the dagskramodelMinMrg to set
     */
    public void setDagskramodelMinMrg(DagskraModel dagskramodelMinMrg) {
        this.dagskramodelMinMrg = dagskramodelMinMrg;
    }
  
       
    
    /**
     * Creates new form AdalDagskra
     */
    public AdalDagskra() {
        initComponents();
        
        
        setjaUppListana(false);
        setjaUppListana(true);
        
        
    }
    
    /**
     * gerir model með dagskrám fyrir jDagskrarLidir og jMinDagskraIDag, eða þá  jDagskrarLidirMrg og jMinDagskraMrg 
     * birtir innihald modelanna fyrir jDagskrarLidir, jDagskrarLidirMrg, ekki hina sem eru upphaflega tómir listar í viðmótinu
     * @param aMorgun true ef á að setja upp dagskrá morgundagsins, false annars
     */
    private void setjaUppListana(boolean aMorgun){
     
        if(!aMorgun){
            // listinn fyrir dagskráliði dagsins í dag settur upp:
            dagskramodel = new DagskraModel(false);
            dagskrain = new DagskraKatalogur(false);
            baetaDagskra(false);
            
            jDagskrarLidir.setModel(dagskramodel);
            jDagskrarLidir.getSelectionModel().addListSelectionListener(new StyringListi(this, false));        
            // listener hefur verið tengdur við listann 

            // listinn fyrir dagskrárliði í dag hefur verið settur upp.

            // set upp gögn fyrir leitina fyrir daginn í dag:     
            setjaUppLeitina(false);
        
            // set upp gögn fyrir Mína Dagskrá
            dagskramodelMinIDag = new DagskraModel(false);
           jMinDagskraIDag.setModel(dagskramodelMinIDag);
        }else{

            // listinn fyrir dagskrárliði á morgun settur upp:
            dagskramodelMrg = new DagskraModel(true);
            dagskrainMrg = new DagskraKatalogur(true);   
            baetaDagskra(true);
            
            // dagskramodelMrg.setDagskrain(dagskrainMrg);        
            jDagskrarLidirMrg.setModel(dagskramodelMrg);
            jDagskrarLidirMrg.getSelectionModel().addListSelectionListener(new StyringListi(this,true));        
            setjaUppLeitina(true);
            // leitin hefur verið sett upp fyrir dagskrárnar

            // set upp gögn fyrir Mína Dagskrá
            dagskramodelMinMrg = new DagskraModel(true);
            jMinDagskraMrg.setModel(dagskramodelMinMrg);
        }
             
    }
    
    /**
     * Setur upp gögn fyrir leitina í annað hvort dagskrána í dag eða áMorgun
     * @param aMorgun 
     */
    private void setjaUppLeitina(boolean aMorgun){

        /**
         * táknar klukkustundirnar sem dagskrá er í gangi
         */
        String[] klukkustundir;

        if(aMorgun){
            int starttime = 15; 
            int endtime = 25; // kl 01
            klukkustundir = new String[endtime-starttime+1];
            int j = 0; 
            for(int i = starttime; i<endtime; i++)
            {
                klukkustundir[j++] = String.valueOf(i);
            }      
            klukkustundir[--j] = "00";
            klukkustundir[++j] = "01";
            
            
            // set upp combobox fyrir klukkustundirnar:
            klstmodelMrg = new DefaultComboBoxModel(klukkustundir);
            // set gögn í jInnanKlstMrg:
            jInnanKlstMrg.setModel(klstmodelMrg);

            styringComboBoxMrg = new StyringComboBox(this, true);
            // tengi listener við jInnanKlstMrg:
           jInnanKlstMrg.addActionListener(styringComboBoxMrg);
            
            // set upp combobox fyrir titill/lýsing með listener:
            String[] titillEdaLysingMrg = new String[] {"Titill inniheldur...", "Lýsing inniheldur..."};
            titillEdaLysingModelMrg = new DefaultComboBoxModel(titillEdaLysingMrg);
            jTitillEdaLysingMrg.setModel(titillEdaLysingModelMrg);        
            styringComboBoxTitillEdaLysingMrg =  new StyringComboBoxTitillEdaLysing(this, aMorgun);
            jTitillEdaLysingMrg.addActionListener(styringComboBoxTitillEdaLysingMrg);

            
        }else{
            int starttime = 17; 
            int endtime = 24; // kl 00
            klukkustundir = new String[endtime-starttime+1];
            int j = 0; 
            for(int i = starttime; i<endtime; i++)
            {
                klukkustundir[j++] = String.valueOf(i);
            }      

            klukkustundir[j] = "00";        
            // set upp combobox fyrir klukkustundirnar:
            klstmodel = new DefaultComboBoxModel(klukkustundir);
            // set gögn í jInnanKlst
            jInnanKlst.setModel(klstmodel);

          styringComboBox = new StyringComboBox(this, false);
            // tengi listener við jInnanKlst
           jInnanKlst.addActionListener(styringComboBox);
            
            // set upp combobox fyrir titill/lýsing         
            String[] titillEdaLysing = new String[] {"Titill inniheldur...", "Lýsing inniheldur..."};
            titillEdaLysingModel = new DefaultComboBoxModel(titillEdaLysing);
            jTitillEdaLysing.setModel(titillEdaLysingModel);
        
            styringComboBoxTitillEdaLysing =  new StyringComboBoxTitillEdaLysing(this, aMorgun);
            jTitillEdaLysing.addActionListener(styringComboBoxTitillEdaLysing);
            
           
        }
        
        
        
    }
      
    
    
    /**
     * raðar Minni Dagskrá í stafrófsröð, annað hvort í dag eða á morgun  
     * @param aMorgun true þþaa á morgun
     */
    public void sortDagskra(boolean aMorgun){
        if(aMorgun){            
            ArrayList list = Collections.list(getDagskramodelMinMrg().elements());
            Collections.sort(list);
            // list inniheldur dagskrána raðaða í tímaröð
            // hreinsa módelið:
            getDagskramodelMinMrg().clear();
            // bæti röðuðu í módelið:
            for(Object lidur : list){
                getDagskramodelMinMrg().addElement(lidur);
            }         
        }else{                        
            ArrayList list = Collections.list(dagskramodelMinIDag.elements());            
            Collections.sort(list);
            // list inniheldur dagskrána raðaða í tímaröð
            // hreinsa módelið 
            dagskramodelMinIDag.clear();
            // bæti röðuðu í módelið 
            for(Object lidur : list){
                dagskramodelMinIDag.addElement(lidur);
            }
        }
    }
    /**
     * bætir dagskrárlið númer index (í tímaröð dagskránnar) í Mína Dagskrá í viðmótinu 
     * @param index  0 <= index < fjöldi dagskrárliða í dag (eða á morgun)
     * @param aMorgun satt ef dagskrárliðurinn er í dagskrá morgundagsins, false ef í dag 
     */
    public void baetaLidVidMina(int index, boolean aMorgun){
        if(aMorgun){
            Root.Results lidurTilAdBirta = getDagskramodelMinMrg().getDagskrain().getDagskrarLidir().get(index); // dagskráin er öll í módelinu, bara ekki birt
            String textiTilAdBirta = lidurTilAdBirta.getStartTime().substring(11,16) + "  " + lidurTilAdBirta.getTitle();
             getDagskramodelMinMrg().addElement(textiTilAdBirta);
        }else{
            Root.Results lidurTilAdBirta = dagskramodelMinIDag.getDagskrain().getDagskrarLidir().get(index);
            String textiTilAdBirta = lidurTilAdBirta.getStartTime().substring(11,16) + "  " + lidurTilAdBirta.getTitle();
            dagskramodelMinIDag.addElement(textiTilAdBirta);
        }
    }
    
     /**
     * setur titlana úr dagskrain / dagskrainMrg í dagskramodel 
     * @param aMorgun ef dagskrá á morgun, false ef í dag

     */
    private void baetaDagskra(boolean aMorgun){
        if(aMorgun){
            for(Root.Results dagskrarlidur : dagskrainMrg.getDagskrarLidir()){
                dagskramodelMrg.addElement(dagskrarlidur.getStartTime().substring(11,16) + "  " + dagskrarlidur.getTitle());

            }
        }
        else{
            for(Root.Results dagskrarlidur : dagskrain.getDagskrarLidir()){
                dagskramodel.addElement(dagskrarlidur.getStartTime().substring(11,16) + "  " + dagskrarlidur.getTitle());

            }
        }
    }
    
    
    
    
    /**
     * Eyðir  dagskrárlið nr lidurNr úr dagskramodel eða dagskramodelMrg
     * @param lidurNr indexið á liðinn í listanum 
     * @param aMorgun ef true, þá eyðir á morgun, annars í dag
     */
    public void eydaDagskrarLid(int lidurNr, boolean aMorgun){
        
        if(aMorgun){
            dagskramodelMrg.remove(lidurNr);
            // þetta eyðir ekki almennilega úr gögnunum
            List<Root.Results> dagskrarLidir = dagskramodelMrg.getDagskrain().getDagskrarLidir();            
           // addEyddumLid(dagskrarLidir.get(lidurNr),aMorgun);
            dagskrarLidir.remove(lidurNr);
            // nú er búið að eyða almennilega úr gögnunum  
            
            
         
        }else{
            dagskramodel.remove(lidurNr);
            // þetta eyðir ekki almennilega úr gögnunum
            List<Root.Results> dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();
          //  getEyddirLidir().add(dagskrarLidir.get(lidurNr));
            dagskrarLidir.remove(lidurNr);
            // nú er búið að eyða almennilega úr gögnunum
            
        }
      
    }
    /**
     * birtir bara þá liði í jDagskrarLidir/jDagskrarLidirMrg sem eru í mesta lagi (eða minnsta lagi) timalengd að lengd
     * 
     * @param timalengd á sniðinu hh:mm
     * @param aMorgun eða í dag
     * @param min true ef birta á dagskrárliði sem eru lengri en tímalengd, false ef birta á þá sem eru í mesta lagi timalengd
     */
    private void filteraTimalengd(String timalengd, boolean aMorgun, boolean min){
        
            List<Root.Results> dagskrarLidir;
            if(aMorgun){
                dagskrarLidir = dagskramodelMrg.getDagskrain().getDagskrarLidir();
            }else{
                dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();
            }
            

            int fjoldiStakaIListanum = dagskrarLidir.size();
            int lidurNr = 0;
            while(lidurNr < fjoldiStakaIListanum){
                // dagskrárliðir úr sætum 0 upp í lidurNr-1 eru lengri en timalengd
                // það eru fjoldiStakaIListanum stök í jDagskrarLidir
                int klst = dagskrarLidir.get(lidurNr).getDuration().getHour();
                int minutur = dagskrarLidir.get(lidurNr).getDuration().getMinute();
                
                String lengdDagskrarlids;
                if(minutur <10){
                    lengdDagskrarlids= "0" + klst + ":0" +  minutur;                                    
                }else{
                    lengdDagskrarlids = "0" + klst + ":" +  minutur;                                    
                }            
                boolean uppfyllir = longer(lengdDagskrarlids,timalengd);
  
                
                // uppfyllir er satt ef dagskrárliðurinn sem verið er að skoða er lengri en timalengd

                if(!min){
                    // ef við erum að athuga hvort liðurinn sé max timalengd, þá snýst þetta við
                    uppfyllir = !uppfyllir;
                }
                
                // checkum á dagskrarlidnum:
                if(uppfyllir){
                    // liðurinn uppfyllir leitarskilyrðin (er styttri/lengri en timalengd)
                    lidurNr++;
                }else{
                    eydaDagskrarLid(lidurNr, aMorgun);
                    fjoldiStakaIListanum--;
                }

            }
   
    }
    /**
     * 
     * @param timastrengur1 á sniðinu hh:mm
     * @param timastrengur2
     * @return true ef timastrengur1 er lengri en timastrengur2 
     */
    private boolean longer(String timastrengur1, String timastrengur2){
        // checkum hvort hh1>hh2
        if(timastrengur1.substring(0,2).compareTo(timastrengur2.substring(0,2)) > 0){
            // fleiri klst í hh1
            return true;
        }else{
            if(timastrengur1.substring(0,2).compareTo(timastrengur2.substring(0,2)) == 0){
                // jafn margar klst 
                // gáum hvort mínúturnar séu fleiri í hh1
                return timastrengur1.substring(3,5).compareTo(timastrengur2.substring(3,5)) > 0;
            }else{
                // fleiri klst í hh2
                return false;
            }
        }        
    }

    /**
     * 
     * @param timastrengur1 á sniðinu hh:mm
     * @param timastrengur2
     * @return true ef timastrengur1 er í mesta lagi jafn langur og timastrengur2 
     */
    private boolean shorter(String timastrengur, String timastrengur2){
        return longer(timastrengur2,timastrengur);
    }    
    
    /**
     * Breytir modelinu fyrir jDagskrarLidir (eða jDagskrarLidirMrg) þannig að bara dagskrárliðir hafa leitarord sem substring eru eftir
     * @param leitarord strengurinn sem leitað er eftir 
     * @param aMorgun true ef leita á í dagskrá jDagskrarLidirMrg, false ef leita á í dagskrá jDagskrarLidir
     * @param eftirTitli ef true þá leitað í titli, ef false þá leitað í lýsingu
     */
     public void filteraDagskrana(String leitarord, boolean aMorgun, boolean eftirTitli){
        
        if(leitarord.equals("")){
            // sýnum allt sem inniheldur tóma strenginn 
            // þ.e. sýnum allt, svo við endurstillum módelið fyrir dagskrárlistann og hættum
           endurstillaDagskra(aMorgun);
        }else{
            List<Root.Results> dagskrarLidir;
            
            if(aMorgun){
                dagskrarLidir = dagskramodelMrg.getDagskrain().getDagskrarLidir();
            }else{
                dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();
            }
             


            int fjoldiStakaIListanum = dagskrarLidir.size();
            int lidurNr = 0;
            while(lidurNr < fjoldiStakaIListanum){
                // dagskrárliðir úr sætum 0 upp í lidurNr-1 innihalda leitarord
                // það eru fjoldiStakaIListanum stök í jDagskrarLidir
                String dagskrarlidur;
                
                if(eftirTitli){
                    dagskrarlidur = dagskrarLidir.get(lidurNr).getTitle();
                }else{
                    dagskrarlidur = dagskrarLidir.get(lidurNr).getDescription();
                }
                if(dagskrarlidur.contains(leitarord) || dagskrarlidur.toLowerCase().contains(leitarord.toLowerCase()))                    
                {
                    // dagskrárliðurinn uppfyllir leitarskilyrðin
                    lidurNr++;
                }else{
                    // dagskrárliðurinn uppfyllir ekki leitarskilyrðin, hendum honum
                    eydaDagskrarLid(lidurNr, aMorgun);
                    fjoldiStakaIListanum--;
                }

            }
        } 
        
        
        
    }
     
    /**
     * bætir lið með index index úr dagskraModel/Mrg í eyddirLidir
     * @param index 
     */
    public void addEyddumLid(Root.Results lidur, boolean aMorgun){
        if(aMorgun){
            eyddirLidirMrg.add(lidur);
            System.out.println(lidur.getTitle());
        }else{
            eyddirLidir.add(lidur);
        }

    }
   /**
    * endurstillir dagskrána þannig að allir dagskrárliðir eru inni
    * @param aMorgun true ef verið er að endustilla dagskrá morgundagsins, false ef í dag
    * 
    */
    public void endurstillaDagskra(boolean aMorgun){
            if(aMorgun){
                
                dagskramodelMrg = new DagskraModel(aMorgun);
                DagskraKatalogur nyDagskra = dagskramodelMrg.getDagskrain();                
                
                List<Root.Results> dagskrarlidir = nyDagskra.getDagskrarLidir();
             
                ArrayList<String> eyddirTitlar = new ArrayList();               
                for(Root.Results eyddurLidur : eyddirLidirMrg){
                    eyddirTitlar.add(eyddurLidur.getTitle());
                }
           
                // eyddirTitlar inniheldur titlum sem hefur verið eytt

                ArrayList<Root.Results> geyma = new ArrayList();                                
                
                int[] indexEyddraLida = new int[dagskrarlidir.size()];
                int fjoldiEyddra = 0;
                int index = 0;
                for(Root.Results dagskrarlidur : dagskrarlidir){
                     
                    if ( !eyddirTitlar.contains(dagskrarlidur.getTitle())){
                        geyma.add(dagskrarlidur);                            
                    }else{
                        System.out.println(dagskrarlidur.getTitle());
                        indexEyddraLida[fjoldiEyddra++] = index;
                    }
                    index++;
                }                    
               
                // geyma inniheldur titlana sem hefur ekki verið eytt 

                
                nyDagskra.setDagskrarLidir( geyma);
                
                dagskramodelMrg.setDagskrain(nyDagskra);
                
                dagskramodelMrg.getDagskrain().birtaDagskrarlid();
                
                // dagskramodelMrg er með gögnin sem eiga að vera(úr geyma), en á eftir að bæta við elements í modelið
             
                
                int j = 0;
                for(Root.Results dagskrarlidur : geyma){
                   dagskramodelMrg.add(j++,dagskrarlidur.getStartTime().substring(11,16) + "  " + dagskrarlidur.getTitle());
                }
                
                jDagskrarLidirMrg.setModel(dagskramodelMrg);
                    jMaxTimeMrg.setText("");
                    jMinTimeMrg.setText("");
                    jFilterMrg.setText("");
        
            }else{
                dagskramodel = new DagskraModel(aMorgun);  
                DagskraKatalogur nyDagskra = dagskramodel.getDagskrain();                                
                List<Root.Results> dagskrarlidir =  nyDagskra.getDagskrarLidir();
                
                ArrayList<String> eyddirTitlar = new ArrayList();               
                for(Root.Results eyddurLidur : eyddirLidir){
                    eyddirTitlar.add(eyddurLidur.getTitle());
                }
           
                // eyddirTitlar inniheldur titlum sem hefur verið eytt

                ArrayList<Root.Results> geyma = new ArrayList();
                
                for(Root.Results dagskrarlidur : dagskrarlidir){ 
                    if ( !eyddirTitlar.contains(dagskrarlidur.getTitle())){
                        geyma.add(dagskrarlidur);                            
                    }
                }              
                // geyma inniheldur titlana sem hefur ekki verið eytt                                
                
                nyDagskra.setDagskrarLidir( geyma);                
                dagskramodel.setDagskrain(nyDagskra);
                
                for(Root.Results dagskrarlidur : geyma){
                   dagskramodel.addElement(dagskrarlidur.getStartTime().substring(11,16) + "  " + dagskrarlidur.getTitle());
                }
                
                
                jDagskrarLidir.setModel(dagskramodel);
                    jMaxTime.setText("");
                    jMinTime.setText("");
                    jFilter.setText("");
            }
           // baetaDagskra(aMorgun);  
            
    }
    
  
    
    /**
     * breytir modelinu fyrir jDagskrarLidir (eða jDagskrarLidirMrg) þ.a. bara dagskrárliðir sem hefjast á klukkutímanum klst
     * t.d. bara það sem byrjar milli 17 og 18 er eftir
     * @param klst strengur sem táknar klst t.d. "17" eða "23" eða "00"
      * @param aMorgun true ef leita á í jDagskrarLidirMrg, annars false
     */ 
    public void filterEftirKlst(String klst, boolean aMorgun){
        
        endurstillaDagskra(aMorgun);
        filteraDagskrana(jFilter.getText(), aMorgun, byTitle);
        // dagskráin hefur verið endurstillt til að geta filterað aftur
            // ef ske kynni að það hafi þegar verið filterað
        
        List<Root.Results> dagskrarLidir;
        if(aMorgun){            
            dagskrarLidir = dagskramodelMrg.getDagskrain().getDagskrarLidir();            
        }else{
            dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();
        }
        
        int fjoldiStakaIListanum = dagskrarLidir.size();
        int lidurNr = 0;
        while(lidurNr < fjoldiStakaIListanum){
            // dagskrárliðir úr sætum 0 upp í lidurNr-1 eru sýndir á klukkutímanum klst
            // það eru fjoldiStakaIListanum stök í jDagskrarLidir
            String dagskrarlidurByrjar = dagskrarLidir.get(lidurNr).getStartTime();
 
            if(innanSamaKlst(dagskrarlidurByrjar, klst)){ 
                // liðurinn uppfyllir leitarskilyrðin; byrjar innan klukkutímans
                lidurNr++;
            }else{
                // liðurinn uppfyllir ekki leitarskilyrðin
                eydaDagskrarLid(lidurNr, aMorgun);
                fjoldiStakaIListanum--;


            }

        }

 
    }
    
    /**
     * skilar true ef startTime er á klukkutímanum klst
     * @param startTime upphafstími á sniðinu 2017-03-14 17:50:00
     * @param klst klukkustund, t.d. 17
     */
    private boolean innanSamaKlst(String startTime, String klst){
        return startTime.substring(11,13).equals(klst);

    }

    /**
     * samræmir módelið fyrir mína dagskrá og dagskrána (ef búið er að eyða úr dagskránni)
     * með því að setja gögnin úr 
     */
    public void samraemaMina(boolean aMorgun){
        if(aMorgun){

            dagskramodelMinMrg.setDagskrain( dagskramodelMrg.getDagskrain() );
        
        }else{
          dagskramodelMinIDag.setDagskrain( dagskramodel.getDagskrain());
            
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDagskra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDagskrarLidir = new javax.swing.JList<>();
        jLeita = new javax.swing.JPanel();
        jFilter = new javax.swing.JTextField();
        jInnanKlst = new javax.swing.JComboBox<>();
        jEndurstilla = new javax.swing.JButton();
        jLeit = new javax.swing.JTextField();
        jSynaKlst = new javax.swing.JTextField();
        jTitillEdaLysing = new javax.swing.JComboBox<>();
        jMinMaxPanel = new javax.swing.JPanel();
        jMinTime = new javax.swing.JTextField();
        jMaxTime = new javax.swing.JTextField();
        jMinLengdText = new javax.swing.JTextField();
        jMaxLengdText = new javax.swing.JTextField();
        jMinMaxLabel = new javax.swing.JLabel();
        jLabelDagskra = new javax.swing.JLabel();
        jDagskraMrg = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDagskrarLidirMrg = new javax.swing.JList<>();
        jLeitaMrg = new javax.swing.JPanel();
        jFilterMrg = new javax.swing.JTextField();
        jInnanKlstMrg = new javax.swing.JComboBox<>();
        jEndurstillaMrg = new javax.swing.JButton();
        jLeitMrg = new javax.swing.JTextField();
        jSynaKlstMrg = new javax.swing.JTextField();
        jTitillEdaLysingMrg = new javax.swing.JComboBox<>();
        jMinMaxPanelMrg = new javax.swing.JPanel();
        jMinTimeMrg = new javax.swing.JTextField();
        jMaxTimeMrg = new javax.swing.JTextField();
        jMinLengdTextMrg = new javax.swing.JTextField();
        jMaxLengdTextMrg = new javax.swing.JTextField();
        jMinMaxLabel1 = new javax.swing.JLabel();
        jLabelDagskraMrg = new javax.swing.JLabel();
        jMinDagskra = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMinDagskraIDag = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jMinDagskraMrg = new javax.swing.JList<>();
        jLabelMinDagskra = new javax.swing.JLabel();
        jLabelIDag = new javax.swing.JLabel();
        jLabelMrg = new javax.swing.JLabel();
        jTakkaPanel = new javax.swing.JPanel();
        jSkoda = new javax.swing.JButton();
        jFaeraIMina = new javax.swing.JButton();
        jEyda = new javax.swing.JButton();
        jSkraLid = new javax.swing.JButton();
        jHeadline = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1500, 2200));

        jDagskra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDagskra.setPreferredSize(new java.awt.Dimension(329, 700));

        jDagskrarLidir.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jDagskrarLidir);

        jFilter.setToolTipText("");
        jFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFilterMouseClicked(evt);
            }
        });
        jFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFilterActionPerformed(evt);
            }
        });
        jFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFilterKeyReleased(evt);
            }
        });

        jInnanKlst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jInnanKlst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInnanKlstActionPerformed(evt);
            }
        });

        jEndurstilla.setText("Sjá alla dagskrárliði");
        jEndurstilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEndurstillaActionPerformed(evt);
            }
        });

        jLeit.setEditable(false);
        jLeit.setText("Leita:");
        jLeit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLeitActionPerformed(evt);
            }
        });

        jSynaKlst.setEditable(false);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("is/hi/dagskra/vidmot/Vidmotstexti_is_IS"); // NOI18N
        jSynaKlst.setText(bundle.getString("thaettirKlukkan")); // NOI18N
        jSynaKlst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSynaKlstActionPerformed(evt);
            }
        });

        jTitillEdaLysing.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jTitillEdaLysing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitillEdaLysingActionPerformed(evt);
            }
        });

        jMinTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinTimeActionPerformed(evt);
            }
        });

        jMaxTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaxTimeActionPerformed(evt);
            }
        });

        jMinLengdText.setEditable(false);
        jMinLengdText.setText("min:");
        jMinLengdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinLengdTextActionPerformed(evt);
            }
        });

        jMaxLengdText.setEditable(false);
        jMaxLengdText.setText("max:");
        jMaxLengdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaxLengdTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jMinMaxPanelLayout = new javax.swing.GroupLayout(jMinMaxPanel);
        jMinMaxPanel.setLayout(jMinMaxPanelLayout);
        jMinMaxPanelLayout.setHorizontalGroup(
            jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMinMaxPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMaxLengdText)
                    .addComponent(jMinLengdText))
                .addGap(18, 18, 18)
                .addGroup(jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMaxTime, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jMinTime)))
        );
        jMinMaxPanelLayout.setVerticalGroup(
            jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMinMaxPanelLayout.createSequentialGroup()
                .addGroup(jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMinTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMinLengdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMaxLengdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMaxTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jMinMaxLabel.setText("Tímalengd [hh:mm]:");

        javax.swing.GroupLayout jLeitaLayout = new javax.swing.GroupLayout(jLeita);
        jLeita.setLayout(jLeitaLayout);
        jLeitaLayout.setHorizontalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitillEdaLysing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFilter)))
                    .addComponent(jEndurstilla, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jMinMaxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jMinMaxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jLeitaLayout.setVerticalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitillEdaLysing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMinMaxLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEndurstilla))
                    .addComponent(jMinMaxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jLabelDagskra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelDagskra.setText("Dagskráin í dag:");

        javax.swing.GroupLayout jDagskraLayout = new javax.swing.GroupLayout(jDagskra);
        jDagskra.setLayout(jDagskraLayout);
        jDagskraLayout.setHorizontalGroup(
            jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLeita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDagskraLayout.createSequentialGroup()
                        .addGroup(jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDagskraLayout.setVerticalGroup(
            jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jDagskraMrg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jDagskrarLidirMrg.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jDagskrarLidirMrg);

        jFilterMrg.setToolTipText("");
        jFilterMrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFilterMrgMouseClicked(evt);
            }
        });
        jFilterMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFilterMrgActionPerformed(evt);
            }
        });
        jFilterMrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFilterMrgKeyReleased(evt);
            }
        });

        jInnanKlstMrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jEndurstillaMrg.setText("Sjá alla dagskrárliði");
        jEndurstillaMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEndurstillaMrgActionPerformed(evt);
            }
        });

        jLeitMrg.setEditable(false);
        jLeitMrg.setText("Leita:");
        jLeitMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLeitMrgActionPerformed(evt);
            }
        });

        jSynaKlstMrg.setEditable(false);
        jSynaKlstMrg.setText(bundle.getString("thaettirKlukkan")); // NOI18N
        jSynaKlstMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSynaKlstMrgActionPerformed(evt);
            }
        });

        jTitillEdaLysingMrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jTitillEdaLysingMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitillEdaLysingMrgActionPerformed(evt);
            }
        });

        jMinTimeMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinTimeMrgActionPerformed(evt);
            }
        });

        jMaxTimeMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaxTimeMrgActionPerformed(evt);
            }
        });

        jMinLengdTextMrg.setEditable(false);
        jMinLengdTextMrg.setText("min:");
        jMinLengdTextMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinLengdTextMrgActionPerformed(evt);
            }
        });

        jMaxLengdTextMrg.setEditable(false);
        jMaxLengdTextMrg.setText("max:");
        jMaxLengdTextMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaxLengdTextMrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jMinMaxPanelMrgLayout = new javax.swing.GroupLayout(jMinMaxPanelMrg);
        jMinMaxPanelMrg.setLayout(jMinMaxPanelMrgLayout);
        jMinMaxPanelMrgLayout.setHorizontalGroup(
            jMinMaxPanelMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMinMaxPanelMrgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jMinMaxPanelMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMaxLengdTextMrg)
                    .addComponent(jMinLengdTextMrg))
                .addGap(18, 18, 18)
                .addGroup(jMinMaxPanelMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMaxTimeMrg, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jMinTimeMrg)))
        );
        jMinMaxPanelMrgLayout.setVerticalGroup(
            jMinMaxPanelMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMinMaxPanelMrgLayout.createSequentialGroup()
                .addGroup(jMinMaxPanelMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMinTimeMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMinLengdTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jMinMaxPanelMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMaxTimeMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMaxLengdTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMinMaxLabel1.setText("Tímalengd [hh:mm]:");

        javax.swing.GroupLayout jLeitaMrgLayout = new javax.swing.GroupLayout(jLeitaMrg);
        jLeitaMrg.setLayout(jLeitaMrgLayout);
        jLeitaMrgLayout.setHorizontalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLeitMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addComponent(jTitillEdaLysingMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addComponent(jFilterMrg)
                        .addGap(40, 40, 40)))
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMinMaxPanelMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMinMaxLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addComponent(jSynaKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jInnanKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jEndurstillaMrg))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLeitaMrgLayout.setVerticalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jTitillEdaLysingMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jMinMaxLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLeitMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFilterMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSynaKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jInnanKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jMinMaxPanelMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEndurstillaMrg)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabelDagskraMrg.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelDagskraMrg.setText("Dagskráin á morgun:");

        javax.swing.GroupLayout jDagskraMrgLayout = new javax.swing.GroupLayout(jDagskraMrg);
        jDagskraMrg.setLayout(jDagskraMrgLayout);
        jDagskraMrgLayout.setHorizontalGroup(
            jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraMrgLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDagskraMrg)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jDagskraMrgLayout.setVerticalGroup(
            jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraMrgLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jMinDagskra.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMinDagskraIDag.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jMinDagskraIDag);

        jMinDagskraMrg.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jMinDagskraMrg);

        jLabelMinDagskra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelMinDagskra.setText("Mín dagskrá");

        jLabelIDag.setText("Í dag");

        jLabelMrg.setText("Á morgun");

        javax.swing.GroupLayout jMinDagskraLayout = new javax.swing.GroupLayout(jMinDagskra);
        jMinDagskra.setLayout(jMinDagskraLayout);
        jMinDagskraLayout.setHorizontalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMinDagskraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
            .addGroup(jMinDagskraLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabelIDag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMrg))
                .addGap(141, 141, 141))
        );
        jMinDagskraLayout.setVerticalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMinDagskraLayout.createSequentialGroup()
                .addComponent(jLabelMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jMinDagskraLayout.createSequentialGroup()
                        .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIDag, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMrg))
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jSkoda.setText("Skoða dagskrárlið");
        jSkoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSkodaActionPerformed(evt);
            }
        });

        jFaeraIMina.setText("Bæta dagskrárlið í mína dagskrá");
        jFaeraIMina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFaeraIMinaActionPerformed(evt);
            }
        });

        jEyda.setText("Eyða dagskrárlið");
        jEyda.setFocusable(false);
        jEyda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jEyda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jEyda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEydaActionPerformed(evt);
            }
        });

        jSkraLid.setText("Skrá nýjan lið í mína dagskrá");
        jSkraLid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSkraLidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jTakkaPanelLayout = new javax.swing.GroupLayout(jTakkaPanel);
        jTakkaPanel.setLayout(jTakkaPanelLayout);
        jTakkaPanelLayout.setHorizontalGroup(
            jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTakkaPanelLayout.createSequentialGroup()
                .addGroup(jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jTakkaPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSkoda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTakkaPanelLayout.createSequentialGroup()
                                .addComponent(jEyda, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTakkaPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jFaeraIMina))
                    .addGroup(jTakkaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSkraLid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jTakkaPanelLayout.setVerticalGroup(
            jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTakkaPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jSkoda, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jEyda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jFaeraIMina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSkraLid, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jHeadline.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jHeadline.setText("Dagskrársjá RÚV ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jTakkaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(jHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTakkaPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * velur að eyða dagskrárlið (en ekki bæta við lið)
     * @param evt 
     */
    private void jEydaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEydaActionPerformed
        setEyda(!isEyda());
        setBaetaLid(false);
        skodaLid = false;
    }//GEN-LAST:event_jEydaActionPerformed

    private void jFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFilterActionPerformed

        
        
    }//GEN-LAST:event_jFilterActionPerformed

    private void jFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFilterMouseClicked

    }//GEN-LAST:event_jFilterMouseClicked

    /**
     * filterar listann jDagskrarlidir út frá því sem stendur í jFilter og hvort titill/lýsing hefur verið valin
     * 
     * @param evt 
     */
    private void jFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFilterKeyReleased
        String textiSkrifadur = jFilter.getText();
        filteraDagskrana(textiSkrifadur,false,byTitle);
        
    }//GEN-LAST:event_jFilterKeyReleased
    /**
     * endurstillir dagskrána
     * @param evt 
     */
    private void jEndurstillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEndurstillaActionPerformed
        endurstillaDagskra(false);

    }//GEN-LAST:event_jEndurstillaActionPerformed

    private void jLeitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLeitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLeitActionPerformed

    private void jSynaKlstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSynaKlstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSynaKlstActionPerformed

    private void jFilterMrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFilterMrgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFilterMrgMouseClicked

    private void jFilterMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFilterMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFilterMrgActionPerformed
/**
     * filterar listann jDagskrarlidirMrg út frá því sem stendur í jFilterMrg
     * og hvort titill/lýsing hefur verið valin
     * @param evt 
     */
    private void jFilterMrgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFilterMrgKeyReleased
        String textiSkrifadur = jFilterMrg.getText();
        filteraDagskrana(textiSkrifadur,true,byTitleMrg);
    }//GEN-LAST:event_jFilterMrgKeyReleased

    /**
     * endurstillir dagskrá morgundagsins
     * @param evt 
     */
    private void jEndurstillaMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEndurstillaMrgActionPerformed
        endurstillaDagskra(true);
  
    }//GEN-LAST:event_jEndurstillaMrgActionPerformed

    private void jLeitMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLeitMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLeitMrgActionPerformed

    private void jSynaKlstMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSynaKlstMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSynaKlstMrgActionPerformed

    private void jMinLengdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinLengdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMinLengdTextActionPerformed

    private void jMaxLengdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaxLengdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaxLengdTextActionPerformed
    /**
     * velur að bæta dagskrárlið í mína (en ekki eyða/skoða lið)
     * @param evt 
     */
    private void jFaeraIMinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFaeraIMinaActionPerformed
        setBaetaLid(!isBaetaLid());
        eyda = false;
        skodaLid = false;
    }//GEN-LAST:event_jFaeraIMinaActionPerformed

    private void jTitillEdaLysingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitillEdaLysingActionPerformed

    }//GEN-LAST:event_jTitillEdaLysingActionPerformed
    /**
     * velur að skoða dagskrárlið (en ekki eyða/bæta lið)
     * @param evt 
     */
    private void jSkodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSkodaActionPerformed
       skodaLid = !skodaLid;
       eyda = false;
       baetaLid = false;
    }//GEN-LAST:event_jSkodaActionPerformed

    /**
     * filterar jDagskrarlidir þ.a. bara þeir sem eru lengri en tímalengdin í jMinTime sjást
     * @param evt 
     */
    private void jMinTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinTimeActionPerformed
        //endurstillaDagskra(false);
        String minTime = jMinTime.getText();      
        if(minTime.matches("\\d\\d:\\d\\d" )){

            filteraTimalengd(minTime,false,true);
        }
        
    }//GEN-LAST:event_jMinTimeActionPerformed

    /**
     * filterar jDagskrarlidir þ.a. bara þeir sem eru <= tímalengdin í jMaxTime sjást
     * @param evt 
     */
    private void jMaxTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaxTimeActionPerformed
       // endurstillaDagskra(false);
        String maxTime = jMaxTime.getText();      
        if(maxTime.matches("\\d\\d:\\d\\d" )){

            filteraTimalengd(maxTime,false,false);
        }
    }//GEN-LAST:event_jMaxTimeActionPerformed

    private void jTitillEdaLysingMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitillEdaLysingMrgActionPerformed
        
    }//GEN-LAST:event_jTitillEdaLysingMrgActionPerformed
    /**
     * filterar jDagskrarlidirMrg þ.a. bara þeir sem eru lengri en tímalengdin í jMinTimeMrg sjást
     * @param evt 
     */
    private void jMinTimeMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinTimeMrgActionPerformed
        //endurstillaDagskra(true);
        String minTime = jMinTimeMrg.getText();      
        if(minTime.matches("\\d\\d:\\d\\d" )){            
            filteraTimalengd(minTime,true,true);
        }        
    }//GEN-LAST:event_jMinTimeMrgActionPerformed
    /**
     * filterar jDagskrarlidirMrg þ.a. bara þeir sem eru <= tímalengdin í jMaxTimeMrg sjást
     * @param evt 
     */
    private void jMaxTimeMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaxTimeMrgActionPerformed
       // endurstillaDagskra(false);
        String maxTime = jMaxTimeMrg.getText();      
        if(maxTime.matches("\\d\\d:\\d\\d" )){            
            filteraTimalengd(maxTime,true,false);
        }
    }//GEN-LAST:event_jMaxTimeMrgActionPerformed

    private void jMinLengdTextMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinLengdTextMrgActionPerformed

    }//GEN-LAST:event_jMinLengdTextMrgActionPerformed

    private void jMaxLengdTextMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaxLengdTextMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaxLengdTextMrgActionPerformed

    /**
     * opnar glugga til að skrá nýjan dagskrárlið í Mína Dagskrá
     * @param evt 
     */
    private void jSkraLidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSkraLidActionPerformed
        SkraLidMinDagskra skraningarGluggi = new SkraLidMinDagskra(this,true);
        skraningarGluggi.setVisible(true);
    }//GEN-LAST:event_jSkraLidActionPerformed

    private void jInnanKlstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInnanKlstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jInnanKlstActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(AdalDagskra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdalDagskra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdalDagskra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdalDagskra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdalDagskra().setVisible(true);
            }
        });
    }


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jDagskra;
    private javax.swing.JPanel jDagskraMrg;
    private javax.swing.JList<String> jDagskrarLidir;
    private javax.swing.JList<String> jDagskrarLidirMrg;
    private javax.swing.JButton jEndurstilla;
    private javax.swing.JButton jEndurstillaMrg;
    private javax.swing.JButton jEyda;
    private javax.swing.JButton jFaeraIMina;
    private javax.swing.JTextField jFilter;
    private javax.swing.JTextField jFilterMrg;
    private javax.swing.JLabel jHeadline;
    private javax.swing.JComboBox<String> jInnanKlst;
    private javax.swing.JComboBox<String> jInnanKlstMrg;
    private javax.swing.JLabel jLabelDagskra;
    private javax.swing.JLabel jLabelDagskraMrg;
    private javax.swing.JLabel jLabelIDag;
    private javax.swing.JLabel jLabelMinDagskra;
    private javax.swing.JLabel jLabelMrg;
    private javax.swing.JTextField jLeit;
    private javax.swing.JTextField jLeitMrg;
    private javax.swing.JPanel jLeita;
    private javax.swing.JPanel jLeitaMrg;
    private javax.swing.JTextField jMaxLengdText;
    private javax.swing.JTextField jMaxLengdTextMrg;
    private javax.swing.JTextField jMaxTime;
    private javax.swing.JTextField jMaxTimeMrg;
    private javax.swing.JPanel jMinDagskra;
    private javax.swing.JList<String> jMinDagskraIDag;
    private javax.swing.JList<String> jMinDagskraMrg;
    private javax.swing.JTextField jMinLengdText;
    private javax.swing.JTextField jMinLengdTextMrg;
    private javax.swing.JLabel jMinMaxLabel;
    private javax.swing.JLabel jMinMaxLabel1;
    private javax.swing.JPanel jMinMaxPanel;
    private javax.swing.JPanel jMinMaxPanelMrg;
    private javax.swing.JTextField jMinTime;
    private javax.swing.JTextField jMinTimeMrg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jSkoda;
    private javax.swing.JButton jSkraLid;
    private javax.swing.JTextField jSynaKlst;
    private javax.swing.JTextField jSynaKlstMrg;
    private javax.swing.JPanel jTakkaPanel;
    private javax.swing.JComboBox<String> jTitillEdaLysing;
    private javax.swing.JComboBox<String> jTitillEdaLysingMrg;
    // End of variables declaration//GEN-END:variables
}
