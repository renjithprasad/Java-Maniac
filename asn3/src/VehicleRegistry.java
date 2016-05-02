/**
 * CSYE 6200 VehicleRegistry class
 * 
 * @author (Renjith Prasad)
 * ID: (001716776)
 *
 LOG:
 02/08/2016
 1.Added Hashmap as per requirement
 2.Added display method.
 Last Update Date:  02/10/2016
 By: Renjith Prasad
 1.Proper comments and indentation added
 2.Edited the display method to include the vehicle number plate(Vin number) details.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class VehicleRegistry {

	private static ArrayList<Vehicle> carList; 

	private HashMap<String, Vehicle> vehicleMap ;
	
	public VehicleRegistry() {
		carList = new ArrayList<Vehicle>();
		vehicleMap = new HashMap<String, Vehicle>();
	}

	public ArrayList<Vehicle> getCarList() {
		return carList;
	}

	public void setCarList(Vehicle List) {
		carList.add(List);
		vehicleMap.put(List.lic_plate,List);
	}
	
	public Set<String> getlicplatedetails () {
		return vehicleMap.keySet();
	}

	public void remove_vehicle(Vehicle vehicle) {
		carList.remove(vehicle);
	}

	public Vehicle getVehicle(String liscencePlate) {
        return vehicleMap.get(liscencePlate);
    }
		
    public void printAllCarDetails() {
        String printMsg = "";
        for (Vehicle vehicle : carList) {
            printMsg = printMsg.concat(vehicle.toString());
        }
        System.out.println(printMsg);
    }
	
}