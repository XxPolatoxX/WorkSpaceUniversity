package co.edu.uptc.models;

public class MotherBoard {
	
	//Atributes
	private int ramSlots;
	private String name;
	private String id;
	private int portSlots;
	private int pciExpresSlots;
	
	//Constructor
	public MotherBoard(int ramSlots, String name, String id, int portSlots, int pciExpresSlots) {
		super();
		this.ramSlots = ramSlots;
		this.name = name;
		this.id = id;
		this.portSlots = portSlots;
		this.pciExpresSlots = pciExpresSlots;
	}
	
	//Getters and setters
	public int getRamSlots() {
		return ramSlots;
	}
	public void setRamSlots(int ramSlots) {
		this.ramSlots = ramSlots;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPortSlots() {
		return portSlots;
	}
	public void setPortSlots(int portSlots) {
		this.portSlots = portSlots;
	}
	public int getPciExpresSlots() {
		return pciExpresSlots;
	}
	public void setPciExpresSlots(int pciExpresSlots) {
		this.pciExpresSlots = pciExpresSlots;
	}
	
	
}
