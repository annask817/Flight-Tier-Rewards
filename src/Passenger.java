
public class Passenger {
	private String passID;
	private Tier tier;
	

	private boolean isCancelled, complained;
	private int miles, flights, cancelledFlights, complaints;

	// Getter and setter for ID, cancelled/complained, and tier
	public void setPassID(String passID) {
		this.passID = passID;
	}	
	public String getPassID() {
		return passID;
	}
	public void setCC(boolean isCancelled, boolean complained) {
		this.isCancelled = isCancelled;
		this.complained = complained;
	}
	
	public void addFlight(boolean isCancelled) {
		tier.addFlight(isCancelled);
	}
	
	public void setTier(Tier tier) {
		this.tier = tier;
	}
	public String getTier() {
		return tier.getTier();
	}
	/*
	public void setInfo() {
		miles = 0;
		flights = 0;
		cancelledFlights = 0;
		complaints = 0;
	}
	
	public void addFlight() {		
		flights++;
		if (isCancelled) {
			cancelledFlights++;
		}
		if (complained) {
			complaints++;
		}
		
		if (cancelledFlights >= 25 && cancelledFlights < 50) {
			tier = new Gold();
		}
		else if (cancelledFlights >= 50 && cancelledFlights <100) {
			if (complaints > 0) {
				tier = new Platinum();
			}
			else
				tier = new PlatinumPro();
		}
		else if (cancelledFlights >= 100) {
			if (complaints >0) {
				tier = new ExecutivePlatinum();
			}
			else
				tier = new PlatinumPro();
		}
	}	
		
	public boolean hasMultiplier() {
		if (complaints != 0){
			return false;
		}
		else
			return true;
	}
	*/
	
	public int getMiles() {
		return tier.getMiles();
	}
	
	public int getCancelledFlights() {
		return cancelledFlights;
	}

	
	public void printInfo() {
		System.out.println("Rewards tier: " + getTier());
		System.out.println("Total miles: " + miles);
		System.out.println("Total cancellations: " + cancelledFlights);
		//System.out.println("Mileage multiplier: " + hasMultiplier());
	}


}
