package com.example.elden_ring_build.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.elden_ring_build.Model.PlayerCharacter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CharacterRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to save a PlayerCharacter to the database
    public void save(PlayerCharacter character) {
        // printing confirmation
        System.out.println("Character: " + character.getName() + " added.");

        // SQL query to insert a character
        String sql = "INSERT INTO playerCharacter (name, buildType, level, strength, dexterity, intelligence, faith, arcane, vigor, endurance, mind, weapon, armor, shield, talisman) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // db update
        jdbcTemplate.update(sql, character.getName(), character.getBuildType(), character.getLevel(),
                character.getStrength(), character.getDexterity(), character.getIntelligence(),
                character.getFaith(), character.getArcane(), character.getVigor(),
                character.getEndurance(), character.getMind(), character.getWeapon(),
                character.getArmor(), character.getShield(), character.getTalisman());
    }

    // Method to fetch and print all characters (for logging or debugging)
    public void printAllCharacters() {
        String sql = "SELECT * FROM playerCharacter";

        RowMapper<PlayerCharacter> rowMapper = new RowMapper<PlayerCharacter>() {
            @Override
            public PlayerCharacter mapRow(ResultSet rs, int rowNum) throws SQLException {
                PlayerCharacter character = new PlayerCharacter();
                character.setName(rs.getString("name"));
                character.setBuildType(rs.getString("buildType"));
                character.setLevel(rs.getInt("level"));
                character.setStrength(rs.getInt("strength"));
                character.setDexterity(rs.getInt("dexterity"));
                character.setIntelligence(rs.getInt("intelligence"));
                character.setFaith(rs.getInt("faith"));
                character.setArcane(rs.getInt("arcane"));
                character.setVigor(rs.getInt("vigor"));
                character.setEndurance(rs.getInt("endurance"));
                character.setMind(rs.getInt("mind"));
                character.setWeapon(rs.getString("weapon"));
                character.setArmor(rs.getString("armor"));
                character.setShield(rs.getString("shield"));
                character.setTalisman(rs.getString("talisman"));
                return character;
            }
        };

        List<PlayerCharacter> characters = jdbcTemplate.query(sql, rowMapper);

        for (PlayerCharacter character : characters) {
            System.out.println(character); // Print each character for debugging
        }
    }

    // Method to fetch all characters and return as a List
    public List<PlayerCharacter> getAllCharacters() {
        String sql = "SELECT * FROM playerCharacter";

        RowMapper<PlayerCharacter> rowMapper = new RowMapper<PlayerCharacter>() {
            @Override
            public PlayerCharacter mapRow(ResultSet rs, int rowNum) throws SQLException {
                PlayerCharacter character = new PlayerCharacter();
                character.setName(rs.getString("name"));
                character.setBuildType(rs.getString("buildType"));
                character.setLevel(rs.getInt("level"));
                character.setStrength(rs.getInt("strength"));
                character.setDexterity(rs.getInt("dexterity"));
                character.setIntelligence(rs.getInt("intelligence"));
                character.setFaith(rs.getInt("faith"));
                character.setArcane(rs.getInt("arcane"));
                character.setVigor(rs.getInt("vigor"));
                character.setEndurance(rs.getInt("endurance"));
                character.setMind(rs.getInt("mind"));
                character.setWeapon(rs.getString("weapon"));
                character.setArmor(rs.getString("armor"));
                character.setShield(rs.getString("shield"));
                character.setTalisman(rs.getString("talisman"));
                return character;
            }
        };

        // Execute the query and return the list of PlayerCharacter objects
        return jdbcTemplate.query(sql, rowMapper);
    }
}
