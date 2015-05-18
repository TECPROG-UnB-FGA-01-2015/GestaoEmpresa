/**********************************************************
 * File: ExpenseView.java
 * Purpose: Responsible to show Expenses' informations
 *********************************************************/
package view;

import java.util.ArrayList;

import javax.swing.JTable;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

import javax.swing.table.DefaultTableModel;

import model.Expense;
import static view.ExpenseDataView.objectExpenseController;

import org.apache.log4j.Logger;

public class ExpenseView extends javax.swing.JFrame
{
	// Variables declaration of Buttons, ComboBox, Labels, Panel, ScrollPane and Table
    private javax.swing.JButton jButton1; // Button that adds a New Expense on the system
    private javax.swing.JButton jButton_Sair; // Button that exits "Expenses Historic" Screen
    private javax.swing.JComboBox jComboBox_Ano1; // Button that shows a drop-down list from the years 2013 until 2017 on the first New Expense's period option
    private javax.swing.JComboBox jComboBox_Ano2; // Button that shows a drop-down list from the years 2013 until 2017 on the second New Expense's period option
    private javax.swing.JComboBox jComboBox_Mes1; // Button that shows a drop-down list from the months January until December on the first New Expense's period option
    private javax.swing.JComboBox jComboBox_Mes2; // Button that shows a drop-down list from the months January until December on the second New Expense's period option
    private javax.swing.JLabel jLabel1; // Shows the "Expense Historic" word on the Screen 
    private javax.swing.JLabel jLabel2; // Shows the "Period" word on the Screen 
    private javax.swing.JLabel jLabel3; // Shows the "From" word on the Screen 
    private javax.swing.JLabel jLabel4; // Shows the "Until" word on the Screen 
    private javax.swing.JPanel jPanel1; // Shows the entire "Expenses Historic" Screen Layout
    private javax.swing.JRadioButton jRadioButton1; // Button that shows all the accomplished Expenses (it disables the first and second option to choose)
    private javax.swing.JScrollPane jScrollPane1; // Shows the "Expenses Historic" screen scroll 
    private javax.swing.JTable jTable_Despesa; // Shows a table with the Expense Historic, day, month, year, note and value
    
    int firstMonth=1; // Holds the expense's month start
    int firstYear=2013; // Holds the expense's year start
    int secondMonth=7; // Holds the expense's month final
    int secondYear=2014; // Holds the expense's year final
    
    static Logger log = Logger.getLogger(ExpenseView.class.getName());
    
    // Constructor to initialize components on ProductDataView
    public ExpenseView()
    {
        initComponents();
        loadList();
        jComboBox_Mes2.setSelectedIndex(secondMonth-1);
        jComboBox_Ano2.setSelectedItem("2014");
        
        log.debug("Load ExpenseView");
    }
    
    // Method to show all the expenses added
    private void loadList()
    {
        boolean permission; // Boolean to allow or not the sequence of the expense creating
        
        ArrayList<Expense> expenseList = objectExpenseController.getListaGasto();
        DefaultTableModel model = (DefaultTableModel) jTable_Despesa.getModel();
        model.setRowCount(0);
        for (Expense expense : expenseList) 
        {
            permission=false;
            
            if(expense.getYear()>=firstYear&&expense.getYear()<=secondYear)
            {
                permission=true;
            }
            
            else if(expense.getYear()==firstYear&&expense.getYear()==secondYear&&expense.getMonth()>=firstMonth&&expense.getMonth()<=secondMonth)
            {
                permission=true;
            }
            
            else if(expense.getYear()==firstYear&&expense.getYear()!=secondYear&&expense.getMonth()>=firstMonth)
            {
                permission=true;
            }
            
            else if(expense.getYear()!=firstYear&&expense.getYear()==secondYear&&expense.getMonth()<=secondMonth)
            {
                permission=true;
            }
            else
            {
            	// Nothing to do
            }
            
            if(expense.getYear()<firstYear)
            {
                permission=false;
            }
            
            else if(expense.getYear()>secondYear)
            {
                permission=false;
            }
            
            else if(expense.getYear()==firstYear&&expense.getMonth()<firstMonth)
            {
                permission=false;
            }
            
            else if(expense.getYear()==secondYear&&expense.getMonth()>secondMonth)
            {
                permission=false;
            }
            
            else
            {
            	// Nothing to do
            }
            
            if(permission==true)
            {
                model.addRow(new String[]{expense.getName(),Integer.toString(expense.getDay()),
                									  Integer.toString(expense.getMonth()),
                									  Integer.toString(expense.getYear()),
                									  expense.getDescription(),
                									  Double.toString(expense.getValue())});
            }
            
            else
            {
            	// Nothing to do
            }
        }
        
        jTable_Despesa.setModel(model);  
  
        jTable_Despesa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        jTable_Despesa.getColumnModel().getColumn(0).setPreferredWidth(220);  
        jTable_Despesa.getColumnModel().getColumn(1).setPreferredWidth(50);  
        jTable_Despesa.getColumnModel().getColumn(2).setPreferredWidth(50);  
        jTable_Despesa.getColumnModel().getColumn(3).setPreferredWidth(50);  
        jTable_Despesa.getColumnModel().getColumn(4).setPreferredWidth(533);
        jTable_Despesa.getColumnModel().getColumn(4).setPreferredWidth(222);   
  
        model.fireTableDataChanged();
        
        log.info("Expense list loaded successfully!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jButton_Sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Despesa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox_Mes1 = new javax.swing.JComboBox();
        jComboBox_Ano1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_Mes2 = new javax.swing.JComboBox();
        jComboBox_Ano2 = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Despesas");
        setBounds(new java.awt.Rectangle(300, 300, 0, 0));

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

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Histórico de Despesas");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Período:");

        jLabel3.setText("De");

        jTable_Despesa.setModel(new javax.swing.table.DefaultTableModel
            (
                null,
                new String [] {
                    "Histórico", "Dia", "Mês", "Ano", "Observação", "Valor"
                }
            )
        {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex)
            {
                return false;
            }
        });
        jScrollPane1. setViewportView(jTable_Despesa);

        jButton1.setText("Nova Despesa");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox_Mes1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBox_Mes1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
            	try
            	{
                    jComboBox_Mes1ItemStateChanged(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
            }
        });

        jComboBox_Ano1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017" }));
        jComboBox_Ano1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
            	try
            	{
                    jComboBox_Ano1ItemStateChanged(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
            }
        });

        jLabel4.setText("Até");

        jComboBox_Mes2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBox_Mes2.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt) 
            {
            	try
            	{
                    jComboBox_Mes2ItemStateChanged(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
            }
        });

        jComboBox_Ano2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017" }));
        jComboBox_Ano2.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
            	try
            	{
                    jComboBox_Ano2ItemStateChanged(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
            }
        });

        jRadioButton1.setText("Mostrar Todas Despesas");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
            	try
            	{
                    jRadioButton1ItemStateChanged(evt);
            	}
            	catch (Exception e)
            	{
            		e.printStackTrace();
            	}
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_Sair)
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Mes1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Ano1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Mes2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Ano2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Sair)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_Mes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Ano1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox_Mes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Ano2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) throws Exception
    {
    	try
    	{
	    	log.debug("Exit ExpenseView");
	        this.dispose();
    	}
    	catch (Exception e)
    	{
    		log.error("Error when exiting ExpenseView. Exception: ", e);
			throw e;
    	}
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.dispose();
        new ExpenseDataView().setVisible(true);
    }

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt)
    {
        if(jRadioButton1.isSelected())
        {
            firstMonth=1;
            secondMonth=12;
            firstYear=2013;
            secondYear=2017;
            jComboBox_Ano1.setEnabled(false);
            jComboBox_Ano2.setEnabled(false);
            jComboBox_Mes1.setEnabled(false);
            jComboBox_Mes2.setEnabled(false);
        }
        
        else
        {
            firstMonth=jComboBox_Mes1.getSelectedIndex()+1;
            secondMonth=jComboBox_Mes2.getSelectedIndex()+1;
            firstYear=Integer.parseInt((String) jComboBox_Ano1.getSelectedItem());
            secondYear=Integer.parseInt((String) jComboBox_Ano1.getSelectedItem());
            jComboBox_Ano1.setEnabled(true);
            jComboBox_Ano2.setEnabled(true);
            jComboBox_Mes1.setEnabled(true);
            jComboBox_Mes2.setEnabled(true);
        }
        
        loadList();
    }
    
    private void jComboBox_Mes1ItemStateChanged(java.awt.event.ItemEvent evt) throws Exception
    {
    	try
    	{
	        firstMonth=jComboBox_Mes1.getSelectedIndex()+1;
	        loadList();
    	}
    	catch (Exception e)
    	{
    		log.error("Error when changing mes1ItemState. Exception: ", e);
			throw e;
    	}
    }

    private void jComboBox_Ano1ItemStateChanged(java.awt.event.ItemEvent evt) throws Exception
    {
    	try
    	{
	        firstYear=Integer.parseInt((String) jComboBox_Ano1.getSelectedItem());
	        loadList();
    	}
    	catch (Exception e)
    	{
    		log.error("Error when changing ano1ItemState. Exception: ", e);
			throw e;
    	}
    }

    private void jComboBox_Mes2ItemStateChanged(java.awt.event.ItemEvent evt) throws Exception
    {
    	try
    	{
        secondMonth=jComboBox_Mes2.getSelectedIndex()+1;
        loadList();
    	}
    	catch (Exception e)
    	{
    		log.error("Error when changing mes2ItemState. Exception: ", e);
			throw e;
    	}
    }

    private void jComboBox_Ano2ItemStateChanged(java.awt.event.ItemEvent evt) throws Exception
    {
        try
        {
        	secondYear=Integer.parseInt((String) jComboBox_Ano2.getSelectedItem());
        	loadList();
        }
        catch (Exception e)
        {
        	log.error("Error when changing ano2ItemState. Exception: ", e);
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
            }
        }
        
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ExpenseView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ExpenseView().setVisible(true);
            }
        });
    }
      
}
