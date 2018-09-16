package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PointsEx extends JFrame {
	 
    public PointsEx() {
 
        initUI();
    }
 
    private void initUI() {
 
        final Surface surface = new Surface();
        add(surface);      
 
        setTitle("Points");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public static void main(String[] args) {
 
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
 
                PointsEx ex = new PointsEx();
                ex.setVisible(true);
            }
        });
    }
}