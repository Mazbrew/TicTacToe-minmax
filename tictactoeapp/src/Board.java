import javax.swing.JLabel;

public class Board extends JLabel{
    private char[][] boardArray = new char[3][3];
    private int turnCount = 0;
    private char player = 'x';

    public Board(){
        clearBoard();
    }

    public void clearBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                boardArray[i][j] ='0';
            }
        }
    }

    public void playerChange(){
        turnCount++;
        if(turnCount%2==0){
            player ='x';
        }else{
            player ='o';
        }
    }

    public char getTileValue(int x,int y){
        return boardArray[y][x];
    }

    public void setTileValue(int x,int y){
        boardArray[y][x]=player;
        playerChange();
    }
}
