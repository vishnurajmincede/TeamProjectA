package com.TeamA.masterTable.entity;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
	public class Employee1 {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
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
