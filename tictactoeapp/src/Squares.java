import java.awt.Rectangle;

public class Squares {
    private int x;
    private int y;
    private Rectangle rect;

    public Squares(int x, int y,int spacing,int block){
        this.x = x;
        this.y = y;
        rect = new Rectangle((block*x)+x*spacing + spacing,(block*y)+y*spacing+spacing+50,block,block);
    }
 
    public boolean checkLocation(int mouseX,int mouseY){
        return rect.contains(mouseX,mouseY);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
