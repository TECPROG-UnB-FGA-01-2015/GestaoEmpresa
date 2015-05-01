/***********************************************************
 * File: SalePurchaseHistoricView.java
 * Purpose: Responsible to get the Product's Buying and Selling Historic info.
 **********************************************************/

package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Purchase;
import model.Transaction;
import model.Sale;
import static view.SalePurchaseView.objectTransactionController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTable;

public class SalePurchaseHistoricView extends javax.swing.JFrame
{
	private int salePurchaseStatus = 0; // Shows the Client's name when option is 0 (Selling) and Supplier's name when option is 1 (Buying)
	Sale objectSale; // Shows Client's name, Worker's name, Transaction value and Sale Product Date
	Purchase objectPurchase; // Shows Supplier's name, Worker's name, Transaction value and Shopping Product Date

	private JButton jButton_exitScreen; // Exit the Historic Buying/Selling Products Screen
	private JComboBox jComboBox_showSalePurchase; // Shows a drop-down list with Historic Buying/Sale option
	private JLabel jLabel_showSalePurchaseHistoricWord; // Shows the "Purchase/Sales Historic" word on the screen
	private JPanel jPanel_showEntireHistoricScreen; // Shows the entire Sales Historic's screen layout
	private JScrollPane jScrollPane_showSalePurchaseHistoricScreenScroll; // Shows the Sales Historic's screen scroll 
	private JTable jTable_showPurchaseSaleHistoricInfoTable; // Shows a table with the Sales Historic's product code, description, quantity, price and final price (with/without discount)

	/* Constructor of SalePurchaseHistoricView 
	 * Loads Purchase/Selling list on the screen */
	public SalePurchaseHistoricView()
	{
		initComponents();
		loadList();
	}

	/* This method is responsible to show the Shopping/Selling list info, as:
	 * Client/Provider name, responsible employee, transaction value and date
	 * (date/month/year) */
	private void loadList()
	{
		ArrayList<Transaction> transactionList = objectTransactionController.getSaleList();
		DefaultTableModel model = (DefaultTableModel) jTable_showPurchaseSaleHistoricInfoTable.getModel();
		model.setRowCount(0);
		for (Transaction transaction : transactionList)
		{
			if (salePurchaseStatus == 0)
			{
				if (transaction.getClass().equals(Sale.class))
				{
					objectSale = (Sale) transaction;
					
					String data = Integer.toString(objectSale.getDay()) + "/" + 
								Integer.toString(objectSale.getMonth()) + "/" + Integer.toString(objectSale.getYear());
					
					model.addRow(new String[]
					{ 
						objectSale.getClient().getName(),
						objectSale.getEmployee().getName(),
				        Double.toString(objectSale.getPrice()),
				        data 
					});
				}
				else
				{
					// Nothing to Do
				}
			}
			else if (salePurchaseStatus == 1)
			{
				if (transaction.getClass().equals(Purchase.class))
				{
					objectPurchase = (Purchase) transaction;
					String data = Integer.toString(objectPurchase.getDay()) + "/"
					        + Integer.toString(objectPurchase.getMonth()) + "/" + Integer.toString(objectPurchase.getYear());
					model.addRow(new String[]
					{ 
						objectPurchase.getSupplier().getName(),
						objectPurchase.getEmployee().getName(),
				        Double.toString(objectPurchase.getPrice()), 
				        data 
				    });
				}
				else
				{
					// Nothing to Do
				}
			}
			else
			{
				// Nothing to Do
			}

		}
		jTable_showPurchaseSaleHistoricInfoTable.setModel(model);
	}

	@SuppressWarnings("unchecked")
	/* This method is responsible to create and show all the GUI's
	 * components/frameworks (with buttons, texts, lists ...) about the
	 * Shopping/Selling info on the screen */
	private void initComponents()
	{
		jPanel_showEntireHistoricScreen = new JPanel();
		jLabel_showSalePurchaseHistoricWord = new JLabel();
		jScrollPane_showSalePurchaseHistoricScreenScroll = new JScrollPane();
		jTable_showPurchaseSaleHistoricInfoTable = new JTable();
		jComboBox_showSalePurchase = new JComboBox();
		jButton_exitScreen = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Historico de Vendas");
		setBounds(new java.awt.Rectangle(450, 300, 0, 0));

		jLabel_showSalePurchaseHistoricWord.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel_showSalePurchaseHistoricWord.setText("Historico de Vendas");

		jTable_showPurchaseSaleHistoricInfoTable
		        .setModel(new javax.swing.table.DefaultTableModel(null,
		                                                          new String[]
		                                                          {
		                                                                  "Nome Cliente/Fornecedor",
		                                                                  "Funcionario Responsavel",
		                                                                  "Valor da Transacao",
		                                                                  "Data" })
		        {
			        @Override
			        public boolean isCellEditable(int rowIndex, int mColIndex)
			        {
				        return false;
			        }
		        });
		jScrollPane_showSalePurchaseHistoricScreenScroll.setViewportView(jTable_showPurchaseSaleHistoricInfoTable);

		jComboBox_showSalePurchase
		        .setModel(new javax.swing.DefaultComboBoxModel(new String[]
		        { "Venda", "Compra" }));
		jComboBox_showSalePurchase.addItemListener(new java.awt.event.ItemListener()
		{
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				jComboBox_showSalePurchaseItemStateChanged(evt);
			}
		});

		jButton_exitScreen.setText("Sair");
		jButton_exitScreen.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_exitScreenActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel_showEntireHistoricScreenLayout = new javax.swing.GroupLayout(jPanel_showEntireHistoricScreen);
		jPanel_showEntireHistoricScreen.setLayout(jPanel_showEntireHistoricScreenLayout);
		jPanel_showEntireHistoricScreenLayout
		        .setHorizontalGroup(jPanel_showEntireHistoricScreenLayout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGap(0, 673, Short.MAX_VALUE)
		                .addGroup(jPanel_showEntireHistoricScreenLayout
		                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addGroup(jPanel_showEntireHistoricScreenLayout
		                                .createSequentialGroup()
		                                .addContainerGap()
		                                .addGroup(jPanel_showEntireHistoricScreenLayout
		                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                        .addGroup(jPanel_showEntireHistoricScreenLayout
		                                                .createSequentialGroup()
		                                                .addComponent(jButton_exitScreen)
		                                                .addGap(159, 159, 159)
		                                                .addComponent(jLabel_showSalePurchaseHistoricWord))
		                                        .addGroup(jPanel_showEntireHistoricScreenLayout
		                                                .createSequentialGroup()
		                                                .addGap(50, 50, 50)
		                                                .addGroup(jPanel_showEntireHistoricScreenLayout
		                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                        .addComponent(jComboBox_showSalePurchase,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                        .addComponent(jScrollPane_showSalePurchaseHistoricScreenScroll,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                      611,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE))))
		                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                 Short.MAX_VALUE))));
		jPanel_showEntireHistoricScreenLayout
		        .setVerticalGroup(jPanel_showEntireHistoricScreenLayout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGap(0, 299, Short.MAX_VALUE)
		                .addGroup(jPanel_showEntireHistoricScreenLayout
		                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addGroup(jPanel_showEntireHistoricScreenLayout
		                                .createSequentialGroup()
		                                .addContainerGap()
		                                .addGroup(jPanel_showEntireHistoricScreenLayout
		                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                        .addComponent(jButton_exitScreen)
		                                        .addComponent(jLabel_showSalePurchaseHistoricWord))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                .addComponent(jComboBox_showSalePurchase,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
		                                                 javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                 Short.MAX_VALUE)
		                                .addComponent(jScrollPane_showSalePurchaseHistoricScreenScroll,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              207,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addContainerGap())));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
		        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		                  layout.createSequentialGroup()
		                          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                           Short.MAX_VALUE)
		                          .addComponent(jPanel_showEntireHistoricScreen,
		                                        javax.swing.GroupLayout.PREFERRED_SIZE,
		                                        javax.swing.GroupLayout.DEFAULT_SIZE,
		                                        javax.swing.GroupLayout.PREFERRED_SIZE)
		                          .addContainerGap()));
		layout.setVerticalGroup(layout
		        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		                  layout.createSequentialGroup()
		                          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                           Short.MAX_VALUE)
		                          .addComponent(jPanel_showEntireHistoricScreen,
		                                        javax.swing.GroupLayout.PREFERRED_SIZE,
		                                        javax.swing.GroupLayout.DEFAULT_SIZE,
		                                        javax.swing.GroupLayout.PREFERRED_SIZE)
		                          .addContainerGap()));

		pack();
	}

	// This method is responsible to confirm the Screen's Exit Button Action
	private void jButton_exitScreenActionPerformed(java.awt.event.ActionEvent evt)
	{
		this.dispose();
	}

	/*
	 * This method is responsible to display two choose options on the same
	 * button: Shopping/Selling list info (Client/Provider name, responsible
	 * employee, transaction value and date (date/month/year)
	 */
	private void jComboBox_showSalePurchaseItemStateChanged(
	        java.awt.event.ItemEvent evt)
	{
		int comboSalePurchaseStatus = jComboBox_showSalePurchase.getSelectedIndex();
		if (comboSalePurchaseStatus == 0)
		{
			salePurchaseStatus = 0;
			jLabel_showSalePurchaseHistoricWord.setText("Historico de Vendas");
		}
		else if (comboSalePurchaseStatus == 1)
		{
			salePurchaseStatus = 1;
			jLabel_showSalePurchaseHistoricWord.setText("Historico de Compras");
		}
		else
		{
			// Nothing to Do
		}
		loadList();
	}

	/*
	 * This main method is responsible to enable the Nimbus (GUI) Interface and
	 * display all the Shopping/Selling list info with a log system
	 */
	public static void main(String args[])
	{
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
					// Nothing to Do
				}
			}
		}
		catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(SalePurchaseHistoricView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(SalePurchaseHistoricView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(SalePurchaseHistoricView.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger
			        .getLogger(SalePurchaseHistoricView.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new SalePurchaseHistoricView().setVisible(true);
			}
		});
	}

}
