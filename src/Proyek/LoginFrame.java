package Proyek;

import static Proyek.newPlayerName.namaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    
    static int mode; //1 = easy ; 2 = medium ; 3 = hard
    static AudioInputStream audioInputStream;
    static Clip clip;
    static boolean soundOn;
    public LoginFrame() {
        this.setResizable(false);
        this.soundOn = false;
        try {
            initComponents();
            audioInputStream = AudioSystem.getAudioInputStream(new File("sound.wav"));
            clip = AudioSystem.getClip( );
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setButtonSound(btnSound);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel1 = new Proyek.LoginPanel();
        btnStart = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnSound = new javax.swing.JButton();
        cbMode = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        btnStart.setBackground(java.awt.SystemColor.windowBorder);
        btnStart.setText("Start Game");
        btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStartMouseClicked(evt);
            }
        });

        btnLoad.setBackground(java.awt.SystemColor.windowBorder);
        btnLoad.setText("Load Game");
        btnLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadMouseClicked(evt);
            }
        });

        btnSound.setText("Sound");
        btnSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSoundMouseClicked(evt);
            }
        });

        cbMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Medium", "Hard" }));

        javax.swing.GroupLayout loginPanel1Layout = new javax.swing.GroupLayout(loginPanel1);
        loginPanel1.setLayout(loginPanel1Layout);
        loginPanel1Layout.setHorizontalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSound, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        loginPanel1Layout.setVerticalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanel1Layout.createSequentialGroup()
                .addContainerGap(307, Short.MAX_VALUE)
                .addComponent(cbMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btnSound))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSoundMouseClicked
        soundOn = !soundOn;
        setButtonSound(btnSound);
    }//GEN-LAST:event_btnSoundMouseClicked

    private void btnStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartMouseClicked
        // TODO add your handling code here:
        switch (cbMode.getSelectedIndex()) {
            case 0:
                mode = 1;
                break;
            case 1:
                mode = 2;
                break;
            case 2:
                mode = 3;
                break;
            default:
                break;
        }
        
        this.setVisible(false);
        newPlayerName f_playername = new newPlayerName();
        f_playername.setLocationRelativeTo(null);
        f_playername.setVisible(true);
    }//GEN-LAST:event_btnStartMouseClicked

    private void btnLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMouseClicked
        // TODO add your handling code here:
        try{
            FileInputStream fisp = new FileInputStream("simpan.txt");
            ObjectInputStream baca = new ObjectInputStream(fisp);
            game gg = (game) baca.readObject(); 
            formGameSpace f_game = new formGameSpace(gg);
            f_game.setLocationRelativeTo(null);
            f_game.setVisible(true);
            formMenuInGame.f_game = f_game;
            baca.close(); fisp.close();
            JOptionPane.showMessageDialog(null, "latest saved game has been loaded!");
        }
        catch(Exception ex){
            System.out.println("gagal karena : " + ex);
        }
        /*String nama = txtNama.getText();
        if (!nama.equals("") && nama.length() >= 3) {
            this.setVisible(false);
            namaPlayer = nama;
            
            formGameSpace f_game = new formGameSpace();
            f_game.setLocationRelativeTo(null);
            f_game.setVisible(true);
            formMenuInGame.f_game = f_game;
        }
        else{
            JOptionPane.showMessageDialog(null, "player's name must at least be 3 characters long");
        }*/
    }//GEN-LAST:event_btnLoadMouseClicked

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    public void playSound(String soundName)
    {
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName));
            Clip clip = AudioSystem.getClip( );
            if(soundName.equals("")){
                clip.stop();
            }
            else{
                clip.open(audioInputStream);
                clip.start( );
            }
        }
        catch(Exception ex)
        {
             System.out.println("Error with playing sound.");
             ex.printStackTrace( );
        }
    }
    
    public void setButtonSound(JButton b){
        try{
            if(soundOn){
                btnSound.setText("No Sound");
            }
            else {
                btnSound.setText("Sound");
            }
            soundEffect(soundOn);
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }
    
    static void soundEffect(boolean on){
        if (on) {
            if (!clip.isOpen()) {
                try {
                    clip.open(audioInputStream);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (LineUnavailableException | IOException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            clip.start();
        }
        else{
            clip.stop();
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSound;
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox<String> cbMode;
    private Proyek.LoginPanel loginPanel1;
    // End of variables declaration//GEN-END:variables
}


