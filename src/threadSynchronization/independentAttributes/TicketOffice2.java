package threadSynchronization.independentAttributes;

public class TicketOffice2 implements Runnable {
	
	private Cinema cinema;
	
	public TicketOffice2(Cinema cinema){
		this.cinema = cinema;
	}
	
	// method that simulates some operations over the two cinemas.
	@Override
	public void run() {
		cinema.sellTickets2(2);
		cinema.sellTickets2(4);
		cinema.sellTickets1(2);
		cinema.sellTickets1(1);
		cinema.returnTickets2(2);
		cinema.sellTickets1(3);
		cinema.sellTickets2(2);
		cinema.sellTickets1(2);
	}

}
