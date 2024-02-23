package com.project.bank.account.savings;

import com.project.bank.Bank;
import com.project.bank.account.Account;
import com.project.bank.account.AccountHolderDetails;


public class SavingsAccount extends Account {

	protected double minBal;
	
	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public SavingsAccount(long accNo, AccountHolderDetails ahd, double accBal,String accountDescription,double minBal) {
		super(accNo,ahd,accBal,accountDescription);
		this.minBal = minBal;
	}
	

	public double getMinBal() {
		return minBal;
	}

	public void setMinBal(double minBal) {
		this.minBal = minBal;
	}
	
	

	public int getTransactionsArrayIndex() {
		return transactionsArrayIndex;
	}

	public void setTransactionsArrayIndex(int transactionsArrayIndex) {
		this.transactionsArrayIndex = transactionsArrayIndex;
	}

	public double depositMoney(double amount) {
		// TODO Auto-generated method stub
		this.setDeposit(amount);
		this.setAccBal(this.getAccBal()+amount);
		return this.getAccBal();
		
	}

	public double withdrawMoney(double amount) {
		// TODO Auto-generated method stub
		if(amount>0 && this.getAccBal()>this.minBal)
		{
			this.setWithdraw(amount);
			this.setAccBal(this.getAccBal()-this.getWithdraw());
//			return this.getAccBal();
			return 1;
		}else {
//			System.out.println("Insufficient funds to withdraw..");
			return -1;
		}
		
	}
	
	public void getAccountDetails()
	{
		super.getAccountDetails();
		System.out.println("-----------------------------------------------");
		System.out.println("Minimum Balance to maintain  | "+this.minBal);
		System.out.println("-----------------------------------------------");
		
	}
	
	
	

	
	
	

}
