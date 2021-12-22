package mysnakegameexample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {

    private int SIZE_BLOCK = 30;
    private int SIZE_FIELD = SIZE_BLOCK * SIZE_BLOCK;
    private int snakeSize;
    private Image imgSnake;
    private Image imgApple;
    private int[] x = new int[SIZE_FIELD];
    private int[] y = new int[SIZE_FIELD];
    private int appleX;
    private int appleY;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private boolean keyLock = true;

    public GameField() {
        setBackground(Color.gray);
        loadImg();
        initGame();
        Timer timer = new Timer(250, this);
        timer.start();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }


    public void initGame() {
        snakeSize = 3;
        for (int i = 0; i < snakeSize; i++) {
            x[i] = snakeSize * SIZE_BLOCK - i * SIZE_BLOCK;
            y[i] = 90;
        }

        createApple();
    }

    public void createApple() {
        appleX = new Random().nextInt(SIZE_BLOCK - 1) * SIZE_BLOCK;
        appleY = new Random().nextInt(SIZE_BLOCK - 1) * SIZE_BLOCK;
    }

    public void loadImg() {
        imgSnake = new ImageIcon(getClass().getResource("/images/snake.png")).getImage();
        imgApple = new ImageIcon(getClass().getResource("/images/apple.png")).getImage();
    }

    public void moveSnake() {
        for (int i = snakeSize; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= SIZE_BLOCK;
        }
        if (right) {
            x[0] += SIZE_BLOCK;
        }
        if (up) {
            y[0] -= SIZE_BLOCK;
        }
        if (down) {
            y[0] += SIZE_BLOCK;
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (inGame) {
            grphcs.drawImage(imgApple, appleX, appleY, this);

            for (int i = 0; i < snakeSize; i++) {
                grphcs.drawImage(imgSnake, x[i], y[i], this);
            }
        } else {
            setBackground(Color.BLACK);
            grphcs.setColor(Color.white);
            grphcs.setFont(new Font(TOOL_TIP_TEXT_KEY, 50, 50));
            grphcs.drawString("Game Over", 300, 400);
            grphcs.setFont(new Font(TOOL_TIP_TEXT_KEY, 30, 30));
            grphcs.drawString("Press \"SPACE\" for a new game!", 230, 500);
            grphcs.setFont(new Font(TOOL_TIP_TEXT_KEY, 30, 30));
            grphcs.drawString("Score: " + (snakeSize - 3), 330, 800);
        }
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (inGame) {
            checkApple();
            checkCollisions();
            moveSnake();
            keyLock = true;
            repaint();
        }
    }

    private void checkCollisions() {
        if (x[0] >= SIZE_FIELD || x[0] < 0 || y[0] >= SIZE_FIELD || y[0] < 0) {
            inGame = false;
        }

        for (int i = snakeSize; i > 0; i--) {
            if (snakeSize > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }
    }

    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            snakeSize++;
            createApple();
        }
    }

    public void clearAll() {
        left = false;
        right = true;
        up = false;
        down = false;
        inGame = true;

        x = new int[SIZE_FIELD];
        y = new int[SIZE_FIELD];
    }

    class FieldKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent ke) {
            int key = ke.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right || key == KeyEvent.VK_A && !right) {
                if (keyLock) {
                    left = true;
                    up = false;
                    down = false;
                    keyLock = false;
                }
            }
            if (key == KeyEvent.VK_UP && !down || key == KeyEvent.VK_W && !down) {
                if (keyLock) {
                    up = true;
                    left = false;
                    right = false;
                    keyLock = false;
                }
            }
            if (key == KeyEvent.VK_RIGHT && !left || key == KeyEvent.VK_D && !left) {
                if (keyLock) {
                    right = true;
                    up = false;
                    down = false;
                    keyLock = false;
                }
            }
            if (key == KeyEvent.VK_DOWN && !up || key == KeyEvent.VK_S && !up) {
                if (keyLock) {
                    down = true;
                    left = false;
                    right = false;
                    keyLock = false;
                }
            }
            if (key == KeyEvent.VK_SPACE) {
                if (!inGame) {
                    clearAll();
                    setBackground(Color.gray);
                    initGame();
                }
            }
        }
    }
}
