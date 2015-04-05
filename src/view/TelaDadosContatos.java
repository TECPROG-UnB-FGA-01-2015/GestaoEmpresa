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
import static view.TelaVendaCompra.modoClienteFornecedor;
import static view.TelaVendaCompra.modoFuncionario;
import static view.TelaVendaCompra.modoVendaCompra;
import static view.TelaVendaCompra.statusVendaCompra;

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

		if(modoVendaCompra == true)
		{
			if(TelaVendaCompra.modoFuncionario == true)
			{
				jComboBox_TipoContato.setSelectedIndex(2);
			}
			else if(statusVendaCompra == 0)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
			}
			else if(statusVendaCompra == 1)
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
			if(TelaContatos.tipoContato == 0)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(0);
			}
			else if(TelaContatos.tipoContato == 1)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(1);
			}
			else if(TelaContatos.tipoContato == 2)
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
		if(TelaContatos.modoEditar == true)
		{
			jComboBox_TipoContato.setEnabled(false);
			jComboBox_TipoPessoa.setEnabled(false);
			if(TelaContatos.novoClienteFisico == false)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editClienteFisico = (ClienteFisico) umControleCliente.pesquisarCliente(TelaContatos.nomeTabela, false);
				jTextField_Nome.setText(editClienteFisico.getNome());
				jTextField_Telefone.setText(editClienteFisico.getTelefone());
				jTextField_Celular.setText(editClienteFisico.getCelular());
				jTextField_CpfCnpj.setText(editClienteFisico.getCpf());
				jTextField_RgRazaoSocial.setText(editClienteFisico.getRg());
				jTextField_Pais.setText(editClienteFisico.getEndereco().getPais());
				jTextField_Estado.setText(editClienteFisico.getEndereco().getEstado());
				jTextField_Cidade.setText(editClienteFisico.getEndereco().getCidade());
				jTextField_Logradouro.setText(editClienteFisico.getEndereco().getLogradouro());
				jTextField_Complemento.setText(editClienteFisico.getEndereco().getComplemento());
				jTextField_Numero.setText(editClienteFisico.getEndereco().getNumero());
			}
			else if(TelaContatos.novoClienteJuridico == false)
			{
				jComboBox_TipoContato.setSelectedIndex(0);
				jComboBox_TipoPessoa.setSelectedIndex(1);
				editClienteJuridico = (ClienteJuridico) umControleCliente.pesquisarCliente(TelaContatos.nomeTabela, false);
				jTextField_Nome.setText(editClienteJuridico.getNome());
				jTextField_Telefone.setText(editClienteJuridico.getTelefone());
				jTextField_Celular.setText(editClienteJuridico.getCelular());
				jTextField_CpfCnpj.setText(editClienteJuridico.getCnpj());
				jTextField_RgRazaoSocial.setText(editClienteJuridico.getRazaoSocial());
				jTextField_Pais.setText(editClienteJuridico.getEndereco().getPais());
				jTextField_Estado.setText(editClienteJuridico.getEndereco().getEstado());
				jTextField_Cidade.setText(editClienteJuridico.getEndereco().getCidade());
				jTextField_Logradouro.setText(editClienteJuridico.getEndereco().getLogradouro());
				jTextField_Complemento.setText(editClienteJuridico.getEndereco().getComplemento());
				jTextField_Numero.setText(editClienteJuridico.getEndereco().getNumero());
			}
			else if(TelaContatos.novoFornecedorFisico == false)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editFornecedorFisico = (FornecedorFisico) umControleFornecedor.pesquisarFornecedor(TelaContatos.nomeTabela, false);
				jTextField_Nome.setText(editFornecedorFisico.getNome());
				jTextField_Telefone.setText(editFornecedorFisico.getTelefone());
				jTextField_Celular.setText(editFornecedorFisico.getCelular());
				jTextField_CpfCnpj.setText(editFornecedorFisico.getCpf());
				jTextField_RgRazaoSocial.setText(editFornecedorFisico.getRg());
				jTextField_Pais.setText(editFornecedorFisico.getEndereco().getPais());
				jTextField_Estado.setText(editFornecedorFisico.getEndereco().getEstado());
				jTextField_Cidade.setText(editFornecedorFisico.getEndereco().getCidade());
				jTextField_Logradouro.setText(editFornecedorFisico.getEndereco().getLogradouro());
				jTextField_Complemento.setText(editFornecedorFisico.getEndereco().getComplemento());
				jTextField_Numero.setText(editFornecedorFisico.getEndereco().getNumero());
			}
			else if(TelaContatos.novoFornecedorJuridico == false)
			{
				jComboBox_TipoContato.setSelectedIndex(1);
				jComboBox_TipoPessoa.setSelectedIndex(1);
				editFornecedorJuridico = (FornecedorJuridico) umControleFornecedor.pesquisarFornecedor(TelaContatos.nomeTabela, false);
				jTextField_Nome.setText(editFornecedorJuridico.getNome());
				jTextField_Telefone.setText(editFornecedorJuridico.getTelefone());
				jTextField_Celular.setText(editFornecedorJuridico.getCelular());
				jTextField_CpfCnpj.setText(editFornecedorJuridico.getCnpj());
				jTextField_RgRazaoSocial.setText(editFornecedorJuridico.getRazaoSocial());
				jTextField_Pais.setText(editFornecedorJuridico.getEndereco().getPais());
				jTextField_Estado.setText(editFornecedorJuridico.getEndereco().getEstado());
				jTextField_Cidade.setText(editFornecedorJuridico.getEndereco().getCidade());
				jTextField_Logradouro.setText(editFornecedorJuridico.getEndereco().getLogradouro());
				jTextField_Complemento.setText(editFornecedorJuridico.getEndereco().getComplemento());
				jTextField_Numero.setText(editFornecedorJuridico.getEndereco().getNumero());
			}
			else if(TelaContatos.novoFuncionario == false)
			{
				jComboBox_TipoContato.setSelectedIndex(2);
				jComboBox_TipoPessoa.setSelectedIndex(0);
				editFuncionario = umControleFuncionario.pesquisarFuncionario(TelaContatos.nomeTabela, false);
				jTextField_Nome.setText(editFuncionario.getNome());
				jTextField_Telefone.setText(editFuncionario.getTelefone());
				jTextField_Celular.setText(editFuncionario.getCelular());
				jTextField_CpfCnpj.setText(editFuncionario.getCpf());
				jTextField_RgRazaoSocial.setText(editFuncionario.getRg());
				jTextField_Pais.setText(editFuncionario.getEndereco().getPais());
				jTextField_Estado.setText(editFuncionario.getEndereco().getEstado());
				jTextField_Cidade.setText(editFuncionario.getEndereco().getCidade());
				jTextField_Logradouro.setText(editFuncionario.getEndereco().getLogradouro());
				jTextField_Complemento.setText(editFuncionario.getEndereco().getComplemento());
				jTextField_Numero.setText(editFuncionario.getEndereco().getNumero());
				jTextField_Cargo.setText(editFuncionario.getCargo());
				jTextField_Salario.setText(Double.toString(editFuncionario.getSalario()));
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

			if(TelaContatos.modoEditar == false)
			{
				if(jComboBox_TipoContato.getSelectedIndex() == 0)
				{
					if(jComboBox_TipoPessoa.getSelectedIndex() == 0)
					{
						umClienteFisico = new ClienteFisico(cpfcnpj, rgrazaosocial, nome, umEndereco, telefone, celular);
						if(umControleCliente.pesquisarCliente(umClienteFisico.getNome(), false) == null)
							umControleCliente.adicionarCliente(umClienteFisico);
						else
							exibirInformacao("Cliente já cadastrado!");
					}
					else if(jComboBox_TipoPessoa.getSelectedIndex() == 1)
					{
						umClienteJuridico = new ClienteJuridico(cpfcnpj, rgrazaosocial, nome, umEndereco, telefone, celular);
						if(umControleCliente.pesquisarCliente(umClienteJuridico.getNome(), false) == null)
							umControleCliente.adicionarCliente(umClienteJuridico);
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
					if(umControleFuncionario.pesquisarFuncionario(umFuncionario.getNome(), false) == null)
						umControleFuncionario.adicionarFuncionario(umFuncionario);
					else
						exibirInformacao("Funcionário já cadastrado!");
				}
			}
			else if(TelaContatos.modoEditar == true)
			{

				if(TelaContatos.novoClienteFisico == false)
				{
					if(!editClienteFisico.getNome().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(0);
						jComboBox_TipoPessoa.setSelectedIndex(0);
						editClienteFisico.getEndereco().setLogradouro(logradouro);
						editClienteFisico.getEndereco().setPais(pais);
						editClienteFisico.getEndereco().setEstado(estado);
						editClienteFisico.getEndereco().setCidade(cidade);
						editClienteFisico.getEndereco().setComplemento(complemento);
						editClienteFisico.getEndereco().setNumero(numero);
						editClienteFisico.setNome(nome);
						editClienteFisico.setTelefone(telefone);
						editClienteFisico.setCelular(celular);
						editClienteFisico.setCpf(cpfcnpj);
						editClienteFisico.setRg(rgrazaosocial);
						editClienteFisico.setEndereco(umEndereco);
					}
				}
				else if(TelaContatos.novoClienteJuridico == false)
				{
					if(!editClienteJuridico.getNome().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(0);
						jComboBox_TipoPessoa.setSelectedIndex(1);
						editClienteJuridico.getEndereco().setLogradouro(logradouro);
						editClienteJuridico.getEndereco().setPais(pais);
						editClienteJuridico.getEndereco().setEstado(estado);
						editClienteJuridico.getEndereco().setCidade(cidade);
						editClienteJuridico.getEndereco().setComplemento(complemento);
						editClienteJuridico.getEndereco().setNumero(numero);
						editClienteJuridico.setNome(nome);
						editClienteJuridico.setTelefone(telefone);
						editClienteJuridico.setCelular(celular);
						editClienteJuridico.setCnpj(cpfcnpj);
						editClienteJuridico.setRazaoSocial(rgrazaosocial);
						editClienteJuridico.setEndereco(umEndereco);
					}
				}
				else if(TelaContatos.novoFornecedorFisico == false)
				{
					if(!editFornecedorFisico.getNome().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(1);
						jComboBox_TipoPessoa.setSelectedIndex(0);
						editFornecedorFisico.getEndereco().setLogradouro(logradouro);
						editFornecedorFisico.getEndereco().setPais(pais);
						editFornecedorFisico.getEndereco().setEstado(estado);
						editFornecedorFisico.getEndereco().setCidade(cidade);
						editFornecedorFisico.getEndereco().setComplemento(complemento);
						editFornecedorFisico.getEndereco().setNumero(numero);
						editFornecedorFisico.setNome(nome);
						editFornecedorFisico.setTelefone(telefone);
						editFornecedorFisico.setCelular(celular);
						editFornecedorFisico.setCpf(cpfcnpj);
						editFornecedorFisico.setRg(rgrazaosocial);
						editFornecedorFisico.setEndereco(umEndereco);
					}
				}
				else if(TelaContatos.novoFornecedorJuridico == false)
				{
					if(!editFornecedorJuridico.getNome().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(1);
						jComboBox_TipoPessoa.setSelectedIndex(1);
						editFornecedorJuridico.getEndereco().setLogradouro(logradouro);
						editFornecedorJuridico.getEndereco().setPais(pais);
						editFornecedorJuridico.getEndereco().setEstado(estado);
						editFornecedorJuridico.getEndereco().setCidade(cidade);
						editFornecedorJuridico.getEndereco().setComplemento(complemento);
						editFornecedorJuridico.getEndereco().setNumero(numero);
						editFornecedorJuridico.setNome(nome);
						editFornecedorJuridico.setTelefone(telefone);
						editFornecedorJuridico.setCelular(celular);
						editFornecedorJuridico.setCnpj(cpfcnpj);
						editFornecedorJuridico.setRazaoSocial(rgrazaosocial);
						editFornecedorJuridico.setEndereco(umEndereco);
					}
				}
				else if(TelaContatos.novoFuncionario == false)
				{
					if(!editFuncionario.getNome().equals(jTextField_Nome.getText()))
					{
						exibirInformacao("Não é permitido a alteração do nome!");
					}
					else
					{
						jComboBox_TipoContato.setSelectedIndex(1);
						jComboBox_TipoPessoa.setSelectedIndex(0);
						editFuncionario.getEndereco().setLogradouro(logradouro);
						editFuncionario.getEndereco().setPais(pais);
						editFuncionario.getEndereco().setEstado(estado);
						editFuncionario.getEndereco().setCidade(cidade);
						editFuncionario.getEndereco().setComplemento(complemento);
						editFuncionario.getEndereco().setNumero(numero);
						editFuncionario.setNome(nome);
						editFuncionario.setTelefone(telefone);
						editFuncionario.setCelular(celular);
						editFuncionario.setCpf(cpfcnpj);
						editFuncionario.setRg(rgrazaosocial);
						editFuncionario.setEndereco(umEndereco);
					}
				}
			}
			TelaContatos.modoEditar = false;
			TelaContatos.novoClienteFisico = true;
			TelaContatos.novoClienteJuridico = true;
			TelaContatos.novoFornecedorFisico = true;
			TelaContatos.novoFornecedorJuridico = true;
			TelaContatos.novoFuncionario = true;

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
