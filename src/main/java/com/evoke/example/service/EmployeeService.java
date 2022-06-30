package com.evoke.example.service;

import com.evoke.example.dto.EmployeeDTO;
import com.evoke.example.entities.Employee;
import com.evoke.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;
    public Employee saveEmp(EmployeeDTO empDTO) {
        Employee emp = new Employee();
        emp = setDBMethod(emp, empDTO);
        empRepo.save(emp);
        return emp;

    }

    public List<Employee> saveEmps(List<EmployeeDTO> empDTO) {
        List<Employee> empList = empDTO.stream().map(x -> {
            Employee employee = new Employee();
            employee = setDBMethod(employee, x);
            return employee;
        }).collect(toList());
        empRepo.saveAll(empList);
        return empList;
    }

    public List<EmployeeDTO> findAll() {
        return
                empRepo.findAll().stream().map(emp -> {
                    EmployeeDTO empDTO = new EmployeeDTO();
                    empDTO = setDTOMethod(emp, empDTO);
                    return empDTO;
                }).collect(toList());

    }

    public EmployeeDTO findById(int id) {
        Employee employee = empRepo.findById(id);
        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO = setDTOMethod(employee, empDTO);
        return empDTO;

    }

    public Employee updateEmp(EmployeeDTO empDTO) {
        int k = empDTO.getId();
        Employee employee = empRepo.findById(k);
        employee = setDBMethod(employee, empDTO);
        empRepo.save(employee);
        return employee;
    }

    public String deleteEmp(Integer id) {

        empRepo.deleteById(id);
        if(empRepo.findById(id).isEmpty())
            return "Employee  Deleted";
        else
            return "Employee Not Deleted";
           }



    public Employee setDBMethod(Employee employee, EmployeeDTO empDTO) {
        employee.setAddress(empDTO.getAddress());
        employee.setAge(empDTO.getAge());
        employee.setName(empDTO.getName());
        employee.setSalary(empDTO.getSalary());
        return employee;
    }

    public EmployeeDTO setDTOMethod(Employee employee, EmployeeDTO empDTO) {
        empDTO.setAddress(employee.getAddress());
        empDTO.setAge(employee.getAge());
        empDTO.setSalary(employee.getSalary());
        empDTO.setName(employee.getName());
        return empDTO;

    }
}