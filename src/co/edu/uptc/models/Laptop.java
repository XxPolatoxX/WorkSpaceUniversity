package co.edu.uptc.models;

import co.edu.uptc.enums.IOSEnum;
import co.edu.uptc.enums.TypeStorageEnums;

public class Laptop extends Computer{
	
	//Atributes
	private int batteryCapacity;
	private	boolean isTactil;
	private boolean backlitKeyboard;
	private double screenSize;
	private double weight;
	
	//Constructor
	public Laptop(int id, String processor, int ramCapacity, int storageCapacity, IOSEnum ios,
			TypeStorageEnums typeStorage, int batteryCapacity, boolean isTactil, boolean backlitKeyboard,
			double screenSize, double weight) {
		super(id, processor, ramCapacity, storageCapacity, ios, typeStorage);
		this.batteryCapacity = batteryCapacity;
		this.isTactil = isTactil;
		this.backlitKeyboard = backlitKeyboard;
		this.screenSize = screenSize;
		this.weight = weight;
	}
	
	//getters and Setters
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public boolean isTactil() {
		return isTactil;
	}
	public void setTactil(boolean isTactil) {
		this.isTactil = isTactil;
	}
	public boolean isBacklitKeyboard() {
		return backlitKeyboard;
	}
	public void setBacklitKeyboard(boolean backlitKeyboard) {
		this.backlitKeyboard = backlitKeyboard;
	}
	public double getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString() + "\nBatteryCapacity: " + 
	batteryCapacity + "\nIs Tactil: " + isTactil + "\nBacklitKeyboard: "
				+ backlitKeyboard + "\nscreenSize: " + screenSize + "\nweight: " + weight;
	}
	
	
	
	
}
