import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;

import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;

public class Panel extends JPanel implements MouseInputListener,KeyListener{
    private int spacing = 25;
    private int block = 100;
    private Squares[][] squareArray= new Squares[3][3];

    private Board board;

    public Panel(Board board){
        super();
        this.setLayout(null);
        this.addMouseListener(this);
        this.setLocation(0,0);
        this.setSize(400,400);
        this.setVisible(true);
        this.board = board;
        
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        
        fillSquareArray();

    }

    public void updateBoard(int x, int y){
        for(int i=0;i<3;i++){
            for(int j =0;j<3;j++){
                if(squareArray[i][j].checkLocation(x,y)==true){
                    System.out.println(j+" "+i);
                    board.setTileValue(j, i);
                    break;
                }
            }
        }
        
    }

    public void fillSquareArray(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                squareArray[i][j] = new Squares(j,i,spacing,block);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(240,234,214));
        g.fillRect(0, 0, 400, 400);
        paintBoard(g);
    }

    public void paintBoard(Graphics g){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                g.setColor(new Color(211,211,211));
                g.fillRect((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing, block, block);
                g.setColor(Color.black);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                switch(board.getTileValue(j, i)){
                    case 'x':
                        g2.drawLine((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing, (block*j)+j*spacing + spacing+block, (block*i)+i*spacing+spacing+block);
                        g2.drawLine((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing+block, (block*j)+j*spacing + spacing+block, (block*i)+i*spacing+spacing);
                    break;
                    case 'o':
                        g2.drawOval((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing, block, block);
                    break;
                }
            }
        }
    }

    public void announceWinner(){
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        updateBoard(e.getX(),e.getY());
        repaint();
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_F4){
            board.clearBoard();
            board.setTurnCount();
            repaint();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        
    }
}
