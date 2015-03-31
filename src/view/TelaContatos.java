package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.ClienteFisico;
import model.ClienteJuridico;
import model.Fornecedor;
import model.FornecedorFisico;
import model.FornecedorJuridico;
import model.Funcionario;
import static view.TelaDadosContatos.umControleCliente;
import static view.TelaDadosContatos.umControleFornecedor;
import static view.TelaDadosContatos.umControleFuncionario;
import static view.TelaVendaCompra.modoClienteFornecedor;
import static view.TelaVendaCompra.modoVendaCompra;
import static view.TelaVendaCompra.statusVendaCompra;

public class ContactView extends javax.swing.JFrame
{
    
    GestaoEmpresa principal;
    static boolean newPhysicalClient = true;
    static boolean newJuridicalClient = true;
    static boolean newPhysicalSupplier = true;
    static boolean newJuridicalSupplier = true;
    static boolean newEmployee = true;
    static boolean editMode = false;
    static String tableName;
    static int contactType;
    static ArrayList<Cliente> listClient;
    public ClienteFisico umClienteFisico;
    public ClienteJuridico umClienteJuridico;
    static ArrayList<Fornecedor> listSupplier;
    public FornecedorFisico umFornecedorFisico;
    public FornecedorJuridico umFornecedorJuridico;
    static ArrayList<Funcionario> listEmployee;
    public Funcionario umFuncionario;
    int i;
    TelaVendaCompra telaVendaCompra;
    static boolean returnClienteFornecedor;
    static boolean returnFuncionario;
    static String nomeClienteFornecedor;
    static String nomeFuncionario;

    // Constructor of the ContactView's class
    public ContactView()
    {
        initComponents();
        jButton_Editar.setEnabled(false);
        jButton_Excluir.setEnabled(false);
        carregarLista();
        jButton_ConfirmarContato.setVisible(false);
        jButton_ConfirmarContato.setEnabled(false);
        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(modoVendaCompra == true)
        {
            if(TelaVendaCompra.modoFuncionario == true)
                jComboBox1.setSelectedIndex(2);
            
            else if(statusVendaCompra == 0)
                jComboBox1.setSelectedIndex(0);
            
            else if(statusVendaCompra == 1)
                jComboBox1.setSelectedIndex(1);
                
            jComboBox1.setEnabled(false);
            jButton_ConfirmarContato.setVisible(true);
        }
        if(TelaVendaCompra.modoFuncionario == true)
        {
            jButton_AdicionarContato.setEnabled(false);
        }
        jTextField_NomeBusca.requestFocus();
    }

    // Auto-generated function to initialize components of the form
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
                jButton_AdicionarContatoActionPerformed(evt);
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
                    jButton_CancelarActionPerformed(evt);
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
        }// </editor-fold>//GEN-END:initComponents

    // Shows message on screen with given string
    public void exibirInformacao(String info)
    {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    // Access and returns the property clieteFisico
    public ClienteFisico getClienteFisico()
    {
        return umClienteFisico;
    }
    
    // Loads the clientList
    private void carregarLista()
    {
        if(contactType==0)
        {
            listClient = umControleCliente.getlistClient();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Cliente c : listClient) {
                if(c.getClass().equals(ClienteFisico.class))
                {
                    umClienteFisico=(ClienteFisico) c;
                    model.addRow(new String[]{umClienteFisico.getNome(), 
                        umClienteFisico.getCpf(), umClienteFisico.getCelular(), 
                        umClienteFisico.getTelefone(), "Física"});
                }
                else if(c.getClass().equals(ClienteJuridico.class))
                {
                    umClienteJuridico=(ClienteJuridico) c;
                    model.addRow(new String[]{umClienteJuridico.getNome(), 
                        umClienteJuridico.getCnpj(), umClienteJuridico.getCelular(), 
                        umClienteJuridico.getTelefone(), "Jurídica"});
                }
                    
            }
            jTable1.setModel(model);
        }
        else if(contactType==1)
        {
            listSupplier = umControleFornecedor.getListaFornecedor();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Fornecedor c : listSupplier)
            {
                if(c.getClass().equals(FornecedorFisico.class))
                {
                    umFornecedorFisico=(FornecedorFisico) c;
                    model.addRow(new String[]{umFornecedorFisico.getNome(), 
                        umFornecedorFisico.getCpf(), umFornecedorFisico.getCelular(), 
                        umFornecedorFisico.getTelefone(), "Física"});
                }
                else if(c.getClass().equals(FornecedorJuridico.class))
                {
                    umFornecedorJuridico=(FornecedorJuridico) c;
                    model.addRow(new String[]{umFornecedorJuridico.getNome(), 
                        umFornecedorJuridico.getCnpj(), umFornecedorJuridico.getCelular(), 
                        umFornecedorJuridico.getTelefone(), "Jurídica"});
                }
                    
            }
            jTable1.setModel(model);
        }
        else if(contactType==2)
        {
            listEmployee = umControleFuncionario.getListaFuncionario();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Funcionario c : listEmployee)
            {
                umFuncionario=(Funcionario) c;
                model.addRow(new String[]{umFuncionario.getNome(), 
                umFuncionario.getCpf(), umFuncionario.getCelular(), 
                umFuncionario.getTelefone(), "Física"});   
            }
            jTable1.setModel(model);
        }
    }
    
    // Cancels the client edit
    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton_CancelarActionPerformed
         this.dispose();
         if(modoClienteFornecedor == true)
         {
             new TelaVendaCompra().setVisible(true);
         }
         modoClienteFornecedor = false;
         TelaVendaCompra.modoFuncionario = false;
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    // Calls the form to register new contact
    private void jButton_AdicionarContatoActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton_AdicionarContatoActionPerformed
        editMode = false;
        new TelaDadosContatos().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_AdicionarContatoActionPerformed

    // Search for the contacts
    private void jButton_PesquisarActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton_PesquisarActionPerformed
        String nomeBusca = jTextField_NomeBusca.getText();
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();  //Funçao para limpar a tabela
        model1.setRowCount(0);
        jTable1.setModel(model1);
           
        if(!nomeBusca.equals(""))
        {
            i=0;
            if(umControleCliente.pesquisarCliente(nomeBusca,true)!=null)
            {
                if((modoVendaCompra==false)||(modoVendaCompra==true&&contactType==0))
                {
                    Cliente buscaCliente = umControleCliente.pesquisarCliente(nomeBusca,true);
                    jComboBox1.setSelectedIndex(0);
                    jTextField_NomeBusca.setText(buscaCliente.getNome());

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();  //Funçao para limpar a tabela
                    model.setRowCount(0);

                    i++;
                    if(buscaCliente.getClass().equals(ClienteFisico.class))
                    {
                        ClienteFisico buscaContato=(ClienteFisico) umControleCliente.pesquisarCliente(nomeBusca,true);
                        model.addRow(new String[]{buscaContato.getNome(), buscaContato.getCpf(), buscaContato.getCelular(), buscaContato.getTelefone(), "Física"});
                    }
                    else if(buscaCliente.getClass().equals(ClienteJuridico.class))
                    {
                        ClienteJuridico buscaContato = (ClienteJuridico) umControleCliente.pesquisarCliente(nomeBusca,true);
                        model.addRow(new String[]{buscaContato.getNome(), 
                            buscaContato.getCnpj(), buscaContato.getCelular(), 
                            buscaContato.getTelefone(), "Jurídica"});
                    }
                }
            }
            if(umControleFornecedor.pesquisarFornecedor(nomeBusca,true)!=null)
            {
                if((modoVendaCompra==false)||(modoVendaCompra==true&&contactType==1))
                {
                    i++;
                    Fornecedor buscaFornecedor = umControleFornecedor.pesquisarFornecedor(nomeBusca,true);
                    jComboBox1.setSelectedIndex(1);
                    jTextField_NomeBusca.setText(buscaFornecedor.getNome());

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();  //Funçao para limpar a tabela
                    model.setRowCount(0);

                    if(buscaFornecedor.getClass().equals(FornecedorFisico.class))
                    {
                        FornecedorFisico buscaContato = (FornecedorFisico) umControleFornecedor.pesquisarFornecedor(nomeBusca,true);
                        model.addRow(new String[]{buscaContato.getNome(), 
                            buscaContato.getCpf(), buscaContato.getCelular(), 
                            buscaContato.getTelefone(), "Físico"});
                    }
                    else if(buscaFornecedor.getClass().equals(FornecedorJuridico.class))
                    {
                        FornecedorJuridico buscaContato = (FornecedorJuridico) umControleFornecedor.pesquisarFornecedor(nomeBusca,true);
                        model.addRow(new String[]{buscaContato.getNome(), 
                            buscaContato.getCnpj(), buscaContato.getCelular(), 
                            buscaContato.getTelefone(), "Jurídica"});
                    }
                }
            }
            if(umControleFuncionario.pesquisarFuncionario(nomeBusca,true)!=null)
            {
                if((modoVendaCompra==false)||(modoVendaCompra==true&&contactType==2))
                {
                    i++;
                    Funcionario buscaFuncionario = umControleFuncionario.pesquisarFuncionario(nomeBusca,true);
                    jComboBox1.setSelectedIndex(2);
                    jTextField_NomeBusca.setText(buscaFuncionario.getNome());

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();  //Funçao para limpar a tabela
                    model.setRowCount(0);

                    model.addRow(new String[]{buscaFuncionario.getNome(), 
                        buscaFuncionario.getCpf(), buscaFuncionario.getCelular(), 
                        buscaFuncionario.getTelefone(), "Física"});
                }
            }
            if((umControleCliente.pesquisarCliente(nomeBusca,true) == null)
                    &&(umControleFornecedor.pesquisarFornecedor(nomeBusca,true) == null)
                    &&(umControleFuncionario.pesquisarFuncionario(nomeBusca,true) == null))
            {
                exibirInformacao("A pesquisa não retornou nenhum resultado!");
                jTextField_NomeBusca.setText(null);
                jTextField_NomeBusca.requestFocus();
            }
        }
        else
        {
            carregarLista();
            if(jTable1.getRowCount()==0)
                exibirInformacao("A pesquisa não retornou nenhum resultado!");
        }

        if(i>1)
        {
            exibirInformacao("Mais de um resultado foi encontrando com o nome '"+ nomeBusca + "'" );
        }
    }//GEN-LAST:event_jButton_PesquisarActionPerformed

    // Changes de variable contactType depending on which contact type was chosen
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt)
    {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(jComboBox1.getSelectedIndex()==0)
        {
            contactType=0;
        }
        else if(jComboBox1.getSelectedIndex()==1)
        {
            contactType=1;
        }
        else if(jComboBox1.getSelectedIndex()==2)
        {
            contactType=2;
        }
        
        jButton_Editar.setEnabled(false);
        jButton_Excluir.setEnabled(false);
        
        carregarLista();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    // Opens contact register form to edit contact
    private void jButton_EditarActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton_EditarActionPerformed
        if(newPhysicalClient==true&&newJuridicalClient==true
                &&newPhysicalSupplier==true&&newJuridicalSupplier==true
                &&newEmployee==true)
        {
            principal.exibirInformacao("Selecione um Contato da Tabela");
        }
        else
        {
            new TelaDadosContatos().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton_EditarActionPerformed

    // Select contact depending on which contact was clicked
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_jTable1MouseClicked
        newPhysicalClient=true;
        newJuridicalClient=true;
        newPhysicalSupplier=true;
        newJuridicalSupplier=true;
        newEmployee=true;
                
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        tableName = (String) model.getValueAt(jTable1.getSelectedRow(), 0);
        
        if(contactType==0)
        {
            if((String) model.getValueAt(jTable1.getSelectedRow(), 4)=="Física")
                newPhysicalClient=false;
            else if((String) model.getValueAt(jTable1.getSelectedRow(), 4)=="Jurídica")
                newJuridicalClient=false;
        }
        else if(contactType==1)
        {
            if((String) model.getValueAt(jTable1.getSelectedRow(), 4)=="Física")
                newPhysicalSupplier=false;
            else if((String) model.getValueAt(jTable1.getSelectedRow(), 4)=="Jurídica")
                newJuridicalSupplier=false;
        }
        else if(contactType==2)
        {
            newEmployee=false;
        }
        
        jButton_Editar.setEnabled(true);
        jButton_Excluir.setEnabled(true);
        jButton_ConfirmarContato.setEnabled(true);
        editMode=true;
    }//GEN-LAST:event_jTable1MouseClicked

    // Exclude contact selected
    private void jButton_ExcluirActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton_ExcluirActionPerformed
        
        if(newPhysicalClient==false)
        {
            umControleCliente.removerCliente(umControleCliente.pesquisarCliente(tableName,false));
        }
        else if(newJuridicalClient==false)
        {
            umControleCliente.removerCliente(umControleCliente.pesquisarCliente(tableName,false));
        }
        else if(newPhysicalSupplier==false)
        {
            umControleFornecedor.removerFornecedor(umControleFornecedor.pesquisarFornecedor(tableName,false));
        }
        else if(newJuridicalSupplier==false)
        {
            umControleFornecedor.removerFornecedor(umControleFornecedor.pesquisarFornecedor(tableName,false));
        }
        else if(newEmployee==false)
        {
            umControleFuncionario.removerFuncionario(umControleFuncionario.pesquisarFuncionario(tableName,false));
        }
        carregarLista();
        exibirInformacao("Contato excluído com sucesso");
        jButton_Editar.setEnabled(false);
        jButton_Excluir.setEnabled(false);
    }//GEN-LAST:event_jButton_ExcluirActionPerformed

    // Disable the Confirm Contact button
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt)
    {//GEN-FIRST:event_jPanel1MouseClicked
        jButton_ConfirmarContato.setEnabled(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    // Confirm Contact chosen to TelaVendaCompra's view
    private void jButton_ConfirmarContatoActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_jButton_ConfirmarContatoActionPerformed
        this.dispose();
        if(TelaVendaCompra.modoClienteFornecedor == true)
            returnClienteFornecedor = true;
        
        if(TelaVendaCompra.modoFuncionario == true)
            returnFuncionario = true;
        
        if(TelaVendaCompra.modoClienteFornecedor == true && nomeClienteFornecedor == null)
            nomeClienteFornecedor = tableName;
            
        if(TelaVendaCompra.modoFuncionario == true && nomeFuncionario == null)
            nomeFuncionario=tableName;
        
        modoVendaCompra = false;
        TelaVendaCompra.modoClienteFornecedor = false;
        TelaVendaCompra.modoFuncionario = false;
        
        new TelaVendaCompra().setVisible(true);
    }//GEN-LAST:event_jButton_ConfirmarContatoActionPerformed

    // Main function
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
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
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ContactView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ContactView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AdicionarContato;
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_ConfirmarContato;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JButton jButton_Pesquisar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_NomeBusca;
    // End of variables declaration//GEN-END:variables

}
