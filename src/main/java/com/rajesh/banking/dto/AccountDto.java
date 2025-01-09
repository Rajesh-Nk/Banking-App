package com.rajesh.banking.dto;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor
//public class AccountDto {
//	private Long accountNumber;
//	private String accountHolderName;
//	private double balance; 
//}

public record AccountDto(Long accountNumber,String accountHolderName,double balance) {
	
}
