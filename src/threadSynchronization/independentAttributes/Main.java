package threadSynchronization.independentAttributes;

public class Main {
	
	public static void main(String[] args) {
		
		// Declare and create a Cinema object.
		Cinema cinema = new Cinema();
		
		// Create a TicketOffice1 object and Thread to execute it.
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");
		
		// Create a TicketOffice2 object and Thread to execute it.
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");
	
		thread1.start();
		thread2.start();
		
		// Wait for the completion of the threads.
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Write to the console the vacancies of the two cinemas.
		System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
	}
}
