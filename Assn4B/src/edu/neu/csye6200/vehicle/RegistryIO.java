package edu.neu.csye6200.vehicle;

/**
 * CSYE 6200 Assignment #4b file
 */

/**
 * A special class used include Input and Output of registry details to  and from file 
 * 
 * @author (Renjith Prasad) ID: (001716776) LOG: 02/17/2016.
 */



import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistryIO implements RegistryParent {

	private static ArrayList<Vehicle> veh_registery;
	private static ArrayList<Vehicle> vehicles = new ArrayList<>();
	private static String fileNameIO;
    private static Logger log = Logger.getLogger(RegistryIO.class.getName());
    private static int counter = 1;
    public RegistryIO() {
        log.info("Running the constructor : creating RegistryIO instance \n");
    }

	// Load Function receives the vehicleRegistry details and output file
	// Try catch catches if an exception happens
	
    @Override
    public ArrayList<Vehicle> load(VehicleRegistry vehicleRegistry, String file) {
		File folder = new File(file);
        File[] listOfFiles = folder.listFiles();
        for (File fn:listOfFiles) {
		log.info("Loading all vehicles from " + fn + "\n");
		String reg_str = "(\\d{1,5})\\s\\w+\\s(\\w+)\\s(\\w+)\\s\\w+\\s\\w+\\s\\w+\\s(\\w+\\s\\w+)\\s\\w+\\s\\w+\\s\\w+\\s\\w+\\s\\w+\\s(\\d{1,5})\\s\\w+\\s\\w+\\s(\\d{1,5})\\s\\w+\\s\\w+\\s\\w+\\s\\w+\\s\\w+\\s\\w+\\s(\\d{1,3})";
		try {
			
			//1. Reads the file as file-reader checks for pattern and parses the input from file for object fields
			//2. Creates a new vehicle object with the parsed fields and then displays the result
			
			FileReader fr = new FileReader(fn);
			BufferedReader in_buffer = new BufferedReader(fr);
			ArrayList<String> list = new ArrayList<String>();
			String str;
			while ((str = in_buffer.readLine()) != null) {
			list.add(str);
			}
			list.removeAll(Arrays.asList(null,""));
			for (String parse : list) {	
				Pattern pat = Pattern.compile(reg_str);
				Matcher matcher = pat.matcher(parse);
				if (matcher.find()) {
					int a = Integer.parseInt(matcher.group(1));
					String b = matcher.group(2);
					String c = matcher.group(3);
					String d = matcher.group(4);
					int e = Integer.parseInt(matcher.group(5));
					int f = Integer.parseInt(matcher.group(6));
					double g = Integer.parseInt(matcher.group(7));
					Vehicle new_vehicle = new Vehicle(f, e, b, c, a, g, d);
					vehicles.add(new_vehicle);
				} 
			}
			in_buffer.close();
		} catch (FileNotFoundException e) {
			log.severe("FileNotFoundException while loading details from " + fn + "\n");
			e.printStackTrace();
		} catch (IOException e) {
			log.severe("IOException while loading details from " + fn + "\n");
			e.printStackTrace();
		}
	}
        System.out.println("\nBonus Question : Output");
        return vehicles;
	}

	//Public Save method receives vehicle registry details and filename
	// This function Save the entire vehicle registry to a named file
	
	@Override
	public void save(VehicleRegistry vehicleRegistry, String fileName) {
		fileNameIO = fileName;
		veh_registery = vehicleRegistry.getCarList();
			for (Vehicle a : veh_registery) {
				if (a != null) {
					save(a);
				}
			}
			save();
			System.out.println("The data has been successfully written into individual vehicle files\n");
	}
	
	
	//Helper class which is called several times by the public class .
	//Accepts only one vehicle at a time and adds vehicle details to already opened output stream
	
	@Override
	public void save(Vehicle vehicle) {
        try {
            if (vehicle != null && fileNameIO != null) {
            	FileWriter fw = new FileWriter(new File(fileNameIO,"Vehicle-"+counter));
				++counter;
				fw.write(vehicle.toString());
				fw.append("\n");
				fw.close();
            } else {
                System.out.println("Unable to serialize Vehicles due to null object\n");
            }
        } catch (IOException ex) {
			log.severe("IOException while trying to write a vehicle detail into an already opened input stream" + "\n");
			System.err.println("IO ERROR received: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
        
        @Override
        public void save() {
        	File folder = new File("vehicles");
        	if (folder.exists()){
        		System.out.println("Checking if files are written and present in the directory or not\n");
        		System.out.println("System ... OK...!!! Files present\n");
        	} else {
        		System.out.println("Files not found\n");
        	}
        }
}

