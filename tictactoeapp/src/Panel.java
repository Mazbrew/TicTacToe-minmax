import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Panel extends JPanel{
    public Panel(){
        super();
        this.setLocation(0,0);
        this.setSize(500,500);
        this.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(240,234,214));
        g.fillRect(0, 0, 500, 500);
        paintBoard(g);
    }

    public void paintBoard(Graphics g){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                g.setColor(new Color(211,211,211));
                g.fillRect((20*j)+20, (20*i)+20, 15, 15);
            }
        }
    }
}
