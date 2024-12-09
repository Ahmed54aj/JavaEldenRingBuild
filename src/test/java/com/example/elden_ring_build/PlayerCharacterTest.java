package com.example.elden_ring_build;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.elden_ring_build.Model.PlayerCharacter;

public class PlayerCharacterTest {

    private PlayerCharacter playerCharacter;

    @BeforeEach
    public void setUp() {
        // Creating a PlayerCharacter object before each test
        playerCharacter = new PlayerCharacter(
                "EldenLord", "Strength", 100, 40, 20, 10, 30, 15, 50, 40, 30,
                "Greatsword", "Havel's Armor", "Tower Shield", "Radagon's Scarseal");
    }

    @Test
    public void testPlayerCharacterConstructor() {
        // Verify that the constructor correctly initializes fields
        assertNotNull(playerCharacter);
        assertEquals("EldenLord", playerCharacter.getName());
        assertEquals("Strength", playerCharacter.getBuildType());
        assertEquals(100, playerCharacter.getLevel());
        assertEquals(40, playerCharacter.getStrength());
        assertEquals(20, playerCharacter.getDexterity());
        assertEquals(10, playerCharacter.getIntelligence());
        assertEquals(30, playerCharacter.getFaith());
        assertEquals(15, playerCharacter.getArcane());
        assertEquals(50, playerCharacter.getVigor());
        assertEquals(40, playerCharacter.getEndurance());
        assertEquals(30, playerCharacter.getMind());
        assertEquals("Greatsword", playerCharacter.getWeapon());
        assertEquals("Havel's Armor", playerCharacter.getArmor());
        assertEquals("Tower Shield", playerCharacter.getShield());
        assertEquals("Radagon's Scarseal", playerCharacter.getTalisman());
    }

    @Test
    public void testSettersAndGetters() {
        // Set all fields using the setters
        playerCharacter.setName("NewName");
        playerCharacter.setBuildType("Dexterity");
        playerCharacter.setLevel(120);
        playerCharacter.setStrength(50);
        playerCharacter.setDexterity(45);
        playerCharacter.setIntelligence(30);
        playerCharacter.setFaith(25);
        playerCharacter.setArcane(15);
        playerCharacter.setVigor(60);
        playerCharacter.setEndurance(35);
        playerCharacter.setMind(20);
        playerCharacter.setWeapon("Claymore");
        playerCharacter.setArmor("Radahn's Armor");
        playerCharacter.setShield("Greatshield");
        playerCharacter.setTalisman("Erdtree's Favor");

        // Verify that the values were updated correctly
        assertEquals("NewName", playerCharacter.getName());
        assertEquals("Dexterity", playerCharacter.getBuildType());
        assertEquals(120, playerCharacter.getLevel());
        assertEquals(50, playerCharacter.getStrength());
        assertEquals(45, playerCharacter.getDexterity());
        assertEquals(30, playerCharacter.getIntelligence());
        assertEquals(25, playerCharacter.getFaith());
        assertEquals(15, playerCharacter.getArcane());
        assertEquals(60, playerCharacter.getVigor());
        assertEquals(35, playerCharacter.getEndurance());
        assertEquals(20, playerCharacter.getMind());
        assertEquals("Claymore", playerCharacter.getWeapon());
        assertEquals("Radahn's Armor", playerCharacter.getArmor());
        assertEquals("Greatshield", playerCharacter.getShield());
        assertEquals("Erdtree's Favor", playerCharacter.getTalisman());
    }

    @Test
    public void testDefaultConstructor() {
        PlayerCharacter defaultPlayer = new PlayerCharacter();
        assertNotNull(defaultPlayer);
        assertEquals(0, defaultPlayer.getLevel());
        assertNull(defaultPlayer.getName());
        assertNull(defaultPlayer.getWeapon());
    }
}
