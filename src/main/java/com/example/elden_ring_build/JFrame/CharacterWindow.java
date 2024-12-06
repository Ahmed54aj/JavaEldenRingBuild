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
            cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Optional border for each card

            // Create a panel for the character's info
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(0, 2)); // Two columns for labels and values

            // Add character details to the info panel
            infoPanel.add(new JLabel("Name:"));
            infoPanel.add(new JLabel(character.getName()));
            infoPanel.add(new JLabel("Level:"));
            infoPanel.add(new JLabel(String.valueOf(character.getLevel())));
            infoPanel.add(new JLabel("Strength:"));
            infoPanel.add(new JLabel(String.valueOf(character.getStrength())));
            infoPanel.add(new JLabel("Dexterity:"));
            infoPanel.add(new JLabel(String.valueOf(character.getDexterity())));
            infoPanel.add(new JLabel("Intelligence:"));
            infoPanel.add(new JLabel(String.valueOf(character.getIntelligence())));
            infoPanel.add(new JLabel("Faith:"));
            infoPanel.add(new JLabel(String.valueOf(character.getFaith())));
            infoPanel.add(new JLabel("Arcane:"));
            infoPanel.add(new JLabel(String.valueOf(character.getArcane())));
            infoPanel.add(new JLabel("Weapon:"));
            infoPanel.add(new JLabel(character.getWeapon()));
            infoPanel.add(new JLabel("Armor:"));
            infoPanel.add(new JLabel(character.getArmor()));
            infoPanel.add(new JLabel("Shield:"));
            infoPanel.add(new JLabel(character.getShield()));
            infoPanel.add(new JLabel("Talisman:"));
            infoPanel.add(new JLabel(character.getTalisman()));

            // Add the info panel to the card panel
            cardPanel.add(infoPanel, BorderLayout.CENTER);

            // Create a small close button
            JPanel closePanel = new JPanel();
            closePanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Right-align the button
            JButton closeButton = new JButton("X");
            closeButton.setFont(new Font("Arial", Font.BOLD, 20)); // Increase font size for better visibility
            closeButton.setPreferredSize(new Dimension(35, 35)); // Adjust button size (larger size)
            closeButton.setBackground(Color.WHITE); // Red background color
            closeButton.setForeground(Color.BLACK); // White text color
            closeButton.setBorder(BorderFactory.createEmptyBorder()); // Remove the button border for better styling
            closePanel.add(closeButton);

            // Add close button to the right side of the card panel
            cardPanel.add(closePanel, BorderLayout.NORTH); // Align to the top of the card

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

        // Create a small close button
        JPanel closePanel = new JPanel();
        closePanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Right-align the button
        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Arial", Font.BOLD, 20)); // Increase font size for better visibility
        closeButton.setPreferredSize(new Dimension(35, 35)); // Adjust button size (larger size)

        // Remove any default border and padding around the button
        closeButton.setBackground(Color.WHITE); // Red background color
        closeButton.setForeground(Color.BLACK); // White text color
        closeButton.setBorder(BorderFactory.createEmptyBorder()); // Remove the button's default border
        closeButton.setMargin(new Insets(0, 0, 0, 0)); // Remove any extra margin around the button

        // Ensure the panel does not add extra space to the button
        closePanel.setBorder(BorderFactory.createEmptyBorder()); // Remove any border from the panel itself

        // Add the button to the close panel
        closePanel.add(closeButton);

        // Add the close panel to the card panel (top-right corner)
        cardPanel.add(closePanel, BorderLayout.NORTH);

        // Create a small close button
        closePanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Right-align the button
        closeButton.setFont(new Font("Arial", Font.BOLD, 16)); // Font size increased
        closeButton.setPreferredSize(new Dimension(35, 35)); // Adjust button size (larger size)
        closeButton.setBackground(Color.WHITE);
        closeButton.setForeground(Color.BLACK);
        closeButton.setBorder(BorderFactory.createEmptyBorder()); // Remove the border for a cleaner look
        closePanel.add(closeButton);

        // Add close button to the top-right corner of the card
        cardPanel.add(closePanel, BorderLayout.NORTH);

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
