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

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class ExpenseDataView extends javax.swing.JFrame
{
	// Variables declaration of Buttons, ComboBox, Label and TextFields
    private javax.swing.JButton jButton_Sair; // Exits "New Expense" Screen
    private javax.swing.JButton jButton_Salvar; // Adds and saves a New Expense on the screen
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jComboBox_Ano; // Shows a drop-down list from the years 2013 until 2017 on the date's option
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jComboBox_Dia; // Shows a drop-down list from the days 1 until 31 on the date's option
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jComboBox_Mes; // Shows a drop-down list from the months January until December on the date's option
    private javax.swing.JLabel jLabel1; // Shows the "Historic" word on the Screen 
    private javax.swing.JLabel jLabel2; // Shows the "Date" word on the Screen 
    private javax.swing.JLabel jLabel3; // Shows the "Value" word on the Screen 
    private javax.swing.JLabel jLabel4; // Shows the "Note" word on the Screen 
    private javax.swing.JLabel jLabel5; // Shows the "New Expense" word on the Screen 
    private javax.swing.JLabel jLabel6;  // Shows the "R$" symbol (Brazilian Currency) on the New Expense Screen
    private javax.swing.JTextField jTextField_Descricao; // Keeps and adds the Expense's note 
    private javax.swing.JTextField jTextField_Nome; // Keeps and adds the Expense's name 
    private javax.swing.JTextField jTextField_Valor; // Keeps and adds the Expense's value 
    
    Expense objectExpense; // Expense type object
    Date date = new Date(); // Describes the date of an expense (dd/MM/yyyy)
    DateFormat dateFormat; // Describes the format of expense date
    
    // ExpenseController type object
    static ExpenseController objectExpenseController = new ExpenseController();
    static Logger log = Logger.getLogger(ExpenseDataView.class.getName());
    
    // Constructor to initialize the ExpenseDataView
    public ExpenseDataView()
    {
        initComponents();
        jTextField_Nome.requestFocus();
        log.debug("Load ExpenseDataView");
        jComboBox_Dia.setSelectedIndex(Integer.parseInt(getDay())-1);
        jComboBox_Mes.setSelectedIndex(Integer.parseInt(getMonth())-1);
        jComboBox_Ano.setSelectedItem(getYear());
    }
    
    // Shows a message to user by passing as a parameter a String info
    public void showMessage(String info)
    {
        JOptionPane.showMessageDialog(this, info, "Atenção" , JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Returns the content of attribute day
    public String getDay() 
    { 
        dateFormat = new SimpleDateFormat("dd"); 
        return dateFormat.format(date);
    }
    
    // Returns the content of attribute month
    public String getMonth() 
    { 
        dateFormat = new SimpleDateFormat("MM"); 
        return dateFormat.format(date);
    }
    
    // Returns the content of attribute year
    public String getYear()
    {
        dateFormat = new SimpleDateFormat("yyyy"); 
        return dateFormat.format(date);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
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
        setTitle("Nova Despesa");
        setBounds(new java.awt.Rectangle(450, 300, 0, 0));

        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            	try
            	{
            		jButton_SairActionPerformed(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
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

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setText("Nova Despesa");

        jComboBox_Mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        log.info("Load months from January until December");

        jComboBox_Ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017", " " }));
        log.info("Load years from 2013 until 2017");
        
        jLabel6.setText("R$");

        jComboBox_Dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        log.info("Load days from 1 until 31");
        
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

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) throws Exception
    {
    	try
    	{
    		log.debug("Exit ExpenseDataView");
    		this.dispose();
    		new ExpenseView().setVisible(true);
    	}
    	catch(Exception e)
        {
        	log.error("Error when exiting ExpenseDataView. Exception: ", e);
        	throw e;
        }
    }

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) throws Exception
    {
    	try
    	{
	        String name = jTextField_Nome.getText();
	        String description = jTextField_Descricao.getText();
	        int month = jComboBox_Mes.getSelectedIndex()+1;
	        int year = jComboBox_Ano.getSelectedIndex()+2013;
	        int day = jComboBox_Dia.getSelectedIndex()+1;
	        double value = Double.parseDouble(jTextField_Valor.getText());
	           
	        String textFieldName = jTextField_Nome.getText();
	        boolean textFieldNameEmpty = textFieldName.equals(""); 
	        
	        String expenseValueTextField = jTextField_Valor.getText();
	        double expenseValue = Double.parseDouble(expenseValueTextField);
	        
	        if(textFieldNameEmpty)
	        {
	            showMessage("Digite o histórico da despesa");
	            log.warn("Expense Historic is empty!");
	        }
	        else if(expenseValue == 0.0)
	        {
	            showMessage("Digite um valor para a despesa");
	            log.warn("Expense value wasn't informed!");
	        }      
	        else
	        {
	            objectExpense = new Expense(name, description, value, day, month, year);
	            objectExpenseController.addExpense(objectExpense);
	            log.debug("New Expense '" + name + "' saved successfully!");
	            log.debug("Expense info: Value '" + value + "', Date: " + day + "/" + month + "/" + year + "");
	            this.dispose();
	            new ExpenseView().setVisible(true);
	        }
    	}
    	catch(Exception e)
    	{
    		log.error("Error when saving new expense. Exception: ", e);
    		throw e;   
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
                else
                {
                	// Nothing to do
                }
            }
        }
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.error("ClassNotFoundException: ", ex);
        }
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.error("InstantiationException: ", ex);
        }
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.error("IllegalAccessException: ", ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(ExpenseDataView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            log.error("UnsupportedLookAndFeelException: ", ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
            	try
            	{
            		new ExpenseDataView().setVisible(true);
            	}
            	catch(Exception e)
            	{
            		log.error("Error when running ExpenseDataView. Exception: ", e);
            		try
					{
						throw e;
					}
					catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}   
            	}
            }
        });
    }     
}
