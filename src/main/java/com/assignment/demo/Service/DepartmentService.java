package com.assignment.demo.Service;

import com.assignment.demo.Dao.DepartmentRepository;
import com.assignment.demo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //create a single department
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

// create a list of departments
    public List<Department> createListOfDepartment(List<Department> departments){
        return departmentRepository.saveAll(departments);
    }

// get department by id
    public Department getDepartmentById(int id){
        return departmentRepository.findById(id).orElse(null);
    }

//update department
  public Department updateDepartment(Department department){
        Department dept = departmentRepository.findById(department.getDepartmentId()).orElse(null);
        dept.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(dept);
  }
// delete department
public void deleteDepartment(int id){
        Department department = departmentRepository.findById(id).orElse(null);
        if(department!=null){
            departmentRepository.deleteById(id);
        }
}


}
