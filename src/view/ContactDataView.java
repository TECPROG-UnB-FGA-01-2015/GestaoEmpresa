/**********************************************************
 * File: ContactDataView.java
 * Purpose: Permits to add, edit and remove a contacts.
 *********************************************************/

package view;

import javax.swing.JOptionPane;

import static view.SalePurchaseView.purchaseSaleMode;
import static view.SalePurchaseView.salePurchaseStatus;
import controller.ClientController;
import controller.EmployeeController;
import controller.SupplierController;
import model.Address;
import model.Employee;
import model.JuridicalClient;
import model.JuridicalSupplier;
import model.PhysicalClient;
import model.PhysicalSupplier;

import org.apache.log4j.Logger;

public class ContactDataView extends javax.swing.JFrame
{
	// Describes the controller of clients
	static ClientController objectClientController = new ClientController();
	
	// Describes the controller of suppliers
	static SupplierController objectSupplierController = new SupplierController();
	
	// Describes the controller of employees
	static EmployeeController objectEmployeeController = new EmployeeController();
	
	EnterpriseManagement principal; // Describes the main view
	
	// Describes the model of physical client
	PhysicalClient objectPhysicalClient;
	
	// Describes the model of juridical client
	JuridicalClient objectJuridicalClient;
	
	// Describes the model of physical supplier
	PhysicalSupplier objectPhysicalSupplier;
	
	// Describes the model of juridical client
	JuridicalSupplier objectJuridicalSupplier;
	
	// Describes the model of employee
	Employee objectEmployee;
	
	// Describes the model of physical client to be edited
	PhysicalClient editPhysicalClient;
	
	// Describes the model of juridical client to be edited
	JuridicalClient editJuridicalClient;
	
	// Describes the model of physical supplier to be edited
	PhysicalSupplier editPhysicalSupplier;
	
	// Describes the model of juridical supplier to be edited
	JuridicalSupplier editJuridicalSupplier;
	
	// Describes the model of employee to be edited
	Employee editEmployee;
	
	static Logger log = Logger.getLogger(ContactDataView.class.getName());

	// Displays a warning message to the user
	public void showInfo(String info)
	{
		JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
	}

	// Constructor to initialize the ContactDataView
	public ContactDataView()
	{
		initComponents();
		jComboBox_TipoContato.setSelectedIndex(0);
		jLabel6.setVisible(false);
		jLabel7.setVisible(false);
		jTextField_Cargo.setVisible(false);
		jTextField_Salario.setVisible(false);
		cleanFields();
		populateFields();

		if(purchaseSaleMode == true)
		{
			if(SalePurchaseView.employeeMode == true)
			{
				jComboBox_TipoContato.setSelectedIndex(2);
			}
			else if(salePurchaseStatus == 0)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
			}
			else if(salePurchaseStatus == 1)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
			}
			else
			{
				jComboBox_TipoContato.setEnabled(false);
			}
		}

		else
		{
			if(ContactView.contactType == 0)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(0);
			}
			else if(ContactView.contactType == 1)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(1);
			}
			else if(ContactView.contactType == 2)
			{
				jComboBox_TipoContato.setSelectedIndex(2);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				jComboBox_TipoPessoa.setEnabled(false);
			}
			else
			{
				// Nothing to do
			}
		}

		jTextField_Nome.requestFocus();
		
		log.debug("Load ContactDataView");
	}

	// Populates text fields with customer information
	private void populateFields()
	{
		if(ContactView.editMode == true)
		{
			jComboBox_TipoContato.setEnabled(false);
			jComboBox_TipoPessoa.setEnabled(false);
			if(ContactView.newPhysicalClient == false)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editPhysicalClient = (PhysicalClient) objectClientController.searchClient(ContactView.tableName, false);
				jTextField_Nome.setText(editPhysicalClient.getName());
				jTextField_Telefone.setText(editPhysicalClient.getTelephone());
				jTextField_Celular.setText(editPhysicalClient.getCellphone());
				jTextField_CpfCnpj.setText(editPhysicalClient.getCpf());
				jTextField_RgRazaoSocial.setText(editPhysicalClient.getRg());
				jTextField_Pais.setText(editPhysicalClient.getAddress().getCountry());
				jTextField_Estado.setText(editPhysicalClient.getAddress().getState());
				jTextField_Cidade.setText(editPhysicalClient.getAddress().getCity());
				jTextField_Logradouro.setText(editPhysicalClient.getAddress().getStreet());
				jTextField_Complemento.setText(editPhysicalClient.getAddress().getComplement());
				jTextField_Numero.setText(editPhysicalClient.getAddress().getNumber());
			}
			else if(ContactView.newJuridicalClient == false)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(1);
				editJuridicalClient = (JuridicalClient) objectClientController.searchClient(ContactView.tableName, false);
				jTextField_Nome.setText(editJuridicalClient.getName());
				jTextField_Telefone.setText(editJuridicalClient.getTelephone());
				jTextField_Celular.setText(editJuridicalClient.getCellphone());
				jTextField_CpfCnpj.setText(editJuridicalClient.getCnpj());
				jTextField_RgRazaoSocial.setText(editJuridicalClient.getSocialReason());
				jTextField_Pais.setText(editJuridicalClient.getAddress().getCountry());
				jTextField_Estado.setText(editJuridicalClient.getAddress().getState());
				jTextField_Cidade.setText(editJuridicalClient.getAddress().getCity());
				jTextField_Logradouro.setText(editJuridicalClient.getAddress().getStreet());
				jTextField_Complemento.setText(editJuridicalClient.getAddress().getComplement());
				jTextField_Numero.setText(editJuridicalClient.getAddress().getNumber());
			}
			else if(ContactView.newPhysicalSupplier == false)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editPhysicalSupplier = (PhysicalSupplier) objectSupplierController.searchSupplier(ContactView.tableName, false);
				jTextField_Nome.setText(editPhysicalSupplier.getName());
				jTextField_Telefone.setText(editPhysicalSupplier.getTelephone());
				jTextField_Celular.setText(editPhysicalSupplier.getCellphone());
				jTextField_CpfCnpj.setText(editPhysicalSupplier.getCpf());
				jTextField_RgRazaoSocial.setText(editPhysicalSupplier.getRg());
				jTextField_Pais.setText(editPhysicalSupplier.getAddress().getCountry());
				jTextField_Estado.setText(editPhysicalSupplier.getAddress().getState());
				jTextField_Cidade.setText(editPhysicalSupplier.getAddress().getCity());
				jTextField_Logradouro.setText(editPhysicalSupplier.getAddress().getStreet());
				jTextField_Complemento.setText(editPhysicalSupplier.getAddress().getComplement());
				jTextField_Numero.setText(editPhysicalSupplier.getAddress().getNumber());
			}
			else if(ContactView.newJuridicalSupplier == false)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(1);
				editJuridicalSupplier = (JuridicalSupplier) objectSupplierController.searchSupplier(ContactView.tableName, false);
				jTextField_Nome.setText(editJuridicalSupplier.getName());
				jTextField_Telefone.setText(editJuridicalSupplier.getTelephone());
				jTextField_Celular.setText(editJuridicalSupplier.getCellphone());
				jTextField_CpfCnpj.setText(editJuridicalSupplier.getCnpj());
				jTextField_RgRazaoSocial.setText(editJuridicalSupplier.getSocialReason());
				jTextField_Pais.setText(editJuridicalSupplier.getAddress().getCountry());
				jTextField_Estado.setText(editJuridicalSupplier.getAddress().getState());
				jTextField_Cidade.setText(editJuridicalSupplier.getAddress().getCity());
				jTextField_Logradouro.setText(editJuridicalSupplier.getAddress().getStreet());
				jTextField_Complemento.setText(editJuridicalSupplier.getAddress().getComplement());
				jTextField_Numero.setText(editJuridicalSupplier.getAddress().getNumber());
			}
			else if(ContactView.newEmployee == false)
			{
				jComboBox_TipoContato.setSelectedIndex(2);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editEmployee = objectEmployeeController.searchEmployee(ContactView.tableName, false);
				jTextField_Nome.setText(editEmployee.getName());
				jTextField_Telefone.setText(editEmployee.getTelephone());
				jTextField_Celular.setText(editEmployee.getCellphone());
				jTextField_CpfCnpj.setText(editEmployee.getCpf());
				jTextField_RgRazaoSocial.setText(editEmployee.getRg());
				jTextField_Pais.setText(editEmployee.getAddress().getCountry());
				jTextField_Estado.setText(editEmployee.getAddress().getState());
				jTextField_Cidade.setText(editEmployee.getAddress().getCity());
				jTextField_Logradouro.setText(editEmployee.getAddress().getStreet());
				jTextField_Complemento.setText(editEmployee.getAddress().getComplement());
				jTextField_Numero.setText(editEmployee.getAddress().getNumber());
				jTextField_Cargo.setText(editEmployee.getRole());
				jTextField_Salario.setText(Double.toString(editEmployee.getSalary()));
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

	// Clears the text fields
	private void cleanFields()
	{
		jTextField_Nome.setText("");
		jTextField_Telefone.setText("");
		jTextField_Celular.setText("");
		jTextField_CpfCnpj.setText("");
		jTextField_RgRazaoSocial.setText("");
		jTextField_Logradouro.setText("");
		jTextField_Numero.setText("");
		jTextField_Cidade.setText("");
		jTextField_Estado.setText("");
		jTextField_Pais.setText("");
		jTextField_Complemento.setText("");
	}

	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField_Nome = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField_Telefone = new javax.swing.JTextField();
		jTextField_Celular = new javax.swing.JTextField();
		jTextField_CpfCnpj = new javax.swing.JTextField();
		jTextField_Cargo = new javax.swing.JTextField();
		jTextField_RgRazaoSocial = new javax.swing.JTextField();
		jTextField_Salario = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jComboBox_TipoContato = new javax.swing.JComboBox();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jTextField_Pais = new javax.swing.JTextField();
		jTextField_Estado = new javax.swing.JTextField();
		jTextField_Cidade = new javax.swing.JTextField();
		jTextField_Logradouro = new javax.swing.JTextField();
		jTextField_Complemento = new javax.swing.JTextField();
		jTextField_Numero = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jButton_Salvar = new javax.swing.JButton();
		jButton_Cancelar = new javax.swing.JButton();
		jComboBox_TipoPessoa = new javax.swing.JComboBox();
		jLabel8 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Novo Contato");
		setBounds(new java.awt.Rectangle(450, 300, 0, 0));

		jLabel1.setText("Nome:");

		jLabel2.setText("Telefone:");

		jTextField_Salario.setText("0.0");
		jTextField_Salario.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jTextField_SalarioActionPerformed(evt);				
			}
		});

		jLabel3.setText("Celular:");

		jLabel4.setText("CPF:");

		jLabel5.setText("RG:");

		jLabel6.setText("Cargo:");

		jLabel7.setText("Salário:");

		jComboBox_TipoContato.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Cliente", "Fornecedor", "Funcionário"}));
		jComboBox_TipoContato.addItemListener(new java.awt.event.ItemListener()
		{
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				try
				{
					jComboBox_TipoContatoItemStateChanged(evt);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		jLabel10.setText("Contato:");
		jLabel11.setText("País:");
		jLabel12.setText("Estado:");
		jLabel13.setText("Cidade:");
		jLabel14.setText("Logradouro:");
		jLabel15.setText("Complemento:");
		jLabel16.setText("Número:");

		jButton_Salvar.setText("Salvar");
		jButton_Salvar.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				try
				{
					jButton_SalvarActionPerformed(evt);
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

		jComboBox_TipoPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Pessoa Física", "Pessoa Jurídica"}));
		jComboBox_TipoPessoa.addItemListener(new java.awt.event.ItemListener()
		{
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				try
				{
					jComboBox_TipoPessoaItemStateChanged(evt);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});

		jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel8.setText("Novo Contato");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								jPanel1Layout.createSequentialGroup().addComponent(jButton_Cancelar).addGap(142, 142, 142).addComponent(jLabel8)).addGroup(
								jPanel1Layout.createSequentialGroup().addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(jLabel1).addComponent(jLabel3).addComponent(
												jLabel4).addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel9).addComponent(jLabel7)).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
												javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(
												jPanel1Layout.createSequentialGroup().addGroup(
														jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
																jPanel1Layout.createSequentialGroup().addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
																		javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
																		jLabel11)).addGroup(
																jPanel1Layout.createSequentialGroup().addComponent(jTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
																		javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
																		jLabel12)).addGroup(
																jPanel1Layout.createSequentialGroup().addComponent(jTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
																		javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
																		jLabel13)).addGroup(
																jPanel1Layout.createSequentialGroup().addComponent(jTextField_CpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
																		javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
																		jLabel14)).addGroup(
																jPanel1Layout.createSequentialGroup().addComponent(jTextField_RgRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 196,
																		javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
																		jLabel15)).addComponent(jTextField_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
																jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jTextField_Pais).addComponent(
																		jTextField_Estado).addComponent(jTextField_Cidade).addComponent(jTextField_Logradouro).addGroup(
																		jPanel1Layout.createSequentialGroup().addGroup(
																				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jButton_Salvar)
																						.addComponent(jTextField_Complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 121,
																								javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel16).addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField_Numero,
																				javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))))).addGroup(
								jPanel1Layout.createSequentialGroup().addComponent(jLabel10).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jComboBox_TipoContato,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jComboBox_TipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								jPanel1Layout.createSequentialGroup().addComponent(jButton_Cancelar).addGap(0, 0, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addGap(0, 10, Short.MAX_VALUE).addComponent(jLabel8))).addGap(19, 19, 19).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel10).addComponent(jComboBox_TipoContato,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jComboBox_TipoPessoa,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(22, 22, 22).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel11).addComponent(jTextField_Pais,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(jTextField_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jTextField_Estado, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel12)).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel3).addComponent(jTextField_Cidade,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel13)).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_CpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel4).addComponent(jTextField_Logradouro,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel14)).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_RgRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5).addComponent(jTextField_Complemento,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel15).addComponent(jLabel16)
								.addComponent(jTextField_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								jPanel1Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel6)).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_Salario, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel9)).addGroup(
								jPanel1Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(jButton_Salvar))).addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Method to enable the text fields according to the type of contact
	private void jComboBox_TipoContatoItemStateChanged(java.awt.event.ItemEvent evt) throws Exception
	{// GEN-FIRST:event_jComboBox_TipoContatoItemStateChanged
		try
		{
			// Selected contact type on ComboBox
			int selectedIndexContactTypeComboBox = jComboBox_TipoContato.getSelectedIndex();
			
			// String of selected contact type on ComboBox
			String selectedItemContactTypeComboBox = (String) jComboBox_TipoContato.getSelectedItem();
			
			if(selectedIndexContactTypeComboBox == 0f)
			{
				jLabel6.setVisible(false);
				jLabel7.setVisible(false);
				jTextField_Cargo.setVisible(false);
				jTextField_Salario.setVisible(false);
				jComboBox_TipoPessoa.setEnabled(true);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedItem("Pessoa Física");
				
				log.debug("Physical Person type to be added!");
			}
			else if(selectedItemContactTypeComboBox == "Fornecedor")
			{
				jLabel6.setVisible(false);
				jLabel7.setVisible(false);
				jTextField_Cargo.setVisible(false);
				jTextField_Salario.setVisible(false);
				jComboBox_TipoPessoa.setEnabled(true);
				jComboBox_TipoPessoa.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedItem("Pessoa Jurídica");
				
				log.debug("Supplier type to be added!");
			}
			else if(selectedItemContactTypeComboBox == "Funcionário")
			{
				jLabel4.setText("CPF:");
				jLabel5.setText("RG:");
				jLabel6.setVisible(true);
				jLabel7.setVisible(true);
				jTextField_Cargo.setVisible(true);
				jTextField_Salario.setVisible(true);
				jComboBox_TipoPessoa.setEnabled(false);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				
				log.debug("Employee type to be added!");
			}
			else
			{
				// Nothing to do
			}
		}
		catch (Exception e)
		{
			log.error("Error when selecting contact type. Exception: ", e);
			throw e;
		}
	}// GEN-LAST:event_jComboBox_TipoContatoItemStateChanged

	// Method to scan the information of text field and save on the customer object attributes
	private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_SalvarActionPerformed
		try
		{
			if(jTextField_Nome.getText().isEmpty() == true)
			{
				log.info("Contact name wasn't informed!");
				
				showInfo("Digite o name do Contato!");
			}
	
			else
			{		
				// Receives the name info of the view's text field 
				String name = jTextField_Nome.getText();
				
				// Receives the telephone info of the view's text field 
				String telephone = jTextField_Telefone.getText();
				
				// Receives the cellphone info of the view's text field 
				String cellphone = jTextField_Celular.getText();
				
				// Receives the cpf or cnpj info of the view's text field 
				String cpfCnpj = jTextField_CpfCnpj.getText();
				
				// Receives the rg or corporate name info of the view's text field 
				String rgSocialReason = jTextField_RgRazaoSocial.getText();
				
				// Receives the patio info of the view's text field 
				String patio = jTextField_Logradouro.getText();
				
				// Receives the number info of the view's text field 
				String number = jTextField_Numero.getText();
				
				// Receives the city info of the view's text field 
				String city = jTextField_Cidade.getText();
				
				// Receives the state info of the view's text field 
				String state = jTextField_Estado.getText();
				
				// Receives the country info of the view's text field 
				String country = jTextField_Pais.getText();
				
				// Receives the complement info of the view's text field 
				String complement = jTextField_Complemento.getText();
				
				// Receives the office info of the view's text field 
				String office = jTextField_Cargo.getText();
				
				// Receives the salary info of the view's text field 
				double salary = Double.parseDouble(jTextField_Salario.getText());
				
				// Object from the Address Class that  is instantiated to receives the information of the address
				Address objectAddress = new Address(patio, number, city, state, country, complement);
	
				if(ContactView.editMode == false)
				{
					// Selected contact type on ComboBox
					int selectedIndexContactTypeComboBox = jComboBox_TipoContato.getSelectedIndex();
					
					// Selected client type on ComboBox
					int selectedIndexClientTypeComboBox = jComboBox_TipoPessoa.getSelectedIndex();
					
					if(selectedIndexContactTypeComboBox == 0)
					{
						if(jComboBox_TipoPessoa.getSelectedIndex() == 0)
						{
							objectPhysicalClient = new PhysicalClient(cpfCnpj, rgSocialReason, name, objectAddress, telephone, cellphone);
							
							String namePhysicalClient = objectPhysicalClient.getName();
							
							if(objectClientController.searchClient(namePhysicalClient, false) == null)
							{
								objectClientController.addClient(objectPhysicalClient);
								
								log.info("Client " + namePhysicalClient + " added successfully!");
							}
							else
							{
								showInfo("Cliente já cadastrado!");
							}
						}
						else if(selectedIndexClientTypeComboBox == 1)
						{
							objectJuridicalClient = new JuridicalClient(cpfCnpj, rgSocialReason, name, objectAddress, telephone, cellphone);
							
							String nameJuridicalClient = objectJuridicalClient.getName();
							
							if(objectClientController.searchClient(nameJuridicalClient, false) == null)
							{
								objectClientController.addClient(objectJuridicalClient);
								
								log.info("Client " + nameJuridicalClient + " added successfully!");
							}
							else
							{
								showInfo("Cliente já cadastrado!");
							}
						}
						else
						{
							// Nothing to do
						}
					}
					else if(selectedIndexContactTypeComboBox == 1)
					{
						if(selectedIndexClientTypeComboBox == 0)
						{
							objectPhysicalSupplier = new PhysicalSupplier(cpfCnpj, rgSocialReason, name, telephone, cellphone, null, objectAddress);
	
							String namePhysicalSupplier = objectPhysicalSupplier.getName();
							
							if(objectSupplierController.searchSupplier(namePhysicalSupplier, false) == null)
							{
								objectSupplierController.addSupplier(objectPhysicalSupplier);
								
								log.info("Supplier " + namePhysicalSupplier + " added successfully!");
							}
							else
							{
								showInfo("Fornecedor já cadastrado!");
							}
						}
						else if(selectedIndexClientTypeComboBox == 1)
						{
							objectJuridicalSupplier = new JuridicalSupplier(cpfCnpj, rgSocialReason, name, telephone, cellphone, null, objectAddress);
	
							String nameJuridicalSupplier = objectJuridicalSupplier.getName();
							
							if(objectSupplierController.searchSupplier(nameJuridicalSupplier, false) == null)
							{
								objectSupplierController.addSupplier(objectJuridicalSupplier);
								
								log.info("Supplier " + nameJuridicalSupplier + " added successfully!");
							}
							else
							{
								showInfo("Fornecedor já cadastrado!");
							}
						}
						else
						{
							// Nothing to do
						}
					}
					else if(selectedIndexContactTypeComboBox == 2)
					{
						objectEmployee = new Employee(name, telephone, cellphone, cpfCnpj, rgSocialReason, office, salary, objectAddress);
	
						String nameEmployee = objectEmployee.getName();
						
						if(objectEmployeeController.searchEmployee(nameEmployee, false) == null)
						{
							objectEmployeeController.addEmployee(objectEmployee);
							
							log.info("Employee " + nameEmployee + " added successfully!");
						}
						else
						{
							showInfo("Funcionário já cadastrado!");
						}
					}
					else
					{
						// Nothing to do
					}
				}
				else if(ContactView.editMode == true)
				{
	
					if(ContactView.newPhysicalClient == false)
					{
						// Result of editPhysicalClient name and jTextField_Nome text comparison
						boolean namePhyicalClientEquals = editPhysicalClient.getName().equals(jTextField_Nome.getText());
						
						if(!namePhyicalClientEquals)
						{
							showInfo("Não é permitido a alteração do name!");
						}
						else
						{
							jComboBox_TipoContato.setSelectedIndex(0);
							jComboBox_TipoPessoa.setSelectedIndex(0);
							editPhysicalClient.getAddress().setStreet(patio);
							editPhysicalClient.getAddress().setCountry(country);
							editPhysicalClient.getAddress().setState(state);
							editPhysicalClient.getAddress().setCity(city);
							editPhysicalClient.getAddress().setComplement(complement);
							editPhysicalClient.getAddress().setNumber(number);
							editPhysicalClient.setName(name);
							editPhysicalClient.setTelephone(telephone);
							editPhysicalClient.setCellphone(cellphone);
							editPhysicalClient.setCpf(cpfCnpj);
							editPhysicalClient.setRg(rgSocialReason);
							editPhysicalClient.setAddress(objectAddress);
						}
					}
					else if(ContactView.newJuridicalClient == false)
					{
						// Result of editJuridicalClient name and jTextField_Nome text comparison
						boolean nameJuridicalClientEquals = editJuridicalClient.getName().equals(jTextField_Nome.getText());
						
						if(!nameJuridicalClientEquals)
						{
							showInfo("Não é permitido a alteração do name!");
						}
						else
						{
							jComboBox_TipoContato.setSelectedIndex(0);
							jComboBox_TipoPessoa.setSelectedIndex(1);
							editJuridicalClient.getAddress().setStreet(patio);
							editJuridicalClient.getAddress().setCountry(country);
							editJuridicalClient.getAddress().setState(state);
							editJuridicalClient.getAddress().setCity(city);
							editJuridicalClient.getAddress().setComplement(complement);
							editJuridicalClient.getAddress().setNumber(number);
							editJuridicalClient.setName(name);
							editJuridicalClient.setTelephone(telephone);
							editJuridicalClient.setCellphone(cellphone);
							editJuridicalClient.setCnpj(cpfCnpj);
							editJuridicalClient.setSocialReason(rgSocialReason);
							editJuridicalClient.setAddress(objectAddress);
						}
					}
					else if(ContactView.newPhysicalSupplier == false)
					{
						// Result of editPhysicalSupplier name and jTextField_Nome text comparison
						boolean namePhysicalSupplierEquals = editPhysicalSupplier.getName().equals(jTextField_Nome.getText()); 
						
						if(!namePhysicalSupplierEquals)
						{
							showInfo("Não é permitido a alteração do name!");
						}
						else
						{
							jComboBox_TipoContato.setSelectedIndex(1);
							jComboBox_TipoPessoa.setSelectedIndex(0);
							editPhysicalSupplier.getAddress().setStreet(patio);
							editPhysicalSupplier.getAddress().setCountry(country);
							editPhysicalSupplier.getAddress().setState(state);
							editPhysicalSupplier.getAddress().setCity(city);
							editPhysicalSupplier.getAddress().setComplement(complement);
							editPhysicalSupplier.getAddress().setNumber(number);
							editPhysicalSupplier.setName(name);
							editPhysicalSupplier.setTelephone(telephone);
							editPhysicalSupplier.setCellphone(cellphone);
							editPhysicalSupplier.setCpf(cpfCnpj);
							editPhysicalSupplier.setRg(rgSocialReason);
							editPhysicalSupplier.setAddress(objectAddress);
						}
					}
					else if(ContactView.newJuridicalSupplier == false)
					{
						// Result of editJuridicalSupplier name and jTextField_Nome text comparison
						boolean nameJuridicalSupplierEquals = editJuridicalSupplier.getName().equals(jTextField_Nome.getText()); 
						
						if(!nameJuridicalSupplierEquals)
						{
							showInfo("Não é permitido a alteração do name!");
						}
						else
						{
							jComboBox_TipoContato.setSelectedIndex(1);
							jComboBox_TipoPessoa.setSelectedIndex(1);
							editJuridicalSupplier.getAddress().setStreet(patio);
							editJuridicalSupplier.getAddress().setCountry(country);
							editJuridicalSupplier.getAddress().setState(state);
							editJuridicalSupplier.getAddress().setCity(city);
							editJuridicalSupplier.getAddress().setComplement(complement);
							editJuridicalSupplier.getAddress().setNumber(number);
							editJuridicalSupplier.setName(name);
							editJuridicalSupplier.setTelephone(telephone);
							editJuridicalSupplier.setCellphone(cellphone);
							editJuridicalSupplier.setCnpj(cpfCnpj);
							editJuridicalSupplier.setSocialReason(rgSocialReason);
							editJuridicalSupplier.setAddress(objectAddress);
						}
					}
					else if(ContactView.newEmployee == false)
					{
						// Result of editEmployee name and jTextField_Nome text comparison
						boolean nameEmployeeEquals = editEmployee.getName().equals(jTextField_Nome.getText()); 
						if(!nameEmployeeEquals)
						{
							showInfo("Não é permitido a alteração do name!");
						}
						else
						{
							jComboBox_TipoContato.setSelectedIndex(1);
							jComboBox_TipoPessoa.setSelectedIndex(0);
							editEmployee.getAddress().setStreet(patio);
							editEmployee.getAddress().setCountry(country);
							editEmployee.getAddress().setState(state);
							editEmployee.getAddress().setCity(city);
							editEmployee.getAddress().setComplement(complement);
							editEmployee.getAddress().setNumber(number);
							editEmployee.setName(name);
							editEmployee.setTelephone(telephone);
							editEmployee.setCellphone(cellphone);
							editEmployee.setCpf(cpfCnpj);
							editEmployee.setRg(rgSocialReason);
							editEmployee.setAddress(objectAddress);
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
				
				ContactView.editMode = false;
				ContactView.newPhysicalClient = true;
				ContactView.newJuridicalClient = true;
				ContactView.newPhysicalSupplier = true;
				ContactView.newJuridicalSupplier = true;
				ContactView.newEmployee = true;
				
				log.info("Save contact operation finalized successfully!");
				
				new ContactView().setVisible(true);
				
				log.debug("Exit SalePurchaseView");
				this.dispose();
			}
		}
		catch (Exception e)
		{
			log.error("Error when saving contact. Exception: ", e);
			throw e;
		}
	}// GEN-LAST:event_jButton_SalvarActionPerformed

	// Method to cancel the operation and close the screen
	private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) throws Exception
	{// GEN-FIRST:event_jButton_CancelarActionPerformed
		try
		{
			new ContactView().setVisible(true);
			this.dispose();
		}
		catch (Exception e)
		{
			log.error("Error when canceling the action of add a contact. Exception: ", e);
			throw e;
		}
	}// GEN-LAST:event_jButton_CancelarActionPerformed

	// Method to enable the text fields according to the type of person
	private void jComboBox_TipoPessoaItemStateChanged(java.awt.event.ItemEvent evt) throws Exception
	{// GEN-FIRST:event_jComboBox_TipoPessoaItemStateChanged
		try
		{
			// String of selected client type on ComboBox
			String selectedClientTypeComboBoxString = (String) jComboBox_TipoPessoa.getSelectedItem();
			
			if(selectedClientTypeComboBoxString == "Pessoa Física")
			{
				jLabel4.setText("CPF:");
				jLabel5.setText("RG:");
			}
			else if(selectedClientTypeComboBoxString == "Pessoa Jurídica")
			{
				jLabel4.setText("CNPJ:");
				jLabel5.setText("Razão Social:");
			}
			else
			{
				// Nothing to do
			}
		}
		catch (Exception e)
		{
			log.error("Error when selecting the person type. Exception: ", e);
			throw e;
		}
	}// GEN-LAST:event_jComboBox_TipoPessoaItemStateChanged

	private void jTextField_SalarioActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jTextField_SalarioActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField_SalarioActionPerformed

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
			java.util.logging.Logger.getLogger(ContactDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(ContactDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(ContactDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(ContactDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new ContactDataView().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton_Cancelar;
	private javax.swing.JButton jButton_Salvar;
	private javax.swing.JComboBox jComboBox_TipoContato;
	private javax.swing.JComboBox jComboBox_TipoPessoa;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField_Cargo;
	private javax.swing.JTextField jTextField_Celular;
	private javax.swing.JTextField jTextField_Cidade;
	private javax.swing.JTextField jTextField_Complemento;
	private javax.swing.JTextField jTextField_CpfCnpj;
	private javax.swing.JTextField jTextField_Estado;
	private javax.swing.JTextField jTextField_Logradouro;
	private javax.swing.JTextField jTextField_Nome;
	private javax.swing.JTextField jTextField_Numero;
	private javax.swing.JTextField jTextField_Pais;
	private javax.swing.JTextField jTextField_RgRazaoSocial;
	private javax.swing.JTextField jTextField_Salario;
	private javax.swing.JTextField jTextField_Telefone;
	// End of variables declaration//GEN-END:variables
}
