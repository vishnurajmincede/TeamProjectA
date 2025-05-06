package com.TeamA.masterTable.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TeamA.masterTable.entity.Employee1;

public interface EmployeeRepo extends JpaRepository<Employee1, Long> {

	List<Employee1> findByIsDelete(boolean b);
	 @Query("SELECT e FROM Employee1 e WHERE e.employeeId = :Id AND e.isDelete = false")
    List<Employee1> FindById(Long Id);
    
    

}
