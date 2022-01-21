import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Frame extends JFrame{
    private int contentWidth;
    private int contentHeight;
    BufferedImage image= ImageIO.read(getClass().getResource("images/logo.png"));
    

    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screen.getWidth();
    private double height = screen.getHeight();

    public Frame(Panel panel) throws Exception{ 
        super();
        contentWidth=panel.getWidth();
        contentHeight=panel.getHeight();
        this.setLayout(null);
        this.getContentPane().setPreferredSize(new Dimension(contentWidth,contentHeight));
        this.pack();
        this.setTitle("TicTacToe");
        this.setResizable(false);
        this.setIconImage(image);
        this.setLocation((int)(width/2-contentWidth/2),(int)(height/2-contentHeight/2));
        this.setContentPane(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
