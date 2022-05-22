package com.Comp.Controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Comp.Exception.*;
import com.Comp.Model.*;
import com.Comp.Repository.*;
public class EmployeeController {
	private EmployeeRepository EmployeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.EmployeeRepository = EmployeeRepository;
    }

    /**
     * @return It returns list of employees based on salary in descending order, If two employees salaries are same it fetches data in ascending order based on their names.
     */
    @GetMapping("/employees")
    Iterable<Employee> getAllEmployees() {
        return EmployeeRepository.findAll(Sort.by(Sort.Order.desc("salary"), Sort.Order.asc("name")));
    }

    /**
     * @param newEmployee New Employee to be added into database.
     * @return Newly added employee otherwise throws EmployeeExistedException.
     */
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        if (EmployeeRepository.existsById(newEmployee.getId()))
            throw new EmployeeExistedException();
        else return EmployeeRepository.save(newEmployee);
    }

    /**
     * @param id Id of the Employee to fetch.
     * @return it id exists return employee otherwise it throws EmployeeNotFoundException.
     */
    @GetMapping("/employees/{id}")
    Employee getEmployee(@PathVariable Long id) {
        return EmployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * @param id id of the employee to delete employee data in database.
     */
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        EmployeeRepository.deleteById(id);
    }

    /**
     * Updates employee salary as path variable.
     *
     * @param id Id of the employee.
     * @param salary New salary for this employee.
     * @return returns ok response with updated salary otherwise returns EmployeeNotFoundException
     */
    @PutMapping("/employees/upSalary/{id}/{salary}")
    ResponseEntity<Employee> updateSalary(@PathVariable long id, @PathVariable int salary) {
        Employee employee = getEmployee(id);
        employee.setSalary(salary);
        EmployeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }
}
