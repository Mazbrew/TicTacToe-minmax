import javax.swing.JFrame;
import java.awt.*;


public class Frame extends JFrame{
    private int contentWidth = 400;
    private int contentHeight = 450;
    

    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screen.getWidth();
    private double height = screen.getHeight();

    public Frame(Panel panel){
        super();
        this.setLayout(null);
        this.getContentPane().setPreferredSize(new Dimension(contentWidth,contentHeight));
        this.pack();
        this.setLocation((int)(width/2-contentWidth/2),(int)(height/2-contentHeight/2));
        this.setContentPane(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
