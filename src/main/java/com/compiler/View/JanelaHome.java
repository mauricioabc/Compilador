package com.compiler.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class JanelaHome extends javax.swing.JPanel {

    Locale localCorrente;
    ResourceBundle traducoes;
    
    public JanelaHome(ResourceBundle traducoes) {
        initComponents();
        setColor(btn_1); 
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaCompilador}, new JPanel[]{ind_3});
        this.traducoes = traducoes;
        traduzir();
        setColorIdioma(lb_PT);
        resetColorIdioma(new JLabel[]{lb_ES, lb_GE, lb_IT, lb_JP, lb_FR, lb_US});
    }

    public void gotoJanelaCompilador(){
        Janela.p2 = new JanelaCompilador(traducoes);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p2, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void traduzir(){
        jLabel3.setText(traducoes.getString("cad_compilador"));
        this.jLabel10.setText(this.traducoes.getString("cad_compilador"));
    }
    
    
    public void mudarIdioma(String idioma, String pais){
        localCorrente = new Locale(idioma, pais);
        traducoes = ResourceBundle.getBundle("MessagesBundle", localCorrente);
        traduzir();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new javax.swing.JPanel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_JanelaCompilador = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lb_PT = new javax.swing.JLabel();
        lb_US = new javax.swing.JLabel();
        lb_ES = new javax.swing.JLabel();
        lb_JP = new javax.swing.JLabel();
        lb_IT = new javax.swing.JLabel();
        lb_FR = new javax.swing.JLabel();
        lb_GE = new javax.swing.JLabel();
        lb_PL = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setBackground(new java.awt.Color(23, 35, 51));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home");

        javax.swing.GroupLayout btn_1Layout = new javax.swing.GroupLayout(btn_1);
        btn_1.setLayout(btn_1Layout);
        btn_1Layout.setHorizontalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_1Layout.setVerticalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, -1));

        btn_JanelaCompilador.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaCompilador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_JanelaCompiladorMousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Compilador");

        javax.swing.GroupLayout btn_JanelaCompiladorLayout = new javax.swing.GroupLayout(btn_JanelaCompilador);
        btn_JanelaCompilador.setLayout(btn_JanelaCompiladorLayout);
        btn_JanelaCompiladorLayout.setHorizontalGroup(
            btn_JanelaCompiladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCompiladorLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_JanelaCompiladorLayout.setVerticalGroup(
            btn_JanelaCompiladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCompiladorLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaCompiladorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaCompilador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lb_PT.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_PT.setIcon(new javax.swing.ImageIcon(".\\images\\brasil.png"));
        lb_PT.setText("Português");
        lb_PT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_PT.setOpaque(true);
        lb_PT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_PTMousePressed(evt);
            }
        });

        lb_US.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_US.setIcon(new javax.swing.ImageIcon(".\\images\\eua.png"));
        lb_US.setText("English");
        lb_US.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_US.setOpaque(true);
        lb_US.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_USMousePressed(evt);
            }
        });

        lb_ES.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_ES.setIcon(new javax.swing.ImageIcon(".\\images\\espanha.png"));
        lb_ES.setText("Español");
        lb_ES.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_ES.setOpaque(true);
        lb_ES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_ESMousePressed(evt);
            }
        });

        lb_JP.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        lb_JP.setIcon(new javax.swing.ImageIcon(".\\images\\japao.png"));
        lb_JP.setText("日本語");
        lb_JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_JP.setOpaque(true);
        lb_JP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_JPMousePressed(evt);
            }
        });

        lb_IT.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_IT.setIcon(new javax.swing.ImageIcon(".\\images\\italia.png"));
        lb_IT.setText("Italiano");
        lb_IT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_IT.setOpaque(true);
        lb_IT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_ITMousePressed(evt);
            }
        });

        lb_FR.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_FR.setIcon(new javax.swing.ImageIcon(".\\images\\franca.png"));
        lb_FR.setText("Français");
        lb_FR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_FR.setOpaque(true);
        lb_FR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_FRMousePressed(evt);
            }
        });

        lb_GE.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_GE.setIcon(new javax.swing.ImageIcon(".\\images\\alemanha.png"));
        lb_GE.setText("Deutsch");
        lb_GE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_GE.setOpaque(true);
        lb_GE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_GEMousePressed(evt);
            }
        });

        lb_PL.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_PL.setIcon(new javax.swing.ImageIcon(".\\images\\polonia.png"));
        lb_PL.setText("Polski");
        lb_PL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_PL.setOpaque(true);
        lb_PL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_PLMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_PT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_US, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_ES, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_FR, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_JP, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_IT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_GE, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_PL, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_PT)
                    .addComponent(lb_US)
                    .addComponent(lb_ES)
                    .addComponent(lb_FR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_IT)
                        .addComponent(lb_GE)
                        .addComponent(lb_PL))
                    .addComponent(lb_JP))
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(".\\images\\iconExit.png"));
        jLabel1.setText("Logout");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Compilador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1074, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 4, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
        // TODO add your handling code here:
        setColor(btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaCompilador}, new JPanel[]{ind_3});
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_JanelaCompiladorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaCompiladorMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaCompilador);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_1}, new JPanel[]{ind_1});
        gotoJanelaCompilador();
    }//GEN-LAST:event_btn_JanelaCompiladorMousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:

        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        Janela.j.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    int xx, xy;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel1MousePressed

    private void lb_PTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PTMousePressed
        mudarIdioma("pt", "BR");
        setColorIdioma(lb_PT);
        resetColorIdioma(new JLabel[]{lb_ES, lb_GE, lb_IT, lb_JP, lb_FR, lb_US, lb_PL});
    }//GEN-LAST:event_lb_PTMousePressed

    private void lb_USMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_USMousePressed
        mudarIdioma("en", "US");
        setColorIdioma(lb_US);
        resetColorIdioma(new JLabel[]{lb_ES, lb_GE, lb_IT, lb_JP, lb_PT, lb_FR, lb_PL});
    }//GEN-LAST:event_lb_USMousePressed

    private void lb_ESMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ESMousePressed
        mudarIdioma("es", "MX");
        setColorIdioma(lb_ES);
        resetColorIdioma(new JLabel[]{lb_FR, lb_GE, lb_IT, lb_JP, lb_PT, lb_US, lb_PL});
    }//GEN-LAST:event_lb_ESMousePressed

    private void lb_JPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_JPMousePressed
        mudarIdioma("ja", "JP");
        setColorIdioma(lb_JP);
        resetColorIdioma(new JLabel[]{lb_ES, lb_GE, lb_IT, lb_FR, lb_PT, lb_US, lb_PL});
    }//GEN-LAST:event_lb_JPMousePressed

    private void lb_ITMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ITMousePressed
        mudarIdioma("it", "IT");
        setColorIdioma(lb_IT);
        resetColorIdioma(new JLabel[]{lb_ES, lb_GE, lb_FR, lb_JP, lb_PT, lb_US, lb_PL});
    }//GEN-LAST:event_lb_ITMousePressed

    private void lb_GEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GEMousePressed
        mudarIdioma("de", "DE");
        setColorIdioma(lb_GE);
        resetColorIdioma(new JLabel[]{lb_ES, lb_FR, lb_IT, lb_JP, lb_PT, lb_US, lb_PL});
    }//GEN-LAST:event_lb_GEMousePressed

    private void lb_FRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FRMousePressed
        mudarIdioma("fr", "FR");
        setColorIdioma(lb_FR);
        resetColorIdioma(new JLabel[]{lb_ES, lb_GE, lb_IT, lb_JP, lb_PT, lb_US, lb_PL});
    }//GEN-LAST:event_lb_FRMousePressed

    private void lb_PLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PLMousePressed
        mudarIdioma("pl", "PL");
        setColorIdioma(lb_PL);
        resetColorIdioma(new JLabel[]{lb_ES, lb_GE, lb_IT, lb_JP, lb_PT, lb_US, lb_FR});
    }//GEN-LAST:event_lb_PLMousePressed

        private void setColor(JPanel pane)
    {
        pane.setBackground(new Color(41,57,80));
    }
    
    private void resetColor(JPanel [] pane, JPanel [] indicators)
    {
        for(int i=0;i<pane.length;i++){
           pane[i].setBackground(new Color(23,35,51));
           
        } for(int i=0;i<indicators.length;i++){
           indicators[i].setOpaque(false);           
        }
        
    }
    
        private void setColorIdioma(JLabel label)
    {
        label.setBackground(new Color(204,204,204));
    }
    
    private void resetColorIdioma(JLabel[] label)
    {
        for(int i=0;i<label.length;i++){
           label[i].setBackground(new Color(255,255,255));
           
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_1;
    private javax.swing.JPanel btn_JanelaCompilador;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lb_ES;
    private javax.swing.JLabel lb_FR;
    private javax.swing.JLabel lb_GE;
    private javax.swing.JLabel lb_IT;
    private javax.swing.JLabel lb_JP;
    private javax.swing.JLabel lb_PL;
    private javax.swing.JLabel lb_PT;
    private javax.swing.JLabel lb_US;
    private javax.swing.JPanel side_pane;
    // End of variables declaration//GEN-END:variables
}
