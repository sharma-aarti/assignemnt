package com.assignment.demo.Service;

import com.assignment.demo.Dao.EmployeeRepository;
import com.assignment.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //create a single Employee
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }


    // get Employee by id
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    //update Employee
    public Employee updateEmployee(Employee employee){
        Employee emp = employeeRepository.findById(employee.getId()).orElse(null);
        emp.setName(employee.getName());
        return employeeRepository.save(emp);
    }
    // delete department
    public void deleteEmployee(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee!=null){
            employeeRepository.deleteById(id);
        }
    }

}
