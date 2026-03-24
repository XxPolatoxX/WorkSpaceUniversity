package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.List;
import co.edu.uptc.models.Laptop;

public class ManagementLaptop {
    private List<Laptop> listLaptops;

    public ManagementLaptop() {
        this.listLaptops = new ArrayList<>();
    }

    // Buscar por ID
    public Laptop findLaptopById(int id) {
        return this.listLaptops.stream()
                .filter(l -> l.getId() == id)
                .findAny()
                .orElse(null);
    }

    // Insertar con validación
    public boolean insertLaptop(Laptop laptop) {
        if (findLaptopById(laptop.getId()) == null) {
            return listLaptops.add(laptop);
        }
        return false;
    }

    // Eliminar
    public boolean deleteLaptop(int id) {
        Laptop lap = findLaptopById(id);
        if (lap != null) {
            return listLaptops.remove(lap);
        }
        return false;
    }

    public List<Laptop> getListLaptops() {
        return new ArrayList<>(listLaptops); // Devuelve copia por seguridad
    }
}
