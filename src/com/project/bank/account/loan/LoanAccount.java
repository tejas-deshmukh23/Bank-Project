package com.project.bank.account.loan;

import com.project.bank.Bank;
import com.project.bank.account.Account;
import com.project.bank.account.AccountHolderDetails;

public class LoanAccount extends Account{

	double interestRate;
	double loanAmount;
	int loanTenure;
	
	public LoanAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public LoanAccount(long accNo, AccountHolderDetails ahd, double accBal,String accountDescription,double interestRate, double loanAmount, int loanTenure) {
		super(accNo,ahd,accBal,accountDescription);
		this.interestRate = interestRate;
		this.loanAmount = loanAmount;
		this.loanTenure = loanTenure;
		
		this.setAccBal(loanAmount+calculateInterest());//When we create a account the account balance will be 0 and we will take the loan from the bank 
		//so we will have a loan amount of what the bank has given us the loan
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	@Override
	public double depositMoney(double amount) {
		// TODO Auto-generated method stub
		
		this.setAccBal(getAccBal()-amount);
		return 1;
	}

	@Override
	public double withdrawMoney(double amount) {
		// TODO Auto-generated method stub
		if(amount>0 && this.getAccBal()>amount)
		{
			this.setAccBal(getAccBal()+amount);
			return 1;
		}
		return -1;
	}
	
	public double calculateInterest()
	{
		double interest;
		interest = (loanAmount)*(interestRate/100)*(loanTenure/12);
		return interest;
	}
	
	public void getAccountDetails()
	{
		super.getAccountDetails();
		
		System.out.println("-----------------------------------------------");
		System.out.println("Interest Rate                | "+this.getInterestRate());
		System.out.println("-----------------------------------------------");
		System.out.println("Loan Amount Taken            | "+this.getLoanAmount());
		System.out.println("-----------------------------------------------");
		System.out.println("Loan Tenure                  | "+this.getLoanTenure());
		System.out.println("-----------------------------------------------");
		System.out.println("loan Balance to pay          | "+this.getAccBal());
		System.out.println("-----------------------------------------------");
		
		
	}
	
}
