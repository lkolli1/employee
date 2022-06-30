package com.evoke.example.controller;
import com.evoke.example.dto.EmployeeDTO;
import com.evoke.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
   private EmployeeService empService;
    @PostMapping("/employee")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        HttpHeaders resHeaders = new HttpHeaders();
        return new ResponseEntity(empService.saveEmp(employeeDTO), resHeaders, HttpStatus.CREATED);
    }
    @PostMapping("/employees")
    public ResponseEntity<String> saveEmployees(@RequestBody List<EmployeeDTO> empList) {
        HttpHeaders resHeaders = new HttpHeaders();
        return new ResponseEntity(empService.saveEmps(empList), resHeaders, HttpStatus.CREATED);

    }
    @GetMapping("/employees")
    public List<EmployeeDTO> findAll() {
        return empService.findAll();
    }
    @GetMapping("/employee/{id}")
    public EmployeeDTO findById(@PathVariable Integer id) {
        return empService.findById(id);
    }
    @PutMapping("/employee")
    public ResponseEntity<String> updateEmp(@RequestBody EmployeeDTO empDto) {
        HttpHeaders resHeaders = new HttpHeaders();
        return new ResponseEntity(empService.updateEmp(empDto), resHeaders, HttpStatus.CREATED);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Integer> deleteEmp(@PathVariable int id) {
        HttpHeaders resHeaders = new HttpHeaders();
        return new ResponseEntity(empService.deleteEmp(id), resHeaders, HttpStatus.OK);
    }

}