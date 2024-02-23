package com.project.bank.account.current;

import com.project.bank.Bank;

import com.project.bank.account.Account;
import com.project.bank.account.AccountHolderDetails;
import com.project.bank.account.TransactionReport;

public class CurrentAccount extends Account {
	
	double overdraftLimit;
	
	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CurrentAccount(long accNo,AccountHolderDetails ahd,double accBal,String accountDescription,double overdraftLimit) {
		super(accNo,ahd,accBal,accountDescription);
//		System.out.println("in current account acc name: "+ ahd.getAccountname());
		this.overdraftLimit = overdraftLimit;
	}
	
	public CurrentAccount(long accNo,AccountHolderDetails ahd,double accBal,String accountDescription,TransactionReport[] trp,double overdraftLimit) {
		super(accNo,ahd,accBal,accountDescription,trp);
//		System.out.println("in current account acc name: "+ ahd.getAccountname());
		this.overdraftLimit = overdraftLimit;
	}
	
	



	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	public  double depositMoney(double amount)
	{
			this.setDeposit(amount);
			this.setAccBal(this.getAccBal()+amount);
			return this.getAccBal();
		
		
	}
	
	public double withdrawMoney(double amount)
	{
		if(amount>0 && this.getAccBal()+getOverdraftLimit()>amount)
		{
			this.setWithdraw(amount);
			this.setAccBal(this.getAccBal()-this.getWithdraw());
//			return this.getAccBal();
			return 1;
		}else {
			System.out.println("Insufficient funds to withdraw..");
			return -1;
		}
	}
	
	public void getAccountDetails()
	{
		super.getAccountDetails();
//		System.out.println("-----------------------------------------------");
		System.out.println("OverDraft Limit              | "+this.getOverdraftLimit());
		System.out.println("-----------------------------------------------");
//		System.out.println("IFSC Code                    | "+Bank.getIfsc());
		
		
		
		
	}

}
