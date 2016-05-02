
/**
 * CSYE 6200 Vehicle starter class
 * 
 * @author (Renjith Prasad) ID: (001716776)
 *
 */
public class Vehicle {
	int passengers;
	int fuelCap;
	String make;
	String model;
	int modelYear;
	String lic_plate;
	// Note - in the lecture, we switched from using Miles Per Gallon (MPG) to
	// using Kilometers Per Liter (KPL).
	double kpl; // <== so this should be 'kpl', not 'mpg'

	Vehicle () {};
	
	Vehicle(int p, int fuel, String mak, String mod, int modYea, double k, String plate) {
		passengers = p;
		fuelCap = fuel;
		make = mak;
		model = mod;
		modelYear = modYea;
		kpl = k;
		lic_plate = plate;
	}

	// Return the range.
	int range() {
		return (int) (kpl * fuelCap);
	}
	
	public String toString() {
		String dis = (modelYear + " Model " + make + " " + model + " Having number plate "
				+ lic_plate + " with a fuel capacity of " + fuelCap + " liters has "
				+ passengers + " passengers in it with kpl of " + kpl + " and will run " + range() + " kilometers" + "\n");
	return dis;
	}

}
