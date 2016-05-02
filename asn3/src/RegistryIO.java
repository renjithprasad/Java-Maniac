
/**
 * CSYE 6200 Assignment #3 file
 */

/**
 * A special class used include Input and Output of registry details to  and from file 
 * 
 * @author (Renjith Prasad) ID: (001716776) LOG: 02/17/2016.
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistryIO extends VehicleRegistry {

	private static ArrayList<Vehicle> veh_registery;
	private static String fileNameIO;

	// Load Function receives the vehicleRegistry details and output file
	// Try catch catches if an exception happens
	
	static void load(VehicleRegistry vehicleRegistry, String fn) {
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
			System.out.println("\nBonus Question : Output");
			System.out.println("------------------------" + "\n");
			System.out.println(
					"Please Wait: Reading from output.txt file and transfering data to the object ********"
							+ "\n");
			System.out.println(
					"The new Vehicle has been created after reading in from the file: Successfully read from the output.txt file.The details are:"
							+ "\n");
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
					String op = new_vehicle.toString();
					System.out.println(op + "\n");
				} else {
					System.out.println("Match not found");
				}
			}
			in_buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Public Save method receives vehicle registry details and filename
	// This function Save the entire vehicle registry to a named file
	
	public static void save(VehicleRegistry vehicleRegistry, String fileName) {
		fileNameIO = fileName;
		veh_registery = vehicleRegistry.getCarList();
		try {
			FileWriter fw = new FileWriter(fileNameIO);
			for (Vehicle a : veh_registery) {
				if (a != null) {
					save(a,fw);
				}
			}
			fw.close();
			System.out.println("The data has been successfully written into output.txt");
		} catch (IOException ex) {
			System.err.println("IO ERROR received: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	
	//Helper class which is called several times by the public class .
	//Accepts only one vehicle at a time and adds vehicle details to already opened output stream
	
	private static void save(Vehicle vehicle, FileWriter a) {
        try {
            if (vehicle != null && fileNameIO != null) {
				a.write(vehicle.toString());
				a.append("\n");
            } else {
                System.out.println("Unable to serialize Vehicles due to null object");
            }
        } catch (IOException ex) {
			System.err.println("IO ERROR received: " + ex.getMessage());
			ex.printStackTrace();
		}
}
}
