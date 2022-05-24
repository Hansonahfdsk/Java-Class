import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

class Item {

    protected enum Shape { NoShape, z, S, Line, T, Box, L, M }

    private Shape pieceShape;
    private int piece[][];
    private static int[][][] shapeLib =  {
            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
    };


    public Item() {
        piece = new int[4][2];
        seT(Shape.NoShape);
    }

    protected void seT(Shape shape) {

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                piece[i][j] = shapeLib[shape.ordinal()][i][j];
            }
        }
        pieceShape = shape;
    }

    private void setX(int index, int x) { piece[index][0] = x; }
    private void setY(int index, int y) { piece[index][1] = y; }
    public int x(int index) { return piece[index][0]; }
    public int y(int index) { return piece[index][1]; }
    public Shape geT()  { return pieceShape; }

    public void setRandomShape() {
        var r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;

        Shape[] values = Shape.values();
        seT(values[x]);
    }

    public int getLowX() {
        int m = piece[0][0];
        for (int i=0; i < 4; i++) {
            m = Math.min(m, piece[i][0]);
        }
        return m;
    }

    public int getLowY() {
        int m = piece[0][1];
        for (int i=0; i < 4; i++) {
            m = Math.min(m, piece[i][1]);
        }
        return m;
    }

    public Item rotate() {
        if (pieceShape == Shape.Box) {
            return this;
        }
        var result = new Item();
        result.pieceShape = pieceShape;
        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }
}

public class Board extends JPanel {

    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 22;
    private final int PERIOD_INTERVAL = 200;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel scoreBanner;
    private Item curPiece;
    private Item.Shape[] board;
    class KeyProcess extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (curPiece.geT() == Item.Shape.NoShape) {
                return;
            }
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT -> tryMove(curPiece, curX - 1, curY);
                case KeyEvent.VK_RIGHT -> tryMove(curPiece, curX + 1, curY);
                case KeyEvent.VK_SPACE -> tryMove(curPiece.rotate(), curX, curY);
            }
        }
    }

    public Board(Game parent) {
        setFocusable(true);
        scoreBanner = parent.getStatus();
        addKeyListener(new KeyProcess());
    }

    private int squareWidth() {
        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    private int squareHeight() {
        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    private Item.Shape shapeAt(int x, int y) {
        return board[(y * BOARD_WIDTH) + x];
    }

    void start() {
        curPiece = new Item();
        board = new Item.Shape[BOARD_WIDTH * BOARD_HEIGHT];

        clearBoard();
        newPiece();

        timer = new Timer(PERIOD_INTERVAL, new GameCycle());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        var size = getSize();
        int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                Item.Shape shape = shapeAt(j, BOARD_HEIGHT - i - 1);
                if (shape != Item.Shape.NoShape) {
                    drawItem(g, j * squareWidth(),
                            boardTop + i * squareHeight(), shape);
                }
            }
        }
        if (curPiece.geT() != Item.Shape.NoShape) {
            for (int i = 0; i < 4; i++) {
                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);
                drawItem(g, x * squareWidth(),
                        boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(),
                        curPiece.geT());
            }
        }
    }

    private void oneLineDown() {
        if (!tryMove(curPiece, curX, curY - 1)) {
            pieceDropped();
        }
    }

    private void clearBoard() {
        for (int i = 0; i < BOARD_HEIGHT * BOARD_WIDTH; i++) {
            board[i] = Item.Shape.NoShape;
        }
    }

    private void pieceDropped() {
        for (int i = 0; i < 4; i++) {
            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            board[(y * BOARD_WIDTH) + x] = curPiece.geT();
        }
        hit();
        if (!isFallingFinished) {
            newPiece();
        }
    }

    private void newPiece() {
        curPiece.setRandomShape();
        curX = BOARD_WIDTH / 2 + 1;
        curY = BOARD_HEIGHT - 1 + curPiece.getLowY();
        if (!tryMove(curPiece, curX, curY)) {
            curPiece.seT(Item.Shape.NoShape);
            timer.stop();
            var msg = String.format("Game over. Score: %d", numLinesRemoved);
            scoreBanner.setText(msg);
        }
    }

    private boolean tryMove(Item newPiece, int newX, int newY) {
        for (int i = 0; i < 4; i++) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {
                return false;
            }
            if (shapeAt(x, y) != Item.Shape.NoShape) {
                return false;
            }
        }
        curPiece = newPiece;
        curX = newX;
        curY = newY;
        repaint();
        return true;
    }

    private void hit() {
        int numFullLines = 0;
        for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
            boolean lineIsFull = true;
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (shapeAt(j, i) == Item.Shape.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }
            if (lineIsFull) {
                numFullLines++;
                for (int k = i; k < BOARD_HEIGHT - 1; k++) {
                    for (int j = 0; j < BOARD_WIDTH; j++) {
                        board[(k * BOARD_WIDTH) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }

        if (numFullLines > 0) {
            numLinesRemoved += numFullLines;
            scoreBanner.setText(String.valueOf(numLinesRemoved));
            isFallingFinished = true;
            curPiece.seT(Item.Shape.NoShape);
        }
    }

    private void drawItem(Graphics g, int x, int y, Item.Shape shape) {
        Color colors[] = {Color.blue, Color.cyan, Color.darkGray, Color.green, Color.magenta, Color.orange, Color.pink, Color.yellow};
        var color = colors[shape.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,  x + squareWidth() - 1, y + 1);
    }

    private class GameCycle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }
    }

    private void doGameCycle() {
        update();
        repaint();
    }

    private void update() {
        if (isPaused) {
            return;
        }
        if (isFallingFinished) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }

}
