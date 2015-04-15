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
import model.Expense;
import model.Supplier;
import model.Employee;
import model.Product;
import model.Sale;
import static view.ContactView.nameClientSupplier;
import static view.ContactView.nameEmployee;
import static view.ProductDataView.objectStockController;
import static view.StockView.codeTable;
import static view.StockView.tableDescription;

public class SalePurchaseView extends javax.swing.JFrame
{

	private javax.swing.JButton jButton_addProduct; // Button responsible to add product
	private javax.swing.JButton jButton_exitScreen; // Button responsible to exit Main Screen
	private javax.swing.JButton jButton_finishForm; // Button responsible to Finish and Complete the Screen's form
	private javax.swing.JButton jButton_searchClientSupplier; // Button responsible to Search Client and Supplier Names
	private javax.swing.JButton jButton_searchEmployee; // Button responsible search Employee
	private javax.swing.JButton jButton_searchProduct; // Button responsible search Employee
	private javax.swing.JButton jButton_removeProduct; // Button responsible to remove product
	private javax.swing.JComboBox jComboBox_showSalePurchase; // Button that shows a drop-down list with Buying/Sale option
	private javax.swing.JLabel jLabel_showClientWord; // Shows the "Client" word with a chosen Sales option 
	private javax.swing.JLabel jLabel_showSupplierWord; // Shows the "Supplier" word with a chosen Shopping option 
	private javax.swing.JLabel jLabel_showProductWord; // Shows the "Product" word on the screen
	private javax.swing.JLabel jLabel_showQuantityWord; // Shows the "Quantity" word on the screen
	private javax.swing.JLabel jLabel_showPriceWord; // Shows the "Price" word on the screen
	private javax.swing.JLabel jLabel_showDiscountWord; // Shows the "Discount" word on the screen
	private javax.swing.JLabel jLabel_showDiscountPercentageSymbol; // Shows a discount's percentage symbol
	private javax.swing.JLabel jLabel_showMainScreenName; // Shows the main screen name: "Sale Release"
	private javax.swing.JLabel jLabel_showOperationName; // Shows the operation name: Buying or Selling
	private javax.swing.JPanel jPanel_showEntireSalePurchaseScreen; // Shows the entire Sales Release's screen layout
	private javax.swing.JScrollPane jScrollPane_showSalePurchaseScreenScroll; // Shows the Sales Release's screen scroll 
	private javax.swing.JTable jTable_showPurchaseSaleInfoTable; // Shows a table with the Product's code, description, quantity, price and final price (with discount)
	private javax.swing.JTextField jTextField_productCode; // Shows the product's code
	private javax.swing.JTextField jTextField_productDiscount; // Shows the product's discount
	private javax.swing.JTextField jTextField_productDescription; // Shows the product's description
	private javax.swing.JTextField jTextField_clientSupplierName; // Shows Client's name with a chosen Selling option and the Supplier's name with a chosen Shopping option 
	private javax.swing.JTextField jTextField_employeeName; // Shows Worker's name with both chosen options: Shopping/Selling
	private javax.swing.JTextField jTextField_productQuantity; // Sets the initial product's quantity value (0)
	private javax.swing.JTextField jTextField_productValue; // Shows the product's value
	
	EnterpriseManagement main; // Main object from EnterpriseManagement's class
	public static int salePurchaseStatus = 0; // Shows the Client's name when option is 0 (Selling) and Supplier's name when option is 1 (Buying)
	static boolean purchaseSaleMode = false; // Makes the user to exit the screen and to not write Client/Supplier's names
	static boolean clientSupplierMode = false; // Enables the user to search registered Client/Supplier's names
	static boolean employeeMode = false; // Gets the Supplier's info to continue the Shopping Products
	static boolean productMode = false; // Gets the Product's code and description to buy or sell them
	static TransactionController umControleTransacao = new TransactionController(); // Object from TransactionController's class
	Product editProduct; // Object from Product class that edits the product's info
	Product productSale = new Product(); // Object from Product class that adds products to sale
	Product productPurchase = new Product(); // Object from Product class that adds products to buy
	Sale objectSale; // Variable that adds a Product to Sell
	Purchase objectPurchase; // Variable that adds a Product to Buy
	double productValue = 0; // Multiplies the product's quantity and the product's value (without discount)
	Date date = new Date(); // Stores the current date/month/year
	DateFormat Day = new SimpleDateFormat("dd"); // Stores the day on the following format: dd
	String day = Day.format(date); // Receives the current day to save on the transaction
	DateFormat Month = new SimpleDateFormat("MM"); // Stores the month on the following format: mm
	String month = Month.format(date); // Receives the current month to save on the transaction
	DateFormat Year = new SimpleDateFormat("yyyy"); // Stores the year on the following format: yyyy
	String year = Year.format(date); // Receives the current year to save on the transaction

	static ArrayList<Product> productTableList = new ArrayList<Product>(); // Stores the Product's info in a Product's table class

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
		if (StockView.returnProduct == true)
		{
			jTextField_productCode.setText(codeTable);
			jTextField_productDescription.setText(tableDescription);
			editProduct = objectStockController.searchProduct(codeTable,
			                                                 false);
			productSale.setCode(editProduct.getCode());
			productSale.setSellingPrice(editProduct.getSellingPrice());
			productSale.setQuantity(editProduct.getQuantity());
			productSale.setDescription(editProduct.getDescription());
			productPurchase.setCode(editProduct.getCode());
			productPurchase.setPurchasePrice(editProduct.getPurchasePrice());
			productPurchase.setQuantity(editProduct.getQuantity());
			productPurchase.setDescription(editProduct.getDescription());
			if (salePurchaseStatus == 0)
			{
				jTextField_productValue.setText(Double.toString(editProduct
				        .getSellingPrice()));
			}
			else if (salePurchaseStatus == 1)
			{
				jTextField_productValue.setText(Double.toString(editProduct
				        .getPurchasePrice()));
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
			jTextField_productCode.setText(codeTable);
			jTextField_productDescription.setText(tableDescription);
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
		for (Product p : productTableList)
		{
			if (salePurchaseStatus == 0)
			{
				model.addRow(new String[]
				{ p.getCode(), p.getDescription(),
				        Double.toString(p.getQuantity()),
				        Double.toString(p.getSellingPrice()),
				        Double.toString(p.getSellingPrice() * p.getQuantity()) });
				productValue = productValue + p.getSellingPrice() * p.getQuantity();
			}
			else if (salePurchaseStatus == 1)
			{
				model.addRow(new String[]
				{ p.getCode(), p.getDescription(),
				        Double.toString(p.getQuantity()),
				        Double.toString(p.getPurchasePrice()),
				        Double.toString(p.getPurchasePrice() * p.getQuantity()) });
				productValue = productValue + p.getPurchasePrice() * p.getQuantity();
			}
		}
		model.addRow(new String[]
		{ "", "", "", "Total:", Double.toString(productValue) });
		jTable_showPurchaseSaleInfoTable.setModel(model);
	}

	// This method is responsible to confirm the Screen's Cancel Button Action
	private void jButton_exitScreenActionPerformed(java.awt.event.ActionEvent evt)
	{
		StockView.returnProduct = false;
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
			for (Product p : productTableList)
			{
				if (salePurchaseStatus == 0)
				{
					Product f = objectStockController.searchProduct(p
					        .getCode(), false);
					f.setQuantity(f.getQuantity() - p.getQuantity());
				}
				else if (salePurchaseStatus == 1)
				{
					Product f = objectStockController.searchProduct(p
					        .getCode(), false);
					f.setQuantity(f.getQuantity() + p.getQuantity());
				}
			}

			if (salePurchaseStatus == 0)
			{
				Client c = ContactDataView.objectClientController
				        .searchClient(nameClientSupplier, false);
				Employee f = ContactDataView.objectEmployeeController
				        .searchEmployee(nameEmployee, false);
				objectSale = new Sale(c,
				                   productTableList,
				                     productValue,
				                     f,
				                     Integer.parseInt(day),
				                     Integer.parseInt(month),
				                     Integer.parseInt(year));
				umControleTransacao.addSale(objectSale);

			}

			else if (salePurchaseStatus == 1)
			{
				Supplier c = ContactDataView.objectSupplierController
				        .searchSupplier(nameClientSupplier, false);
				Employee f = ContactDataView.objectEmployeeController
				        .searchEmployee(nameEmployee, false);
				objectPurchase = new Purchase(c,
				                           productTableList,
				                       productValue,
				                       f,
				                       Integer.parseInt(day),
				                       Integer.parseInt(month),
				                       Integer.parseInt(year));
				umControleTransacao.addSale(objectPurchase);

				Expense expenseInfo = new Expense("Compra de Produto do Fornecedor'"
				                                      + c.getName() + "'",
				                              null,
				                              productValue,
				                              Integer.parseInt(day),
				                              Integer.parseInt(month),
				                              Integer.parseInt(year));
				ExpenseDataView.objectExpenseController.addExpense(expenseInfo);
			}

			showInfo("Operação realizada com sucesso!");
			this.dispose();
			employeeMode = false;
			clientSupplierMode = false;
			StockView.returnProduct = false;
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
		new StockView().setVisible(true);
		this.dispose();
	}

	// This method is responsible to confirm the Screen's Add Product Button Action
	private void jButton_addProductActionPerformed(
	        java.awt.event.ActionEvent evt)
	{
		int verifyAddedProduct = 0;
		for (Product s : productTableList)
			if (s.getCode().equalsIgnoreCase(productSale.getCode()))
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
					if (editProduct.getQuantity() != 0)
					{
						if (Double.parseDouble(jTextField_productQuantity.getText()) <= editProduct
						        .getQuantity())
						{
							productSale.setQuantity(Double
							        .parseDouble(jTextField_productQuantity
							                .getText()));
							productSale.setSellingPrice(Double
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
						productPurchase.setQuantity(Double
						        .parseDouble(jTextField_productQuantity.getText()));
						productTableList.add(productPurchase);
						loadList();
						jButton_addProduct.setEnabled(false);
						jTextField_productQuantity.setEnabled(false);
						jTextField_productDiscount.setEditable(false);
						for (Product s : productTableList)
						{
							if (s.getCode()
							        .equalsIgnoreCase(productSale.getCode()))
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
			for (Product p : productTableList)
			{
				if (p.getCode().equalsIgnoreCase(nomeTabela))
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
			double productValueWithDiscount = editProduct.getSellingPrice();
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
