/**********************************************************
 * File: ExpenseDataView.java
 * Purpose: Responsible to get the Expenses' informations from user
 *********************************************************/
package view;

import controller.ExpenseController;
import javax.swing.JOptionPane;
import model.Expense;
import java.util.Date; 
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 

public class ExpenseDataView extends javax.swing.JFrame
{
	// Variables declaration of Buttons, Labels, ComboBox and TextFields
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JButton jButton_Salvar;
    private javax.swing.JComboBox jComboBox_Ano;
    private javax.swing.JComboBox jComboBox_Dia;
    private javax.swing.JComboBox jComboBox_Mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField_Descricao;
    private javax.swing.JTextField jTextField_Nome;
    private javax.swing.JTextField jTextField_Valor;
    
    Expense objectExpense; // Expense type object
    Date date = new Date(); // Contains the date of an expense (dd/MM/yyyy)
    DateFormat dateFormat; // Gets the expense date on format of date
    
    // ExpenseController type object
    static ExpenseController objectExpenseController = new ExpenseController();
    
    // Constructor to initialize components on ExpenseDataView
    public ExpenseDataView()
    {
        initComponents();
        jTextField_Nome.requestFocus();
        jComboBox_Dia.setSelectedIndex(Integer.parseInt(getDay())-1);
        jComboBox_Mes.setSelectedIndex(Integer.parseInt(getMonth())-1);
        jComboBox_Ano.setSelectedItem(getYear());
    }
    
    // Method to show a message to user by passing as a parameter a String info
    public void showMessage(String info)
    {
        JOptionPane.showMessageDialog(this, info,"Atenção" ,JOptionPane.
        		INFORMATION_MESSAGE);
    }
    
    // Method to return the content of attribute day
    public String getDay() 
    { 
        dateFormat = new SimpleDateFormat("dd"); 
        return dateFormat.format(date);
    }
    
    // Method to return the content of attribute month
    public String getMonth() 
    { 
        dateFormat = new SimpleDateFormat("MM"); 
        return dateFormat.format(date);
    }
    
    // Method to return the content of attribute year
    public String getYear()
    {
        dateFormat = new SimpleDateFormat("yyyy"); 
        return dateFormat.format(date);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        jButton_Sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Nome = new javax.swing.JTextField();
        jTextField_Valor = new javax.swing.JTextField();
        jTextField_Descricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_Salvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_Mes = new javax.swing.JComboBox();
        jComboBox_Ano = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_Dia = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Expense");
        setBounds(new java.awt.Rectangle(450, 300, 0, 0));

        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton_SairActionPerformed(evt);
            }
        });

        jLabel1.setText("Histórico:");

        jTextField_Valor.setText("0.00");

        jLabel2.setText("Data:");

        jLabel3.setText("Valor:");

        jLabel4.setText("Observação:");

        jButton_Salvar.setText("Salvar");
        jButton_Salvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton_SalvarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setText("Nova Expense");

        jComboBox_Mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jComboBox_Ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017", " " }));

        jLabel6.setText("R$");

        jComboBox_Dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Sair)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton_Salvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Sair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Salvar)
                .addGap(12, 12, 12))
        );

        pack();
    }

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt)
    {
      this.dispose();
      new ExpenseView().setVisible(true);
    }

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt)
    {
        String name = jTextField_Nome.getText();
        String description = jTextField_Descricao.getText();
        int month = jComboBox_Mes.getSelectedIndex()+1;
        int year = jComboBox_Ano.getSelectedIndex()+2013;
        int day = jComboBox_Dia.getSelectedIndex()+1;
        double valor = Double.parseDouble(jTextField_Valor.getText());
            
        if(jTextField_Nome.getText().equals(""))
        {
            showMessage("Digite o histórico da despesa");
        }
        
        else if(Double.parseDouble(jTextField_Valor.getText())==0.0)
        {
            showMessage("Digite um valor para a despesa");
        }
        
        else
        {
            objectExpense = new Expense(name, description, valor, day, month, year);
            objectExpenseController.addExpense(objectExpense);
            this.dispose();
            new ExpenseView().setVisible(true);
        }
    }

    /**
     * @param args the command line arguments
     */
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
            }
        }
        
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ExpenseDataView().setVisible(true);
            }
        });
    }
       
}
