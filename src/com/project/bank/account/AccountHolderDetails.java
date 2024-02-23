package com.project.bank.account;

import java.math.BigInteger;

public class AccountHolderDetails {

	private String accountName;
	private String location;
	private long contactNo;
	public AccountHolderDetails()
	{
//		this.accountName="not given";
//		this.location="not given";
//		this.contactNo=0;	
	}
	public AccountHolderDetails(String accountName, String location, long contactNo) {
//		super();
		
		this.accountName = accountName;
//		System.out.println("in acc holder details acc name: "+ this.accountName);
//		System.out.println("in acc holder details acc name: "+ accountName);
		this.location = location;
		this.contactNo = contactNo;
	}
	public String getAccountname() {
		return accountName;
	}
	public void setAccountname(String accountname) {
		this.accountName = accountname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getContactno() {
		return contactNo;
	}
	public void setContactno(long contactno) {
		this.contactNo = contactno;
	}
	public void display()
	{
		System.out.println("Account Holder Name       :"+ accountName);
		System.out.println("Account Holder Location   :"+ location);
		System.out.println("Account Holder contactno  :"+ contactNo);
	}

	
}
