/***********************************************************
 * File: TelaVendaCompra.java
 * Purpose: Responsible to get the Product's Buying and Selling info
 **********************************************************/

package view;

import controller.ControleTransacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Compra;
import model.Despesa;
import model.Fornecedor;
import model.Funcionario;
import model.Produto;
import model.Venda;
import static view.TelaContatos.nomeClienteFornecedor;
import static view.TelaContatos.nomeFuncionario;
import static view.TelaDadosProdutos.umControleEstoque;
import static view.TelaEstoque.codigoTabela;
import static view.TelaEstoque.descricaoTabela;

public class TelaVendaCompra extends javax.swing.JFrame
{

	// Variables declaration (do not modify) - GEN-BEGIN:variables
	private javax.swing.JButton jButton_AdicionarProduto;
	private javax.swing.JButton jButton_Cancelar;
	private javax.swing.JButton jButton_Finalizar;
	private javax.swing.JButton jButton_PesquisarClienteFornecedor;
	private javax.swing.JButton jButton_PesquisarFuncionario;
	private javax.swing.JButton jButton_PesquisarProduto;
	private javax.swing.JButton jButton_RemoverProduto;
	private javax.swing.JComboBox jComboBox_VendaCompra;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField_CodigoProduto;
	private javax.swing.JTextField jTextField_Desconto;
	private javax.swing.JTextField jTextField_DescricaoProduto;
	private javax.swing.JTextField jTextField_NomeClienteFornecedor;
	private javax.swing.JTextField jTextField_NomeFuncionario;
	private javax.swing.JTextField jTextField_Quantidade;
	private javax.swing.JTextField jTextField_Valor;
	// End of variables declaration - GEN-END:variables

	GestaoEmpresa principal;
	public static int statusVendaCompra = 0;
	static boolean modoVendaCompra = false;
	static boolean modoClienteFornecedor = false;
	static boolean modoFuncionario = false;
	static boolean modoProduto = false;
	static ControleTransacao umControleTransacao = new ControleTransacao();
	Produto editProduto;
	Produto vendaProduto = new Produto();
	Produto compraProduto = new Produto();
	Venda umaVenda;
	Compra umaCompra;
	double valor = 0;
	Date date = new Date();
	DateFormat Dia = new SimpleDateFormat("dd");
	String dia = Dia.format(date);
	DateFormat Mes = new SimpleDateFormat("MM");
	String mes = Mes.format(date);
	DateFormat Ano = new SimpleDateFormat("yyyy");
	String ano = Ano.format(date);

	static ArrayList<Produto> listaTabelaProduto = new ArrayList<Produto>();

	// This method is responsible to show a specific info as a Text Box
	public void exibirInformacao(String info)
	{
		JOptionPane.showMessageDialog(this,
		                              info,
		                              "Atenção",
		                              JOptionPane.INFORMATION_MESSAGE);
	}

	/* This method is responsible to display a GUI so that the User can choose
	 * the Clients/Providers' names search products' names, add products, remove
	 * products, buy and sell products according to their quantities */
	public TelaVendaCompra()
	{
		initComponents();
		jTextField_NomeClienteFornecedor.setEnabled(false);
		jTextField_NomeFuncionario.setEnabled(false);
		jTextField_CodigoProduto.setEnabled(false);
		jTextField_Valor.setEnabled(false);
		jTextField_Quantidade.setEnabled(false);
		jTextField_Desconto.setEnabled(false);
		jTextField_DescricaoProduto.setEnabled(false);
		jButton_AdicionarProduto.setEnabled(false);
		jButton_RemoverProduto.setEnabled(false);
		if (TelaContatos.returnClienteFornecedor == true)
		{
			jTextField_NomeClienteFornecedor
			        .setText(TelaContatos.nomeClienteFornecedor);
		}
		else 
		{
			// Nothing to Do
		}
		if (TelaContatos.returnFuncionario == true)
		{
			jTextField_NomeFuncionario.setText(TelaContatos.nomeFuncionario);
		}
		else
		{
			// Nothing to Do
		}
		if (TelaEstoque.returnProduto == true)
		{
			jTextField_CodigoProduto.setText(codigoTabela);
			jTextField_DescricaoProduto.setText(descricaoTabela);
			editProduto = umControleEstoque.pesquisarProduto(codigoTabela,
			                                                 false);
			vendaProduto.setCodigo(editProduto.getCodigo());
			vendaProduto.setPreco(editProduto.getPrecoVenda());
			vendaProduto.setQuantidade(editProduto.getQuantidade());
			vendaProduto.setDescricao(editProduto.getDescricao());
			compraProduto.setCodigo(editProduto.getCodigo());
			compraProduto.setPreco(editProduto.getPrecoCompra());
			compraProduto.setQuantidade(editProduto.getQuantidade());
			compraProduto.setDescricao(editProduto.getDescricao());
			if (statusVendaCompra == 0)
			{
				jTextField_Valor.setText(Double.toString(editProduto
				        .getPrecoVenda()));
			}
			else if (statusVendaCompra == 1)
			{
				jTextField_Valor.setText(Double.toString(editProduto
				        .getPrecoCompra()));
			jTextField_Quantidade.setEnabled(true);
			}
			if (statusVendaCompra == 0)
			{
				jTextField_Desconto.setEnabled(true);
			}
			else if (statusVendaCompra == 1)
			{
				jTextField_Desconto.setEnabled(false);
			jButton_AdicionarProduto.setEnabled(true);
			}
		}
		else
		{
			// Nothing to Do
		}
		if (statusVendaCompra == 0)
		{
			jComboBox_VendaCompra.setSelectedIndex(0);
		}
		else if (statusVendaCompra == 1)
		{
			jComboBox_VendaCompra.setSelectedIndex(1);
		}
		if (modoProduto == true)
		{
			jTextField_CodigoProduto.setText(codigoTabela);
			jTextField_DescricaoProduto.setText(descricaoTabela);
		}
		else
		{
			// Nothing to Do
		}
		if (modoClienteFornecedor == true)
		{
			jTextField_NomeClienteFornecedor.setText(nomeClienteFornecedor);
		}
		else
		{
			// Nothing to Do			
		}
		if (modoFuncionario == true)
		{
			jTextField_NomeFuncionario.setText(nomeFuncionario);
		carregarLista();
		}
		else
		{
			// Nothing to Do
		}
		if (statusVendaCompra == 0)
		{
			jLabel1.setText("Cliente:");
		}
		else if (statusVendaCompra == 1)
		{
			jLabel1.setText("Fornecedor:");
		}
	}

	/* This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify the content of this method, because it was
	 * regenerated by the Form Editor. */
	@SuppressWarnings("unchecked")
	/* This method is responsible to create and show all the GUI's
	 * components/frameworks (with buttons, texts, lists ...) about the
	 * Shopping/Selling info on the screen */
	private void initComponents()
	{

		jPanel1 = new javax.swing.JPanel();
		jButton_Cancelar = new javax.swing.JButton();
		jTextField_Valor = new javax.swing.JTextField();
		jButton_PesquisarFuncionario = new javax.swing.JButton();
		jButton_AdicionarProduto = new javax.swing.JButton();
		jTextField_Quantidade = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jTextField_CodigoProduto = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton_PesquisarProduto = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField_NomeClienteFornecedor = new javax.swing.JTextField();
		jButton_Finalizar = new javax.swing.JButton();
		jButton_PesquisarClienteFornecedor = new javax.swing.JButton();
		jTextField_NomeFuncionario = new javax.swing.JTextField();
		jComboBox_VendaCompra = new javax.swing.JComboBox();
		jLabel6 = new javax.swing.JLabel();
		jButton_RemoverProduto = new javax.swing.JButton();
		jTextField_Desconto = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jTextField_DescricaoProduto = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Lançamento Venda/Compra");
		setBounds(new java.awt.Rectangle(450, 300, 0, 0));

		jButton_Cancelar.setText("Sair");
		jButton_Cancelar.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_CancelarActionPerformed(evt);
			}
		});

		jTextField_Valor.setText("0.00");

		jButton_PesquisarFuncionario.setText("Pesquisar");
		jButton_PesquisarFuncionario
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_PesquisarFuncionarioActionPerformed(evt);
			        }
		        });

		jButton_AdicionarProduto.setText("+");
		jButton_AdicionarProduto
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_AdicionarProdutoActionPerformed(evt);
			        }
		        });

		jTextField_Quantidade.setText("0.0");

		jLabel1.setText("Cliente:");

		jLabel2.setText("Funcionário:");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(null,
		                                                         new String[]
		                                                         {
		                                                                 "Código",
		                                                                 "Descrição",
		                                                                 "Quantidade",
		                                                                 "Preço",
		                                                                 "Preço Final" })
		{
			@Override
			public boolean isCellEditable(int rowIndex, int mColIndex)
			{
				return false;
			}
		});
		jTable1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jTable1MouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jButton_PesquisarProduto.setText("Pesquisar");
		jButton_PesquisarProduto
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_PesquisarProdutoActionPerformed(evt);
			        }
		        });

		jLabel4.setText("Quantidade:");

		jLabel3.setText("Produto:");

		jLabel5.setText("Valor:");

		jButton_Finalizar.setText("Finalizar");
		jButton_Finalizar.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_FinalizarActionPerformed(evt);
			}
		});

		jButton_PesquisarClienteFornecedor.setText("Pesquisar");
		jButton_PesquisarClienteFornecedor
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_PesquisarClienteFornecedorActionPerformed(evt);
			        }
		        });

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

		jLabel6.setText("Desconto:");

		jButton_RemoverProduto.setText("-");
		jButton_RemoverProduto
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_RemoverProdutoActionPerformed(evt);
			        }
		        });

		jTextField_Desconto.setText("0.0");
		jTextField_Desconto.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				jTextField_DescontoFocusLost(evt);
			}
		});

		jLabel7.setText("%");

		jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel8.setText("Lançamento Venda");

		jLabel9.setText("Operação:");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
		        .setHorizontalGroup(jPanel1Layout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGroup(jPanel1Layout
		                        .createSequentialGroup()
		                        .addGap(13, 13, 13)
		                        .addGroup(jPanel1Layout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addGroup(jPanel1Layout
		                                        .createSequentialGroup()
		                                        .addGroup(jPanel1Layout
		                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                .addGroup(jPanel1Layout
		                                                        .createSequentialGroup()
		                                                        .addComponent(jLabel9)
		                                                        .addGap(148,
		                                                                148,
		                                                                148)
		                                                        .addComponent(jComboBox_VendaCompra,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE))
		                                                .addGroup(jPanel1Layout
		                                                        .createSequentialGroup()
		                                                        .addGap(20,
		                                                                20,
		                                                                20)
		                                                        .addComponent(jButton_Cancelar)
		                                                        .addGap(64,
		                                                                64,
		                                                                64)
		                                                        .addComponent(jLabel8)))
		                                        .addGap(0, 0, Short.MAX_VALUE))
		                                .addComponent(jScrollPane1)
		                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		                                          jPanel1Layout
		                                                  .createSequentialGroup()
		                                                  .addGroup(jPanel1Layout
		                                                          .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                                                          .addGroup(jPanel1Layout
		                                                                  .createSequentialGroup()
		                                                                  .addComponent(jLabel5)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jTextField_Valor,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                65,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                                                  .addComponent(jLabel4)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jTextField_Quantidade,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                52,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jLabel6)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jTextField_Desconto,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                55,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jLabel7))
		                                                          .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
		                                                                    jPanel1Layout
		                                                                            .createSequentialGroup()
		                                                                            .addGroup(jPanel1Layout
		                                                                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                                                    .addComponent(jLabel2)
		                                                                                    .addComponent(jLabel1,
		                                                                                                  javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                                  96,
		                                                                                                  javax.swing.GroupLayout.PREFERRED_SIZE))
		                                                                            .addGap(49,
		                                                                                    49,
		                                                                                    49)
		                                                                            .addGroup(jPanel1Layout
		                                                                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                                                    .addComponent(jTextField_NomeFuncionario)
		                                                                                    .addComponent(jTextField_NomeClienteFornecedor)
		                                                                                    .addComponent(jTextField_DescricaoProduto)))
		                                                          .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
		                                                                    jPanel1Layout
		                                                                            .createSequentialGroup()
		                                                                            .addComponent(jLabel3)
		                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                            .addComponent(jTextField_CodigoProduto,
		                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                          60,
		                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
		                                                                                             javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                                                             Short.MAX_VALUE)))
		                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                  .addGroup(jPanel1Layout
		                                                          .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		                                                                    jPanel1Layout
		                                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                                            .addComponent(jButton_PesquisarProduto)
		                                                                            .addComponent(jButton_PesquisarFuncionario)
		                                                                            .addComponent(jButton_PesquisarClienteFornecedor))
		                                                          .addComponent(jButton_RemoverProduto,
		                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
		                                                          .addComponent(jButton_AdicionarProduto,
		                                                                        javax.swing.GroupLayout.Alignment.TRAILING))))
		                        .addContainerGap())
		                .addGroup(jPanel1Layout
		                        .createSequentialGroup()
		                        .addGap(207, 207, 207)
		                        .addComponent(jButton_Finalizar)
		                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                         Short.MAX_VALUE)));

		jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		                       new java.awt.Component[]
		                       { jButton_PesquisarClienteFornecedor,
		                               jButton_PesquisarFuncionario,
		                               jButton_PesquisarProduto });

		jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		                       new java.awt.Component[]
		                       { jButton_Finalizar, jComboBox_VendaCompra });

		jPanel1Layout
		        .setVerticalGroup(jPanel1Layout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGroup(jPanel1Layout
		                        .createSequentialGroup()
		                        .addContainerGap()
		                        .addGroup(jPanel1Layout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addGroup(jPanel1Layout
		                                        .createSequentialGroup()
		                                        .addGap(1, 1, 1)
		                                        .addComponent(jLabel8))
		                                .addComponent(jButton_Cancelar,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              29,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addGroup(jPanel1Layout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addGroup(jPanel1Layout
		                                        .createSequentialGroup()
		                                        .addGap(12, 12, 12)
		                                        .addComponent(jComboBox_VendaCompra,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE))
		                                .addGroup(jPanel1Layout
		                                        .createSequentialGroup()
		                                        .addGap(18, 18, 18)
		                                        .addComponent(jLabel9)))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(jPanel1Layout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                .addComponent(jTextField_NomeClienteFornecedor,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addComponent(jLabel1)
		                                .addComponent(jButton_PesquisarClienteFornecedor))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(jPanel1Layout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                .addComponent(jTextField_NomeFuncionario,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addComponent(jButton_PesquisarFuncionario)
		                                .addComponent(jLabel2))
		                        .addGap(18, 60, Short.MAX_VALUE)
		                        .addGroup(jPanel1Layout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                .addComponent(jTextField_CodigoProduto,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addComponent(jButton_PesquisarProduto)
		                                .addComponent(jLabel3)
		                                .addComponent(jTextField_DescricaoProduto,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(jPanel1Layout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addComponent(jButton_AdicionarProduto)
		                                .addGroup(jPanel1Layout
		                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
		                                        .addComponent(jLabel5)
		                                        .addComponent(jTextField_Valor,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(jLabel4)
		                                        .addComponent(jTextField_Quantidade,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(jLabel6)
		                                        .addComponent(jTextField_Desconto,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(jLabel7)))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(jButton_RemoverProduto)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(jScrollPane1,
		                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                      100,
		                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(jButton_Finalizar)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
		        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout
		                .createSequentialGroup()
		                .addContainerGap()
		                .addComponent(jPanel1,
		                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                 Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
		        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addComponent(jPanel1,
		                      javax.swing.GroupLayout.Alignment.TRAILING,
		                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                      Short.MAX_VALUE));

		pack();
	}

	/* This method is responsible to load and show on the screen the Product's
	 * list info (Code, Description, Quantity, Shopping/Sale Price and Total
	 * Price) */
	private void carregarLista()
	{
		valor = 0;
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.setRowCount(0);
		for (Produto p : listaTabelaProduto)
		{
			if (statusVendaCompra == 0)
			{
				model.addRow(new String[]
				{ p.getCodigo(), p.getDescricao(),
				        Double.toString(p.getQuantidade()),
				        Double.toString(p.getPrecoVenda()),
				        Double.toString(p.getPrecoVenda() * p.getQuantidade()) });
				valor = valor + p.getPrecoVenda() * p.getQuantidade();
			}
			else if (statusVendaCompra == 1)
			{
				model.addRow(new String[]
				{ p.getCodigo(), p.getDescricao(),
				        Double.toString(p.getQuantidade()),
				        Double.toString(p.getPrecoCompra()),
				        Double.toString(p.getPrecoCompra() * p.getQuantidade()) });
				valor = valor + p.getPrecoCompra() * p.getQuantidade();
			}
		}
		model.addRow(new String[]
		{ "", "", "", "Total:", Double.toString(valor) });
		jTable1.setModel(model);
	}

	// This method is responsible to confirm the Screen's Cancel Button Action
	private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt)
	{
		TelaEstoque.returnProduto = false;
		modoVendaCompra = false;
		this.dispose();
	}

	// This method is responsible to confirm the Screen's Search Client/Provider Button Action
	private void jButton_PesquisarClienteFornecedorActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		modoVendaCompra = true;
		modoClienteFornecedor = true;
		if (statusVendaCompra == 0)
		{
			TelaContatos.contactType = 0;
		}
		else if (statusVendaCompra == 1)
		{
			TelaContatos.contactType = 1;
		TelaContatos.nomeClienteFornecedor = null;
		new TelaContatos().setVisible(true);
		this.dispose();
		}
	}

	/* This method is responsible to display the Client's name when the chosen
	 * operation was "Selling" and the Provider's name when the chosen operation
	 * was "Shopping" */
	private void jComboBox_VendaCompraItemStateChanged(
	        java.awt.event.ItemEvent evt)
	{

		if (statusVendaCompra == 1)
		{
			if (jComboBox_VendaCompra.getSelectedIndex() == 0)
			{
				listaTabelaProduto.clear();
				statusVendaCompra = 0;
				jLabel1.setText("Cliente:");
				jLabel8.setText("Lançamento Venda");
				jTextField_NomeClienteFornecedor.setText(null);
			}
			else
			{
				// Nothing to Do
			}
		}

		else if (statusVendaCompra == 0)
		{
			if (jComboBox_VendaCompra.getSelectedIndex() == 1)
			{
				listaTabelaProduto.clear();
				statusVendaCompra = 1;
				jLabel1.setText("Fornecedor:");
				jTextField_NomeClienteFornecedor.setText(null);
				jTextField_Desconto.setText("0.0");
				jLabel8.setText("Lançamento Compra");
				jTextField_Desconto.setEnabled(false);
			}
			else
			{
				// Nothing to Do
			}
		}
		carregarLista();
	}

	// This method is responsible to confirm the Screen's Search Provider Button Action
	private void jButton_PesquisarFuncionarioActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		modoVendaCompra = true;
		modoFuncionario = true;
		TelaContatos.contactType = 2;
		TelaContatos.nomeFuncionario = null;
		new TelaContatos().setVisible(true);
		this.dispose();
	}

	/* This method is responsible to confirm the Screen's Finish Button Action
	 * and to prevent the User to finish the form without choosing the Client,
	 * Provider and Product names */
	private void jButton_FinalizarActionPerformed(java.awt.event.ActionEvent evt)
	{
		if (nomeClienteFornecedor == null)
		{
			if (statusVendaCompra == 0)
			{
				exibirInformacao("Selecione o Cliente para operação");
			}
			else if (statusVendaCompra == 1)
			{
				exibirInformacao("Selecione o Fornecedor para operação");
			}
		}
		else if (nomeFuncionario == null)
		{
			exibirInformacao("Selecione o Funcionario responsável pela operação");
		}
		else if (listaTabelaProduto.isEmpty())
		{
			exibirInformacao("Inclua pelo menos um produto");
		}

		else
		{
			for (Produto p : listaTabelaProduto)
			{
				if (statusVendaCompra == 0)
				{
					Produto f = umControleEstoque.pesquisarProduto(p
					        .getCodigo(), false);
					f.setQuantidade(f.getQuantidade() - p.getQuantidade());
				}
				else if (statusVendaCompra == 1)
				{
					Produto f = umControleEstoque.pesquisarProduto(p
					        .getCodigo(), false);
					f.setQuantidade(f.getQuantidade() + p.getQuantidade());
				}
			}

			if (statusVendaCompra == 0)
			{
				Cliente c = TelaDadosContatos.umControleCliente
				        .pesquisarCliente(nomeClienteFornecedor, false);
				Funcionario f = TelaDadosContatos.umControleFuncionario
				        .pesquisarFuncionario(nomeFuncionario, false);
				umaVenda = new Venda(c,
				                     listaTabelaProduto,
				                     valor,
				                     f,
				                     Integer.parseInt(dia),
				                     Integer.parseInt(mes),
				                     Integer.parseInt(ano));
				umControleTransacao.adicionarVenda(umaVenda);

			}

			else if (statusVendaCompra == 1)
			{
				Fornecedor c = TelaDadosContatos.umControleFornecedor
				        .pesquisarFornecedor(nomeClienteFornecedor, false);
				Funcionario f = TelaDadosContatos.umControleFuncionario
				        .pesquisarFuncionario(nomeFuncionario, false);
				umaCompra = new Compra(c,
				                       listaTabelaProduto,
				                       valor,
				                       f,
				                       Integer.parseInt(dia),
				                       Integer.parseInt(mes),
				                       Integer.parseInt(ano));
				umControleTransacao.adicionarVenda(umaCompra);

				Despesa despesa = new Despesa("Compra de Produto do Fornecedor'"
				                                      + c.getNome() + "'",
				                              null,
				                              valor,
				                              Integer.parseInt(dia),
				                              Integer.parseInt(mes),
				                              Integer.parseInt(ano));
				TelaDadosDespesas.umControleDespesa.adicionarGasto(despesa);
			}

			exibirInformacao("Operação realizada com sucesso!");
			this.dispose();
			modoFuncionario = false;
			modoClienteFornecedor = false;
			TelaEstoque.returnProduto = false;
			TelaContatos.returnFuncionario = false;
			TelaContatos.returnClienteFornecedor = false;
			modoVendaCompra = false;

		}

	}

	// This method is responsible to confirm the Screen's Search Product Button Action
	private void jButton_PesquisarProdutoActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		modoVendaCompra = true;
		modoProduto = true;
		new TelaEstoque().setVisible(true);
		this.dispose();
	}

	// This method is responsible to confirm the Screen's Add Product Button Action
	private void jButton_AdicionarProdutoActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		int x = 0;
		for (Produto s : listaTabelaProduto)
			if (s.getCodigo().equalsIgnoreCase(vendaProduto.getCodigo()))
			{
				x = 1;
			}
			else 
			{
				// Nothing to Do
			}
		if (x == 0)
		{
			if (Double.parseDouble(jTextField_Quantidade.getText()) != 0.0
			        && jTextField_Quantidade.getText() != "")
			{
				if (statusVendaCompra == 0)
				{
					if (editProduto.getQuantidade() != 0)
					{
						if (Double.parseDouble(jTextField_Quantidade.getText()) <= editProduto
						        .getQuantidade())
						{
							vendaProduto.setQuantidade(Double
							        .parseDouble(jTextField_Quantidade
							                .getText()));
							vendaProduto.setPrecoVenda(Double
							        .parseDouble(jTextField_Valor.getText()));
							listaTabelaProduto.add(vendaProduto);
							carregarLista();
							jButton_AdicionarProduto.setEnabled(false);
							jTextField_Quantidade.setEnabled(false);
							jTextField_Desconto.setEditable(false);
						}
						else
						{
							exibirInformacao("A quantidade de produto vendido não deve exceder a quantidade em estoque");
						}
					}
					else
					{
						exibirInformacao("Produto não disponível em estoque");
					}
				}
				else if (statusVendaCompra == 1)
				{
					if (x == 0)
					{
						compraProduto.setQuantidade(Double
						        .parseDouble(jTextField_Quantidade.getText()));
						listaTabelaProduto.add(compraProduto);
						carregarLista();
						jButton_AdicionarProduto.setEnabled(false);
						jTextField_Quantidade.setEnabled(false);
						jTextField_Desconto.setEditable(false);
						for (Produto s : listaTabelaProduto)
						{
							if (s.getCodigo()
							        .equalsIgnoreCase(vendaProduto.getCodigo()))
							{
								x = 1;
							}
							else
							{
								// Nothing to Do
							}
						}
					}
					else if (x == 1)
					{
						exibirInformacao("Produto já adicionado!");
					}
				}
			}
			else
			{
				exibirInformacao("Selecione a quantidade envolvida na operação");
				jTextField_Quantidade.requestFocus();
			}
		}
		else
		{
			exibirInformacao("Produto já adicionado!");
		}
	}

	// This method is responsible to list and edit the registered Products
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt)
	{
		String nomeValor = null;
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		String nomeTabela = (String) model.getValueAt(jTable1.getSelectedRow(),
		                                              0);
		nomeValor = (String) model.getValueAt(jTable1.getSelectedRow(), 1);
		if (!"Total:".equals(nomeValor))
		{
			for (Produto p : listaTabelaProduto)
			{
				if (p.getCodigo().equalsIgnoreCase(nomeTabela))
				{
					editProduto = p;
				}
			}
			jButton_RemoverProduto.setEnabled(true);
		}
		else if (nomeValor.equals("Total:"))
		{
			jButton_RemoverProduto.setEnabled(false);
		}
	}

	// This method is responsible to confirm the Screen's Remove Product Button Action
	private void jButton_RemoverProdutoActionPerformed(
	        java.awt.event.ActionEvent evt)
	{

		listaTabelaProduto.remove(editProduto);
		carregarLista();
		exibirInformacao("Produto removido");
		jButton_AdicionarProduto.setEnabled(true);
		jTextField_Quantidade.setEnabled(true);
		jTextField_Desconto.setEnabled(true);
		jButton_RemoverProduto.setEnabled(false);
	}

	// This method is responsible to add (in percentage) the Product's discount
	private void jTextField_DescontoFocusLost(java.awt.event.FocusEvent evt)
	{
		if (Double.parseDouble(jTextField_Desconto.getText()) > 100)
		{
			exibirInformacao("Limite de desconto excedido");
			jTextField_Desconto.setText("0.0");
			jTextField_Desconto.requestFocus();
		}
		else if (jTextField_Desconto.getText() == "")
		{
			jTextField_Desconto.setText("0.0");
		}
		else
		{
			double valor2 = editProduto.getPrecoVenda();
			double desconto = Double.parseDouble(jTextField_Desconto.getText());
			jTextField_Valor.setText(Double.toString(valor2
			        * (1 - desconto / 100)));
		}
	}

	/* This main method is responsible to enable the Nimbus (GUI) Interface and
	 * display all the Shopping/Selling list info with a log system */
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
			}
		}
		catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(TelaVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(TelaVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(TelaVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(TelaVendaCompra.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new TelaVendaCompra().setVisible(true);
			}
		});
	}

}
