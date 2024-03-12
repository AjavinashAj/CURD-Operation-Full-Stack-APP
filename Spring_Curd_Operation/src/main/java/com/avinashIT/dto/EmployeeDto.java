package com.avinashIT.dto;

import lombok.Data;

@Data
public class EmployeeDto {

	private String firstName ;
    private String lastName ;
    private String department;
    private String gender;
    private String email;
    private Long phoneNo;
}
