import javax.swing.JFrame;
import java.awt.*;


public class Frame extends JFrame{
    private int contentWidth;
    private int contentHeight;
    

    private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screen.getWidth();
    private double height = screen.getHeight();

    public Frame(Panel panel){
        super();
        contentWidth=panel.getWidth();
        contentHeight=panel.getHeight();
        this.setLayout(null);
        this.getContentPane().setPreferredSize(new Dimension(contentWidth,contentHeight));
        this.pack();
        this.setTitle("TicTacToe");
        this.setLocation((int)(width/2-contentWidth/2),(int)(height/2-contentHeight/2));
        this.setContentPane(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
