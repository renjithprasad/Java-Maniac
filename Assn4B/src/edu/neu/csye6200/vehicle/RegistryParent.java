package edu.neu.csye6200.vehicle;

import java.util.ArrayList;

/**
 * Created by Renjith Prasad on 3/14/2016.
 */
public interface RegistryParent {
    ArrayList<Vehicle> load(VehicleRegistry vehicleRegistry, String fileName);
    void save(VehicleRegistry vehicleRegistry, String fileName);
    void save(Vehicle vehicle);
    void save();
}
