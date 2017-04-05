
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


/**
 * Aðal klasinn. viðmótsglugginn sem birtir dagskrána og býr til og notar hlutina af hinum klösunum
 * @author Valdimar Ágúst Eggertsson vae11@hi.is
 * 
 */
public class AdalDagskra extends javax.swing.JFrame {


    
    /**
     * upprunalegu gögnin sem hlaðið er inn eru geymd í dagskrain
     */ 
    private DagskraKatalogur dagskrain; 
    /**
     * dagskramodel er modelið fyrir jDagskrarLidir
     * ( gögnin eru geymd sem í dagskramodel sem er DefaultListModel )
     */
    private DagskraModel dagskramodel;
         
    /**
     * upprunalegu gögnin sem hlaðið er inn fyrir lista "morgundagsins" eru geymd í dagskrainMrg
     */ 
    private DagskraKatalogur dagskrainMrg; 
    
    
    
    /**
     * dagskramodelMrg er modelið fyrir jDagskrarLidirMrg
     * ( gögnin eru geymd sem í dagskramodelMrg sem er DefaultListModel )
     */
    private DagskraModel dagskramodelMrg;
    
    
    /**
     * ef true þá búið að smella á hnappinn og ekki búið að smella á dagskrárlið til að eyða
     */
    private boolean eyda = false;
    
    /**
     * ef true þá búið að ýta á ok í eyðingar staðfestingarglugga og verið að fara að eyða breytunni
     */
    private boolean stadfestaEyda = false;
    
    
    /**
     * klstmodel er modelið fyrir jInnanKlst
     */
    private DefaultComboBoxModel klstmodel;
    
    /**
     * listener með event handler fyrir comboboxið
     */
    private StyringComboBox styringComboBox;
    
    // getters og setters
    
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
     * Creates new form AdalDagskra
     */
    public AdalDagskra() {
        initComponents();
        
        
        dagskramodel = new DagskraModel();
        dagskrain = new DagskraKatalogur();
        birtaDagskra(dagskrain);
        // titlunum úr dagskrain (upprunal. dagskránni) hefur verið hlaðið í dagskramodel og prentaðir á console
        
        // g.r.f. að dagskrain sé working model
        jDagskrarLidir.setModel(dagskramodel);
        
        jDagskrarLidir.getSelectionModel().addListSelectionListener(new StyringListi(this));        
        // listener hefur verið tengdur við listann 
        
        // listinn fyrir dagskrárliði í dag hefur verið settur upp.
        
        
        // listinn fyrir dagskrárliði á morgun settur upp:
        dagskramodelMrg = new DagskraModel();
        dagskrainMrg = new DagskraKatalogur();   
        for(Root.Results dagskrarlidur : dagskrainMrg.getDagskrarLidir()){
            dagskramodelMrg.addElement(dagskrarlidur.getTitle());
        }
        // titlunum úr dagskrá morgundagsins hefur verið bætt í dagskraModelMrg

        // dagskramodelMrg.setDagskrain(dagskrainMrg);        
        jDagskrarLidirMrg.setModel(dagskramodelMrg);
        
        
        
        
        // geri gögn til að hlaða inn inn í ComboBoxið
        String[] klukkustundir = new String[24-17+1];
        int j = 0; 
        for(int i = 17; i<24; i++)
        {
            //System.out.println(String.valueOf(i));
            klukkustundir[j++] = String.valueOf(i);
        }
        klukkustundir[j] = "00";
        

        klstmodel = new DefaultComboBoxModel(klukkustundir);
 
        // set gögn í jInnanKlst
        jInnanKlst.setModel(klstmodel);
     
        styringComboBox = new StyringComboBox(this);
        // tengi listener við jInnanKlst
        jInnanKlst.addActionListener(styringComboBox);
        
  
        
    }

     /**
     * setur titlana úr dagskra í dagskramodel og birtir á console 
     * @param dagskra 

     */
    private void birtaDagskra(DagskraKatalogur dagskra){

        
        for(Root.Results dagskrarlidur : getDagskrain().getDagskrarLidir()){
            getDagskramodel().addElement(dagskrarlidur.getTitle());
            System.out.println(getDagskramodel().lastElement());
            System.out.println(dagskrarlidur.getStartTime());
            System.out.println(dagskrarlidur.getDuration());
            System.out.println(dagskrarlidur.getDescription());
            System.out.println(dagskrarlidur.getLive());          
            System.out.println(dagskrarlidur.getSeries() + "\n");
            
        }
    }
    
    /**
     * Eyðir  dagskrárlið nr lidurNr úr dagskramodel
     * @param lidurNr indexið á liðinn í listanum
     */
    public void eydaDagskrarLid(int lidurNr){
        //System.out.println(lidurNr);
         dagskramodel.remove(lidurNr);
         // þetta eyðir ekki almennilega úr gögnunum
         List<Root.Results> dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();
         dagskrarLidir.remove(lidurNr);
         // nú er búið að eyða almennilega úr gögnunum
  
    }
    /**
     * Breytir modelinu fyrir jDagskrarLidir þannig að bara dagskrárliðir sem innihalda leitarord sem substring eru eftir
     * @param leitarord strengurinn sem leitað er eftir
     */
     public void filteraDagskrana(String leitarord){
        
        if(leitarord.equals("")){
            // sýnum allt sem inniheldur tóma strenginn 
            // þ.e. sýnum allt, svo við endurstillum módelið fyrir dagskrárlistann
           endurstillaDagskra();
        }else{
            List<Root.Results> dagskrarLidir = dagskramodel.getDagskrain().getDagskrarLidir();


            int fjoldiStakaIListanum = dagskrarLidir.size();
            int lidurNr = 0;
            while(lidurNr < fjoldiStakaIListanum){
                // dagskrárliðir úr sætum 0 upp í lidurNr-1 innihalda leitarord
                // það eru fjoldiStakaIListanum stök í jDagskrarLidir
                String dagskrarlidur = dagskrarLidir.get(lidurNr).getTitle();

                if(dagskrarlidur.contains(leitarord)){
                    // dagskrárliðurinn uppfyllir leitarskilyrðin
                    lidurNr++;
                }else{
                    // dagskrárliðurinn uppfyllir ekki leitarskilyrðin, hendum honum
                    eydaDagskrarLid(lidurNr);
                    fjoldiStakaIListanum--;
                }

            }
        } 
        
        
        
    }
   /**
    * endurstillir dagskrána þannig að allir dagskrárliðir eru inni
    * 
    */
    public void endurstillaDagskra(){
            dagskramodel = new DagskraModel();            
            jDagskrarLidir.setModel(dagskramodel);
            birtaDagskra(dagskrain);  
    }
    
    /**
     * breytir modelinu fyrir jDagskrarLidir þ.a. bara dagskrárliðir sem hefjast á klukkutímanum klst, t.d. milli 17 og 18 eru eftir
     * @param klst strengur sem táknar klst t.d. "17" eða "23" eða "00"
     */ 
    public void filterEftirKlst(String klst){
        
        endurstillaDagskra();
        filteraDagskrana(jFilter.getText());
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
                eydaDagskrarLid(lidurNr);
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jEyda = new javax.swing.JButton();
        jMinDagskra = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMinDagskraIDag = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jMinDagskraMrg = new javax.swing.JList<>();
        jTextIDag = new javax.swing.JTextField();
        jTextMrg = new javax.swing.JTextField();
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
        jSkraLid = new javax.swing.JButton();
        jEydaLid = new javax.swing.JButton();
        jFaeraIMina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jEyda.setText("Eyða ");
        jEyda.setFocusable(false);
        jEyda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jEyda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jEyda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEydaActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jMinDagskraLayout = new javax.swing.GroupLayout(jMinDagskra);
        jMinDagskra.setLayout(jMinDagskraLayout);
        jMinDagskraLayout.setHorizontalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMinDagskraLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextIDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(112, 112, 112))
        );
        jMinDagskraLayout.setVerticalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMinDagskraLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextIDag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jTextMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

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

        javax.swing.GroupLayout jLeitaLayout = new javax.swing.GroupLayout(jLeita);
        jLeita.setLayout(jLeitaLayout);
        jLeitaLayout.setHorizontalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jEndurstilla))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jTitillEdaLysing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jLeitaLayout.setVerticalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTitillEdaLysing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jEndurstilla)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDagskraLayout = new javax.swing.GroupLayout(jDagskra);
        jDagskra.setLayout(jDagskraLayout);
        jDagskraLayout.setHorizontalGroup(
            jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jDagskraLayout.setVerticalGroup(
            jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDagskraLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jLeitaMrgLayout = new javax.swing.GroupLayout(jLeitaMrg);
        jLeitaMrg.setLayout(jLeitaMrgLayout);
        jLeitaMrgLayout.setHorizontalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(jEndurstillaMrg))
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
                                .addGap(3, 3, 3)
                                .addComponent(jLeitMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFilterMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTitillEdaLysingMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLeitaMrgLayout.setVerticalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFilterMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeitMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTitillEdaLysingMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSynaKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jInnanKlstMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEndurstillaMrg)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDagskraMrgLayout = new javax.swing.GroupLayout(jDagskraMrg);
        jDagskraMrg.setLayout(jDagskraMrgLayout);
        jDagskraMrgLayout.setHorizontalGroup(
            jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraMrgLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jDagskraMrgLayout.setVerticalGroup(
            jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDagskraMrgLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jDagskraMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jSkraLid.setText("Skrá nýjan lið í mína dagskrá");

        jEydaLid.setText("Eyða lið úr minni dagskrá");

        jFaeraIMina.setText("Bæta dagskrárlið í mína dagskrá");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(jDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jFaeraIMina))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jEyda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEydaLid)
                    .addComponent(jSkraLid))
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDagskraMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSkraLid)
                    .addComponent(jFaeraIMina))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jEydaLid))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jEyda)))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEydaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEydaActionPerformed
        setEyda(true);
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
        filteraDagskrana(textiSkrifadur);
        
    }//GEN-LAST:event_jFilterKeyReleased

    private void jEndurstillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEndurstillaActionPerformed
        endurstillaDagskra();
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
    private javax.swing.JTextField jLeit;
    private javax.swing.JTextField jLeitMrg;
    private javax.swing.JPanel jLeita;
    private javax.swing.JPanel jLeitaMrg;
    private javax.swing.JPanel jMinDagskra;
    private javax.swing.JList<String> jMinDagskraIDag;
    private javax.swing.JList<String> jMinDagskraMrg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jSkraLid;
    private javax.swing.JTextField jSynaKlst;
    private javax.swing.JTextField jSynaKlstMrg;
    private javax.swing.JTextField jTextIDag;
    private javax.swing.JTextField jTextMrg;
    private javax.swing.JComboBox<String> jTitillEdaLysing;
    private javax.swing.JComboBox<String> jTitillEdaLysingMrg;
    // End of variables declaration//GEN-END:variables
}
