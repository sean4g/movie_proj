package com.MovieWatcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.MovieWatcher.model.User;
import com.MovieWatcher.repositories.UserRepository;
import com.MovieWatcher.service.UserService;

import java.util.Optional;

@SpringBootTest
class MovieWatcherApplicationTests {

	@Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	void contextLoads() {
	}

	@Test 
	public void testRegistration_unit() {
        String username = "testuser";
		String email = "test@123.com";
        String password = "password123";
        String encodedPassword = new BCryptPasswordEncoder().encode(password);

		System.out.println(encodedPassword);

		User user = new User(username, email, encodedPassword);

		when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

		userService.registerUser(user);
		verify(userRepository).save(user);
		
	}

    @Test
    public void testAuthenticateUser_Success() {
        String username = "testuser";
		String email = "test@123.com";
        String password = "password123";
        String encodedPassword = new BCryptPasswordEncoder().encode(password);

        User user = new User(username, email, encodedPassword);

		userService.registerUser(user);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

		// when(userService.authenticateUser(username, encodedPassword)).thenReturn(true);

        // assertTrue(userService.authenticateUser(username, encodedPassword));
    }

    @Test
    public void testAuthenticateUser_Failure() {
        MockitoAnnotations.openMocks(this);
        String username = "testuser";
        String password = "wrongpassword";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        assertFalse(userService.authenticateUser(username, password));
    }

}
