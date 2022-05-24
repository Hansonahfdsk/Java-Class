import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame {

    private JLabel status;
    public Game() {
        init();
    }

    private void init() {
        status = new JLabel(" 0");
        add(status, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Hanson");
        setSize(500, 1000);

    }

    JLabel getStatus() {
        return status;
    }

    public static void main(String[] args) {
        var game = new Game();
        game.setVisible(true);
    }
}
