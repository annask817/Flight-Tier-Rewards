import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create a reward system to give to passengers as data as
 * read from a file to award them based on their cancellations
 * and complaint data. 
 * @author Anna Kong
 *
 */

public class Main {
	public static void main (String[] arg) throws FileNotFoundException {
		// Store passenger information into array list as an object
		ArrayList <Passenger> passengerList = new ArrayList<Passenger>();
		Tier tier = new Base();
		String passengerID = null;
		char cancel, complain;
		boolean cancelled, complained = false;
		
		File inFile = new File("flight-data.txt");
		Scanner inFS= new Scanner(inFile);
		
		// Read passenger data
		while(inFS.hasNext()) {
			passengerID = inFS.next();
			cancel = inFS.next().charAt(0);
			if (cancel == 'Y') {
				cancelled = true;			// convert to boolean value
				complain = inFS.next().charAt(0);
				if (complain == 'Y')
					complained = true;		// convert to boolean value
				else
					complained = false;
			}
			else
				cancelled = false;
			
			// Check whether the passenger has already appeared in the list
			Passenger passenger = null;
			for (int i = 0; i < passengerList.size(); i++) {
				if (passengerList.get(i).getPassID().equals(passengerID)) {
					passenger = passengerList.get(i);	// Edit information
					passenger.setCC(cancelled, complained);
					passenger.addFlight(cancelled);
			
					passengerList.add(i, passenger);	// Add back to list

					break;
				}
			}
			
			// If passenger isn't is list, add to list
			if (passenger == null) {
				Passenger p2 = new Passenger();
				p2.setPassID(passengerID);
				p2.setCC(cancelled, complained);
				p2.setTier(tier);
				p2.addFlight(cancelled);
				passengerList.add(p2);

			}
			complained = false; //reset for when flight isn't cancelled
		}
		
		// Close file
		inFS.close();
		///
		
		int index = 0;
		for (index = 0; index < passengerList.size(); index++) {
		System.out.println("Passenger " + index + " ID: " + passengerList.get(index).getPassID()
				+ "Cancelled: " + passengerList.get(index).getCancelledFlights());
		}
		
		
		int userIn = -1;
		String userString;
		Scanner input = new Scanner(System.in);
		while (userIn != 0) {
			System.out.println("Enter passenger ID (enter 0 to quit): ");

			userIn = input.nextInt();
			userString = Integer.toString(userIn);	// convert input to string
					
			Passenger passenger = null;
			for (int i = 0; i < passengerList.size(); i++) {
				if (passengerList.get(i).getPassID().equals(userString)) {
					passenger = passengerList.get(i);
					passenger.printInfo();
					break;
				}
			}
			
			
			// Exit statement
			if(userIn == 0) {
				System.out.println("Exit");
				break;
			}
			else if (passenger == null) {
				System.out.println("Passenger ID does not exist.");
			}
		}
		
		
	}
}
