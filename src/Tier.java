
public abstract class Tier {
	protected int miles;
	protected int flights;
	protected int cancelledFlights;

	public void setInfos() {
		miles = 0;
		flights = 0;
		cancelledFlights = 0;
	}
	
	public int getMiles() {
		return miles;
	}
	public int getCancelledFlights() {
		return cancelledFlights;
	}
	public int getFlights() {
		return flights;
	}
	
	public void addFlight(boolean isCancelled) {
		flights++;
		if (isCancelled) {
			cancelledFlights++;
			miles +=1000;
		}
	}
	public abstract String getTier();
}

class Base extends Tier{
	public String getTier() {
		return "No tier";
	}
}


class Gold extends Tier {
	public String getTier() {
		return "Gold";
	}
}

class Platinum extends Tier{
	public String getTier() {
		return "Platinum";
	}
}

class PlatinumPro extends Platinum{
	public String getTier() {
		return "Platinum Pro";
	}
	public int getMiles() {
		return super.getMiles() + getCancelledFlights()* 2;
	}
	
}

class ExecutivePlatinum extends Tier{
	public String getTier() {
		return "Executive Platinum";
	}
}

class SuperExecutivePlatinum extends ExecutivePlatinum{
	public String getTier() {
		return "Super Executive Platinum";
	}
	public int getMiles() {
		return super.getMiles() + getCancelledFlights() * 2;
	}
}
