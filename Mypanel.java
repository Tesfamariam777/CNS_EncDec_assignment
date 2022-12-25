import java.awt.event.*;
//import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.awt.Toolkit;
//import java.util.Arrays;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.awt.datatransfer.UnsupportedFlavorException;

import javax.swing.*;


public class Mypanel extends javax.swing.JFrame {
    public Mypanel() {
        initComponents();
    }

private void initComponents() {
    
    jScrollPane1 = new javax.swing.JScrollPane();
    text1 = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    text2 = new javax.swing.JTextArea();
    jScrollPane3 = new javax.swing.JScrollPane();
    text3 = new javax.swing.JTextArea();
    jScrollPane4 = new javax.swing.JScrollPane();
    text4 = new javax.swing.JTextArea();
    msg1 = new javax.swing.JTextField();
    msg2 = new javax.swing.JTextField();
    encrypt = new javax.swing.JButton();
    decrypt = new javax.swing.JButton();
    copyencrypt = new javax.swing.JButton();
    pasteEncrypt = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    message1 = new javax.swing.JLabel();
    message2 = new javax.swing.JLabel();
    mainsection = new javax.swing.JLabel();

    String[] comboItem = {"AES/ECB/PKCS5Padding", "DESede/ECB/PKCS5Padding","OTP"};
    combo = new JComboBox(comboItem);


    label = new JLabel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Encryption and Decryption ");
    setAlwaysOnTop(false);
    setUndecorated(false);
    setResizable(false);
    getContentPane().setLayout(null);

    text1.setBackground(new java.awt.Color(255, 255, 255));
    text1.setColumns(20);
    text1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    text1.setForeground(new java.awt.Color(0, 0, 0));
    text1.setRows(5);
    text1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
    jScrollPane1.setViewportView(text1);

    getContentPane().add(jScrollPane1);
    jScrollPane1.setBounds(80, 80, 300, 120);

    text2.setBackground(new java.awt.Color(255, 255, 255));
    text2.setColumns(20);
    text2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    text2.setForeground(new java.awt.Color(0, 0, 0));
    text2.setRows(5);
    text2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
    jScrollPane2.setViewportView(text2);

    getContentPane().add(jScrollPane2);
    jScrollPane2.setBounds(80, 322, 300, 120);

    text3.setBackground(new java.awt.Color(255, 255, 255));
    text3.setColumns(20);
    text3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    text3.setForeground(new java.awt.Color(0, 0, 0));
    text3.setRows(5);
    text3.setToolTipText("");
    text3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
    jScrollPane3.setViewportView(text3);

    getContentPane().add(jScrollPane3);
    jScrollPane3.setBounds(470, 80, 320, 120);

    text4.setBackground(new java.awt.Color(255, 255, 255));
    text4.setColumns(20);
    text4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    text4.setForeground(new java.awt.Color(0, 0, 0));
    text4.setRows(5);
    text4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
    jScrollPane4.setViewportView(text4);

    getContentPane().add(jScrollPane4);
    jScrollPane4.setBounds(470, 320, 320, 120);

    msg1.setBackground(new java.awt.Color(255, 255, 255));
    msg1.setForeground(new java.awt.Color(0, 0, 0));
    msg1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    getContentPane().add(msg1);
    msg1.setBounds(200, 220, 180, 30);

    msg2.setBackground(new java.awt.Color(255, 255, 255));
    msg2.setForeground(new java.awt.Color(0, 0, 0));
    msg2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    getContentPane().add(msg2);
    msg2.setBounds(595, 220, 190, 30);

    encrypt.setBackground(new java.awt.Color(0, 51, 51));
    encrypt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    encrypt.setForeground(new java.awt.Color(255, 255, 255));
    encrypt.setText("Encrypt");
    //register the button
    encrypt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if(combo.getItemAt(combo.getSelectedIndex()) == "AES/ECB/PKCS5Padding")
              encryptActionPerformed_aes(evt);
            else if(combo.getItemAt(combo.getSelectedIndex()) == "DESede/ECB/PKCS5Padding")
              encryptActionPerformed_tdes(evt);
            else 
            encryptActionPerformed_otp(evt);
              
        }
    });
   
    getContentPane().add(encrypt);
    encrypt.setBounds(80, 275, 90, 30);

    decrypt.setBackground(new java.awt.Color(0, 51, 51));
    decrypt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    decrypt.setForeground(new java.awt.Color(255, 255, 255));
    decrypt.setText("Decrypt");
    
    decrypt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            String choice = (String) combo.getItemAt(combo.getSelectedIndex());
            switch (choice){
                case "AES/ECB/PKCS5Padding":
                    decryptActionPerformed_aes(evt);
                    break;
                case "DESede/ECB/PKCS5Padding":
                    decryptActionPerformed_tdes(evt);
                    break;
                case "OTP":
                    decryptActionPerformed_otp(evt);
                    break;
                default:
            }

        }
    });
  
    getContentPane().add(decrypt);
    decrypt.setBounds(470, 275, 90, 30);

    copyencrypt.setBackground(new java.awt.Color(102, 0, 0));
    copyencrypt.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    copyencrypt.setForeground(new java.awt.Color(255, 255, 255));
    copyencrypt.setText("Copy Encryption");
   
    copyencrypt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            copyencryptActionPerformed(evt);
        }
    });
   
    getContentPane().add(copyencrypt);
    copyencrypt.setBounds(240, 275, 140, 30);

    pasteEncrypt.setBackground(new java.awt.Color(102, 0, 0));
    pasteEncrypt.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
    pasteEncrypt.setForeground(new java.awt.Color(255, 255, 255));
    pasteEncrypt.setText("Paste Encryption");
    
    pasteEncrypt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pasteEncryptActionPerformed(evt);
        }
    });
    getContentPane().add(pasteEncrypt);
    pasteEncrypt.setBounds(633, 275, 150, 30);

    jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    // jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
    //     public void mousePressed(java.awt.event.MouseEvent evt) {
    //         jLabel2MousePressed(evt);
    //     }
    // });
    getContentPane().add(jLabel2);
    jLabel2.setBounds(810, 5, 30, 20);

    jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    // jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
    //     public void mousePressed(java.awt.event.MouseEvent evt) {
    //         jLabel3MousePressed(evt);
    //     }
    // });
    getContentPane().add(jLabel3);
    jLabel3.setBounds(780, 5, 30, 20);

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(204, 51, 0));
    jLabel1.setText("Encryption Key");
    jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
    getContentPane().add(jLabel1);
    jLabel1.setBounds(80, 220, 110, 30);

    jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(204, 51, 0));
    jLabel4.setText("Decryption Key");
    jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
    getContentPane().add(jLabel4);
    jLabel4.setBounds(470, 220, 110, 30);

    jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 51));
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("Message to Decrypt");
    getContentPane().add(jLabel5);
    jLabel5.setBounds(470, 50, 300, 30);

    jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 0, 51));
    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setText("Message to Encrypt ");
    getContentPane().add(jLabel6);
    jLabel6.setBounds(80, 50, 300, 30);

    message1.setForeground(new java.awt.Color(204, 0, 0));
    message1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    getContentPane().add(message1);
    message1.setBounds(80, 450, 300, 20);

    message2.setForeground(new java.awt.Color(204, 0, 0));
    message2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    getContentPane().add(message2);
    message2.setBounds(470, 450, 320, 20);

    combo.setBounds (255, 475, 230, 35);
    getContentPane().add(combo);

    label.setBounds(80,475, 160, 25);
    label.setFont(new java.awt.Font("Dialog", 1, 18)); 
    label.setText("Choose Algorithm");
    getContentPane().add(label);
    

    mainsection.setForeground(new java.awt.Color(153, 0, 0));
   // mainsection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edcrypt.png"))); // NOI18N
    mainsection.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    getContentPane().add(mainsection);
    mainsection.setBounds(0, 0, 850, 500);

    setSize(new java.awt.Dimension(850, 600));
    //setLocationRelativeTo(null);
    
}
 // Variables declaration - do not modify//GEN-BEGIN:variables
 
 private javax.swing.JButton pasteEncrypt;
 private javax.swing.JButton copyencrypt;
 private javax.swing.JButton decrypt;
 private javax.swing.JButton encrypt;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JLabel jLabel5;
 private javax.swing.JLabel jLabel6;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JScrollPane jScrollPane2;
 private javax.swing.JScrollPane jScrollPane3;
 private javax.swing.JScrollPane jScrollPane4;
 private javax.swing.JLabel mainsection;
 private javax.swing.JLabel message1;
 private javax.swing.JLabel message2;
 private javax.swing.JTextField msg1;
 private javax.swing.JTextField msg2;
 private javax.swing.JTextArea text1;
 private javax.swing.JTextArea text2;
 private javax.swing.JTextArea text3;
 private javax.swing.JTextArea text4;
 private javax.swing.JComboBox combo;
 private javax.swing.JLabel label;
 // End of variables declaration//GEN-END:variables


 //Methods Handlers for button clicked events

 //Method excuted if encrypt button clicked

 private void encryptActionPerformed_aes(ActionEvent evt) {
    
    try{
        if(text1.getText() != null && msg1.getText().length() > 4)
        text2.setText(AES_ED.encrypt(text1.getText(),msg1.getText()));
        else
            text2.setText("Please enter Message to be encrypted or the key length must be greater or equal to 5");
    }
    catch(Exception e)
    {
        text2.setText("Please fill up the right secret key");
    }

   
}
//method excuted if Dycrypt button cliced
private void decryptActionPerformed_aes(ActionEvent evt) {
    
    try{
        text4.setText(AES_ED.decrypt(text3.getText(),msg2.getText()));
    }
    catch(Exception e)
    {
        text4.setText("Please fill up the right secret key");
    }
}
    private void encryptActionPerformed_tdes(ActionEvent evt) {
    
        try{
            if(text1.getText() != null && msg1.getText().length() > 4)
                text2.setText(TripleDES.encrypt(text1.getText(),msg1.getText()));
            else
                text2.setText("Please enter Message to be encrypted or the key length must be greater or equal to 5");
        }
        catch(Exception e)
        {
            text2.setText("Please fill up the right secret key");
        }
    
       
    }
    //method excuted if Dycrypt button cliced
    private void decryptActionPerformed_tdes(ActionEvent evt) {
        
        try{
            text4.setText(TripleDES.decrypt(text3.getText(),msg2.getText()));
        }
        catch(Exception e)
        {
            text4.setText("Please fill up the right secret key");
        }
    
       
}

private void encryptActionPerformed_otp(ActionEvent evt) {
    String messageToEncrypt;
    String secret;
    try{

        messageToEncrypt = text1.getText();

        //auto key generation

        msg1.setText(OTP_Algo.returnKey(messageToEncrypt));
        secret = msg1.getText();

        if((messageToEncrypt != null )) {

            text2.setText(OTP_Algo.encrypt(messageToEncrypt, secret));
        }
        else
        {text2.setText("Please enter the message to be encrypted");}
    }
    catch(Exception e)
    {
           
    }

}
//method excuted if Dycrypt button cliced
private void decryptActionPerformed_otp(ActionEvent evt) {

        String messageToDecrypt;
        String secret;
    try{
        //auto generate key and display

        messageToDecrypt = text3.getText();              
        secret = msg2.getText();
        if(!(
            //messageToDecrypt.length() != secret.length() || 
            messageToDecrypt == null || secret == null))
        text4.setText(OTP_Algo.decrypt(messageToDecrypt, secret));
        else 
        text4.setText("The message and key must be non-empty");
    }
    catch(Exception e)
    {
        
    }
}

private void copyencryptActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text2.getText()),null);
    message1.setText("Your encryption result is copied!");
    message2.setText("");
}


private void pasteEncryptActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    DataFlavor flavor = DataFlavor.stringFlavor;
    if (clipboard.isDataFlavorAvailable(flavor)) {
      try {
        String text = (String) clipboard.getData(flavor);
        text3.setText(text);
        message2.setText("Your encryption result is pasted!");
        message1.setText("");
        //System.out.println(text);
      } catch (UnsupportedFlavorException e) {
        //System.out.println(e);
      } catch (IOException e) {
       // System.out.println(e);
      }
    }
  }



 public static void main (String[] args) {
    // JFrame frame = new JFrame ("javagui");
    // frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       
    // frame.pack();
    // frame.setVisible (true);
     Mypanel frame = new Mypanel();
     frame.setVisible(true);
     frame.setDefaultCloseOperation (Mypanel.EXIT_ON_CLOSE);
     frame.getContentPane().add (new Mypanel());
     frame.pack();
}
}