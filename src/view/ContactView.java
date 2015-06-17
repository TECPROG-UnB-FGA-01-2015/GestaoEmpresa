/**********************************************************
 * File: ContactView.java
 * Purpose: Lists the contacts of the system
 *********************************************************/

package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.Client;
import model.PhysicalClient;
import model.JuridicalClient;
import model.Supplier;
import model.PhysicalSupplier;
import model.JuridicalSupplier;
import model.Employee;
import static view.ContactDataView.objectClientController;
import static view.ContactDataView.objectSupplierController;
import static view.ContactDataView.objectEmployeeController;
import static view.SalePurchaseView.clientSupplierMode;
import static view.SalePurchaseView.purchaseSaleMode;
import static view.SalePurchaseView.salePurchaseStatus;

import org.apache.log4j.Logger;

public class ContactView extends javax.swing.JFrame
{
	// Variables declaration of Buttons, ComboBox, Labels, Panel, ScrollPane, Table and TextField
    private javax.swing.JButton jButton_AdicionarContato; // Button that adds a New Contact (Client, Supplier or Employee) on the system
    private javax.swing.JButton jButton_Cancelar; // Button that exits "Contact Register" Screen
    private javax.swing.JButton jButton_ConfirmarContato; // Button that adds and saves the new contact on the system
    private javax.swing.JButton jButton_Editar; // Button that edits the added contact on the system
    private javax.swing.JButton jButton_Excluir; // Button that deletes the added contact on the system
    private javax.swing.JButton jButton_Pesquisar; // Button that searches the added contact on the system
    private javax.swing.JComboBox jComboBox1; // Button that shows a drop-down list with Client/Supplier/Employee options
    private javax.swing.JLabel jLabel1; // Shows the "Name" word on the Screen 
    private javax.swing.JLabel jLabel2; // Shows the "Contact Register" sentence on the Screen 
    private javax.swing.JPanel jPanel1; // Shows the entire "Contact Register" Screen Layout
    private javax.swing.JScrollPane jScrollPane1; // Shows the "Contact Register" screen scroll 
    private javax.swing.JTable jTable1; // Shows a table with name, CPF/CNPJ, cellphone, telephone, Physical/Juridical
    private javax.swing.JTextField jTextField_NomeBusca; // Shows the searched name of Client/Supplier/Employee
    
    EnterpriseManagement mainMenu; // Instantiate the main menu class
    static boolean newPhysicalClient = true; // Indicates if form is loaded to add a new Physical Client
    static boolean newJuridicalClient = true; // Indicates if form is loaded to add a new Juridical Client
    static boolean newPhysicalSupplier = true; // Indicates if form is loaded to add a new Physical Supplier
    static boolean newJuridicalSupplier = true; // Indicates if form is loaded to add a new Juridical Supplier
    static boolean newEmployee = true; // Indicates if form is loaded to add a new Employee
    static boolean editMode = false; // Indicates if form is loaded to edit some contact
    static String tableName; // Holds the name of the table
    static int contactType; // Indicates the type of contact (0 = client, 1 = supplier, 2 = employee)
    static ArrayList<Client> listClient; // Instantiates a list of clients
    public PhysicalClient objectPhysicalClient; // Instantiates an objectPhysicalClient
    public JuridicalClient objectJuridicalClient; // Instantiates an object JuridicalClient
    static ArrayList<Supplier> listSupplier; // Instantiates a list of suppliers
    public PhysicalSupplier objectPhysicalSupplier; // Instantiates an object PhysicalSupplier
    public JuridicalSupplier objectJuridicalSupplier; // Instantiates an object JuridicalSupplier
    static ArrayList<Employee> listEmployee; // Instantiates a list of employees
    public Employee objectEmployee; // Instantiates an object Employee
    int quantitySearchResult; // Holds the quantity of contacts found after the search
    SalePurchaseView salePurchaseView; // Instantiates the sale/purchase view
    static boolean returnClientSupplier; // Indicates if client/supplier was returned to sale/purchase view
    static boolean returnEmployee; // Indicates if employees was returned to sale/purchase view
    static String nameClientSupplier; // Holds the name of the client/supplier to return to sale/purchase view
    static String nameEmployee; // Holds the name of the employee to return to sale/purchase view
    
    static Logger log = Logger.getLogger(ContactView.class.getName());

    // Constructor of the ContactView's class
    public ContactView()
    {
        initComponents();
        jButton_Editar.setEnabled(false);
        jButton_Excluir.setEnabled(false);
        loadContactList();
        jButton_ConfirmarContato.setVisible(false);
        jButton_ConfirmarContato.setEnabled(false);
        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(purchaseSaleMode == true)
        {
            if(SalePurchaseView.employeeMode == true)
            {
                jComboBox1.setSelectedIndex(2);
            }
            else if(salePurchaseStatus == 0)
            {
                jComboBox1.setSelectedIndex(0);
            }
            else if(salePurchaseStatus == 1)
            {
                jComboBox1.setSelectedIndex(1);
            }   
            else
            {
            	// Nothing to do
            }
            jComboBox1.setEnabled(false);
            jButton_ConfirmarContato.setVisible(true);
        }
        if(SalePurchaseView.employeeMode == true)
        {
            jButton_AdicionarContato.setEnabled(false);
        }
        else
        {
        	// Nothing to do
        }
        
        jTextField_NomeBusca.requestFocus();
        log.debug("Load ContactView");
    }

    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jButton_AdicionarContato = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField_NomeBusca = new javax.swing.JTextField();
        jButton_Pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_Editar = new javax.swing.JButton();
        jButton_Excluir = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton_ConfirmarContato = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contato");
        setBounds(new java.awt.Rectangle(450, 300, 0, 0));

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jPanel1MouseClicked(evt);
            }
        });

        jButton_AdicionarContato.setText("Adicionar Novo Contato");
        jButton_AdicionarContato.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                try
				{
					jButton_AdicionarContatoActionPerformed(evt);
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel1.setText("Nome:");

        jButton_Pesquisar.setText("Pesquisar");
        jButton_Pesquisar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton_PesquisarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel
            (
                null,
                new String []
                {
                    "Nome", "CPF/CNPJ", "Celular", "Telefone", "Físico/Jurídico"
                }
            )
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

            jButton_Editar.setText("Editar");
            jButton_Editar.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    jButton_EditarActionPerformed(evt);
                }
            });

            jButton_Excluir.setText("Excluir");
            jButton_Excluir.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    jButton_ExcluirActionPerformed(evt);
                }
            });

            jButton_Cancelar.setText("Sair");
            jButton_Cancelar.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
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

            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "Fornecedor", "Funcionário" }));
            jComboBox1.addItemListener(new java.awt.event.ItemListener()
            {
                public void itemStateChanged(java.awt.event.ItemEvent evt)
                {
                    jComboBox1ItemStateChanged(evt);
                }
            });

            jButton_ConfirmarContato.setText("Confirmar");
            jButton_ConfirmarContato.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    jButton_ConfirmarContatoActionPerformed(evt);
                }
            });

            jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
            jLabel2.setText("Cadastro de Contato");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton_Excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(17, 17, 17))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jButton_Cancelar)
                            .addGap(70, 70, 70)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(185, 185, 185)
                            .addComponent(jButton_ConfirmarContato))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(235, 235, 235)
                            .addComponent(jButton_AdicionarContato))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField_NomeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton_Pesquisar)))
                    .addContainerGap(17, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton_Cancelar)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField_NomeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jButton_Pesquisar)
                            .addGap(18, 18, 18)
                            .addComponent(jButton_AdicionarContato)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jButton_Editar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton_Excluir))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton_ConfirmarContato)
                    .addContainerGap(33, Short.MAX_VALUE))
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
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            getAccessibleContext().setAccessibleDescription("");

            pack();
        }

    // Shows message on screen with given string
    public void showMessage(String info)
    {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
        log.info(info);
    }

    // Access and returns the property clieteFisico
    public PhysicalClient getPhysicalClient()
    {
        return objectPhysicalClient;
    }
    
    // Loads the contact list
    private void loadContactList()
    {
        if(contactType == 0)
        {
            listClient = objectClientController.getClientList();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (listClient != null)
            {
	            for (Client client : listClient) {
	                if(client.getClass().equals(PhysicalClient.class))
	                {
	                    objectPhysicalClient=(PhysicalClient) client;
	                    model.addRow(new String[]{objectPhysicalClient.getName(), 
	                        objectPhysicalClient.getCpf(), objectPhysicalClient.getCellphone(), 
	                        objectPhysicalClient.getTelephone(), "Física"});
	                }
	                else if(client.getClass().equals(JuridicalClient.class))
	                {
	                    objectJuridicalClient = (JuridicalClient) client;
	                    model.addRow(new String[]{objectJuridicalClient.getName(), 
	                        objectJuridicalClient.getCnpj(), objectJuridicalClient.getCellphone(), 
	                        objectJuridicalClient.getTelephone(), "Jurídica"});
	                }
	                else
	                {
	                	// Nothing to do
	                } 
	            }
            }
            else
            {
            	// Nothing to do
            }
            jTable1.setModel(model);
            log.debug("Load client on List");
        }
        else if(contactType == 1)
        {
            listSupplier = objectSupplierController.getSupplierList();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Supplier supplier : listSupplier)
            {
                if(supplier.getClass().equals(PhysicalSupplier.class))
                {
                    objectPhysicalSupplier = (PhysicalSupplier) supplier;
                    model.addRow(new String[]{objectPhysicalSupplier.getName(), 
                        objectPhysicalSupplier.getCpf(), objectPhysicalSupplier.getCellphone(), 
                        objectPhysicalSupplier.getTelephone(), "Física"});
                }
                else if(supplier.getClass().equals(JuridicalSupplier.class))
                {
                    objectJuridicalSupplier = (JuridicalSupplier) supplier;
                    model.addRow(new String[]{objectJuridicalSupplier.getName(), 
                        objectJuridicalSupplier.getCnpj(), objectJuridicalSupplier.getCellphone(), 
                        objectJuridicalSupplier.getTelephone(), "Jurídica"});
                }  
                else
                {
                	// Nothing to do
                }
            }
            jTable1.setModel(model);
            log.debug("Load supplier on List");
        }
        else if(contactType == 2)
        {
            listEmployee = objectEmployeeController.getEmployeeList();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Employee employee : listEmployee)
            {
                objectEmployee = (Employee) employee;
                model.addRow(new String[]{objectEmployee.getName(), 
                objectEmployee.getCpf(), objectEmployee.getCellphone(), 
                objectEmployee.getTelephone(), "Física"});   
            }
            jTable1.setModel(model);
            log.debug("Load employee on List");
        }
        else
        {
        	// Nothing to do
        }
    }
    
    // Cancels the client edit
    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) throws Exception
    {
         this.dispose();
         if(clientSupplierMode == true)
         {
        	 try
        	 {
	             new SalePurchaseView().setVisible(true);
	             log.debug("Open SalePurchaseView");
        	 }
        	 catch (Exception e)
     		 {
     			log.error("Error opening the view SalePurchaseView. Exception: ", e);
     			throw e;
     		 }
         }
         else
         {
        	 // Nothing to do
         }
         clientSupplierMode = false;
         SalePurchaseView.employeeMode = false;
    }

    // Calls the form to register new contact
    private void jButton_AdicionarContatoActionPerformed(java.awt.event.ActionEvent evt) throws Exception
    {
        editMode = false;
        
	    try
	   	{
	    	new ContactDataView().setVisible(true);
	        log.debug("Open ContactDataView");
	   	}
	   	catch (Exception e)
		{
	   		log.error("Error opening the view ContactDataView. Exception: ", e);
	   		throw e;
		}
	     
        this.setVisible(false);
    }

    // Search for the contacts
    private void jButton_PesquisarActionPerformed(java.awt.event.ActionEvent evt)
    {
        String searchName = jTextField_NomeBusca.getText();
        log.info("The user-given name is: '" + searchName + "'.");
        
        // Cleans the table
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        model1.setRowCount(0);
        jTable1.setModel(model1);
           
        if(!searchName.equals(""))
        {
            quantitySearchResult = 0;
            if(objectClientController.searchClient(searchName,true) != null)
            {
                if((purchaseSaleMode == false) || (purchaseSaleMode == true && contactType == 0))
                {
                	// Variable to receive the client returned of the search
                    Client searchClient = objectClientController.searchClient(searchName,true);
                    
                    jComboBox1.setSelectedIndex(0);
                    jTextField_NomeBusca.setText(searchClient.getName());

                    // Cleans the table
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);

                    quantitySearchResult = quantitySearchResult + 1;
                    
                    if(searchClient.getClass().equals(PhysicalClient.class))
                    {
                        PhysicalClient contactSearch=(PhysicalClient) objectClientController.searchClient(searchName,true);
                        model.addRow(new String[]{contactSearch.getName(), contactSearch.getCpf(), contactSearch.getCellphone(), contactSearch.getTelephone(), "Física"});
                        log.debug("Load physical client on list as result");
                    }
                    else if(searchClient.getClass().equals(JuridicalClient.class))
                    {
                        JuridicalClient contactSearch = (JuridicalClient) objectClientController.searchClient(searchName,true);
                        model.addRow(new String[]{contactSearch.getName(), 
                            contactSearch.getCnpj(), contactSearch.getCellphone(), 
                            contactSearch.getTelephone(), "Jurídica"});
                        log.debug("Load Juridical client on list as result");
                    }
                    else
                    {
                    	// Nothing to do
                    }
                }
                else
                {
                	// Nothing to do
                }
            }
            else
            {
            	// Nothing to do
            }
            
            if(objectSupplierController.searchSupplier(searchName,true) != null)
            {
                if((purchaseSaleMode == false) || (purchaseSaleMode == true && contactType == 1))
                {
                    quantitySearchResult = quantitySearchResult + 1;
                    
                    // Variable to receive the supplier returned of the search
                    Supplier supplierSearch = objectSupplierController.searchSupplier(searchName,true);
                    
                    jComboBox1.setSelectedIndex(1);
                    jTextField_NomeBusca.setText(supplierSearch.getName());

                    // Cleans the table
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);

                    if(supplierSearch.getClass().equals(PhysicalSupplier.class))
                    {
                        PhysicalSupplier contactSearch = (PhysicalSupplier) objectSupplierController.searchSupplier(searchName,true);
                        model.addRow(new String[]{contactSearch.getName(), 
                            contactSearch.getCpf(), contactSearch.getCellphone(), 
                            contactSearch.getTelephone(), "Físico"});
                    }
                    else if(supplierSearch.getClass().equals(JuridicalSupplier.class))
                    {
                        JuridicalSupplier contactSearch = (JuridicalSupplier) objectSupplierController.searchSupplier(searchName,true);
                        model.addRow(new String[]{contactSearch.getName(), 
                            contactSearch.getCnpj(), contactSearch.getCellphone(), 
                            contactSearch.getTelephone(), "Jurídica"});
                    }
                    else
                    {
                    	// Nothing to do
                    }
                }
                else
                {
                	// Nothing to do
                }
            }
            else
            {
            	// Nothing to do
            }
            
            if(objectEmployeeController.searchEmployee(searchName,true)!=null)
            {
                if((purchaseSaleMode == false) || (purchaseSaleMode == true && contactType == 2))
                {
                    quantitySearchResult = quantitySearchResult + 1;
                    
                    // Variable to receive the employee returned of the search
                    Employee buscaEmployee = objectEmployeeController.searchEmployee(searchName,true);
                    
                    jComboBox1.setSelectedIndex(2);
                    jTextField_NomeBusca.setText(buscaEmployee.getName());

                    // Cleans the table
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);

                    model.addRow(new String[]{buscaEmployee.getName(), 
                        buscaEmployee.getCpf(), buscaEmployee.getCellphone(), 
                        buscaEmployee.getTelephone(), "Física"});
                }
                else
                {
                	// Nothing to do
                }
            }
            else
            {
            	// Nothing to do
            }
            
            if((objectClientController.searchClient(searchName,true) == null)
                    &&(objectSupplierController.searchSupplier(searchName,true) == null)
                    &&(objectEmployeeController.searchEmployee(searchName,true) == null))
            {
                showMessage("A pesquisa não retornou nenhum resultado!");
                jTextField_NomeBusca.setText(null);
                jTextField_NomeBusca.requestFocus();
            }
            else
            {
            	// Nothing to do
            }
        }
        else
        {
            loadContactList();
            if(jTable1.getRowCount() == 0)
            {
                showMessage("A pesquisa não retornou nenhum resultado!");
            }
            else
            {
            	// Nothing to do
            }
        }

        if(quantitySearchResult > 1)
        {
            showMessage("Mais de um resultado foi encontrando com o nome '" + searchName + "'" );
            log.info("More than one result has found with the name '" + searchName + "'.");
        }
        else
        {
        	// Nothing to do
        }
    }

    // Changes contactType's variable depending on which contact type was chosen
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt)
    {
        if(jComboBox1.getSelectedIndex() == 0)
        {
            contactType = 0;
        }
        else if(jComboBox1.getSelectedIndex() == 1)
        {
            contactType = 1;
        }
        else if(jComboBox1.getSelectedIndex() == 2)
        {
            contactType = 2;
        }
        else
        {
        	// Nothing to do
        }
        
        jButton_Editar.setEnabled(false);
        jButton_Excluir.setEnabled(false);
        
        loadContactList();
    }

    // Opens contact register form to edit contact
    private void jButton_EditarActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(newPhysicalClient == true && newJuridicalClient == true
                && newPhysicalSupplier == true && newJuridicalSupplier == true
                && newEmployee == true)
        {
            mainMenu.showMessage("Selecione um Contato da Tabela");
        }
        else
        {
            new ContactDataView().setVisible(true);
            this.setVisible(false);
        }
    }

    // Select contact depending on which contact was clicked
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)
    {
        newPhysicalClient = true;
        newJuridicalClient = true;
        newPhysicalSupplier = true;
        newJuridicalSupplier = true;
        newEmployee = true;
                
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        tableName = (String) model.getValueAt(jTable1.getSelectedRow(), 0);
        
        if(contactType == 0)
        {
            if((String) model.getValueAt(jTable1.getSelectedRow(), 4) == "Física")
            {
                newPhysicalClient = false;
            }
            else if((String) model.getValueAt(jTable1.getSelectedRow(), 4) == "Jurídica")
            {
                newJuridicalClient = false;
            }
            else
            {
            	// Nothing to do
            }
        }
        else if(contactType == 1)
        {
            if((String) model.getValueAt(jTable1.getSelectedRow(), 4) == "Física")
            {
                newPhysicalSupplier = false;
            }
            else if((String) model.getValueAt(jTable1.getSelectedRow(), 4) == "Jurídica")
            {
                newJuridicalSupplier = false;
            }
            else
            {
            	// Nothing to do
            }
        }
        else if(contactType == 2)
        {
            newEmployee = false;
        }
        else
        {
        	// Nothing to do
        }
        
        jButton_Editar.setEnabled(true);
        jButton_Excluir.setEnabled(true);
        jButton_ConfirmarContato.setEnabled(true);
        editMode = true;
    }

    // Exclude contact selected
    private void jButton_ExcluirActionPerformed(java.awt.event.ActionEvent evt)
    {  
        if(newPhysicalClient == false)
        {
            objectClientController.removeClient(objectClientController.searchClient(tableName, false));
        }
        else if(newJuridicalClient == false)
        {
            objectClientController.removeClient(objectClientController.searchClient(tableName, false));
        }
        else if(newPhysicalSupplier == false)
        {
        	objectSupplierController.removeSupplier(objectSupplierController.searchSupplier(tableName, false));
        }
        else if(newJuridicalSupplier == false)
        {
            objectSupplierController.removeSupplier(objectSupplierController.searchSupplier(tableName, false));
        }
        else if(newEmployee == false)
        {
            objectEmployeeController.removeEmployee(objectEmployeeController.searchEmployee(tableName, false));
        }
        else
        {
        	// Nothing to do
        }
        
        loadContactList();
        showMessage("Contato excluído com sucesso");
        log.debug("Contact deleted successfully");
        jButton_Editar.setEnabled(false);
        jButton_Excluir.setEnabled(false);
    }

    // Disable the Confirm Contact button
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt)
    {
        jButton_ConfirmarContato.setEnabled(false);
    }

    // Confirm Contact chosen to TelaVendaCompra's view
    private void jButton_ConfirmarContatoActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.dispose();
        if(SalePurchaseView.clientSupplierMode == true)
        {
            returnClientSupplier = true;
        }
        else
        {
        	// Nothing to do
        }
        
        if(SalePurchaseView.employeeMode == true)
        {
            returnEmployee = true;
        }  
        else
        {
        	// Nothing to do
        }
        
        if(SalePurchaseView.clientSupplierMode == true && nameClientSupplier == null)
        {
            nameClientSupplier = tableName;
        }   
        else
        {
        	// Nothing to do
        }

        if(SalePurchaseView.employeeMode == true && nameEmployee == null)
        {
            nameEmployee = tableName;
        }
        else
        {
        	// Nothing to do
        }
        
        purchaseSaleMode = false;
        SalePurchaseView.clientSupplierMode = false;
        SalePurchaseView.employeeMode = false;
        
        new SalePurchaseView().setVisible(true);
    }

    // Main function
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
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.fatal("ClassNotFound. Exception: ", ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.fatal("Instantiation. Exception: ", ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.fatal("IllegalAccess. Exception: ", ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.fatal("UnsupportedLookAndFeel. Exception: ", ex);
        }
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ContactView().setVisible(true);
                log.debug("Open ContactView");
            }
        });
    }
}
