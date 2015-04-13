/***********************************************************
 * File: SalePurchaseView.java
 * Purpose: Responsible to get the Product's Purchase and Sale info
 **********************************************************/

package view;

import controller.TransactionController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;	
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.Purchase;
import model.Despesa;
import model.Supplier;
import model.Employee;
import model.Produto;
import model.Sale;
import static view.ContactView.nameClientSupplier;
import static view.ContactView.nameEmployee;
import static view.TelaDadosProdutos.umControleEstoque;
import static view.TelaEstoque.codigoTabela;
import static view.TelaEstoque.descricaoTabela;

public class SalePurchaseView extends javax.swing.JFrame
{

	// Variables declaration (do not modify) - GEN-BEGIN:variables
	private javax.swing.JButton jButton_addProduct;
	private javax.swing.JButton jButton_exitScreen;
	private javax.swing.JButton jButton_finishForm;
	private javax.swing.JButton jButton_searchClientSupplier;
	private javax.swing.JButton jButton_searchEmployee;
	private javax.swing.JButton jButton_searchProduct;
	private javax.swing.JButton jButton_removeProduct;
	private javax.swing.JComboBox jComboBox_showSalePurchase;
	private javax.swing.JLabel jLabel_showClientWord;
	private javax.swing.JLabel jLabel_showSupplierWord;
	private javax.swing.JLabel jLabel_showProductWord;
	private javax.swing.JLabel jLabel_showQuantityWord;
	private javax.swing.JLabel jLabel_showPriceWord;
	private javax.swing.JLabel jLabel_showDiscountWord;
	private javax.swing.JLabel jLabel_showDiscountPercentageSymbol;
	private javax.swing.JLabel jLabel_showMainScreenName;
	private javax.swing.JLabel jLabel_showOperationName;
	private javax.swing.JPanel jPanel_showEntireSalePurchaseScreen;
	private javax.swing.JScrollPane jScrollPane_showSalePurchaseScreenScroll;
	private javax.swing.JTable jTable_showPurchaseSaleInfoTable;
	private javax.swing.JTextField jTextField_productCode;
	private javax.swing.JTextField jTextField_productDiscount;
	private javax.swing.JTextField jTextField_productDescription;
	private javax.swing.JTextField jTextField_clientSupplierName;
	private javax.swing.JTextField jTextField_employeeName;
	private javax.swing.JTextField jTextField_productQuantity;
	private javax.swing.JTextField jTextField_productValue;
	// End of variables declaration - GEN-END:variables

	EnterpriseManagement main;
	public static int salePurchaseStatus = 0;
	static boolean purchaseSaleMode = false;
	static boolean clientSupplierMode = false;
	static boolean employeeMode = false;
	static boolean productMode = false;
	static TransactionController umControleTransacao = new TransactionController();
	Produto editProduct;
	Produto productSale = new Produto();
	Produto productPurchase = new Produto();
	Sale oneSale;
	Purchase onePurchase;
	double productValue = 0;
	Date date = new Date();
	DateFormat Day = new SimpleDateFormat("dd");
	String salePurchaseDay = Day.format(date);
	DateFormat Month = new SimpleDateFormat("MM");
	String salePurchaseMonth = Month.format(date);
	DateFormat Year = new SimpleDateFormat("yyyy");
	String salePurchaseYear = Year.format(date);

	static ArrayList<Produto> productTableList = new ArrayList<Produto>();

	// This method is responsible to show a specific info as a Text Box
	public void showInfo(String info)
	{
		JOptionPane.showMessageDialog(this,
		                              info,
		                              "Atenção",
		                              JOptionPane.INFORMATION_MESSAGE);
	}

	/* This method is responsible to display a GUI so that the User can choose
	 * the Clients/Providers' names search products' names, add products, remove
	 * products, buy and sell products according to their quantities */
	public SalePurchaseView()
	{
		initComponents();
		jTextField_clientSupplierName.setEnabled(false);
		jTextField_employeeName.setEnabled(false);
		jTextField_productCode.setEnabled(false);
		jTextField_productValue.setEnabled(false);
		jTextField_productQuantity.setEnabled(false);
		jTextField_productDiscount.setEnabled(false);
		jTextField_productDescription.setEnabled(false);
		jButton_addProduct.setEnabled(false);
		jButton_removeProduct.setEnabled(false);
		if (ContactView.returnClientSupplier == true)
		{
			jTextField_clientSupplierName
			        .setText(ContactView.nameClientSupplier);
		}
		else 
		{
			// Nothing to Do
		}
		if (ContactView.returnEmployee == true)
		{
			jTextField_employeeName.setText(ContactView.nameEmployee);
		}
		else
		{
			// Nothing to Do
		}
		if (TelaEstoque.returnProduto == true)
		{
			jTextField_productCode.setText(codigoTabela);
			jTextField_productDescription.setText(descricaoTabela);
			editProduct = umControleEstoque.pesquisarProduto(codigoTabela,
			                                                 false);
			productSale.setCodigo(editProduct.getCodigo());
			productSale.setPreco(editProduct.getPrecoVenda());
			productSale.setQuantidade(editProduct.getQuantidade());
			productSale.setDescricao(editProduct.getDescricao());
			productPurchase.setCodigo(editProduct.getCodigo());
			productPurchase.setPreco(editProduct.getPrecoCompra());
			productPurchase.setQuantidade(editProduct.getQuantidade());
			productPurchase.setDescricao(editProduct.getDescricao());
			if (salePurchaseStatus == 0)
			{
				jTextField_productValue.setText(Double.toString(editProduct
				        .getPrecoVenda()));
			}
			else if (salePurchaseStatus == 1)
			{
				jTextField_productValue.setText(Double.toString(editProduct
				        .getPrecoCompra()));
			jTextField_productQuantity.setEnabled(true);
			}
			if (salePurchaseStatus == 0)
			{
				jTextField_productDiscount.setEnabled(true);
			}
			else if (salePurchaseStatus == 1)
			{
				jTextField_productDiscount.setEnabled(false);
				jButton_addProduct.setEnabled(true);
			}
		}
		else
		{
			// Nothing to Do
		}
		if (salePurchaseStatus == 0)
		{
			jComboBox_showSalePurchase.setSelectedIndex(0);
		}
		else if (salePurchaseStatus == 1)
		{
			jComboBox_showSalePurchase.setSelectedIndex(1);
		}
		if (productMode == true)
		{
			jTextField_productCode.setText(codigoTabela);
			jTextField_productDescription.setText(descricaoTabela);
		}
		else
		{
			// Nothing to Do
		}
		if (clientSupplierMode == true)
		{
			jTextField_clientSupplierName.setText(nameClientSupplier);
		}
		else
		{
			// Nothing to Do			
		}
		if (employeeMode == true)
		{
			jTextField_employeeName.setText(nameEmployee);
			loadList();
		}
		else
		{
			// Nothing to Do
		}
		if (salePurchaseStatus == 0)
		{
			jLabel_showClientWord.setText("Cliente:");
		}
		else if (salePurchaseStatus == 1)
		{
			jLabel_showClientWord.setText("Fornecedor:");
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

		jPanel_showEntireSalePurchaseScreen = new javax.swing.JPanel();
		jButton_exitScreen = new javax.swing.JButton();
		jTextField_productValue = new javax.swing.JTextField();
		jButton_searchEmployee = new javax.swing.JButton();
		jButton_addProduct = new javax.swing.JButton();
		jTextField_productQuantity = new javax.swing.JTextField();
		jLabel_showClientWord = new javax.swing.JLabel();
		jTextField_productCode = new javax.swing.JTextField();
		jLabel_showSupplierWord = new javax.swing.JLabel();
		jScrollPane_showSalePurchaseScreenScroll = new javax.swing.JScrollPane();
		jTable_showPurchaseSaleInfoTable = new javax.swing.JTable();
		jButton_searchProduct = new javax.swing.JButton();
		jLabel_showQuantityWord = new javax.swing.JLabel();
		jLabel_showProductWord = new javax.swing.JLabel();
		jLabel_showPriceWord = new javax.swing.JLabel();
		jTextField_clientSupplierName = new javax.swing.JTextField();
		jButton_finishForm = new javax.swing.JButton();
		jButton_searchClientSupplier = new javax.swing.JButton();
		jTextField_employeeName = new javax.swing.JTextField();
		jComboBox_showSalePurchase = new javax.swing.JComboBox();
		jLabel_showDiscountWord = new javax.swing.JLabel();
		jButton_removeProduct = new javax.swing.JButton();
		jTextField_productDiscount = new javax.swing.JTextField();
		jLabel_showDiscountPercentageSymbol = new javax.swing.JLabel();
		jLabel_showMainScreenName = new javax.swing.JLabel();
		jTextField_productDescription = new javax.swing.JTextField();
		jLabel_showOperationName = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Lançamento Venda/Compra");
		setBounds(new java.awt.Rectangle(450, 300, 0, 0));

		jButton_exitScreen.setText("Sair");
		jButton_exitScreen.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_exitScreenActionPerformed(evt);
			}
		});

		jTextField_productValue.setText("0.00");

		jButton_searchEmployee.setText("Pesquisar");
		jButton_searchEmployee
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
			        	jButton_searchEmployeeActionPerformed(evt);
			        }
		        });

		jButton_addProduct.setText("+");
		jButton_addProduct
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
			        	jButton_addProductActionPerformed(evt);
			        }
		        });

		jTextField_productQuantity.setText("0.0");

		jLabel_showClientWord.setText("Cliente:");

		jLabel_showSupplierWord.setText("Funcionário:");

		jTable_showPurchaseSaleInfoTable.setModel(new javax.swing.table.DefaultTableModel(null,
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
		jTable_showPurchaseSaleInfoTable.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jTable_showPurchaseSaleInfoTableMouseClicked(evt);
			}
		});
		jScrollPane_showSalePurchaseScreenScroll.setViewportView(jTable_showPurchaseSaleInfoTable);

		jButton_searchProduct.setText("Pesquisar");
		jButton_searchProduct
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_searchProductActionPerformed(evt);
			        }
		        });

		jLabel_showQuantityWord.setText("Quantidade:");

		jLabel_showProductWord.setText("Produto:");

		jLabel_showPriceWord.setText("Valor:");

		jButton_finishForm.setText("Finalizar");
		jButton_finishForm.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_finishFormActionPerformed(evt);
			}
		});

		jButton_searchClientSupplier.setText("Pesquisar");
		jButton_searchClientSupplier
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_searchClientSupplierActionPerformed(evt);
			        }
		        });

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

		jLabel_showDiscountWord.setText("Desconto:");

		jButton_removeProduct.setText("-");
		jButton_removeProduct
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        jButton_removeProductActionPerformed(evt);
			        }
		        });

		jTextField_productDiscount.setText("0.0");
		jTextField_productDiscount.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				jTextField_productDiscountFocusLost(evt);
			}
		});

		jLabel_showDiscountPercentageSymbol.setText("%");

		jLabel_showMainScreenName.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel_showMainScreenName.setText("Lançamento Venda");

		jLabel_showOperationName.setText("Operação:");

		javax.swing.GroupLayout jPanel_showEntireSalePurchaseScreenLayout = new javax.swing.GroupLayout(jPanel_showEntireSalePurchaseScreen);
		jPanel_showEntireSalePurchaseScreen.setLayout(jPanel_showEntireSalePurchaseScreenLayout);
		jPanel_showEntireSalePurchaseScreenLayout
		        .setHorizontalGroup(jPanel_showEntireSalePurchaseScreenLayout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                        .createSequentialGroup()
		                        .addGap(13, 13, 13)
		                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                        .createSequentialGroup()
		                                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                        .createSequentialGroup()
		                                                        .addComponent(jLabel_showOperationName)
		                                                        .addGap(148,
		                                                                148,
		                                                                148)
		                                                        .addComponent(jComboBox_showSalePurchase,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                                      javax.swing.GroupLayout.PREFERRED_SIZE))
		                                                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                        .createSequentialGroup()
		                                                        .addGap(20,
		                                                                20,
		                                                                20)
		                                                        .addComponent(jButton_exitScreen)
		                                                        .addGap(64,
		                                                                64,
		                                                                64)
		                                                        .addComponent(jLabel_showMainScreenName)))
		                                        .addGap(0, 0, Short.MAX_VALUE))
		                                .addComponent(jScrollPane_showSalePurchaseScreenScroll)
		                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		                                          jPanel_showEntireSalePurchaseScreenLayout
		                                                  .createSequentialGroup()
		                                                  .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                          .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                                                          .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                                  .createSequentialGroup()
		                                                                  .addComponent(jLabel_showPriceWord)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jTextField_productValue,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                65,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                                                                  .addComponent(jLabel_showQuantityWord)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jTextField_productQuantity,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                52,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jLabel_showDiscountWord)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jTextField_productDiscount,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                55,
		                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                  .addComponent(jLabel_showDiscountPercentageSymbol))
		                                                          .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
		                                                                    jPanel_showEntireSalePurchaseScreenLayout
		                                                                            .createSequentialGroup()
		                                                                            .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                                                    .addComponent(jLabel_showSupplierWord)
		                                                                                    .addComponent(jLabel_showClientWord,
		                                                                                                  javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                                  96,
		                                                                                                  javax.swing.GroupLayout.PREFERRED_SIZE))
		                                                                            .addGap(49,
		                                                                                    49,
		                                                                                    49)
		                                                                            .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                                                    .addComponent(jTextField_employeeName)
		                                                                                    .addComponent(jTextField_clientSupplierName)
		                                                                                    .addComponent(jTextField_productDescription)))
		                                                          .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
		                                                                    jPanel_showEntireSalePurchaseScreenLayout
		                                                                            .createSequentialGroup()
		                                                                            .addComponent(jLabel_showProductWord)
		                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                                            .addComponent(jTextField_productCode,
		                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                                                          60,
		                                                                                          javax.swing.GroupLayout.PREFERRED_SIZE)
		                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
		                                                                                             javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                                                             Short.MAX_VALUE)))
		                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                                  .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                                          .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		                                                                    jPanel_showEntireSalePurchaseScreenLayout
		                                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                                            .addComponent(jButton_searchProduct)
		                                                                            .addComponent(jButton_searchEmployee)
		                                                                            .addComponent(jButton_searchClientSupplier))
		                                                          .addComponent(jButton_removeProduct,
		                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
		                                                          .addComponent(jButton_addProduct,
		                                                                        javax.swing.GroupLayout.Alignment.TRAILING))))
		                        .addContainerGap())
		                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                        .createSequentialGroup()
		                        .addGap(207, 207, 207)
		                        .addComponent(jButton_finishForm)
		                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                         Short.MAX_VALUE)));

		jPanel_showEntireSalePurchaseScreenLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		                       new java.awt.Component[]
		                       { jButton_searchClientSupplier,
				jButton_searchEmployee,
		                               jButton_searchProduct });

		jPanel_showEntireSalePurchaseScreenLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
		                       new java.awt.Component[]
		                       { jButton_finishForm, jComboBox_showSalePurchase });

		jPanel_showEntireSalePurchaseScreenLayout
		        .setVerticalGroup(jPanel_showEntireSalePurchaseScreenLayout
		                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                        .createSequentialGroup()
		                        .addContainerGap()
		                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                        .createSequentialGroup()
		                                        .addGap(1, 1, 1)
		                                        .addComponent(jLabel_showMainScreenName))
		                                .addComponent(jButton_exitScreen,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              29,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                        .createSequentialGroup()
		                                        .addGap(12, 12, 12)
		                                        .addComponent(jComboBox_showSalePurchase,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE))
		                                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                        .createSequentialGroup()
		                                        .addGap(18, 18, 18)
		                                        .addComponent(jLabel_showOperationName)))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                .addComponent(jTextField_clientSupplierName,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addComponent(jLabel_showClientWord)
		                                .addComponent(jButton_searchClientSupplier))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                .addComponent(jTextField_employeeName,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addComponent(jButton_searchEmployee)
		                                .addComponent(jLabel_showSupplierWord))
		                        .addGap(18, 60, Short.MAX_VALUE)
		                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                                .addComponent(jTextField_productCode,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                                .addComponent(jButton_searchProduct)
		                                .addComponent(jLabel_showProductWord)
		                                .addComponent(jTextField_productDescription,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                                              javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                .addComponent(jButton_addProduct)
		                                .addGroup(jPanel_showEntireSalePurchaseScreenLayout
		                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
		                                        .addComponent(jLabel_showPriceWord)
		                                        .addComponent(jTextField_productValue,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(jLabel_showQuantityWord)
		                                        .addComponent(jTextField_productQuantity,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(jLabel_showDiscountWord)
		                                        .addComponent(jTextField_productDiscount,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(jLabel_showDiscountPercentageSymbol)))
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(jButton_removeProduct)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(jScrollPane_showSalePurchaseScreenScroll,
		                                      javax.swing.GroupLayout.PREFERRED_SIZE,
		                                      100,
		                                      javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(jButton_finishForm)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
		        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout
		                .createSequentialGroup()
		                .addContainerGap()
		                .addComponent(jPanel_showEntireSalePurchaseScreen,
		                              javax.swing.GroupLayout.PREFERRED_SIZE,
		                              javax.swing.GroupLayout.DEFAULT_SIZE,
		                              javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
		                                 Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
		        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addComponent(jPanel_showEntireSalePurchaseScreen,
		                      javax.swing.GroupLayout.Alignment.TRAILING,
		                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                      javax.swing.GroupLayout.DEFAULT_SIZE,
		                      Short.MAX_VALUE));

		pack();
	}

	/* This method is responsible to load and show on the screen the Product's
	 * list info (Code, Description, Quantity, Shopping/Sale Price and Total
	 * Price) */
	private void loadList()
	{
		productValue = 0;
		DefaultTableModel model = (DefaultTableModel) jTable_showPurchaseSaleInfoTable.getModel();
		model.setRowCount(0);
		for (Produto p : productTableList)
		{
			if (salePurchaseStatus == 0)
			{
				model.addRow(new String[]
				{ p.getCodigo(), p.getDescricao(),
				        Double.toString(p.getQuantidade()),
				        Double.toString(p.getPrecoVenda()),
				        Double.toString(p.getPrecoVenda() * p.getQuantidade()) });
				productValue = productValue + p.getPrecoVenda() * p.getQuantidade();
			}
			else if (salePurchaseStatus == 1)
			{
				model.addRow(new String[]
				{ p.getCodigo(), p.getDescricao(),
				        Double.toString(p.getQuantidade()),
				        Double.toString(p.getPrecoCompra()),
				        Double.toString(p.getPrecoCompra() * p.getQuantidade()) });
				productValue = productValue + p.getPrecoCompra() * p.getQuantidade();
			}
		}
		model.addRow(new String[]
		{ "", "", "", "Total:", Double.toString(productValue) });
		jTable_showPurchaseSaleInfoTable.setModel(model);
	}

	// This method is responsible to confirm the Screen's Cancel Button Action
	private void jButton_exitScreenActionPerformed(java.awt.event.ActionEvent evt)
	{
		TelaEstoque.returnProduto = false;
		purchaseSaleMode = false;
		this.dispose();
	}

	// This method is responsible to confirm the Screen's Search Client/Provider Button Action
	private void jButton_searchClientSupplierActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		purchaseSaleMode = true;
		clientSupplierMode = true;
		if (salePurchaseStatus == 0)
		{
			ContactView.contactType = 0;
		}
		else if (salePurchaseStatus == 1)
		{
			ContactView.contactType = 1;
		ContactView.nameClientSupplier = null;
		new ContactView().setVisible(true);
		this.dispose();
		}
	}

	/* This method is responsible to display the Client's name when the chosen
	 * operation was "Selling" and the Provider's name when the chosen operation
	 * was "Shopping" */
	private void jComboBox_showSalePurchaseItemStateChanged(
	        java.awt.event.ItemEvent evt)
	{

		if (salePurchaseStatus == 1)
		{
			if (jComboBox_showSalePurchase.getSelectedIndex() == 0)
			{
				productTableList.clear();
				salePurchaseStatus = 0;
				jLabel_showClientWord.setText("Cliente:");
				jLabel_showMainScreenName.setText("Lançamento Venda");
				jTextField_clientSupplierName.setText(null);
			}
			else
			{
				// Nothing to Do
			}
		}

		else if (salePurchaseStatus == 0)
		{
			if (jComboBox_showSalePurchase.getSelectedIndex() == 1)
			{
				productTableList.clear();
				salePurchaseStatus = 1;
				jLabel_showClientWord.setText("Fornecedor:");
				jTextField_clientSupplierName.setText(null);
				jTextField_productDiscount.setText("0.0");
				jLabel_showMainScreenName.setText("Lançamento Compra");
				jTextField_productDiscount.setEnabled(false);
			}
			else
			{
				// Nothing to Do
			}
		}
		loadList();
	}

	// This method is responsible to confirm the Screen's Search Provider Button Action
	private void jButton_searchEmployeeActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		purchaseSaleMode = true;
		employeeMode = true;
		ContactView.contactType = 2;
		ContactView.nameEmployee = null;
		new ContactView().setVisible(true);
		this.dispose();
	}

	/* This method is responsible to confirm the Screen's Finish Button Action
	 * and to prevent the User to finish the form without choosing the Client,
	 * Provider and Product names */
	private void jButton_finishFormActionPerformed(java.awt.event.ActionEvent evt)
	{
		if (nameClientSupplier == null)
		{
			if (salePurchaseStatus == 0)
			{
				showInfo("Selecione o Cliente para operação");
			}
			else if (salePurchaseStatus == 1)
			{
				showInfo("Selecione o Fornecedor para operação");
			}
		}
		else if (nameEmployee == null)
		{
			showInfo("Selecione o Funcionario responsável pela operação");
		}
		else if (productTableList.isEmpty())
		{
			showInfo("Inclua pelo menos um produto");
		}

		else
		{
			for (Produto p : productTableList)
			{
				if (salePurchaseStatus == 0)
				{
					Produto f = umControleEstoque.pesquisarProduto(p
					        .getCodigo(), false);
					f.setQuantidade(f.getQuantidade() - p.getQuantidade());
				}
				else if (salePurchaseStatus == 1)
				{
					Produto f = umControleEstoque.pesquisarProduto(p
					        .getCodigo(), false);
					f.setQuantidade(f.getQuantidade() + p.getQuantidade());
				}
			}

			if (salePurchaseStatus == 0)
			{
				Client c = TelaDadosContatos.umControleCliente
				        .pesquisarCliente(nameClientSupplier, false);
				Employee f = TelaDadosContatos.umControleFuncionario
				        .pesquisarFuncionario(nameEmployee, false);
				oneSale = new Sale(c,
				                   productTableList,
				                     productValue,
				                     f,
				                     Integer.parseInt(salePurchaseDay),
				                     Integer.parseInt(salePurchaseMonth),
				                     Integer.parseInt(salePurchaseYear));
				umControleTransacao.addSale(oneSale);

			}

			else if (salePurchaseStatus == 1)
			{
				Supplier c = TelaDadosContatos.umControleFornecedor
				        .pesquisarFornecedor(nameClientSupplier, false);
				Employee f = TelaDadosContatos.umControleFuncionario
				        .pesquisarFuncionario(nameEmployee, false);
				onePurchase = new Purchase(c,
				                           productTableList,
				                       productValue,
				                       f,
				                       Integer.parseInt(salePurchaseDay),
				                       Integer.parseInt(salePurchaseMonth),
				                       Integer.parseInt(salePurchaseYear));
				umControleTransacao.addSale(onePurchase);

				Despesa despesa = new Despesa("Compra de Produto do Fornecedor'"
				                                      + c.getNome() + "'",
				                              null,
				                              productValue,
				                              Integer.parseInt(salePurchaseDay),
				                              Integer.parseInt(salePurchaseMonth),
				                              Integer.parseInt(salePurchaseYear));
				TelaDadosDespesas.umControleDespesa.adicionarGasto(despesa);
			}

			showInfo("Operação realizada com sucesso!");
			this.dispose();
			employeeMode = false;
			clientSupplierMode = false;
			TelaEstoque.returnProduto = false;
			ContactView.returnEmployee = false;
			ContactView.returnClientSupplier = false;
			purchaseSaleMode = false;

		}

	}

	// This method is responsible to confirm the Screen's Search Product Button Action
	private void jButton_searchProductActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		purchaseSaleMode = true;
		productMode = true;
		new TelaEstoque().setVisible(true);
		this.dispose();
	}

	// This method is responsible to confirm the Screen's Add Product Button Action
	private void jButton_addProductActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		int verifyAddedProduct = 0;
		for (Produto s : productTableList)
			if (s.getCodigo().equalsIgnoreCase(productSale.getCodigo()))
			{
				verifyAddedProduct = 1;
			}
			else 
			{
				// Nothing to Do
			}
		if (verifyAddedProduct == 0)
		{
			if (Double.parseDouble(jTextField_productQuantity.getText()) != 0.0
			        && jTextField_productQuantity.getText() != "")
			{
				if (salePurchaseStatus == 0)
				{
					if (editProduct.getQuantidade() != 0)
					{
						if (Double.parseDouble(jTextField_productQuantity.getText()) <= editProduct
						        .getQuantidade())
						{
							productSale.setQuantidade(Double
							        .parseDouble(jTextField_productQuantity
							                .getText()));
							productSale.setPrecoVenda(Double
							        .parseDouble(jTextField_productValue.getText()));
							productTableList.add(productSale);
							loadList();
							jButton_addProduct.setEnabled(false);
							jTextField_productQuantity.setEnabled(false);
							jTextField_productDiscount.setEditable(false);
						}
						else
						{
							showInfo("A quantidade de produto vendido não deve exceder a quantidade em estoque");
						}
					}
					else
					{
						showInfo("Produto não disponível em estoque");
					}
				}
				else if (salePurchaseStatus == 1)
				{
					if (verifyAddedProduct == 0)
					{
						productPurchase.setQuantidade(Double
						        .parseDouble(jTextField_productQuantity.getText()));
						productTableList.add(productPurchase);
						loadList();
						jButton_addProduct.setEnabled(false);
						jTextField_productQuantity.setEnabled(false);
						jTextField_productDiscount.setEditable(false);
						for (Produto s : productTableList)
						{
							if (s.getCodigo()
							        .equalsIgnoreCase(productSale.getCodigo()))
							{
								verifyAddedProduct = 1;
							}
							else
							{
								// Nothing to Do
							}
						}
					}
					else if (verifyAddedProduct == 1)
					{
						showInfo("Produto já adicionado!");
					}
				}
			}
			else
			{
				showInfo("Selecione a quantidade envolvida na operação");
				jTextField_productQuantity.requestFocus();
			}
		}
		else
		{
			showInfo("Produto já adicionado!");
		}
	}

	// This method is responsible to list and edit the registered Products
	private void jTable_showPurchaseSaleInfoTableMouseClicked(java.awt.event.MouseEvent evt)
	{
		String totalProductValue = null;
		DefaultTableModel model = (DefaultTableModel) jTable_showPurchaseSaleInfoTable.getModel();
		String nomeTabela = (String) model.getValueAt(jTable_showPurchaseSaleInfoTable.getSelectedRow(),
		                                              0);
		totalProductValue = (String) model.getValueAt(jTable_showPurchaseSaleInfoTable.getSelectedRow(), 1);
		if (!"Total:".equals(totalProductValue))
		{
			for (Produto p : productTableList)
			{
				if (p.getCodigo().equalsIgnoreCase(nomeTabela))
				{
					editProduct = p;
				}
			}
			jButton_removeProduct.setEnabled(true);
		}
		else if (totalProductValue.equals("Total:"))
		{
			jButton_removeProduct.setEnabled(false);
		}
	}

	// This method is responsible to confirm the Screen's Remove Product Button Action
	private void jButton_removeProductActionPerformed(
	        java.awt.event.ActionEvent evt)
	{

		productTableList.remove(editProduct);
		loadList();
		showInfo("Produto removido");
		jButton_addProduct.setEnabled(true);
		jTextField_productQuantity.setEnabled(true);
		jTextField_productDiscount.setEnabled(true);
		jButton_removeProduct.setEnabled(false);
	}

	// This method is responsible to add (in percentage) the Product's discount
	private void jTextField_productDiscountFocusLost(java.awt.event.FocusEvent evt)
	{
		if (Double.parseDouble(jTextField_productDiscount.getText()) > 100)
		{
			showInfo("Limite de desconto excedido");
			jTextField_productDiscount.setText("0.0");
			jTextField_productDiscount.requestFocus();
		}
		else if (jTextField_productDiscount.getText() == "")
		{
			jTextField_productDiscount.setText("0.0");
		}
		else
		{
			double productValueWithDiscount = editProduct.getPrecoVenda();
			double productDiscount = Double.parseDouble(jTextField_productDiscount.getText());
			jTextField_productValue.setText(Double.toString(productValueWithDiscount
			        * (1 - productDiscount / 100)));
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
			java.util.logging.Logger.getLogger(SalePurchaseView.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(SalePurchaseView.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(SalePurchaseView.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(SalePurchaseView.class.getName())
			        .log(java.util.logging.Level.SEVERE, null, ex);
		}

		// Create and display the form
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new SalePurchaseView().setVisible(true);
			}
		});
	}

}
