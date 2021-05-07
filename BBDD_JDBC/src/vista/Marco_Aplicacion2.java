package vista;

import controlador.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Marco_Aplicacion2 extends JFrame{
    
    private Connection miConexion;
    
    public JComboBox secciones; // Lo ponemos public para poder acceder desde otro paquete
    
    public JComboBox paises;
    
    public JTextArea resultado;
    
    private PreparedStatement enviaConsultaSeccion;
    
    private PreparedStatement enviaConsultaPais;
    
    private PreparedStatement enviaConsultaTodos;
    
    public Marco_Aplicacion2(){
        
        setTitle ("Consulta BBDD");
        
        setBounds(500,300,400,400);
        
        setLayout(new BorderLayout());
        
        JPanel menus=new JPanel();
        
        menus.setLayout(new FlowLayout());
        
        secciones=new JComboBox();
        
        secciones.setEditable(false);
        
        secciones.addItem("Todos");
        
        paises=new JComboBox();
        
        paises.setEditable(false);
        
        paises.addItem("Todos");
        
        resultado= new JTextArea(4,50);
        
        resultado.setEditable(false);
        
        add(resultado);
        
        menus.add(secciones);
        
        menus.add(paises);  
        
        add(menus, BorderLayout.NORTH);
        
        add(resultado, BorderLayout.CENTER);
        
        JButton botonConsulta=new JButton("Consulta");
        
        add(botonConsulta, BorderLayout.SOUTH);
        
        botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
        
        addWindowListener(new ControladorCargaMenus(this));
        
    }
    
}
