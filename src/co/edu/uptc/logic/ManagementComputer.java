package co.edu.uptc.logic;

import co.edu.uptc.enums.IOSEnum;
import co.edu.uptc.enums.TypeStorageEnums;
import co.edu.uptc.models.Computer;
import java.util.List;
import java.util.ArrayList;

public class ManagementComputer {
	private List<Computer> listComputer;

	//Constructor
	public ManagementComputer() {
		super();
		listComputer = new ArrayList<>();
	}
	
	//Metodo para encontrar un computador por su id
	public Computer findComputerID(int id) {
		
		return this.listComputer.stream().filter(t -> t.getId() == id).findAny().orElse(null);

		
	}
	
	//Metodo de agregar computador
	public boolean InsertComputer(int id, String processor, 
			int ramCapacity, int storageCapacity, IOSEnum ios, TypeStorageEnums typeStorage) {
		
		if(this.findComputerID(id) == null) {
			this.listComputer.add(new Computer(id, processor, 
					ramCapacity, storageCapacity, ios, typeStorage));
			return true;
		}
		return false;	
	}
	
	public int findIndexComputerById(int id) {
		for(int i=0; i<this.listComputer.size(); i++) {
			if(this.listComputer.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean UpdateComputer(Computer newComputer) {
		/* Identificar el registro actual */
		Computer computer = this.findComputerID(newComputer.getId());
		
		if(computer == null) {
			return false;
		}
		
		/* Realizar las asignaciones de la información */
		if(newComputer.getProcessor() != null && !newComputer.getProcessor().isEmpty()) {
			computer.setProcessor(newComputer.getProcessor());
		}
		
		if(newComputer.getRamCapacity() > 0) {
			computer.setRamCapacity(newComputer.getRamCapacity());
		}
		
		if(newComputer.getStorageCapacity() > 0) {
			computer.setStorageCapacity(newComputer.getStorageCapacity());
		}
		
		/* Actualizarlo en la lista */
		this.listComputer.set(this.findIndexComputerById(newComputer.getId()), 
				computer);
		return true;
	}
	
	public boolean deleteComputer(int id) {
		int index = this.findIndexComputerById(id);
		if(index != -1) {
			this.listComputer.remove(index);
			return true;
		}
		return false;
		
	}
	
	//Getter and Setter
	public List<Computer> getListComputer() {
		return listComputer;
	}

	public void setListComputer(List<Computer> listComputer) {
		this.listComputer = listComputer;
	}
	
	
}
