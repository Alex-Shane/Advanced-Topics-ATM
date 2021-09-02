import java.util.*; 

public class atm {
	private HashMap <String,Double> bankAccounts; 
	
	public atm(){
		bankAccounts= new HashMap <String,Double>(); 
	}
	
	
	public void deposit(String id, double amount)
	{
		if (amount < 0)
		{
			System.out.println ("Can't deposit a negative amount");
		    return;
		}
		else if (bankAccounts.isEmpty() || bankAccounts.containsKey((id))==false)
		{
			bankAccounts.put(id, amount);
			//System.out.println ("ID didn't exist. Created and Deposited " + amount);
		}
		else
		{
			double oldMoney = (double) bankAccounts.get(id);
			bankAccounts.put(id, oldMoney + amount);
			//System.out.println ("ID existed. Deposited " + amount + ". There is now " + bankAccounts.get(this.iD) + " in this account.");
		}
	}
	public void withdraw (String id, double cash) {
		if (bankAccounts.containsKey(id)==false) {
			System.out.println("Sorry your bank account doesnt exsist"); 
			return; 
		}
		double currentMon= bankAccounts.get(id); 
		if (cash>currentMon) {
			System.out.println ("Sorry you can't withdraw that much money because you don't have enougn in your bank account"); 
		}
		else if (cash<=currentMon) {
			currentMon=currentMon-cash; 
			bankAccounts.put(id, currentMon); 
		}	
	}
	public String checkBalance (String id) {
		if (bankAccounts.containsKey(id)==false) {
			return "Sorry this is not a valid ID."; 
		}
		else {
			return (""+(bankAccounts.get(id))); 
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
		System.out.println (cash.checkBalance("YoMama"));
		System.out.println(cash.checkBalance("MrTheiss"));
	}
}
