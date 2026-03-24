package co.edu.uptc.run;
import java.util.Objects;
import java.util.Scanner;
import co.edu.uptc.models.Computer;
import co.edu.uptc.models.Laptop;
import co.edu.uptc.enums.TypeStorageEnums;
import co.edu.uptc.logic.ManagementComputer;
import co.edu.uptc.enums.IOSEnum;
import co.edu.uptc.logic.ManagementLaptop;
import co.edu.uptc.logic.ManagementPcDesktop;
import co.edu.uptc.models.PcDesktop;;
public class Main {

	public static void main(String[] args) {

		String menuPrincipal = """
				----- EJERCICIO CRUDS -----
				[1] CRUD COMPUTER 
				[2] CRUD LAPTOP
				[3] CRUD PCDESKTOP
				[4] SALIR
				""";
		
		String menuComputer = """
				----- EJERCICIO CRUDS -----
				[1] INSERT COMPUTER
				[2] FIND COMPUTER
				[3] UPGRADE COMPUTER
				[4] DELETE COMPUTER
				[5] LISTAR COMPUTER
				[6] SALIR
				""";
		
		String menuLaptop = """
				----- EJERCICIO CRUDS -----
				[1] INSERT LAPTOP
				[2] FIND LAPTOP
				[3] UPGRADE LAPTOP
				[4] DELETE LAPTOP
				[5]	LISTAR LAPTOP
				[6] EXIT
				""";
		String menupcDesktop = """
				----- EJERCICIO CRUDS -----
				[1] INSERT PCDESKTOP
				[2] FIND PCDESKTOP
				[3] UPGRADE PCDESKTOP
				[4] DELETE PCDESKTOP
				[5] LISTAR PCDESKTOP
				[6] SALIR
				""";
	
		ManagementComputer managementComputer = new ManagementComputer();
		ManagementLaptop managementLaptop = new ManagementLaptop();
		ManagementPcDesktop managementDesktop = new ManagementPcDesktop();
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println(menuPrincipal);
			int operacion = Integer.parseInt(sc.nextLine());
			
			switch(operacion) {
			case 1:
				System.out.println(menuComputer);
				int operacionComputer = Integer.parseInt(sc.nextLine());
				
				
				switch(operacionComputer) {
				case 1:
					
					try {
						
					System.out.println("----------CREATE COMPUTER----------");
					System.out.println("Ingrese el id del computador: ");
					int idComputer = Integer.parseInt(sc.nextLine());
					
					System.out.println("Ingrese el nombre del procesador: ");
					String processorComputer = sc.nextLine();
					
					System.out.println("Ingrese la ram (8, 16, 24, 32)gb: ");
					int ram = Integer.parseInt(sc.nextLine());
					
					System.out.println("ingrese el almacenamiento que desea (256, 512, 1024, 2048)gb: ");
					int storage = Integer.parseInt(sc.nextLine());
					
					System.out.println("Ingrese el Sitema Operativo (Windows, Linux, Mac): ");
					IOSEnum ios = IOSEnum.valueOf(sc.nextLine().toUpperCase());
				
					System.out.println("Ingrese el tipo de almacenamiento(HDD, SSD, NVME): ");
					TypeStorageEnums typeStorage = TypeStorageEnums.valueOf(sc.nextLine().toUpperCase());
					 
					
					if(managementComputer.InsertComputer(idComputer, processorComputer, ram, 
							storage, ios, typeStorage)) {
						System.out.println(" El registro se agregó correctamente");
					}else {
						System.out.println(" No se agregó el registro");
					}
					
					}catch (NumberFormatException e) {
			            System.out.println("❌ Error: Ingresaste letras en un campo numérico.");
			        } catch (IllegalArgumentException e) {
			            System.out.println("❌ Error: El valor del Enum no es válido.");
			        } catch (Exception e) {
			            System.out.println("❌ Ocurrió un error inesperado: " + e.getMessage());
			        }
			        
					break;
				case 2:
					
					System.out.println("FIND COMPUTER");
					System.out.println("Write to idCommputer: ");
					int idComputer1 = Integer.parseInt(sc.nextLine());
					Computer computer = managementComputer.findComputerID(idComputer1);
					if(!Objects.isNull(computer)) {
						
						System.out.println(computer);
					}else {
						System.out.println("The computer was not finded");
					}
					break;
				case 3:
					
					System.out.println("UPGRADE COMPUTER");
					System.out.println("Write the Computer id updater: ");
					int idUpdateComputer = Integer.parseInt(sc.nextLine());
					
					System.out.println("Write the computer's processors name: ");
					String nameUpdateProcessor = sc.nextLine();
					
					System.out.println("Write the computer's ram upgrader : ");
					int ramUpgradeCapacity = Integer.parseInt(sc.nextLine());
					
					System.out.println("Write the computer's ram upgrader : ");
					int storageUpgradeCapacity = Integer.parseInt(sc.nextLine());
					
					System.out.println("Write the new ios: ");
					String newIos = sc.nextLine().toUpperCase();
					IOSEnum newUpDateIos = IOSEnum.valueOf(newIos);
					
					System.out.println("Write the new Storage: ");
					String newStorage = sc.nextLine().toUpperCase();
				    TypeStorageEnums newUpDateStorage = TypeStorageEnums.valueOf(newStorage);
					
					
					Computer updateComputer = new Computer(idUpdateComputer, nameUpdateProcessor, ramUpgradeCapacity, storageUpgradeCapacity, newUpDateIos, newUpDateStorage);
					updateComputer.setId(idUpdateComputer);
					updateComputer.setProcessor(nameUpdateProcessor);
					updateComputer.setRamCapacity(ramUpgradeCapacity);
					updateComputer.setIos(newUpDateIos);
					updateComputer.setTypeStorage(newUpDateStorage);
					
					
					if(managementComputer.UpdateComputer(updateComputer)) {
						System.out.println("Se realizó la actualización");
					}else {
						System.out.println("No se realizó la actualización");
					}
					break;
				case 4:
					System.out.println("DELETE COMPUTER");
					System.out.println("Digite el identificador del Computer a eliminar: ");
					int idDeleteComputer = Integer.parseInt(sc.nextLine());
					if(managementComputer.deleteComputer(idDeleteComputer)) {
						System.out.println("Se eliminó el registro.");
					}else {
						System.out.println("No se eliminó el registro.");
					}
					break;
				case 5:
					System.out.println("\n========= LISTADO DE COMPUTADORES =========");
				    
				    // Obtenemos la lista desde la lógica
				    var lista = managementComputer.getListComputer();
				    
				    if (lista.isEmpty()) {
				        System.out.println("No hay computadores registrados actualmente.");
				    } else {
				        // Recorremos y mostramos cada uno
				        lista.forEach(c -> System.out.println(c.toString()));
				    }
				    System.out.println("============================================\n");
				    break;
				    
				case 6:
					flag = false;
					break;
					
				}
				break;
			case 2:
				
					System.out.println(menuLaptop);
					int operationLaptop = Integer.parseInt(sc.nextLine());
			    
					switch(operationLaptop) {
			        	case 1: // INSERT LAPTOP
			        		try {
			        			System.out.println("---------- CREATE LAPTOP ----------");
			        			System.out.print("ID: ");
			        			int idL = Integer.parseInt(sc.nextLine());
			                
			        			System.out.print("PROCESSOR: ");
			        			String procL = sc.nextLine();
			                
			        			System.out.print("RAM (GB): ");
			        			int ramL = Integer.parseInt(sc.nextLine());
			                
			        			System.out.print("STORAGE (GB): ");
			        			int storL = Integer.parseInt(sc.nextLine());
			                
			        			System.out.print("IOS (WINDOWS, LINUX, MAC): ");
			        			IOSEnum iosL = IOSEnum.valueOf(sc.nextLine().toUpperCase());
			                
			        			System.out.print("TYPESTORAGE (SSD, HDD): ");
			        			TypeStorageEnums typeL = TypeStorageEnums.valueOf(sc.nextLine().toUpperCase());
			                
			        			// Atributos específicos de Laptop
			        			System.out.print("BATTERY CAPACITY (mAh): ");
			        			int batt = Integer.parseInt(sc.nextLine());
			                
			        			System.out.print("IS TACTIL? (true/false): ");
			        			boolean tact = Boolean.parseBoolean(sc.nextLine());
			        			
			        			System.out.print("BACKLIT KEYBOARD (true/false): ");
			        			boolean back = Boolean.parseBoolean(sc.nextLine());
			        			
			        			System.out.print("SCREEN SIZE (pulgadas): ");
			        			double screen = Double.parseDouble(sc.nextLine());
			        			
			        			System.out.print("WEIGHT (kg): ");
			        			double weight = Double.parseDouble(sc.nextLine());
			        			
			        			Laptop newLap = new Laptop(idL, procL, ramL, storL, iosL, typeL, batt, tact, back, screen, weight);
			        			
			        			if(managementLaptop.insertLaptop(newLap)) {
			        				System.out.println("✅ Laptop agregada correctamente.");
			        			} else {
			        				System.out.println("❌ Error: El ID ya existe.");
			        			}
			        		} catch (Exception e) {
			        			System.out.println("❌ Error en los datos: " + e.getMessage());
			        		}
			        		
			        		break;
			        		
			        	case 2:
			        		
			        		System.out.println("FIND COMPUTER");
							System.out.println("Write to idCommputer: ");
							int idLaptop1 = Integer.parseInt(sc.nextLine());
							Laptop laptop = managementLaptop.findLaptopById(idLaptop1);
							if(!Objects.isNull(laptop)) {
								
								System.out.println(laptop);
							}else {
								System.out.println("The computer was not finded");
							}
							break;
			        		
			        	case 3:
			        		System.out.println("UPGRADE LAPTOP");
							System.out.println("Write the laptop id updater: ");
							int idLaptopUp = Integer.parseInt(sc.nextLine());
							
							System.out.println("Write the laptop's processors name: ");
							String processorLaptopU = sc.nextLine();
							
							System.out.println("Write the laptop's ram upgrader : ");
							int ramLaptopU = Integer.parseInt(sc.nextLine());
							
							System.out.println("Write the laptop's ram upgrader : ");
							int storageLaptopU = Integer.parseInt(sc.nextLine());
							
							System.out.println("Write the new laptop ios: ");
							String newIos = sc.nextLine().toUpperCase();
							IOSEnum newLaptopIos = IOSEnum.valueOf(newIos);
							
							System.out.println("Write the new Storage: ");
							String newStorage = sc.nextLine().toUpperCase();
						    TypeStorageEnums newLaptopStorage = TypeStorageEnums.valueOf(newStorage);
						    
						    System.out.println("Write the battery capacity (mAh)");
						    int bateryCapacity = Integer.parseInt(sc.nextLine());
						    
						    System.out.println("The new laptop is tactil? (True / false): ");
						    boolean isTactil = Boolean.parseBoolean(sc.nextLine());
							
						    System.out.println("The new laptop is tactil? (True / false): ");
						    boolean isBacklitKeyboard = Boolean.parseBoolean(sc.nextLine());
						    
						    System.out.println("Write new screen size: ");
						    double newScreenSize = Double.parseDouble(sc.nextLine());
						    
						    System.out.println("Write the new weight: ");
						    double newWeight = Double.parseDouble(sc.nextLine());
							
							Laptop updateComputer = new Laptop(idLaptopUp, processorLaptopU, ramLaptopU, storageLaptopU, 
									newLaptopIos, newLaptopStorage, bateryCapacity, isTactil, isBacklitKeyboard, 
									newScreenSize, newWeight);
							
							updateComputer.setId(idLaptopUp);
							updateComputer.setProcessor(processorLaptopU);
							updateComputer.setRamCapacity(ramLaptopU);
							updateComputer.setIos(newLaptopIos);
							updateComputer.setTypeStorage(newLaptopStorage);
							updateComputer.setBacklitKeyboard(isBacklitKeyboard);
							updateComputer.setBatteryCapacity(bateryCapacity);
							updateComputer.setTactil(isTactil);
							updateComputer.setScreenSize(newScreenSize);
							updateComputer.setWeight(newWeight);
							
							if(managementComputer.UpdateComputer(updateComputer)) {
								System.out.println("Se realizó la actualización");
							}else {
								System.out.println("No se realizó la actualización");
							}
			        	break;	
			        	case 4:
			        		
			        		System.out.println("DELETE LAPTOP");
							System.out.println("Digite el identificador del laptop a eliminar: ");
							
							
							int idDeleteLaptop = Integer.parseInt(sc.nextLine());
							if(managementLaptop.deleteLaptop(idDeleteLaptop)) {
								System.out.println("Se eliminó el registro.");
							}else {
								System.out.println("No se eliminó el registro.");
							}
							break;
			        	case 5: 
			        		System.out.println("\n========= LISTADO DE COMPUTADORES =========");
						    
						    // Obtenemos la lista desde la lógica
						    var lista = managementLaptop.getListLaptops();
						    
						    if (lista.isEmpty()) {
						        System.out.println("No hay computadores registrados actualmente.");
						    } else {
						        // Recorremos y mostramos cada uno
						        lista.forEach(c -> System.out.println(c.toString()));
						    }
						    System.out.println("============================================\n");
						    break;
			        	case 6:
			        		break;
					}
					break;
			case 3:
				
				System.out.println(menupcDesktop);
				int operationDesktop = Integer.parseInt(sc.nextLine());
		    
				switch(operationDesktop) {
				case 1:
				try {
			    System.out.println("----- MENU PCDESKTOP -----");
			    System.out.println("Write the laptop id updater: ");
				int idPcUp = Integer.parseInt(sc.nextLine());
				
				System.out.println("Write the laptop's processors name: ");
				String processorPcU = sc.nextLine();
				
				System.out.println("Write the laptop's ram upgrader : ");
				int ramPcU = Integer.parseInt(sc.nextLine());
				
				System.out.println("Write the laptop's ram upgrader : ");
				int storagePcU = Integer.parseInt(sc.nextLine());
				
				System.out.println("Write the new laptop ios: ");
				String newIos = sc.nextLine().toUpperCase();
				IOSEnum newPcIos = IOSEnum.valueOf(newIos);
				
				System.out.println("Write the new Storage: ");
				String newStorage = sc.nextLine().toUpperCase();
			    TypeStorageEnums newPcStorage = TypeStorageEnums.valueOf(newStorage);
			    
			    // Al capturar los datos específicos:
			    System.out.println("Ingrese el Socket (ej: AM4, LGA1700): ");
			    String socket = sc.nextLine();
			    
			    System.out.println("Cantidad de ranuras PCIe: ");
			    int pcie = Integer.parseInt(sc.nextLine());
			    
			    System.out.println("Nombre de la Fuente de Poder: ");
			    String psu = sc.nextLine();
			    
			    System.out.println("Capacidad en Watts: ");
			    int watts = Integer.parseInt(sc.nextLine());
			    
			    System.out.println("Nombre del Chasis/Gabinete: ");
			    String chasis = sc.nextLine();

			    PcDesktop newDesktop = new PcDesktop(idPcUp, processorPcU, ramPcU
			    		, storagePcU, newPcIos, newPcStorage, socket
			    		, pcie, psu, watts, chasis);
	
    			
    			if(managementDesktop.insertDesktop(newDesktop)) {
    				System.out.println("✅ Laptop agregada correctamente.");
    			} else {
    				System.out.println("❌ Error: El ID ya existe.");
    			}
    		} catch (Exception e) {
    			System.out.println("❌ Error en los datos: " + e.getMessage());
    		}
    			break;
    			
    			case 2: 
    				System.out.println("FIND PC DESKTOP");
					System.out.println("Write to id pc desktop: ");
					int idComputer1 = Integer.parseInt(sc.nextLine());
					Computer computer = managementComputer.findComputerID(idComputer1);
					if(!Objects.isNull(computer)) {
						
						System.out.println(computer);
					}else {
						System.out.println("The computer was not finded");
					}
					break;
    				break;
    				
    		}
			    
			    
				}
			}
		}
	}

				
				
		

		
	
	
	


