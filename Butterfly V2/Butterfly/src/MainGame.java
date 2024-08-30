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
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainGame extends JFrame {
    private VoidGame gamePanel;

    public MainGame() {
        setTitle("Into the Void");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gamePanel = new VoidGame();
        add(gamePanel);
       
        gamePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gamePanel.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gamePanel.keyReleased(e);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGame());
    }
}
