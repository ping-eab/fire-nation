/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insideout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Maglasang
 */

public class EmotionApp extends JFrame implements ActionListener, ItemListener { 
    private JPanel buttonPanel;
    private JPanel imagePanel;
    private JButton joyButton, angerButton, fearButton, disgustButton, sadnessButton;
    private JComboBox<String> emotionComboBox;
    private JLabel joyLabel, angerLabel, fearLabel, disgustLabel, sadnessLabel, comboBoxLabel;

    public EmotionApp() {
        setTitle("Emotions Inside");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Create buttons
        joyButton = new JButton("Joy");
        angerButton = new JButton("Anger");
        fearButton = new JButton("Fear");
        disgustButton = new JButton("Disgust");
        sadnessButton = new JButton("Sadness");

        //Add action listeners
        joyButton.addActionListener(this);
        angerButton.addActionListener(this);
        fearButton.addActionListener(this);
        disgustButton.addActionListener(this);
        sadnessButton.addActionListener(this);

        //Create a panel for buttons and set layout
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        //Add buttons to the panel
        buttonPanel.add(joyButton);
        buttonPanel.add(angerButton);
        buttonPanel.add(fearButton);
        buttonPanel.add(disgustButton);
        buttonPanel.add(sadnessButton);

        //Item event for additional emotions
        String[] emotions = { "mystery 1", "mystery 2", "mystery 3" };
        emotionComboBox = new JComboBox<>(emotions);
        emotionComboBox.addItemListener(this);
        buttonPanel.add(emotionComboBox);

        //panel for images and set layout
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 6));

        //labels for images
        joyLabel = new JLabel();
        angerLabel = new JLabel();
        fearLabel = new JLabel();
        disgustLabel = new JLabel();
        sadnessLabel = new JLabel();
        comboBoxLabel = new JLabel();
        
       // Center align labels
        joyLabel.setHorizontalAlignment(JLabel.CENTER);
        joyLabel.setVerticalAlignment(JLabel.CENTER);
        angerLabel.setHorizontalAlignment(JLabel.CENTER);
        angerLabel.setVerticalAlignment(JLabel.CENTER);
        fearLabel.setHorizontalAlignment(JLabel.CENTER);
        fearLabel.setVerticalAlignment(JLabel.CENTER);
        disgustLabel.setHorizontalAlignment(JLabel.CENTER);
        disgustLabel.setVerticalAlignment(JLabel.CENTER);
        sadnessLabel.setHorizontalAlignment(JLabel.CENTER);
        sadnessLabel.setVerticalAlignment(JLabel.CENTER);
        comboBoxLabel.setHorizontalAlignment(JLabel.CENTER);
        comboBoxLabel.setVerticalAlignment(JLabel.CENTER);

        //Add image panel labels
        imagePanel.add(joyLabel);
        imagePanel.add(angerLabel);
        imagePanel.add(fearLabel);
        imagePanel.add(disgustLabel);
        imagePanel.add(sadnessLabel);
        imagePanel.add(comboBoxLabel);

        // Add panels to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);

        setVisible(true);
    }
    
    private ImageIcon createScaledIcon(String path, int width, int height) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
   
    @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == joyButton) {
            joyLabel.setIcon(createScaledIcon("joy.jpg", joyLabel.getWidth(), joyLabel.getHeight()));
            joyLabel.setOpaque(true);
            joyLabel.setBackground(Color.YELLOW);
        } else if (e.getSource() == angerButton) {
            angerLabel.setIcon(createScaledIcon("anger.jpg", angerLabel.getWidth(), angerLabel.getHeight()));
            angerLabel.setOpaque(true);
            angerLabel.setBackground(Color.RED);
        } else if (e.getSource() == fearButton) {
            fearLabel.setIcon(createScaledIcon("fear.png", fearLabel.getWidth(), fearLabel.getHeight()));
            fearLabel.setOpaque(true);
            fearLabel.setBackground(new Color(128, 0, 128)); 
        } else if (e.getSource() == disgustButton) {
            disgustLabel.setIcon(createScaledIcon("disgust.jpg", disgustLabel.getWidth(), disgustLabel.getHeight()));
            disgustLabel.setOpaque(true);
            disgustLabel.setBackground(Color.GREEN);
        } else if (e.getSource() == sadnessButton) {
            sadnessLabel.setIcon(createScaledIcon("sadness.jpg", sadnessLabel.getWidth(), sadnessLabel.getHeight()));
            sadnessLabel.setOpaque(true);
            sadnessLabel.setBackground(Color.BLUE);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedEmotion = (String) e.getItem();
            switch (selectedEmotion) {
                case "mystery 1":
                    comboBoxLabel.setIcon(createScaledIcon("mystery 1.jpg", comboBoxLabel.getWidth(), comboBoxLabel.getHeight()));
                    comboBoxLabel.setOpaque(true);
                    comboBoxLabel.setBackground(new Color (75, 0, 130)); // indigo
                    break;
                case "mystery 2":
                    comboBoxLabel.setIcon(createScaledIcon("mystery 2.jpg", comboBoxLabel.getWidth(), comboBoxLabel.getHeight()));
                    comboBoxLabel.setOpaque(true);
                    comboBoxLabel.setBackground(new Color(0,128, 128)); // teal
                    break;
                case "mystery 3":
                    comboBoxLabel.setIcon(createScaledIcon("mystery 3.jpg", comboBoxLabel.getWidth(), comboBoxLabel.getHeight()));
                    comboBoxLabel.setOpaque(true);
                    comboBoxLabel.setBackground(Color.LIGHT_GRAY);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        new EmotionApp();
    }
}