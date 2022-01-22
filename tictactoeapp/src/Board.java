public class Board{
    private char[][] boardArray=new char[3][3];
    private int turnCount = -1;
    private char player = ' ';
    private int winner =0;
    private boolean ai = true;

    public Board(){
        clearBoard();
        playerChange();
    }

    public void clearBoard(){
        winner =0;
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
            if(ai==true){
                runAiPlayer();
                checkEnd();
                playerChange();
            }
        }else{
            player ='o';
        }
    }


    public int minmaxPlayer(boolean isMax){
        int score = checkEnd();

        if(score == 1 || score == -1){
            return score;
        }else if(boardFull()==true && score == 0){
            return 0;
        }

        if(isMax == true){
            int best = -10000;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(boardArray[i][j]=='0'){
                        boardArray[i][j]='x';
                        best = Math.max(best,minmaxPlayer(!isMax));
                        boardArray[i][j]='0';
                    }
                }
            }
            return best;
        }else{
            int best = 10000;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(boardArray[i][j]=='0'){
                        boardArray[i][j]='o';
                        best = Math.min(best,minmaxPlayer(!isMax));
                        boardArray[i][j]='0';
                    }
                }
            }
            return best;
        }
    }

    public void runAiPlayer(){
        bestMove move = new bestMove();
        int score = -10000;
        int tempscore=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(boardArray[i][j]=='0'){
                    boardArray[i][j] = 'x';
                    tempscore = minmaxPlayer(false);
                    boardArray[i][j] = '0';

                    if(tempscore>score){
                        score = tempscore;
                        move.setX(j);
                        move.setY(i);
                    }
                }
            }
        }
        boardArray[move.getY()][move.getX()] = player;
    }

    public int checkEnd(){
        int playerX=0;
        int playerO=0;
        int score =0;

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
                score=1;
            }else if(playerO==3){
                score=-1;
            }
        }

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
                score=1;
            }else if(playerO==3){
                score=-1;
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
                score=1;
            }else if(playerO==3){
                score=-1;
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
                score=1;
            }else if(playerO==3){
                score=-1;
            }
        }

        return score;
    }

    public boolean boardFull(){
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                if(boardArray[j][i]=='0'){
                    return false;
                }
            }
        }

        return true;
    }

    public void setTileValue(int x,int y){
        if(boardArray[y][x]=='0' && boardFull()==false && winner == 0){
            boardArray[y][x]=player;
            playerChange();
            checkEnd();
        }
    }

    public void setTurnCount(){
        turnCount=-1;
        playerChange();
    }

    public char getTileValue(int x,int y){
        return boardArray[y][x];
    }

    public String getDrawString(){
        winner = checkEnd();
        if(boardFull()==true && winner==0){
            return "TIE";
        }else if(winner==1){
            return "X WON";
        }else if(winner ==-1){
            return "O WON";
        }

        return player + "'s turn";
    }

    public void setAi(boolean set){
        ai = set;
    }
}
