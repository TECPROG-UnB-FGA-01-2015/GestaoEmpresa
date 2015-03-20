/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Compra;
import model.Transacao;
import model.Venda;
import static view.TelaVendaCompra.umControleTransacao;


public class TelaHistoricoVendaCompra extends javax.swing.JFrame {

    private int statusVendaCompra=0;
    Venda umaVenda;
    Compra umaCompra;
    
   public TelaHistoricoVendaCompra() {
        initComponents();
        carregarLista();
    }
    private void carregarLista(){
        ArrayList<Transacao> listaTransacao = umControleTransacao.getListaVenda();
        DefaultTableModel model = (DefaultTableModel) jTable_Historico.getModel();
        model.setRowCount(0);
        for (Transacao t : listaTransacao) 
        {
            if(statusVendaCompra==0)
            {
                if(t.getClass().equals(Venda.class))
                {
                    umaVenda = (Venda) t;
                    String data = Integer.toString(umaVenda.getDia())+"/"+Integer.toString(umaVenda.getMes())+Integer.toString(umaVenda.getAno());
                    model.addRow(new String[]{umaVenda.getCliente().getNome(),
                        umaVenda.getFuncionario().getNome(),Double.toString(umaVenda.getPreco()),
                        data});     
                }
            }
            else if(statusVendaCompra==1)
            {
                if(t.getClass().equals(Compra.class))
                {
                    umaCompra = (Compra) t;
                    String data = Integer.toString(umaCompra.getDia())+"/"+Integer.toString(umaCompra.getMes())+"/"+Integer.toString(umaCompra.getAno());
                    model.addRow(new String[]{umaCompra.getFornecedor().getNome(),umaCompra.getFuncionario().getNome(),Double.toString(umaCompra.getPreco()),data});     
                }
            }
        }
        jTable_Historico.setModel(model); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Historico = new javax.swing.JTable();
        jComboBox_VendaCompra = new javax.swing.JComboBox();
        jButton_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Vendas");
        setBounds(new java.awt.Rectangle(450, 300, 0, 0));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Histórico de Vendas");

        jTable_Historico.setModel(new javax.swing.table.DefaultTableModel
            (
                null,
                new String [] {
                    "Nome Cliente/Fornecedor", "Funcionário Responsável", "Valor da Transação", "Data"
                }
            )
            {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            jScrollPane1.setViewportView(jTable_Historico);

            jComboBox_VendaCompra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Venda", "Compra" }));
            jComboBox_VendaCompra.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    jComboBox_VendaCompraItemStateChanged(evt);
                }
            });

            jButton_sair.setText("Sair");
            jButton_sair.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton_sairActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 673, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_sair)
                                .addGap(159, 159, 159)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_VendaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 299, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_sair)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_VendaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sairActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton_sairActionPerformed

    private void jComboBox_VendaCompraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_VendaCompraItemStateChanged
        if(jComboBox_VendaCompra.getSelectedIndex()==0)
        {
            statusVendaCompra=0;
            jLabel1.setText("Histórico de Vendas");
        }
        else if(jComboBox_VendaCompra.getSelectedIndex()==1)
        {
            statusVendaCompra=1;
            jLabel1.setText("Histórico de Compras");
        }
        carregarLista();
    }//GEN-LAST:event_jComboBox_VendaCompraItemStateChanged

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
            java.util.logging.Logger.getLogger(TelaHistoricoVendaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHistoricoVendaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHistoricoVendaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHistoricoVendaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaHistoricoVendaCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_sair;
    private javax.swing.JComboBox jComboBox_VendaCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Historico;
    // End of variables declaration//GEN-END:variables
}
