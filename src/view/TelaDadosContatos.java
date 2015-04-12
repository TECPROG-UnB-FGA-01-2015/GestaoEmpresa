/**********************************************************
 * File: TelaDadosContatos.java
 * Purpose: Permits to add, edit and remove a contacts.
 *********************************************************/

package view;

import controller.ControleCliente;
import controller.ControleFornecedor;
import controller.ControleFuncionario;
import javax.swing.JOptionPane;
import model.ClienteFisico;
import model.ClienteJuridico;
import model.Endereco;
import model.FornecedorFisico;
import model.FornecedorJuridico;
import model.Funcionario;
import static view.SalePurchaseView.clientSupplierMode;
import static view.SalePurchaseView.employeeMode;
import static view.SalePurchaseView.purchaseSaleMode;
import static view.SalePurchaseView.salePurchaseStatus;

public class TelaDadosContatos extends javax.swing.JFrame
{

	static ControleCliente umControleCliente = new ControleCliente();
	static ControleFornecedor umControleFornecedor = new ControleFornecedor();
	static ControleFuncionario umControleFuncionario = new ControleFuncionario();
	GestaoEmpresa principal;
	ClienteFisico umClienteFisico;
	ClienteJuridico umClienteJuridico;
	FornecedorFisico umFornecedorFisico;
	FornecedorJuridico umFornecedorJuridico;
	Funcionario umFuncionario;
	ClienteFisico editClienteFisico;
	ClienteJuridico editClienteJuridico;
	FornecedorFisico editFornecedorFisico;
	FornecedorJuridico editFornecedorJuridico;
	Funcionario editFuncionario;

	// Method to display a warning message to the user
	public void exibirInformacao(String info)
	{
		JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
	}

	// Constructor to initialize components on TelaDadosContatos
	public TelaDadosContatos()
	{
		initComponents();
		jComboBox_TipoContato.setSelectedIndex(0);
		jLabel6.setVisible(false);
		jLabel7.setVisible(false);
		jTextField_Cargo.setVisible(false);
		jTextField_Salario.setVisible(false);
		limparCampos();
		preencherCampos();

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
			if(TelaContatos.contactType == 0)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(0);
			}
			else if(TelaContatos.contactType == 1)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(1);
			}
			else if(TelaContatos.contactType == 2)
			{
				jComboBox_TipoContato.setSelectedIndex(2);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				jComboBox_TipoPessoa.setEnabled(false);
			}
		}

		jTextField_Nome.requestFocus();
	}

	// Method to populate text fields with customer information
	private void preencherCampos()
	{
		if(TelaContatos.editMode == true)
		{
			jComboBox_TipoContato.setEnabled(false);
			jComboBox_TipoPessoa.setEnabled(false);
			if(TelaContatos.newPhysicalClient == false)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editClienteFisico = (ClienteFisico) umControleCliente.pesquisarCliente(TelaContatos.tableName, false);
				jTextField_Nome.setText(editClienteFisico.getName());
				jTextField_Telefone.setText(editClienteFisico.getTelephone());
				jTextField_Celular.setText(editClienteFisico.getCellphone());
				jTextField_CpfCnpj.setText(editClienteFisico.getCpf());
				jTextField_RgRazaoSocial.setText(editClienteFisico.getRg());
				jTextField_Pais.setText(editClienteFisico.getAddress().getCountry());
				jTextField_Estado.setText(editClienteFisico.getAddress().getState());
				jTextField_Cidade.setText(editClienteFisico.getAddress().getCity());
				jTextField_Logradouro.setText(editClienteFisico.getAddress().getStreet());
				jTextField_Complemento.setText(editClienteFisico.getAddress().getComplement());
				jTextField_Numero.setText(editClienteFisico.getAddress().getNumber());
			}
			else if(TelaContatos.newJuridicalClient == false)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(1);
				editClienteJuridico = (ClienteJuridico) umControleCliente.pesquisarCliente(TelaContatos.tableName, false);
				jTextField_Nome.setText(editClienteJuridico.getName());
				jTextField_Telefone.setText(editClienteJuridico.getTelephone());
				jTextField_Celular.setText(editClienteJuridico.getCellphone());
				jTextField_CpfCnpj.setText(editClienteJuridico.getCnpj());
				jTextField_RgRazaoSocial.setText(editClienteJuridico.getSocialReason());
				jTextField_Pais.setText(editClienteJuridico.getAddress().getCountry());
				jTextField_Estado.setText(editClienteJuridico.getAddress().getState());
				jTextField_Cidade.setText(editClienteJuridico.getAddress().getCity());
				jTextField_Logradouro.setText(editClienteJuridico.getAddress().getStreet());
				jTextField_Complemento.setText(editClienteJuridico.getAddress().getComplement());
				jTextField_Numero.setText(editClienteJuridico.getAddress().getNumber());
			}
			else if(TelaContatos.newPhysicalSupplier == false)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editFornecedorFisico = (FornecedorFisico) umControleFornecedor.pesquisarFornecedor(TelaContatos.tableName, false);
				jTextField_Nome.setText(editFornecedorFisico.getNome());
				jTextField_Telefone.setText(editFornecedorFisico.getTelefone());
				jTextField_Celular.setText(editFornecedorFisico.getCelular());
				jTextField_CpfCnpj.setText(editFornecedorFisico.getCpf());
				jTextField_RgRazaoSocial.setText(editFornecedorFisico.getRg());
				jTextField_Pais.setText(editFornecedorFisico.getEndereco().getCountry());
				jTextField_Estado.setText(editFornecedorFisico.getEndereco().getState());
				jTextField_Cidade.setText(editFornecedorFisico.getEndereco().getCity());
				jTextField_Logradouro.setText(editFornecedorFisico.getEndereco().getStreet());
				jTextField_Complemento.setText(editFornecedorFisico.getEndereco().getComplement());
				jTextField_Numero.setText(editFornecedorFisico.getEndereco().getNumber());
			}
			else if(TelaContatos.newJuridicalSupplier == false)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(1);
				editFornecedorJuridico = (FornecedorJuridico) umControleFornecedor.pesquisarFornecedor(TelaContatos.tableName, false);
				jTextField_Nome.setText(editFornecedorJuridico.getNome());
				jTextField_Telefone.setText(editFornecedorJuridico.getTelefone());
				jTextField_Celular.setText(editFornecedorJuridico.getCelular());
				jTextField_CpfCnpj.setText(editFornecedorJuridico.getCnpj());
				jTextField_RgRazaoSocial.setText(editFornecedorJuridico.getRazaoSocial());
				jTextField_Pais.setText(editFornecedorJuridico.getEndereco().getCountry());
				jTextField_Estado.setText(editFornecedorJuridico.getEndereco().getState());
				jTextField_Cidade.setText(editFornecedorJuridico.getEndereco().getCity());
				jTextField_Logradouro.setText(editFornecedorJuridico.getEndereco().getStreet());
				jTextField_Complemento.setText(editFornecedorJuridico.getEndereco().getComplement());
				jTextField_Numero.setText(editFornecedorJuridico.getEndereco().getNumber());
			}
			else if(TelaContatos.newEmployee == false)
			{
				jComboBox_TipoContato.setSelectedIndex(2);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editFuncionario = umControleFuncionario.pesquisarFuncionario(TelaContatos.tableName, false);
				jTextField_Nome.setText(editFuncionario.getName());
				jTextField_Telefone.setText(editFuncionario.getTelephone());
				jTextField_Celular.setText(editFuncionario.getCellphone());
				jTextField_CpfCnpj.setText(editFuncionario.getCpf());
				jTextField_RgRazaoSocial.setText(editFuncionario.getRg());
				jTextField_Pais.setText(editFuncionario.getAddress().getCountry());
				jTextField_Estado.setText(editFuncionario.getAddress().getState());
				jTextField_Cidade.setText(editFuncionario.getAddress().getCity());
				jTextField_Logradouro.setText(editFuncionario.getAddress().getStreet());
				jTextField_Complemento.setText(editFuncionario.getAddress().getComplement());
				jTextField_Numero.setText(editFuncionario.getAddress().getNumber());
				jTextField_Cargo.setText(editFuncionario.getRole());
				jTextField_Salario.setText(Double.toString(editFuncionario.getSalary()));
			}
		}
	}

	// Method to clear the text fields
	private void limparCampos()
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

	@SuppressWarnings("unchecked")
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
				jComboBox_TipoContatoItemStateChanged(evt);
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
				jButton_SalvarActionPerformed(evt);
			}
		});

		jButton_Cancelar.setText("Sair");
		jButton_Cancelar.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton_CancelarActionPerformed(evt);
			}
		});

		jComboBox_TipoPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Pessoa Física", "Pessoa Jurídica"}));
		jComboBox_TipoPessoa.addItemListener(new java.awt.event.ItemListener()
		{
			public void itemStateChanged(java.awt.event.ItemEvent evt)
			{
				jComboBox_TipoPessoaItemStateChanged(evt);
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
	private void jComboBox_TipoContatoItemStateChanged(java.awt.event.ItemEvent evt)
	{// GEN-FIRST:event_jComboBox_TipoContatoItemStateChanged
		if(jComboBox_TipoContato.getSelectedIndex() == 0f)
		{
			jLabel6.setVisible(false);
			jLabel7.setVisible(false);
			jTextField_Cargo.setVisible(false);
			jTextField_Salario.setVisible(false);
			jComboBox_TipoPessoa.setEnabled(true);
			jComboBox_TipoPessoa.setSelectedIndex(0);
			jComboBox_TipoPessoa.setSelectedItem("Pessoa Física");
		}
		else if(jComboBox_TipoContato.getSelectedItem() == "Fornecedor")
		{
			jLabel6.setVisible(false);
			jLabel7.setVisible(false);
			jTextField_Cargo.setVisible(false);
			jTextField_Salario.setVisible(false);
			jComboBox_TipoPessoa.setEnabled(true);
			jComboBox_TipoPessoa.setSelectedIndex(1);
			jComboBox_TipoPessoa.setSelectedItem("Pessoa Jurídica");
		}
		else if(jComboBox_TipoContato.getSelectedItem() == "Funcionário")
		{
			jLabel4.setText("CPF:");
			jLabel5.setText("RG:");
			jLabel6.setVisible(true);
			jLabel7.setVisible(true);
			jTextField_Cargo.setVisible(true);
			jTextField_Salario.setVisible(true);
			jComboBox_TipoPessoa.setEnabled(false);
			jComboBox_TipoPessoa.setSelectedIndex(0);
		}
	}// GEN-LAST:event_jComboBox_TipoContatoItemStateChanged

	// Method to scan the information of text field and save on the customer object attributes
	private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButton_SalvarActionPerformed
		if(jTextField_Nome.getText().isEmpty() == true)
		{
			exibirInformacao("Digite o nome do Contato!");
		}

		else
		{
			String nome = jTextField_Nome.getText();
			String telefone = jTextField_Telefone.getText();
			String celular = jTextField_Celular.getText();
			String cpfcnpj = jTextField_CpfCnpj.getText();
			String rgrazaosocial = jTextField_RgRazaoSocial.getText();
			String logradouro = jTextField_Logradouro.getText();
			String numero = jTextField_Numero.getText();
			String cidade = jTextField_Cidade.getText();
			String estado = jTextField_Estado.getText();
			String pais = jTextField_Pais.getText();
			String complemento = jTextField_Complemento.getText();
			String cargo = jTextField_Cargo.getText();
			double salario = Double.parseDouble(jTextField_Salario.getText());
			Endereco umEndereco = new Endereco(logradouro, numero, cidade, estado, pais, complemento);

			if(TelaContatos.editMode == false)
			{
				if(jComboBox_TipoContato.getSelectedIndex() == 0)
				{
					if(jComboBox_TipoPessoa.getSelectedIndex() == 0)
					{
						umClienteFisico = new ClienteFisico(cpfcnpj, rgrazaosocial, nome, umEndereco, telefone, celular);
						if(umControleCliente.pesquisarCliente(umClienteFisico.getName(), false) == null)
							umControleCliente.addCliente(umClienteFisico);
						else
							exibirInformacao("Cliente já cadastrado!");
					}
					else if(jComboBox_TipoPessoa.getSelectedIndex() == 1)
					{
						umClienteJuridico = new ClienteJuridico(cpfcnpj, rgrazaosocial, nome, umEndereco, telefone, celular);
						if(umControleCliente.pesquisarCliente(umClienteJuridico.getName(), false) == null)
							umControleCliente.addCliente(umClienteJuridico);
						else
							exibirInformacao("Cliente já cadastrado!");
					}
				}
				else if(jComboBox_TipoContato.getSelectedIndex() == 1)
				{
					if(jComboBox_TipoPessoa.getSelectedIndex() == 0)
					{
						umFornecedorFisico = new FornecedorFisico(cpfcnpj, rgrazaosocial, nome, telefone, celular, null, umEndereco);
						if(umControleFornecedor.pesquisarFornecedor(umFornecedorFisico.getNome(), false) == null)
							umControleFornecedor.adicionarFornecedor(umFornecedorFisico);
						else
							exibirInformacao("Fornecedor já cadastrado!");
					}
					else if(jComboBox_TipoPessoa.getSelectedIndex() == 1)
					{
						umFornecedorJuridico = new FornecedorJuridico(cpfcnpj, rgrazaosocial, nome, telefone, celular, null, umEndereco);
						if(umControleFornecedor.pesquisarFornecedor(umFornecedorJuridico.getNome(), false) == null)
							umControleFornecedor.adicionarFornecedor(umFornecedorJuridico);
						else
							exibirInformacao("Fornecedor já cadastrado!");
					}
				}
				else if(jComboBox_TipoContato.getSelectedIndex() == 2)
				{
					umFuncionario = new Funcionario(nome, telefone, celular, cpfcnpj, rgrazaosocial, cargo, salario, umEndereco);
					if(umControleFuncionario.pesquisarFuncionario(umFuncionario.getName(), false) == null)
						umControleFuncionario.addFuncionario(umFuncionario);
					else
						exibirInformacao("Funcionário já cadastrado!");
				}
			}
			else if(TelaContatos.editMode == true)
			{

				if(TelaContatos.newPhysicalClient == false)
				{
					if(!editClienteFisico.getName().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(0);
						jComboBox_TipoPessoa.setSelectedIndex(0);
						editClienteFisico.getAddress().setStreet(logradouro);
						editClienteFisico.getAddress().setCountry(pais);
						editClienteFisico.getAddress().setState(estado);
						editClienteFisico.getAddress().setCity(cidade);
						editClienteFisico.getAddress().setComplement(complemento);
						editClienteFisico.getAddress().setNumber(numero);
						editClienteFisico.setName(nome);
						editClienteFisico.setTelephone(telefone);
						editClienteFisico.setCellphone(celular);
						editClienteFisico.setCpf(cpfcnpj);
						editClienteFisico.setRg(rgrazaosocial);
						editClienteFisico.setAddress(umEndereco);
					}
				}
				else if(TelaContatos.newJuridicalClient == false)
				{
					if(!editClienteJuridico.getName().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(0);
						jComboBox_TipoPessoa.setSelectedIndex(1);
						editClienteJuridico.getAddress().setStreet(logradouro);
						editClienteJuridico.getAddress().setCountry(pais);
						editClienteJuridico.getAddress().setState(estado);
						editClienteJuridico.getAddress().setCity(cidade);
						editClienteJuridico.getAddress().setComplement(complemento);
						editClienteJuridico.getAddress().setNumber(numero);
						editClienteJuridico.setName(nome);
						editClienteJuridico.setTelephone(telefone);
						editClienteJuridico.setCellphone(celular);
						editClienteJuridico.setCnpj(cpfcnpj);
						editClienteJuridico.setSocialReason(rgrazaosocial);
						editClienteJuridico.setAddress(umEndereco);
					}
				}
				else if(TelaContatos.newPhysicalSupplier == false)
				{
					if(!editFornecedorFisico.getNome().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(1);
						jComboBox_TipoPessoa.setSelectedIndex(0);
						editFornecedorFisico.getEndereco().setStreet(logradouro);
						editFornecedorFisico.getEndereco().setCountry(pais);
						editFornecedorFisico.getEndereco().setState(estado);
						editFornecedorFisico.getEndereco().setCity(cidade);
						editFornecedorFisico.getEndereco().setComplement(complemento);
						editFornecedorFisico.getEndereco().setNumber(numero);
						editFornecedorFisico.setNome(nome);
						editFornecedorFisico.setTelefone(telefone);
						editFornecedorFisico.setCelular(celular);
						editFornecedorFisico.setCpf(cpfcnpj);
						editFornecedorFisico.setRg(rgrazaosocial);
						editFornecedorFisico.setEndereco(umEndereco);
					}
				}
				else if(TelaContatos.newJuridicalSupplier == false)
				{
					if(!editFornecedorJuridico.getNome().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(1);
						jComboBox_TipoPessoa.setSelectedIndex(1);
						editFornecedorJuridico.getEndereco().setStreet(logradouro);
						editFornecedorJuridico.getEndereco().setCountry(pais);
						editFornecedorJuridico.getEndereco().setState(estado);
						editFornecedorJuridico.getEndereco().setCity(cidade);
						editFornecedorJuridico.getEndereco().setComplement(complemento);
						editFornecedorJuridico.getEndereco().setNumber(numero);
						editFornecedorJuridico.setNome(nome);
						editFornecedorJuridico.setTelefone(telefone);
						editFornecedorJuridico.setCelular(celular);
						editFornecedorJuridico.setCnpj(cpfcnpj);
						editFornecedorJuridico.setRazaoSocial(rgrazaosocial);
						editFornecedorJuridico.setEndereco(umEndereco);
					}
				}
				else if(TelaContatos.newEmployee == false)
				{
					if(!editFuncionario.getName().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(1);
						jComboBox_TipoPessoa.setSelectedIndex(0);
						editFuncionario.getAddress().setStreet(logradouro);
						editFuncionario.getAddress().setCountry(pais);
						editFuncionario.getAddress().setState(estado);
						editFuncionario.getAddress().setCity(cidade);
						editFuncionario.getAddress().setComplement(complemento);
						editFuncionario.getAddress().setNumber(numero);
						editFuncionario.setName(nome);
						editFuncionario.setTelephone(telefone);
						editFuncionario.setCellphone(celular);
						editFuncionario.setCpf(cpfcnpj);
						editFuncionario.setRg(rgrazaosocial);
						editFuncionario.setAddress(umEndereco);
					}
				}
			}
			TelaContatos.editMode = false;
			TelaContatos.newPhysicalClient = true;
			TelaContatos.newJuridicalClient = true;
			TelaContatos.newPhysicalSupplier = true;
			TelaContatos.newJuridicalSupplier = true;
			TelaContatos.newEmployee = true;

			new TelaContatos().setVisible(true);
			this.dispose();
		}

	}// GEN-LAST:event_jButton_SalvarActionPerformed

	// Method to cancel the operation and close the screen
	private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt)
	{// GEN-FIRST:event_jButton_CancelarActionPerformed
		new TelaContatos().setVisible(true);
		this.dispose();
	}// GEN-LAST:event_jButton_CancelarActionPerformed

	// Method to enable the text fields according to the type of person
	private void jComboBox_TipoPessoaItemStateChanged(java.awt.event.ItemEvent evt)
	{// GEN-FIRST:event_jComboBox_TipoPessoaItemStateChanged
		if(jComboBox_TipoPessoa.getSelectedItem() == "Pessoa Física")
		{
			jLabel4.setText("CPF:");
			jLabel5.setText("RG:");
		}
		else if(jComboBox_TipoPessoa.getSelectedItem() == "Pessoa Jurídica")
		{
			jLabel4.setText("CNPJ:");
			jLabel5.setText("Razão Social:");
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
			}
		}
		catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(TelaDadosContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(TelaDadosContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(TelaDadosContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(TelaDadosContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new TelaDadosContatos().setVisible(true);
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
