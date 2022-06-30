package com.evoke.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
//validations@pattern
@Builder
public class EmployeeDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    @Size(min = 3, message = "Name should be minimum three characters")
    private String name;
    @JsonProperty("salary")
    @NotBlank(message = "Blank Not Allowed")
    @Pattern(regexp = "^[0-9]*", message = "Should be Digits Only")
    @Min(value = 10000, message = "Salary Should be Greater than 10000")
    private Integer salary;
    @JsonProperty("age")
    @Min(value = 18, message = "Age should be greater than are equal to 18")
    @Max(value = 60, message = "Age should be less than 60")
    @Pattern(regexp = "^[0-9]*", message = "Should be Digits Only")
    private Integer age;
    @JsonProperty("address")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String name, Integer salary, Integer age, String address) {
        this.id = id;
        this.name = name;

        this.salary = salary;
        this.age = age;
        this.address = address;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}