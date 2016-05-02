package edu.neu.csye6200.vehicle;


/**
 * CSYE 6200 Assignment 3 file
 */

/**
 * A special class used to test the Vehicle class
 * 
 * @author (Renjith Prasad) ID: (001716776) LOG: 02/17/2016.
 */
public class VehicleTest {

	/**
	 * This is where your program starts
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void run()  {
		Vehicle minivan = new Vehicle(5, 30, "volvo", "S60", 2013, 18, "VGB 32");
		Vehicle sportscar = new Vehicle(6, 35, "bmw", "320d", 2012, 20, "IND 42");
		Vehicle motorbike = new Vehicle(1, 10, "bajaj", "pulsar", 2011, 50, "HI 394");
		Vehicle auto = new Vehicle(3, 14, "mahindra", "diesel", 2000, 18, "VGB 94");
		Vehicle jeep = new Vehicle(8, 40, "mahi", "willis", 2001, 20, "IND 00");
		Vehicle wilson = new Vehicle(3, 25, "jeep", "wil", 2007, 50, "KER 394");
		Vehicle enfield = new Vehicle(2, 22, "enfield", "thunderbird", 2009, 25, "GOA 32");
		Vehicle car = new Vehicle(4, 32, "maruthi", "swift", 2003, 19, "KAR 42");
		Vehicle bus = new Vehicle(40, 60, "benz", "pulari", 2016, 100, "TN 394");
		Vehicle lorry = new Vehicle(9, 100, "tata", "tempo", 2015, 17, "BOS 32");
		VehicleRegistry registryDetails = VehicleRegistry.getinstance();
		registryDetails.setCarList(minivan);
		registryDetails.setCarList(sportscar);
		registryDetails.setCarList(motorbike);
		registryDetails.setCarList(auto);
		registryDetails.setCarList(jeep);
		registryDetails.setCarList(wilson);
		registryDetails.setCarList(enfield);
		registryDetails.setCarList(car);
		registryDetails.setCarList(bus);
		registryDetails.setCarList(lorry);
		
		registryDetails.sortVehicle();
		registryDetails.printAllCarDetails();
		
		/*Note ---------------------------------------------------------------------
		 * This code was used for assignment 3 . Commented so that only code that will be available in this file is ASN 4
		 * 
		 * 
		 * System.out.println("*********** ASN 3 PART 1 OUTPUT ************" + "\n");
		Vehicle truck = new TruckVehicle(2, 100, "Benz", "300DTruck", 2014,20, "MGB 456", 20,30,10); 
		System.out.println("Printing TruckVehicle Details of truck :" + "\n");
	        System.out.println(truck.toString());
	    System.out.println("*********************************************************************" + "\n");

		
	       RegistryIO.save(registryDetails, "output.txt");
	       System.out.println("The vehicle details are written in to a file output.txt and is ready to be loaded back" + "\n");
	       RegistryIO.load(registryDetails, "output.txt");	 */
		
		/* Note -------------------------------------------------------------------------------------
		 * This code was used for ASN 2B. Commented so that only code that will be available in this file is ASN 3.
		 * 
		 * 
		System.out.println("\nVehicleRegistery Details : Getting vehicle registery details from the details available : \n");
		ArrayList<Vehicle> veh = registryDetails.getCarList();
        if (veh != null) {
            String Msg = "";
            for (Vehicle car : veh) {
                Msg = Msg.concat(car.toString());
            }
            System.out.println(Msg);
        } else {
            System.out.println("VehicleRegistry details empty : No vehicle details to show");
        }

        
        Set<String> details = registryDetails.getlicplatedetails();
        System.out.println("The available License Plate NUmbers are : " + "\n");
        for (String a : details) {
        	System.out.println(a + "\n");
        }
        System.out.println("Please enter a license plate number from above to view the vehicle details :");
        Scanner b = new Scanner(System.in);
        String input = b.nextLine ();
        
        System.out.println("\nShowing Details of car with License Number :  \"" + input + "\"\n");
        Vehicle vehicle = registryDetails.getVehicle(input);
        if (vehicle != null) {
            System.out.println(vehicle.toString());
        } else {
            System.out.println("License Number Invalid ---- quitting \"" + input + "\"");
        }		
        -------------------------------------------------------------------------------------*/

	
	}
	public static void main(String[] args)   {
		run();
	}

}
