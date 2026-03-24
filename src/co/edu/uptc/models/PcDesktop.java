package co.edu.uptc.models;

import co.edu.uptc.enums.IOSEnum;
import co.edu.uptc.enums.TypeStorageEnums;

public class PcDesktop extends Computer {
	
	//Atributes
	private	String socket;
	private int pciESlots;
	private String powerSupply;
	private int wattsCapacity;
	private String chasisName;
	
	//Constructor
	public PcDesktop(int id, String processor, int ramCapacity, int storageCapacity, IOSEnum ios,
			TypeStorageEnums typeStorage, String socket, int pciESlots, String powerSupply, int wattsCapacity,
			String chasisName) {
		super(id, processor, ramCapacity, storageCapacity, ios, typeStorage);
		this.socket = socket;
		this.pciESlots = pciESlots;
		this.powerSupply = powerSupply;
		this.wattsCapacity = wattsCapacity;
		this.chasisName = chasisName;
	}
	
	//Getters and Setters
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public int getPciESlots() {
		return pciESlots;
	}
	public void setPciESlots(int pciESlots) {
		this.pciESlots = pciESlots;
	}
	public String getPowerSupply() {
		return powerSupply;
	}
	public void setPowerSupply(String powerSupply) {
		this.powerSupply = powerSupply;
	}
	public int getWattsCapacity() {
		return wattsCapacity;
	}
	public void setWattsCapacity(int wattsCapacity) {
		this.wattsCapacity = wattsCapacity;
	}
	public String getChasisName() {
		return chasisName;
	}
	public void setChasisName(String chasisName) {
		this.chasisName = chasisName;
	}

	@Override
	public String toString() {
		return "PcDesktop [socket=" + socket + ", pciESlots=" + pciESlots + ", powerSupply=" + powerSupply
				+ ", wattsCapacity=" + wattsCapacity + ", chasisName=" + chasisName + "]";
	}
	
	
}
