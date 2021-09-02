import java.util.*; 

public class atm {
	private HashMap <String,Double> bankAccounts; 
	
	public atm(){
		bankAccounts= new HashMap <String,Double>(); 
	}
	
	
	public void deposit(String name, double amount)
	{
		if (amount < 0)
		{
			System.out.println ("Can't deposit a negative amount");
		    return;
		}
		else if (bankAccounts.isEmpty() || bankAccounts.containsKey((name))==false)
		{
			bankAccounts.put(name, amount);
			//System.out.println ("ID didn't exist. Created and Deposited " + amount);
		}
		else
		{
			double oldMoney = (double) bankAccounts.get(name);
			bankAccounts.put(name, oldMoney + amount);
			//System.out.println ("ID existed. Deposited " + amount + ". There is now " + bankAccounts.get(this.iD) + " in this account.");
		}
	}
	public void withdraw (String ident, double cash) {
		if (bankAccounts.containsKey(ident)==false) {
			System.out.println("Sorry your bank account doesnt exsist"); 
			return; 
		}
		double currentMon= bankAccounts.get(ident); 
		if (cash>currentMon) {
			System.out.println ("Sorry you can't withdraw that much money because you don't have enougn in your bank account"); 
		}
		else if (cash<=currentMon) {
			currentMon=currentMon-cash; 
			bankAccounts.put(ident, currentMon); 
		}	
	}
	public double checkBalance (String identification) {
		if (bankAccounts.containsKey(identification)==false) {
			System.out.println("Sorry this is not a valid ID."); 
			return -1.0; 
		}
		else {
			return (bankAccounts.get(identification)); 
		}
	}
	public static void main (String [] args)
	{
		atm cash = new atm (); 
		cash.deposit("Winfrey", 25159684372.43);
		cash.deposit("Bezos", 193495330293.43);
		cash.deposit("Bezos", 20394353.35);
		cash.withdraw("Bezos", 3593293.66);
		cash.deposit("MrTheiss",64033.55);
		cash.withdraw("MrTheiss", 443964.46);
		System.out.println(cash.checkBalance("Bezos")); 
		System.out.println(cash.checkBalance("Winfrey")); 
		cash.checkBalance("YoMama");
		System.out.println(cash.checkBalance("MrTheiss"));
	}
}
