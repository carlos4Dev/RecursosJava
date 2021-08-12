package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lamina extends JPanel {
    
    private JButton L1, L2, L3, L4, L5, L6, L7, L8, L9;
    private JButton pj1, pj2, reinicio;
    
    private String c1="", c2="", c3="", c4="", c5="", c6="", c7="", c8="", c9="";
    private int t = 0;
    private int  j1 = 0, j2 = 0;
    
    public Lamina() {
            
            L1 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));         
            L2 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            L3 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            L4 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            L5 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            L6 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            L7 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            L8 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            L9 = new JButton(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
            
            pj1 = new JButton("Jugador (X)");
            pj1.setFont(new Font("Serif", Font.BOLD, 28));
            pj1.setForeground(new Color(204,0,0));
            
            reinicio = new JButton("Reiniciar");
            reinicio.setFont(new Font("Serif", Font.BOLD, 28));
            
            pj2 = new JButton("Jugador (O)");
            pj2.setFont(new Font("Serif", Font.BOLD, 28));
            pj2.setForeground(new Color(0,0,204));
            
            add(L1);
            add(L2);
            add(L3);
            add(L4);
            add(L5);
            add(L6);
            add(L7);
            add(L8);
            add(L9);
            add(pj1);
            add(reinicio);
            add(pj2);
            
            L1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L1, 1);
                    t++;
                }
                
            });
            
            L2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L2, 2);
                    t++;
                }
                
            });
            
            L3.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L3, 3);
                    t++;
                }
                
            });
            
            L4.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L4, 4);
                    t++;
                }
                
            });
            
            L5.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L5, 5);
                    t++;
                }
                
            });
            
            L6.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L6, 6);
                    t++;
                }
                
            });
            
            L7.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L7, 7);
                    t++;
                }
                
            });
            
            L8.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L8, 8);
                    t++;
                }
                
            });
            
            L9.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Jugar(t, L9, 9);
                    t++;
                }
                
            });
            
            reinicio.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    L1.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L2.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L3.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L4.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L5.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L6.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L7.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L8.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    L9.setIcon(new ImageIcon(getClass().getResource("/imagenes/blank.png")));
                    c1="";
                    c2=""; 
                    c3=""; 
                    c4=""; 
                    c5="";
                    c6=""; 
                    c7=""; 
                    c8="";
                    c9="";
                }
                
            });

    }
    
    
    public void Ganador() {
        // Cuando un jugador hace línea en alguno de los lados
        if( (c1.equals("x") && c2.equals("x") && c3.equals("x"))
                || (c1.equals("x") && c4.equals("x") && c7.equals("x"))
                || (c7.equals("x") && c8.equals("x") && c9.equals("x"))
                || (c3.equals("x") && c6.equals("x") && c9.equals("x")) ) {                 
                    j1++;
                    JOptionPane.showMessageDialog(null, "Jugador 1 Gana! (X)");
        }
        
        if( (c1.equals("o") && c2.equals("o") && c3.equals("o"))
                || (c1.equals("o") && c4.equals("o") && c7.equals("o"))
                || (c7.equals("o") && c8.equals("o") && c9.equals("o"))
                || (c3.equals("o") && c6.equals("o") && c9.equals("o")) ) {
                    j2++;
                    JOptionPane.showMessageDialog(null, "Jugador 2 Gana! (O)");
        }
        
        // Cuando un jugador hace línea en alguna de las filas del medio
        if( (c2.equals("x") && c5.equals("x") && c8.equals("x"))
                || (c4.equals("x") && c5.equals("x") && c6.equals("x")) ) {
                    j1++;
                    JOptionPane.showMessageDialog(null, "Jugador 1 Gana! (X)");
        }
        
        if( (c2.equals("o") && c5.equals("o") && c8.equals("o"))
                || (c4.equals("o") && c5.equals("o") && c6.equals("o")) ) {             
                    j2++;
                    JOptionPane.showMessageDialog(null, "Jugador 2 Gana! (O)");
        }
        
        // Cuando un jugador hace línea en alguna diagonal
                if( (c1.equals("x") && c5.equals("x") && c9.equals("x"))
                        || (c3.equals("x") && c5.equals("x") && c7.equals("x")) ) {
                            j1++;
                            JOptionPane.showMessageDialog(null, "Jugador 1 Gana! (X)");         
                }
                
                if( (c1.equals("o") && c5.equals("o") && c9.equals("o"))
                        || (c3.equals("o") && c5.equals("o") && c7.equals("o")) ) {
                            j2++;
                            JOptionPane.showMessageDialog(null, "Jugador 2 Gana! (O)");
                }
                
                pj1.setText("Jugador (X): " + j1);
                pj2.setText("Jugador (O): " + j2);
                
    }
    
    public void Opcion(int l, int t) {
        
        if( (l==1) && (t==0) ) {
            c1="x";
        } else if ( (l==1) && (t==1) ) {
            c1="o";
        } else if( (l==2) && (t==0) ) {
            c2="x";
        } else if ( (l==2) && (t==1) ) {
            c2="o";
        } else if( (l==3) && (t==0) ) {
            c3="x";
        } else if ( (l==3) && (t==1) ) {
            c3="o";
        } else if( (l==4) && (t==0) ) {
            c4="x";
        } else if ( (l==4) && (t==1) ) {
            c4="o";
        } else if( (l==5) && (t==0) ) {
            c5="x";
        } else if ( (l==5) && (t==1) ) {
            c5="o";
        } else if( (l==6) && (t==0) ) {
            c6="x";
        } else if ( (l==6) && (t==1) ) {
            c6="o";
        } else if( (l==7) && (t==0) ) {
            c7="x";
        } else if ( (l==7) && (t==1) ) {
            c7="o";
        } else if( (l==8) && (t==0) ) {
            c8="x";
        } else if ( (l==8) && (t==1) ) {
            c8="o";
        } else if( (l==9) && (t==0) ) {
            c9="x";
        } else if ( (l==9) && (t==1) ) {
            c9="o";
        }
        
        Ganador();
            
    }
    
    public void Jugar(int turno, JButton l, int n) {
        
        if(turno % 2 ==0) {
            turno = 0;
        } else {
            turno = 1;
        }
        
        
        if(turno == 0) {
            l.setIcon(new ImageIcon(getClass().getResource("/imagenes/x.png")));
            Opcion(n, turno);
            turno = 1;
            
             
        } else {
            l.setIcon(new ImageIcon(getClass().getResource("/imagenes/zero.png")));
            Opcion(n, turno);
            turno = 0;
        }
            
    }

}

