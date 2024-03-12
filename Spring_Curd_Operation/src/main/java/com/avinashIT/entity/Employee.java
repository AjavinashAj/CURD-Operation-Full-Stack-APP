package com.avinashIT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity 
@Table(name="EMPLOYEE_TBL")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String firstName ;
    private String lastName ;
    private String department;
    private String gender;
    private String email;
    private Long phoneNo;

}
