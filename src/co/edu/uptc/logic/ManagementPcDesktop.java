package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.List;
import co.edu.uptc.models.PcDesktop;

public class ManagementPcDesktop {
    private List<PcDesktop> listDesktops;

    public ManagementPcDesktop() {
        this.listDesktops = new ArrayList<>();
    }

    public boolean insertDesktop(PcDesktop desktop) {
        if (findDesktopById(desktop.getId()) == null) {
            return listDesktops.add(desktop);
        }
        return false;
    }

    public PcDesktop findDesktopById(int id) {
        return listDesktops.stream()
                .filter(d -> d.getId() == id)
                .findAny()
                .orElse(null);
    }

    public List<PcDesktop> getListDesktops() {
        return new ArrayList<>(listDesktops);
    }
    
    
}
