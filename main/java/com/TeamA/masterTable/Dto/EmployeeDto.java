package com.TeamA.masterTable.Dto;



import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDto {

	 private Long employeeId;
		
		private String firstName;

	    private String lastName;

	    private String email;

	    private String phone;

	    private String gender;

	    private String designation; 

	    private String department;

	    private Double salary;
	
	    private Date createdDate;
	    
	    private boolean isDelete;
	    

	
	
	
}
