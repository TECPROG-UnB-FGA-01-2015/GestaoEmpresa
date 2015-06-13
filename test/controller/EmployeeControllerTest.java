package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import model.Client;
import model.Employee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeControllerTest extends TestCase
{
	Employee employee;
	ArrayList<Employee> employeeList;
	EmployeeController employeeController = new EmployeeController(); 


	@Before
	public void setUp() throws Exception
	{
		employee = new Employee("Teste", "123", "1234", "12345", "123456", "admin", 150.00, null);
		employeeList = new ArrayList<Employee>();
	}

	@After
	public void tearDown() throws Exception
	{
		employeeList.clear();
	}

	@Test
	public void test()
	{
		
	}

}
