package com.project.bank;
import com.project.bank.account.Account;
public class Bank {
	
	static String bankName;
	static String ifsc;
	Account acc;
	DailyTransactionReport dtr;
	
	public Bank() {
		// TODO Auto-generated constructor stub
		dtr = new DailyTransactionReport();
//		acc = new Account();
	}

	public Bank(Account acc, DailyTransactionReport dtr) {
		super();
		this.acc = acc;
		this.dtr = dtr;
	}

	public static String getBankName() {
		return bankName;
	}

	public static void setBankName(String bankName) {
		Bank.bankName = bankName;
	}

	public static String getIfsc() {
		return ifsc;
	}

	public static void setIfsc(String ifsc) {
		Bank.ifsc = ifsc;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public DailyTransactionReport getDtr() {
		return dtr;
	}

	public void setDtr(DailyTransactionReport dtr) {
		this.dtr = dtr;
	}
	
	public void display()
	{
		System.out.println("Bank Name :    "+this.bankName);
		System.out.println("IFSC Code :    "+this.ifsc);
		
		dtr.display();
		acc.display();
		
	}
	
}
