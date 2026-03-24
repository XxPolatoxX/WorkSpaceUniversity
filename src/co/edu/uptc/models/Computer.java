package co.edu.uptc.models;

import co.edu.uptc.enums.IOSEnum;
import co.edu.uptc.enums.TypeStorageEnums;

public class Computer {
	
	//Atributes
	protected int id;
	protected String processor;
	protected int ramCapacity;
	protected int storageCapacity;
	protected IOSEnum ios;
	protected TypeStorageEnums typeStorage;
	
	//Constructor
	public Computer(int id, String processor, int ramCapacity, int storageCapacity, IOSEnum ios,
			TypeStorageEnums typeStorage) {
		super();
		this.id = id;
		this.processor = processor;
		this.ramCapacity = ramCapacity;
		this.storageCapacity = storageCapacity;
		this.ios = ios;
		this.typeStorage = typeStorage;
	}
	
	//Getters And Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public int getRamCapacity() {
		return ramCapacity;
	}
	public void setRamCapacity(int ramCapacity) {
		this.ramCapacity = ramCapacity;
	}
	public int getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public IOSEnum getIos() {
		return ios;
	}
	public void setIos(IOSEnum ios) {
		this.ios = ios;
	}
	public TypeStorageEnums getTypeStorage() {
		return typeStorage;
	}
	public void setTypeStorage(TypeStorageEnums typeStorage) {
		this.typeStorage = typeStorage;
	}

	@Override
	public String toString() {
		return "Computer id: " + id + "\nProcessor: " + processor + "\nRamCapacity: " + ramCapacity + "\nStorageCapacity: "
				+ storageCapacity + "\nIos: " + ios + "\nTypeStorage: " + typeStorage;
	}
	
	
	
	
}
