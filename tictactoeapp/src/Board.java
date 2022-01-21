public class Board{
    private char[][] boardArray = new char[3][3];
    private int turnCount = 0;
    private char player = 'x';
    private int winner =0;

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

    //x=1
    //tie =0
    //o=-1
    public void checkEnd(){
        int playerX=0;
        int playerO=0;

        //hori check
        for(int i=0;i<3;i++){
            playerX=0;
            playerO=0;
            for(int j=0;j<3;j++){
                switch(boardArray[i][j]){
                    case 'x':
                        playerX++;
                    break;
                    case 'o':
                        playerO++;
                    break;
                }
            }
            if(playerX==3){
                winner=1;
            }else if(playerO==3){
                winner=-1;
            }
        }

        //verti check
        for(int j=0;j<3;j++){
            playerX=0;
            playerO=0;
            for(int i=0;i<3;i++){
                switch(boardArray[i][j]){
                    case 'x':
                        playerX++;
                    break;
                    case 'o':
                        playerO++;
                    break;
                }
            }
            if(playerX==3){
                winner=1;
            }else if(playerO==3){
                winner=-1;
            }
        }

        playerX=0;
        playerO=0;
        for(int i=0, j=0;i<3;i++,j++){
            switch(boardArray[i][j]){
                case 'x':
                    playerX++;
                break;
                case 'o':
                    playerO++;
                break;
            }
            if(playerX==3){
                winner=1;
            }else if(playerO==3){
                winner=-1;
            }
        }

        playerX=0;
        playerO=0;
        for(int i=0, j=2;i<3;i++,j--){
            switch(boardArray[i][j]){
                case 'x':
                    playerX++;
                break;
                case 'o':
                    playerO++;
                break;
            }
            if(playerX==3){
                winner=1;
            }else if(playerO==3){
                winner=-1;
            }
        }
    }

    public void setTileValue(int x,int y){
        if(boardArray[y][x]=='0'){
            boardArray[y][x]=player;
            playerChange();
            checkEnd();
        }
    }

    public int getWinner(){
        return winner;
    }
}
