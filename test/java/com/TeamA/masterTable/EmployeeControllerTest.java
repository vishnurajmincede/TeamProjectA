package com.TeamA.masterTable;


import com.TeamA.masterTable.Controller.EmployeeController;
import com.TeamA.masterTable.Dto.EmployeeDto;
import com.TeamA.masterTable.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    
    
    
    
    
    
    
    
    
    
    
    
    @Test
    void testGetAllEmployees() throws Exception {
        EmployeeDto emp1 = new EmployeeDto();
        emp1.setEmployeeId(1L);
        emp1.setFirstName("John");

        EmployeeDto emp2 = new EmployeeDto();
        emp2.setEmployeeId(2L);
        emp2.setFirstName("Jane");

        List<EmployeeDto> employees = Arrays.asList(emp1, emp2);

        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/EmployeeProject/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[1].firstName").value("Jane"));
    }

    @Test
    void testGetEmployeeById() throws Exception {
        EmployeeDto emp = new EmployeeDto();
        emp.setEmployeeId(1L);
        emp.setFirstName("Alice");

        when(employeeService.getEmployeeById(1L)).thenReturn(emp);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/EmployeeProject/getById/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"));
    }
    
}
