package com.assignment.demo.Controller;

import com.assignment.demo.Service.DepartmentService;
import com.assignment.demo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departmemt")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
public Department addDepartment(@RequestBody Department department){
   return departmentService.createDepartment(department);
}

@GetMapping("/getDepartment/{id}")
public Department getDepartmentById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
}
@PutMapping("/updateDepartment")
public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
}
@DeleteMapping("/deleteDepartment")
public void deleteDepartment(@PathVariable int id){
    departmentService.deleteDepartment(id);
}


}
