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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.log4j.Logger;


public class SalePurchaseView extends javax.swing.JFrame
{
	private JButton jButton_addProduct; // Button responsible to add product
	private JButton jButton_exitScreen; // Button responsible to exit Main Screen
	private JButton jButton_finishForm; // Button responsible to Finish and Complete the Screen's form
	private JButton jButton_searchClientSupplier; // Button responsible to Search Client and Supplier Names
	private JButton jButton_searchEmployee; // Button responsible search Employee
	private JButton jButton_searchProduct; // Button responsible search Employee
	private JButton jButton_removeProduct; // Button responsible to remove product
	private JComboBox jComboBox_showSalePurchase; // Button that shows a drop-down list with Buying/Sale option
	private JLabel jLabel_showClientWord; // Shows the "Client" word with a chosen Sales option 
	private JLabel jLabel_showSupplierWord; // Shows the "Supplier" word with a chosen Shopping option 
	private JLabel jLabel_showProductWord; // Shows the "Product" word on the screen
	private JLabel jLabel_showQuantityWord; // Shows the "Quantity" word on the screen
	private JLabel jLabel_showPriceWord; // Shows the "Price" word on the screen
	private JLabel jLabel_showDiscountWord; // Shows the "Discount" word on the screen
	private JLabel jLabel_showDiscountPercentageSymbol; // Shows a discount's percentage symbol
	private JLabel jLabel_showMainScreenName; // Shows the main screen name: "Sale Release"
	private JLabel jLabel_showOperationName; // Shows the operation name: Buying or Selling
	private JPanel jPanel_showEntireSalePurchaseScreen; // Shows the entire Sales Release's screen layout
	private JScrollPane jScrollPane_showSalePurchaseScreenScroll; // Shows the Sales Release's screen scroll 
	private JTable jTable_showPurchaseSaleInfoTable; // Shows a table with the Product's code, description, quantity, price and final price (with discount)
	private JTextField jTextField_productCode; // Shows the product's code
	private JTextField jTextField_productDiscount; // Shows the product's discount
	private JTextField jTextField_productDescription; // Shows the product's description
	private JTextField jTextField_clientSupplierName; // Shows Client's name with a chosen Selling option and the Supplier's name with a chosen Shopping option 
	private JTextField jTextField_employeeName; // Shows Worker's name with both chosen options: Shopping/Selling
	private JTextField jTextField_productQuantity; // Sets the initial product's quantity value (0)
	private JTextField jTextField_productValue; // Shows the product's value
	
	EnterpriseManagement main; // Main object from EnterpriseManagement's class
	protected static int salePurchaseStatus = 0; // Shows the Client's name when option is 0 (Selling) and Supplier's name when option is 1 (Buying)
	static boolean purchaseSaleMode = false; // Makes the user to exit the screen and to not write Client/Supplier's names
	static boolean clientSupplierMode = false; // Enables the user to search registered Client/Supplier's names
	static boolean employeeMode = false; // Gets the Supplier's info to continue the Shopping Products
	static boolean productMode = false; // Gets the Product's code and description to buy or sell them
	static TransactionController objectTransactionController = new TransactionController(); // Object from TransactionController's class
	Product editProduct; // Object from Product class that edits the product's info
	Product productSale = new Product(); // Object from Product class that adds products to sale
	Product productPurchase = new Product(); // Object from Product class that adds products to buy
	Sale objectSale; // Variable that adds a Product to Sell
	Purchase objectPurchase; // Variable that adds a Product to Buy
	double transactionPrice = 0; // Multiplies the product's quantity and the product's value (without discount)
	final Date CURRENT_DATE = new Date(); // Stores the current date/month/year
	final DateFormat DAY = new SimpleDateFormat("dd"); // Stores the day on the following format: dd
	final String CURRENT_DAY = DAY.format(CURRENT_DATE); // Receives the current day to save on the transaction
	final DateFormat MONTH = new SimpleDateFormat("MM"); // Stores the month on the following format: mm
	final String CURRENT_MONTH = MONTH.format(CURRENT_DATE); // Receives the current month to save on the transaction
	final DateFormat YEAR = new SimpleDateFormat("yyyy"); // Stores the year on the following format: yyyy
	final String CURRENT_YEAR = YEAR.format(CURRENT_DATE); // Receives the current year to save on the transaction

	static ArrayList<Product> productTableList = new ArrayList<Product>(); // Stores the Product's info in a Product's table class
	static Logger log = Logger.getLogger(SalePurchaseView.class.getName()); // Used to log debug, info, warning, error and fatal error

	// This method is responsible to show a specific info as a Text Box
	public void showInfo(String info)
	{
		JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
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
			jTextField_clientSupplierName.setText(ContactView.nameClientSupplier);
		}
		else 
		{
			// Nothing to Do
		}
		
		if (ContactView.returnEmployee == true)
		{
			String employeeName = ContactView.nameEmployee;
			jTextField_employeeName.setText(employeeName);
			
			if (employeeName != "")
			{
				log.info("Selected transaction's employee: '" + employeeName +  "'.");
			}
			else
			{
				// Nothing to do because any employee was selected
			}
		}
		else
		{
			// Nothing to Do
		}
		
		if (StockView.returnProduct == true)
		{
			jTextField_productCode.setText(codeTable);
			jTextField_productDescription.setText(tableDescription);
			editProduct = objectStockController.searchProduct(codeTable, false);
			
			String transactionProductCode = editProduct.getCode();
			double transactionProductSellingPrice = editProduct.getSellingPrice();
			double transactionProductQuantity = editProduct.getQuantity();
			String transactionProductDescription = editProduct.getDescription();
			
			productSale.setCode(transactionProductCode);
			productSale.setSellingPrice(transactionProductSellingPrice);
			productSale.setQuantity(transactionProductQuantity);
			productSale.setDescription(transactionProductDescription);
			
			productPurchase.setCode(transactionProductCode);
			productPurchase.setPurchasePrice(transactionProductSellingPrice);
			productPurchase.setQuantity(transactionProductQuantity);
			productPurchase.setDescription(transactionProductDescription);
			
			if (salePurchaseStatus == 0)
			{
				double productSellingPrice = editProduct.getSellingPrice();
				String strProductSellingPrice = Double.toString(productSellingPrice);
				jTextField_productValue.setText(strProductSellingPrice);
			}
			else if (salePurchaseStatus == 1)
			{
				double productPurchasePrice = editProduct.getPurchasePrice();
				String strproductPurchasePrice = Double.toString(productPurchasePrice);
				jTextField_productValue.setText(strproductPurchasePrice);
			}
			else
			{
				// Nothing to do
			}
			
			if (salePurchaseStatus == 0)
			{
				jTextField_productDiscount.setEnabled(true);
			}
			else if (salePurchaseStatus == 1)
			{
				jTextField_productDiscount.setEnabled(false);
			}
			else
			{
				// Nothing to do
			}

			jButton_addProduct.setEnabled(true);
			jTextField_productQuantity.setEnabled(true);
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
		else
		{
			// Nothing to do
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
		else
		{
			// Nothing to do
		}
		
		log.debug("Load SalePurchaseView");
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
		jPanel_showEntireSalePurchaseScreen = new JPanel();
		jButton_exitScreen = new JButton();
		jTextField_productValue = new JTextField();
		jButton_searchEmployee = new JButton();
		jButton_addProduct = new JButton();
		jTextField_productQuantity = new JTextField();
		jLabel_showClientWord = new JLabel();
		jTextField_productCode = new JTextField();
		jLabel_showSupplierWord = new JLabel();
		jScrollPane_showSalePurchaseScreenScroll = new JScrollPane();
		jTable_showPurchaseSaleInfoTable = new JTable();
		jButton_searchProduct = new JButton();
		jLabel_showQuantityWord = new JLabel();
		jLabel_showProductWord = new JLabel();
		jLabel_showPriceWord = new JLabel();
		jTextField_clientSupplierName = new JTextField();
		jButton_finishForm = new JButton();
		jButton_searchClientSupplier = new JButton();
		jTextField_employeeName = new JTextField();
		jComboBox_showSalePurchase = new JComboBox();
		jLabel_showDiscountWord = new JLabel();
		jButton_removeProduct = new JButton();
		jTextField_productDiscount = new JTextField();
		jLabel_showDiscountPercentageSymbol = new JLabel();
		jLabel_showMainScreenName = new JLabel();
		jTextField_productDescription = new JTextField();
		jLabel_showOperationName = new JLabel();

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
			        	try
						{
							jButton_searchEmployeeActionPerformed(evt);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
			        }
		        });

		jButton_addProduct.setText("+");
		jButton_addProduct
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
			        	try
						{
							jButton_addProductActionPerformed(evt);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
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
				try
				{
					jTable_showPurchaseSaleInfoTableMouseClicked(evt);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		jScrollPane_showSalePurchaseScreenScroll.setViewportView(jTable_showPurchaseSaleInfoTable);

		jButton_searchProduct.setText("Pesquisar");
		jButton_searchProduct
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        try
						{
							jButton_searchProductActionPerformed(evt);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
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
				try
				{
					jButton_finishFormActionPerformed(evt);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		jButton_searchClientSupplier.setText("Pesquisar");
		jButton_searchClientSupplier
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        try
						{
							jButton_searchClientSupplierActionPerformed(evt);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
			        }
		        });

		jComboBox_showSalePurchase
		        .setModel(new javax.swing.DefaultComboBoxModel(new String[]
		        { "Venda", "Compra" }));
		jComboBox_showSalePurchase.addItemListener(new java.awt.event.ItemListener()
		{
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				try
				{
					jComboBox_showSalePurchaseItemStateChanged(evt);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		jLabel_showDiscountWord.setText("Desconto:");

		jButton_removeProduct.setText("-");
		jButton_removeProduct
		        .addActionListener(new java.awt.event.ActionListener()
		        {
			        public void actionPerformed(java.awt.event.ActionEvent evt)
			        {
				        try
						{
							jButton_removeProductActionPerformed(evt);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
			        }
		        });

		jTextField_productDiscount.setText("0.0");
		jTextField_productDiscount.addFocusListener(new java.awt.event.FocusAdapter()
		{
			public void focusLost(java.awt.event.FocusEvent evt)
			{
				try
				{
					jTextField_productDiscountFocusLost(evt);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
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
		transactionPrice = 0;
		DefaultTableModel model = (DefaultTableModel) jTable_showPurchaseSaleInfoTable.getModel();
		model.setRowCount(0);
		for (Product product : productTableList)
		{
			if (salePurchaseStatus == 0)
			{
				String productCode = product.getCode();
				String productDescripiton = product.getDescription();
				double productQuantity = product.getQuantity();
				String strProductQuantity = Double.toString(productQuantity);
				double productSellingPrice = product.getSellingPrice();
				String strProductSellingPrice = Double.toString(productSellingPrice);
				double itemValue = productSellingPrice * productQuantity;
				String strItemValue = Double.toString(itemValue);
				
				model.addRow(new String[]
				{ 
					productCode, 
					productDescripiton,
					strProductQuantity,
					strProductSellingPrice,
					strItemValue 
				});
				
				transactionPrice = transactionPrice + itemValue;
			}
			else if (salePurchaseStatus == 1)
			{
				String productCode = product.getCode();
				String productDescripiton = product.getDescription();
				double productQuantity = product.getQuantity();
				String strProductQuantity = Double.toString(productQuantity);
				double productPurchasePrice = product.getPurchasePrice();
				String strProductPurchasePrice = Double.toString(productPurchasePrice);
				double itemValue = productPurchasePrice * productQuantity;
				String strItemValue = Double.toString(itemValue);
				
				model.addRow(new String[]
				{ 
					productCode, 
					productDescripiton,
					strProductQuantity,
					strProductPurchasePrice,
					strItemValue  
				});
				
				transactionPrice = transactionPrice + itemValue;
			}
			else
			{
				// Nothing to do
			}
		}
		
		String strTransactionPrice = Double.toString(transactionPrice);
		
		model.addRow(new String[]
		{ 
			"", "", "", "Total:", strTransactionPrice
		});
		
		jTable_showPurchaseSaleInfoTable.setModel(model);
		
		log.debug("Refresh product list");
	}

	// This method is responsible to confirm the Screen's Cancel Button Action
	private void jButton_exitScreenActionPerformed(java.awt.event.ActionEvent evt)
	{
		StockView.returnProduct = false;
		purchaseSaleMode = false;
		log.debug("Exit SalePurchaseView");
		this.dispose();
	}

	// This method is responsible to confirm the Screen's Search Client/Provider Button Action
	private void jButton_searchClientSupplierActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{
		try
		{
			Integer.parseInt(ContactView.nameClientSupplier);
			purchaseSaleMode = true;
			clientSupplierMode = true;
			
			if (salePurchaseStatus == 0)
			{
				ContactView.contactType = 0;
			}
			else if (salePurchaseStatus == 1)
			{
				ContactView.contactType = 1;
			}
			else
			{
				// Nothing to do
			}
			
			ContactView.nameClientSupplier = null;
			new ContactView().setVisible(true);
			this.dispose();
		}
		catch(Exception e)
		{
			log.error("Error when searching client/supplier. Exception: ",e);
			throw e;
		}
	}

	/* This method is responsible to display the Client's name when the chosen
	 * operation was "Selling" and the Provider's name when the chosen operation
	 * was "Shopping" */
	private void jComboBox_showSalePurchaseItemStateChanged(java.awt.event.ItemEvent evt) throws Exception
	{
		try
		{
			int selectedTransactionComboBox = jComboBox_showSalePurchase.getSelectedIndex();
			
			if (salePurchaseStatus == 1)
			{
				if (selectedTransactionComboBox == 0)
				{
					productTableList.clear();
					salePurchaseStatus = 0;
					jLabel_showClientWord.setText("Cliente:");
					jLabel_showMainScreenName.setText("Lançamento Venda");
					jTextField_clientSupplierName.setText(null);
					
					log.debug("Selected sale transaction");
				}
				else
				{
					// Nothing to do because the selected combo box is the same as the previous one
				}
			}
			else if (salePurchaseStatus == 0)
			{
				if (selectedTransactionComboBox == 1)
				{
					productTableList.clear();
					salePurchaseStatus = 1;
					jLabel_showClientWord.setText("Fornecedor:");
					jTextField_clientSupplierName.setText(null);
					jTextField_productDiscount.setText("0.0");
					jLabel_showMainScreenName.setText("Lançamento Compra");
					jTextField_productDiscount.setEnabled(false);
					
					log.debug("Selected purchase transaction");
				}
				else
				{
					// Nothing to do because the selected combo box is the same as the previous one
				}
			}
			
			loadList();
		}
		catch(Exception e)
		{
			log.error("Error when selecting transaction mode (Sale/Transaction). Exception: ",e);
			throw e;
		}
	}

	// This method is responsible to confirm the Screen's Search Provider Button Action
	private void jButton_searchEmployeeActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{
		try
		{
			purchaseSaleMode = true;
			employeeMode = true;
			ContactView.contactType = 2;
			ContactView.nameEmployee = null;
			new ContactView().setVisible(true);
			this.dispose();
		}
		catch(Exception e)
		{
			log.error("Error when search Employee",e);
			throw e;
		}
	}

	/* This method is responsible to confirm the Screen's Finish Button Action
	 * and to prevent the User to finish the form without choosing the Client,
	 * Provider and Product names */
	private void jButton_finishFormActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{
		try
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
				else
				{
					// Nothing to do
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
				for (Product product : productTableList)
				{
					String productCode = product.getCode();
					Product objectEditProduct = objectStockController.searchProduct(productCode, false);
					
					double editProductQuantity = objectEditProduct.getQuantity();
					double productQuantity = product.getQuantity();
					
					if (salePurchaseStatus == 0)
					{
						double newProductQuantity = editProductQuantity - productQuantity;
						objectEditProduct.setQuantity(newProductQuantity);
					}
					else if (salePurchaseStatus == 1)
					{
						double newProductQuantity = editProductQuantity + productQuantity;
						objectEditProduct.setQuantity(newProductQuantity);
					}
					else
					{
						// Nothing to do
					}
				}
	
				if (salePurchaseStatus == 0)
				{	
					Client client = ContactDataView.objectClientController.searchClient(nameClientSupplier, false);
					Employee employee = ContactDataView.objectEmployeeController.searchEmployee(nameEmployee, false);
					objectSale = new Sale(client, productTableList, transactionPrice, employee, Integer.parseInt(CURRENT_DAY), 
					                      Integer.parseInt(CURRENT_MONTH), Integer.parseInt(CURRENT_YEAR));
					objectTransactionController.addTransaction(objectSale);
					
					log.info("Sale operation to client '" + nameClientSupplier + "' finalized successfully!");
				}
				else if (salePurchaseStatus == 1)
				{	
					Supplier purchaseSupplier = ContactDataView.objectSupplierController.searchSupplier(nameClientSupplier, false);
					Employee employeeSupplier = ContactDataView.objectEmployeeController.searchEmployee(nameEmployee, false);
					
					objectPurchase = new Purchase(purchaseSupplier, productTableList, transactionPrice, employeeSupplier, Integer.parseInt(CURRENT_DAY),
					                              Integer.parseInt(CURRENT_MONTH), Integer.parseInt(CURRENT_YEAR));
					objectTransactionController.addTransaction(objectPurchase);
	
					String expenseDescription = "Compra de Produto do Fornecedor'" + purchaseSupplier.getName() + "'";
					
					Expense expenseInfo = new Expense(expenseDescription, null, transactionPrice, 
					                                  Integer.parseInt(CURRENT_DAY), Integer.parseInt(CURRENT_MONTH), Integer.parseInt(CURRENT_YEAR));
					
					ExpenseDataView.objectExpenseController.addExpense(expenseInfo);
					
					log.info("Purchase operation of supplier '" + nameClientSupplier + "' finalized successfully!");
				}
				else
				{
					// Nothing to do
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
		catch(Exception e)
		{
			log.error("Error when finishing transaction. Exception: ",e);
			throw e;
		}
	}

	// This method is responsible to confirm the Screen's Search Product Button Action
	private void jButton_searchProductActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{
		try
		{
			purchaseSaleMode = true;
			productMode = true;
			new StockView().setVisible(true);
			this.dispose();
		}
		catch(Exception e)
		{
			log.error("Error when search product. Exception: ",e);
			throw e;
		}
	}

	// This method is responsible to confirm the Screen's Add Product Button Action
	private void jButton_addProductActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{
		try
		{
			int verifyAddedProduct = 0;
			String saleProductCode = productSale.getCode();
			
			for (Product tableProduct : productTableList)
			{
				String tableProductCode = tableProduct.getCode();
				
				if (tableProductCode.equalsIgnoreCase(saleProductCode))
				{
					verifyAddedProduct = 1;
				}
				else 
				{
					// Nothing to Do
				}
			}
			
			if (verifyAddedProduct == 0)
			{
				String strProductQuantity = jTextField_productQuantity.getText();
				double productQuantity = Double.parseDouble(jTextField_productQuantity.getText());
				if (productQuantity != 0.0 && !strProductQuantity.equals(""))
				{
					if (salePurchaseStatus == 0)
					{
						double productStockQuantity = editProduct.getQuantity();
						
						if (productStockQuantity != 0)
						{
							if (productQuantity <= productStockQuantity)
							{
								productSale.setQuantity(Double.parseDouble(jTextField_productQuantity.getText()));
								productSale.setSellingPrice(Double.parseDouble(jTextField_productValue.getText()));
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
						productPurchase.setQuantity(Double.parseDouble(jTextField_productQuantity.getText()));
						productTableList.add(productPurchase);
						loadList();
						jButton_addProduct.setEnabled(false);
						jTextField_productQuantity.setEnabled(false);
						jTextField_productDiscount.setEditable(false);
						
						String productName = productPurchase.getDescription();
						log.info("Added product '" + productName + "' to transaction");
						
						for (Product tableProduct : productTableList)
						{
							String tableProductCode = tableProduct.getCode();
							
							if (tableProductCode.equalsIgnoreCase(saleProductCode))
							{
								verifyAddedProduct = 1;
							}
							else
							{
								// Nothing to Do
							}
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
		catch(Exception e)
		{
			log.error("Error when adding product. Exception: ", e);
			throw e;
		}
	}

	// This method is responsible to list and edit the registered Products
	private void jTable_showPurchaseSaleInfoTableMouseClicked(java.awt.event.MouseEvent evt) throws Exception
	{
		try
		{
			String totalProductValue = null;
			DefaultTableModel model = (DefaultTableModel) jTable_showPurchaseSaleInfoTable.getModel();
			String nomeTabela = (String) model.getValueAt(jTable_showPurchaseSaleInfoTable.getSelectedRow(), 0);
			totalProductValue = (String) model.getValueAt(jTable_showPurchaseSaleInfoTable.getSelectedRow(), 1);
			
			if (!"Total:".equals(totalProductValue))
			{
				for (Product product : productTableList)
				{
					String tableProductCode = product.getCode();
					
					if (tableProductCode.equalsIgnoreCase(nomeTabela))
					{
						editProduct = product;
						
						String productDescription = product.getDescription();
						log.debug("Click product '" + productDescription + "' on product table");
					}
					else
					{
						// Nothing to do
					}
				}
				jButton_removeProduct.setEnabled(true);
			}
			else if (totalProductValue.equals("Total:"))
			{
				jButton_removeProduct.setEnabled(false);
			}
			else
			{
				// Nothing to do
			}
		}
		catch(Exception e)
		{
			log.error("Error when clicking the product table. Exception: ", e);
			throw e;
		}
	}

	// This method is responsible to confirm the Screen's Remove Product Button Action
	private void jButton_removeProductActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{
		try
		{
			String productDescription = editProduct.getDescription();
			log.debug("Start removing product '" + productDescription + "'.");
			
			productTableList.remove(editProduct);
			loadList();
			showInfo("Produto removido");
			jButton_addProduct.setEnabled(true);
			jTextField_productQuantity.setEnabled(true);
			jTextField_productDiscount.setEnabled(true);
			jButton_removeProduct.setEnabled(false);
			
			log.info("Product '" + productDescription + "' successfully removed");
		}
		catch(Exception e)
		{
			log.error("Error when removing product. Exception: ", e);
			throw e;
		}
	}

	// This method is responsible to add (in percentage) the Product's discount
	private void jTextField_productDiscountFocusLost(java.awt.event.FocusEvent evt) throws Exception
	{
		try
		{
			String strProductDiscount = jTextField_productDiscount.getText();
			double productDiscount = Double.parseDouble(strProductDiscount);
			
			if (productDiscount > 100)
			{
				showInfo("Limite de desconto excedido");
				jTextField_productDiscount.setText("0.0");
				jTextField_productDiscount.requestFocus();
			}
			else if (strProductDiscount.equals(""))
			{
				jTextField_productDiscount.setText("0.0");
			}
			else
			{
				double productValueWithDiscount = editProduct.getSellingPrice();
				
				double decimalDiscount = 1 - (productDiscount / 100);
				double finalProductPrice = productValueWithDiscount * decimalDiscount;
				String strFinalProductPrice = Double.toString(finalProductPrice);
				
				String productDescription = editProduct.getDescription();
				
				log.info("Applied discount of " + productDiscount + "% on product '" + productDescription +"'.");
				
				jTextField_productValue.setText(strFinalProductPrice);
			}
		}
		catch(Exception e)
		{
			log.error("Error when applying discount on product.");
		}
	}

	/* This main method is responsible to enable the Nimbus (GUI) Interface and
	 * display all the Shopping/Selling list info with a log system */
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
					// Nothing to do
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
