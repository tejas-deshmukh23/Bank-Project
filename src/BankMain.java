import com.project.bank.Bank;

import com.project.bank.DailyTransactionReport;
import com.project.bank.account.Account;
import com.project.bank.account.AccountHolderDetails;
import com.project.bank.account.savings.SavingsAccount;
import com.project.bank.account.savings.salary.SalaryAccount;
import com.project.bank.account.TransactionReport;
import com.project.bank.account.current.CurrentAccount;
import com.project.bank.account.loan.LoanAccount;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.management.DescriptorAccess;
public class BankMain {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/////////////////////////////Global variables for keeping the track of saving account transaction details///////////////
		int depositT=0;
		int withdrawT=0;
		
		Bank.setBankName("SBI BANK");
		Bank.setIfsc("MAHGB0008010");
		
		//this index is for accessing the values in Transaction Details array
		Account.setDepositMoneyIndex(0);
		
		//this index is for accessing the values in Transaction Details array
		Account.setWithdrawMoneyIndex(0);
		
		Scanner sc = new Scanner(System.in);
//		
		Account[] acc = new Account[100];
		int i=0;
		
//		System.out.println("Enter Account No : ");
//		long accNo = sc.nextLong();
//		
//		System.out.println("Enter Account bal : ");
//		double accBal = sc.nextDouble();
//		
//		long contact;
//		contact=8010489800l;//we need to add l after intvalue while using long
//		
//		Bank b = new Bank(new Account(accNo,new AccountHolderDetails("Tejas","Sangamner",contact),accBal),new DailyTransactionReport(23,23,23,23,23,23));
//		b.display();
		int exit=1;
		while(exit!=0)
		{
			System.out.println("\t\t1.Create Current Account                5.Deposit");
			System.out.println("\t\t2.Create Saving Account                 6.Withdraw");
			System.out.println("\t\t3.Create Salary Account                 7.Total Balance");
			System.out.println("\t\t4.Create Loan Account                   8.OverDraft limit check");
			System.out.println("--------------------------------------");
			System.out.print("Enter your choice : ");
			int ch = sc.nextInt();
			System.out.println("--------------------------------------");
			
			switch (ch) {
				case 0:	{
					System.out.println("Closing System...");
					break;
				}
				case 1: {
					//Create Current Account
					System.out.println("Enter the Overdraft limit : ");
					double overdraft = sc.nextInt();
					System.out.println("Enter the account Number : ");
					long accNo = sc.nextLong();
					
					System.out.println("Enter the account holder name : ");
					sc.nextLine();
					
					String name = sc.next();
					
					System.out.println("Enter the account holder location : ");
					sc.nextLine();
					String location = sc.nextLine();
					
					System.out.println("Enter the account holder contact : ");
					
					long contact = sc.nextLong();
					System.out.println("Deposit money in account : ");
					double amt = sc.nextDouble();
					
//					System.out.println("Enter the account type : ");
					String accountDescription="Current";
					
					
					if(amt>=5000)
					{			
						acc[i] = new CurrentAccount(accNo,new AccountHolderDetails(name,location,contact),amt,accountDescription,overdraft);
						int transactionArrayIndex = acc[i].getTransactionsArrayIndex();
						acc[i].trp[acc[i].getTransactionsArrayIndex()] = new TransactionReport(new Date(),amt,0,acc[i].getAccBal()); 
//						int tempi = Account.getDepositMoneyIndex();
//						Account.setDepositMoneyIndex(++tempi);
						acc[i].setTransactionsArrayIndex(++transactionArrayIndex);
						acc[i].getAccountDetails();
						i++;
					}else {
						System.out.println("Enter amount atleast 5000 to create a account in a bank");
					}
					
					break;
				}
				
				case 2:{
					
					//Create Saving Account
					
					double minBal = 10000;
					
					System.out.println("Enter the account Number : ");
					long accNo = sc.nextLong();
					
					System.out.println("Enter the account holder name : ");
					sc.nextLine();
					
					String name = sc.next();
					
					System.out.println("Enter the account holder location : ");
					sc.nextLine();
					String location = sc.nextLine();
					
					System.out.println("Enter the account holder contact : ");
					
					long contact = sc.nextLong();
					System.out.println("Deposit money in account : ");
					double amt = sc.nextDouble();
					
//					System.out.println("Enter the account type : ");
					String accountDescription="Saving";
					
					if(amt>=10000)
					{
						acc[i] = new SavingsAccount(accNo,new AccountHolderDetails(name,location,contact),amt,accountDescription,minBal);
						int transactionArrayIndex = acc[i].getTransactionsArrayIndex();
						acc[i].trp[transactionArrayIndex] = new TransactionReport(new Date(),amt,0,acc[i].getAccBal()); 
						acc[i].setTransactionsArrayIndex(++transactionArrayIndex);
						acc[i].getAccountDetails();
						i++;
//						acc[i].getAccountDetails();
						////////////This algorithm is for maintaining the count of deposits done//////////////////////////
//						int tempi = Account.getDepositMoneyIndex();
//						System.out.println("Account.getDepositMoneyIndex() is "+tempi);
//						Account.setDepositMoneyIndex(++depositT);
						
						/////////////////////////////////////////////////////////////////////////////////////////////////
						
					}else {
						System.out.println("Enter minimum 10000 to create a saving account");
					}
					
					break;
				}
				
				//////////////////////////////////////////////////////////////////////////////
				case 3: {
					
					//create salary Account
					
					double minBal = 10000;
					
					System.out.println("Enter the account Number : ");
					long accNo = sc.nextLong();
					
					System.out.println("Enter the account holder name : ");
					sc.nextLine();
					
					String name = sc.next();
					
					System.out.println("Enter the account holder location : ");
					sc.nextLine();
					String location = sc.nextLine();
					
					System.out.println("Enter the account holder contact : ");
					
					long contact = sc.nextLong();
					System.out.println("Deposit money in account : ");
					double amt = sc.nextDouble();
					
//					System.out.println("Enter the account type : ");
					String accountDescription="Salary";
					
					boolean accountFrozen = false;
					
					if(amt>=10000)
					{
						acc[i] = new SalaryAccount(accNo,new AccountHolderDetails(name,location,contact),amt,accountDescription,minBal,accountFrozen);
						int transactionArrayIndex = acc[i].getTransactionsArrayIndex();
						acc[i].trp[transactionArrayIndex] = new TransactionReport(new Date(),amt,0,acc[i].getAccBal()); 
						//////////////////////////////
			
						//////////////////////////////
						acc[i].setTransactionsArrayIndex(++transactionArrayIndex);
						acc[i].getAccountDetails();
						
						i++;
						
						/////////////////////////////////////////////////////////////////////////////////////////////////
						
					}else {
						System.out.println("Enter minimum 10000 to create a saving account");
					}
					
					break;
					
				}
				//////////////////////////////////////////////////////////////////////////////
				case 4: {
					
					//create Loan Account
					

					System.out.println("Enter the account Number : ");
					long accNo = sc.nextLong();
					
					System.out.println("Enter the account holder name : ");
					sc.nextLine();
					
					String name = sc.next();
					
					System.out.println("Enter the account holder location : ");
					sc.nextLine();
					String location = sc.nextLine();
					
					System.out.println("Enter the account holder contact : ");
					
					long contact = sc.nextLong();
					System.out.println("Take Loan From bank : ");
					double amt = sc.nextDouble();
					
//					System.out.println("Enter the account type : ");
					String accountDescription="Loan Account";

					System.out.println("Enter the interest Rate for the loan Amount : ");
					double interestRate = sc.nextDouble();
					
					System.out.println("Enter the loanTenure for the loanAccount : ");
					int loanTenure = sc.nextInt();
					
					double loanAmount = amt;
					
					
					if(loanAmount>=10000)
					{
						acc[i] = new LoanAccount(accNo,new AccountHolderDetails(name,location,contact),amt,accountDescription,interestRate,loanAmount,loanTenure);
						int transactionArrayIndex = acc[i].getTransactionsArrayIndex();
						acc[i].trp[transactionArrayIndex] = new TransactionReport(new Date(),amt,0,acc[i].getAccBal()); 
						//////////////////////////////
			
						//////////////////////////////
						acc[i].setTransactionsArrayIndex(++transactionArrayIndex);
						acc[i].getAccountDetails();
						
						i++;
						
						/////////////////////////////////////////////////////////////////////////////////////////////////
						
					}else {
						System.out.println("You'll need to take atleast 10000 loan to create a loan amount");
					}
					
					break;
				}
				//////////////////////////////////////////////////////////////////////////////
				
				case 5: {
//					System.out.println("In which account you want to deposit : ");
//					System.out.println("1:Current                          2.Saving");
//					System.out.println("3:Salary                           4.Loan");
					System.out.println("press (1) to deposit in : ");
					System.out.println("1:Current/saving/Salary/loan");
					System.out.println("5:getAccountTransactionReport     ");
					System.out.println("---------------------------");
					System.out.print("Enter your choice : ");
					int choice = sc.nextInt();
					System.out.println("---------------------------");
					
					switch(choice)
					{
//						
						/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						case 1: {
							///////////////////////////Saving account////////////////////////////////////
							System.out.println("Enter your account no to deposit in your account : ");
							long accNo = sc.nextLong();
//							LocalDate lastTransactionDate = LocalDate.now();
//							System.out.println(ChronoUnit.DAYS.between(lastTransactionDate,LocalDate.now()));
							////////////////////////////////////////////////////
							try {
								
								int index = searchAccount(acc,accNo);
								if(index!=-1)
								{
									double amount=0;
									System.out.println("Enter the amount to deposit : ");
									amount = sc.nextDouble();
									acc[index].depositMoney(amount);
									///////////////////////////////////////////////
									int transactionArrayIndex = acc[index].getTransactionsArrayIndex();
									acc[index].trp[transactionArrayIndex]=new TransactionReport(new Date(),amount,0,acc[index].getAccBal());
//									int index2 = Account.getDepositMoneyIndex();//Here we are updating the static variable index by firstly taking it in a local variable index2 and then by doing index2++ i.e we do Account.setDepositMoneyIndex(index2++);
									System.out.println("Date and Time\t\t\tDeposit\t\tWithdraw\tTotal Balance");
									acc[index].trp[transactionArrayIndex].ViewTransactionDetails();
									acc[index].setTransactionsArrayIndex(++transactionArrayIndex);
									
//									++depositT;
//									Account.setDepositMoneyIndex(++index2);
									///////////////////////////////////////////////
									
								}else {
									
									System.out.println("Account number not found...");
									
								}
								
							}catch(Exception e)
							{
								System.out.println("Sorry can't complete your request, try again with proper Details..");
//								System.out.println("No accounts present in your bank...");
//								e.printStackTrace();
							}
							
							break;
						}
						////////////////////////////////////////////////////////////////////////////////////////////
						case 5: {
							System.out.println("Enter your account Number to get Transaction Details of account : ");
							long accNo = sc.nextLong();
							try {
								int index = searchAccount(acc,accNo);
//								System.out.println("index in case 5 is : "+index);
								if(index!=-1)
								{
									System.out.println("Date and Time\t\t\tDeposit\t\tWithdraw\tTotal Balance");
									int i2=0;
									for(i2=0;i2<acc[index].getTransactionsArrayIndex();i2++)//getDepositMoney() function will return that how many times we have deposited money in our bankAccount
									{
										
										acc[index].trp[i2].ViewTransactionDetails();
									}
									
//									acc[0].getAccountDetails();
									
								}else {
									System.out.println("No account found with this index");
								}
							}catch(Exception e)
							{
								System.out.println("No account present in your bank...");
								e.printStackTrace();
							}
							break;
						}
					}
					
					break;
				}
				case 6: {
					//Withdraw Money////////////////////////////////////////////////
//					System.out.println("From which account you want to withdraw : ");
//					System.out.println("1:Current                          2.Saving");
//					System.out.println("3:Salary                           4.Loan");
					System.out.println("press (1) to withdraw from below accounts");
					System.out.println("1.Current/Saving/Salary/Loan");
					System.out.println("--------------------------------------------");
					System.out.println("5:getAccountTransactionReport      ");
					System.out.println("---------------------------");
					System.out.print("Enter your choice : ");
					int choice = sc.nextInt();
					System.out.println("---------------------------");
					///////////////////////////////////////////////////
					switch(choice)
					{
						case 1:{
							
							//Withdraw
							
							System.out.println("Enter your account number to withdraw the balance from your account : ");
							long accNo = sc.nextLong();
							
							try {
								int index = searchAccount(acc, accNo);
								if(index!=-1)
								{
									double amount=0;
									System.out.println("Enter the amount to Withdraw : ");
									amount = sc.nextDouble();
									if(acc[index].withdrawMoney(amount)!=-1)
									{
										int transactionArrayIndex=acc[index].getTransactionsArrayIndex();
										
										acc[index].trp[transactionArrayIndex]=new TransactionReport(new Date(),0,amount,acc[index].getAccBal());
										
										System.out.println("Date and Time\t\t\tDeposit\t\tWithdraw\t\tTotal Balance");
										acc[index].trp[transactionArrayIndex].ViewTransactionDetails();
										
										acc[index].setTransactionsArrayIndex(++transactionArrayIndex);
//										System.out.println("index 2 before ++index2");

//										System.out.println("index 2 after ++index2");
										
										
									}else {
										System.out.println("Insufficient funds to withdraw..");
									}
								}else {
									System.out.println("Account Number not found...");
								}
							}catch(Exception e)
							{
//								System.out.println("No accounts present in your bank...");
								System.out.println("Sorry can't complete your request, try again with proper Details..");
							}
							
							
							break;
						}
						case 5: {
							//Get Account Transaction Report
							
							//////////////////////////////////////////////////////////////
							System.out.println("Enter your account Number to find the account : ");
							long accNo = sc.nextLong();
							try {
								int index = searchAccount(acc,accNo);
								if(index!=-1)
								{	
									int transactionArrayIndex = acc[index].getTransactionsArrayIndex();									
									int i2=0;//////////////////////////////////////////this Account.getWithdrawIndex is a static function which has the count of all the Withdraws done by all the people in a bank so it will be better to find new  way than this to store count of how many withdraws happen for a particular account
									System.out.println("Date and Time\t\t\tDeposit\t\tWithdraw\tTotal Balance");
									for(i2=0;i2<transactionArrayIndex;i2++)//getDepositMoney() function will return that how many times we have deposited money in our bankAccount
									{
										acc[index].trp[i2].ViewTransactionDetails();
									}
								}else {
									System.out.println("No account found with this index");
								}
							}catch(Exception e)
							{
								System.out.println("No account present in your bank");
							}
							/////////////////////////////////////////////////////////////
							
							break;
						}
					}
					break;
					/////////////////////////////////////////////////
					
				}
				
				case 7 :{
					
					//Check Account Total balance
					
					System.out.println("Enter the account number : ");
					long accNo = sc.nextLong();
					
					int index = searchAccount(acc, accNo);
					if(index!=-1) {
						System.out.println("Account Balance :: "+acc[index].getAccBal());
					}else {
						System.out.println("Account not found");
					}
					
					
					break;
				}
				
				case 8:{
					
					//Overdraft Limit Check
					
					System.out.println("Enter the account Number to check the Overdraft Limit : ");
					long accNo = sc.nextLong();
					int index = searchAccount(acc, accNo);
					if(index!=-1) {
						
//						if(acc[index].getAccountDescription().equals("Current"))
//						{
							//Downcasting account to current account to access the special functions of CurrentAccount
//							CurrentAccount ca = (CurrentAccount)acc[index];
//							System.out.println("Overdraft Limit :: "+ca.getOverdraftLimit());
							
							//or
							
							if(acc[index] instanceof CurrentAccount) {
								//Downcasting account to current account to access the special functions of CurrentAccount
								CurrentAccount ca = (CurrentAccount)acc[index];
								System.out.println("Overdraft Limit :: "+ca.getOverdraftLimit());
							}
							else {
								System.out.println("AccountType : '"+acc[index].getAccountDescription()+"' doesn't have Overdraft Limit");
							}
//						}
						
					}else {
						System.out.println("Account with this account number not found");
					}
					
					break;
				}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + ch);
			}
			
		}
		
		
		
		
		
		

	}
	
	public static int searchAccount(Account[] acc,long accNo)
	{
		int i=0;
		for(i=0;i<acc.length;i++)
		{
			if(acc[i].getAccNo()==accNo)
			{
				return i;
			}
		}
		return -1;
	}

}
