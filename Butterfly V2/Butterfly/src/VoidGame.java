/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maglasang, Arizala
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VoidGame extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int VoidX = 400;
    private int VoidY = 300;
    private int VoidSpeed = 5;
    private boolean up, down, left, right;
    private List<Point> flowers;
    
    private int timeLeft = 20;
    private Timer gameClock;
    private boolean gameOver;
    private boolean gameWon;
    private int difficulty = 1;
    private JPopupMenu popupMenu;

    public VoidGame() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 600));

        timer = new Timer(16, this);
        timer.start();

        flowers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            flowers.add(new Point((int) (Math.random() * 780), (int) (Math.random() * 580)));
        }

        gameClock = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                } else {
                    gameOver = true;
                    gameClock.stop();
                }
                if (flowers.isEmpty()) {
                    gameWon = true;
                    gameClock.stop();
                }
                repaint();
            }
        });
        gameClock.start();
        
        addKeyListener(this);
        setFocusable(true); 
        requestFocusInWindow(); 
        
        //mouse listener for popup menu
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        //popup menu
        popupMenu = new JPopupMenu();
        JMenuItem restartItem = new JMenuItem("Restart");
        JMenuItem menuItem = new JMenuItem("Return to Main Menu");

        restartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDifficultyMenu();
            }
        });

        popupMenu.add(restartItem);
        popupMenu.add(menuItem);

        showDifficultyMenu();
    }

    private void showDifficultyMenu() {
        String[] options = {"Easy", "Medium", "Hard"};
        int choice = JOptionPane.showOptionDialog(this,
                "Choose difficulty level:",
                "GAME LEVELS:",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        switch (choice) {
            case 0: // Easy
                difficulty = 1;
                timeLeft = 20;
                break;
            case 1: // Medium
                difficulty = 2;
                timeLeft = 15;
                break;
            case 2: // Hard
                difficulty = 3;
                timeLeft = 10;
                break;
            default:
                difficulty = 1;
                timeLeft = 20;
                break;
        }

        // Restart game with selected difficulty
        restartGame();
    }

    private void restartGame() {
        flowers.clear();
        for (int i = 0; i < 10 + difficulty * 2; i++) {
            flowers.add(new Point((int) (Math.random() * 780), (int) (Math.random() * 580)));
        }
        gameOver = false;
        gameWon = false;
        gameClock.restart();
        timeLeft = difficulty == 1 ? 20 : difficulty == 2 ? 15 : 10;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // for the void
        g.setColor(Color.RED);
        g.fillOval(VoidX, VoidY, 30, 20);

        // for the flowers
        g.setColor(Color.YELLOW);
        for (Point flower : flowers) {
            g.fillOval(flower.x, flower.y, 10, 10);
        }
        
        // Draw timer
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Time left: " + timeLeft + "s", 10, 20);

        // Draw game over or win message
        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Tragedy!! You lose!!", 300, 300);
        } else if (gameWon) {
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("You Win!", 300, 300);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (up && VoidY > 0) {
            VoidY -= VoidSpeed;
        }
        if (down && VoidY < getHeight() - 20) {
           VoidY += VoidSpeed;
        }
        if (left && VoidX > 0) {
           VoidX -= VoidSpeed;
        }
        // Adjust to account for the object's width
        if (right && VoidX < getWidth() - 30) { 
            VoidX += VoidSpeed;
        }

        // Check for collision with flowers
        flowers.removeIf(flower -> flower.distance(VoidX, VoidY) < 20);

        repaint();
    }
}
