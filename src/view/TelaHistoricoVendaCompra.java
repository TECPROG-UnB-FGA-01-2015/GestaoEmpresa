/***********************************************************
 * File: TelaHistoricoVendaCompra.java
 * Purpose: Responsible to get the Product's Buying and Selling Historic info.
 **********************************************************/

package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Purchase;
import model.Transaction;
import model.Sale;
import static view.TelaVendaCompra.umControleTransacao;

public class TelaHistoricoVendaCompra extends javax.swing.JFrame
{

	private int statusVendaCompra = 0;
	Sale umaVenda;
	Purchase umaCompra;

	// Variables declaration (do not modify) - GEN-BEGIN:variables
	private javax.swing.JButton jButton_sair;
	private javax.swing.JComboBox jComboBox_VendaCompra;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable_Historico;

	// End of variables declaration - GEN-END:variables

	/* This method is responsible to load Shopping/Selling list on the GUI
	 * (Graphical User Interface) screen */
	public TelaHistoricoVendaCompra()
	{
		initComponents();
		carregarLista();
	}

	/* This method is responsible to show the Shopping/Selling list info, as:
	 * Client/Provider name, responsible worker, transaction value and date
	 * (date/month/year) */
	private void carregarLista()
	{
		ArrayList<Transaction> listaTransacao = umControleTransacao
		        .getListaVenda();
		DefaultTableModel model = (DefaultTableModel) jTable_Historico
		        .getModel();
		model.setRowCount(0);
		for (Transaction t : listaTransacao)
		{
			if (statusVendaCompra == 0)
			{
				if (t.getClass().equals(Sale.class))
				{
					umaVenda = (Sale) t;
					String data = Integer.toString(umaVenda.getDay()) + "/"
					        + Integer.toString(umaVenda.getMonth()) + "/"
					        + Integer.toString(umaVenda.getYear());
					model.addRow(new String[]
					{ umaVenda.getClient().getName(),
					        umaVenda.getEmployee().getName(),
					        Double.toString(umaVenda.getPrice()), data });
				}
				else
				{
					// Nothing to Do
				}
			}
			else if (statusVendaCompra == 1)
			{
				if (t.getClass().equals(Purchase.class))
				{
					umaCompra = (Purchase) t;
					String data = Integer.toString(umaCompra.getDay()) + "/"
					        + Integer.toString(umaCompra.getMonth()) + "/"
					        + Integer.toString(umaCompra.getYear());
					model.addRow(new String[]
					{ umaCompra.getFornecedor().getNome(),
					        umaCompra.getEmployee().getName(),
					        Double.toString(umaCompra.getPrice()), data });
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
		jTable_Historico.setModel(model);
	}

	@SuppressWarnings("unchecked")
	/* This method is responsible to create and show all the GUI's
	 * components/frameworks (with buttons, texts, lists ...) about the
	 * Shopping/Selling info on the screen */
	private void initComponents()
	{

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable_Historico = new javax.swing.JTable();
		jComboBox_VendaCompra = new javax.swing.JComboBox();
		jButton_sair = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Historico de Vendas");
		setBounds(new java.awt.Rectangle(450, 300, 0, 0));

		jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel1.setText("Historico de Vendas");

		jTable_Historico
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
		jScrollPane1.setViewportView(jTable_Historico);

		jComboBox_VendaCompra
		        .setModel(new javax.swing.DefaultComboBoxModel(new String[]
		        { "Venda", "Compra" }));
		jComboBox_VendaCompra.addItemListener(new java.awt.event.ItemListener()
		{
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				jComboBox_VendaCompraItemStateChanged(evt);
			}
		});

		jButton_sair.setText("Sair");
		jButton_sair.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_sairActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
		        .setHorizontalGroup(jPanel1Layout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGap(0, 673, Short.MAX_VALUE)
		                .addGroup(jPanel1Layout
		                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addGroup(jPanel1Layout
		                                .createSequentialGroup()
		                                .addContainerGap()
		                                .addGroup(jPanel1Layout
		                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                        .addGroup(jPanel1Layout
		                                                .createSequentialGroup()
		                                                .addComponent(jButton_sair)
		                                                .addGap(159, 159, 159)
		                                                .addComponent(jLabel1))
		                                        .addGroup(jPanel1Layout
		                                                .createSequentialGroup()
		                                                .addGap(50, 50, 50)
		                                                .addGroup(jPanel1Layout
		                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                        .addComponent(jComboBox_VendaCompra,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                        .addComponent(jScrollPane1,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                      611,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE))))
		                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                 Short.MAX_VALUE))));
		jPanel1Layout
		        .setVerticalGroup(jPanel1Layout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGap(0, 299, Short.MAX_VALUE)
		                .addGroup(jPanel1Layout
		                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addGroup(jPanel1Layout
		                                .createSequentialGroup()
		                                .addContainerGap()
		                                .addGroup(jPanel1Layout
		                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                        .addComponent(jButton_sair)
		                                        .addComponent(jLabel1))
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                .addComponent(jComboBox_VendaCompra,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
		                                                 javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                 Short.MAX_VALUE)
		                                .addComponent(jScrollPane1,
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
		                          .addComponent(jPanel1,
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
		                          .addComponent(jPanel1,
		                                        javax.swing.GroupLayout.PREFERRED_SIZE,
		                                        javax.swing.GroupLayout.DEFAULT_SIZE,
		                                        javax.swing.GroupLayout.PREFERRED_SIZE)
		                          .addContainerGap()));

		pack();
	}

	// This method is responsible to confirm the Screen's Exit Button Action
	private void jButton_sairActionPerformed(java.awt.event.ActionEvent evt)
	{
		this.dispose();
	}

	/*
	 * This method is responsible to display two choose options on the same
	 * button: Shopping/Selling list info (Client/Provider name, responsible
	 * worker, transaction value and date (date/month/year)
	 */
	private void jComboBox_VendaCompraItemStateChanged(
	        java.awt.event.ItemEvent evt)
	{
		if (jComboBox_VendaCompra.getSelectedIndex() == 0)
		{
			statusVendaCompra = 0;
			jLabel1.setText("Historico de Vendas");
		}
		else if (jComboBox_VendaCompra.getSelectedIndex() == 1)
		{
			statusVendaCompra = 1;
			jLabel1.setText("Historico de Compras");
		}
		else
		{
			// Nothing to Do
		}
		carregarLista();
	}

	/*
	 * This main method is responsible to enable the Nimbus (GUI) Interface and
	 * display all the Shopping/Selling list info with a log system
	 */
	public static void main(String args[])
	{

		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
			        .getInstalledLookAndFeels())
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
			java.util.logging.Logger
			        .getLogger(TelaHistoricoVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger
			        .getLogger(TelaHistoricoVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger
			        .getLogger(TelaHistoricoVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger
			        .getLogger(TelaHistoricoVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new TelaHistoricoVendaCompra().setVisible(true);
			}
		});
	}

}
