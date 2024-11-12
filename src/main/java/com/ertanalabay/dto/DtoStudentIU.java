package com.ertanalabay.dto;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

	@NotEmpty(message = "First Name alanı boş bırakılamaz!")
	@Min(value = 3, message = "Alan ismi 3 karakterden büyük olmalı!")
	@Max(value = 10,message = "Alan ismi 10 karakterden küçük olmalı!" )
	private String firstName;
	
	private String lastName;
	
	private Date birthOfDate;
	
}
