package beans;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UsoBeanPropio extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UsoBeanPropio frame = new UsoBeanPropio();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UsoBeanPropio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400, 800, 600);
        contentPane = new JPanel();
        
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        VisorDeImagenesBean visorDeImagenesBean = new VisorDeImagenesBean();
        visorDeImagenesBean.setBounds(-193, -153, 600, 400);
        contentPane.add(visorDeImagenesBean);
    }
}
