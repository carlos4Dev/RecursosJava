package controlador;

import modelo.*;
import vista.*;

import java.awt.event.*;

public class ControladorCargaMenus extends WindowAdapter {
    
    CargaMenus obj = new CargaMenus();
    private Marco_Aplicacion2 elMarco;
    
    public ControladorCargaMenus (Marco_Aplicacion2 elMarco) {
        
        this.elMarco = elMarco;
        
    }
    
    public void windowOpened(WindowEvent e) {
        
        obj.ejecutaConsultas();
        
        try {
            
            while(obj.rs.next()) {
                
                elMarco.secciones.addItem(obj.rs.getString(1));
                
            }
            
            while(obj.rs2.next()) {
                
                elMarco.paises.addItem(obj.rs2.getString(1));
                
            }
            
        } catch(Exception e2) {
            
            e2.printStackTrace();
            
        }
        
    }

}
