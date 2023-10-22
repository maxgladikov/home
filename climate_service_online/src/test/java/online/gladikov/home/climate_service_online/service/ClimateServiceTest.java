//package online.gladikov.home.climate_service_online.service;
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
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import online.gladikov.home.climate_service_online.model.SensorRecord;
//import online.gladikov.home.common.exception.ResourceNotAvailableException;
//import online.gladikov.home.common.exception.ResourceNotFoundException;
//
//class ClimateServiceTest {
//
//	@Autowired
//    private SensorRecord sensorRecord;
////    @MockBean
////    private  ClimateService service;
//    @Autowired
//    private  ClimateService service;
//    
//    @BeforeEach
//    public void setup() {
//    	sensorRecord=new SensorRecord("livingroom", 1.0, 2.0, 3.0);
//    }
//    
//    @Test
//    void givenSensorName_whenGetSensorByName_thenReturnSensorRecord() {
//    	service.getByName("bedrom");
//    	String sensorName="bedroom";
//    	
//    }
//
////	@Test
////	void WhenSensorIsNotAvailable_thenReturn503() throws Exception {
////		  when(service.getByName("name")).thenThrow(new ResourceNotAvailableException("The sensor is not available"));
////	        
////		  mockMvc.perform(get("/api/v1/climate/online/name"))
////	            .andDo(print())
////	            .andExpect(status().is(503))
////	            ;
////	    }
//}
