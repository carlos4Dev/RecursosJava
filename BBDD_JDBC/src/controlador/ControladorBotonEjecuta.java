package controlador;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  modelo.*;
import vista.*;

public class ControladorBotonEjecuta implements ActionListener {
    
    private Marco_Aplicacion2 elMarco;
    
    EjecutaConsultas obj = new EjecutaConsultas();
    
    private ResultSet resultadoConsulta;
    
    public ControladorBotonEjecuta(Marco_Aplicacion2 elMarco) {
        
        this.elMarco = elMarco;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        String seleccionSeccion = (String)elMarco.secciones.getSelectedItem();
        
        String seleccionPais = (String)elMarco.paises.getSelectedItem();
        
        resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
        
        try {
            
            elMarco.resultado.setText("");
            
            while (resultadoConsulta.next()) {
                
                elMarco.resultado.append(resultadoConsulta.getString(1));
                elMarco.resultado.append(", ");
                
                elMarco.resultado.append(resultadoConsulta.getString(2));
                elMarco.resultado.append(", ");
                
                elMarco.resultado.append(resultadoConsulta.getString(3));
                elMarco.resultado.append(", ");
                
                elMarco.resultado.append(resultadoConsulta.getString(4));
                elMarco.resultado.append("\n");
                
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

}
