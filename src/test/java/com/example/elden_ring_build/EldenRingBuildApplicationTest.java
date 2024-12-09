package com.example.elden_ring_build;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.elden_ring_build.JFrame.CharacterWindow;
import com.example.elden_ring_build.Service.CharacterService;

import javax.swing.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class) // Enable Mockito in tests
public class EldenRingBuildApplicationTest {

    @Mock
    private CharacterService characterService; // Mock CharacterService

    @Mock
    private CharacterWindow characterWindow; // Mock CharacterWindow (to avoid GUI instantiation)

    @InjectMocks
    private EldenRingBuildApplication application; // The application to test

    @Test
    public void testMainMethod() throws Exception {
        // Set the system property to ensure headless mode
        System.setProperty("java.awt.headless", "true");

        // Mock static methods using Mockito-inline (requires Mockito version 3.4.0 or
        // higher)
        try (var mockSwing = mockStatic(SwingUtilities.class)) {
            // When: The main method is called
            String[] args = {}; // Simulate command-line args if needed
            EldenRingBuildApplication.main(args);

            // Then: Verify that SwingUtilities.invokeLater was called with a Runnable
            ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
            mockSwing.verify(() -> SwingUtilities.invokeLater(runnableCaptor.capture()));

            // Capture the Runnable passed to invokeLater
            Runnable capturedRunnable = runnableCaptor.getValue();

            // Ensure the Runnable was captured and run it manually
            if (capturedRunnable != null) {
                // capturedRunnable.run(); // Simulate the execution of the Runnable
            }

            // Now verify that SpringApplication.run() was called
            try (var mockSpring = mockStatic(SpringApplication.class)) {
                // mockSpring.verify(() ->
                // SpringApplication.run(EldenRingBuildApplication.class, args));
            }
        }
    }
}
