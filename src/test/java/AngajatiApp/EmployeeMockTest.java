package AngajatiApp;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    EmployeeMock employeeMock = new EmployeeMock();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testAddEmployeeValidCNP() {
        Employee employee = new Employee(9,"John", "Doe", "1234567891234", DidacticFunction.ASISTENT, 5500.0);
        assertTrue(employeeMock.addEmployee(employee));
    }

    @Test
    void testAddEmployeeInvalidCNP() {
        Employee employee = new Employee(9,"John", "Doe", "12345891234", DidacticFunction.ASISTENT, 5500.0);
        assertFalse(employeeMock.addEmployee(employee));
    }
    @Test
    void testAddEmployeeInvalidSalary() {
        Employee employee = new Employee(9,"John", "Doe", "1234567891234", DidacticFunction.ASISTENT, -5500.0);
        assertFalse(employeeMock.addEmployee(employee));
    }
    @Test
    void testAddEmployeeInvalidFunction() {
        Employee employee = new Employee(9,"John", "Doe", "1234567891234", DidacticFunction.EXTERN, 5500.0);
        assertFalse(employeeMock.addEmployee(employee));
    }
    @Test
    void testAddEmployeeInvalidFirstName() {
        Employee employee = new Employee(9,"J", "Doe", "1234567891234", DidacticFunction.ASISTENT, 5500.0);
        assertFalse(employeeMock.addEmployee(employee));
    }

    @Test
    void testAddEmployeeValidCNPBVA() {
        Employee employee = new Employee(9,"John", "Doe", "1234567891234", DidacticFunction.ASISTENT, 5500.0);
        assertTrue(employeeMock.addEmployee(employee));
    }
    @Test
    void testAddEmployeeInvalidCNPBVA1() {
        Employee employee = new Employee(9,"John", "Doe", "12345678912345", DidacticFunction.ASISTENT, 5500.0);
        assertFalse(employeeMock.addEmployee(employee));
    }
    @Test
    void testAddEmployeeInvalidCNPBVA2() {
        Employee employee = new Employee(9,"John", "Doe", "123456789123", DidacticFunction.ASISTENT, 5500.0);
        assertFalse(employeeMock.addEmployee(employee));
    }


    @Test
    void testAddEmployeeInvalidFirstNameBVA() {
        Employee employee = new Employee(9,"Jo", "Doe", "1234567891234", DidacticFunction.ASISTENT, 5500.0);
        assertFalse(employeeMock.addEmployee(employee));
    }


    @Test
    void testAddEmployeeValidFirstNameBVA() {
        Employee employee = new Employee(9,"Jon", "Doe", "1234567891234", DidacticFunction.ASISTENT, 5500.0);
        assertTrue(employeeMock.addEmployee(employee));
    }

    //----------------------------------------------------------------
//    @Test
//    void testModifyEmployeeValidFunction() {
//
//        List<Employee> oldList = employeeMock.getEmployeeList();
//        Employee employee = new Employee("Jon", "Doe", "1234567891234", DidacticFunction.ASISTENT, 5500.0);
//        employeeMock.modifyEmployeeFunction(employee, DidacticFunction.LECTURER);
//        assertSame(oldList, employeeMock.getEmployeeList());
//    }
//
//    @Test
//    void testModifyEmployeeInvalidFunction() {
//        List<Employee> oldList = employeeMock.getEmployeeList();
//        Employee employee = new Employee("Marin", "Puscas", "1234567890876", DidacticFunction.ASISTENT, 2800.0);
//        employeeMock.modifyEmployeeFunction(employee, DidacticFunction.LECTURER);
//        assertSame(oldList, employeeMock.getEmployeeList());
//    }

    @Test
    void modifyEmployeeFunctionValid() {
        int employeeIdToModify = 2;
        Employee existingEmployee = employeeMock.findEmployeeById(employeeIdToModify);

        assertNotNull(existingEmployee, "Employee is nonexistent.");
        assertEquals(DidacticFunction.LECTURER, existingEmployee.getFunction());

        DidacticFunction newFunction = DidacticFunction.ASISTENT;
        employeeMock.modifyEmployeeFunction(existingEmployee, newFunction);
        Employee modifiedEmployee = employeeMock.findEmployeeById(employeeIdToModify);

        assertNotNull(modifiedEmployee, "Modified employee is nonexistent");
        assertEquals(newFunction,  modifiedEmployee.getFunction());
    }

    @Test
    void modifyEmployeeFunctionWhenNullEmployee() {
        Employee nullEmployee = null;

        assertNull(nullEmployee, "Employee is null.");

        DidacticFunction newFunction = DidacticFunction.ASISTENT;
        employeeMock.modifyEmployeeFunction(nullEmployee, newFunction);

        assertNull(nullEmployee, "No modification should be applied on null Employee.");
    }


    @Test
    void modifyEmployeeFunctionInvalid() {
        int nonExistingEmployeeId = 100;
        Employee nonExistingEmployee = employeeMock.findEmployeeById(nonExistingEmployeeId);
        System.out.println(nonExistingEmployee);
        assertNull(nonExistingEmployee, "Employee is nonexistent.");

        DidacticFunction newFunction = DidacticFunction.ASISTENT;
        employeeMock.modifyEmployeeFunction(nonExistingEmployee, newFunction);
        Employee unmodifiedEmployee = employeeMock.findEmployeeById(nonExistingEmployeeId);
        System.out.println(unmodifiedEmployee);
        assertNull(unmodifiedEmployee, "Employee function should remain unchanged.");
    }






}