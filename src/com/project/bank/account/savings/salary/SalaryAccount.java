package com.project.bank.account.savings.salary;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.project.bank.account.AccountHolderDetails;
import com.project.bank.account.TransactionReport;
import com.project.bank.account.savings.SavingsAccount;

public class SalaryAccount extends SavingsAccount {
	
	boolean frozen;
	LocalDate lastTransactionDate;
	
	
	public SalaryAccount() {
		// TODO Auto-generated constructor stub
		
	}

	public SalaryAccount(long accNo, AccountHolderDetails ahd, double accBal,String accountDescription,double minBal,boolean frozen) {
		super(accNo,ahd,accBal,accountDescription,minBal);
		this.frozen = false;
		this.lastTransactionDate = LocalDate.now();
	}

	public boolean isFrozen() {
		return frozen;    
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	
	public long getDateDiff()
	{
		long daysDiff = ChronoUnit.DAYS.between(lastTransactionDate,LocalDate.now());
		return daysDiff;
	}
	
	public double depositMoney(double amount) {
		// TODO Auto-generated method stub
//		System.out.println("1.hi");
////		long daysDiff = this.getDateDiff();
//		System.out.println("2.hihi");
//		if(ChronoUnit.DAYS.between(lastTransactionDate,LocalDate.now())>60)//here we have not given the value to lastTransactionDetails till now so here if we not initialized last TransactionDate it willl give error so will need to innititalize it in the constructor where we made our first transaction at the time of account creation
		{
			this.setFrozen(true);
//			System.out.println("3.hi");
			
		}
		
		if(!this.isFrozen())//i.e if the value of frozen is false then only the if block will execute
		{
			System.out.println("4.hi");
			this.setDeposit(amount);
			this.setAccBal(this.getAccBal()+amount);
			return this.getAccBal();
		}else {
			System.out.println("your account is frozen because you have not done any transactions from 2 months ");
			return -1;
		}
		
	}

	public double withdrawMoney(double amount) {
		// TODO Auto-generated method stub
		long daysDiff = this.getDateDiff();
		if(daysDiff>60)
		{
			this.setFrozen(true);
			
		}
		if(!this.isFrozen())
		{
			if(amount>0 && this.getAccBal()>this.minBal)
			{
				
				this.setWithdraw(amount);
				this.setAccBal(this.getAccBal()-this.getWithdraw());
//				return this.getAccBal();
				return 1;
			}else {
//				System.out.println("Insufficient funds to withdraw..");
				return 0;
			}
			
		}else {
			System.out.println("your account is frozen because you have not done any transactions from 2 months ");
			return -1;
		}
		
		
		
	}
	
	
	
}
