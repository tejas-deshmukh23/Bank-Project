package com.project.bank.account;

import java.util.Date;

import com.project.bank.Bank;

public abstract class Account {
	//Declaring the static variable for deposit 
	///////////////////////////////////////////////
	public static int depositMoneyIndex;
	
	public int transactionsArrayIndex;//This index is to maintain the index of how transactionReport array for every object
	
	public static int getDepositMoneyIndex() {
		return depositMoneyIndex;
	}

	public static void setDepositMoneyIndex(int depositMoneyIndex) {
		Account.depositMoneyIndex = depositMoneyIndex;
	}
	////////////////////////////////////////////////////////////
	public static int WithdrawMoneyIndex;
	
	public static int getWithdrawMoneyIndex() {
		return WithdrawMoneyIndex;
	}

	public static void setWithdrawMoneyIndex(int withdrawMoneyIndex) {
		WithdrawMoneyIndex = withdrawMoneyIndex;
	}
	///////////////////////////////////////////////////////////

	
	long accNo;
//	AccountStatement acs;
	AccountHolderDetails ahd;
//	public AccountHolderDetails[] ahd2;
	double accBal;
	double deposit;
	double withdraw;
	String accountDescription;
	private Date accountOpenDate;
	
	public TransactionReport trp[];
	
	public TransactionReport[] getTrp() {
		return trp;
	}

	public void setTrp(TransactionReport[] trp) {
		this.trp = trp;
	}


	public Account() {
		// TODO Auto-generated constructor stub
		this.ahd = new AccountHolderDetails();
		trp = new TransactionReport[1000];
	}

	public Account(long accNo, AccountHolderDetails ahd, double accBal,String accountDescription) {
		super();
		this.accNo = accNo;
		this.ahd = ahd;
		this.accBal = accBal;
		this.accountDescription = accountDescription;
		trp = new TransactionReport[1000];
		
		this.transactionsArrayIndex=0;
		
		this.accountOpenDate=new Date();
//		System.out.println("in account acc name: "+ this.ahd.getAccountname());
//		System.out.println("in account acc name: "+ ahd.getAccountname());
		
	}
	
	

	public Account(long accNo, AccountHolderDetails ahd, double accBal,String accountDescription, TransactionReport[] trp) {
		super();
		this.accNo = accNo;
		this.ahd = ahd;
		this.accBal = accBal;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.accountDescription = accountDescription;
		this.trp = trp;
		this.accountOpenDate=new Date();
	}
	

	public Date getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public AccountHolderDetails getAhd() {
		return ahd;
	}

	public void setAhd(AccountHolderDetails ahd) {
		this.ahd = ahd;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}
	
	

	public double getDeposit() {
		return deposit;
	}
	
	

//	public void setDeposit(double deposit) {
//		this.deposit = deposit;
//	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getWithdraw() {
		return withdraw;
	}
	
	

//	public void setWithdraw(double withdraw) {
//		this.withdraw = withdraw;
//	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public void display()
	{
		System.out.println("Account Number : "+this.accNo);
		System.out.println("Account Balance : "+this.accBal);
//		System.out.println("Account Holder Name       :"+ahd.getAccountname());
//		System.out.println("Account Holder Location   :"+ahd.getLocation());
//		System.out.println("Account Holder contactno  :"+ahd.getContactno());
		ahd.display();
	}
	
	public void getAccountDetails()
	{
		System.out.println("-----------------------------------------------");
		System.out.println("BANK Name                    | "+Bank.getBankName());
		System.out.println("-----------------------------------------------");
		System.out.println("IFSC Code                    | "+Bank.getIfsc());
		System.out.println("-----------------------------------------------");
		System.out.println("Account Number               | "+this.getAccNo());
		System.out.println("-----------------------------------------------");
		System.out.println("Account Holder Name          | "+ahd.getAccountname());
		System.out.println("-----------------------------------------------");
		System.out.println("Account Holder Address       | "+ahd.getLocation());
		System.out.println("-----------------------------------------------");
		System.out.println("Account Holder Contact       | "+ahd.getContactno());
		System.out.println("-----------------------------------------------");
		System.out.println("Account Description          | "+this.accountDescription);
		System.out.println("-----------------------------------------------");
		System.out.println("Account Balance              | "+this.accBal);
		System.out.println("-----------------------------------------------");
		
		
	}
	
	
	
	//Calculate Total Balance
//	public double totalBal()
//	{
//		return
	//	}
	public int getTransactionsArrayIndex() {
		return transactionsArrayIndex;
	}

	public void setTransactionsArrayIndex(int transactionsArrayIndex) {
		this.transactionsArrayIndex = transactionsArrayIndex;
	}

	public abstract double depositMoney(double amount);
	
	public abstract double withdrawMoney(double amount);
	
	
}
