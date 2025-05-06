package com.TeamA.masterTable.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeamA.masterTable.Dto.EmployeeDto;
import com.TeamA.masterTable.Service.EmployeeService;

@RestController
@RequestMapping("api/EmployeeProject")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	//Post and update
		@PostMapping("/")
		public ResponseEntity<Long> createUpdate(@RequestBody EmployeeDto employeeDto) {
			return ResponseEntity.ok(employeeService.createUpdateEmployee(employeeDto));
		}
		
		 @GetMapping("/getAll")
		    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		        return ResponseEntity.ok(employeeService.getAllEmployees());
		    }

		    // Get By ID
		    @GetMapping("/getById/{id}")
		    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		        EmployeeDto dto = employeeService.getEmployeeById(id);
		        if (dto != null) {
		            return ResponseEntity.ok(dto);
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    }

		    // Delete 
		    @DeleteMapping("/delete/{id}")
		    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		        employeeService.deleteEmployee(id);
		        return ResponseEntity.ok("Employee with id " + id + " deleted successfully (soft delete)");
		    }
	
	
}
