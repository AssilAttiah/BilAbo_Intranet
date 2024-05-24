package com.example.bilabo_intranet.repository;

import com.example.bilabo_intranet.model.Bil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BilRepositoryTest {

    // Injects the mocks into the BilRepository instance
    @InjectMocks
    private BilRepository bilRepository;

    // Mocks the JdbcTemplate to avoid actual database interaction
    @Mock
    private JdbcTemplate jdbcTemplate;

    // Initializes the mocks before each test
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for the save method in BilRepository
    @Test
    public void testSave() {
        // Arrange: Set up a Bil object with test data
        Bil bil = new Bil();
        bil.setStelnummer("12345");
        bil.setMærke("Toyota");
        bil.setModel("Corolla");
        bil.setStatus("Available");

        // Act: Call the save method
        bilRepository.save(bil);

        // Assert: Verify that the update method on jdbcTemplate was called once with the correct arguments
        verify(jdbcTemplate, times(1)).update(anyString(), eq("12345"), eq("Toyota"), eq("Corolla"), eq("Available"));
    }

    // Test for the findAll method in BilRepository
    @Test
    public void testFindAll() {
        // Arrange: Create two Bil objects with test data
        Bil bil1 = new Bil();
        bil1.setStelnummer("12345");
        Bil bil2 = new Bil();
        bil2.setStelnummer("67890");

        // Set up the expected list of Bil objects
        List<Bil> expectedBiler = Arrays.asList(bil1, bil2);

        // Mock the behavior of jdbcTemplate.query to return the expected list
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(expectedBiler);

        // Act: Call the findAll method
        List<Bil> actualBiler = bilRepository.findAll();

        // Assert: Check that the actual list matches the expected list
        assertEquals(2, actualBiler.size());
        assertEquals("12345", actualBiler.get(0).getStelnummer());
        assertEquals("67890", actualBiler.get(1).getStelnummer());
    }
}
