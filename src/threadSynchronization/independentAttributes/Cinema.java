package threadSynchronization.independentAttributes;

public class Cinema {
	
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	
	private final Object controlCinema1, controlCinema2;
	
	public Cinema() {
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}
	
	// method that is called when some tickets for the
	// first cinema are sold. It uses the controlCinema1 object to control the access to
	// the synchronized block of code.
	public boolean sellTickets1 (int number) {
		synchronized (controlCinema1) {
			if (number < vacanciesCinema1) {
				vacanciesCinema1 -= number;
				return true;
			} else {
				return false;
			}
		}
	}
	
	// called when some tickets for the
	// first cinema are returned. It uses the controlCinema1 object to control the access
	// to the synchronized block of code.
	public boolean returnTickets1 (int number) {
		synchronized (controlCinema1) {
			vacanciesCinema1 += number;
			return true;
		}
	}
	
	// called when some tickets for the
	// second cinema are sold. It uses the controlCinema2 object to control the access
	// to the synchronized block of code.
	public boolean sellTickets2 (int number){
		synchronized (controlCinema2) {
			if (number < vacanciesCinema2) {
				vacanciesCinema2 -= number;
				return true;
			} else {
				return false;
			}
		}
	}
	
	// called when some tickets for
	// the second cinema are returned. It uses the controlCinema2 object to control the
	// access to the synchronized block of code.
	public boolean returnTickets2 (int number) {
		synchronized (controlCinema2) {
			vacanciesCinema2 += number;
			return true;
		}
	}	
	
	// another two methods that return the number of 
	// vacancies in each  cinema.
	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}
		
	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}
}
