package com.zohaib.timetablegenerator.algorithm.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zohaib.timetablegenerator.algorithm.basic.model.Data;

@SpringBootTest
public class BasicAlgorithmTests {

	
	ObjectMapper objectMapper = new ObjectMapper();
	@Test
	public void jsonMappedToDataObject() throws Exception {
		
		Data data = objectMapper.readValue(new File("src/test/resources/test_input.json"), Data.class);
		assertNotNull(data);
		
	}
	
	
	@Test
	public void dataShouldHave3Courses() throws Exception {
		Data data = objectMapper.readValue(new File("src/test/resources/test_input.json"), Data.class);
		assertEquals(3,data.getCourses().size());

		
	}
	
	
	
	
	

}

