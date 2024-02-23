package com.project.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyTransactionReport {
	
	private int noOfAccountCreated;
	private int noOfAccountDeleted;
	private int noOfDeposit;
	private int noOfWithdraw;
    private	double totalMoneyDeposit;
	private double totalMoneyWithdraw;
	
	private Date accountOpenDate;
	
	public DailyTransactionReport() {
		// TODO Auto-generated constructor stub
		
	}

	public DailyTransactionReport(int noOfAccountCreated, int noOfAccountDeleted, int noOfDeposit, int noOfWithdraw,
			double totalMoneyDeposit, double totalMoneyWithdraw) {
		super();
		this.noOfAccountCreated = noOfAccountCreated;
		this.noOfAccountDeleted = noOfAccountDeleted;
		this.noOfDeposit = noOfDeposit;
		this.noOfWithdraw = noOfWithdraw;
		this.totalMoneyDeposit = totalMoneyDeposit;
		this.totalMoneyWithdraw = totalMoneyWithdraw;
		
		this.accountOpenDate = new Date();
		
		
	}
	
	

	public Date getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public int getNoOfAccountCreated() {
		return noOfAccountCreated;
	}

	public void setNoOfAccountCreated(int noOfAccountCreated) {
		this.noOfAccountCreated = noOfAccountCreated;
	}

	public int getNoOfAccountDeleted() {
		return noOfAccountDeleted;
	}

	public void setNoOfAccountDeleted(int noOfAccountDeleted) {
		this.noOfAccountDeleted = noOfAccountDeleted;
	}

	public int getNoOfDeposit() {
		return noOfDeposit;
	}

	public void setNoOfDeposit(int noOfDeposit) {
		this.noOfDeposit = noOfDeposit;
	}

	public int getNoOfWithdraw() {
		return noOfWithdraw;
	}

	public void setNoOfWithdraw(int noOfWithdraw) {
		this.noOfWithdraw = noOfWithdraw;
	}

	public double getTotalMoneyDeposit() {
		return totalMoneyDeposit;
	}

	public void setTotalMoneyDeposit(double totalMoneyDeposit) {
		this.totalMoneyDeposit = totalMoneyDeposit;
	}

	public double getTotalMoneyWithdraw() {
		return totalMoneyWithdraw;
	}

	public void setTotalMoneyWithdraw(double totalMoneyWithdraw) {
		this.totalMoneyWithdraw = totalMoneyWithdraw;
	}
	
	public void display()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		System.out.printf("Transaction Report Printing Current Date :: ",sdf.format(this.accountOpenDate));
		System.out.println("No of Account Created : "+this.noOfAccountCreated);
		System.out.println("No of Account Created : "+this.noOfAccountDeleted);
		System.out.println("No of Account Created : "+this.noOfDeposit);
		System.out.println("No of Account Created : "+this.noOfWithdraw);
		System.out.println("No of Account Created : "+this.totalMoneyDeposit);
		System.out.println("No of Account Created : "+this.totalMoneyWithdraw);
	}
	
	
	
}
