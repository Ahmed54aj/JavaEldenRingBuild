package com.example.elden_ring_build.JFrame;

import com.example.elden_ring_build.CharacterRepository.CharacterRepo;
import com.example.elden_ring_build.Model.PlayerCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CharacterWindow extends JFrame {

    private CharacterRepo characterRepo;
    private JPanel panel;

    @Autowired
    public CharacterWindow(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
        setTitle("Player Character Cards");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the panel and scroll pane
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout for cards
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);

        // Load characters from the database when the window is created
        loadCharacters();
    }

    // Initialize the window and load characters from the repository
    public void loadCharacters() {
        List<PlayerCharacter> characters = characterRepo.getAllCharacters(); // Get all characters from the DB

        // Clear existing cards in the UI
        panel.removeAll();

        // Add each character card to the window
        for (PlayerCharacter character : characters) {
            // Create a new panel for each character
            JPanel cardPanel = new JPanel();
            cardPanel.setLayout(new BorderLayout());

            // Add character details to the panel
            JLabel characterLabel = new JLabel("Name: " + character.getName() + " | Level: " + character.getLevel());
            cardPanel.add(characterLabel, BorderLayout.CENTER);

            // Create a close button
            JButton closeButton = new JButton("X");
            closeButton.setBackground(Color.RED);
            closeButton.setForeground(Color.WHITE);
            cardPanel.add(closeButton, BorderLayout.EAST); // Add close button to the right side

            // Add action listener to the close button
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the card when the button is clicked
                    removeCard(cardPanel);
                }
            });

            // Add the card panel to the main panel
            panel.add(cardPanel);
        }

        // Refresh the window to display the updated cards
        revalidate();
        repaint();
    }

    // Method to remove a card from the main panel
    private void removeCard(JPanel cardPanel) {
        // Remove the card panel from the parent container (main panel)
        panel.remove(cardPanel);
        revalidate(); // Revalidate the layout
        repaint(); // Repaint the panel to reflect the changes
    }

    // Method to add a new character card dynamically (called by service or
    // application)
    public void addCharacterCard(PlayerCharacter character) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BorderLayout());

        // Add character details to the panel
        JLabel characterLabel = new JLabel("Name: " + character.getName() + " | Level: " + character.getLevel());
        cardPanel.add(characterLabel, BorderLayout.CENTER);

        // Create a close button
        JButton closeButton = new JButton("X");
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);
        cardPanel.add(closeButton, BorderLayout.EAST);

        // Add action listener to the close button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the card when the button is clicked
                removeCard(cardPanel);
            }
        });

        // Add the card panel to the main panel
        panel.add(cardPanel);

        // Refresh the window to display the new card
        revalidate();
        repaint();
    }

    // Method to display the window explicitly
    public void showWindow() {
        setVisible(true);
    }
}
