import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import java.io.File;
import java.io.IOException;

public class Panel extends JPanel implements MouseInputListener,KeyListener{
    private int spacing = 25;
    private int block = 100;
    private Squares[][] squareArray= new Squares[3][3];

    private int width = 400;
    private int height = 500;

    private Board board;

    private Graphics2D g2;

    private int sliderHeight= 15;
    private int sliderWidth =75;
    private int buttonSize = 25;
    private boolean ai = false;
    private Button aiButton;
    private Button resetButton;
    final BufferedImage image = ImageIO.read(getClass().getResource("reset.png"));

    public Panel(Board board) throws IOException{
        super();
        this.setLayout(null);
        this.addMouseListener(this);
        this.setLocation(0,0);
        this.setSize(400,450);
        this.setVisible(true);
        this.board = board;
        
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();

        

        aiButton = new Button(0,0,125,50);
        resetButton = new Button(325,0,125,50);

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
        g.fillRect(0, 50, 400, 400);
        paintTopBar(g);
        paintBoard(g);
        paintAnnouncer(g);
    }

    public void paintTopBar(Graphics g){
        g.setColor(new Color(211,211,211).darker().darker());
        g.fillRect(0, 0, 400, 50);

        if(ai==false){
            g.setColor(new Color(255,105,97));
            g.fillRect(50/2, 50/2-sliderHeight/2, sliderWidth, sliderHeight);
            g.setColor(Color.white);
            g.fillOval(50/2-buttonSize/2, 50/2-buttonSize/2, buttonSize, buttonSize);
        }else if(ai==true){
            g.setColor(new Color(119,221,119));
            g.fillRect(50/2, 50/2-sliderHeight/2, sliderWidth, sliderHeight);
            g.setColor(Color.white);
            g.fillOval(50/2-buttonSize/2+sliderWidth, 50/2-buttonSize/2, buttonSize, buttonSize);
        }

        g2 = (Graphics2D) g;
        g2.drawImage(image,325,0,null);
    }

    public void paintBoard(Graphics g){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                g.setColor(new Color(211,211,211));
                g.fillRect((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing+50, block, block);
                g.setColor(Color.black);
                g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                switch(board.getTileValue(j, i)){
                    case 'x':
                        g2.drawLine((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing+50, (block*j)+j*spacing + spacing+block, (block*i)+i*spacing+spacing+block+50);
                        g2.drawLine((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing+block+50, (block*j)+j*spacing + spacing+block, (block*i)+i*spacing+spacing+50);
                    break;
                    case 'o':
                        g2.drawOval((block*j)+j*spacing + spacing, (block*i)+i*spacing+spacing+50, block, block);
                    break;
                }
            }
        }
    }

    public void paintAnnouncer(Graphics g){
        g.setColor(new Color(211,211,211).darker().darker());
        g.fillRect(0, 450, 400, 50);
        g.setColor(new Color(240,234,214).brighter());
        g2 = (Graphics2D) g;
        Font font = new Font("Arial",Font.BOLD,25);
    
        g2.setFont(font);
        g2.drawString(board.getDrawString(), 400/2-g.getFontMetrics().stringWidth(board.getDrawString())/2, 430+50);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(aiButton.checkLocation(e.getX(), e.getY())==true){
            setAi();
        }
        
        if(resetButton.checkLocation(e.getX(),e.getY())==true){
            board.clearBoard();
            board.setTurnCount();
        }
        
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

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setAi(){
        ai=!ai;
    }

    public boolean getAi(){
        return ai;
    }
}
