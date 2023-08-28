package online.gladikov.home.climate_service.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import online.gladikov.home.climate_service.model.dto.SensorRecordDto;
import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service.service.ClimateService;


@WebMvcTest(ClimateController.class)
class ClimateControllerTest {
	@Autowired
    private  MockMvc mockMvc;
    
    private SensorRecordDto sensorRecord;
    @MockBean
    private  ClimateService service;
    
    @BeforeEach
    public void setup() {
    	sensorRecord=new SensorRecordDto(1L,"livingroom", 1, 2, 3);
    }

	@Test
	void getSensorRecord_givenASensor_statusOk() throws Exception {
		  when(service.getById(1L)).thenReturn(sensorRecord);
	        
		  mockMvc.perform(get("/api/v1/climate/1"))
	            .andDo(print())
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	            .andExpect(jsonPath("$.id", is(1)))
	            .andExpect(jsonPath("$.sensor", is("livingroom")))
	            .andExpect(jsonPath("$.temperature", is(1.0)))
	            .andExpect(jsonPath("$.pressure", is(2.0)))
	            .andExpect(jsonPath("$.humidity", is(3.0)))
	            .andExpect(jsonPath("$").isNotEmpty());
	    }
	}


