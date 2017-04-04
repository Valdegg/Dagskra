
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
     * gögnin eru geymd sem DefaultListModel í dagskramodel
     */
    private DagskraModel dagskramodel;
    
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDagskrarLidir = new javax.swing.JList<>();
        jToolBar1 = new javax.swing.JToolBar();
        jLeita = new javax.swing.JPanel();
        jFilter = new javax.swing.JTextField();
        jInnanKlst = new javax.swing.JComboBox<>();
        jEndurstilla = new javax.swing.JButton();
        jLeit = new javax.swing.JTextField();
        jSynaKlst = new javax.swing.JTextField();
        jEyda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDagskrarLidirMrg = new javax.swing.JList<>();
        jLeitaMrg = new javax.swing.JPanel();
        jFilter1 = new javax.swing.JTextField();
        jInnanKlst1 = new javax.swing.JComboBox<>();
        jEndurstilla1 = new javax.swing.JButton();
        jLeit1 = new javax.swing.JTextField();
        jSynaKlst1 = new javax.swing.JTextField();
        jTitillEdaLysing = new javax.swing.JToggleButton();
        jMinDagskra = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDagskrarLidir.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jDagskrarLidir);

        jToolBar1.setRollover(true);

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

        javax.swing.GroupLayout jLeitaLayout = new javax.swing.GroupLayout(jLeita);
        jLeita.setLayout(jLeitaLayout);
        jLeitaLayout.setHorizontalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jEndurstilla))
                    .addGroup(jLeitaLayout.createSequentialGroup()
                        .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLeitaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLeitaLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLeitaLayout.createSequentialGroup()
                                .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLeitaLayout.setVerticalGroup(
            jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSynaKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jInnanKlst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEndurstilla)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jEyda.setText("Eyða ");
        jEyda.setFocusable(false);
        jEyda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jEyda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jEyda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEydaActionPerformed(evt);
            }
        });

        jDagskrarLidirMrg.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jDagskrarLidirMrg);

        jFilter1.setToolTipText("");
        jFilter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFilter1MouseClicked(evt);
            }
        });
        jFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFilter1ActionPerformed(evt);
            }
        });
        jFilter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFilter1KeyReleased(evt);
            }
        });

        jInnanKlst1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jEndurstilla1.setText("Sjá alla dagskrárliði");
        jEndurstilla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEndurstilla1ActionPerformed(evt);
            }
        });

        jLeit1.setEditable(false);
        jLeit1.setText("Leita:");
        jLeit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLeit1ActionPerformed(evt);
            }
        });

        jSynaKlst1.setEditable(false);
        jSynaKlst1.setText(bundle.getString("thaettirKlukkan")); // NOI18N
        jSynaKlst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSynaKlst1ActionPerformed(evt);
            }
        });

        jTitillEdaLysing.setText("jToggleButton1");
        jTitillEdaLysing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitillEdaLysingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLeitaMrgLayout = new javax.swing.GroupLayout(jLeitaMrg);
        jLeitaMrg.setLayout(jLeitaMrgLayout);
        jLeitaMrgLayout.setHorizontalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jEndurstilla1))
                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                        .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jInnanKlst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSynaKlst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTitillEdaLysing)
                                .addGroup(jLeitaMrgLayout.createSequentialGroup()
                                    .addComponent(jLeit1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLeitaMrgLayout.setVerticalGroup(
            jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitaMrgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeitaMrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLeit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTitillEdaLysing)
                .addGap(29, 29, 29)
                .addComponent(jSynaKlst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jInnanKlst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEndurstilla1)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jMinDagskraLayout = new javax.swing.GroupLayout(jMinDagskra);
        jMinDagskra.setLayout(jMinDagskraLayout);
        jMinDagskraLayout.setHorizontalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );
        jMinDagskraLayout.setVerticalGroup(
            jMinDagskraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jEyda))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLeita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jMinDagskra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLeitaMrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addComponent(jEyda)
                .addGap(23, 23, 23))
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

    private void jFilter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFilter1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFilter1MouseClicked

    private void jFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFilter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFilter1ActionPerformed

    private void jFilter1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFilter1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jFilter1KeyReleased

    private void jEndurstilla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEndurstilla1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEndurstilla1ActionPerformed

    private void jLeit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLeit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLeit1ActionPerformed

    private void jSynaKlst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSynaKlst1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSynaKlst1ActionPerformed

    private void jTitillEdaLysingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitillEdaLysingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTitillEdaLysingActionPerformed

    
    
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
    private javax.swing.JList<String> jDagskrarLidir;
    private javax.swing.JList<String> jDagskrarLidirMrg;
    private javax.swing.JButton jEndurstilla;
    private javax.swing.JButton jEndurstilla1;
    private javax.swing.JButton jEyda;
    private javax.swing.JTextField jFilter;
    private javax.swing.JTextField jFilter1;
    private javax.swing.JComboBox<String> jInnanKlst;
    private javax.swing.JComboBox<String> jInnanKlst1;
    private javax.swing.JTextField jLeit;
    private javax.swing.JTextField jLeit1;
    private javax.swing.JPanel jLeita;
    private javax.swing.JPanel jLeitaMrg;
    private javax.swing.JPanel jMinDagskra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jSynaKlst;
    private javax.swing.JTextField jSynaKlst1;
    private javax.swing.JToggleButton jTitillEdaLysing;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
