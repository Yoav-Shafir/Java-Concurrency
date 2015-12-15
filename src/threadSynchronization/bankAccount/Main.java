package threadSynchronization.bankAccount;

public class Main {
	
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Thread bank = new Thread(new Bank(account));
		Thread company = new Thread(new Company(account));
		
		System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
		
		bank.start();
		company.start();
		
		try {
			bank.join();
			company.join();
			System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
