package com.TeamA.masterTable.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeamA.masterTable.Dto.EmployeeDto;
import com.TeamA.masterTable.entity.Employee1;
import com.TeamA.masterTable.repository.EmployeeRepo;
@Service
public class EmployeeService {


	    @Autowired
	    private EmployeeRepo employeeRepository;

	    public Long createUpdateEmployee(EmployeeDto employeeDto) {

	        Employee1 employee = null;
	        Date now = new Date();

	        if (employeeDto.getEmployeeId() == null || employeeDto.getEmployeeId() == 0) {
	            employee = new Employee1();
	            
	            employee.setCreatedDate(now);
	       
	        } else {
	            employee = employeeRepository.findById(employeeDto.getEmployeeId())
	                    .orElse(new Employee1());
	        }

	        // Common fields (set for both create & update)
	        employee.setFirstName(employeeDto.getFirstName());
	        employee.setLastName(employeeDto.getLastName());
	        employee.setEmail(employeeDto.getEmail());
	        employee.setPhone(employeeDto.getPhone());
	        employee.setGender(employeeDto.getGender());
	        employee.setDesignation(employeeDto.getDesignation());
	        employee.setDepartment(employeeDto.getDepartment());
	        employee.setSalary(employeeDto.getSalary());
	 

	        // Save
	        Employee1 saved = employeeRepository.save(employee);
	        return saved.getEmployeeId();
	    }

	    public List<EmployeeDto> getAllEmployees() {
	        List<EmployeeDto> dtoList = new ArrayList<>();
	        List<Employee1> empList = employeeRepository.findByIsDelete(false);

	        for (Employee1 emp : empList) {
	            EmployeeDto dto = new EmployeeDto();
	            dto.setEmployeeId(emp.getEmployeeId());
	            dto.setFirstName(emp.getFirstName());
	            dto.setLastName(emp.getLastName());
	            dto.setEmail(emp.getEmail());
	            dto.setPhone(emp.getPhone());
	            dto.setGender(emp.getGender());
	            dto.setDesignation(emp.getDesignation());
	            dto.setDepartment(emp.getDepartment());
	            dto.setSalary(emp.getSalary());
	            dto.setCreatedDate(emp.getCreatedDate());
	            dto.setDelete(emp.isDelete());
	            dtoList.add(dto);
	        }
	        return dtoList;
	    }

	    public EmployeeDto getEmployeeById(Long id) {
	        Employee1 emp = employeeRepository.findById(id).orElse(null);

	        if (emp != null && !emp.isDelete()) {
	            EmployeeDto dto = new EmployeeDto();
	            dto.setEmployeeId(emp.getEmployeeId());
	            dto.setFirstName(emp.getFirstName());
	            dto.setLastName(emp.getLastName());
	            dto.setEmail(emp.getEmail());
	            dto.setPhone(emp.getPhone());
	            dto.setGender(emp.getGender());
	            dto.setDesignation(emp.getDesignation());
	            dto.setDepartment(emp.getDepartment());
	            dto.setSalary(emp.getSalary());
	            dto.setCreatedDate(emp.getCreatedDate());
	            dto.setDelete(emp.isDelete());
	            return dto;
	        }
	        return null;
	    }

	    public void deleteEmployee(Long id) {
	        Employee1 emp = employeeRepository.findById(id).orElse(null);
	        if (emp != null) {
	            emp.setDelete(true);
	            employeeRepository.save(emp);
	        }
	    }
	}
	    
	    
	

