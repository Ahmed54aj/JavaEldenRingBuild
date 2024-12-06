package com.example.elden_ring_build.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.elden_ring_build.CharacterRepository.CharacterRepo;
import com.example.elden_ring_build.Model.PlayerCharacter;

@Service
public class CharacterService {

    private CharacterRepo characterRepo;

    @Autowired
    public void setCharacterRepo(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    // Add character to the repository
    public void addCharacter(PlayerCharacter character) {
        // Save character to DB
        characterRepo.save(character);

        // Log character saving (you can add logic to trigger UI refresh elsewhere)
        characterRepo.printAllCharacters();
    }
}
