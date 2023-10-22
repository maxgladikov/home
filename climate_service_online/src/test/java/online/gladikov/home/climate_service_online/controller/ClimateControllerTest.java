//package online.gladikov.home.climate_service_online.controller;
//
//import static org.hamcrest.Matchers.is;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import online.gladikov.home.climate_service_online.model.SensorRecord;
//import online.gladikov.home.climate_service_online.service.ClimateService;
//import online.gladikov.home.common.exception.ResourceNotAvailableException;
//import online.gladikov.home.common.exception.ResourceNotFoundException;
//
//@WebMvcTest(ClimateController.class)
//class ClimateControllerTest {
//
//	@Autowired
//    private  MockMvc mockMvc;
//    private SensorRecord sensorRecord;
//    @MockBean
//    private  ClimateService service;
//    
//    @BeforeEach
//    public void setup() {
//    	sensorRecord=new SensorRecord("livingroom", 1.0, 2.0, 3.0);
//    }
//
//    @Test
//    void givenHttpRequestByName_WhenProcess_ThenAssure() throws Exception {
//    	when(service.getByName("name")).thenReturn(sensorRecord);
//    	
//    	mockMvc.perform(get("/api/v1/climate/online/name"))
//    	.andDo(print())
//    	.andExpect(status().isOk())
//    	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//    	.andExpect(jsonPath("$.sensor", is("livingroom")))
//    	.andExpect(jsonPath("$.temperature", is(1.0)))
//    	.andExpect(jsonPath("$.pressure", is(2.0)))
//    	.andExpect(jsonPath("$.humidity", is(3.0)))
//    	.andExpect(jsonPath("$").isNotEmpty());
//    }
//    @Test
//    void WhenSensorNotExisted_thenReturn404() throws Exception {
//    	when(service.getByName("name")).thenThrow(new ResourceNotFoundException("There is no such sensor"));
//    	
//    	mockMvc.perform(get("/api/v1/climate/online/name"))
//    	.andDo(print())
//    	.andExpect(status().is(404))
//    	;
//    }
//	@Test
//	void WhenSensorIsNotAvailable_thenReturn503() throws Exception {
//		  when(service.getByName("name")).thenThrow(new ResourceNotAvailableException("The sensor is not available"));
//	        
//		  mockMvc.perform(get("/api/v1/climate/online/name"))
//	            .andDo(print())
//	            .andExpect(status().is(503))
//	            ;
//	    }
//}
