package com.example.elden_ring_build;

import com.example.elden_ring_build.Model.PlayerCharacter;
import com.example.elden_ring_build.Service.CharacterService;
import com.example.elden_ring_build.JFrame.CharacterWindow;
import org.springframework.beans.factory.annotation.Autowired;
import javax.swing.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EldenRingBuildApplication {

	@Autowired
	private CharacterService service;

	@Autowired
	private CharacterWindow characterWindow;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			SpringApplication.run(EldenRingBuildApplication.class, args);
		});
	}

	// This method will run after Spring Boot starts up and will launch the window
	@Autowired
	public void run(ApplicationContext context) {
		// Create a sample character to be added
		PlayerCharacter dexBuild = new PlayerCharacter();
		dexBuild.setName("SlasherNoSlashing");

		// Add the character to the repository
		service.addCharacter(dexBuild);

		// Show the character window
		characterWindow.showWindow();

	}

}
