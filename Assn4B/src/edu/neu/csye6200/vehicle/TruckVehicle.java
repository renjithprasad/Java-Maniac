package edu.neu.csye6200.vehicle;
public class TruckVehicle extends Vehicle {

	/* All Measurements are mentioned in cms */
	
	float height;
	float width;
	float length;
	
	TruckVehicle(int p, int fuel, String mak, String mod, int modYea,double k, String plate,float ht,float wt,float ln) {
		
		super(p,fuel,mak,mod,modYea,k,plate);
		this.height = ht;
		this.width = wt;
		this.length = ln;
	
	}
	
	public float area_calc () {
		float area = 2 * ((length*width) + (width*height) + (length*height));
		return area;
	}
	
	public String toString() {
        return super.toString() + "And has a total Cargo area of : "  + area_calc() + "\n";
	}
	
}
