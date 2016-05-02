package edu.neu.csye6200.vehicle;

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
import java.util.logging.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class VehicleRegistry {
	
	private static VehicleRegistry veh_obj;
	
	private static ArrayList<Vehicle> carList; 

	private HashMap<String, Vehicle> vehicleMap ;
	private static Logger log = Logger.getLogger(VehicleRegistry.class.getName());
	
	///SINGLETON PATTERN
	
	private VehicleRegistry() {
		carList = new ArrayList<Vehicle>();
		vehicleMap = new HashMap<String, Vehicle>();
		log.info("Creating a VehicleRegistry instance\n");
	}
	
	public static VehicleRegistry getinstance() {
		if (veh_obj == null ) {
			veh_obj = new VehicleRegistry();
		}
		return veh_obj;
	}

	public ArrayList<Vehicle> getCarList() {
		log.info("Returning " + carList.size() + " vehicles\n");
		return carList;
	}

	public void setCarList(Vehicle List) {
		carList.add(List);
		vehicleMap.put(List.lic_plate,List);
		log.info("Vehicle " + List.make + " " + List.model + " is getting added to the registery details\n");
		
	}
	
	public Set<String> getlicplatedetails () {
		return vehicleMap.keySet();
	}

	public void remove_vehicle(Vehicle vehicle) {
		carList.remove(vehicle);
	}

	public Vehicle getVehicle(String liscencePlate) {
		if (liscencePlate != null) {
            log.info("Get details of Vehicle with liscencePlate: " + liscencePlate + "\n");

        } else {
            log.warning("Liscence plate is null\n");

        }
		return vehicleMap.get(liscencePlate);
    }
	
	public ArrayList<Vehicle> sortVehicle() {
		log.info("Sorting the vehicledetails based in Liscence plate details");
		Collections.sort(carList, new Comparator<Vehicle>() {;
		@Override
			public int compare(Vehicle veh1, Vehicle veh2)
	        {

	            return  veh1.lic_plate.compareTo(veh2.lic_plate);
	        }
	});
	return carList;
	}

	
    public void printAllCarDetails() {
    	log.info("Printing details if vehicle in the registry");
        String printMsg = "";
        for (Vehicle vehicle : carList) {
            printMsg = printMsg.concat(vehicle.toString());
        }
        System.out.println(printMsg);
    }
	
}