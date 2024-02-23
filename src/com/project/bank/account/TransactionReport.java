package com.project.bank.account;

import java.util.Date;

public class TransactionReport {
	Date date;
	int date2;
	double deposit;
	double withdraw;
	double totalBal;
	
	public TransactionReport() {
		// TODO Auto-generated constructor stub
	}
	
	

	public TransactionReport(int date2, double deposit, double withdraw) {
//		super();
		this.date2 = date2;
		this.deposit = deposit;
		this.withdraw = withdraw;
	}



	public TransactionReport(Date date, double deposit, double withdraw,double totalBal) {
		super();
		this.date = date;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.totalBal = totalBal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	
	public void ViewTransactionDetails()
	{
//		System.out.println("Date and Time\t\t\tDeposit\tWithdraw\tTotal Balance");
		System.out.println(this.date+"\t"+this.deposit+"\t\t"+this.withdraw+"\t\t"+this.totalBal);
		
	}
	
}
