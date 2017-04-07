
package is.hi.dagskra.vidmot;

import is.hi.dagskra.gogn.DagskraModel;
import is.hi.dagskra.vinnsla.DagskraKatalogur;
import is.hi.dagskra.gogn.Root;
import is.hi.dagskra.gogn.KlukkustundirModel;
import is.hi.dagskra.styring.*;

import javax.swing.JList;
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

import java.util.Collections;


/**
 * Aðal klasinn. viðmótsglugginn sem birtir dagskrána og býr til og notar hlutina af hinum klösunum
 * @author Valdimar Ágúst Eggertsson vae11@hi.is
 * 
 */
public class AdalDagskra extends javax.swing.JFrame {

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
     * upprunalegu gögnin sem hlaðið er inn eru geymd í dagskrain
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
     * hvort leitað sé eftir titli eða ekki 
     */
    private boolean byTitle = true;
   
    /**
     * hvort leitað sé eftir titli í dagskrá morgundagsins eða ekki 
     */
    private boolean byTitleMrg = true;
   
    
    /**
     * klstmodel er modelið fyrir jInnanKlst
     */
    private DefaultComboBoxModel klstmodel;
    
    /**
     * modelið fyrir jTitillEdaLysing
     */
    private DefaultComboBoxModel titillEdaLysingModel;

    /**
     * modelið fyrir jTitillEdaLysingMrg
     */
    private DefaultComboBoxModel titillEdaLysingModelMrg;
    
    
    /**
     * listener með event handler fyrir comboboxið
     */
    private StyringComboBox styringComboBox;

    /**
     * listener með event handler fyrir jTitillEdaLysing 
     */
    private StyringComboBoxTitillEdaLysing styringComboBoxTitillEdaLysing;

        /**
     * listener með event handler fyrir jTitillEdaLysingMrg
     */
    private StyringComboBoxTitillEdaLysing styringComboBoxTitillEdaLysingMrg;
  
    
    // getters og setters
    
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
     * Creates new form AdalDagskra
     */
    public AdalDagskra() {
        initComponents();
        
        
        dagskramodel = new DagskraModel(false);
        dagskrain = new DagskraKatalogur(false);
        baetaDagskra(dagskrain);
        // titlunum úr dagskrain (upprunal. dagskránni) hefur verið hlaðið í dagskramodel
        jDagskrarLidir.setModel(dagskramodel);
        jDagskrarLidir.getSelectionModel().addListSelectionListener(new StyringListi(this, false));        
        // listener hefur verið tengdur við listann 
        
        // listinn fyrir dagskrárliði í dag hefur verið settur upp.
        
        // set upp gögn fyrir leitina fyrir daginn í dag:     
        setjaUppLeitina(false);
        // ComboBoxið fyrir klukkustundirnar hefur verið sett upp

          
        // listinn fyrir dagskrárliði á morgun settur upp:
        dagskramodelMrg = new DagskraModel(true);
        dagskrainMrg = new DagskraKatalogur(true);   
        for(Root.Results dagskrarlidur : dagskrainMrg.getDagskrarLidir()){
            
            dagskramodelMrg.addElement(dagskrarlidur.getStartTime().substring(11,16) + "  " + dagskrarlidur.getTitle());
        }
        // titlunum úr dagskrá morgundagsins hefur verið bætt í dagskraModelMrg

        // dagskramodelMrg.setDagskrain(dagskrainMrg);        
        jDagskrarLidirMrg.setModel(dagskramodelMrg);
        
        jDagskrarLidirMrg.getSelectionModel().addListSelectionListener(new StyringListi(this,true));        
        
        setjaUppLeitina(false);
        // leitin hefur verið sett upp fyrir dagskrárnar
        
        
        // set upp gögn fyrir Mína Dagskrá
        dagskramodelMinIDag = new DagskraModel(false);
       jMinDagskraIDag.setModel(dagskramodelMinIDag);
    
        dagskramodelMinMrg = new DagskraModel(true);
        jMinDagskraMrg.setModel(dagskramodelMinMrg);

        
        
    }
    /**
     * raðar Minni Dagskrá í stafrófsröð, annað hvort í dag eða á morgun   
     */
    public void sortDagskra(boolean aMorgun){
        if(aMorgun){
            ArrayList list = Collections.list(dagskramodelMinMrg.elements());
            System.out.println(list);
            Collections.sort(list);
            // hreinsa módelið 
            dagskramodelMinMrg.clear();
            // bæti aftur í módelið 
            for(Object lidur : list){
                dagskramodelMinMrg.addElement(lidur);
            }         
        }else{
            ArrayList list = Collections.list(dagskramodelMinIDag.elements());
            System.out.println(list);
            Collections.sort(list);
            // hreinsa módelið 
            dagskramodelMinIDag.clear();
            // bæti aftur í módelið 
            for(Object lidur : list){
                dagskramodelMinIDag.addElement(lidur);
            }
        }
    }
    /**
     * bætir dagskrárlið númer index (í tímaröð dagskránnar) í Mína Dagskrá í viðmótinu og 
     * @param index  0 <= index < fjöldi dagskrárliða í dag (eða á morgun)
     * @param aMorgun satt ef dagskrárliðurinn er í dagskrá morgundagsins, false ef í dag 
     */
    public void baetaLidVidMina(int index, boolean aMorgun){
        if(aMorgun){
             Root.Results lidurTilAdBirta = dagskramodelMinMrg.getDagskrain().getDagskrarLidir().get(index);
            String textiTilAdBirta = lidurTilAdBirta.getStartTime().substring(11,16) + "  " + lidurTilAdBirta.getTitle();
            dagskramodelMinMrg.addElement(textiTilAdBirta);
        }else{
            Root.Results lidurTilAdBirta = dagskramodelMinIDag.getDagskrain().getDagskrarLidir().get(index);
            String textiTilAdBirta = lidurTilAdBirta.getStartTime().substring(11,16) + "  " + lidurTilAdBirta.getTitle();
            dagskramodelMinIDag.addElement(textiTilAdBirta);
        }
    }
     /**
     * setur titlana úr dagskra í dagskramodel 
     * @param dagskra 

     */
    private void baetaDagskra(DagskraKatalogur dagskra){

        for(Root.Results dagskrarlidur : getDagskrain().getDagskrarLidir()){
            dagskramodel.addElement(dagskrarlidur.getStartTime().substring(11,16) + "  " + dagskrarlidur.getTitle());

        }
    }
    
    
    
    
    /**
     * Eyðir  dagskrárlið nr lidurNr úr dagskramodel eða dagskramodelMrg
     * @param lidurNr indexið á liðinn í listanum 
     * @param aMorgun ef true, þá eyðir á morgun, annars í dag
     */
    public void eydaDagskrarLid(int lidurNr, boolean aMorgun){
        if(aMorgun){
            getDagskramodelMrg().remove(lidurNr);
            // þetta eyðir ekki almennilega úr gögnunum
            List<Root.Results> dagskrarLidir = getDagskramodelMrg().getDagskrain().getDagskrarLidir();
            dagskrarLidir.remove(lidurNr);
            // nú er búið að eyða almennilega úr gögnunum
        }else{
            dagskramodel.remove(lidurNr);
            // þetta eyðir ekki almennilega úr gögnunum
            List<Root.Results> dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();
            dagskrarLidir.remove(lidurNr);
            // nú er búið að eyða almennilega úr gögnunum
        }
    }
    /**
     * Breytir modelinu fyrir jDagskrarLidir (eða jDagskrarLidirMrg) þannig að bara dagskrárliðir hafa leitarord sem substring eru eftir
     * @param leitarord strengurinn sem leitað er eftir 
     * @param aMorgun true ef leita á í jDagskrarLidirMrg, annars false
     * @param eftirTitli ef true þá leitað í titli, ef false þá leitað í lýsingu
     */
     public void filteraDagskrana(String leitarord, boolean aMorgun, boolean eftirTitli){
        
        if(leitarord.equals("")){
            // sýnum allt sem inniheldur tóma strenginn 
            // þ.e. sýnum allt, svo við endurstillum módelið fyrir dagskrárlistann
           endurstillaDagskra(aMorgun);
        }else{
            List<Root.Results> dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();


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
                if(dagskrarlidur.contains(leitarord)){
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
    * endurstillir dagskrána þannig að allir dagskrárliðir eru inni
    * 
    */
    public void endurstillaDagskra(boolean aMorgun){
            if(aMorgun){
                setDagskramodelMrg(new DagskraModel(true));
                dagskrainMrg = new DagskraKatalogur(true);   
                for(Root.Results dagskrarlidur : dagskrainMrg.getDagskrarLidir()){
                    getDagskramodelMrg().addElement(dagskrarlidur.getTitle());
                }
                // titlunum úr dagskrá morgundagsins hefur verið bætt í dagskraModelMrg

            }else{
                dagskramodel = new DagskraModel(aMorgun);            
                jDagskrarLidir.setModel(dagskramodel);
                baetaDagskra(dagskrain);  
            }
            
    }
    
    /**
     * Setur upp gögn fyrir leitina í annað hvort dagskrána í dag eða áMorgun
     * @param aMorgun 
     */
    private void setjaUppLeitina(boolean aMorgun){

        // geri gögn til að hlaða inn inn í ComboBoxið fyrir klukkustundirnar
        String[] klukkustundir = new String[24-17+1];
        int j = 0; 
        for(int i = 17; i<24; i++)
        {

            klukkustundir[j++] = String.valueOf(i);
        }
        klukkustundir[j] = "00";        
        
      
        if(aMorgun){
            // sama og í hinu nema önnur nöfn á breytum 
            
        }else{
              // set upp combobox fyrir klukkustundirnar:
            klstmodel = new DefaultComboBoxModel(klukkustundir);
            // set gögn í jInnanKlst
            jInnanKlst.setModel(klstmodel);

          //  styringComboBox = new StyringComboBox(this, false);
            // tengi listener við jInnanKlst
            //jInnanKlst.addActionListener(styringComboBox);
            
            // set upp combobox fyrir titill/lýsing         
            String[] titillEdaLysing =new String[] {"Titill inniheldur...", "Lýsing inniheldur..."};
            titillEdaLysingModel = new DefaultComboBoxModel(titillEdaLysing);
            jTitillEdaLysing.setModel(titillEdaLysingModel);
        
            styringComboBoxTitillEdaLysing =  new StyringComboBoxTitillEdaLysing(this, aMorgun);
            jTitillEdaLysing.addActionListener(styringComboBoxTitillEdaLysing);
            
            // set upp spinnerinn
            
            //minSpinnerModel
        }
        
        
        
    }
    
    
    /**
     * breytir modelinu fyrir jDagskrarLidir (eða jDagskrarLidirMrg) þ.a. bara dagskrárliðir sem hefjast á klukkutímanum klst, t.d. milli 17 og 18 eru eftir
     * @param klst strengur sem táknar klst t.d. "17" eða "23" eða "00"
      * @param aMorgun true ef leita á í jDagskrarLidirMrg, annars false
     */ 
    public void filterEftirKlst(String klst, boolean aMorgun){
        
        endurstillaDagskra(aMorgun);
        filteraDagskrana(jFilter.getText(), aMorgun, byTitle);
        // dagskráin hefur verið endurstillt til að geta filterað aftur
        //   ef ske kynni að það hafi þegar verið filterað
        
        List<Root.Results> dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();
       
        int fjoldiStakaIListanum = dagskrarLidir.size();
        int lidurNr = 0;
        while(lidurNr < fjoldiStakaIListanum){
            // dagskrárliðir úr sætum 0 upp í lidurNr-1 eru á klukkutímanum klst
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
        if(startTime.substring(11,13).equals(klst)){
            return true;
        }else{
            return false;
        }
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
        jMaxLengd = new javax.swing.JSpinner();
        jMinLengd = new javax.swing.JSpinner();
        jMaxLengdTextMrg1 = new javax.swing.JTextField();
        jMinLengdTextMrg1 = new javax.swing.JTextField();
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
        jMaxLengdMrg = new javax.swing.JSpinner();
        jMinLengdMrg = new javax.swing.JSpinner();
        jMinLengdTextMrg = new javax.swing.JTextField();
        jMaxLengdTextMrg = new javax.swing.JTextField();
        jLabelDagskraMrg = new javax.swing.JLabel();
        jMinDagskra = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMinDagskraIDag = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jMinDagskraMrg = new javax.swing.JList<>();
        jTextIDag = new javax.swing.JTextField();
        jTextMrg = new javax.swing.JTextField();
        jLabelMinDagskra = new javax.swing.JLabel();
        jSkraLid = new javax.swing.JButton();
        jEydaLid = new javax.swing.JButton();
        jTakkaPanel = new javax.swing.JPanel();
        jSkoda = new javax.swing.JButton();
        jFaeraIMina = new javax.swing.JButton();
        jEyda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1256, 1600));
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

        jMaxLengdTextMrg1.setText("max:");
        jMaxLengdTextMrg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaxLengdTextMrg1ActionPerformed(evt);
            }
        });

        jMinLengdTextMrg1.setText("min:");
        jMinLengdTextMrg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinLengdTextMrg1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jMinMaxPanelLayout = new javax.swing.GroupLayout(jMinMaxPanel);
        jMinMaxPanel.setLayout(jMinMaxPanelLayout);
        jMinMaxPanelLayout.setHorizontalGroup(
            jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMinMaxPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jMinMaxPanelLayout.createSequentialGroup()
                        .addComponent(jMaxLengdTextMrg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMaxLengd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jMinMaxPanelLayout.createSequentialGroup()
                        .addComponent(jMinLengdTextMrg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jMinLengd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jMinMaxPanelLayout.setVerticalGroup(
            jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMinMaxPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMinLengd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMinLengdTextMrg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jMinMaxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMaxLengd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMaxLengdTextMrg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMinMaxLabel.setText("Tímalengd:");

        javax.swing.GroupLayout jLeitaLayout = new javax.swing.GroupLayout(jLeita);
        jLeita.setLayout(jLeitaLayout);
        jLeitaLayout.setHorizontalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jEndurstilla))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitillEdaLysing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMinMaxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMinMaxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jLeitaLayout.setVerticalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTitillEdaLysing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMinMaxLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jEndurstilla)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jMinMaxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelDagskra.setText("Dagskráin í dag:");

        javax.swing.GroupLayout jDagskraLayout = new javax.swing.GroupLayout(jDagskra);
        jDagskra.setLayout(jDagskraLayout);
        jDagskraLayout.setHorizontalGroup(
            jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jDagskraLayout.setVerticalGroup(
            jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
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

        jMinLengdMrg.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jMinLengdMrgStateChanged(evt);
            }
        });

        jMinLengdTextMrg.setText("jTextField1");
        jMinLengdTextMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinLengdTextMrgActionPerformed(evt);
            }
        });

        jMaxLengdTextMrg.setText("jTextField1");
        jMaxLengdTextMrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaxLengdTextMrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLeitaMrgLayout = new javax.swing.GroupLayout(jLeitaMrg);
        jLeitaMrg.setLayout(jLeitaMrgLayout);
        jLeitaMrgLayout.setHorizontalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jInnanKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSynaKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTitillEdaLysingMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                .addComponent(jMaxLengdTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMaxLengdMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                .addComponent(jMinLengdTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMinLengdMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLeitMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFilterMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jEndurstillaMrg)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLeitaMrgLayout.setVerticalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFilterMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeitMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTitillEdaLysingMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jSynaKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jInnanKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMinLengdMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMinLengdTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jMaxLengdMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMaxLengdTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jEndurstillaMrg)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabelDagskraMrg.setText("Dagskráin á morgun:");

        javax.swing.GroupLayout jDagskraMrgLayout = new javax.swing.GroupLayout(jDagskraMrg);
        jDagskraMrg.setLayout(jDagskraMrgLayout);
        jDagskraMrgLayout.setHorizontalGroup(
            jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDagskraMrgLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
            .addGroup(jDagskraMrgLayout.createSequentialGroup()
                .addGroup(jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDagskraMrgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDagskraMrg))
                    .addGroup(jDagskraMrgLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDagskraMrgLayout.setVerticalGroup(
            jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraMrgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
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

        jTextIDag.setEditable(false);
        jTextIDag.setText("Í dag:");

        jTextMrg.setEditable(false);
        jTextMrg.setText("Á morgun:");

        jLabelMinDagskra.setText("Mín dagskrá");

        jSkraLid.setText("Skrá nýjan lið í mína dagskrá");

        jEydaLid.setText("Eyða lið úr minni dagskrá");

        javax.swing.GroupLayout jMinDagskraLayout = new javax.swing.GroupLayout(jMinDagskra);
        jMinDagskra.setLayout(jMinDagskraLayout);
        jMinDagskraLayout.setHorizontalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMinDagskraLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextIDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextMrg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
            .addGroup(jMinDagskraLayout.createSequentialGroup()
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jMinDagskraLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabelMinDagskra))
                    .addGroup(jMinDagskraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSkraLid)
                        .addGap(18, 18, 18)
                        .addComponent(jEydaLid)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jMinDagskraLayout.setVerticalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMinDagskraLayout.createSequentialGroup()
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSkraLid)
                    .addComponent(jEydaLid))
                .addGap(7, 7, 7)
                .addComponent(jLabelMinDagskra)
                .addGap(17, 17, 17)
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jMinDagskraLayout.createSequentialGroup()
                        .addComponent(jTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jMinDagskraLayout.createSequentialGroup()
                        .addComponent(jTextIDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jTakkaPanelLayout = new javax.swing.GroupLayout(jTakkaPanel);
        jTakkaPanel.setLayout(jTakkaPanelLayout);
        jTakkaPanelLayout.setHorizontalGroup(
            jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTakkaPanelLayout.createSequentialGroup()
                .addGroup(jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jFaeraIMina, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jTakkaPanelLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jSkoda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jTakkaPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jEyda, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jTakkaPanelLayout.setVerticalGroup(
            jTakkaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTakkaPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jSkoda, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jFaeraIMina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jEyda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jTakkaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(jDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTakkaPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addComponent(jDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEydaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEydaActionPerformed
        setEyda(true);
        setBaetaLid(false);
    }//GEN-LAST:event_jEydaActionPerformed

    private void jFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFilterActionPerformed

        
        
    }//GEN-LAST:event_jFilterActionPerformed

    private void jFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFilterMouseClicked
      //  System.out.println("\n clicked \n");
    }//GEN-LAST:event_jFilterMouseClicked

    /**
     * filterar listann jDagskrarlidir út frá því sem stendur í jFilter
     * 
     * @param evt 
     */
    private void jFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFilterKeyReleased
        String textiSkrifadur = jFilter.getText();
        filteraDagskrana(textiSkrifadur,false,byTitle);
        
    }//GEN-LAST:event_jFilterKeyReleased

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

    private void jFilterMrgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFilterMrgKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jFilterMrgKeyReleased

    private void jEndurstillaMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEndurstillaMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEndurstillaMrgActionPerformed

    private void jLeitMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLeitMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLeitMrgActionPerformed

    private void jSynaKlstMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSynaKlstMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSynaKlstMrgActionPerformed

    private void jMinLengdTextMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinLengdTextMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMinLengdTextMrgActionPerformed

    private void jMaxLengdTextMrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaxLengdTextMrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaxLengdTextMrgActionPerformed

    private void jMinLengdTextMrg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinLengdTextMrg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMinLengdTextMrg1ActionPerformed

    private void jMaxLengdTextMrg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaxLengdTextMrg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaxLengdTextMrg1ActionPerformed

    private void jFaeraIMinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFaeraIMinaActionPerformed
        setBaetaLid(!isBaetaLid());
        eyda = false;
    }//GEN-LAST:event_jFaeraIMinaActionPerformed

    private void jTitillEdaLysingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitillEdaLysingActionPerformed

    }//GEN-LAST:event_jTitillEdaLysingActionPerformed

    private void jSkodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSkodaActionPerformed
       skodaLid = true;
    }//GEN-LAST:event_jSkodaActionPerformed

    private void jMinLengdMrgStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMinLengdMrgStateChanged
        System.out.println(evt.getSource());
    }//GEN-LAST:event_jMinLengdMrgStateChanged

    
    
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
    private javax.swing.JButton jEydaLid;
    private javax.swing.JButton jFaeraIMina;
    private javax.swing.JTextField jFilter;
    private javax.swing.JTextField jFilterMrg;
    private javax.swing.JComboBox<String> jInnanKlst;
    private javax.swing.JComboBox<String> jInnanKlstMrg;
    private javax.swing.JLabel jLabelDagskra;
    private javax.swing.JLabel jLabelDagskraMrg;
    private javax.swing.JLabel jLabelMinDagskra;
    private javax.swing.JTextField jLeit;
    private javax.swing.JTextField jLeitMrg;
    private javax.swing.JPanel jLeita;
    private javax.swing.JPanel jLeitaMrg;
    private javax.swing.JSpinner jMaxLengd;
    private javax.swing.JSpinner jMaxLengdMrg;
    private javax.swing.JTextField jMaxLengdTextMrg;
    private javax.swing.JTextField jMaxLengdTextMrg1;
    private javax.swing.JPanel jMinDagskra;
    private javax.swing.JList<String> jMinDagskraIDag;
    private javax.swing.JList<String> jMinDagskraMrg;
    private javax.swing.JSpinner jMinLengd;
    private javax.swing.JSpinner jMinLengdMrg;
    private javax.swing.JTextField jMinLengdTextMrg;
    private javax.swing.JTextField jMinLengdTextMrg1;
    private javax.swing.JLabel jMinMaxLabel;
    private javax.swing.JPanel jMinMaxPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jSkoda;
    private javax.swing.JButton jSkraLid;
    private javax.swing.JTextField jSynaKlst;
    private javax.swing.JTextField jSynaKlstMrg;
    private javax.swing.JPanel jTakkaPanel;
    private javax.swing.JTextField jTextIDag;
    private javax.swing.JTextField jTextMrg;
    private javax.swing.JComboBox<String> jTitillEdaLysing;
    private javax.swing.JComboBox<String> jTitillEdaLysingMrg;
    // End of variables declaration//GEN-END:variables
}
