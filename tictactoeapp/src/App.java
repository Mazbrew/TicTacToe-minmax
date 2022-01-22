public class App {
    public static void main(String[] args) throws Exception {
        
        
        Board board = new Board();
        Panel panel = new Panel(board);
        new Frame(panel);
    }
}
