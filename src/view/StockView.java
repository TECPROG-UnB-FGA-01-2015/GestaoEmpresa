/**********************************************************
 * File: StockView.java
 * Purpose: Lists the products and permits
 *          to add, edit and remove a product.
 *********************************************************/

package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import model.Product;
import static view.ProductDataView.objectStockController;
import static view.SalePurchaseView.productMode;
import static view.SalePurchaseView.purchaseSaleMode;

@SuppressWarnings("serial")
public class StockView extends javax.swing.JFrame
{
	EnterpriseManagement principal; // Object from the EnterpriseManagement Class that instantiates the main view
	static boolean newProduct = true; // Receives the boolean info
	static String codeTable; // Receives an info of the view's table
	static String tableDescription; // Receives an info of the view's table 
	static boolean returnProduct = false; // Receives a list of products from the class StockController 
    static Logger log = Logger.getLogger(StockView.class.getName());

	// Constructor to initialize components on StockView
	public StockView() throws Exception
	{
		initComponents();
		jButton_EditarProduto.setEnabled(false);
		jButton_ExcluirProduto.setEnabled(false);
		jButton_ConfirmarProduto.setVisible(false);
		jButton_ConfirmarProduto.setEnabled(false);
		if(SalePurchaseView.productMode == true)
		{
			jButton_ConfirmarProduto.setVisible(newProduct);
		}
		else
		{
			// Nothing to do
		}
		
		if(purchaseSaleMode == true)
		{
			jButton_AdicionarProduto.setEnabled(false);
		}
		else
		{
			// Nothing to do
		}
		
		if(ProductDataView.loadInfo == true)
		{
			loadList();
		}
		else
		{
			// Nothing to do
		}
		
		ProductDataView.loadInfo = false;
		loadList();
		jTextField_NomeProduto.requestFocus();
		log.debug("Load StockView");
	}

	// Displays a warning message to the user
	public void showMessage(String info)
	{
		JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
	}

	// Loads the table with product information
	public void loadList() throws Exception
	{
		try
		{
			DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();  
																				
			model1.setRowCount(0);
			jTable2.setModel(model1);
	
			ArrayList<Product> productList = objectStockController.getProductList();
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
			model.setRowCount(0);
			for(Product product : productList)
			{
				model.addRow(new String[] {product.getCode(), product.getDescription(), Double.toString(product.getPurchasePrice()), Double.toString(product.getSellingPrice()), Double.toString(product.getQuantity())});
			}
			jTable2.setModel(model);
		}
		catch(Exception e)
        {
        	log.error("Error when loading StockView. Exception: ", e);
        	throw e;
        }
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{
		jPanel1 = new javax.swing.JPanel();
		jTextField_NomeProduto = new javax.swing.JTextField();
		jButton_PesquisarProduto = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton_AdicionarProduto = new javax.swing.JButton();
		jButton_EditarProduto = new javax.swing.JButton();
		jButton_ExcluirProduto = new javax.swing.JButton();
		jButton_Cancelar = new javax.swing.JButton();
		jButton_ConfirmarProduto = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Cadastro de Produto");
		setBounds(new java.awt.Rectangle(450, 300, 0, 0));

		jButton_PesquisarProduto.setText("Pesquisar");
		jButton_PesquisarProduto.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
            	{
					jButton_PesquisarProdutoActionPerformed(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
			}
		});

		jTable2.setModel(new javax.swing.table.DefaultTableModel(null, new String[] {"Código", "Descrição", "Preço Compra", "Preço Venda", "Quantidade"})
		{
			private static final long serialVersionUID = 1725313209337348693L;

			@Override
			public boolean isCellEditable(int rowIndex, int mColIndex)
			{
				log.info("Load Product's info: code, description, purchase price, selling price and quantity.");
				return false;
			}	
		});
		
		jTable2.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				try
            	{
					jTable2MouseClicked(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
			}
		});
		
		jScrollPane1.setViewportView(jTable2);

		jButton_AdicionarProduto.setText("Adicionar Produto");
		jButton_AdicionarProduto.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
            	{
					jButton_AdicionarProdutoActionPerformed(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
			}
		});

		jButton_EditarProduto.setText("Editar");
		jButton_EditarProduto.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
            	{
					jButton_EditarProdutoActionPerformed(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
			}
		});

		jButton_ExcluirProduto.setText("Excluir");
		jButton_ExcluirProduto.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
            	{
					jButton_ExcluirProdutoActionPerformed(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
			}
		});

		jButton_Cancelar.setText("Sair");
		jButton_Cancelar.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
            	{
					jButton_CancelarActionPerformed(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
			}
		});

		jButton_ConfirmarProduto.setText("Confirmar");
		jButton_ConfirmarProduto.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
            	{
					jButton_ConfirmarProdutoActionPerformed(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
			}
		});

		jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel1.setText("Cadastro de Produto");

		jLabel2.setText("Pesquisar Produto pelo Código ou Descrição:");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								jPanel1Layout.createSequentialGroup().addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
												jPanel1Layout.createSequentialGroup().addComponent(jButton_Cancelar).addGap(65, 65, 65).addComponent(jLabel1)).addGroup(
												jPanel1Layout.createSequentialGroup().addComponent(jTextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 227,
														javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
														jButton_PesquisarProduto))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(
								jPanel1Layout.createSequentialGroup().addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(jButton_ConfirmarProduto).addGroup(
												jPanel1Layout.createSequentialGroup().addGroup(
														jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jButton_AdicionarProduto).addComponent(jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(
														jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jButton_ExcluirProduto).addComponent(
																jButton_EditarProduto)))).addGap(0, 0, Short.MAX_VALUE)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jButton_Cancelar))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(jLabel1))).addGap(20, 20, 20).addComponent(jLabel2).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_NomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton_PesquisarProduto)).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton_AdicionarProduto).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								jPanel1Layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addComponent(jButton_EditarProduto).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										jButton_ExcluirProduto).addGap(33, 33, 33))).addComponent(jButton_ConfirmarProduto)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Searches for a product from the name
	private void jButton_PesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_PesquisarProdutoActionPerformed
		try
		{
			/// Describes the result of product name and jTextField_NomeProduto text comparison
			boolean nameProductEquals = "".equals(jTextField_NomeProduto.getText());
			
			if(nameProductEquals == true)
			{
				loadList();
				
				if(jTable2.getRowCount() == 0)
				{
					showMessage("Nenhum produto fora cadastrado até o momento.");
					log.info("No product was added until now.");
				}
				else
				{
					// Nothing to do
				}
			}
			else
			{
				Product otherProduct = objectStockController.searchProduct(jTextField_NomeProduto.getText(), true);
				DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();  
				
				model1.setRowCount(0);
				jTable2.setModel(model1);
	
				ArrayList<Product> testList = objectStockController.getProductList();
				
				int sizeOfTestList = testList.size();
	
				if(sizeOfTestList == 0)
				{
					showMessage("Nenhum produto foi cadastrado até o momento.");
					log.info("No product was registered until now.");
	
				}
				else if(otherProduct == null)
				{
					showMessage("Produto não encontrado!");
					log.info("Product not found!");
				}
				else
				{
					model1.addRow(new String[] {otherProduct.getCode(), otherProduct.getDescription(), Double.toString(otherProduct.getPurchasePrice()), Double.toString(otherProduct.getSellingPrice()),
							Double.toString(otherProduct.getQuantity())});
					jTextField_NomeProduto.setText(otherProduct.getCode());
				}
			}
		}
		catch(Exception e)
		{
			log.error("Error when searching Product. Exception: ", e);
			throw e; 
		}
	}// GEN-LAST:event_jButton_PesquisarProdutoActionPerformed

	// Opens the view ProductDataView for add a new product
	private void jButton_AdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_AdicionarProdutoActionPerformed
		try
		{
			new ProductDataView().setVisible(true);
			this.setVisible(false);
		}
		catch(Exception e)
        {
        	log.error("Error when adding Product. Exception: ", e);
        	throw e; 
        }
	}// GEN-LAST:event_jButton_AdicionarProdutoActionPerformed

	// Cancels the operation and close the screen
	private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_CancelarActionPerformed
		try
		{
			log.debug("Exit StockView");
			this.dispose();
			
			if(productMode == true)
			{
				new SalePurchaseView().setVisible(true);
			}
			else
			{
				// Nothing to do
			}
		}
		catch(Exception e)
        {
        	log.error("Error when exiting StockView. Exception: ", e);
        	throw e; 
        }
	}// GEN-LAST:event_jButton_CancelarActionPerformed

	// Opens the view ProductDataView for edit the product information
	private void jButton_EditarProdutoActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_EditarProdutoActionPerformed
		try
		{
			newProduct = false;
			new ProductDataView().setVisible(true);
		}
		catch(Exception e)
    	{
    		log.error("Error when editing Product. Exception: ", e);
    		throw e;   
    	}
	}// GEN-LAST:event_jButton_EditarProdutoActionPerformed

	// Select an item in the table and enable the options edit, delete and confirms
	private void jTable2MouseClicked(java.awt.event.MouseEvent evt) throws Exception
	{// GEN-FIRST:event_jTable2MouseClicked
		try
		{
			DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
			codeTable = (String) model.getValueAt(jTable2.getSelectedRow(), 0);
			tableDescription = (String) model.getValueAt(jTable2.getSelectedRow(), 1);
			jButton_EditarProduto.setEnabled(true);
			jButton_ExcluirProduto.setEnabled(true);
			jButton_ConfirmarProduto.setEnabled(true);
		}
		catch(Exception e)
    	{
    		log.error("Error when clicking on Product's info. Exception: ", e);
    		throw e;   
    	}
	}// GEN-LAST:event_jTable2MouseClicked

	// Removes a product from the table
	private void jButton_ExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_ExcluirProdutoActionPerformed
		try
		{
			objectStockController.removeProduct(objectStockController.searchProduct(codeTable, false));
			loadList();
			log.debug("Product deleted!");
			jButton_EditarProduto.setEnabled(false);
			jButton_ExcluirProduto.setEnabled(false);
		}
		catch(Exception e)
    	{
    		log.error("Error when deleting Product. Exception: ", e);
    		throw e;   
    	}
	}// GEN-LAST:event_jButton_ExcluirProdutoActionPerformed

	// Confirms the operation
	private void jButton_ConfirmarProdutoActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_ConfirmarProdutoActionPerformed
		try
		{
			returnProduct = true;
			productMode = false;
			log.debug("Product confirmed!");
			this.dispose();
			new SalePurchaseView().setVisible(true);
		}
		catch(Exception e)
    	{
    		log.error("Error when confirming Product. Exception: ", e);
    		throw e;   
    	}
	}// GEN-LAST:event_jButton_ConfirmarProdutoActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try
		{
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
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
			java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			log.error("ClassNotFoundException: ", ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			log.error("InstantiationException: ", ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			log.error("IllegalAccessException: ", ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(StockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			log.error("UnsupportedLookAndFeelException: ", ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					new StockView().setVisible(true);
				}
				catch(Exception e)
            	{
            		log.error("Error when running StockView. Exception: ", e);
            		try
					{
						throw e;
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}   
            	}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton_AdicionarProduto;
	private javax.swing.JButton jButton_Cancelar;
	private javax.swing.JButton jButton_ConfirmarProduto;
	private javax.swing.JButton jButton_EditarProduto;
	private javax.swing.JButton jButton_ExcluirProduto;
	private javax.swing.JButton jButton_PesquisarProduto;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField_NomeProduto;
	// End of variables declaration//GEN-END:variables
}
