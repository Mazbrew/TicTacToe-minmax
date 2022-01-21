import java.awt.Rectangle;

public class Button {
    private Rectangle rect;

    public Button(int x, int y,int width,int height){
        rect = new Rectangle(x,y,width,height);
    }
 
    public boolean checkLocation(int mouseX,int mouseY){
        return rect.contains(mouseX,mouseY);
    }
}
