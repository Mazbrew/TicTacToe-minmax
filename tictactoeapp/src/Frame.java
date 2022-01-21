import javax.swing.JFrame;
import java.awt.*;


public class Frame extends JFrame{
    private int size = 500;
    
    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screen.getWidth();
    private double height = screen.getHeight();

    public Frame(Panel panel){
        super();
        this.setSize(size,size);
        this.setLocation((int)(width/2-size/2),(int)(height/2-size/2));
        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
