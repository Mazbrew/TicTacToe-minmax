public class App {
    public static void main(String[] args) throws Exception {
        
        
        Board board = new Board();
        Panel panel = new Panel(board);
        new Frame(panel);

        while(true){
            System.out.print("\033[H\033[2J");
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print(board.getTileValue(j, i));
                }
                System.out.println();
            }
        }
    }
}
