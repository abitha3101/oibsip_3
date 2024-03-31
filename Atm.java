package atm_interface;

import java.util.Scanner;

class Bank{
	Scanner m=new Scanner(System.in);
	float balance=50000f;
	float amount=0;
	String transaction_history="";
	int acc_no;
	String name;
	String user_id;
	String pin;
	int transaction=0;
	public void Register() {
		System.out.println("Enter your name:");
		name=m.next();
		System.out.println("Enter your User Id:");
		user_id=m.next();
		System.out.println("Enter your Pin");
		pin=m.next();
		System.out.println("Enter your account number:");
		acc_no=m.nextInt();
		System.out.println("Registration Successfull...");
	}

	public boolean login() {
		boolean logins=false;
		Scanner b=new Scanner(System.in);
		while(!logins) {
			System.out.println("Enter your User Id:");
			String user_idl=b.next();
			if(user_idl.equals(user_id)) {
				System.out.println("Enter your Pin:");
				String pinl=b.next();
				if(pinl.equals(pin)) {
					System.out.println("Welcome "+name);
					logins=true;
				}
				else {
					System.out.println("Incorrect password");
				}
			}
			else {
				System.out.println("User Id not found");
			}
		}
		return logins;
	}
	public void withdraw() {
		
		System.out.println("Enter the amount to withdraw:");
		this.amount=m.nextFloat();
		try {
		if(balance>=amount) {
			transaction++;
			balance-=amount;
			System.out.println("Amount Rs."+amount+" withdrawn successfully");
			String msg="Rs."+amount+" "+" withdrawn\n";
			transaction_history=transaction_history.concat(msg);
		}
		else if(amount<30000) {
			System.out.println("The withdrawn amount limit is Rs.30000");
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
		catch(Exception e) {
			
		}
	}
	public void deposite() {
		System.out.println("Enter the amount to deposite:");
		amount=m.nextFloat();
		try {
		if(amount<=50000) {
			transaction++;
			balance+=amount;
			System.out.println("Amount Rs."+amount+" deposited successfully");
			String msg="Rs."+amount+" "+" Deposited\n";
			transaction_history=transaction_history.concat(msg);
		}
			else {
				System.out.println("Depositin limit is 50000");
			}
	}
		catch(Exception e) {
		}
		}
	public void transfer() {
		System.out.println("Enter the recipient account number:");
		int recipient_accountno=m.nextInt();
		System.out.println("Enter the recipient name:");
		String recipient_name=m.next();
		try {
		if(balance>=amount) {
			if(amount<=50000f) {
				balance-=amount;
				transaction++;
				System.out.println("Amount Rs."+amount+" transferred successfully to"+recipient_name);
				String msg="Rs."+amount+" transferred to "+recipient_name+" "+recipient_accountno+"\n";
				transaction_history=transaction_history.concat(msg);
			}
			else {
				System.out.println("The limit to transfer is Rs.50000");
			}
		}
		else {
			System.out.println("Insufficient amount");
		}
	}
		catch(Exception e) {
		}
		}
	public void checkBalance() {
		System.out.println("Available balance Rs."+balance);
	}
	
	public void transactionHistory() {
		if(transaction==0) {
			System.out.println("No Data Found");
		}
		else {
			System.out.println(transaction_history);
		}
	}
}



public class Atm {

	public static void main(String[] args) {
		
		System.out.println("***********WELCOME TO ATM INTERFACE**********");
		System.out.println("choose 1 to Register and 2 to Exit");
		System.out.println("1.Register \n2.Exit");
		Scanner a=new Scanner(System.in);
		int choice=a.nextInt();
		if(choice==1) {
			Bank obj=new Bank();
			obj.Register();
			System.out.println("Enter 1 to login and 2 to Exit");
			System.out.println("1.Login \n2.Exit");
			int choose=a.nextInt();
			if(choose==1) {
				obj.login();
				System.out.println("Enter your choice:");
				boolean finish=false;
				while(!finish) {
				System.out.println("1.Withdraw\n2.Deposite\n3.Transfer\n4.Transaction History\n5.Quit");
				choose=a.nextInt();
				switch(choose) {
				case 1:
					obj.withdraw();
					break;
				case 2:
					obj.deposite();
					break;
				case 3:
					obj.transfer();
					break;
				case 4:
					obj.transactionHistory();
					break;
				case 5:
					finish=true;
					break;
				}
			}
			}
			else {
				System.exit(0);
			}
			}
		else {
			System.exit(0);
		}
	 }	
}


