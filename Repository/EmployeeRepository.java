package com.Comp.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.Comp.Repository.*;
import com.Comp.*;
import com.Comp.Model.Employee;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
    Employee findById(long id);
    }