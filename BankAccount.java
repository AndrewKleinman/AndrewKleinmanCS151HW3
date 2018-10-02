import java.util.*;
public class BankAccount implements Comparable<BankAccount>{
	int balance;
	BankAccount(int balance){
		this.balance=balance;
	}
	public int compareTo(BankAccount that)
	{
		return this.balance - that.balance;
	}
	public boolean equals(BankAccount that) {
		return this.compareTo(that)==0;
	}
	public static void main(String[] args)
	{
		ArrayList<BankAccount> accounts = new ArrayList();
		accounts.add(new BankAccount(6));
		accounts.add(new BankAccount(600000));
		accounts.add(new BankAccount(6000));
		accounts.add(new BankAccount(60000));
		accounts.add(new BankAccount(600));
		accounts.add(new BankAccount(60));
		accounts = new ArrayList(new TreeSet<BankAccount>(accounts));
		for(BankAccount a: accounts)
		{
			System.out.println(a.balance);
		}
	}
	
}
