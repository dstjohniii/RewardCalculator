package com.poc.reward.calculator.controller;
import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RewardCalculatorControllerIT {

	@LocalServerPort
	private int port;

	private URL index;

	@Autowired
	private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.index = new URL("http://localhost:" + port + "/");
    }

    @Test
    void givenIndex_whenCalled_thenOk() throws Exception {
        ResponseEntity<String> response = template.getForEntity(index.toString(),
                String.class);
        assertThat(response.getBody()).isEqualTo("Home");
    }
}
