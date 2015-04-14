/**********************************************************
 * File: ProductDataView.java
 * Purpose: Responsible to get Products' informations from user
**********************************************************/
package view;

import controller.StockController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import static view.StockView.newProduct;

public class ProductDataView extends javax.swing.JFrame
{
    Product objectProduct; // Product type object
    static StockController objectStockController = new StockController(); // ControleEstoque type object
    Product editProduct; // Product type object that is being editing
    StockView stockView; // Control the view visibility situation
    static boolean infoCarregar=false; // Boolean to disposes the informations on view
    
    // Constructor to initialize components on ProductDataView
    public ProductDataView()
    {
        initComponents();
        preencherCampos();
        jTextField_QuantidadeProduto.setEnabled(false);
        preencherCodigo();
        jTextField_DescricaoProduto.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jButton_Cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField_NomeProduto = new javax.swing.JTextField();
        jTextField_DescricaoProduto = new javax.swing.JTextField();
        jTextField_PrecoCompra = new javax.swing.JTextField();
        jTextField_QuantidadeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_SalvarProduto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_PrecoVenda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Product");
        setBounds(new java.awt.Rectangle(450, 300, 0, 0));

        jButton_Cancelar.setText("Sair");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton_CancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jTextField_PrecoCompra.setText("0.00");

        jTextField_QuantidadeProduto.setText("0.0");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Preço Venda:");

        jLabel4.setText("Quantidade:");

        jButton_SalvarProduto.setText("Salvar");
        jButton_SalvarProduto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton_SalvarProdutoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setText("Novo Product");

        jLabel6.setText("R$");

        jLabel7.setText("Preço Compra:");

        jLabel8.setText("R$");

        jTextField_PrecoVenda.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton_Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_SalvarProduto)
                .addGap(107, 107, 107))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_PrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_PrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_QuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_DescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Cancelar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_DescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_PrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_PrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_QuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton_SalvarProduto))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    // Method to show a message to user by passing as a parameter a String info
    public void showMessage(String info)
    {
        JOptionPane.showMessageDialog(this, info,"Atenção" ,JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Method to add informations on the Product list
    private void preencherCodigo()
    {
        if(newProduct==true)
        {
        	// Variable to receive a list of Products
            ArrayList<Product> productList = objectStockController.getProductList();
            if(productList.isEmpty())
            {
                jTextField_NomeProduto.setText("1");
            }
            
            else
            {
                jTextField_NomeProduto.setText(Integer.toString
                                            (Integer.parseInt
                                            (productList.get
                                            (productList.size()-1)
                                            .getCode())
                                             +1));
            }
        }
        
        else
        {
        	// Nothing to do
        }
    }
    
    // Method to add one more on the attribute code if there is already a Product
    private void preencherCampos()
    {
        if(newProduct==false)
        {
	        editProduct = objectStockController.searchProduct(stockView.codeTable,false);
	        jTextField_NomeProduto.setText(editProduct.getCode());
	        jTextField_DescricaoProduto.setText(editProduct.getDescription());
	        jTextField_PrecoCompra.setText(Double.toString(editProduct.getPurchasePrice()));
	        jTextField_PrecoVenda.setText(Double.toString(editProduct.getSellingPrice()));
	        jTextField_QuantidadeProduto.setText(Double.toString(editProduct.getQuantity()));
        }
        
        else
        {
        	// Nothing to do
        }
    }
    
    // Method to clean up the textBox
        private void limparCampos()
    {
        jTextField_NomeProduto.setText("");
        jTextField_DescricaoProduto.setText("");
        jTextField_PrecoCompra.setText("0.00");
        jTextField_PrecoVenda.setText("0.00");
        jTextField_QuantidadeProduto.setText("0.0");
    }
    
    /* Method to cancel the action to add another product giving returning an
     * information to user
     */
    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton_CancelarActionPerformed
        if(!jTextField_DescricaoProduto.getText().equals(""))
        {
            showMessage("Product não adicionado");
        }
            
        new StockView().setVisible(true);
        this.dispose();
        infoCarregar=true;
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    /* Method to save all the informations provided by the user on a new object
     * Product
     */
    private void jButton_SalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalvarProdutoActionPerformed
        if(!jTextField_NomeProduto.getText().equals("")&&!jTextField_DescricaoProduto.getText().equals("")&&!jTextField_PrecoCompra.getText().equals(""))
        {
            String code = jTextField_NomeProduto.getText();
            String description = jTextField_DescricaoProduto.getText();
            double purchasePrice = Double.parseDouble(jTextField_PrecoCompra.getText());
            double sellingPrice = Double.parseDouble(jTextField_PrecoVenda.getText());
            double quantity = Double.parseDouble(jTextField_QuantidadeProduto.getText());

            if(stockView.newProduct==true)
            {
                objectProduct = new Product(code, description, purchasePrice, quantity, sellingPrice);
                
                if(objectStockController.searchProduct(objectProduct.getCode(),false)==null
                        &&objectStockController.searchProduct(objectProduct.getDescription(),false)==null)
                {
                    objectStockController.addProduct(objectProduct);
                    showMessage("Product Adicionado!");
                }
                
                else if(objectStockController.searchProduct(objectProduct.getCode(),false)!=null)
                {
                    showMessage("Product com esse código já existente no quantity!");
                }
                
                else if(objectStockController.searchProduct(objectProduct.getDescription(),false)!=null)
                {
                    showMessage("Product com essa Descrição já existente no quantity!");
                }
                
                else
                {
                	// Nothing to do
                }
            }
            
            else if(stockView.newProduct==false)
            {    
                if(!editProduct.getCode().equals(jTextField_NomeProduto.getText()))
                {
                    showMessage("Não é permitido a alteração do código do produto!");
                }
                
                else{
                    editProduct.setCode(code);
                    editProduct.setDescription(description);
                    editProduct.setPurchasePrice(purchasePrice);
                    editProduct.setSellingPrice(sellingPrice);
                    editProduct.setQuantity(quantity);   
                    showMessage("Product Editado!");
                }
            }
            
            else
            {
            	// Nothing to do
            }
            
            limparCampos();
            preencherCodigo();
            newProduct=true;
        }
        
        else if(jTextField_NomeProduto.getText().equals(""))
        {
            showMessage("Digite um código para o produto");
            jTextField_NomeProduto.requestFocus();
        }
        
        else if(jTextField_DescricaoProduto.getText().equals(""))
        {
            showMessage("Digite uma descrição para o produto");
            jTextField_DescricaoProduto.requestFocus();
        }
        
        else if(jTextField_PrecoCompra.getText().equals(""))
        {
            showMessage("Digite um preço de compra para o produto");
            jTextField_PrecoCompra.requestFocus();
        }
        
        else if(jTextField_PrecoVenda.getText().equals(""))
        {
            showMessage("Digite um preço de venda para o produto");
            jTextField_PrecoCompra.requestFocus();
        }
        
        else
        {
        	// Nothing to do
        }
    }//GEN-LAST:event_jButton_SalvarProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                
                else
                {
                	// Nothing to do
                }
            }
        }
        
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ProductDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ProductDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ProductDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ProductDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ProductDataView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_SalvarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_DescricaoProduto;
    private javax.swing.JTextField jTextField_NomeProduto;
    private javax.swing.JTextField jTextField_PrecoCompra;
    private javax.swing.JTextField jTextField_PrecoVenda;
    private javax.swing.JTextField jTextField_QuantidadeProduto;
    // End of variables declaration//GEN-END:variables
}
