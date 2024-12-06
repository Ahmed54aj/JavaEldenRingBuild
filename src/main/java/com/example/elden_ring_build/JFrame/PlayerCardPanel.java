package com.example.elden_ring_build.JFrame;

import javax.swing.*;
import java.awt.*;
import com.example.elden_ring_build.Model.PlayerCharacter;

public class PlayerCardPanel extends JPanel {
    private PlayerCharacter character;

    public PlayerCardPanel(PlayerCharacter character) {
        this.character = character;

        // Set the layout manager
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Set a border around the panel
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Display the character name
        JLabel nameLabel = new JLabel("Name: " + character.getName());
        add(nameLabel);

        // Display the character stats
        add(new JLabel("Build Type: " + character.getBuildType()));
        add(new JLabel("Level: " + character.getLevel()));
        add(new JLabel("Strength: " + character.getStrength()));
        add(new JLabel("Dexterity: " + character.getDexterity()));
        add(new JLabel("Intelligence: " + character.getIntelligence()));
        add(new JLabel("Faith: " + character.getFaith()));
        add(new JLabel("Arcane: " + character.getArcane()));
        add(new JLabel("Vigor: " + character.getVigor()));
        add(new JLabel("Endurance: " + character.getEndurance()));
        add(new JLabel("Mind: " + character.getMind()));
        add(new JLabel("Weapon: " + character.getWeapon()));
        add(new JLabel("Armor: " + character.getArmor()));
        add(new JLabel("Shield: " + character.getShield()));
        add(new JLabel("Talisman: " + character.getTalisman()));
    }
}
