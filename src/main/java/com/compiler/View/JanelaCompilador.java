package com.compiler.View;

import com.compiler.Lexer.AnaliseLexica;
import com.compiler.Lexer.Arquivo;
import static com.compiler.Lexer.Arquivo.errors;
import static com.compiler.Lexer.Arquivo.generatedTree;
import com.compiler.Lexer.Simbolo;
import com.compiler.Lexer.TabelaSimbolos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauricio.rodrigues
 */
public class JanelaCompilador extends javax.swing.JPanel {

    private Arquivo arquivo;
    private ResourceBundle traducoes;
   
    public JanelaCompilador(ResourceBundle traducoes) {
        initComponents();
        
        this.traducoes = traducoes;
        this.traduzir();
        
        setColor(btn_JanelaCompilador); 
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_Home}, new JPanel[]{ind_1});
    }
    
    public void traduzir(){
        this.bt_Compilar.setText(this.traducoes.getString("cad_compilar"));
        this.bt_Limpar.setText(this.traducoes.getString("cad_limpar"));
        this.bt_Selecionar.setText(this.traducoes.getString("cad_selecionar"));
        this.lb_JanelaCompilador.setText(this.traducoes.getString("cad_compilador"));
        this.lb_compilador.setText(this.traducoes.getString("cad_compilador"));
        this.lb_erros.setText(this.traducoes.getString("cad_errosEncontrados"));
        this.lb_lista_tokens.setText(this.traducoes.getString("cad_listaTokens"));
        this.lb_selecionar.setText(this.traducoes.getString("cad_selecionarArquivo"));
        this.lb_tabela.setText(this.traducoes.getString("cad_tabela"));
        this.jLabel5.setText(this.traducoes.getString("cad_arquivoSel"));
        DefaultTableModel model = (DefaultTableModel) tabelaErros.getModel(); // obtém o modelo de tabela do JTable
        model.setColumnIdentifiers(new String[] {this.traducoes.getString("cad_erro")});
        model = (DefaultTableModel) tabelaSimbolos.getModel(); // Obtém o modelo de tabela do JTable
        Vector<String> novosNomes = new Vector<String>(Arrays.asList(this.traducoes.getString("cad_indice"), this.traducoes.getString("cad_simbolo"))); // Define os novos nomes das colunas
        model.setColumnIdentifiers(novosNomes);
        model = (DefaultTableModel) tabelaListaTokens.getModel(); // Obtém o modelo de tabela do JTable
        novosNomes = new Vector<String>(Arrays.asList(this.traducoes.getString("cad_lexema"), this.traducoes.getString("cad_token"))); // Define os novos nomes das colunas
        model.setColumnIdentifiers(novosNomes);
    }
    
    public void selecionaArquivo(){
        final JFileChooser fc = new JFileChooser();
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Texto", "txt");
        fc.setFileFilter(filter);
        System.out.println("Diretório atual: " + System.getProperty("user.dir"));
        File initialDir = new File("./");
        fc.setCurrentDirectory(initialDir);
        fc.setDialogTitle("Abrir arquivo de texto");
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                String nomeArquivo = file.getName();
                tf_NomeArquivo.setText(nomeArquivo);
                this.arquivo = new Arquivo();
                arquivo.lerArquivo(file);
            } catch (IOException ex) {
                Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void limparArquivo(){
        tf_NomeArquivo.setText("");
        ta_Arvore.removeAll();
        ((DefaultTableModel) tabelaListaTokens.getModel()).setRowCount(0);
        ((DefaultTableModel) tabelaSimbolos.getModel()).setRowCount(0);
        ((DefaultTableModel) tabelaErros.getModel()).setRowCount(0);
    }
    
    public void compilar(){
        atualizaTabelaTokens();
        atualizaTabelaSimbolos();
        atualizaTabelaErros();
        atualizaArvore();
    }
    
    public void atualizaArvore(){
        System.out.println(generatedTree);
        //Atualiza tabela
        ta_Arvore.removeAll();
        ta_Arvore.append("Árvore de derivação: \n");
        ta_Arvore.append(generatedTree);
    }
    
    public void atualizaTabelaTokens(){
        //Atualiza tabela
        ((DefaultTableModel) tabelaListaTokens.getModel()).setRowCount(0);
            
        for (Simbolo s : AnaliseLexica.simbolos) {
           ((DefaultTableModel) tabelaListaTokens.getModel()).addRow(new Object[]{
            s.getLexema(),
            s.getToken()+", "+s.getAtributo()
        }); 
        }
    }
    
    public void atualizaTabelaSimbolos(){
        int ordem = TabelaSimbolos.tabela.size();
        HashMap<Integer, String> tabela;
        tabela = TabelaSimbolos.tabela;
        ((DefaultTableModel) tabelaSimbolos.getModel()).setRowCount(0);
        
        for (int i = 1; i <= ordem; i++) {
            ((DefaultTableModel) tabelaSimbolos.getModel()).addRow(new Object[]{
            i,
            tabela.get(i)
        });
        }
    }
    
    public void atualizaTabelaErros(){
        //Atualiza tabela
        ((DefaultTableModel) tabelaErros.getModel()).setRowCount(0);
            
        for (String s : AnaliseLexica.erros) {
           ((DefaultTableModel) tabelaErros.getModel()).addRow(new Object[]{
            "Lexer: " + s
        }); 
        }
        
        for (String s : errors) {
           ((DefaultTableModel) tabelaErros.getModel()).addRow(new Object[]{
            "Parser: " + s
        }); 
        }
    }
    
    public void gotoJanelaHome(){
        Janela.p1 = new JanelaHome(traducoes);
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p2);
        janela.getContentPane().remove(Janela.p2);
        janela.add(Janela.p1, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new javax.swing.JPanel();
        btn_Home = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_JanelaCompilador = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lb_JanelaCompilador = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaListaTokens = new javax.swing.JTable();
        lb_selecionar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_NomeArquivo = new javax.swing.JTextField();
        bt_Limpar = new javax.swing.JButton();
        bt_Compilar = new javax.swing.JButton();
        lb_tabela = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaSimbolos = new javax.swing.JTable();
        lb_lista_tokens = new javax.swing.JLabel();
        bt_Selecionar = new javax.swing.JButton();
        lb_erros = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaErros = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Arvore = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_compilador = new javax.swing.JLabel();

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Home.setBackground(new java.awt.Color(23, 35, 51));
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HomeMousePressed(evt);
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

        javax.swing.GroupLayout btn_HomeLayout = new javax.swing.GroupLayout(btn_Home);
        btn_Home.setLayout(btn_HomeLayout);
        btn_HomeLayout.setHorizontalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_HomeLayout.setVerticalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, -1));

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

        lb_JanelaCompilador.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_JanelaCompilador.setForeground(new java.awt.Color(255, 255, 255));
        lb_JanelaCompilador.setText("Compilador");

        javax.swing.GroupLayout btn_JanelaCompiladorLayout = new javax.swing.GroupLayout(btn_JanelaCompilador);
        btn_JanelaCompilador.setLayout(btn_JanelaCompiladorLayout);
        btn_JanelaCompiladorLayout.setHorizontalGroup(
            btn_JanelaCompiladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCompiladorLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_JanelaCompilador)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_JanelaCompiladorLayout.setVerticalGroup(
            btn_JanelaCompiladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCompiladorLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaCompiladorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_JanelaCompilador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaCompilador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tabelaListaTokens.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        tabelaListaTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaListaTokens);

        lb_selecionar.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_selecionar.setText("Selecionar arquivo .txt");

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Arquivo selecionado:");

        tf_NomeArquivo.setEnabled(false);

        bt_Limpar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Limpar.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        bt_Limpar.setText("Limpar");
        bt_Limpar.setFocusPainted(false);
        bt_Limpar.setFocusable(false);
        bt_Limpar.setMaximumSize(new java.awt.Dimension(200, 32));
        bt_Limpar.setPreferredSize(new java.awt.Dimension(91, 32));
        bt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LimparActionPerformed(evt);
            }
        });

        bt_Compilar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Compilar.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        bt_Compilar.setText("Compilar");
        bt_Compilar.setFocusPainted(false);
        bt_Compilar.setFocusable(false);
        bt_Compilar.setMaximumSize(new java.awt.Dimension(200, 32));
        bt_Compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CompilarActionPerformed(evt);
            }
        });

        lb_tabela.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_tabela.setText("Tabela de Símbolos");

        tabelaSimbolos.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        tabelaSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Índice", "Símbolo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaSimbolos);

        lb_lista_tokens.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_lista_tokens.setText("Lista de Tokens");

        bt_Selecionar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Selecionar.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        bt_Selecionar.setText("Selecionar");
        bt_Selecionar.setFocusPainted(false);
        bt_Selecionar.setFocusable(false);
        bt_Selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SelecionarActionPerformed(evt);
            }
        });

        lb_erros.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        lb_erros.setText("Erros encontrados:");

        tabelaErros.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        tabelaErros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Erro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabelaErros);

        ta_Arvore.setEditable(false);
        ta_Arvore.setColumns(20);
        ta_Arvore.setRows(5);
        jScrollPane1.setViewportView(ta_Arvore);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(lb_lista_tokens)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(bt_Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_Selecionar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_Compilar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lb_selecionar)
                                    .addComponent(lb_tabela)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_NomeArquivo))
                                    .addComponent(lb_erros))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_selecionar)
                    .addComponent(lb_lista_tokens))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_NomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Compilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Selecionar)
                            .addComponent(bt_Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_tabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_erros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
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

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(".\\images\\iconExit.png"));
        jLabel1.setText("Logout");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        lb_compilador.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        lb_compilador.setForeground(new java.awt.Color(255, 255, 255));
        lb_compilador.setText("Compilador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_compilador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(23, 23, 23)
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
                            .addComponent(jLabel1)
                            .addComponent(lb_compilador))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(side_pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_JanelaCompiladorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaCompiladorMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaCompilador);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_Home}, new JPanel[]{ind_1});
    }//GEN-LAST:event_btn_JanelaCompiladorMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel1MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        //tQuando altera o JPainel, ele altera a posição da Janela
        Janela.j.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void bt_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LimparActionPerformed
        limparArquivo();
    }//GEN-LAST:event_bt_LimparActionPerformed

    private void bt_CompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CompilarActionPerformed
        compilar();
    }//GEN-LAST:event_bt_CompilarActionPerformed

    private void bt_SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SelecionarActionPerformed
        selecionaArquivo();
    }//GEN-LAST:event_bt_SelecionarActionPerformed

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        setColor(btn_Home);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaCompilador}, new JPanel[]{ind_3});
        gotoJanelaHome();
    }//GEN-LAST:event_btn_HomeMousePressed

    int xx, xy;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Compilar;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_Selecionar;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_JanelaCompilador;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lb_JanelaCompilador;
    private javax.swing.JLabel lb_compilador;
    private javax.swing.JLabel lb_erros;
    private javax.swing.JLabel lb_lista_tokens;
    private javax.swing.JLabel lb_selecionar;
    private javax.swing.JLabel lb_tabela;
    private javax.swing.JPanel side_pane;
    private javax.swing.JTextArea ta_Arvore;
    private javax.swing.JTable tabelaErros;
    private javax.swing.JTable tabelaListaTokens;
    private javax.swing.JTable tabelaSimbolos;
    private javax.swing.JTextField tf_NomeArquivo;
    // End of variables declaration//GEN-END:variables
}
