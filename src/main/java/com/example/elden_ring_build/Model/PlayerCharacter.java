package com.example.elden_ring_build.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@Scope("prototype")
public class PlayerCharacter {

    // character info
    private String name;
    private String buildType;
    // Character Attributes
    private int level;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int faith;
    private int arcane;
    private int vigor;
    private int endurance;
    private int mind;
    // Equipment
    private String weapon;
    private String armor;
    private String shield;
    private String talisman;

    // Default no-arg constructor
    public PlayerCharacter() {
        // Optionally, you can set default values here if needed
    }

    // Constructor with parameters for easy instantiation
    public PlayerCharacter(String name, String buildType, int level, int strength, int dexterity, int intelligence,
            int faith, int arcane, int vigor, int endurance, int mind, String weapon, String armor,
            String shield, String talisman) {
        this.name = name;
        this.buildType = buildType;
        this.level = level;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.faith = faith;
        this.arcane = arcane;
        this.vigor = vigor;
        this.endurance = endurance;
        this.mind = mind;
        this.weapon = weapon;
        this.armor = armor;
        this.shield = shield;
        this.talisman = talisman;
    }
}
